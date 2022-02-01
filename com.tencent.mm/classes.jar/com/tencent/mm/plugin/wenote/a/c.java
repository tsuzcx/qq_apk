package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.nl.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.fau().EQZ;
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
      if (!com.tencent.mm.vfs.o.fB(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.ERf.get(parame.field_dataId);
      if (!bu.isNullOrNil(str))
      {
        ae.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.ERg.get(str) != null))
        {
          if (((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).getType() == 2) {
            ((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).dCC = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.ERg.get(str));
          locald.ERf.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.ERf.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new nl();
        ((nl)localObject1).dCA.dCq = str;
        ((nl)localObject1).dCA.dCC = parame.field_path;
        ((nl)localObject1).dCA.type = 1;
        ((nl)localObject1).dCA.dCw = ((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).type;
        if (((nl)localObject1).dCA.dCw != 4)
        {
          localObject2 = (com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str);
          if (((nl)localObject1).dCA.dCw == 2) {
            break label350;
          }
          ((com.tencent.mm.plugin.wenote.model.a.o)localObject2).dCC = parame.field_path;
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.wenote.model.a.o)localObject2).pAx = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((nl)localObject1).dCA.dCw) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.ft(parame.field_path, ((com.tencent.mm.plugin.wenote.model.a.o)localObject2).dCC);
        }
        if (((nl)localObject1).dCA.dCw == 4)
        {
          localObject2 = locald.aLz(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          ae.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((nl)localObject1).dCA.duj = i;
          ((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).dCC = parame.field_path;
          ((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).pAx = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.ERg.get(str));
        }
        ae.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((nl)localObject1).dCA.dCq, ((nl)localObject1).dCA.dCC });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.ERf.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((ajx)localObject2).duration;
      break;
      if (locald.ERc.dCD == -1L) {}
      for (localObject1 = (w)locald.ERe.get(Long.toString(locald.ERc.msgId)); (localObject1 == null) || (((w)localObject1).pAD == null); localObject1 = (w)locald.ERe.get(Long.toString(locald.ERc.dCD)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).pAD.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.wenote.model.a.o)((Iterator)localObject2).next();
        if (!((com.tencent.mm.plugin.wenote.model.a.o)localObject1).pAw.equals(str)) {
          break label494;
        }
        ((com.tencent.mm.plugin.wenote.model.a.o)localObject1).pAx = true;
        ajx localajx;
        if (((com.tencent.mm.plugin.wenote.model.a.o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).kVn = com.tencent.mm.plugin.wenote.model.d.pzO;
          localajx = locald.aLz(parame.field_dataId);
          if (localajx == null)
          {
            ae.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.sI(i));
            ((v)localObject2).pAA = f.R(ak.getContext(), ((v)localObject2).length);
            ((v)localObject2).duj = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localajx.duration;
          break label691;
          if (((com.tencent.mm.plugin.wenote.model.a.o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.ft(parame.field_path, ((com.tencent.mm.plugin.wenote.model.a.o)locald.ERg.get(str)).dCC);
          } else {
            ((com.tencent.mm.plugin.wenote.model.a.o)localObject1).dCC = parame.field_path;
          }
        }
        ae.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.ERc.dCD == -1L) {}
        for (localObject1 = (w)locald.ERe.get(Long.toString(locald.ERc.msgId)); localObject1 == null; localObject1 = (w)locald.ERe.get(Long.toString(locald.ERc.dCD)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).pAC = com.tencent.mm.vfs.o.aZT(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().aLE(((w)localObject1).pAC);
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
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
    Object localObject = f.zd(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.fau().EQZ;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).ERc == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).ERc.dCD)
      {
        ae.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).ERc.dCD) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      ae.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (com.tencent.mm.vfs.o.fB(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.J(paramc.field_favLocalId, paramc.field_path);
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