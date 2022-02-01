package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
    localb.description = paramv.hlf;
    localb.type = 33;
    localb.hke = paramv.hli;
    localb.hkd = paramv.hlj;
    localb.hkf = paramv.hlm;
    localb.hkq = paramv.hll;
    localb.hkr = paramv.hlk;
    localb.hkh = "";
    localb.hkg = 2;
    localb.url = paramv.url;
    localb.hks = paramv.hlo;
    localb.dvr = ("wxapp_" + paramv.hlm + paramv.hlj);
    localb.dvl = paramv.hli;
    localb.dvm = paramv.hlp;
    paramv = new com.tencent.mm.ah.a();
    paramv.hfN = false;
    paramv.hfO = "";
    localb.a(paramv);
    if (bs.isNullOrNil(localb.thumburl))
    {
      paramString = p.aBw().Ak(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.aBo();
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
        if (!bs.isNullOrNil(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.aAS().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          ac.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (w.sQ(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.hkf, paramb.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.h.wUl.f(14127, new Object[] { paramb.hkf, paramb.hke, paramb.hkd, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
            AppMethodBeat.o(34457);
          }
        }
        else
        {
          ac.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        ac.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(34457);
        return;
      }
    }
  }
  
  public static boolean f(bo parambo, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (parambo == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!parambo.eZj())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    parambo = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content).hkS;
    if (!bs.gY(parambo))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambo.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.ah.m.vC(((v)parambo.get(i)).hli))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void hM(List<bo> paramList)
  {
    AppMethodBeat.i(34460);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.gan;
        if (!bs.gY((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bo)((Iterator)localObject1).next();
            if (((bo)localObject2).eZj())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(((dy)localObject2).field_msgId, ((dy)localObject2).field_content).hkS;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  v localv = (v)((Iterator)localObject2).next();
                  if ((!bs.isNullOrNil(localv.hln)) && (com.tencent.mm.ah.m.vC(localv.hli))) {
                    b.aAS().a(new l.2(localv), localv.hln, null, ((k)g.ab(k.class)).dc(112, 90));
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