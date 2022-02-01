package com.tencent.mm.vfs;

import android.annotation.TargetApi;
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
  protected final String LGO;
  private final c LGP;
  
  static
  {
    AppMethodBeat.i(13183);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13183);
  }
  
  protected NativeFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13157);
    w.a(paramParcel, NativeFileSystem.class, 2);
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {}
    for (paramParcel = "";; paramParcel = w.o(paramParcel, true, false))
    {
      this.LGO = paramParcel;
      if (!this.LGO.isEmpty()) {
        break;
      }
      this.LGP = new c(this.LGO);
      AppMethodBeat.o(13157);
      return;
    }
    paramParcel = w.T(this.LGO, e.fSU().OAF.fTa());
    if (paramParcel != null)
    {
      this.LGP = new c(paramParcel);
      AppMethodBeat.o(13157);
      return;
    }
    this.LGP = null;
    AppMethodBeat.o(13157);
  }
  
  public NativeFileSystem(String paramString)
  {
    AppMethodBeat.i(13156);
    this.LGO = w.o(paramString, true, false);
    if (this.LGO.isEmpty())
    {
      this.LGP = new c(this.LGO);
      AppMethodBeat.o(13156);
      return;
    }
    paramString = w.T(this.LGO, e.fSU().OAF.fTa());
    if (paramString != null)
    {
      this.LGP = new c(w.baa(paramString));
      AppMethodBeat.o(13156);
      return;
    }
    this.LGP = null;
    AppMethodBeat.o(13156);
  }
  
  private static boolean b(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(13174);
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
          bool2 &= b(localFile, false);
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
    AppMethodBeat.o(13174);
    return bool2;
  }
  
  /* Error */
  private static long e(String paramString1, FileSystem.b paramb, String paramString2)
  {
    // Byte code:
    //   0: ldc 153
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 159 2 0
    //   12: astore_2
    //   13: new 161	java/io/FileOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 166	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: astore_1
    //   25: getstatic 172	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 23
    //   30: if_icmple +28 -> 58
    //   33: aload_1
    //   34: aload_2
    //   35: lconst_0
    //   36: ldc2_w 173
    //   39: invokevirtual 180	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   42: lstore_3
    //   43: aload_1
    //   44: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   47: aload_2
    //   48: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   51: ldc 153
    //   53: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: lload_3
    //   57: lreturn
    //   58: sipush 8192
    //   61: invokestatic 190	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   64: astore_0
    //   65: lconst_0
    //   66: lstore_3
    //   67: aload_2
    //   68: aload_0
    //   69: invokeinterface 196 2 0
    //   74: iflt +41 -> 115
    //   77: aload_0
    //   78: invokevirtual 200	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   81: pop
    //   82: lload_3
    //   83: aload_1
    //   84: aload_0
    //   85: invokevirtual 203	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   88: i2l
    //   89: ladd
    //   90: lstore_3
    //   91: aload_0
    //   92: invokevirtual 206	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   95: pop
    //   96: goto -29 -> 67
    //   99: astore_0
    //   100: aload_1
    //   101: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   104: aload_2
    //   105: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   108: ldc 153
    //   110: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: athrow
    //   115: aload_1
    //   116: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   119: aload_2
    //   120: invokestatic 184	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   123: ldc 153
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
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193411);
    if (this.LGP != null)
    {
      paramMap = this.LGP;
      AppMethodBeat.o(193411);
      return paramMap;
    }
    paramMap = w.T(this.LGO, paramMap);
    Log.i("VFS.NativeFileSystem", "Real path resolved: " + this.LGO + " => " + paramMap);
    paramMap = new c(paramMap);
    AppMethodBeat.o(193411);
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
    if (this.LGP == null) {}
    for (String str = this.LGO;; str = this.LGP.fSX())
    {
      str = str + "]";
      AppMethodBeat.o(13181);
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13180);
    w.b(paramParcel, NativeFileSystem.class, 2);
    paramParcel.writeString(this.LGO);
    AppMethodBeat.o(13180);
  }
  
  @TargetApi(21)
  static final class a
  {
    static c a(File paramFile, FileSystem.b paramb, String paramString1, String paramString2)
    {
      AppMethodBeat.i(193389);
      try
      {
        paramFile = Os.stat(paramFile.getPath());
        if (paramFile == null)
        {
          AppMethodBeat.o(193389);
          return null;
        }
        boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
        paramFile = new c(paramb, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, 1000L * paramFile.st_mtime, bool);
        AppMethodBeat.o(193389);
        return paramFile;
      }
      catch (ErrnoException paramFile)
      {
        AppMethodBeat.o(193389);
      }
      return null;
    }
    
    static boolean mD(String paramString1, String paramString2)
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
    private long bbz = 0L;
    
    b(String paramString)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      AppMethodBeat.i(13154);
      try
      {
        this.bbz = getChannel().position();
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
      getChannel().position(this.bbz);
      AppMethodBeat.o(13155);
    }
  }
  
  protected final class c
    extends a
  {
    protected final String LGQ;
    private boolean LGR;
    
    c(String paramString)
    {
      AppMethodBeat.i(193391);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        this.LGQ = paramString;
        this.LGR = true;
        AppMethodBeat.o(193391);
        return;
      }
      this.LGQ = w.baa(paramString);
      this$1 = new File(this.LGQ);
      if (NativeFileSystem.this.isDirectory())
      {
        this.LGR = true;
        AppMethodBeat.o(193391);
        return;
      }
      if (NativeFileSystem.this.exists())
      {
        Log.e("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + NativeFileSystem.this.getPath());
        NativeFileSystem.this.delete();
      }
      this.LGR = false;
      AppMethodBeat.o(193391);
    }
    
    private c V(File paramFile)
    {
      AppMethodBeat.i(193403);
      String str1 = this.LGQ;
      if (!paramFile.getPath().startsWith(str1))
      {
        paramFile = new RuntimeException("Illegal file: " + paramFile + " (base: " + str1 + ")");
        AppMethodBeat.o(193403);
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
        AppMethodBeat.o(193403);
        return paramFile;
        i = str1.length();
      }
      if (!paramFile.exists())
      {
        AppMethodBeat.o(193403);
        return null;
      }
      boolean bool = paramFile.isDirectory();
      long l = paramFile.length();
      paramFile = new c(this, str1, str2, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
      AppMethodBeat.o(193403);
      return paramFile;
    }
    
    public final boolean Dc(String paramString)
    {
      AppMethodBeat.i(193404);
      paramString = de(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(193404);
        return false;
      }
      boolean bool = new File(paramString).delete();
      AppMethodBeat.o(193404);
      return bool;
    }
    
    public final ReadableByteChannel aZD(String paramString)
    {
      AppMethodBeat.i(193394);
      String str = de(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193394);
        throw paramString;
      }
      paramString = new FileInputStream(str).getChannel();
      AppMethodBeat.o(193394);
      return paramString;
    }
    
    public final ByteChannel aZE(String paramString)
    {
      AppMethodBeat.i(193397);
      String str = de(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193397);
        throw paramString;
      }
      paramString = new RandomAccessFile(str, "rw").getChannel();
      AppMethodBeat.o(193397);
      return paramString;
    }
    
    public final FileSystem.a aZF(String paramString)
    {
      AppMethodBeat.i(193392);
      Object localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      for (;;)
      {
        try
        {
          paramString = new StatFs(de((String)localObject, false));
          localObject = new FileSystem.a();
          if (Build.VERSION.SDK_INT >= 18)
          {
            ((FileSystem.a)localObject).IAj = paramString.getBlockSizeLong();
            ((FileSystem.a)localObject).IAi = paramString.getAvailableBlocksLong();
            ((FileSystem.a)localObject).IAg = paramString.getBlockCountLong();
            ((FileSystem.a)localObject).LGf = (((FileSystem.a)localObject).IAi * ((FileSystem.a)localObject).IAj);
            ((FileSystem.a)localObject).bGr = (((FileSystem.a)localObject).IAg * ((FileSystem.a)localObject).IAj);
            AppMethodBeat.o(193392);
            return localObject;
          }
        }
        catch (RuntimeException paramString)
        {
          AppMethodBeat.o(193392);
          return null;
        }
        ((FileSystem.a)localObject).IAj = paramString.getBlockSize();
        ((FileSystem.a)localObject).IAi = paramString.getAvailableBlocks();
        ((FileSystem.a)localObject).IAg = paramString.getBlockCount();
      }
    }
    
    public final boolean aZG(String paramString)
    {
      AppMethodBeat.i(193399);
      paramString = de(paramString, false);
      if ((paramString != null) && (new File(paramString).exists()))
      {
        AppMethodBeat.o(193399);
        return true;
      }
      AppMethodBeat.o(193399);
      return false;
    }
    
    public final c aZH(String paramString)
    {
      AppMethodBeat.i(193400);
      paramString = V(new File(de(paramString, false)));
      AppMethodBeat.o(193400);
      return paramString;
    }
    
    public final boolean aZI(String paramString)
    {
      AppMethodBeat.i(193405);
      paramString = de(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(193405);
        return false;
      }
      boolean bool = new File(paramString).mkdirs();
      AppMethodBeat.o(193405);
      return bool;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193407);
      if ((paramb.fSL() & 0x2) != 0)
      {
        paramb = paramb.de(paramString2, false);
        paramString1 = de(paramString1, true);
        if ((paramb != null) && (paramString1 != null))
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            bool = NativeFileSystem.a.mD(paramb, paramString1);
            AppMethodBeat.o(193407);
            return bool;
          }
          boolean bool = new File(paramb).renameTo(new File(paramString1));
          AppMethodBeat.o(193407);
          return bool;
        }
      }
      AppMethodBeat.o(193407);
      return false;
    }
    
    public final boolean cp(String paramString, long paramLong)
    {
      AppMethodBeat.i(193401);
      boolean bool = new File(de(paramString, true)).setLastModified(paramLong);
      AppMethodBeat.o(193401);
      return bool;
    }
    
    protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193408);
      String str = de(paramString1, true);
      if (str == null)
      {
        paramString1 = new IOException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(193408);
        throw paramString1;
      }
      long l = NativeFileSystem.f(str, paramb, paramString2);
      AppMethodBeat.o(193408);
      return l;
    }
    
    public final WritableByteChannel da(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193396);
      String str = de(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193396);
        throw paramString;
      }
      paramString = new FileOutputStream(str, paramBoolean).getChannel();
      AppMethodBeat.o(193396);
      return paramString;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193395);
      String str = de(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193395);
        throw paramString;
      }
      paramString = new FileOutputStream(str, paramBoolean);
      AppMethodBeat.o(193395);
      return paramString;
    }
    
    public final Iterable<c> dc(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193402);
      paramString = new File(de(paramString, false)).listFiles();
      if (paramString == null)
      {
        AppMethodBeat.o(193402);
        return null;
      }
      paramString = new com.tencent.mm.vfs.a.a(Arrays.asList(paramString), new a(paramBoolean));
      AppMethodBeat.o(193402);
      return paramString;
    }
    
    public final boolean dd(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193406);
      if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = new File(de(paramString, false));
        if (paramString.isDirectory()) {
          break;
        }
        AppMethodBeat.o(193406);
        return false;
      }
      if (paramBoolean)
      {
        paramBoolean = NativeFileSystem.c(paramString, bool);
        AppMethodBeat.o(193406);
        return paramBoolean;
      }
      paramBoolean = paramString.delete();
      AppMethodBeat.o(193406);
      return paramBoolean;
    }
    
    public final String de(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193409);
      String str = this.LGQ;
      if (str == null)
      {
        paramString = new IllegalStateException("Base path cannot be resolved: " + NativeFileSystem.this.LGO);
        AppMethodBeat.o(193409);
        throw paramString;
      }
      if ((paramBoolean) && (!this.LGR))
      {
        new File(this.LGQ).mkdirs();
        this.LGR = true;
      }
      if (paramString.isEmpty())
      {
        AppMethodBeat.o(193409);
        return str;
      }
      paramString = str + '/' + paramString;
      AppMethodBeat.o(193409);
      return paramString;
    }
    
    public final FileSystem fSK()
    {
      return NativeFileSystem.this;
    }
    
    public final int fSL()
    {
      return 31;
    }
    
    public final String fSX()
    {
      return this.LGQ;
    }
    
    public final ParcelFileDescriptor mA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(193398);
      String str = de(paramString1, true);
      if (str == null)
      {
        paramString1 = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(193398);
        throw paramString1;
      }
      paramString1 = ParcelFileDescriptor.open(new File(str), NativeFileSystem.aZN(paramString2));
      AppMethodBeat.o(193398);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(193393);
      String str = de(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(193393);
        throw paramString;
      }
      paramString = new NativeFileSystem.b(str);
      AppMethodBeat.o(193393);
      return paramString;
    }
    
    final class a
      implements a.a<File, c>
    {
      private final boolean FJ;
      private final boolean LGT;
      
      a(boolean paramBoolean)
      {
        this.FJ = paramBoolean;
        this.LGT = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */