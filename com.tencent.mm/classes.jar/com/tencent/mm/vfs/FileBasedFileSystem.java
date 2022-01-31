package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class FileBasedFileSystem
  extends AbstractFileSystem
{
  private final String APn;
  private final boolean APo;
  private volatile String APp;
  private volatile long APq = 512L;
  final boolean mReadOnly;
  
  protected FileBasedFileSystem(Parcel paramParcel)
  {
    j.a(paramParcel, getClass());
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.APn = str1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mReadOnly = bool;
      if (!this.APn.isEmpty()) {
        break;
      }
      this.APp = this.APn;
      this.APo = true;
      return;
    }
    paramParcel = j.J(this.APn, Collections.unmodifiableMap(FileSystemManager.dQE().APJ));
    if (paramParcel != null)
    {
      avF(paramParcel);
      this.APo = true;
      return;
    }
    this.APp = null;
    this.APo = false;
  }
  
  protected FileBasedFileSystem(String paramString)
  {
    this.APn = paramString;
    this.mReadOnly = false;
    if (this.APn.isEmpty())
    {
      this.APp = this.APn;
      this.APo = true;
      return;
    }
    paramString = j.J(this.APn, Collections.unmodifiableMap(FileSystemManager.dQE().APJ));
    if (paramString != null)
    {
      avF(paramString);
      this.APo = true;
      return;
    }
    this.APp = null;
    this.APo = false;
  }
  
  private List<FileSystem.a> a(File paramFile, ArrayList<FileSystem.a> paramArrayList)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      paramFile = null;
      return paramFile;
    }
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      paramFile = paramArrayList;
      if (i >= j) {
        break;
      }
      paramFile = arrayOfFile[i];
      FileSystem.a locala = ab(paramFile);
      if (locala != null)
      {
        paramArrayList.add(locala);
        if (locala.APu) {
          a(paramFile, paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  private FileSystem.a ab(File paramFile)
  {
    String str1 = this.APp;
    if (paramFile.getPath().length() == str1.length()) {}
    String str2;
    int i;
    for (str1 = "";; str1 = paramFile.getPath().substring(i + 1))
    {
      str2 = paramFile.getName();
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
      return a.a(paramFile, this, str1, str2);
      i = str1.length();
    }
    if (!paramFile.exists()) {
      return null;
    }
    boolean bool = paramFile.isDirectory();
    long l1 = paramFile.length();
    long l2 = this.APq;
    return new FileSystem.a(this, str1, str2, l1, (this.APq - 1L ^ 0xFFFFFFFF) & l2 + l1 - 1L, paramFile.lastModified(), bool);
  }
  
  private void avF(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      paramString = localFile.getCanonicalFile();
      if (!paramString.isDirectory())
      {
        if (paramString.exists())
        {
          b.e("VFS.FileBasedFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + paramString.getPath());
          paramString.delete();
        }
        if (!paramString.mkdirs()) {
          b.e("VFS.FileBasedFileSystem", "Base directory cannot be created. Base path: " + paramString.getPath());
        }
      }
      try
      {
        i = new StatFs(paramString.getPath()).getBlockSize();
        if ((i - 1 & i) != 0) {
          break label171;
        }
        this.APq = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          b.b("VFS.FileBasedFileSystem", localException, "Failed to retrieve block size.");
          this.APq = 4096L;
        }
      }
      this.APp = paramString.getPath();
      b.i("VFS.FileBasedFileSystem", "Real path resolved: " + this.APn + " => " + this.APp);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = localFile.getAbsoluteFile();
        continue;
        label171:
        b.w("VFS.FileBasedFileSystem", "Non-power-of-two block size: " + i + ", use default: 4096");
        this.APq = 4096L;
      }
    }
  }
  
  private static boolean d(File paramFile, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      bool1 = bool2;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          bool2 &= d(localFile, false);
        }
        for (;;)
        {
          i += 1;
          break;
          bool2 &= localFile.delete();
        }
      }
    }
    bool2 = bool1;
    if (!paramBoolean) {
      bool2 = bool1 & paramFile.delete();
    }
    return bool2;
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    return new File(P(paramString, true)).setLastModified(paramLong);
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(P(paramString, false));
    if (!((File)localObject).isDirectory()) {}
    do
    {
      return null;
      paramString = new ArrayList();
      if (paramBoolean) {
        return a((File)localObject, paramString);
      }
      localObject = ((File)localObject).listFiles();
    } while (localObject == null);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      FileSystem.a locala = ab(localObject[i]);
      if (locala != null) {
        paramString.add(locala);
      }
      i += 1;
    }
    return paramString;
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new File(P(paramString, false));
      if (paramString.isDirectory()) {
        break;
      }
      return false;
    }
    if (paramBoolean) {
      return d(paramString, bool);
    }
    return paramString.delete();
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    String str = this.APp;
    if (str == null) {
      throw new IllegalStateException("Base path cannot be resolved: " + this.APn);
    }
    if (paramString.isEmpty()) {
      return str;
    }
    return str + '/' + paramString;
  }
  
  public final boolean aV(String paramString1, String paramString2)
  {
    paramString1 = P(paramString1, false);
    paramString2 = P(paramString2, true);
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  public int ajj()
  {
    int i = 56;
    if (!this.mReadOnly) {
      i = 57;
    }
    return i;
  }
  
  public final String dQz()
  {
    String str2 = this.APp;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.APn;
    }
    return str1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    boolean bool2 = false;
    paramString = P(paramString, false);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (new File(paramString).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void q(Map<String, String> paramMap)
  {
    if (!this.APo)
    {
      String str = this.APp;
      paramMap = j.J(this.APn, paramMap);
      if ((paramMap != null) && (!paramMap.equals(str))) {
        avF(paramMap);
      }
    }
    else
    {
      return;
    }
    this.APp = paramMap;
  }
  
  public final boolean qD(String paramString)
  {
    paramString = P(paramString, false);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).delete();
  }
  
  public final FileSystem.b uk(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    for (;;)
    {
      try
      {
        paramString = new StatFs(P((String)localObject, false));
        localObject = new FileSystem.b();
        if (Build.VERSION.SDK_INT >= 18)
        {
          ((FileSystem.b)localObject).yqh = paramString.getBlockSizeLong();
          ((FileSystem.b)localObject).yqg = paramString.getAvailableBlocksLong();
          ((FileSystem.b)localObject).yqe = paramString.getBlockCountLong();
          ((FileSystem.b)localObject).APw = (((FileSystem.b)localObject).yqg * ((FileSystem.b)localObject).yqh);
          ((FileSystem.b)localObject).bau = (((FileSystem.b)localObject).yqe * ((FileSystem.b)localObject).yqh);
          return localObject;
        }
      }
      catch (RuntimeException paramString)
      {
        return null;
      }
      ((FileSystem.b)localObject).yqh = paramString.getBlockSize();
      ((FileSystem.b)localObject).yqg = paramString.getAvailableBlocks();
      ((FileSystem.b)localObject).yqe = paramString.getBlockCount();
    }
  }
  
  public final FileSystem.a ul(String paramString)
  {
    return ab(new File(P(paramString, false)));
  }
  
  public final boolean um(String paramString)
  {
    paramString = P(paramString, true);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).mkdirs();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 1;
    paramParcel.writeInt(1);
    paramParcel.writeString(this.APn);
    if (this.mReadOnly) {}
    for (;;)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
    }
  }
  
  @TargetApi(21)
  static final class a
  {
    static FileSystem.a a(File paramFile, FileSystem paramFileSystem, String paramString1, String paramString2)
    {
      AppMethodBeat.i(54503);
      try
      {
        paramFile = Os.stat(paramFile.getPath());
        if (paramFile == null)
        {
          AppMethodBeat.o(54503);
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
        paramFile = new FileSystem.a(paramFileSystem, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
        AppMethodBeat.o(54503);
        return paramFile;
      }
      catch (ErrnoException paramFile)
      {
        AppMethodBeat.o(54503);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileBasedFileSystem
 * JD-Core Version:    0.7.0.1
 */