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
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import java.util.LinkedList;

public final class g
  extends l
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    agx localagx = paramb.dhe;
    long l = paramb.wkf;
    boolean bool = paramb.dhh;
    int j = paramb.maxWidth;
    if (!e.YD()) {
      paramb = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131233476);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localagx, l);
        ac.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          n.b(localagx, l, bool);
        }
      }
      AppMethodBeat.o(27867);
      return paramb;
      str = n.c(localagx, l);
      if ((bs.isNullOrNil(str)) || (!com.tencent.mm.vfs.i.eA(str)))
      {
        ac.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.FALSE, str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.qOt.get(str);
        if (paramb != null)
        {
          ac.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
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
    ac.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      ac.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    ac.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
      m = BackwardSupportUtil.ExifHelper.ce(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = com.tencent.mm.sdk.platformtools.f.e(str, j, i, false);
        if (paramb == null)
        {
          ac.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          paramb = null;
          break;
        }
        paramb = com.tencent.mm.sdk.platformtools.f.a(paramb, m);
        this.qOt.put(str, paramb);
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
    paramc = super.b(paramc.dhe, paramc.wkf);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(27865);
    ImageView localImageView = parama.dhf;
    agx localagx = parama.dhe;
    long l = parama.wkf;
    int j = parama.dhg;
    int k = parama.width;
    int m = parama.height;
    if (localImageView == null)
    {
      AppMethodBeat.o(27865);
      return;
    }
    if (!e.YD())
    {
      localImageView.setImageResource(2131233476);
      AppMethodBeat.o(27865);
      return;
    }
    if (localagx == null)
    {
      localImageView.setImageResource(j);
      AppMethodBeat.o(27865);
      return;
    }
    int i;
    switch (localagx.dataType)
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
      ac.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localagx.dataType) });
      AppMethodBeat.o(27865);
      return;
    case 7: 
      super.a(localImageView, localagx, l, localagx.dbZ, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localagx, l, localagx.dbZ, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 5: 
      if (localagx.EzZ != null)
      {
        parama = localagx.EzZ.EAK;
        localObject = localagx.EzZ.CoY;
        if ((localObject != null) && (((ahf)localObject).hgY == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
        {
          i = 1;
          label331:
          if (parama != null) {
            break label420;
          }
          parama = null;
          label337:
          if (!bs.isNullOrNil(parama)) {
            break label887;
          }
          parama = localagx.dbZ;
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
      super.a(localImageView, localagx, l, (String)localObject, j, k, m);
      AppMethodBeat.o(27865);
      return;
      i = 0;
      break label331;
      ac.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localagx.dhw });
      i = 0;
      parama = null;
      break label331;
      parama = parama.thumbUrl;
      break label337;
      if ((localagx.EzZ != null) && (localagx.EzZ.EBc != null) && (!bs.gY(localagx.EzZ.EBc.mediaList)) && (!bs.isNullOrNil(((anw)localagx.EzZ.EBc.mediaList.getFirst()).thumbUrl)))
      {
        this.wjr.a(localImageView, null, ((anw)localagx.EzZ.EBc.mediaList.getFirst()).thumbUrl, j, k, m);
        AppMethodBeat.o(27865);
        return;
      }
      localImageView.setImageDrawable(am.k(localImageView.getContext(), 2131690572, localImageView.getContext().getResources().getColor(2131099777)));
      AppMethodBeat.o(27865);
      return;
      if (localagx.EzZ == null)
      {
        ac.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localagx.dhw });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localagx.EzZ.EAM;
      if (parama == null) {
        break;
      }
      this.wjr.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localagx.EzZ == null)
      {
        ac.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localagx.dhw });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localagx.EzZ.EAO;
      if (parama == null) {
        break;
      }
      this.wjr.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localagx.EzZ == null)
      {
        ac.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localagx.dhw });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localagx.EzZ.EAM;
      if (parama == null) {
        break;
      }
      this.wjr.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localagx.EzZ != null)
      {
        parama = localagx.EzZ.EAX;
        if (parama != null) {
          break label876;
        }
        parama = (h.a.a)localObject;
        if (!bs.isNullOrNil(parama)) {
          break label884;
        }
        parama = localagx.dbZ;
      }
      for (;;)
      {
        super.a(localImageView, localagx, l, parama, j, k, m);
        AppMethodBeat.o(27865);
        return;
        ac.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localagx.dhw });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label815;
      }
    }
  }
  
  public final void dtQ()
  {
    AppMethodBeat.i(27868);
    super.destory();
    AppMethodBeat.o(27868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */