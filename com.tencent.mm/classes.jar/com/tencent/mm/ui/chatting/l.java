package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
    localb.description = paramv.gKF;
    localb.type = 33;
    localb.gJE = paramv.gKI;
    localb.gJD = paramv.gKJ;
    localb.gJF = paramv.gKM;
    localb.gJQ = paramv.gKL;
    localb.gJR = paramv.gKK;
    localb.gJH = "";
    localb.gJG = 2;
    localb.url = paramv.url;
    localb.gJS = paramv.gKO;
    localb.dxF = ("wxapp_" + paramv.gKM + paramv.gKJ);
    localb.dxz = paramv.gKI;
    localb.dxA = paramv.gKP;
    paramv = new com.tencent.mm.ai.a();
    paramv.gFm = false;
    paramv.gFn = "";
    localb.a(paramv);
    if (bt.isNullOrNil(localb.thumburl))
    {
      paramString = p.auF().we(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.aux();
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
            localObject1 = b.aub().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          ad.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (w.pF(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.gJF, paramb.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.h.vKh.f(14127, new Object[] { paramb.gJF, paramb.gJE, paramb.gJD, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
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
  
  public static boolean f(bl parambl, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (parambl == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!parambl.eJL())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    parambl = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content).gKs;
    if (!bt.gL(parambl))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambl.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.ai.m.rz(((v)parambl.get(i)).gKI))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void hz(List<bl> paramList)
  {
    AppMethodBeat.i(34460);
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.krN;
        if (!bt.gL((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bl)((Iterator)localObject1).next();
            if (((bl)localObject2).eJL())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(((du)localObject2).field_msgId, ((du)localObject2).field_content).gKs;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  v localv = (v)((Iterator)localObject2).next();
                  if ((!bt.isNullOrNil(localv.gKN)) && (com.tencent.mm.ai.m.rz(localv.gKI))) {
                    b.aub().a(new l.2(localv), localv.gKN, null, ((k)g.ab(k.class)).dc(112, 90));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */