package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.f;
import com.tencent.mm.vfs.a.f.a;
import com.tencent.stubs.logger.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class AssetsSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  private final AssetsFileSystem agvI;
  
  static
  {
    AppMethodBeat.i(13038);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13038);
  }
  
  private AssetsSchemeResolver()
  {
    AppMethodBeat.i(13036);
    this.agvI = new AssetsFileSystem(k.kMs().mContext);
    AppMethodBeat.o(13036);
  }
  
  public static AssetsSchemeResolver jKb()
  {
    return a.agvM;
  }
  
  public final Pair<FileSystem.b, String> a(o paramo, Uri paramUri)
  {
    AppMethodBeat.i(238406);
    paramo = paramUri.getPath();
    if (paramo == null) {}
    for (paramo = "";; paramo = ah.v(paramo, true, true))
    {
      paramo = Pair.create(this.agvI, paramo);
      AppMethodBeat.o(238406);
      return paramo;
    }
  }
  
  static final class AssetsFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
    private final AssetManager agvJ;
    
    AssetsFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13024);
      this.agvJ = paramContext.getAssets();
      AppMethodBeat.o(13024);
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(13026);
      try
      {
        paramString = this.agvJ.open(paramString);
        AppMethodBeat.o(13026);
        return paramString;
      }
      catch (IOException paramString)
      {
        if ((paramString instanceof FileNotFoundException))
        {
          paramString = (FileNotFoundException)paramString;
          AppMethodBeat.o(13026);
          throw paramString;
        }
        paramString = new FileNotFoundException(paramString.getMessage());
        AppMethodBeat.o(13026);
        throw paramString;
      }
    }
    
    protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(238180);
      paramString1 = new IOException("Not implemented");
      AppMethodBeat.o(238180);
      throw paramString1;
    }
    
    protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
    {
      return false;
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(13028);
      try
      {
        Lh(paramString).close();
        AppMethodBeat.o(13028);
        return true;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(13028);
      }
      return false;
    }
    
    public final j bDV(String paramString)
    {
      AppMethodBeat.i(238148);
      for (;;)
      {
        int j;
        try
        {
          localObject = Lh(paramString);
          int i = ((InputStream)localObject).available();
          ((InputStream)localObject).close();
          j = paramString.lastIndexOf('/');
          if (j < 0)
          {
            localObject = paramString;
            paramString = new j(this, paramString, (String)localObject, i, 0L, 0L, false);
            AppMethodBeat.o(238148);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          AppMethodBeat.o(238148);
          return null;
        }
        Object localObject = paramString.substring(j + 1);
      }
    }
    
    public final Iterable<j> bDW(final String paramString)
    {
      AppMethodBeat.i(238162);
      String str = ah.v(paramString, true, false);
      try
      {
        String[] arrayOfString = this.agvJ.list(str);
        if (arrayOfString == null)
        {
          AppMethodBeat.o(238162);
          return null;
        }
        if (str.isEmpty()) {}
        for (paramString = str;; paramString = str + '/')
        {
          paramString = new f(Arrays.asList(arrayOfString), new f.a()
          {
            /* Error */
            private j bDZ(String paramAnonymousString)
            {
              // Byte code:
              //   0: ldc 34
              //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: new 42	java/lang/StringBuilder
              //   8: dup
              //   9: invokespecial 43	java/lang/StringBuilder:<init>	()V
              //   12: aload_0
              //   13: getfield 25	com/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem$1:agvK	Ljava/lang/String;
              //   16: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   19: aload_1
              //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   23: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   26: astore 6
              //   28: aload_0
              //   29: getfield 23	com/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem$1:agvL	Lcom/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem;
              //   32: invokestatic 55	com/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem:a	(Lcom/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem;)Landroid/content/res/AssetManager;
              //   35: aload 6
              //   37: invokevirtual 61	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
              //   40: astore 5
              //   42: aload 5
              //   44: astore 4
              //   46: aload 5
              //   48: invokevirtual 67	java/io/InputStream:available	()I
              //   51: i2l
              //   52: lstore_2
              //   53: aload 5
              //   55: astore 4
              //   57: new 69	com/tencent/mm/vfs/j
              //   60: dup
              //   61: aload_0
              //   62: getfield 23	com/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem$1:agvL	Lcom/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem;
              //   65: aload 6
              //   67: aload_1
              //   68: lload_2
              //   69: lconst_0
              //   70: lconst_0
              //   71: iconst_0
              //   72: invokespecial 72	com/tencent/mm/vfs/j:<init>	(Lcom/tencent/mm/vfs/FileSystem$b;Ljava/lang/String;Ljava/lang/String;JJJZ)V
              //   75: astore 7
              //   77: aload 5
              //   79: invokestatic 78	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
              //   82: ldc 34
              //   84: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   87: aload 7
              //   89: areturn
              //   90: astore 4
              //   92: aconst_null
              //   93: astore 5
              //   95: aload 5
              //   97: astore 4
              //   99: new 69	com/tencent/mm/vfs/j
              //   102: dup
              //   103: aload_0
              //   104: getfield 23	com/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem$1:agvL	Lcom/tencent/mm/vfs/AssetsSchemeResolver$AssetsFileSystem;
              //   107: aload 6
              //   109: aload_1
              //   110: lconst_0
              //   111: lconst_0
              //   112: lconst_0
              //   113: iconst_1
              //   114: invokespecial 72	com/tencent/mm/vfs/j:<init>	(Lcom/tencent/mm/vfs/FileSystem$b;Ljava/lang/String;Ljava/lang/String;JJJZ)V
              //   117: astore_1
              //   118: aload 5
              //   120: invokestatic 78	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
              //   123: ldc 34
              //   125: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   128: aload_1
              //   129: areturn
              //   130: astore_1
              //   131: aconst_null
              //   132: astore 4
              //   134: aload 4
              //   136: invokestatic 78	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
              //   139: ldc 34
              //   141: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   144: aload_1
              //   145: athrow
              //   146: astore_1
              //   147: goto -13 -> 134
              //   150: astore 4
              //   152: goto -57 -> 95
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	155	0	this	1
              //   0	155	1	paramAnonymousString	String
              //   52	17	2	l	long
              //   44	12	4	localInputStream1	InputStream
              //   90	1	4	localIOException1	IOException
              //   97	38	4	localInputStream2	InputStream
              //   150	1	4	localIOException2	IOException
              //   40	79	5	localInputStream3	InputStream
              //   26	82	6	str	String
              //   75	13	7	localj	j
              // Exception table:
              //   from	to	target	type
              //   28	42	90	java/io/IOException
              //   28	42	130	finally
              //   46	53	146	finally
              //   57	77	146	finally
              //   99	118	146	finally
              //   46	53	150	java/io/IOException
              //   57	77	150	java/io/IOException
            }
          });
          AppMethodBeat.o(238162);
          return paramString;
        }
        return null;
      }
      catch (IOException paramString)
      {
        Log.e("VFS.AssetsFileSystem", paramString, "Cannot list: ".concat(String.valueOf(str)));
        AppMethodBeat.o(238162);
      }
    }
    
    public final boolean bDX(String paramString)
    {
      return false;
    }
    
    public final FileSystem.a bDY(String paramString)
    {
      AppMethodBeat.i(13025);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13025);
      return paramString;
    }
    
    public final boolean cF(String paramString, long paramLong)
    {
      return false;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13027);
      paramString = new FileNotFoundException("Cannot open files for writing on read-only filesystems");
      AppMethodBeat.o(13027);
      throw paramString;
    }
    
    public final boolean ew(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String ex(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean iP(String paramString)
    {
      return false;
    }
    
    public final FileSystem jKa()
    {
      return this;
    }
    
    public final int jKc()
    {
      return 12;
    }
    
    public final String toString()
    {
      return "AssetsFS";
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(13034);
      paramParcel = new UnsupportedOperationException();
      AppMethodBeat.o(13034);
      throw paramParcel;
    }
  }
  
  static class a
    implements Parcelable.Creator<AssetsSchemeResolver>
  {
    static final AssetsSchemeResolver agvM;
    
    static
    {
      AppMethodBeat.i(13035);
      agvM = new AssetsSchemeResolver((byte)0);
      AppMethodBeat.o(13035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */