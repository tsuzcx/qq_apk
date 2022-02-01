package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.mt.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.esw().BCA;
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
      if (!com.tencent.mm.vfs.i.eK(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.BCG.get(parame.field_dataId);
      if (!bt.isNullOrNil(str))
      {
        ad.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.BCH.get(str) != null))
        {
          if (((o)locald.BCH.get(str)).getType() == 2) {
            ((o)locald.BCH.get(str)).drZ = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.BCH.get(str));
          locald.BCG.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.BCG.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new mt();
        ((mt)localObject1).drX.drN = str;
        ((mt)localObject1).drX.drZ = parame.field_path;
        ((mt)localObject1).drX.type = 1;
        ((mt)localObject1).drX.drT = ((o)locald.BCH.get(str)).type;
        if (((mt)localObject1).drX.drT != 4)
        {
          localObject2 = (o)locald.BCH.get(str);
          if (((mt)localObject1).drX.drT == 2) {
            break label350;
          }
          ((o)localObject2).drZ = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).omJ = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((mt)localObject1).drX.drT) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.eS(parame.field_path, ((o)localObject2).drZ);
        }
        if (((mt)localObject1).drX.drT == 4)
        {
          localObject2 = locald.azm(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          ad.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((mt)localObject1).drX.dkk = i;
          ((o)locald.BCH.get(str)).drZ = parame.field_path;
          ((o)locald.BCH.get(str)).omJ = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.BCH.get(str));
        }
        ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((mt)localObject1).drX.drN, ((mt)localObject1).drX.drZ });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.BCG.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((afy)localObject2).duration;
      break;
      if (locald.BCD.dsa == -1L) {}
      for (localObject1 = (w)locald.BCF.get(Long.toString(locald.BCD.msgId)); (localObject1 == null) || (((w)localObject1).omP == null); localObject1 = (w)locald.BCF.get(Long.toString(locald.BCD.dsa)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).omP.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).omI.equals(str)) {
          break label494;
        }
        ((o)localObject1).omJ = true;
        afy localafy;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).jUR = com.tencent.mm.plugin.wenote.model.d.oma;
          localafy = locald.azm(parame.field_dataId);
          if (localafy == null)
          {
            ad.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.mI(i));
            ((v)localObject2).omM = f.N(aj.getContext(), ((v)localObject2).length);
            ((v)localObject2).dkk = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localafy.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.eS(parame.field_path, ((o)locald.BCH.get(str)).drZ);
          } else {
            ((o)localObject1).drZ = parame.field_path;
          }
        }
        ad.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.BCD.dsa == -1L) {}
        for (localObject1 = (w)locald.BCF.get(Long.toString(locald.BCD.msgId)); localObject1 == null; localObject1 = (w)locald.BCF.get(Long.toString(locald.BCD.dsa)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).omO = com.tencent.mm.vfs.i.aMP(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().azr(((w)localObject1).omO);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(30262);
    e locale = new e();
    locale.field_localId = parami.field_localId;
    locale.field_dataId = parami.field_dataId;
    locale.field_status = parami.field_status;
    locale.field_offset = parami.field_offset;
    locale.field_totalLen = parami.field_totalLen;
    locale.field_path = parami.field_path;
    a(locale);
    AppMethodBeat.o(30262);
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(30261);
    Object localObject = f.rP(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.esw().BCA;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).BCD == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).BCD.dsa)
      {
        ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).BCD.dsa) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      ad.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (com.tencent.mm.vfs.i.eK(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.F(paramc.field_favLocalId, paramc.field_path);
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