package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.x;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class m
{
  public static k.b a(String paramString, v paramv)
  {
    AppMethodBeat.i(34458);
    k.b localb = new k.b();
    localb.title = paramv.title;
    localb.description = paramv.hGg;
    localb.type = 33;
    localb.hFc = paramv.hGj;
    localb.hFb = paramv.hGk;
    localb.hFd = paramv.hGn;
    localb.hFr = paramv.hGm;
    localb.hFs = paramv.hGl;
    localb.hFf = "";
    localb.hFe = 2;
    localb.url = paramv.url;
    localb.hFt = paramv.hGp;
    localb.dIz = ("wxapp_" + paramv.hGn + paramv.hGk);
    localb.dIt = paramv.hGj;
    localb.dIu = paramv.hGq;
    paramv = new com.tencent.mm.ah.a();
    paramv.hAJ = false;
    paramv.hAK = "";
    localb.a(paramv);
    if (bu.isNullOrNil(localb.thumburl))
    {
      paramString = p.aEN().DL(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.aEG();
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
        if (!bu.isNullOrNil(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.aEl().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          ae.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (x.wb(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.hFd, paramb.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.g.yxI.f(14127, new Object[] { paramb.hFd, paramb.hFc, paramb.hFb, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
            AppMethodBeat.o(34457);
          }
        }
        else
        {
          ae.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        ae.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(34457);
        return;
      }
    }
  }
  
  public static boolean f(bv parambv, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (parambv == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!parambv.fta())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    parambv = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content).hFT;
    if (!bu.ht(parambv))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambv.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.ah.m.zd(((v)parambv.get(i)).hGj))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void ii(List<bv> paramList)
  {
    AppMethodBeat.i(34460);
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.gww;
        if (!bu.ht((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bv)((Iterator)localObject1).next();
            if (((bv)localObject2).fta())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(((ei)localObject2).field_msgId, ((ei)localObject2).field_content).hFT;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  v localv = (v)((Iterator)localObject2).next();
                  if ((!bu.isNullOrNil(localv.hGo)) && (com.tencent.mm.ah.m.zd(localv.hGj))) {
                    b.aEl().a(new m.2(localv), localv.hGo, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(112, 90));
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
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */