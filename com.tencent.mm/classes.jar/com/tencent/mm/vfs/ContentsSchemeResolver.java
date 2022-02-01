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

public final class ContentsSchemeResolver
  extends SchemeResolver.Base
{
  public static final a CREATOR;
  private final ContentProviderFileSystem HRk;
  
  static
  {
    AppMethodBeat.i(13061);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13061);
  }
  
  private ContentsSchemeResolver()
  {
    AppMethodBeat.i(13059);
    this.HRk = new ContentProviderFileSystem(a.gap().mContext);
    AppMethodBeat.o(13059);
  }
  
  public static ContentsSchemeResolver fhC()
  {
    return a.HRm;
  }
  
  public final Pair<FileSystem, String> a(SchemeResolver.a parama, Uri paramUri)
  {
    AppMethodBeat.i(13060);
    parama = new StringBuilder();
    String str = paramUri.getScheme();
    if (str != null) {
      parama.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if (str != null) {
      parama.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      parama.append(paramUri);
    }
    parama = new Pair(this.HRk, parama.toString());
    AppMethodBeat.o(13060);
    return parama;
  }
  
  static final class ContentProviderFileSystem
    extends AbstractFileSystem
  {
    public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
    private final ContentResolver HRl;
    
    ContentProviderFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13048);
      this.HRl = paramContext.getContentResolver();
      AppMethodBeat.o(13048);
    }
    
    public final ByteChannel aMB(String paramString)
    {
      AppMethodBeat.i(13052);
      paramString = new FileNotFoundException("Not supported.");
      AppMethodBeat.o(13052);
      throw paramString;
    }
    
    public final FileSystem.b aMC(String paramString)
    {
      AppMethodBeat.i(13049);
      paramString = new FileSystem.b();
      AppMethodBeat.o(13049);
      return paramString;
    }
    
    public final boolean aMD(String paramString)
    {
      AppMethodBeat.i(13054);
      if (aME(paramString) != null)
      {
        AppMethodBeat.o(13054);
        return true;
      }
      AppMethodBeat.o(13054);
      return false;
    }
    
    public final FileSystem.a aME(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(13055);
      try
      {
        Object localObject1 = this.HRl.query(Uri.parse(paramString), null, null, null, null);
        if (localObject1 == null)
        {
          q.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(13055);
          return null;
        }
        int i;
        int j;
        boolean bool;
        q.closeQuietly((Closeable)localObject1);
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
            q.closeQuietly((Closeable)localObject1);
            AppMethodBeat.o(13055);
            return null;
          }
          paramString = new FileSystem.a(this, paramString, ((Cursor)localObject1).getString(i), ((Cursor)localObject1).getLong(j), 0L, 0L, false);
          q.closeQuietly((Closeable)localObject1);
          AppMethodBeat.o(13055);
          return paramString;
        }
        finally
        {
          break label138;
        }
        paramString = finally;
        localObject1 = localObject2;
      }
      label138:
      AppMethodBeat.o(13055);
      throw paramString;
    }
    
    public final boolean aMF(String paramString)
    {
      return false;
    }
    
    public final OutputStream cM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13051);
      ContentResolver localContentResolver = this.HRl;
      Uri localUri = Uri.parse(paramString);
      if (paramBoolean) {}
      for (paramString = "wa";; paramString = "w")
      {
        paramString = localContentResolver.openOutputStream(localUri, paramString);
        AppMethodBeat.o(13051);
        return paramString;
      }
    }
    
    public final Iterable<FileSystem.a> cN(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean cO(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String cP(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean cf(String paramString, long paramLong)
    {
      return false;
    }
    
    public final int fhA()
    {
      return 1;
    }
    
    public final ParcelFileDescriptor lw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13053);
      paramString1 = this.HRl.openFileDescriptor(Uri.parse(paramString1), paramString2);
      AppMethodBeat.o(13053);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13050);
      paramString = this.HRl.openInputStream(Uri.parse(paramString));
      AppMethodBeat.o(13050);
      return paramString;
    }
    
    public final boolean vv(String paramString)
    {
      AppMethodBeat.i(13056);
      if (this.HRl.delete(Uri.parse(paramString), null, null) > 0)
      {
        AppMethodBeat.o(13056);
        return true;
      }
      AppMethodBeat.o(13056);
      return false;
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
    static final ContentsSchemeResolver HRm;
    
    static
    {
      AppMethodBeat.i(13058);
      HRm = new ContentsSchemeResolver((byte)0);
      AppMethodBeat.o(13058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */