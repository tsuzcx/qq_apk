package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;

public final class h
{
  private ContentResolver gJw;
  protected Context mContext;
  
  protected h(Context paramContext)
  {
    AppMethodBeat.i(31743);
    this.mContext = paramContext;
    this.gJw = this.mContext.getContentResolver();
    AppMethodBeat.o(31743);
  }
  
  private String aOy(String paramString)
  {
    AppMethodBeat.i(31744);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      AppMethodBeat.o(31744);
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.gJw.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(31744);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(31744);
      return null;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        paramString = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("_data"));
      } while (((Cursor)localObject).moveToNext());
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(31744);
      return paramString;
      paramString = null;
    }
  }
  
  public final ArrayList<g> fik()
  {
    AppMethodBeat.i(31745);
    ArrayList localArrayList = new ArrayList();
    long l = bu.fpO() / 1000L;
    Cursor localCursor;
    try
    {
      ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "query excludeImageWithFeatureDate");
      localCursor = this.gJw.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, "date_added <= ?", new String[] { String.valueOf(l) }, "date_added desc limit 1");
      if (localCursor == null)
      {
        AppMethodBeat.o(31745);
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      if (0 != 0) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(31745);
      return null;
    }
    if (localCursor.moveToFirst()) {}
    for (;;)
    {
      String str3 = localCursor.getString(localCursor.getColumnIndexOrThrow("_id"));
      String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("date_added"));
      String str4 = aOy(str3);
      if ((bu.isNullOrNil(str2)) || (!o.fB(str2))) {
        ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        AppMethodBeat.o(31745);
        return localArrayList;
        if (str2.startsWith(b.asv()))
        {
          ae.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.tSr = bu.getLong(str3, 0L);
          localg.Fwk = bu.getLong(str1, 0L);
          if ((!bu.isNullOrNil(str4)) && (o.fB(str4))) {
            localg.thumbPath = str4;
          }
          if ((!bu.isNullOrNil(str2)) && (o.fB(str2))) {
            localg.Fwj = str2;
          }
          if ((bu.isNullOrNil(localg.Fwj)) && (bu.isNullOrNil(localg.Fwj))) {
            ae.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
          } else {
            localArrayList.add(localg);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean fhJ();
    
    public abstract int getYFromBottom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.h
 * JD-Core Version:    0.7.0.1
 */