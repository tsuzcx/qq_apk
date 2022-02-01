package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.aa;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class o
{
  public static k.b a(String paramString, v paramv)
  {
    AppMethodBeat.i(34458);
    k.b localb = new k.b();
    localb.title = paramv.title;
    localb.description = paramv.nUO;
    localb.type = 33;
    localb.nTD = paramv.nUR;
    localb.nTC = paramv.nUS;
    localb.nTE = paramv.nUV;
    localb.nTW = paramv.nUU;
    localb.nTX = paramv.nUT;
    localb.nTG = "";
    localb.nTF = 2;
    localb.url = paramv.url;
    localb.nTY = paramv.nUX;
    localb.iag = ("wxapp_" + paramv.nUV + paramv.nUS);
    localb.iaa = paramv.nUR;
    localb.iab = paramv.nUY;
    paramv = new com.tencent.mm.message.a();
    paramv.nOK = false;
    paramv.nOL = "";
    localb.a(paramv);
    if (Util.isNullOrNil(localb.thumburl))
    {
      paramString = q.bFE().LS(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.bFw();
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
            localObject1 = b.bEY().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          Log.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (au.bwE(paramString1))
          {
            i = 1;
            n.a(paramb, paramb.nTE, paramb.title, paramString1, null, paramString2);
            paramString2 = paramb.nTI;
            com.tencent.mm.plugin.report.service.h.OAn.b(14127, new Object[] { paramb.nTE, paramb.nTD, paramb.nTC, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1, Integer.valueOf(1), paramString2, "" });
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
  
  public static boolean i(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(34459);
    if (paramcc == null)
    {
      AppMethodBeat.o(34459);
      return false;
    }
    if (!paramcc.iYe())
    {
      AppMethodBeat.o(34459);
      return false;
    }
    paramcc = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content).nUC;
    if (!Util.isNullOrNil(paramcc))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < paramcc.size()) {}
      }
      else
      {
        i = 0;
      }
      if (m.Hh(((v)paramcc.get(i)).nUR))
      {
        AppMethodBeat.o(34459);
        return true;
      }
    }
    AppMethodBeat.o(34459);
    return false;
  }
  
  static void nt(List<cc> paramList)
  {
    AppMethodBeat.i(34460);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34454);
        Object localObject1 = o.this;
        if (!Util.isNullOrNil((List)localObject1))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (cc)((Iterator)localObject1).next();
            Object localObject3;
            if (((cc)localObject2).fxR())
            {
              localObject3 = k.b.Hf(((fi)localObject2).field_content);
              if ((localObject3 != null) && (((k.b)localObject3).aK(com.tencent.mm.message.a.class) != null))
              {
                aa localaa = new aa();
                localaa.nVy = ((k.b)localObject3);
                localaa.publish();
              }
            }
            if (((cc)localObject2).iYe())
            {
              localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(((fi)localObject2).field_msgId, ((fi)localObject2).field_content).nUC;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (v)((Iterator)localObject2).next();
                  if ((!Util.isNullOrNil(((v)localObject3).nUW)) && (m.Hh(((v)localObject3).nUR))) {
                    b.bEY().a(new o.2((v)localObject3), ((v)localObject3).nUW, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(112, 90));
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
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */