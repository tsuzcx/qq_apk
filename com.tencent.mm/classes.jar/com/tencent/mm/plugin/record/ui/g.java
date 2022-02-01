package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public final class g
  extends n
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    ajx localajx = paramb.dtI;
    long l = paramb.xHT;
    boolean bool = paramb.dtL;
    int j = paramb.maxWidth;
    if (!e.abo()) {
      paramb = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localajx, l);
        ae.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          p.b(localajx, l, bool);
        }
      }
      AppMethodBeat.o(27867);
      return paramb;
      str = p.c(localajx, l);
      if ((bu.isNullOrNil(str)) || (!o.fB(str)))
      {
        ae.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.FALSE, str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.rGD.get(str);
        if (paramb != null)
        {
          ae.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
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
    ae.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      ae.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    ae.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
      m = BackwardSupportUtil.ExifHelper.df(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = h.d(str, j, i, false);
        if (paramb == null)
        {
          ae.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          paramb = null;
          break;
        }
        paramb = h.a(paramb, m);
        this.rGD.put(str, paramb);
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
    AppMethodBeat.i(27866);
    paramc = super.b(paramc.dtI, paramc.xHT);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(27865);
    ImageView localImageView = parama.dtJ;
    ajx localajx = parama.dtI;
    long l = parama.xHT;
    int j = parama.dtK;
    int k = parama.width;
    int m = parama.height;
    if (localImageView == null)
    {
      AppMethodBeat.o(27865);
      return;
    }
    if (!e.abo())
    {
      localImageView.setImageResource(2131233476);
      AppMethodBeat.o(27865);
      return;
    }
    if (localajx == null)
    {
      localImageView.setImageResource(j);
      AppMethodBeat.o(27865);
      return;
    }
    int i;
    switch (localajx.dataType)
    {
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    default: 
      ae.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localajx.dataType) });
      AppMethodBeat.o(27865);
      return;
    case 7: 
      super.a(localImageView, localajx, l, localajx.dox, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localajx, l, localajx.dox, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 5: 
      if (localajx.GAu != null)
      {
        parama = localajx.GAu.GBf;
        localObject = localajx.GAu.Ekw;
        if ((localObject != null) && (((akf)localObject).hBV == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
        {
          i = 1;
          label331:
          if (parama != null) {
            break label420;
          }
          parama = null;
          label337:
          if (!bu.isNullOrNil(parama)) {
            break label887;
          }
          parama = localajx.dox;
        }
      }
      break;
    }
    label420:
    label815:
    label876:
    label884:
    label887:
    for (;;)
    {
      localObject = parama;
      if (i != 0) {
        localObject = com.tencent.mm.api.b.t(parama, 4);
      }
      super.a(localImageView, localajx, l, (String)localObject, j, k, m);
      AppMethodBeat.o(27865);
      return;
      i = 0;
      break label331;
      ae.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localajx.dua });
      i = 0;
      parama = null;
      break label331;
      parama = parama.thumbUrl;
      break label337;
      if ((localajx.GAu != null) && (localajx.GAu.GBx != null) && (!bu.ht(localajx.GAu.GBx.mediaList)) && (!bu.isNullOrNil(((arx)localajx.GAu.GBx.mediaList.getFirst()).thumbUrl)))
      {
        this.xHa.a(localImageView, null, ((arx)localajx.GAu.GBx.mediaList.getFirst()).thumbUrl, j, k, m);
        AppMethodBeat.o(27865);
        return;
      }
      localImageView.setImageDrawable(ao.k(localImageView.getContext(), 2131690572, localImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(27865);
      return;
      if (localajx.GAu == null)
      {
        ae.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localajx.dua });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localajx.GAu.GBh;
      if (parama == null) {
        break;
      }
      this.xHa.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localajx.GAu == null)
      {
        ae.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localajx.dua });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localajx.GAu.GBj;
      if (parama == null) {
        break;
      }
      this.xHa.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localajx.GAu == null)
      {
        ae.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localajx.dua });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localajx.GAu.GBh;
      if (parama == null) {
        break;
      }
      this.xHa.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localajx.GAu != null)
      {
        parama = localajx.GAu.GBs;
        if (parama != null) {
          break label876;
        }
        parama = (h.a.a)localObject;
        if (!bu.isNullOrNil(parama)) {
          break label884;
        }
        parama = localajx.dox;
      }
      for (;;)
      {
        super.a(localImageView, localajx, l, parama, j, k, m);
        AppMethodBeat.o(27865);
        return;
        ae.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localajx.dua });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label815;
      }
    }
  }
  
  public final void dHE()
  {
    AppMethodBeat.i(27868);
    super.destory();
    AppMethodBeat.o(27868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */