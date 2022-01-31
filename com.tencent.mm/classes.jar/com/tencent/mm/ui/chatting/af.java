package com.tencent.mm.ui.chatting;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class af
{
  public static String a(bi parambi, g.a parama)
  {
    String str2 = "";
    String str1 = str2;
    if (parama != null)
    {
      str1 = str2;
      if (!bk.bl(parama.bFE))
      {
        parama = ap.avh().VQ(parama.bFE);
        str1 = str2;
        if (parama != null)
        {
          str1 = str2;
          if (parama.aXY())
          {
            str1 = str2;
            if (com.tencent.mm.vfs.e.bK(parama.field_fileFullPath)) {
              str1 = parama.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bk.bl(str1))
    {
      y.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      return str1;
    }
    if (parambi != null) {
      str1 = o.OJ().F(parambi.field_imgPath, true);
    }
    y.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    return str1;
  }
  
  private static String g(com.tencent.mm.as.e parame)
  {
    if (parame != null)
    {
      Object localObject;
      if (parame.Or())
      {
        localObject = parame.enq;
        if ((localObject == null) || (!com.tencent.mm.vfs.e.bK((String)localObject))) {}
      }
      do
      {
        String str;
        do
        {
          return localObject;
          localObject = parame.enq;
          str = o.OJ().o((String)localObject, null, null);
          if (str == null) {
            break;
          }
          localObject = str;
        } while (com.tencent.mm.vfs.e.bK(str));
        parame = parame.ens;
        parame = o.OJ().o(parame, null, null);
        if (parame == null) {
          break;
        }
        localObject = parame;
      } while (com.tencent.mm.vfs.e.bK(parame));
    }
    return null;
  }
  
  public static String hM(long paramLong)
  {
    String str = g(o.OJ().bY(paramLong));
    if (str != null) {
      return str;
    }
    return null;
  }
  
  public static String hN(long paramLong)
  {
    String str = g(o.OJ().bX(paramLong));
    if (str != null) {
      return str;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.af
 * JD-Core Version:    0.7.0.1
 */