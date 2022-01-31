package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class h
{
  private ContentResolver eRr;
  protected Context mContext;
  
  protected h(Context paramContext)
  {
    this.mContext = paramContext;
    this.eRr = this.mContext.getContentResolver();
  }
  
  private String WM(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.eRr.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        y.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + paramString);
        return null;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
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
      return paramString;
      paramString = null;
    }
  }
  
  public final ArrayList<g> cnM()
  {
    ArrayList localArrayList = new ArrayList();
    bk.UY();
    Cursor localCursor;
    try
    {
      localCursor = this.eRr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, null, null, "date_added desc limit 1");
      if (localCursor == null) {
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      return null;
    }
    if (localCursor.moveToFirst()) {}
    for (;;)
    {
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("_id"));
      String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      String str3 = localCursor.getString(localCursor.getColumnIndexOrThrow("date_added"));
      String str4 = WM(str1);
      if ((bk.bl(str2)) || (!com.tencent.mm.a.e.bK(str2))) {
        y.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        return localException;
        if (str2.startsWith(com.tencent.mm.compatible.util.e.dzD))
        {
          y.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.sgt = bk.getLong(str1, 0L);
          localg.kGY = bk.getLong(str3, 0L);
          if ((!bk.bl(str4)) && (com.tencent.mm.a.e.bK(str4))) {
            localg.thumbPath = str4;
          }
          if ((!bk.bl(str2)) && (com.tencent.mm.a.e.bK(str2))) {
            localg.sgu = str2;
          }
          if ((bk.bl(localg.sgu)) && (bk.bl(localg.sgu))) {
            y.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
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