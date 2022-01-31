package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.e.a.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class FileBasedFileSystem
  extends AbstractFileSystem
{
  final boolean mReadOnly;
  private final String wuo;
  private final boolean wup;
  private volatile String wuq;
  private volatile long wur = 512L;
  
  protected FileBasedFileSystem(Parcel paramParcel)
  {
    j.a(paramParcel, getClass());
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.wuo = str1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mReadOnly = bool;
      if (!this.wuo.isEmpty()) {
        break;
      }
      this.wuq = this.wuo;
      this.wup = true;
      return;
    }
    paramParcel = j.y(this.wuo, Collections.unmodifiableMap(FileSystemManager.cVw().xvU));
    if (paramParcel != null)
    {
      aeN(paramParcel);
      this.wup = true;
      return;
    }
    this.wuq = null;
    this.wup = false;
  }
  
  protected FileBasedFileSystem(String paramString)
  {
    this.wuo = paramString;
    this.mReadOnly = false;
    if (this.wuo.isEmpty())
    {
      this.wuq = this.wuo;
      this.wup = true;
      return;
    }
    paramString = j.y(this.wuo, Collections.unmodifiableMap(FileSystemManager.cVw().xvU));
    if (paramString != null)
    {
      aeN(paramString);
      this.wup = true;
      return;
    }
    this.wuq = null;
    this.wup = false;
  }
  
  private FileSystem.a S(File paramFile)
  {
    String str1 = this.wuq;
    if (paramFile.getPath().length() == str1.length()) {}
    String str2;
    int i;
    for (str1 = "";; str1 = paramFile.getPath().substring(i + 1))
    {
      str2 = paramFile.getName();
      if (Build.VERSION.SDK_INT < 21) {
        break;
      }
      FileSystem.a locala = a.a(paramFile, this, str1, str2);
      if (locala == null) {
        break;
      }
      return locala;
      i = str1.length();
    }
    boolean bool = paramFile.isDirectory();
    long l1 = paramFile.length();
    long l2 = this.wur;
    return new FileSystem.a(this, str1, str2, l1, (this.wur - 1L ^ 0xFFFFFFFF) & l2 + l1 - 1L, paramFile.lastModified(), bool);
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
      FileSystem.a locala = S(paramFile);
      if (locala != null)
      {
        paramArrayList.add(locala);
        if (locala.wuv) {
          a(paramFile, paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  private void aeN(String paramString)
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
        this.wur = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          b.b("VFS.FileBasedFileSystem", localException, "Failed to retrieve block size.");
          this.wur = 4096L;
        }
      }
      this.wuq = paramString.getPath();
      b.i("VFS.FileBasedFileSystem", "Real path resolved: " + this.wuo + " => " + this.wuq);
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
        this.wur = 4096L;
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
  
  public final List<FileSystem.a> J(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(L(paramString, false));
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
      FileSystem.a locala = S(localObject[i]);
      if (locala != null) {
        paramString.add(locala);
      }
      i += 1;
    }
    return paramString;
  }
  
  public final boolean K(String paramString, boolean paramBoolean)
  {
    if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
    for (boolean bool = true;; bool = false)
    {
      paramString = new File(L(paramString, false));
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
  
  public final String L(String paramString, boolean paramBoolean)
  {
    String str = this.wuq;
    if (str == null) {
      throw new IllegalStateException("Base path cannot be resolved: " + this.wuo);
    }
    if (paramString.isEmpty()) {
      return str;
    }
    return str + '/' + paramString;
  }
  
  public int Qd()
  {
    int i = 56;
    if (!this.mReadOnly) {
      i = 57;
    }
    return i;
  }
  
  public final boolean aC(String paramString1, String paramString2)
  {
    paramString1 = L(paramString1, false);
    paramString2 = L(paramString2, true);
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  public final String cLh()
  {
    String str2 = this.wuq;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.wuo;
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
    paramString = L(paramString, false);
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
  
  public final boolean jJ(String paramString)
  {
    paramString = L(paramString, false);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).delete();
  }
  
  public void m(Map<String, String> paramMap)
  {
    if (!this.wup)
    {
      String str = this.wuq;
      paramMap = j.y(this.wuo, paramMap);
      if ((paramMap != null) && (!paramMap.equals(str))) {
        aeN(paramMap);
      }
    }
    else
    {
      return;
    }
    this.wuq = paramMap;
  }
  
  public final FileSystem.b mZ(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    for (;;)
    {
      try
      {
        paramString = new StatFs(L((String)localObject, false));
        localObject = new FileSystem.b();
        if (Build.VERSION.SDK_INT >= 18)
        {
          ((FileSystem.b)localObject).uib = paramString.getBlockSizeLong();
          ((FileSystem.b)localObject).uia = paramString.getAvailableBlocksLong();
          ((FileSystem.b)localObject).uhY = paramString.getBlockCountLong();
          ((FileSystem.b)localObject).wux = (((FileSystem.b)localObject).uia * ((FileSystem.b)localObject).uib);
          ((FileSystem.b)localObject).wuy = (((FileSystem.b)localObject).uhY * ((FileSystem.b)localObject).uib);
          return localObject;
        }
      }
      catch (RuntimeException paramString)
      {
        return null;
      }
      ((FileSystem.b)localObject).uib = paramString.getBlockSize();
      ((FileSystem.b)localObject).uia = paramString.getAvailableBlocks();
      ((FileSystem.b)localObject).uhY = paramString.getBlockCount();
    }
  }
  
  public final FileSystem.a na(String paramString)
  {
    return S(new File(L(paramString, false)));
  }
  
  public final boolean nb(String paramString)
  {
    paramString = L(paramString, true);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).mkdirs();
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    return new File(L(paramString, true)).setLastModified(paramLong);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 1;
    paramParcel.writeInt(1);
    paramParcel.writeString(this.wuo);
    if (this.mReadOnly) {}
    for (;;)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
    }
  }
  
  @TargetApi(21)
  private static final class a
  {
    static FileSystem.a a(File paramFile, FileSystem paramFileSystem, String paramString1, String paramString2)
    {
      try
      {
        paramFile = Os.stat(paramFile.getPath());
        if (paramFile == null) {
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
        paramFile = new FileSystem.a(paramFileSystem, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
        return paramFile;
      }
      catch (ErrnoException paramFile) {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileBasedFileSystem
 * JD-Core Version:    0.7.0.1
 */