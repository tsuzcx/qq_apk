package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

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
  
  private com.tencent.mm.av.a.d.b aOl(String paramString)
  {
    AppMethodBeat.i(124383);
    ae.d("MicroMsg.ChattingBizImgDownloader", "getNormalImageData from url:%s", new Object[] { paramString });
    try
    {
      System.currentTimeMillis();
      h localh = h.FnG;
      paramString = h.a(paramString, true, new k(this.scene));
      if (paramString != null) {
        System.currentTimeMillis();
      }
      AppMethodBeat.o(124383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
      paramString = new com.tencent.mm.av.a.d.b(null, null, (byte)0);
      AppMethodBeat.o(124383);
    }
    return paramString;
  }
  
  private com.tencent.mm.av.a.d.b aOm(String paramString)
  {
    AppMethodBeat.i(124385);
    ae.i("MicroMsg.ChattingBizImgDownloader", "alvinluo tryToGetNormalImage after get WxPic failed");
    paramString = aOl(paramString);
    AppMethodBeat.o(124385);
    return paramString;
  }
  
  private void fgm()
  {
    AppMethodBeat.i(124384);
    Object localObject = g.FnF;
    if (g.Zu(this.scene))
    {
      localObject = f.FnD;
      f.vU(false);
    }
    AppMethodBeat.o(124384);
  }
  
  public final com.tencent.mm.av.a.d.b Gj(String paramString)
  {
    AppMethodBeat.i(124382);
    ae.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject1 = h.FnG;
        localObject1 = h.a(paramString, false, new k(this.scene));
        if (localObject1 != null)
        {
          l = System.currentTimeMillis() - l;
          localObject2 = ((com.tencent.mm.av.a.d.b)localObject1).contentType;
          int j = ((com.tencent.mm.av.a.d.b)localObject1).igM;
          if (((com.tencent.mm.av.a.d.b)localObject1).data != null)
          {
            i = ((com.tencent.mm.av.a.d.b)localObject1).data.length;
            ae.d("MicroMsg.ChattingBizImgDownloader", "alvinluo BizImage download responseContentType: %s, contentLength: %d, dataLength: %d, url: %s, download used %d ms", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(i), paramString, Long.valueOf(l) });
            localObject2 = g.FnF;
            localObject2 = ((com.tencent.mm.av.a.d.b)localObject1).contentType;
            p.h(paramString, "url");
            if ((com.tencent.mm.api.b.Kk()) && (g.aOi((String)localObject2)) && (com.tencent.mm.api.b.eC(paramString)))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              if (((com.tencent.mm.av.a.d.b)localObject1).data != null) {
                continue;
              }
              ae.e("MicroMsg.ChattingBizImgDownloader", "response.data is null");
              fgm();
              paramString = aOm(paramString);
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
          if ((((com.tencent.mm.av.a.d.b)localObject1).igM > 0) && (((com.tencent.mm.av.a.d.b)localObject1).igM != ((com.tencent.mm.av.a.d.b)localObject1).data.length))
          {
            fgm();
            paramString = aOm(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          MMBitmapFactory.decodeByteArray(((com.tencent.mm.av.a.d.b)localObject1).data, 0, ((com.tencent.mm.av.a.d.b)localObject1).data.length, (BitmapFactory.Options)localObject2);
          if ((((BitmapFactory.Options)localObject2).outHeight <= 0) || (((BitmapFactory.Options)localObject2).outWidth <= 0))
          {
            ae.e("MicroMsg.ChattingBizImgDownloader", "decode wxpic fail");
            localObject1 = ((com.tencent.mm.av.a.d.b)localObject1).contentType;
            localObject2 = g.FnF;
            if (g.Zu(this.scene))
            {
              localObject2 = f.FnD;
              f.cF((String)localObject1, false);
            }
            localObject2 = g.FnF;
            if (g.aOi((String)localObject1))
            {
              localObject1 = f.FnD;
              f.aJ(paramString, 1, this.scene);
            }
            paramString = aOm(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          paramString = g.FnF;
          if (g.Zu(this.scene))
          {
            paramString = f.FnD;
            f.vU(true);
          }
          ae.d("MicroMsg.ChattingBizImgDownloader", "decode wxpic success");
        }
        else
        {
          AppMethodBeat.o(124382);
          return localObject1;
        }
        Object localObject2 = g.FnF;
        boolean bool;
        if (g.lC(paramString, ((com.tencent.mm.av.a.d.b)localObject1).contentType))
        {
          bool = true;
          ae.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b, used %d ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 4L, l, false);
          if (bool) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 17L, l, false);
          }
        }
        else
        {
          bool = false;
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
        paramString = new com.tencent.mm.av.a.d.b(null, null, (byte)0);
        AppMethodBeat.o(124382);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.n
 * JD-Core Version:    0.7.0.1
 */