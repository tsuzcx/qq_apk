package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class l
{
  public static k.b a(String paramString, v paramv)
  {
    AppMethodBeat.i(34458);
    k.b localb = new k.b();
    localb.title = paramv.title;
    localb.description = paramv.hDo;
    localb.type = 33;
    localb.hCn = paramv.hDr;
    localb.hCm = paramv.hDs;
    localb.hCo = paramv.hDv;
    localb.hCz = paramv.hDu;
    localb.hCA = paramv.hDt;
    localb.hCq = "";
    localb.hCp = 2;
    localb.url = paramv.url;
    localb.hCB = paramv.hDx;
    localb.dHu = ("wxapp_" + paramv.hDv + paramv.hDs);
    localb.dHo = paramv.hDr;
    localb.dHp = paramv.hDy;
    paramv = new com.tencent.mm.ai.a();
    paramv.hxV = false;
    paramv.hxW = "";
    localb.a(paramv);
    if (bt.isNullOrNil(localb.thumburl))
    {
      paramString = p.aEx().Dj(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.aEq();
      }
    }
    AppMethodBeat.o(34458);
    return localb;
  }
  
  public static void b(String paramString1, k.b paramb, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(34457);
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[0];
        Object localObject1 = localObject2;
        if (!bt.isNullOrNil(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.aDV().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          ad.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (w.vF(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.hCo, paramb.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.g.yhR.f(14127, new Object[] { paramb.hCo, paramb.hCn, paramb.hCm, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
            AppMethodBeat.o(34457);
          }
        }
        else
        {
          ad.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        ad.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(34457);
        return;
      }
    }
  }
  
  public static boolean f(bu parambu, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (parambu == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!parambu.fpd())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    parambu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content).hDb;
    if (!bt.hj(parambu))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambu.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.ai.m.yt(((v)parambu.get(i)).hDr))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void hY(List<bu> paramList)
  {
    AppMethodBeat.i(34460);
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.gtP;
        if (!bt.hj((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bu)((Iterator)localObject1).next();
            if (((bu)localObject2).fpd())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(((ei)localObject2).field_msgId, ((ei)localObject2).field_content).hDb;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  v localv = (v)((Iterator)localObject2).next();
                  if ((!bt.isNullOrNil(localv.hDw)) && (com.tencent.mm.ai.m.yt(localv.hDr))) {
                    b.aDV().a(new l.2(localv), localv.hDw, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(112, 90));
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(34454);
      }
    }, "MicroMsg.ChattingEditModeSendToAppBrand$prepareAppBrandMsgToSend");
    AppMethodBeat.o(34460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */