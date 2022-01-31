package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class m
{
  public static g.a a(String paramString, com.tencent.mm.ae.m paramm)
  {
    g.a locala = new g.a();
    locala.title = paramm.title;
    locala.description = paramm.dTF;
    locala.type = 33;
    locala.dSY = paramm.dTI;
    locala.dSX = paramm.dTJ;
    locala.dSZ = paramm.dTM;
    locala.dTf = paramm.dTL;
    locala.dTg = paramm.dTK;
    locala.dTb = "";
    locala.dTa = 2;
    locala.url = paramm.url;
    locala.dTh = paramm.dTO;
    locala.bYM = ("wxapp_" + paramm.dTM + paramm.dTJ);
    locala.bYG = paramm.dTI;
    locala.bYH = paramm.dTP;
    paramm = new com.tencent.mm.ae.a();
    paramm.dPD = false;
    paramm.dPE = "";
    locala.a(paramm);
    if (bk.bl(locala.thumburl))
    {
      paramString = o.Kh().kp(paramString);
      if (paramString != null) {
        locala.thumburl = paramString.JX();
      }
    }
    return locala;
  }
  
  public static void b(String paramString1, g.a parama, String paramString2)
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[0];
        Object localObject1 = localObject2;
        if (!bk.bl(paramString2)) {
          if (!paramString2.startsWith("http://"))
          {
            localObject1 = localObject2;
            if (!paramString2.startsWith("https://")) {}
          }
          else
          {
            localObject1 = b.JD().a(paramString2, null);
          }
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          y.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
          paramString2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, paramString2);
          paramString2 = paramString2.toByteArray();
          if (s.fn(paramString1))
          {
            i = 1;
            com.tencent.mm.pluginsdk.model.app.l.a(parama, parama.dSZ, parama.title, paramString1, null, paramString2);
            com.tencent.mm.plugin.report.service.h.nFQ.f(14127, new Object[] { parama.dSZ, parama.dSY, parama.dSX, parama.title, parama.description, "", parama.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), paramString1 });
          }
        }
        else
        {
          y.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
          paramString2 = arrayOfByte;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", paramString1, "", new Object[0]);
        y.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[] { paramString1.getLocalizedMessage() });
        return;
      }
    }
  }
  
  public static boolean e(bi parambi, int paramInt)
  {
    if (parambi == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!parambi.ctz());
        parambi = ((com.tencent.mm.plugin.biz.a.a)g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content).dTx;
      } while (bk.dk(parambi));
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < parambi.size()) {}
      }
      else
      {
        i = 0;
      }
    } while (!com.tencent.mm.ae.i.gr(((com.tencent.mm.ae.m)parambi.get(i)).dTI));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */