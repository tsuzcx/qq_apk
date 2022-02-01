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
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public final class g
  extends n
  implements h.a
{
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27867);
    aml localaml = paramb.dKT;
    long l = paramb.BHU;
    boolean bool = paramb.dKW;
    int j = paramb.maxWidth;
    if (!e.apn()) {
      paramb = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    }
    String str;
    for (;;)
    {
      if ((paramb == null) && (!bool))
      {
        bool = super.a(localaml, l);
        Log.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          p.b(localaml, l, bool);
        }
      }
      AppMethodBeat.o(27867);
      return paramb;
      str = p.c(localaml, l);
      if ((Util.isNullOrNil(str)) || (!s.YS(str)))
      {
        Log.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[] { Boolean.FALSE, str });
        paramb = null;
      }
      else
      {
        paramb = (Bitmap)this.tgj.get(str);
        if (paramb != null)
        {
          Log.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[] { str });
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
    Log.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[] { str });
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(str, paramb);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i = paramb.outHeight;
    int m = paramb.outWidth;
    Log.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
      m = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        paramb = BitmapUtil.extractThumbNail(str, j, i, false);
        if (paramb == null)
        {
          Log.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
          paramb = null;
          break;
        }
        paramb = BitmapUtil.rotate(paramb, m);
        this.tgj.put(str, paramb);
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
    paramc = super.b(paramc.dKT, paramc.BHU);
    AppMethodBeat.o(27866);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(27865);
    ImageView localImageView = parama.dKU;
    aml localaml = parama.dKT;
    long l = parama.BHU;
    int j = parama.dKV;
    int k = parama.width;
    int m = parama.height;
    if (localImageView == null)
    {
      AppMethodBeat.o(27865);
      return;
    }
    if (!e.apn())
    {
      localImageView.setImageResource(2131234279);
      AppMethodBeat.o(27865);
      return;
    }
    if (localaml == null)
    {
      localImageView.setImageResource(j);
      AppMethodBeat.o(27865);
      return;
    }
    int i;
    switch (localaml.dataType)
    {
    default: 
      Log.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[] { Integer.valueOf(localaml.dataType) });
      AppMethodBeat.o(27865);
      return;
    case 7: 
    case 29: 
      super.a(localImageView, localaml, l, localaml.dFN, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 4: 
    case 15: 
      super.a(localImageView, localaml, l, localaml.dFN, j, k, m);
      AppMethodBeat.o(27865);
      return;
    case 5: 
      if (localaml.Lwh != null)
      {
        parama = localaml.Lwh.LwS;
        localObject = localaml.Lwh.IXu;
        if ((localObject != null) && (((amt)localObject).iwc == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
        {
          i = 1;
          label331:
          if (parama != null) {
            break label420;
          }
          parama = null;
          label337:
          if (!Util.isNullOrNil(parama)) {
            break label887;
          }
          parama = localaml.dFN;
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
        localObject = com.tencent.mm.api.b.u(parama, 4);
      }
      super.a(localImageView, localaml, l, (String)localObject, j, k, m);
      AppMethodBeat.o(27865);
      return;
      i = 0;
      break label331;
      Log.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[] { localaml.dLl });
      i = 0;
      parama = null;
      break label331;
      parama = parama.thumbUrl;
      break label337;
      if ((localaml.Lwh != null) && (localaml.Lwh.Lxk != null) && (!Util.isNullOrNil(localaml.Lwh.Lxk.mediaList)) && (!Util.isNullOrNil(((bch)localaml.Lwh.Lxk.mediaList.getFirst()).thumbUrl)))
      {
        this.BGZ.a(localImageView, null, ((bch)localaml.Lwh.Lxk.mediaList.getFirst()).thumbUrl, j, k, m);
        AppMethodBeat.o(27865);
        return;
      }
      localImageView.setImageDrawable(ar.m(localImageView.getContext(), 2131690801, localImageView.getContext().getResources().getColor(2131099792)));
      AppMethodBeat.o(27865);
      return;
      if (localaml.Lwh == null)
      {
        Log.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[] { localaml.dLl });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localaml.Lwh.LwU;
      if (parama == null) {
        break;
      }
      this.BGZ.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localaml.Lwh == null)
      {
        Log.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[] { localaml.dLl });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localaml.Lwh.LwW;
      if (parama == null) {
        break;
      }
      this.BGZ.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localaml.Lwh == null)
      {
        Log.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[] { localaml.dLl });
        AppMethodBeat.o(27865);
        return;
      }
      parama = localaml.Lwh.LwU;
      if (parama == null) {
        break;
      }
      this.BGZ.a(localImageView, null, parama.thumbUrl, j, k, m);
      AppMethodBeat.o(27865);
      return;
      if (localaml.Lwh != null)
      {
        parama = localaml.Lwh.Lxf;
        if (parama != null) {
          break label876;
        }
        parama = (h.a.a)localObject;
        if (!Util.isNullOrNil(parama)) {
          break label884;
        }
        parama = localaml.dFN;
      }
      for (;;)
      {
        super.a(localImageView, localaml, l, parama, j, k, m);
        AppMethodBeat.o(27865);
        return;
        Log.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[] { localaml.dLl });
        parama = null;
        break;
        parama = parama.iconUrl;
        break label815;
      }
    }
  }
  
  public final void eIr()
  {
    AppMethodBeat.i(27868);
    super.destory();
    AppMethodBeat.o(27868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.g
 * JD-Core Version:    0.7.0.1
 */