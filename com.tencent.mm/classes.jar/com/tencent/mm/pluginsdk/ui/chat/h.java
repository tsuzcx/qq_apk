package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;

public final class h
{
  protected Context mContext;
  private ContentResolver mJn;
  
  protected h(Context paramContext)
  {
    AppMethodBeat.i(31743);
    this.mContext = paramContext;
    this.mJn = this.mContext.getContentResolver();
    AppMethodBeat.o(31743);
  }
  
  private String brk(String paramString)
  {
    AppMethodBeat.i(31744);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      AppMethodBeat.o(31744);
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.mJn.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(31744);
        return null;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
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
  
  public final ArrayList<g> iNl()
  {
    AppMethodBeat.i(31745);
    ArrayList localArrayList = new ArrayList();
    long l = Util.nowMilliSecond() / 1000L;
    Cursor localCursor;
    try
    {
      Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query excludeImageWithFeatureDate");
      localCursor = this.mJn.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, "date_added <= ?", new String[] { String.valueOf(l) }, "date_added desc limit 1");
      if (localCursor == null)
      {
        AppMethodBeat.o(31745);
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      if (0 != 0) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(31745);
      return null;
    }
    if (localCursor.moveToFirst()) {}
    for (;;)
    {
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("_id"));
      String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      String str4 = localCursor.getString(localCursor.getColumnIndexOrThrow("date_added"));
      String str3 = brk(str1);
      if ((Util.isNullOrNil(str2)) || (!y.ZC(str2))) {
        Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        AppMethodBeat.o(31745);
        return localArrayList;
        if (str2.startsWith(b.bmL()))
        {
          Log.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.HIr = Util.getLong(str1, 0L);
          localg.Yki = Util.getLong(str4, 0L);
          if ((!Util.isNullOrNil(str3)) && (y.ZC(str3))) {
            localg.thumbPath = str3;
          }
          if ((!Util.isNullOrNil(str2)) && (y.ZC(str2))) {
            localg.Ykh = str2;
          }
          if ((Util.isNullOrNil(localg.Ykh)) && (Util.isNullOrNil(localg.Ykh))) {
            Log.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
          } else {
            localArrayList.add(localg);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract int getYFromBottom();
    
    public abstract boolean iMJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.h
 * JD-Core Version:    0.7.0.1
 */