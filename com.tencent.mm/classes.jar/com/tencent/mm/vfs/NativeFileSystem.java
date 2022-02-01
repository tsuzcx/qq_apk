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
  protected final String RcA;
  private final c RcB;
  
  static
  {
    AppMethodBeat.i(13183);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13183);
  }
  
  protected NativeFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13157);
    aa.a(paramParcel, NativeFileSystem.class, 2);
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = "";; paramParcel = aa.q(paramParcel, true, false))
    {
      this.RcA = paramParcel;
      if (!this.RcA.isEmpty()) {
        break;
      }
      this.RcB = new c(this.RcA);
      AppMethodBeat.o(13157);
      return;
    }
    paramParcel = aa.aa(this.RcA, g.hRR().Uvh.hej());
    if (paramParcel != null)
    {
      this.RcB = new c(paramParcel);
      AppMethodBeat.o(13157);
      return;
    }
    this.RcB = null;
    AppMethodBeat.o(13157);
  }
  
  public NativeFileSystem(String paramString)
  {
    AppMethodBeat.i(13156);
    this.RcA = aa.q(paramString, true, false);
    if (this.RcA.isEmpty())
    {
      this.RcB = new c(this.RcA);
      AppMethodBeat.o(13156);
      return;
    }
    paramString = aa.aa(this.RcA, g.hRR().Uvh.hej());
    if (paramString != null)
    {
      this.RcB = new c(paramString);
      AppMethodBeat.o(13156);
      return;
    }
    this.RcB = null;
    AppMethodBeat.o(13156);
  }
  
  private static boolean G(File paramFile)
  {
    AppMethodBeat.i(187704);
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
          bool1 &= G(localFile);
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
    AppMethodBeat.o(187704);
    return bool2 & bool3;
  }
  
  /* Error */
  private static long e(String paramString1, FileSystem.b paramb, String paramString2)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 160 2 0
    //   12: astore_2
    //   13: new 162	java/io/FileOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 163	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 167	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: astore_1
    //   25: getstatic 173	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 23
    //   30: if_icmple +28 -> 58
    //   33: aload_1
    //   34: aload_2
    //   35: lconst_0
    //   36: ldc2_w 174
    //   39: invokevirtual 181	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   42: lstore_3
    //   43: aload_1
    //   44: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   47: aload_2
    //   48: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   51: ldc 154
    //   53: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: lload_3
    //   57: lreturn
    //   58: sipush 8192
    //   61: invokestatic 191	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   64: astore_0
    //   65: lconst_0
    //   66: lstore_3
    //   67: aload_2
    //   68: aload_0
    //   69: invokeinterface 197 2 0
    //   74: iflt +41 -> 115
    //   77: aload_0
    //   78: invokevirtual 201	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   81: pop
    //   82: lload_3
    //   83: aload_1
    //   84: aload_0
    //   85: invokevirtual 204	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   88: i2l
    //   89: ladd
    //   90: lstore_3
    //   91: aload_0
    //   92: invokevirtual 207	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   95: pop
    //   96: goto -29 -> 67
    //   99: astore_0
    //   100: aload_1
    //   101: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   104: aload_2
    //   105: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   108: ldc 154
    //   110: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: athrow
    //   115: aload_1
    //   116: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   119: aload_2
    //   120: invokestatic 185	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   123: ldc 154
    //   125: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: lload_3
    //   129: lreturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -35 -> 100
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -41 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString1	String
    //   0	144	1	paramb	FileSystem.b
    //   0	144	2	paramString2	String
    //   42	87	3	l	long
    // Exception table:
    //   from	to	target	type
    //   25	43	99	finally
    //   58	65	99	finally
    //   67	96	99	finally
    //   5	13	130	finally
    //   13	25	138	finally
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187703);
    if (this.RcB != null)
    {
      paramMap = this.RcB;
      AppMethodBeat.o(187703);
      return paramMap;
    }
    paramMap = aa.aa(this.RcA, paramMap);
    Log.i("VFS.NativeFileSystem", "Real path resolved: " + this.RcA + " => " + paramMap);
    paramMap = new c(paramMap);
    AppMethodBeat.o(187703);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13181);
    StringBuilder localStringBuilder = new StringBuilder("Native [");
    if (this.RcB == null) {}
    for (String str = this.RcA;; str = this.RcB.heg())
    {
      str = str + "]";
      AppMethodBeat.o(13181);
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13180);
    aa.b(paramParcel, NativeFileSystem.class, 2);
    paramParcel.writeString(this.RcA);
    AppMethodBeat.o(13180);
  }
  
  static final class a
  {
    static e a(File paramFile, FileSystem.b paramb, String paramString1, String paramString2)
    {
      AppMethodBeat.i(187681);
      try
      {
        paramFile = Os.stat(paramFile.getPath());
        if (paramFile == null)
        {
          AppMethodBeat.o(187681);
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
        paramFile = new e(paramb, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
        AppMethodBeat.o(187681);
        return paramFile;
      }
      catch (ErrnoException paramFile)
      {
        AppMethodBeat.o(187681);
      }
      return null;
    }
    
    static boolean nu(String paramString1, String paramString2)
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
  
  protected final class c
    extends a
  {
    protected final String RcC;
    private boolean RcD;
    
    c(String paramString)
    {
      AppMethodBeat.i(187683);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        this.RcC = paramString;
        this.RcD = true;
        AppMethodBeat.o(187683);
        return;
      }
      this.RcC = aa.bpf(paramString);
      this$1 = new File(this.RcC);
      if (NativeFileSystem.this.isDirectory())
      {
        this.RcD = true;
        AppMethodBeat.o(187683);
        return;
      }
      if (NativeFileSystem.this.exists())
      {
        Log.e("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + NativeFileSystem.this.getPath());
        NativeFileSystem.this.delete();
      }
      this.RcD = false;
      AppMethodBeat.o(187683);
    }
    
    private e W(File paramFile)
    {
      AppMethodBeat.i(187695);
      String str1 = this.RcC;
      if (!paramFile.getPath().startsWith(str1))
      {
        paramFile = new RuntimeException("Illegal file: " + paramFile + " (base: " + str1 + ")");
        AppMethodBeat.o(187695);
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
        AppMethodBeat.o(187695);
        return paramFile;
        i = str1.length();
      }
      if (!paramFile.exists())
      {
        AppMethodBeat.o(187695);
        return null;
      }
      boolean bool = paramFile.isDirectory();
      long l = paramFile.length();
      paramFile = new e(this, str1, str2, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
      AppMethodBeat.o(187695);
      return paramFile;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187699);
      if ((paramb.hdR() & 0x2) != 0)
      {
        paramb = paramb.dz(paramString2, false);
        paramString1 = dz(paramString1, true);
        if ((paramb != null) && (paramString1 != null))
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            bool = NativeFileSystem.a.nu(paramb, paramString1);
            AppMethodBeat.o(187699);
            return bool;
          }
          boolean bool = new File(paramb).renameTo(new File(paramString1));
          AppMethodBeat.o(187699);
          return bool;
        }
      }
      AppMethodBeat.o(187699);
      return false;
    }
    
    public final ReadableByteChannel boI(String paramString)
    {
      AppMethodBeat.i(187686);
      String str = dz(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187686);
        throw paramString;
      }
      paramString = new FileInputStream(str).getChannel();
      AppMethodBeat.o(187686);
      return paramString;
    }
    
    public final ByteChannel boJ(String paramString)
    {
      AppMethodBeat.i(187689);
      String str = dz(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187689);
        throw paramString;
      }
      paramString = new RandomAccessFile(str, "rw").getChannel();
      AppMethodBeat.o(187689);
      return paramString;
    }
    
    public final FileSystem.a boK(String paramString)
    {
      AppMethodBeat.i(187684);
      for (;;)
      {
        FileSystem.a locala;
        try
        {
          paramString = new StatFs(dz(paramString, false));
          locala = new FileSystem.a();
          if (Build.VERSION.SDK_INT >= 18)
          {
            locala.blockSize = paramString.getBlockSizeLong();
            locala.availableBlocks = paramString.getAvailableBlocksLong();
            locala.totalBlocks = paramString.getBlockCountLong();
            locala.RbL = (locala.availableBlocks * locala.blockSize);
            locala.bGI = (locala.totalBlocks * locala.blockSize);
            AppMethodBeat.o(187684);
            return locala;
          }
        }
        catch (RuntimeException paramString)
        {
          AppMethodBeat.o(187684);
          return null;
        }
        locala.blockSize = paramString.getBlockSize();
        locala.availableBlocks = paramString.getAvailableBlocks();
        locala.totalBlocks = paramString.getBlockCount();
      }
    }
    
    public final boolean boL(String paramString)
    {
      AppMethodBeat.i(187691);
      paramString = dz(paramString, false);
      if ((paramString != null) && (new File(paramString).exists()))
      {
        AppMethodBeat.o(187691);
        return true;
      }
      AppMethodBeat.o(187691);
      return false;
    }
    
    public final e boM(String paramString)
    {
      AppMethodBeat.i(187692);
      paramString = dz(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(187692);
        return null;
      }
      paramString = W(new File(paramString));
      AppMethodBeat.o(187692);
      return paramString;
    }
    
    public final boolean boN(String paramString)
    {
      AppMethodBeat.i(187697);
      paramString = dz(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(187697);
        return false;
      }
      boolean bool = new File(paramString).mkdirs();
      AppMethodBeat.o(187697);
      return bool;
    }
    
    public final boolean ck(String paramString, long paramLong)
    {
      AppMethodBeat.i(187693);
      paramString = dz(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(187693);
        return false;
      }
      boolean bool = new File(paramString).setLastModified(paramLong);
      AppMethodBeat.o(187693);
      return bool;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(187700);
      String str = dz(paramString1, true);
      if (str == null)
      {
        paramString1 = new IOException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(187700);
        throw paramString1;
      }
      long l = NativeFileSystem.f(str, paramb, paramString2);
      AppMethodBeat.o(187700);
      return l;
    }
    
    public final WritableByteChannel dv(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187688);
      String str = dz(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187688);
        throw paramString;
      }
      paramString = new FileOutputStream(str, paramBoolean).getChannel();
      AppMethodBeat.o(187688);
      return paramString;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187687);
      String str = dz(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187687);
        throw paramString;
      }
      paramString = new FileOutputStream(str, paramBoolean);
      AppMethodBeat.o(187687);
      return paramString;
    }
    
    public final Iterable<e> dx(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187694);
      paramString = dz(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(187694);
        return null;
      }
      paramString = new File(paramString).listFiles();
      if (paramString == null)
      {
        AppMethodBeat.o(187694);
        return null;
      }
      paramString = new com.tencent.mm.vfs.a.a(Arrays.asList(paramString), new a(paramBoolean));
      AppMethodBeat.o(187694);
      return paramString;
    }
    
    public final boolean dy(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187698);
      String str = dz(paramString, false);
      if (str == null)
      {
        AppMethodBeat.o(187698);
        return false;
      }
      if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
      for (int i = 1;; i = 0)
      {
        paramString = new File(str);
        if (paramString.isDirectory()) {
          break;
        }
        AppMethodBeat.o(187698);
        return false;
      }
      if (paramBoolean) {}
      for (paramBoolean = NativeFileSystem.V(paramString);; paramBoolean = paramString.delete())
      {
        if ((i != 0) && (paramBoolean)) {
          this.RcD = false;
        }
        AppMethodBeat.o(187698);
        return paramBoolean;
      }
    }
    
    public final String dz(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187701);
      String str = this.RcC;
      if (str == null)
      {
        paramString = new IllegalStateException("Base path cannot be resolved: " + NativeFileSystem.this.RcA);
        AppMethodBeat.o(187701);
        throw paramString;
      }
      if ((paramBoolean) && (!this.RcD))
      {
        new File(this.RcC).mkdirs();
        this.RcD = true;
      }
      if (paramString.isEmpty())
      {
        AppMethodBeat.o(187701);
        return str;
      }
      paramString = str + '/' + paramString;
      AppMethodBeat.o(187701);
      return paramString;
    }
    
    public final boolean gC(String paramString)
    {
      AppMethodBeat.i(187696);
      paramString = dz(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(187696);
        return false;
      }
      boolean bool = new File(paramString).delete();
      AppMethodBeat.o(187696);
      return bool;
    }
    
    public final FileSystem hdQ()
    {
      return NativeFileSystem.this;
    }
    
    public final int hdR()
    {
      return 31;
    }
    
    public final String heg()
    {
      return this.RcC;
    }
    
    public final ParcelFileDescriptor nr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187690);
      String str = dz(paramString1, true);
      if (str == null)
      {
        paramString1 = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(187690);
        throw paramString1;
      }
      paramString1 = ParcelFileDescriptor.open(new File(str), NativeFileSystem.boS(paramString2));
      AppMethodBeat.o(187690);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(187685);
      String str = dz(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187685);
        throw paramString;
      }
      paramString = new NativeFileSystem.b(str);
      AppMethodBeat.o(187685);
      return paramString;
    }
    
    final class a
      implements a.a<File, e>
    {
      private final boolean FT;
      private final boolean RcF;
      
      a(boolean paramBoolean)
      {
        this.FT = paramBoolean;
        this.RcF = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */