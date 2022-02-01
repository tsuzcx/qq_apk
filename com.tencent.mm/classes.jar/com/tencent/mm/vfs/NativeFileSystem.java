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
import com.tencent.mm.vfs.a.h.a;
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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class NativeFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<NativeFileSystem> CREATOR;
  protected final h agys;
  private final e agyt;
  
  static
  {
    AppMethodBeat.i(13183);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13183);
  }
  
  protected NativeFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13157);
    ah.a(paramParcel, NativeFileSystem.class, 2);
    paramParcel = paramParcel.readString();
    if (paramParcel == null)
    {
      paramParcel = "";
      this.agys = new h(paramParcel);
      if (!paramParcel.isEmpty()) {
        break label80;
      }
      paramParcel = new e(paramParcel);
    }
    for (;;)
    {
      this.agyt = paramParcel;
      AppMethodBeat.o(13157);
      return;
      paramParcel = ah.v(paramParcel, true, false);
      break;
      label80:
      if (this.agys.jKr()) {
        paramParcel = null;
      } else {
        paramParcel = new e(paramParcel);
      }
    }
  }
  
  public NativeFileSystem(String paramString)
  {
    AppMethodBeat.i(13156);
    paramString = ah.v(paramString, true, false);
    this.agys = new h(paramString);
    if (paramString.isEmpty()) {
      paramString = new e(paramString);
    }
    for (;;)
    {
      this.agyt = paramString;
      AppMethodBeat.o(13156);
      return;
      if (this.agys.jKr()) {
        paramString = null;
      } else {
        paramString = new e(paramString);
      }
    }
  }
  
  private static boolean S(File paramFile)
  {
    AppMethodBeat.i(238232);
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
          bool1 &= S(localFile);
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
    AppMethodBeat.o(238232);
    return bool2 & bool3;
  }
  
  public final FileSystem.b cO(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238295);
    if (this.agyt != null)
    {
      paramMap = this.agyt;
      AppMethodBeat.o(238295);
      return paramMap;
    }
    paramMap = this.agys.cR(paramMap);
    Log.i("VFS.NativeFileSystem", "Real path resolved: " + this.agys + " => " + paramMap);
    if (paramMap == null)
    {
      paramMap = NullFileSystem.jKG();
      AppMethodBeat.o(238295);
      return paramMap;
    }
    paramMap = new e(paramMap);
    AppMethodBeat.o(238295);
    return paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238282);
    if (((paramObject instanceof NativeFileSystem)) && (this.agys.equals(((NativeFileSystem)paramObject).agys)))
    {
      AppMethodBeat.o(238282);
      return true;
    }
    AppMethodBeat.o(238282);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238275);
    int i = NativeFileSystem.class.hashCode();
    int j = this.agys.hashCode();
    AppMethodBeat.o(238275);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13181);
    StringBuilder localStringBuilder = new StringBuilder("Native [");
    if (this.agyt == null) {}
    for (Object localObject = this.agys;; localObject = this.agyt.jKF())
    {
      localObject = localObject + "]";
      AppMethodBeat.o(13181);
      return localObject;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13180);
    ah.b(paramParcel, NativeFileSystem.class, 2);
    paramParcel.writeString(this.agys.value);
    AppMethodBeat.o(13180);
  }
  
  static final class a
  {
    static j a(String paramString1, FileSystem.b paramb, String paramString2, String paramString3)
    {
      AppMethodBeat.i(238334);
      try
      {
        StructStat localStructStat = Os.lstat(paramString1);
        if (localStructStat == null)
        {
          AppMethodBeat.o(238334);
          return null;
        }
        if (OsConstants.S_ISLNK(localStructStat.st_mode)) {}
        for (paramString1 = Os.stat(paramString1);; paramString1 = localStructStat)
        {
          paramString1 = new j(paramb, paramString2, paramString3, paramString1.st_size, 512L * localStructStat.st_blocks, 1000L * localStructStat.st_mtime, OsConstants.S_ISDIR(paramString1.st_mode));
          AppMethodBeat.o(238334);
          return paramString1;
        }
        return null;
      }
      catch (ErrnoException paramString1)
      {
        AppMethodBeat.o(238334);
      }
    }
    
    static boolean qi(String paramString1, String paramString2)
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
      catch (RuntimeException localRuntimeException)
      {
        paramString1 = new IOException("Cannot move file " + paramString1 + " to " + paramString2 + ": " + localRuntimeException.getMessage(), localRuntimeException);
        AppMethodBeat.o(13147);
        throw paramString1;
      }
    }
  }
  
  static final class b
  {
    static Iterable<j> a(NativeFileSystem.e parame, String paramString)
    {
      AppMethodBeat.i(238336);
      Path localPath;
      try
      {
        localPath = Paths.get(paramString, new String[0]);
        boolean bool = Files.isDirectory(localPath, new LinkOption[0]);
        if (!bool)
        {
          AppMethodBeat.o(238336);
          return null;
        }
      }
      catch (InvalidPathException parame)
      {
        Log.w("VFS.NativeFileSystem", "Invalid path for list: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238336);
        return null;
      }
      parame = new NativeFileSystem.c(localPath, parame);
      AppMethodBeat.o(238336);
      return parame;
    }
    
    static boolean bDX(String paramString)
    {
      AppMethodBeat.i(238341);
      paramString = Paths.get(paramString, new String[0]);
      if (Files.isDirectory(paramString, new LinkOption[] { LinkOption.NOFOLLOW_LINKS }))
      {
        AppMethodBeat.o(238341);
        return false;
      }
      try
      {
        Files.createDirectories(paramString, new FileAttribute[0]);
        AppMethodBeat.o(238341);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("VFS.NativeFileSystem", paramString, "Cannot create directory.");
        AppMethodBeat.o(238341);
      }
      return false;
    }
  }
  
  static final class c
    implements a.a<Path, j>, h.a, Iterable<j>
  {
    private DirectoryStream<Path> agyu;
    private final Path agyv;
    private final NativeFileSystem.e agyw;
    private final j[] agyx;
    private final Iterable<j> agyy;
    
    c(Path paramPath, NativeFileSystem.e parame)
    {
      AppMethodBeat.i(238343);
      this.agyx = new j[1];
      this.agyy = Arrays.asList(this.agyx);
      this.agyv = paramPath;
      this.agyw = parame;
      AppMethodBeat.o(238343);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(238363);
      jKE();
      AppMethodBeat.o(238363);
    }
    
    public final Iterator<j> iterator()
    {
      AppMethodBeat.i(238356);
      ah.closeQuietly(this.agyu);
      try
      {
        this.agyu = Files.newDirectoryStream(this.agyv);
        Iterator local1 = new Iterator()
        {
          final Iterator<j> agyz;
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(238086);
            try
            {
              boolean bool = this.agyz.hasNext();
              AppMethodBeat.o(238086);
              return bool;
            }
            catch (RuntimeException localRuntimeException)
            {
              Log.w("VFS.NativeFileSystem", localRuntimeException, "Cannot iterate through directory: " + NativeFileSystem.c.b(NativeFileSystem.c.this).toString());
              AppMethodBeat.o(238086);
            }
            return false;
          }
        };
        AppMethodBeat.o(238356);
        return local1;
      }
      catch (Exception localException)
      {
        Log.w("VFS.NativeFileSystem", localException, "Cannot list directory '" + this.agyv + "'");
        this.agyu = null;
        Iterator localIterator = Collections.emptyIterator();
        AppMethodBeat.o(238356);
        return localIterator;
      }
    }
    
    public final void jKE()
    {
      AppMethodBeat.i(238360);
      ah.closeQuietly(this.agyu);
      this.agyu = null;
      AppMethodBeat.o(238360);
    }
  }
  
  static final class d
    extends FileInputStream
  {
    private long mMarkPosition = 0L;
    
    d(String paramString)
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
  
  protected class e
    extends a
  {
    protected final String agyB;
    private boolean agyC;
    
    e(String paramString)
    {
      AppMethodBeat.i(238376);
      if (paramString.isEmpty()) {}
      for (this$1 = "";; this$1 = ah.bEu(paramString))
      {
        paramString = NativeFileSystem.this;
        if (NativeFileSystem.this.equals("/")) {
          paramString = "";
        }
        this.agyB = paramString;
        if (!this.agyB.isEmpty()) {
          break;
        }
        this.agyC = true;
        AppMethodBeat.o(238376);
        return;
      }
      this$1 = new File(this.agyB);
      if (NativeFileSystem.this.isDirectory())
      {
        this.agyC = true;
        AppMethodBeat.o(238376);
        return;
      }
      if (NativeFileSystem.this.exists())
      {
        Log.e("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + NativeFileSystem.this.getPath());
        NativeFileSystem.this.delete();
      }
      this.agyC = false;
      AppMethodBeat.o(238376);
    }
    
    private j U(File paramFile)
    {
      AppMethodBeat.i(238386);
      String str1 = this.agyB;
      if (!paramFile.getPath().startsWith(str1))
      {
        paramFile = new RuntimeException("Illegal file: " + paramFile + " (base: " + str1 + ")");
        AppMethodBeat.o(238386);
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
        paramFile = NativeFileSystem.a.a(paramFile.getPath(), this, str1, str2);
        AppMethodBeat.o(238386);
        return paramFile;
        i = str1.length();
      }
      if (!paramFile.exists())
      {
        AppMethodBeat.o(238386);
        return null;
      }
      boolean bool = paramFile.isDirectory();
      long l = paramFile.length();
      paramFile = new j(this, str1, str2, l, 0xFFFFF000 & 4096L + l - 1L, paramFile.lastModified(), bool);
      AppMethodBeat.o(238386);
      return paramFile;
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238418);
      String str = ex(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238418);
        throw paramString;
      }
      try
      {
        paramString = new NativeFileSystem.d(str);
        AppMethodBeat.o(238418);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.o(paramString);
        AppMethodBeat.o(238418);
        throw paramString;
      }
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(238487);
      if ((paramb.jKc() & 0x2) != 0)
      {
        paramb = paramb.ex(paramString2, false);
        paramString1 = ex(paramString1, true);
        if ((paramb != null) && (paramString1 != null))
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            bool = NativeFileSystem.a.qi(paramb, paramString1);
            AppMethodBeat.o(238487);
            return bool;
          }
          boolean bool = new File(paramb).renameTo(new File(paramString1));
          AppMethodBeat.o(238487);
          return bool;
        }
      }
      AppMethodBeat.o(238487);
      return false;
    }
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238423);
      String str = ex(paramString, false);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238423);
        throw paramString;
      }
      try
      {
        paramString = new FileInputStream(str).getChannel();
        AppMethodBeat.o(238423);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.o(paramString);
        AppMethodBeat.o(238423);
        throw paramString;
      }
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(238440);
      String str = ex(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238440);
        throw paramString;
      }
      try
      {
        paramString = new RandomAccessFile(str, "rw").getChannel();
        AppMethodBeat.o(238440);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.o(paramString);
        AppMethodBeat.o(238440);
        throw paramString;
      }
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(238448);
      paramString = ex(paramString, false);
      if ((paramString != null) && (new File(paramString).exists()))
      {
        AppMethodBeat.o(238448);
        return true;
      }
      AppMethodBeat.o(238448);
      return false;
    }
    
    public final j bDV(String paramString)
    {
      AppMethodBeat.i(238454);
      paramString = ex(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(238454);
        return null;
      }
      paramString = U(new File(paramString));
      AppMethodBeat.o(238454);
      return paramString;
    }
    
    public final Iterable<j> bDW(final String paramString)
    {
      AppMethodBeat.i(238467);
      paramString = ex(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(238467);
        return null;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramString = NativeFileSystem.b.a(this, paramString);
        AppMethodBeat.o(238467);
        return paramString;
      }
      paramString = new File(paramString);
      String[] arrayOfString = paramString.list();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(238467);
        return null;
      }
      paramString = new com.tencent.mm.vfs.a.a(Arrays.asList(arrayOfString), new a.a()
      {
        final j[] agyx;
        final Iterable<j> agyy;
      });
      AppMethodBeat.o(238467);
      return paramString;
    }
    
    public final boolean bDX(String paramString)
    {
      AppMethodBeat.i(238476);
      paramString = ex(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(238476);
        return false;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        bool = NativeFileSystem.b.bDX(paramString);
        AppMethodBeat.o(238476);
        return bool;
      }
      boolean bool = new File(paramString).mkdirs();
      AppMethodBeat.o(238476);
      return bool;
    }
    
    public final FileSystem.a bDY(String paramString)
    {
      AppMethodBeat.i(238413);
      for (;;)
      {
        FileSystem.a locala;
        try
        {
          paramString = new StatFs(ex(paramString, false));
          locala = new FileSystem.a();
          if (Build.VERSION.SDK_INT >= 18)
          {
            locala.blockSize = paramString.getBlockSizeLong();
            locala.availableBlocks = paramString.getAvailableBlocksLong();
            locala.totalBlocks = paramString.getBlockCountLong();
            locala.agxj = (locala.availableBlocks * locala.blockSize);
            locala.djV = (locala.totalBlocks * locala.blockSize);
            AppMethodBeat.o(238413);
            return locala;
          }
        }
        catch (RuntimeException paramString)
        {
          AppMethodBeat.o(238413);
          return null;
        }
        locala.blockSize = paramString.getBlockSize();
        locala.availableBlocks = paramString.getAvailableBlocks();
        locala.totalBlocks = paramString.getBlockCount();
      }
    }
    
    public final boolean cF(String paramString, long paramLong)
    {
      AppMethodBeat.i(238461);
      paramString = ex(paramString, true);
      if (paramString == null)
      {
        AppMethodBeat.o(238461);
        return false;
      }
      boolean bool = new File(paramString).setLastModified(paramLong);
      AppMethodBeat.o(238461);
      return bool;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238504);
      if (((paramObject instanceof e)) && (this.agyB.equals(((e)paramObject).agyB)))
      {
        AppMethodBeat.o(238504);
        return true;
      }
      AppMethodBeat.o(238504);
      return false;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238436);
      String str = ex(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238436);
        throw paramString;
      }
      try
      {
        paramString = new FileOutputStream(str, paramBoolean).getChannel();
        AppMethodBeat.o(238436);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.o(paramString);
        AppMethodBeat.o(238436);
        throw paramString;
      }
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238428);
      String str = ex(paramString, true);
      if (str == null)
      {
        paramString = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238428);
        throw paramString;
      }
      try
      {
        paramString = new FileOutputStream(str, paramBoolean);
        AppMethodBeat.o(238428);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = NativeFileSystem.o(paramString);
        AppMethodBeat.o(238428);
        throw paramString;
      }
    }
    
    public final boolean ew(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238482);
      String str = ex(paramString, false);
      if (str == null)
      {
        AppMethodBeat.o(238482);
        return false;
      }
      if ((paramString.isEmpty()) || (paramString.equals("/"))) {}
      for (int i = 1;; i = 0)
      {
        paramString = new File(str);
        if (paramString.isDirectory()) {
          break;
        }
        AppMethodBeat.o(238482);
        return false;
      }
      if (paramBoolean) {}
      for (paramBoolean = NativeFileSystem.T(paramString);; paramBoolean = paramString.delete())
      {
        if ((i != 0) && (paramBoolean)) {
          this.agyC = false;
        }
        AppMethodBeat.o(238482);
        return paramBoolean;
      }
    }
    
    public final String ex(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238492);
      if (this.agyB == null)
      {
        paramString = new IllegalStateException("Base path cannot be resolved: " + NativeFileSystem.this.agys);
        AppMethodBeat.o(238492);
        throw paramString;
      }
      if ((paramBoolean) && (!this.agyC))
      {
        new File(this.agyB).mkdirs();
        this.agyC = true;
      }
      if (paramString.isEmpty())
      {
        paramString = this.agyB;
        AppMethodBeat.o(238492);
        return paramString;
      }
      paramString = this.agyB + '/' + paramString;
      AppMethodBeat.o(238492);
      return paramString;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238499);
      int i = e.class.hashCode();
      int j = this.agyB.hashCode();
      AppMethodBeat.o(238499);
      return i ^ j;
    }
    
    public final boolean iP(String paramString)
    {
      AppMethodBeat.i(238471);
      paramString = ex(paramString, false);
      if (paramString == null)
      {
        AppMethodBeat.o(238471);
        return false;
      }
      boolean bool = new File(paramString).delete();
      AppMethodBeat.o(238471);
      return bool;
    }
    
    public final String jKF()
    {
      return this.agyB;
    }
    
    public final FileSystem jKa()
    {
      return NativeFileSystem.this;
    }
    
    public final int jKc()
    {
      return 31;
    }
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238444);
      String str = ex(paramString1, true);
      if (str == null)
      {
        paramString1 = new FileNotFoundException("Invalid path: ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(238444);
        throw paramString1;
      }
      try
      {
        paramString1 = ParcelFileDescriptor.open(new File(str), NativeFileSystem.bEe(paramString2));
        AppMethodBeat.o(238444);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1 = NativeFileSystem.o(paramString1);
        AppMethodBeat.o(238444);
        throw paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem
 * JD-Core Version:    0.7.0.1
 */