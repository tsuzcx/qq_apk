package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.aa;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.am.j;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
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
    localb.description = paramv.lpM;
    localb.type = 33;
    localb.loA = paramv.lpP;
    localb.loz = paramv.lpQ;
    localb.loB = paramv.lpT;
    localb.loT = paramv.lpS;
    localb.loU = paramv.lpR;
    localb.loD = "";
    localb.loC = 2;
    localb.url = paramv.url;
    localb.loV = paramv.lpV;
    localb.fUj = ("wxapp_" + paramv.lpT + paramv.lpQ);
    localb.fUd = paramv.lpP;
    localb.fUe = paramv.lpW;
    paramv = new com.tencent.mm.aj.a();
    paramv.ljZ = false;
    paramv.lka = "";
    localb.a(paramv);
    if (Util.isNullOrNil(localb.thumburl))
    {
      paramString = q.bhP().TS(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.bhH();
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
            localObject1 = b.bhh().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          Log.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (ab.Lj(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.m.a(paramb, paramb.loB, paramb.title, paramString1, null, paramString2);
            paramString2 = paramb.loF;
            com.tencent.mm.plugin.report.service.h.IzE.a(14127, new Object[] { paramb.loB, paramb.loA, paramb.loz, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1, Integer.valueOf(1), paramString2, "" });
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
  
  public static boolean i(ca paramca, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (paramca == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!paramca.hwA())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    paramca = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content).lpz;
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
      if (com.tencent.mm.aj.m.OS(((v)paramca.get(i)).lpP))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void kd(List<ca> paramList)
  {
    AppMethodBeat.i(34460);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = this.pzd;
        if (!Util.isNullOrNil((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ca)((Iterator)localObject1).next();
            Object localObject3;
            if (((ca)localObject2).erk())
            {
              localObject3 = k.b.OQ(((et)localObject2).field_content);
              if ((localObject3 != null) && (((k.b)localObject3).ar(com.tencent.mm.aj.a.class) != null))
              {
                aa localaa = new aa();
                localaa.lqv = ((k.b)localObject3);
                EventCenter.instance.publish(localaa);
              }
            }
            if (((ca)localObject2).hwA())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(((et)localObject2).field_msgId, ((et)localObject2).field_content).lpz;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (v)((Iterator)localObject2).next();
                  if ((!Util.isNullOrNil(((v)localObject3).lpU)) && (com.tencent.mm.aj.m.OS(((v)localObject3).lpP))) {
                    b.bhh().a(new m.2((v)localObject3), ((v)localObject3).lpU, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(112, 90));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */