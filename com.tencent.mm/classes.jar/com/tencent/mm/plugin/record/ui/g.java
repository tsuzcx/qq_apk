package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends com.tencent.mm.plugin.record.b.f
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    xv localxv = paramb.bNt;
    long l = paramb.ntR;
    boolean bool = paramb.bNw;
    int j = paramb.maxWidth;
    if (!com.tencent.mm.compatible.util.f.zF()) {
      paramb = BitmapFactory.decodeResource(ae.getContext().getResources(), R.g.nosdcard_chatting_bg);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localxv, l);
        y.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        h.b(localxv, l, bool);
      }
      return paramb;
      str = h.c(localxv, l);
      if ((bk.bl(str)) || (!e.bK(str)))
      {
        y.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.valueOf(false), str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.kdO.get(str);
        if (paramb != null)
        {
          y.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
        }
        else
        {
          if (!bool) {
            break;
          }
          paramb = null;
        }
      }
    }
    y.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      y.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    y.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
    int k = m;
    if (m > j)
    {
      i = paramb.outHeight * j / paramb.outWidth;
      k = j;
    }
    k = Math.max(1, k);
    i = Math.max(1, i);
    if (k > j) {
      i = paramb.outHeight * j / paramb.outWidth;
    }
    for (;;)
    {
      m = BackwardSupportUtil.ExifHelper.YS(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = c.e(str, j, i, false);
        if (paramb == null)
        {
          y.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + str);
          paramb = null;
          break;
        }
        paramb = c.b(paramb, m);
        this.kdO.put(str, paramb);
        break;
        k = j;
        j = i;
        i = k;
      }
      j = k;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    return super.b(paramc.bNt, paramc.ntR);
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    ImageView localImageView = parama.bNu;
    xv localxv = parama.bNt;
    long l = parama.ntR;
    int i = parama.bNv;
    int j = parama.width;
    int k = parama.height;
    if (localImageView == null) {
      return;
    }
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      localImageView.setImageResource(R.g.nosdcard_chatting_bg);
      return;
    }
    if (localxv == null)
    {
      localImageView.setImageResource(i);
      return;
    }
    switch (localxv.aYU)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    default: 
      y.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localxv.aYU) });
      return;
    case 7: 
      super.a(localImageView, localxv, l, localxv.bIm, i, j, k);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localxv, l, localxv.bIm, i, j, k);
      return;
    case 5: 
      if (localxv.sVA != null)
      {
        parama = localxv.sVA.sWh;
        label236:
        if (parama != null) {
          break label296;
        }
        parama = localObject1;
        label243:
        if (!bk.bl(parama)) {
          break label576;
        }
        parama = localxv.bIm;
      }
      break;
    }
    label296:
    label565:
    label573:
    label576:
    for (;;)
    {
      super.a(localImageView, localxv, l, parama, i, j, k);
      return;
      y.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localxv.kgC });
      parama = null;
      break label236;
      parama = parama.thumbUrl;
      break label243;
      if (localxv.sVA == null)
      {
        y.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localxv.kgC });
        return;
      }
      parama = localxv.sVA.sWj;
      if (parama == null) {
        break;
      }
      this.nte.a(localImageView, null, parama.thumbUrl, i, j, k);
      return;
      if (localxv.sVA == null)
      {
        y.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localxv.kgC });
        return;
      }
      parama = localxv.sVA.sWl;
      if (parama == null) {
        break;
      }
      this.nte.a(localImageView, null, parama.thumbUrl, i, j, k);
      return;
      if (localxv.sVA == null)
      {
        y.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localxv.kgC });
        return;
      }
      parama = localxv.sVA.sWj;
      if (parama == null) {
        break;
      }
      this.nte.a(localImageView, null, parama.thumbUrl, i, j, k);
      return;
      if (localxv.sVA != null)
      {
        parama = localxv.sVA.sWu;
        if (parama != null) {
          break label565;
        }
        parama = localObject2;
        label511:
        if (!bk.bl(parama)) {
          break label573;
        }
        parama = localxv.bIm;
      }
      for (;;)
      {
        super.a(localImageView, localxv, l, parama, i, j, k);
        return;
        y.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localxv.kgC });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label511;
      }
    }
  }
  
  public final void bvC()
  {
    super.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */