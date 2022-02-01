package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  implements c
{
  private int scene;
  
  public n()
  {
    this(0);
  }
  
  public n(int paramInt)
  {
    this.scene = paramInt;
  }
  
  private com.tencent.mm.aw.a.d.b aBU(String paramString)
  {
    AppMethodBeat.i(124383);
    ad.d("MicroMsg.ChattingBizImgDownloader", "getNormalImageData from url:%s", new Object[] { paramString });
    try
    {
      System.currentTimeMillis();
      h localh = h.BXR;
      paramString = h.a(paramString, true, new k(this.scene));
      if (paramString != null) {
        System.currentTimeMillis();
      }
      AppMethodBeat.o(124383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
      paramString = new com.tencent.mm.aw.a.d.b(null, null, (byte)0);
      AppMethodBeat.o(124383);
    }
    return paramString;
  }
  
  private com.tencent.mm.aw.a.d.b aBV(String paramString)
  {
    AppMethodBeat.i(124385);
    ad.i("MicroMsg.ChattingBizImgDownloader", "alvinluo tryToGetNormalImage after get WxPic failed");
    paramString = aBU(paramString);
    AppMethodBeat.o(124385);
    return paramString;
  }
  
  private void eyf()
  {
    AppMethodBeat.i(124384);
    Object localObject = g.BXQ;
    if (g.UI(this.scene))
    {
      localObject = f.BXO;
      f.ua(false);
    }
    AppMethodBeat.o(124384);
  }
  
  public final com.tencent.mm.aw.a.d.b yy(String paramString)
  {
    AppMethodBeat.i(124382);
    ad.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject1 = h.BXR;
        localObject1 = h.a(paramString, false, new k(this.scene));
        if (localObject1 != null)
        {
          l = System.currentTimeMillis() - l;
          localObject2 = ((com.tencent.mm.aw.a.d.b)localObject1).bxn;
          int j = ((com.tencent.mm.aw.a.d.b)localObject1).hkw;
          if (((com.tencent.mm.aw.a.d.b)localObject1).data != null)
          {
            i = ((com.tencent.mm.aw.a.d.b)localObject1).data.length;
            ad.d("MicroMsg.ChattingBizImgDownloader", "alvinluo BizImage download responseContentType: %s, contentLength: %d, dataLength: %d, url: %s, download used %d ms", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(i), paramString, Long.valueOf(l) });
            localObject2 = g.BXQ;
            localObject2 = ((com.tencent.mm.aw.a.d.b)localObject1).bxn;
            d.g.b.k.h(paramString, "url");
            if ((com.tencent.mm.api.b.IT()) && (g.aBR((String)localObject2)) && (com.tencent.mm.api.b.dM(paramString)))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              if (((com.tencent.mm.aw.a.d.b)localObject1).data != null) {
                continue;
              }
              ad.e("MicroMsg.ChattingBizImgDownloader", "response.data is null");
              eyf();
              paramString = aBV(paramString);
              AppMethodBeat.o(124382);
              return paramString;
            }
          }
          else
          {
            i = -1;
            continue;
          }
          int i = 0;
          continue;
          if ((((com.tencent.mm.aw.a.d.b)localObject1).hkw > 0) && (((com.tencent.mm.aw.a.d.b)localObject1).hkw != ((com.tencent.mm.aw.a.d.b)localObject1).data.length))
          {
            eyf();
            paramString = aBV(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          MMBitmapFactory.decodeByteArray(((com.tencent.mm.aw.a.d.b)localObject1).data, 0, ((com.tencent.mm.aw.a.d.b)localObject1).data.length, (BitmapFactory.Options)localObject2);
          if ((((BitmapFactory.Options)localObject2).outHeight <= 0) || (((BitmapFactory.Options)localObject2).outWidth <= 0))
          {
            ad.e("MicroMsg.ChattingBizImgDownloader", "decode wxpic fail");
            localObject1 = ((com.tencent.mm.aw.a.d.b)localObject1).bxn;
            localObject2 = g.BXQ;
            if (g.UI(this.scene))
            {
              localObject2 = f.BXO;
              f.cq((String)localObject1, false);
            }
            localObject2 = g.BXQ;
            if (g.aBR((String)localObject1))
            {
              localObject1 = f.BXO;
              f.aA(paramString, 1, this.scene);
            }
            paramString = aBV(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          paramString = g.BXQ;
          if (g.UI(this.scene))
          {
            paramString = f.BXO;
            f.ua(true);
          }
          ad.d("MicroMsg.ChattingBizImgDownloader", "decode wxpic success");
        }
        else
        {
          AppMethodBeat.o(124382);
          return localObject1;
        }
        Object localObject2 = g.BXQ;
        boolean bool;
        if (g.kB(paramString, ((com.tencent.mm.aw.a.d.b)localObject1).bxn))
        {
          bool = true;
          ad.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b, used %d ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 4L, l, false);
          if (bool) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 17L, l, false);
          }
        }
        else
        {
          bool = false;
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
        paramString = new com.tencent.mm.aw.a.d.b(null, null, (byte)0);
        AppMethodBeat.o(124382);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.n
 * JD-Core Version:    0.7.0.1
 */