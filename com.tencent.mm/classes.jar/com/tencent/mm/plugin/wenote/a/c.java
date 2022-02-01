package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nc.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
    com.tencent.mm.plugin.wenote.model.d locald = com.tencent.mm.plugin.wenote.model.c.eHP().CUG;
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
      if (!com.tencent.mm.vfs.i.eA(parame.field_path))
      {
        AppMethodBeat.o(30263);
        return;
      }
      str = (String)locald.CUM.get(parame.field_dataId);
      if (!bs.isNullOrNil(str))
      {
        ac.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[] { str });
        if ((parame.field_dataId.endsWith("_t")) && (locald.CUN.get(str) != null))
        {
          if (((o)locald.CUN.get(str)).getType() == 2) {
            ((o)locald.CUN.get(str)).dpK = parame.field_path;
          }
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.CUN.get(str));
          locald.CUM.remove(parame.field_dataId);
          AppMethodBeat.o(30263);
          return;
        }
        if (str.equals("WeNoteHtmlFile")) {
          break label790;
        }
        if (locald.CUM.containsValue("WeNoteHtmlFile")) {
          break label523;
        }
        localObject1 = new nc();
        ((nc)localObject1).dpI.dpy = str;
        ((nc)localObject1).dpI.dpK = parame.field_path;
        ((nc)localObject1).dpI.type = 1;
        ((nc)localObject1).dpI.dpE = ((o)locald.CUN.get(str)).type;
        if (((nc)localObject1).dpI.dpE != 4)
        {
          localObject2 = (o)locald.CUN.get(str);
          if (((nc)localObject1).dpI.dpE == 2) {
            break label350;
          }
          ((o)localObject2).dpK = parame.field_path;
        }
        for (;;)
        {
          ((o)localObject2).oQj = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject2);
          if (5 != ((nc)localObject1).dpI.dpE) {
            break;
          }
          AppMethodBeat.o(30263);
          return;
          label350:
          com.tencent.mm.plugin.wenote.c.c.ff(parame.field_path, ((o)localObject2).dpK);
        }
        if (((nc)localObject1).dpI.dpE == 4)
        {
          localObject2 = locald.aED(parame.field_dataId);
          if (localObject2 != null) {
            break label514;
          }
          ac.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
          i = 0;
          ((nc)localObject1).dpI.dhF = i;
          ((o)locald.CUN.get(str)).dpK = parame.field_path;
          ((o)locald.CUN.get(str)).oQj = true;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(str, (com.tencent.mm.plugin.wenote.model.a.c)locald.CUN.get(str));
        }
        ac.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[] { ((nc)localObject1).dpI.dpy, ((nc)localObject1).dpI.dpK });
        label494:
        break label609;
      }
    }
    label514:
    label523:
    label691:
    for (;;)
    {
      locald.CUM.remove(parame.field_dataId);
      AppMethodBeat.o(30263);
      return;
      i = ((agx)localObject2).duration;
      break;
      if (locald.CUJ.dpL == -1L) {}
      for (localObject1 = (w)locald.CUL.get(Long.toString(locald.CUJ.msgId)); (localObject1 == null) || (((w)localObject1).oQp == null); localObject1 = (w)locald.CUL.get(Long.toString(locald.CUJ.dpL)))
      {
        AppMethodBeat.o(30263);
        return;
      }
      localObject2 = ((w)localObject1).oQp.iterator();
      label609:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (!((o)localObject1).oQi.equals(str)) {
          break label494;
        }
        ((o)localObject1).oQj = true;
        agx localagx;
        if (((o)localObject1).type == 4)
        {
          localObject2 = (v)localObject1;
          ((v)localObject2).kvC = com.tencent.mm.plugin.wenote.model.d.oPA;
          localagx = locald.aED(parame.field_dataId);
          if (localagx == null)
          {
            ac.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
            ((v)localObject2).length = ((int)f.qw(i));
            ((v)localObject2).oQm = f.R(ai.getContext(), ((v)localObject2).length);
            ((v)localObject2).dhF = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(str, (com.tencent.mm.plugin.wenote.model.a.c)localObject1);
          break;
          i = localagx.duration;
          break label691;
          if (((o)localObject1).getType() == 2) {
            com.tencent.mm.plugin.wenote.c.c.ff(parame.field_path, ((o)locald.CUN.get(str)).dpK);
          } else {
            ((o)localObject1).dpK = parame.field_path;
          }
        }
        ac.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
        if (locald.CUJ.dpL == -1L) {}
        for (localObject1 = (w)locald.CUL.get(Long.toString(locald.CUJ.msgId)); localObject1 == null; localObject1 = (w)locald.CUL.get(Long.toString(locald.CUJ.dpL)))
        {
          AppMethodBeat.o(30263);
          return;
        }
        try
        {
          ((w)localObject1).oQo = com.tencent.mm.vfs.i.aSr(parame.field_path);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().aEI(((w)localObject1).oQo);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", localException, "", new Object[0]);
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
    Object localObject = f.ws(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.eHP().CUG;
      if ((localObject == null) || (((com.tencent.mm.plugin.wenote.model.d)localObject).CUJ == null))
      {
        AppMethodBeat.o(30261);
        return;
      }
      if (paramc.field_favLocalId != ((com.tencent.mm.plugin.wenote.model.d)localObject).CUJ.dpL)
      {
        ac.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((com.tencent.mm.plugin.wenote.model.d)localObject).CUJ.dpL) });
        AppMethodBeat.o(30261);
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      ac.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      AppMethodBeat.o(30261);
      return;
    }
    if ((paramc.field_status == 3) && (com.tencent.mm.vfs.i.eA(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      f.D(paramc.field_favLocalId, paramc.field_path);
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
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.c
 * JD-Core Version:    0.7.0.1
 */