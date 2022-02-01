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
  private final ContentProviderFileSystem Rbj;
  
  static
  {
    AppMethodBeat.i(13061);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13061);
  }
  
  private ContentsSchemeResolver()
  {
    AppMethodBeat.i(13059);
    this.Rbj = new ContentProviderFileSystem(g.hRR().mContext);
    AppMethodBeat.o(13059);
  }
  
  public static SchemeResolver hdT()
  {
    return a.Rbl.Rds;
  }
  
  public final Pair<FileSystem.b, String> a(k paramk, Uri paramUri)
  {
    AppMethodBeat.i(187633);
    paramk = new StringBuilder();
    String str = paramUri.getScheme();
    if (str != null) {
      paramk.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if (str != null) {
      paramk.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      paramk.append(paramUri);
    }
    paramk = Pair.create(this.Rbj, paramk.toString());
    AppMethodBeat.o(187633);
    return paramk;
  }
  
  static final class ContentProviderFileSystem
    extends a
    implements FileSystem
  {
    public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
    private final ContentResolver Rbk;
    
    ContentProviderFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13048);
      this.Rbk = paramContext.getContentResolver();
      AppMethodBeat.o(13048);
    }
    
    public final ByteChannel boJ(String paramString)
    {
      AppMethodBeat.i(13052);
      paramString = new FileNotFoundException("Not supported.");
      AppMethodBeat.o(13052);
      throw paramString;
    }
    
    public final FileSystem.a boK(String paramString)
    {
      AppMethodBeat.i(13049);
      paramString = new FileSystem.a();
      AppMethodBeat.o(13049);
      return paramString;
    }
    
    public final boolean boL(String paramString)
    {
      AppMethodBeat.i(13054);
      if (boM(paramString) != null)
      {
        AppMethodBeat.o(13054);
        return true;
      }
      AppMethodBeat.o(13054);
      return false;
    }
    
    public final e boM(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(187632);
      try
      {
        Object localObject1 = this.Rbk.query(Uri.parse(paramString), null, null, null, null);
        if (localObject1 == null)
        {
          aa.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(187632);
          return null;
        }
        int i;
        int j;
        boolean bool;
        aa.closeQuietly((Closeable)localObject1);
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
            aa.closeQuietly((Closeable)localObject1);
            AppMethodBeat.o(187632);
            return null;
          }
          paramString = new e(this, paramString, ((Cursor)localObject1).getString(i), ((Cursor)localObject1).getLong(j), 0L, 0L, false);
          aa.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(187632);
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
      AppMethodBeat.o(187632);
      throw paramString;
    }
    
    public final boolean boN(String paramString)
    {
      return false;
    }
    
    public final FileSystem.b cj(Map<String, String> paramMap)
    {
      return this;
    }
    
    public final boolean ck(String paramString, long paramLong)
    {
      return false;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13051);
      ContentResolver localContentResolver = this.Rbk;
      Uri localUri = Uri.parse(paramString);
      if (paramBoolean) {}
      for (paramString = "wa";; paramString = "w")
      {
        paramString = localContentResolver.openOutputStream(localUri, paramString);
        if (paramString != null) {
          break;
        }
        paramString = new FileNotFoundException("ContentResolver returns null");
        AppMethodBeat.o(13051);
        throw paramString;
      }
      AppMethodBeat.o(13051);
      return paramString;
    }
    
    public final Iterable<e> dx(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean dy(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String dz(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean gC(String paramString)
    {
      AppMethodBeat.i(13056);
      if (this.Rbk.delete(Uri.parse(paramString), null, null) > 0)
      {
        AppMethodBeat.o(13056);
        return true;
      }
      AppMethodBeat.o(13056);
      return false;
    }
    
    public final FileSystem hdQ()
    {
      return this;
    }
    
    public final int hdR()
    {
      return 1;
    }
    
    public final ParcelFileDescriptor nr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13053);
      paramString1 = this.Rbk.openFileDescriptor(Uri.parse(paramString1), paramString2);
      if (paramString1 == null)
      {
        paramString1 = new FileNotFoundException("ContentResolver returns null");
        AppMethodBeat.o(13053);
        throw paramString1;
      }
      AppMethodBeat.o(13053);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13050);
      paramString = this.Rbk.openInputStream(Uri.parse(paramString));
      if (paramString == null)
      {
        paramString = new FileNotFoundException("ContentResolver returns null");
        AppMethodBeat.o(13050);
        throw paramString;
      }
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
    static final m Rbl;
    
    static
    {
      AppMethodBeat.i(13058);
      Rbl = new m(new ContentsSchemeResolver((byte)0));
      AppMethodBeat.o(13058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */