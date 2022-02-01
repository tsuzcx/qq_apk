package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelimage.loader.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.s;

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
  
  private com.tencent.mm.modelimage.loader.c.b bqX(String paramString)
  {
    AppMethodBeat.i(124383);
    Log.d("MicroMsg.ChattingBizImgDownloader", "getNormalImageData from url:%s", new Object[] { paramString });
    try
    {
      System.currentTimeMillis();
      h localh = h.Ybr;
      paramString = h.a(paramString, true, new k(this.scene));
      if (paramString != null) {
        System.currentTimeMillis();
      }
      AppMethodBeat.o(124383);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
      paramString = new com.tencent.mm.modelimage.loader.c.b(null, null, (byte)0);
      AppMethodBeat.o(124383);
    }
    return paramString;
  }
  
  private com.tencent.mm.modelimage.loader.c.b bqY(String paramString)
  {
    AppMethodBeat.i(124385);
    Log.i("MicroMsg.ChattingBizImgDownloader", "alvinluo tryToGetNormalImage after get WxPic failed");
    paramString = bqX(paramString);
    AppMethodBeat.o(124385);
    return paramString;
  }
  
  private void iLl()
  {
    AppMethodBeat.i(124384);
    Object localObject = g.Ybp;
    if (g.awl(this.scene))
    {
      localObject = f.Ybo;
      f.JG(false);
    }
    AppMethodBeat.o(124384);
  }
  
  public final com.tencent.mm.modelimage.loader.c.b Os(String paramString)
  {
    AppMethodBeat.i(124382);
    Log.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject1 = h.Ybr;
        localObject1 = h.a(paramString, false, new k(this.scene));
        if (localObject1 != null)
        {
          l = System.currentTimeMillis() - l;
          localObject2 = ((com.tencent.mm.modelimage.loader.c.b)localObject1).contentType;
          int j = ((com.tencent.mm.modelimage.loader.c.b)localObject1).oKT;
          if (((com.tencent.mm.modelimage.loader.c.b)localObject1).data != null)
          {
            i = ((com.tencent.mm.modelimage.loader.c.b)localObject1).data.length;
            Log.d("MicroMsg.ChattingBizImgDownloader", "alvinluo BizImage download responseContentType: %s, contentLength: %d, dataLength: %d, url: %s, download used %d ms", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(i), paramString, Long.valueOf(l) });
            localObject2 = g.Ybp;
            localObject2 = ((com.tencent.mm.modelimage.loader.c.b)localObject1).contentType;
            s.u(paramString, "url");
            if ((com.tencent.mm.api.b.aAF()) && (g.bqU((String)localObject2)) && (com.tencent.mm.api.b.hC(paramString)))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              if (((com.tencent.mm.modelimage.loader.c.b)localObject1).data != null) {
                continue;
              }
              Log.e("MicroMsg.ChattingBizImgDownloader", "response.data is null");
              iLl();
              paramString = bqY(paramString);
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
          if ((((com.tencent.mm.modelimage.loader.c.b)localObject1).oKT > 0) && (((com.tencent.mm.modelimage.loader.c.b)localObject1).oKT != ((com.tencent.mm.modelimage.loader.c.b)localObject1).data.length))
          {
            iLl();
            paramString = bqY(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          MMBitmapFactory.decodeByteArray(((com.tencent.mm.modelimage.loader.c.b)localObject1).data, 0, ((com.tencent.mm.modelimage.loader.c.b)localObject1).data.length, (BitmapFactory.Options)localObject2);
          if ((((BitmapFactory.Options)localObject2).outHeight <= 0) || (((BitmapFactory.Options)localObject2).outWidth <= 0))
          {
            Log.e("MicroMsg.ChattingBizImgDownloader", "decode wxpic fail");
            localObject1 = ((com.tencent.mm.modelimage.loader.c.b)localObject1).contentType;
            localObject2 = g.Ybp;
            if (g.awl(this.scene))
            {
              localObject2 = f.Ybo;
              f.dX((String)localObject1, false);
            }
            localObject2 = g.Ybp;
            if (g.bqU((String)localObject1))
            {
              localObject1 = f.Ybo;
              f.aV(paramString, 1, this.scene);
            }
            paramString = bqY(paramString);
            AppMethodBeat.o(124382);
            return paramString;
          }
          paramString = g.Ybp;
          if (g.awl(this.scene))
          {
            paramString = f.Ybo;
            f.JG(true);
          }
          Log.d("MicroMsg.ChattingBizImgDownloader", "decode wxpic success");
        }
        else
        {
          AppMethodBeat.o(124382);
          return localObject1;
        }
        Object localObject2 = g.Ybp;
        boolean bool;
        if (g.pl(paramString, ((com.tencent.mm.modelimage.loader.c.b)localObject1).contentType))
        {
          bool = true;
          Log.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b, used %d ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 4L, l, false);
          if (bool) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 17L, l, false);
          }
        }
        else
        {
          bool = false;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
        paramString = new com.tencent.mm.modelimage.loader.c.b(null, null, (byte)0);
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