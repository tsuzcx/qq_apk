package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;

public final class h
{
  private ContentResolver gGN;
  protected Context mContext;
  
  protected h(Context paramContext)
  {
    AppMethodBeat.i(31743);
    this.mContext = paramContext;
    this.gGN = this.mContext.getContentResolver();
    AppMethodBeat.o(31743);
  }
  
  private String aNb(String paramString)
  {
    AppMethodBeat.i(31744);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      AppMethodBeat.o(31744);
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.gGN.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(31744);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
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
  
  public final ArrayList<g> feu()
  {
    AppMethodBeat.i(31745);
    ArrayList localArrayList = new ArrayList();
    long l = bt.flT() / 1000L;
    Cursor localCursor;
    try
    {
      ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "query excludeImageWithFeatureDate");
      localCursor = this.gGN.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, "date_added <= ?", new String[] { String.valueOf(l) }, "date_added desc limit 1");
      if (localCursor == null)
      {
        AppMethodBeat.o(31745);
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      if (0 != 0) {
        throw new NullPointerException();
      }
      AppMethodBeat.o(31745);
      return null;
    }
    if (localCursor.moveToFirst()) {}
    for (;;)
    {
      String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_id"));
      String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      String str3 = localCursor.getString(localCursor.getColumnIndexOrThrow("date_added"));
      String str4 = aNb(str2);
      if ((bt.isNullOrNil(str1)) || (!i.fv(str1))) {
        ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!localCursor.moveToNext())
      {
        localCursor.close();
        AppMethodBeat.o(31745);
        return localException;
        if (str1.startsWith(b.asg()))
        {
          ad.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.tHA = bt.getLong(str2, 0L);
          localg.FdM = bt.getLong(str3, 0L);
          if ((!bt.isNullOrNil(str4)) && (i.fv(str4))) {
            localg.thumbPath = str4;
          }
          if ((!bt.isNullOrNil(str1)) && (i.fv(str1))) {
            localg.FdL = str1;
          }
          if ((bt.isNullOrNil(localg.FdL)) && (bt.isNullOrNil(localg.FdL))) {
            ad.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
          } else {
            localException.add(localg);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean fdU();
    
    public abstract int getYFromBottom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.h
 * JD-Core Version:    0.7.0.1
 */