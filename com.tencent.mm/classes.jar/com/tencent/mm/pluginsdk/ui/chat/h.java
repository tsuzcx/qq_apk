package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class h
{
  private ContentResolver gjm;
  protected Context mContext;
  
  protected h(Context paramContext)
  {
    AppMethodBeat.i(27948);
    this.mContext = paramContext;
    this.gjm = this.mContext.getContentResolver();
    AppMethodBeat.o(27948);
  }
  
  private String amt(String paramString)
  {
    AppMethodBeat.i(27949);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      AppMethodBeat.o(27949);
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.gjm.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(27949);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(27949);
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
      AppMethodBeat.o(27949);
      return paramString;
      paramString = null;
    }
  }
  
  public final ArrayList<g> doT()
  {
    AppMethodBeat.i(27950);
    ArrayList localArrayList = new ArrayList();
    bo.aoy();
    Cursor localCursor;
    try
    {
      localCursor = this.gjm.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, null, null, "date_added desc limit 1");
      if (localCursor == null)
      {
        AppMethodBeat.o(27950);
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      AppMethodBeat.o(27950);
      return null;
    }
    if (localCursor.moveToFirst()) {}
    for (;;)
    {
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("_id"));
      String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      String str3 = localCursor.getString(localCursor.getColumnIndexOrThrow("date_added"));
      String str4 = amt(str1);
      if ((bo.isNullOrNil(str2)) || (!com.tencent.mm.a.e.cN(str2))) {
        ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        AppMethodBeat.o(27950);
        return localException;
        if (str2.startsWith(com.tencent.mm.compatible.util.e.esr))
        {
          ab.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.vYK = bo.getLong(str1, 0L);
          localg.vYM = bo.getLong(str3, 0L);
          if ((!bo.isNullOrNil(str4)) && (com.tencent.mm.a.e.cN(str4))) {
            localg.thumbPath = str4;
          }
          if ((!bo.isNullOrNil(str2)) && (com.tencent.mm.a.e.cN(str2))) {
            localg.vYL = str2;
          }
          if ((bo.isNullOrNil(localg.vYL)) && (bo.isNullOrNil(localg.vYL))) {
            ab.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
          } else {
            localException.add(localg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.h
 * JD-Core Version:    0.7.0.1
 */