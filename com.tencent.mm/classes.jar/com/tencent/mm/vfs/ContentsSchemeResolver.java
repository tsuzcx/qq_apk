package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;

public final class ContentsSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  private final ContentProviderFileSystem agwr;
  
  static
  {
    AppMethodBeat.i(13061);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13061);
  }
  
  private ContentsSchemeResolver()
  {
    AppMethodBeat.i(13059);
    this.agwr = new ContentProviderFileSystem(k.kMs().mContext);
    AppMethodBeat.o(13059);
  }
  
  public static SchemeResolver jKg()
  {
    return (SchemeResolver)a.agwt.agzC;
  }
  
  public final Pair<FileSystem.b, String> a(o paramo, Uri paramUri)
  {
    AppMethodBeat.i(238139);
    paramo = new StringBuilder();
    String str = paramUri.getScheme();
    if (str != null) {
      paramo.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if (str != null) {
      paramo.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      paramo.append(paramUri);
    }
    paramo = Pair.create(this.agwr, paramo.toString());
    AppMethodBeat.o(238139);
    return paramo;
  }
  
  static final class ContentProviderFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
    private final ContentResolver agws;
    
    ContentProviderFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13048);
      this.agws = paramContext.getContentResolver();
      AppMethodBeat.o(13048);
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(13050);
      try
      {
        InputStream localInputStream = this.agws.openInputStream(Uri.parse(paramString));
        if (localInputStream == null)
        {
          paramString = new FileNotFoundException("ContentResolver returns null");
          AppMethodBeat.o(13050);
          throw paramString;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        paramString = (FileNotFoundException)new FileNotFoundException(paramString + " cannot be opened: " + localRuntimeException.getMessage()).initCause(localRuntimeException);
        AppMethodBeat.o(13050);
        throw paramString;
      }
      AppMethodBeat.o(13050);
      return localRuntimeException;
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(13052);
      paramString = new FileNotFoundException("Not supported.");
      AppMethodBeat.o(13052);
      throw paramString;
    }
    
    public final boolean bDU(String paramString)
    {
      AppMethodBeat.i(13054);
      if (bDV(paramString) != null)
      {
        AppMethodBeat.o(13054);
        return true;
      }
      AppMethodBeat.o(13054);
      return false;
    }
    
    /* Error */
    public final j bDV(String paramString)
    {
      // Byte code:
      //   0: ldc 94
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/vfs/ContentsSchemeResolver$ContentProviderFileSystem:agws	Landroid/content/ContentResolver;
      //   9: aload_1
      //   10: invokestatic 50	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   13: aconst_null
      //   14: aconst_null
      //   15: aconst_null
      //   16: aconst_null
      //   17: invokevirtual 98	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +15 -> 39
      //   27: aload 5
      //   29: invokestatic 104	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   32: ldc 94
      //   34: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aconst_null
      //   38: areturn
      //   39: aload 5
      //   41: ldc 106
      //   43: invokeinterface 112 2 0
      //   48: istore_2
      //   49: aload 5
      //   51: ldc 114
      //   53: invokeinterface 112 2 0
      //   58: istore_3
      //   59: aload 5
      //   61: invokeinterface 118 1 0
      //   66: istore 4
      //   68: iload 4
      //   70: ifne +15 -> 85
      //   73: aload 5
      //   75: invokestatic 104	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   78: ldc 94
      //   80: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: aconst_null
      //   84: areturn
      //   85: new 120	com/tencent/mm/vfs/j
      //   88: dup
      //   89: aload_0
      //   90: aload_1
      //   91: aload 5
      //   93: iload_2
      //   94: invokeinterface 124 2 0
      //   99: aload 5
      //   101: iload_3
      //   102: invokeinterface 128 2 0
      //   107: lconst_0
      //   108: lconst_0
      //   109: iconst_0
      //   110: invokespecial 131	com/tencent/mm/vfs/j:<init>	(Lcom/tencent/mm/vfs/FileSystem$b;Ljava/lang/String;Ljava/lang/String;JJJZ)V
      //   113: astore_1
      //   114: aload 5
      //   116: invokestatic 104	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   119: ldc 94
      //   121: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   124: aload_1
      //   125: areturn
      //   126: astore_1
      //   127: aconst_null
      //   128: astore_1
      //   129: aload_1
      //   130: invokestatic 104	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   133: ldc 94
      //   135: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aconst_null
      //   139: areturn
      //   140: astore_1
      //   141: aconst_null
      //   142: astore 5
      //   144: aload 5
      //   146: invokestatic 104	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   149: ldc 94
      //   151: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: aload_1
      //   155: athrow
      //   156: astore_1
      //   157: goto -13 -> 144
      //   160: astore_1
      //   161: aload 5
      //   163: astore_1
      //   164: goto -35 -> 129
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	167	0	this	ContentProviderFileSystem
      //   0	167	1	paramString	String
      //   48	46	2	i	int
      //   58	44	3	j	int
      //   66	3	4	bool	boolean
      //   20	142	5	localCursor	android.database.Cursor
      // Exception table:
      //   from	to	target	type
      //   5	22	126	java/lang/RuntimeException
      //   5	22	140	finally
      //   39	68	156	finally
      //   85	114	156	finally
      //   39	68	160	java/lang/RuntimeException
      //   85	114	160	java/lang/RuntimeException
    }
    
    public final Iterable<j> bDW(String paramString)
    {
      return null;
    }
    
    public final boolean bDX(String paramString)
    {
      return false;
    }
    
    public final FileSystem.a bDY(String paramString)
    {
      AppMethodBeat.i(13049);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13049);
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
      AppMethodBeat.i(13051);
      try
      {
        ContentResolver localContentResolver = this.agws;
        Uri localUri = Uri.parse(paramString);
        if (paramBoolean) {}
        for (Object localObject = "wa";; localObject = "w")
        {
          localObject = localContentResolver.openOutputStream(localUri, (String)localObject);
          if (localObject != null) {
            break;
          }
          paramString = new FileNotFoundException("ContentResolver returns null");
          AppMethodBeat.o(13051);
          throw paramString;
        }
        AppMethodBeat.o(13051);
      }
      catch (RuntimeException localRuntimeException)
      {
        paramString = (FileNotFoundException)new FileNotFoundException(paramString + " cannot be opened: " + localRuntimeException.getMessage()).initCause(localRuntimeException);
        AppMethodBeat.o(13051);
        throw paramString;
      }
      return localRuntimeException;
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
      AppMethodBeat.i(13056);
      try
      {
        if (this.agws.delete(Uri.parse(paramString), null, null) > 0)
        {
          AppMethodBeat.o(13056);
          return true;
        }
        AppMethodBeat.o(13056);
        return false;
      }
      catch (RuntimeException paramString)
      {
        AppMethodBeat.o(13056);
      }
      return false;
    }
    
    public final FileSystem jKa()
    {
      return this;
    }
    
    public final int jKc()
    {
      return 1;
    }
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13053);
      try
      {
        paramString2 = this.agws.openFileDescriptor(Uri.parse(paramString1), paramString2);
        if (paramString2 == null)
        {
          paramString1 = new FileNotFoundException("ContentResolver returns null");
          AppMethodBeat.o(13053);
          throw paramString1;
        }
      }
      catch (RuntimeException paramString2)
      {
        paramString1 = (FileNotFoundException)new FileNotFoundException(paramString1 + " cannot be opened: " + paramString2.getMessage()).initCause(paramString2);
        AppMethodBeat.o(13053);
        throw paramString1;
      }
      AppMethodBeat.o(13053);
      return paramString2;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(13057);
      paramParcel = new UnsupportedOperationException();
      AppMethodBeat.o(13057);
      throw paramParcel;
    }
  }
  
  static class a
    implements Parcelable.Creator<ContentsSchemeResolver>
  {
    static final r<SchemeResolver, SchemeResolver.a> agwt;
    
    static
    {
      AppMethodBeat.i(13058);
      agwt = new r(new ContentsSchemeResolver((byte)0));
      AppMethodBeat.o(13058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */