package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.util.Map;

public final class ContentsSchemeResolver
  extends SingletonSchemeResolver
{
  public static final a CREATOR;
  private final ContentProviderFileSystem LFS;
  
  static
  {
    AppMethodBeat.i(13061);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13061);
  }
  
  private ContentsSchemeResolver()
  {
    AppMethodBeat.i(13059);
    this.LFS = new ContentProviderFileSystem(e.fSU().mContext);
    AppMethodBeat.o(13059);
  }
  
  public static SchemeResolver fSN()
  {
    return a.LFU.LHE;
  }
  
  public final Pair<FileSystem.b, String> a(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(193360);
    paramg = new StringBuilder();
    String str = paramUri.getScheme();
    if (str != null) {
      paramg.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if (str != null) {
      paramg.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      paramg.append(paramUri);
    }
    paramg = Pair.create(this.LFS, paramg.toString());
    AppMethodBeat.o(193360);
    return paramg;
  }
  
  static final class ContentProviderFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
    private final ContentResolver LFT;
    
    ContentProviderFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13048);
      this.LFT = paramContext.getContentResolver();
      AppMethodBeat.o(13048);
    }
    
    public final boolean Dc(String paramString)
    {
      AppMethodBeat.i(13056);
      if (this.LFT.delete(Uri.parse(paramString), null, null) > 0)
      {
        AppMethodBeat.o(13056);
        return true;
      }
      AppMethodBeat.o(13056);
      return false;
    }
    
    public final ByteChannel aZE(String paramString)
    {
      AppMethodBeat.i(13052);
      paramString = new FileNotFoundException("Not supported.");
      AppMethodBeat.o(13052);
      throw paramString;
    }
    
    public final FileSystem.a aZF(String paramString)
    {
      AppMethodBeat.i(13049);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13049);
      return paramString;
    }
    
    public final boolean aZG(String paramString)
    {
      AppMethodBeat.i(13054);
      if (aZH(paramString) != null)
      {
        AppMethodBeat.o(13054);
        return true;
      }
      AppMethodBeat.o(13054);
      return false;
    }
    
    public final c aZH(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(193359);
      try
      {
        Object localObject1 = this.LFT.query(Uri.parse(paramString), null, null, null, null);
        if (localObject1 == null)
        {
          w.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(193359);
          return null;
        }
        int i;
        int j;
        boolean bool;
        w.closeQuietly((Closeable)localObject1);
      }
      finally
      {
        try
        {
          i = ((Cursor)localObject1).getColumnIndex("_display_name");
          j = ((Cursor)localObject1).getColumnIndex("_size");
          bool = ((Cursor)localObject1).moveToFirst();
          if (!bool)
          {
            w.closeQuietly((Closeable)localObject1);
            AppMethodBeat.o(193359);
            return null;
          }
          paramString = new c(this, paramString, ((Cursor)localObject1).getString(i), ((Cursor)localObject1).getLong(j), 0L, 0L, false);
          w.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(193359);
          return paramString;
        }
        finally
        {
          break label134;
        }
        paramString = finally;
        localObject1 = localObject2;
      }
      label134:
      AppMethodBeat.o(193359);
      throw paramString;
    }
    
    public final boolean aZI(String paramString)
    {
      return false;
    }
    
    public final FileSystem.b cd(Map<String, String> paramMap)
    {
      return this;
    }
    
    public final boolean cp(String paramString, long paramLong)
    {
      return false;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13051);
      ContentResolver localContentResolver = this.LFT;
      Uri localUri = Uri.parse(paramString);
      if (paramBoolean) {}
      for (paramString = "wa";; paramString = "w")
      {
        paramString = localContentResolver.openOutputStream(localUri, paramString);
        AppMethodBeat.o(13051);
        return paramString;
      }
    }
    
    public final Iterable<c> dc(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean dd(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String de(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final FileSystem fSK()
    {
      return this;
    }
    
    public final int fSL()
    {
      return 1;
    }
    
    public final ParcelFileDescriptor mA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13053);
      paramString1 = this.LFT.openFileDescriptor(Uri.parse(paramString1), paramString2);
      AppMethodBeat.o(13053);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13050);
      paramString = this.LFT.openInputStream(Uri.parse(paramString));
      AppMethodBeat.o(13050);
      return paramString;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(13057);
      paramParcel = new UnsupportedOperationException();
      AppMethodBeat.o(13057);
      throw paramParcel;
    }
  }
  
  static final class a
    implements Parcelable.Creator<ContentsSchemeResolver>
  {
    static final i LFU;
    
    static
    {
      AppMethodBeat.i(13058);
      LFU = new i(new ContentsSchemeResolver((byte)0));
      AppMethodBeat.o(13058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */