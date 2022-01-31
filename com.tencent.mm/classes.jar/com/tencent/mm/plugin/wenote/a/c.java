package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.lj.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class c
  implements p, com.tencent.mm.plugin.record.a.d
{
  private static void a(com.tencent.mm.plugin.wenote.model.e parame)
  {
    int i = 0;
    AppMethodBeat.i(26592);
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ;
    if (locald == null)
    {
      AppMethodBeat.o(26592);
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (parame.isFinished())
    {
      if (!com.tencent.mm.a.e.cN(parame.field_path))
      {
        AppMethodBeat.o(26592);
        return;
      }
      str = (String)locald.vvV.get(parame.field_dataId);
      if (!bo.isNullOrNil(str))
      {
        ab.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.vvW.get(str) != null))
        {
          if (((o)locald.vvW.get(str)).getType() == 2) {
            ((o)locald.vvW.get(str)).cBD = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.vvW.get(str));
          locald.vvV.remove(parame.field_dataId);
          AppMethodBeat.o(26592);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.vvV.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new lj();
        ((lj)localObject1).cBB.cBt = str;
        ((lj)localObject1).cBB.cBD = parame.field_path;
        ((lj)localObject1).cBB.type = 1;
        ((lj)localObject1).cBB.itemType = ((o)locald.vvW.get(str)).type;
        if (((lj)localObject1).cBB.itemType != 4)
        {
          localObject2 = (o)locald.vvW.get(str);
          if (((lj)localObject1).cBB.itemType == 2) {
            break label350;
          }
          ((o)localObject2).cBD = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).vxs = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((lj)localObject1).cBB.itemType) {
            break;
          }
          AppMethodBeat.o(26592);
          return;
          label350:
          com.tencent.mm.plugin.wenote.b.c.hJ(parame.field_path, ((o)localObject2).cBD);
        }
        if (((lj)localObject1).cBB.itemType == 4)
        {
          localObject2 = locald.ajE(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          ab.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((lj)localObject1).cBB.cvf = i;
          ((o)locald.vvW.get(str)).cBD = parame.field_path;
          ((o)locald.vvW.get(str)).vxs = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.vvW.get(str));
        }
        ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((lj)localObject1).cBB.cBt, ((lj)localObject1).cBB.cBD });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.vvV.remove(parame.field_dataId);
      AppMethodBeat.o(26592);
      return;
      i = ((aca)localObject2).duration;
      break;
      if (locald.vvS.cBE == -1L) {}
      for (localObject1 = (w)locald.vvU.get(Long.toString(locald.vvS.cpO)); (localObject1 == null) || (((w)localObject1).vxI == null); localObject1 = (w)locald.vvU.get(Long.toString(locald.vvS.cBE)))
      {
        AppMethodBeat.o(26592);
        return;
      }
      localObject2 = ((w)localObject1).vxI.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).vxr.equals(str)) {
          break label494;
        }
        ((o)localObject1).vxs = true;
        aca localaca;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).hPe = com.tencent.mm.plugin.wenote.model.d.vwe;
          localaca = locald.ajE(parame.field_dataId);
          if (localaca == null)
          {
            ab.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.hi(i));
            ((v)localObject2).vxF = f.L(ah.getContext(), ((v)localObject2).length);
            ((v)localObject2).cvf = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localaca.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.b.c.hJ(parame.field_path, ((o)locald.vvW.get(str)).cBD);
          } else {
            ((o)localObject1).cBD = parame.field_path;
          }
        }
        ab.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.vvS.cBE == -1L) {}
        for (localObject1 = (w)locald.vvU.get(Long.toString(locald.vvS.cpO)); localObject1 == null; localObject1 = (w)locald.vvU.get(Long.toString(locald.vvS.cBE)))
        {
          AppMethodBeat.o(26592);
          return;
        }
        try
        {
          ((w)localObject1).vxH = com.tencent.mm.vfs.e.cS(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ajM(((w)localObject1).vxH);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(26591);
    com.tencent.mm.plugin.wenote.model.e locale = new com.tencent.mm.plugin.wenote.model.e();
    locale.field_localId = parami.field_localId;
    locale.field_dataId = parami.field_dataId;
    locale.field_status = parami.field_status;
    locale.field_offset = parami.field_offset;
    locale.field_totalLen = parami.field_totalLen;
    locale.field_path = parami.field_path;
    a(locale);
    AppMethodBeat.o(26591);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(26590);
    Object localObject = f.kY(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).vvS == null))
      {
        AppMethodBeat.o(26590);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).vvS.cBE)
      {
        ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).vvS.cBE) });
        AppMethodBeat.o(26590);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(26590);
      return;
    }
    if ((paramc.field_status == 3) && (com.tencent.mm.a.e.cN(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.z(paramc.field_favLocalId, paramc.field_path);
    }
    localObject = new com.tencent.mm.plugin.wenote.model.e();
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_favLocalId = paramc.field_favLocalId;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_dataId = paramc.field_dataId;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_status = paramc.field_status;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_offset = paramc.field_offset;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_totalLen = paramc.field_totalLen;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_path = paramc.field_path;
    a((com.tencent.mm.plugin.wenote.model.e)localObject);
    AppMethodBeat.o(26590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.c
 * JD-Core Version:    0.7.0.1
 */