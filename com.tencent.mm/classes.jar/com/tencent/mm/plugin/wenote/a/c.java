package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.gjz().JGL;
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
      if (!s.YS(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.JGR.get(parame.field_dataId);
      if (!Util.isNullOrNil(str))
      {
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.JGS.get(str) != null))
        {
          if (((o)locald.JGS.get(str)).getType() == 2) {
            ((o)locald.JGS.get(str)).dUs = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.JGS.get(str));
          locald.JGR.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.JGR.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new od();
        ((od)localObject1).dUq.dUg = str;
        ((od)localObject1).dUq.dUs = parame.field_path;
        ((od)localObject1).dUq.type = 1;
        ((od)localObject1).dUq.dUm = ((o)locald.JGS.get(str)).type;
        if (((od)localObject1).dUq.dUm != 4)
        {
          localObject2 = (o)locald.JGS.get(str);
          if (((od)localObject1).dUq.dUm == 2) {
            break label350;
          }
          ((o)localObject2).dUs = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).qPO = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((od)localObject1).dUq.dUm) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.fK(parame.field_path, ((o)localObject2).dUs);
        }
        if (((od)localObject1).dUq.dUm == 4)
        {
          localObject2 = locald.bbP(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((od)localObject1).dUq.dLu = i;
          ((o)locald.JGS.get(str)).dUs = parame.field_path;
          ((o)locald.JGS.get(str)).qPO = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.JGS.get(str));
        }
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((od)localObject1).dUq.dUg, ((od)localObject1).dUq.dUs });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.JGR.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((aml)localObject2).duration;
      break;
      if (locald.JGO.dUt == -1L) {}
      for (localObject1 = (w)locald.JGQ.get(Long.toString(locald.JGO.msgId)); (localObject1 == null) || (((w)localObject1).qPU == null); localObject1 = (w)locald.JGQ.get(Long.toString(locald.JGO.dUt)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).qPU.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).qPN.equals(str)) {
          break label494;
        }
        ((o)localObject1).qPO = true;
        aml localaml;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).mav = com.tencent.mm.plugin.wenote.model.d.qPf;
          localaml = locald.bbP(parame.field_dataId);
          if (localaml == null)
          {
            Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.AO(i));
            ((v)localObject2).qPR = f.W(MMApplicationContext.getContext(), ((v)localObject2).length);
            ((v)localObject2).dLu = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localaml.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.fK(parame.field_path, ((o)locald.JGS.get(str)).dUs);
          } else {
            ((o)localObject1).dUs = parame.field_path;
          }
        }
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.JGO.dUt == -1L) {}
        for (localObject1 = (w)locald.JGQ.get(Long.toString(locald.JGO.msgId)); localObject1 == null; localObject1 = (w)locald.JGQ.get(Long.toString(locald.JGO.dUt)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).qPT = s.boY(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbU(((w)localObject1).qPT);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
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
    Object localObject = f.HT(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.gjz().JGL;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).JGO == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).JGO.dUt)
      {
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).JGO.dUt) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (s.YS(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.O(paramc.field_favLocalId, paramc.field_path);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.c
 * JD-Core Version:    0.7.0.1
 */