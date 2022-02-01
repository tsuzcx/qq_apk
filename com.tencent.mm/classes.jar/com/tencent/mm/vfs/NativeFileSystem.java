package com.tencent.mm.vfs;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Map;

public class NativeFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<NativeFileSystem> CREATOR;
  protected final String YDd;
  private final c YDe;
  
  static
  {
    AppMethodBeat.i(13183);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13183);
  }
  
  protected NativeFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13157);
    ad.a(paramParcel, NativeFileSystem.class, 2);
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = "";; paramParcel = ad.r(paramParcel, true, false))
    {
      this.YDd = paramParcel;
      if (!this.YDd.isEmpty()) {
        break;
      }
      this.YDe = new c(this.YDd);
      AppMethodBeat.o(13157);
      return;
    }
    paramParcel = ad.ad(this.YDd, h.iWH().abSS.ift());
    if (paramParcel != null)
    {
      this.YDe = new c(paramParcel);
      AppMethodBeat.o(13157);
      return;
    }
    this.YDe = null;
    AppMethodBeat.o(13157);
  }
  
  public NativeFileSystem(String paramString)
  {
    AppMethodBeat.i(13156);
    this.YDd = ad.r(paramString, true, false);
    if (this.YDd.isEmpty())
    {
      this.YDe = new c(this.YDd);
      AppMethodBeat.o(13156);
      return;
    }
    paramString = ad.ad(this.YDd, h.iWH().abSS.ift());
    if (paramString != null)
    {
      this.YDe = new c(paramString);
      AppMethodBeat.o(13156);
      return;
    }
    this.YDe = null;
    AppMethodBeat.o(13156);
  }
  
  private static boolean N(File paramFile)
  {
    AppMethodBeat.i(236398);
    boolean bool2 = true;
    boolean bool1 = true;
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      bool2 = bool1;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          bool1 &= N(localFile);
        }
        for (;;)
        {
          i += 1;
          break;
          bool1 &= localFile.delete();
        }
      }
    }
    boolean bool3 = paramFile.delete();
    AppMethodBeat.o(236398);
    return bool2 & bool3;
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236397);
    if (this.YDe != null)
    {
      paramMap = this.YDe;
      AppMethodBeat.o(236397);
      return paramMap;
    }
    paramMap = ad.ad(this.YDd, paramMap);
    Log.i("VFS.NativeFileSystem", "Real path resolved: " + this.YDd + " => " + paramMap);
    if (paramMap == null)
    {
      paramMap = NullFileSystem.ifq();
      AppMethodBeat.o(236397);
      return paramMap;
    }
    paramMap = new c(paramMap);
    AppMethodBeat.o(236397);
    return paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236395);
    if (((paramObject instanceof NativeFileSystem)) && (this.YDd.equals(((NativeFileSystem)paramObject).YDd)))
    {
      AppMethodBeat.o(236395);
      return true;
    }
    AppMethodBeat.o(236395);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236394);
    int i = NativeFileSystem.class.hashCode();
    int j = this.YDd.hashCode();
    AppMethodBeat.o(236394);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13181);
    StringBuilder localStringBuilder = new StringBuilder("Native [");
    if (this.YDe == null) {}
    for (String str = this.YDd;; str = this.YDe.ifp())
    {
      str = str + "]";
      AppMethodBeat.o(13181);
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13180);
    ad.b(paramParcel, NativeFileSystem.class, 2);
    paramParcel.writeString(this.YDd);
    AppMethodBeat.o(13180);
  }
  
  static final class a
  {
    static f a(File paramFile, FileSystem.b paramb, String paramString1, String paramString2)
    {
      AppMethodBeat.i(236330);
      try
      {
        paramFile = Os.stat(paramFile.getPath());
        if (paramFile == null)
        {
          AppMethodBeat.o(236330);
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
        paramFile = new f(paramb, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
        AppMethodBeat.o(236330);
        return paramFile;
      }
      catch (ErrnoException paramFile)
      {
        AppMethodBeat.o(236330);
      }
      return null;
    }
    
    static boolean ok(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13147);
      try
      {
        Os.rename(paramString1, paramString2);
        AppMethodBeat.o(13147);
        return true;
      }
      catch (ErrnoException localErrnoException)
      {
        if (localErrnoException.errno == OsConstants.EXDEV)
        {
          AppMethodBeat.o(13147);
          return false;
        }
        if (localErrnoException.errno == OsConstants.ENOENT)
        {
          paramString1 = new FileNotFoundException("Cannot move file " + paramString1 + " to " + paramString2 + ": " + localErrnoException.getMessage());
          AppMethodBeat.o(13147);
          throw paramString1;
        }
        paramString1 = new IOException("Cannot move file " + paramString1 + " to " + paramString2 + ": " + localErrnoException.getMessage());
        AppMethodBeat.o(13147);
        throw paramString1;
      }
    }
  }
  
  static final class b
    extends FileInputStream
  {
    private long mMarkPosition = 0L;
    
    b(String paramString)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      AppMethodBeat.i(13154);
      try
      {
        this.mMarkPosition = getChannel().position();
        AppMethodBeat.o(13154);
        return;
      }
      catch (IOException localIOException)
      {
        RuntimeException localRuntimeException = new RuntimeException(localIOException);
        AppMethodBeat.o(13154);
        throw localRuntimeException;
      }
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(13155);
      getChannel().position(this.mMarkPosition);
      AppMethodBeat.o(13155);
    }
  }
  
  protected class c
    extends a
  {
    protected final String YDf;
    private boolean YDg;
    
    c(String paramString)
    {
      AppMethodBeat.i(236352);
      if (paramString.isEmpty()) {}
      for (this$1 = "";; this$1 = ad.bCb(paramString))
      {
        paramString = NativeFileSystem.this;
        if (NativeFileSystem.this.equals("/")) {
          paramString = "";
        }
        this.YDf = paramString;
        if (!this.YDf.isEmpty()) {
          break;
        }
        this.YDg = true;
        AppMethodBeat.o(236352);
        return;
      }
      this$1 = new File(this.YDf);
      if (NativeFileSystem.this.isDirectory())
      {
        this.YDg = true;
        AppMethodBeat.o(236352);
        return;
      }
      if (NativeFileSystem.this.exists())
      {
        Log.e("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + NativeFileSystem.this.getPath());
        NativeFileSystem.this.delete();
      }
      this.YDg = false;
      AppMethodBeat.o(236352);
    }
    
    private f P(File paramFile)
    {
      AppMethodBeat.i(236381);
      String str1 = this.YDf;
      if (!paramFile.getPath().startsWith(str1))
      {
        paramFile = new RuntimeException("Illegal file: " + paramFile + " (base: " + str1 + ")");
        AppMethodBeat.o(236381);
        throw paramFile;
      }
      if (paramFile.getPath().length() == str1.length()) {}
      String str2;
      int i;
      for (str1 = "";; str1 = paramFile.getPath().substring(i + 1))
      {
        str2 = paramFile.getName();
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        paramFile = NativeFileSystem.a.a(paramFile, this, str1, str2);
        AppMethodBeat.o(236381);
        return paramFile;
        i = str1.length();
      }
      if (!paramFile.exists())
      {
        AppMethodBeat.o(236381);
        return null;
      }
      boolean bool = paramFile.isDirectory();
      long l = paramFile.length();
      paramFile = new f(this, str1, str2, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
      AppMethodBeat.o(236381);
      return paramFile;
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(236361);
      String str = dL(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(236361);
        throw paramString;
      }
      try
      {
        paramString = new NativeFileSystem.b(str);
        AppMethodBeat.o(236361);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.m(paramString);
        AppMethodBeat.o(236361);
        throw paramString;
      }
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(236387);
      if ((paramb.ieY() & 0x2) != 0)
      {
        paramb = paramb.dL(paramString2, false);
        paramString1 = dL(paramString1, true);
        if ((paramb != null) && (paramString1 != null))
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            bool = NativeFileSystem.a.ok(paramb, paramString1);
            AppMethodBeat.o(236387);
            return bool;
          }
          boolean bool = new File(paramb).renameTo(new File(paramString1));
          AppMethodBeat.o(236387);
          return bool;
        }
      }
      AppMethodBeat.o(236387);
      return false;
    }
    
    public final FileSystem.a bBA(String paramString)
    {
      AppMethodBeat.i(236359);
      for (;;)
      {
        FileSystem.a locala;
        try
        {
          paramString = new StatFs(dL(paramString, false));
          locala = new FileSystem.a();
          if (Build.VERSION.SDK_INT >= 18)
          {
            locala.blockSize = paramString.getBlockSizeLong();
            locala.availableBlocks = paramString.getAvailableBlocksLong();
            locala.totalBlocks = paramString.getBlockCountLong();
            locala.YCl = (locala.availableBlocks * locala.blockSize);
            locala.bqr = (locala.totalBlocks * locala.blockSize);
            AppMethodBeat.o(236359);
            return locala;
          }
        }
        catch (RuntimeException paramString)
        {
          AppMethodBeat.o(236359);
          return null;
        }
        locala.blockSize = paramString.getBlockSize();
        locala.availableBlocks = paramString.getAvailableBlocks();
        locala.totalBlocks = paramString.getBlockCount();
      }
    }
    
    public final boolean bBB(String paramString)
    {
      AppMethodBeat.i(236374);
      paramString = dL(paramString, false);
      if ((paramString != null) && (new File(paramString).exists()))
      {
        AppMethodBeat.o(236374);
        return true;
      }
      AppMethodBeat.o(236374);
      return false;
    }
    
    public final f bBC(String paramString)
    {
      AppMethodBeat.i(236376);
      paramString = dL(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(236376);
        return null;
      }
      paramString = P(new File(paramString));
      AppMethodBeat.o(236376);
      return paramString;
    }
    
    public final boolean bBD(String paramString)
    {
      AppMethodBeat.i(236383);
      paramString = dL(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(236383);
        return false;
      }
      boolean bool = new File(paramString).mkdirs();
      AppMethodBeat.o(236383);
      return bool;
    }
    
    public final ReadableByteChannel bBy(String paramString)
    {
      AppMethodBeat.i(236363);
      String str = dL(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(236363);
        throw paramString;
      }
      try
      {
        paramString = new FileInputStream(str).getChannel();
        AppMethodBeat.o(236363);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.m(paramString);
        AppMethodBeat.o(236363);
        throw paramString;
      }
    }
    
    public final ByteChannel bBz(String paramString)
    {
      AppMethodBeat.i(236370);
      String str = dL(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(236370);
        throw paramString;
      }
      try
      {
        paramString = new RandomAccessFile(str, "rw").getChannel();
        AppMethodBeat.o(236370);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.m(paramString);
        AppMethodBeat.o(236370);
        throw paramString;
      }
    }
    
    public final boolean ct(String paramString, long paramLong)
    {
      AppMethodBeat.i(236378);
      paramString = dL(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(236378);
        return false;
      }
      boolean bool = new File(paramString).setLastModified(paramLong);
      AppMethodBeat.o(236378);
      return bool;
    }
    
    public final WritableByteChannel dH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236368);
      String str = dL(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(236368);
        throw paramString;
      }
      try
      {
        paramString = new FileOutputStream(str, paramBoolean).getChannel();
        AppMethodBeat.o(236368);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.m(paramString);
        AppMethodBeat.o(236368);
        throw paramString;
      }
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236366);
      String str = dL(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(236366);
        throw paramString;
      }
      try
      {
        paramString = new FileOutputStream(str, paramBoolean);
        AppMethodBeat.o(236366);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.m(paramString);
        AppMethodBeat.o(236366);
        throw paramString;
      }
    }
    
    public final Iterable<f> dJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236380);
      paramString = dL(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(236380);
        return null;
      }
      paramString = new File(paramString).listFiles();
      if (paramString == null)
      {
        AppMethodBeat.o(236380);
        return null;
      }
      paramString = new com.tencent.mm.vfs.a.a(Arrays.asList(paramString), new a(paramBoolean));
      AppMethodBeat.o(236380);
      return paramString;
    }
    
    public final boolean dK(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236384);
      String str = dL(paramString, false);
      if (str == null)
      {
        AppMethodBeat.o(236384);
        return false;
      }
      if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
      for (int i = 1;; i = 0)
      {
        paramString = new File(str);
        if (paramString.isDirectory()) {
          break;
        }
        AppMethodBeat.o(236384);
        return false;
      }
      if (paramBoolean) {}
      for (paramBoolean = NativeFileSystem.O(paramString);; paramBoolean = paramString.delete())
      {
        if ((i != 0) && (paramBoolean)) {
          this.YDg = false;
        }
        AppMethodBeat.o(236384);
        return paramBoolean;
      }
    }
    
    public final String dL(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236388);
      if (this.YDf == null)
      {
        paramString = new IllegalStateException("Base path cannot be resolved: " + NativeFileSystem.this.YDd);
        AppMethodBeat.o(236388);
        throw paramString;
      }
      if ((paramBoolean) && (!this.YDg))
      {
        new File(this.YDf).mkdirs();
        this.YDg = true;
      }
      if (paramString.isEmpty())
      {
        paramString = this.YDf;
        AppMethodBeat.o(236388);
        return paramString;
      }
      paramString = this.YDf + '/' + paramString;
      AppMethodBeat.o(236388);
      return paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236390);
      if (((paramObject instanceof c)) && (this.YDf.equals(((c)paramObject).YDf)))
      {
        AppMethodBeat.o(236390);
        return true;
      }
      AppMethodBeat.o(236390);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236389);
      int i = c.class.hashCode();
      int j = this.YDf.hashCode();
      AppMethodBeat.o(236389);
      return i ^ j;
    }
    
    public final boolean ho(String paramString)
    {
      AppMethodBeat.i(236382);
      paramString = dL(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(236382);
        return false;
      }
      boolean bool = new File(paramString).delete();
      AppMethodBeat.o(236382);
      return bool;
    }
    
    public final FileSystem ieX()
    {
      return NativeFileSystem.this;
    }
    
    public final int ieY()
    {
      return 31;
    }
    
    public final String ifp()
    {
      return this.YDf;
    }
    
    public final ParcelFileDescriptor oh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(236372);
      String str = dL(paramString1, true);
      if (str == null)
      {
        paramString1 = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(236372);
        throw paramString1;
      }
      try
      {
        paramString1 = ParcelFileDescriptor.open(new File(str), NativeFileSystem.bBI(paramString2));
        AppMethodBeat.o(236372);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1 = NativeFileSystem.m(paramString1);
        AppMethodBeat.o(236372);
        throw paramString1;
      }
    }
    
    final class a
      implements a.a<File, f>
    {
      private final boolean Wa;
      private final boolean YDi;
      
      a(boolean paramBoolean)
      {
        this.Wa = paramBoolean;
        this.YDi = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */