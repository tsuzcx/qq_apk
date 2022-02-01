package com.tencent.mm.plugin.wenote.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qm;
import com.tencent.mm.autogen.a.qm.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a
  implements q, com.tencent.mm.plugin.record.a.d
{
  private static void a(e parame)
  {
    int i = 0;
    AppMethodBeat.i(30263);
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.iDT().XzB;
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
      if (!y.ZC(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.XzH.get(parame.field_dataId);
      if (!Util.isNullOrNil(str))
      {
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.XzI.get(str) != null))
        {
          if (((o)locald.XzI.get(str)).getType() == 2) {
            ((o)locald.XzI.get(str)).hTM = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.XzI.get(str));
          locald.XzH.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.XzH.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new qm();
        ((qm)localObject1).hTJ.hTA = str;
        ((qm)localObject1).hTJ.hTM = parame.field_path;
        ((qm)localObject1).hTJ.type = 1;
        ((qm)localObject1).hTJ.itemType = ((o)locald.XzI.get(str)).type;
        if (((qm)localObject1).hTJ.itemType != 4)
        {
          localObject2 = (o)locald.XzI.get(str);
          if (((qm)localObject1).hTJ.itemType == 2) {
            break label350;
          }
          ((o)localObject2).hTM = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).xyp = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((qm)localObject1).hTJ.itemType) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.gB(parame.field_path, ((o)localObject2).hTM);
        }
        if (((qm)localObject1).hTJ.itemType == 4)
        {
          localObject2 = locald.bnD(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((qm)localObject1).hTJ.hIZ = i;
          ((o)locald.XzI.get(str)).hTM = parame.field_path;
          ((o)locald.XzI.get(str)).xyp = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.XzI.get(str));
        }
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((qm)localObject1).hTJ.hTA, ((qm)localObject1).hTJ.hTM });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.XzH.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((arf)localObject2).duration;
      break;
      if (locald.XzE.hTN == -1L) {}
      for (localObject1 = (w)locald.XzG.get(Long.toString(locald.XzE.msgId)); (localObject1 == null) || (((w)localObject1).xyw == null); localObject1 = (w)locald.XzG.get(Long.toString(locald.XzE.hTN)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).xyw.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).xyo.equals(str)) {
          break label494;
        }
        ((o)localObject1).xyp = true;
        arf localarf;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).sdM = com.tencent.mm.plugin.wenote.model.d.xxG;
          localarf = locald.bnD(parame.field_dataId);
          if (localarf == null)
          {
            Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.jh(i));
            ((v)localObject2).xyt = f.aj(MMApplicationContext.getContext(), ((v)localObject2).length);
            ((v)localObject2).hIZ = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localarf.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.gB(parame.field_path, ((o)locald.XzI.get(str)).hTM);
          } else {
            ((o)localObject1).hTM = parame.field_path;
          }
        }
        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.XzE.hTN == -1L) {}
        for (localObject1 = (w)locald.XzG.get(Long.toString(locald.XzE.msgId)); localObject1 == null; localObject1 = (w)locald.XzG.get(Long.toString(locald.XzE.hTN)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).xyv = y.bEn(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().bnI(((w)localObject1).xyv);
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
    Object localObject = f.to(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.iDT().XzB;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).XzE == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).XzE.hTN)
      {
        Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).XzE.hTN) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (y.ZC(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.al(paramc.field_favLocalId, paramc.field_path);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.event.a
 * JD-Core Version:    0.7.0.1
 */