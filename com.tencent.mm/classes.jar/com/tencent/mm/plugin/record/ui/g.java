package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import java.util.LinkedList;

public final class g
  extends l
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    afy localafy = paramb.djJ;
    long l = paramb.vbr;
    boolean bool = paramb.djM;
    int j = paramb.maxWidth;
    if (!e.XG()) {
      paramb = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localafy, l);
        ad.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          n.b(localafy, l, bool);
        }
      }
      AppMethodBeat.o(27867);
      return paramb;
      str = n.c(localafy, l);
      if ((bt.isNullOrNil(str)) || (!com.tencent.mm.vfs.i.eK(str)))
      {
        ad.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.FALSE, str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.qfR.get(str);
        if (paramb != null)
        {
          ad.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
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
    ad.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    ad.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
      m = BackwardSupportUtil.ExifHelper.co(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = com.tencent.mm.sdk.platformtools.f.e(str, j, i, false);
        if (paramb == null)
        {
          ad.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          paramb = null;
          break;
        }
        paramb = com.tencent.mm.sdk.platformtools.f.a(paramb, m);
        this.qfR.put(str, paramb);
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
    paramc = super.b(paramc.djJ, paramc.vbr);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(27865);
    ImageView localImageView = parama.djK;
    afy localafy = parama.djJ;
    long l = parama.vbr;
    int j = parama.djL;
    int k = parama.width;
    int m = parama.height;
    if (localImageView == null)
    {
      AppMethodBeat.o(27865);
      return;
    }
    if (!e.XG())
    {
      localImageView.setImageResource(2131233476);
      AppMethodBeat.o(27865);
      return;
    }
    if (localafy == null)
    {
      localImageView.setImageResource(j);
      AppMethodBeat.o(27865);
      return;
    }
    int i;
    switch (localafy.dataType)
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
      ad.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localafy.dataType) });
      AppMethodBeat.o(27865);
      return;
    case 7: 
      super.a(localImageView, localafy, l, localafy.deE, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localafy, l, localafy.deE, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 5: 
      if (localafy.DgT != null)
      {
        parama = localafy.DgT.DhE;
        localObject = localafy.DgT.AWL;
        if ((localObject != null) && (((agg)localObject).gGx == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()))
        {
          i = 1;
          label331:
          if (parama != null) {
            break label420;
          }
          parama = null;
          label337:
          if (!bt.isNullOrNil(parama)) {
            break label887;
          }
          parama = localafy.deE;
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
        localObject = com.tencent.mm.api.b.q(parama, 4);
      }
      super.a(localImageView, localafy, l, (String)localObject, j, k, m);
      AppMethodBeat.o(27865);
      return;
      i = 0;
      break label331;
      ad.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localafy.dkb });
      i = 0;
      parama = null;
      break label331;
      parama = parama.thumbUrl;
      break label337;
      if ((localafy.DgT != null) && (localafy.DgT.DhW != null) && (!bt.gL(localafy.DgT.DhW.mediaList)) && (!bt.isNullOrNil(((alc)localafy.DgT.DhW.mediaList.getFirst()).thumbUrl)))
      {
        this.vaD.a(localImageView, null, ((alc)localafy.DgT.DhW.mediaList.getFirst()).thumbUrl, j, k, m);
        AppMethodBeat.o(27865);
        return;
      }
      localImageView.setImageDrawable(am.i(localImageView.getContext(), 2131690572, localImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(27865);
      return;
      if (localafy.DgT == null)
      {
        ad.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localafy.dkb });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localafy.DgT.DhG;
      if (parama == null) {
        break;
      }
      this.vaD.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localafy.DgT == null)
      {
        ad.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localafy.dkb });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localafy.DgT.DhI;
      if (parama == null) {
        break;
      }
      this.vaD.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localafy.DgT == null)
      {
        ad.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localafy.dkb });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localafy.DgT.DhG;
      if (parama == null) {
        break;
      }
      this.vaD.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localafy.DgT != null)
      {
        parama = localafy.DgT.DhR;
        if (parama != null) {
          break label876;
        }
        parama = (h.a.a)localObject;
        if (!bt.isNullOrNil(parama)) {
          break label884;
        }
        parama = localafy.deE;
      }
      for (;;)
      {
        super.a(localImageView, localafy, l, parama, j, k, m);
        AppMethodBeat.o(27865);
        return;
        ad.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localafy.dkb });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label815;
      }
    }
  }
  
  public final void dgj()
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