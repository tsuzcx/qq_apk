package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class g
  extends l
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(24226);
    aca localaca = paramb.cuL;
    long l = paramb.pZy;
    boolean bool = paramb.cuO;
    int j = paramb.maxWidth;
    if (!com.tencent.mm.compatible.util.f.Mi()) {
      paramb = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839821);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localaca, l);
        ab.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        n.b(localaca, l, bool);
      }
      AppMethodBeat.o(24226);
      return paramb;
      str = n.c(localaca, l);
      if ((bo.isNullOrNil(str)) || (!e.cN(str)))
      {
        ab.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.FALSE, str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.myy.get(str);
        if (paramb != null)
        {
          ab.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
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
    ab.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      ab.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    ab.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
      m = BackwardSupportUtil.ExifHelper.bY(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = d.d(str, j, i, false);
        if (paramb == null)
        {
          ab.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          paramb = null;
          break;
        }
        paramb = d.b(paramb, m);
        this.myy.put(str, paramb);
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
    AppMethodBeat.i(24225);
    paramc = super.b(paramc.cuL, paramc.pZy);
    AppMethodBeat.o(24225);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(24224);
    ImageView localImageView = parama.cuM;
    aca localaca = parama.cuL;
    long l = parama.pZy;
    int i = parama.cuN;
    int j = parama.width;
    int k = parama.height;
    if (localImageView == null)
    {
      AppMethodBeat.o(24224);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      localImageView.setImageResource(2130839821);
      AppMethodBeat.o(24224);
      return;
    }
    if (localaca == null)
    {
      localImageView.setImageResource(i);
      AppMethodBeat.o(24224);
      return;
    }
    switch (localaca.dataType)
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
      ab.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localaca.dataType) });
      AppMethodBeat.o(24224);
      return;
    case 7: 
      super.a(localImageView, localaca, l, localaca.cpH, i, j, k);
      AppMethodBeat.o(24224);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localaca, l, localaca.cpH, i, j, k);
      AppMethodBeat.o(24224);
      return;
    case 5: 
      if (localaca.wTw != null)
      {
        parama = localaca.wTw.wUf;
        label278:
        if (parama != null) {
          break label345;
        }
        parama = localObject1;
        label285:
        if (!bo.isNullOrNil(parama)) {
          break label667;
        }
        parama = localaca.cpH;
      }
      break;
    }
    label656:
    label664:
    label667:
    for (;;)
    {
      super.a(localImageView, localaca, l, parama, i, j, k);
      AppMethodBeat.o(24224);
      return;
      ab.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localaca.mBq });
      parama = null;
      break label278;
      label345:
      parama = parama.thumbUrl;
      break label285;
      if (localaca.wTw == null)
      {
        ab.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localaca.mBq });
        AppMethodBeat.o(24224);
        return;
      }
      parama = localaca.wTw.wUh;
      if (parama == null) {
        break;
      }
      this.pYK.a(localImageView, null, parama.thumbUrl, i, j, k);
      AppMethodBeat.o(24224);
      return;
      if (localaca.wTw == null)
      {
        ab.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localaca.mBq });
        AppMethodBeat.o(24224);
        return;
      }
      parama = localaca.wTw.wUj;
      if (parama == null) {
        break;
      }
      this.pYK.a(localImageView, null, parama.thumbUrl, i, j, k);
      AppMethodBeat.o(24224);
      return;
      if (localaca.wTw == null)
      {
        ab.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localaca.mBq });
        AppMethodBeat.o(24224);
        return;
      }
      parama = localaca.wTw.wUh;
      if (parama == null) {
        break;
      }
      this.pYK.a(localImageView, null, parama.thumbUrl, i, j, k);
      AppMethodBeat.o(24224);
      return;
      if (localaca.wTw != null)
      {
        parama = localaca.wTw.wUs;
        if (parama != null) {
          break label656;
        }
        parama = localObject2;
        label596:
        if (!bo.isNullOrNil(parama)) {
          break label664;
        }
        parama = localaca.cpH;
      }
      for (;;)
      {
        super.a(localImageView, localaca, l, parama, i, j, k);
        AppMethodBeat.o(24224);
        return;
        ab.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localaca.mBq });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label596;
      }
    }
  }
  
  public final void cfT()
  {
    AppMethodBeat.i(24227);
    super.destory();
    AppMethodBeat.o(24227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */