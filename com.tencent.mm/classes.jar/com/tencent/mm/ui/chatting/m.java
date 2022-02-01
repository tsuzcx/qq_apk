package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.aa;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
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
    localb.description = paramv.iAq;
    localb.type = 33;
    localb.izi = paramv.iAt;
    localb.izh = paramv.weappPath;
    localb.izj = paramv.iAv;
    localb.izz = paramv.iAu;
    localb.izA = paramv.weappVersion;
    localb.izl = "";
    localb.izk = 2;
    localb.url = paramv.url;
    localb.izB = paramv.iAx;
    localb.eam = ("wxapp_" + paramv.iAv + paramv.weappPath);
    localb.eag = paramv.iAt;
    localb.eah = paramv.iAy;
    paramv = new com.tencent.mm.ag.a();
    paramv.iuQ = false;
    paramv.iuR = "";
    localb.a(paramv);
    if (Util.isNullOrNil(localb.thumburl))
    {
      paramString = p.aYB().Mx(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.aYt();
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
        if (!Util.isNullOrNil(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.aXY().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          Log.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (ab.Eq(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.izj, paramb.title, paramString1, null, paramString2);
            paramString2 = paramb.izn;
            com.tencent.mm.plugin.report.service.h.CyF.a(14127, new Object[] { paramb.izj, paramb.izi, paramb.izh, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1, Integer.valueOf(1), paramString2, "" });
            AppMethodBeat.o(34457);
          }
        }
        else
        {
          Log.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        Log.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(34457);
        return;
      }
    }
  }
  
  public static boolean f(ca paramca, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (paramca == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!paramca.gAt())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    paramca = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content).iAd;
    if (!Util.isNullOrNil(paramca))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < paramca.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.ag.m.HF(((v)paramca.get(i)).iAt))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void jl(List<ca> paramList)
  {
    AppMethodBeat.i(34460);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.hjk;
        if (!Util.isNullOrNil((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ca)((Iterator)localObject1).next();
            Object localObject3;
            if (((ca)localObject2).dOQ())
            {
              localObject3 = k.b.HD(((eo)localObject2).field_content);
              if ((localObject3 != null) && (((k.b)localObject3).as(com.tencent.mm.ag.a.class) != null))
              {
                aa localaa = new aa();
                localaa.iAX = ((k.b)localObject3);
                EventCenter.instance.publish(localaa);
              }
            }
            if (((ca)localObject2).gAt())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((eo)localObject2).field_msgId, ((eo)localObject2).field_content).iAd;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (v)((Iterator)localObject2).next();
                  if ((!Util.isNullOrNil(((v)localObject3).iAw)) && (com.tencent.mm.ag.m.HF(((v)localObject3).iAt))) {
                    b.aXY().a(new m.2((v)localObject3), ((v)localObject3).iAw, null, ((k)g.af(k.class)).jdMethod_do(112, 90));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */