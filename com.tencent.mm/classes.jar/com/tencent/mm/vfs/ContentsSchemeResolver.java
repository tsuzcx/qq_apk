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
  private final ContentProviderFileSystem JrR;
  
  static
  {
    AppMethodBeat.i(13061);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(13061);
  }
  
  private ContentsSchemeResolver()
  {
    AppMethodBeat.i(13059);
    this.JrR = new ContentProviderFileSystem(a.ghk().mContext);
    AppMethodBeat.o(13059);
  }
  
  public static ContentsSchemeResolver fxE()
  {
    return a.JrT;
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
    parama = new Pair(this.JrR, parama.toString());
    AppMethodBeat.o(13060);
    return parama;
  }
  
  static final class ContentProviderFileSystem
    extends AbstractFileSystem
  {
    public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR = null;
    private final ContentResolver JrS;
    
    ContentProviderFileSystem(Context paramContext)
    {
      AppMethodBeat.i(13048);
      this.JrS = paramContext.getContentResolver();
      AppMethodBeat.o(13048);
    }
    
    public final ByteChannel aSd(String paramString)
    {
      AppMethodBeat.i(13052);
      paramString = new FileNotFoundException("Not supported.");
      AppMethodBeat.o(13052);
      throw paramString;
    }
    
    public final FileSystem.b aSe(String paramString)
    {
      AppMethodBeat.i(13049);
      paramString = new FileSystem.b();
      AppMethodBeat.o(13049);
      return paramString;
    }
    
    public final boolean aSf(String paramString)
    {
      AppMethodBeat.i(13054);
      if (aSg(paramString) != null)
      {
        AppMethodBeat.o(13054);
        return true;
      }
      AppMethodBeat.o(13054);
      return false;
    }
    
    public final FileSystem.a aSg(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(13055);
      try
      {
        Object localObject1 = this.JrS.query(Uri.parse(paramString), null, null, null, null);
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
    
    public final boolean aSh(String paramString)
    {
      return false;
    }
    
    public final OutputStream cS(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13051);
      ContentResolver localContentResolver = this.JrS;
      Uri localUri = Uri.parse(paramString);
      if (paramBoolean) {}
      for (paramString = "wa";; paramString = "w")
      {
        paramString = localContentResolver.openOutputStream(localUri, paramString);
        AppMethodBeat.o(13051);
        return paramString;
      }
    }
    
    public final Iterable<FileSystem.a> cT(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean cU(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public final String cV(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public final boolean ch(String paramString, long paramLong)
    {
      return false;
    }
    
    public final int fxC()
    {
      return 1;
    }
    
    public final ParcelFileDescriptor lT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13053);
      paramString1 = this.JrS.openFileDescriptor(Uri.parse(paramString1), paramString2);
      AppMethodBeat.o(13053);
      return paramString1;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(13050);
      paramString = this.JrS.openInputStream(Uri.parse(paramString));
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
    
    public final boolean zB(String paramString)
    {
      AppMethodBeat.i(13056);
      if (this.JrS.delete(Uri.parse(paramString), null, null) > 0)
      {
        AppMethodBeat.o(13056);
        return true;
      }
      AppMethodBeat.o(13056);
      return false;
    }
  }
  
  static final class a
    implements Parcelable.Creator<ContentsSchemeResolver>
  {
    static final ContentsSchemeResolver JrT;
    
    static
    {
      AppMethodBeat.i(13058);
      JrT = new ContentsSchemeResolver((byte)0);
      AppMethodBeat.o(13058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */