package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;

public final class ac
{
  public static String b(bl parambl, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!bt.isNullOrNil(paramb.dbA))
      {
        paramb = ap.bxS().aAL(paramb.dbA);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.cAX())
          {
            str1 = str2;
            if (i.eK(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bt.isNullOrNil(str1))
    {
      ad.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(34824);
      return str1;
    }
    if (parambl != null) {
      str1 = o.ayF().Q(parambl.field_imgPath, true);
    }
    ad.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  private static String j(e parame)
  {
    AppMethodBeat.i(34823);
    if (parame != null)
    {
      if (parame.ayi())
      {
        str = parame.hgj;
        if ((str != null) && (i.eK(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = parame.hgj;
      str = o.ayF().p(str, null, null);
      if ((str != null) && (i.eK(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      parame = parame.hgl;
      parame = o.ayF().p(parame, null, null);
      if ((parame != null) && (i.eK(parame)))
      {
        AppMethodBeat.o(34823);
        return parame;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
  
  public static String ww(long paramLong)
  {
    AppMethodBeat.i(34821);
    String str = j(o.ayF().ms(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(34821);
      return str;
    }
    AppMethodBeat.o(34821);
    return null;
  }
  
  public static String wx(long paramLong)
  {
    AppMethodBeat.i(34822);
    String str = j(o.ayF().mr(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(34822);
      return str;
    }
    AppMethodBeat.o(34822);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */