package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class c
  implements p, com.tencent.mm.plugin.record.a.d
{
  private static void a(e parame)
  {
    int i = 0;
    AppMethodBeat.i(30263);
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.eWI().EyD;
    if (locald == null)
    {
      AppMethodBeat.o(30263);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (parame.isFinished())
    {
      if (!i.fv(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.EyJ.get(parame.field_dataId);
      if (!bt.isNullOrNil(str))
      {
        ad.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.EyK.get(str) != null))
        {
          if (((o)locald.EyK.get(str)).getType() == 2) {
            ((o)locald.EyK.get(str)).dBx = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.EyK.get(str));
          locald.EyJ.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.EyJ.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new nk();
        ((nk)localObject1).dBv.dBl = str;
        ((nk)localObject1).dBv.dBx = parame.field_path;
        ((nk)localObject1).dBv.type = 1;
        ((nk)localObject1).dBv.dBr = ((o)locald.EyK.get(str)).type;
        if (((nk)localObject1).dBv.dBr != 4)
        {
          localObject2 = (o)locald.EyK.get(str);
          if (((nk)localObject1).dBv.dBr == 2) {
            break label350;
          }
          ((o)localObject2).dBx = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).ptT = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((nk)localObject1).dBv.dBr) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.fp(parame.field_path, ((o)localObject2).dBx);
        }
        if (((nk)localObject1).dBv.dBr == 4)
        {
          localObject2 = locald.aKd(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          ad.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((nk)localObject1).dBv.dtd = i;
          ((o)locald.EyK.get(str)).dBx = parame.field_path;
          ((o)locald.EyK.get(str)).ptT = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.EyK.get(str));
        }
        ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((nk)localObject1).dBv.dBl, ((nk)localObject1).dBv.dBx });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.EyJ.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((ajn)localObject2).duration;
      break;
      if (locald.EyG.dBy == -1L) {}
      for (localObject1 = (w)locald.EyI.get(Long.toString(locald.EyG.msgId)); (localObject1 == null) || (((w)localObject1).ptZ == null); localObject1 = (w)locald.EyI.get(Long.toString(locald.EyG.dBy)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).ptZ.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).ptS.equals(str)) {
          break label494;
        }
        ((o)localObject1).ptT = true;
        ajn localajn;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).kRE = com.tencent.mm.plugin.wenote.model.d.pti;
          localajn = locald.aKd(parame.field_dataId);
          if (localajn == null)
          {
            ad.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.sv(i));
            ((v)localObject2).ptW = f.R(aj.getContext(), ((v)localObject2).length);
            ((v)localObject2).dtd = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localajn.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.fp(parame.field_path, ((o)locald.EyK.get(str)).dBx);
          } else {
            ((o)localObject1).dBx = parame.field_path;
          }
        }
        ad.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.EyG.dBy == -1L) {}
        for (localObject1 = (w)locald.EyI.get(Long.toString(locald.EyG.msgId)); localObject1 == null; localObject1 = (w)locald.EyI.get(Long.toString(locald.EyG.dBy)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).ptY = i.aYq(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aKi(((w)localObject1).ptY);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(30262);
    e locale = new e();
    locale.field_localId = paramj.field_localId;
    locale.field_dataId = paramj.field_dataId;
    locale.field_status = paramj.field_status;
    locale.field_offset = paramj.field_offset;
    locale.field_totalLen = paramj.field_totalLen;
    locale.field_path = paramj.field_path;
    a(locale);
    AppMethodBeat.o(30262);
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(30261);
    Object localObject = f.yE(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.eWI().EyD;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).EyG == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).EyG.dBy)
      {
        ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).EyG.dBy) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (i.fv(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.I(paramc.field_favLocalId, paramc.field_path);
    }
    localObject = new e();
    ((e)localObject).field_favLocalId = paramc.field_favLocalId;
    ((e)localObject).field_dataId = paramc.field_dataId;
    ((e)localObject).field_status = paramc.field_status;
    ((e)localObject).field_offset = paramc.field_offset;
    ((e)localObject).field_totalLen = paramc.field_totalLen;
    ((e)localObject).field_path = paramc.field_path;
    a((e)localObject);
    AppMethodBeat.o(30261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.c
 * JD-Core Version:    0.7.0.1
 */