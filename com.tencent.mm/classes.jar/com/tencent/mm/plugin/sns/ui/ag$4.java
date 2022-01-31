package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class ag$4
  implements Runnable
{
  ag$4(ag paramag) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.oSk.oSd.oSo.iterator();
    Exif localExif;
    int i;
    label73:
    String str2;
    int k;
    int j;
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      localExif = Exif.fromFile(str1);
      if ((localExif.latitude >= 0.0D) && (localExif.longitude >= 0.0D))
      {
        i = 1;
        str2 = localExif.model;
        k = localExif.imageWidth;
        j = localExif.imageHeight;
        if ((k > 0) && (j > 0)) {
          break label225;
        }
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str1, localOptions);
        k = localOptions.outWidth;
        j = localOptions.outHeight;
      }
    }
    label225:
    for (;;)
    {
      int m = (int)localExif.getUxtimeDatatimeOriginal();
      h.nFQ.f(15523, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
      break;
      i = 0;
      break label73;
      y.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - l));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.4
 * JD-Core Version:    0.7.0.1
 */