package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class l
{
  public static j.b a(String paramString, q paramq)
  {
    AppMethodBeat.i(30594);
    j.b localb = new j.b();
    localb.title = paramq.title;
    localb.description = paramq.fjL;
    localb.type = 33;
    localb.fiX = paramq.fjO;
    localb.fiW = paramq.fjP;
    localb.fiY = paramq.fjS;
    localb.fjh = paramq.fjR;
    localb.fji = paramq.fjQ;
    localb.fja = "";
    localb.fiZ = 2;
    localb.url = paramq.url;
    localb.fjj = paramq.fjU;
    localb.cGT = ("wxapp_" + paramq.fjS + paramq.fjP);
    localb.cGN = paramq.fjO;
    localb.cGO = paramq.fjV;
    paramq = new com.tencent.mm.af.a();
    paramq.ffc = false;
    paramq.ffd = "";
    localb.a(paramq);
    if (bo.isNullOrNil(localb.thumburl))
    {
      paramString = o.adg().rj(paramString);
      if (paramString != null) {
        localb.thumburl = paramString.acX();
      }
    }
    AppMethodBeat.o(30594);
    return localb;
  }
  
  public static void b(String paramString1, j.b paramb, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(30593);
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[0];
        Object localObject1 = localObject2;
        if (!bo.isNullOrNil(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.acD().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          ab.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (t.lA(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.l.a(paramb, paramb.fiY, paramb.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.h.qsU.e(14127, new Object[] { paramb.fiY, paramb.fiX, paramb.fiW, paramb.title, paramb.description, "", paramb.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
            AppMethodBeat.o(30593);
          }
        }
        else
        {
          ab.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        ab.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(30593);
        return;
      }
    }
  }
  
  public static boolean f(bi parambi, int paramInt)
  {
    AppMethodBeat.i(30595);
    if (parambi == null)
    {
      AppMethodBeat.o(30595);
      return false;
    }
    if (!parambi.dvV())
    {
      AppMethodBeat.o(30595);
      return false;
    }
    parambi = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content).fjy;
    if (!bo.es(parambi))
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambi.size()) {}
      }
      else
      {
        i = 0;
      }
      if (com.tencent.mm.af.l.na(((q)parambi.get(i)).fjO))
      {
        AppMethodBeat.o(30595);
        return true;
      }
    }
    AppMethodBeat.o(30595);
    return false;
  }
  
  static void fc(List<bi> paramList)
  {
    AppMethodBeat.i(30596);
    d.ysm.b(new l.1(paramList), "MicroMsg.ChattingEditModeSendToAppBrand$prepareAppBrandMsgToSend");
    AppMethodBeat.o(30596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */