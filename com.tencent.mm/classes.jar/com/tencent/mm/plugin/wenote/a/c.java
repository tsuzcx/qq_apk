package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pa;
import com.tencent.mm.f.a.pa.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class c
  implements q, com.tencent.mm.plugin.record.a.d
{
  private static void a(e parame)
  {
    int i = 0;
    AppMethodBeat.i(30263);
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.hdm().QGd;
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
      if (!u.agG(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.QGj.get(parame.field_dataId);
      if (!Util.isNullOrNil(str))
      {
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.QGk.get(str) != null))
        {
          if (((o)locald.QGk.get(str)).getType() == 2) {
            ((o)locald.QGk.get(str)).fNU = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.QGk.get(str));
          locald.QGj.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.QGj.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new pa();
        ((pa)localObject1).fNS.fNI = str;
        ((pa)localObject1).fNS.fNU = parame.field_path;
        ((pa)localObject1).fNS.type = 1;
        ((pa)localObject1).fNS.fNO = ((o)locald.QGk.get(str)).type;
        if (((pa)localObject1).fNS.fNO != 4)
        {
          localObject2 = (o)locald.QGk.get(str);
          if (((pa)localObject1).fNS.fNO == 2) {
            break label350;
          }
          ((o)localObject2).fNU = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).urU = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((pa)localObject1).fNS.fNO) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.d.c.fY(parame.field_path, ((o)localObject2).fNU);
        }
        if (((pa)localObject1).fNS.fNO == 4)
        {
          localObject2 = locald.bnP(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((pa)localObject1).fNS.fEj = i;
          ((o)locald.QGk.get(str)).fNU = parame.field_path;
          ((o)locald.QGk.get(str)).urU = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.QGk.get(str));
        }
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((pa)localObject1).fNS.fNI, ((pa)localObject1).fNS.fNU });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.QGj.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((anm)localObject2).duration;
      break;
      if (locald.QGg.fNV == -1L) {}
      for (localObject1 = (w)locald.QGi.get(Long.toString(locald.QGg.msgId)); (localObject1 == null) || (((w)localObject1).usa == null); localObject1 = (w)locald.QGi.get(Long.toString(locald.QGg.fNV)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).usa.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).urT.equals(str)) {
          break label494;
        }
        ((o)localObject1).urU = true;
        anm localanm;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).oYm = com.tencent.mm.plugin.wenote.model.d.urk;
          localanm = locald.bnP(parame.field_dataId);
          if (localanm == null)
          {
            Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.GW(i));
            ((v)localObject2).urX = f.ab(MMApplicationContext.getContext(), ((v)localObject2).length);
            ((v)localObject2).fEj = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localanm.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.d.c.fY(parame.field_path, ((o)locald.QGk.get(str)).fNU);
          } else {
            ((o)localObject1).fNU = parame.field_path;
          }
        }
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.QGg.fNV == -1L) {}
        for (localObject1 = (w)locald.QGi.get(Long.toString(locald.QGg.msgId)); localObject1 == null; localObject1 = (w)locald.QGi.get(Long.toString(locald.QGg.fNV)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).urZ = u.bBS(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().bnU(((w)localObject1).urZ);
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
    Object localObject = f.Po(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.hdm().QGd;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).QGg == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).QGg.fNV)
      {
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).QGg.fNV) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (u.agG(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.W(paramc.field_favLocalId, paramc.field_path);
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