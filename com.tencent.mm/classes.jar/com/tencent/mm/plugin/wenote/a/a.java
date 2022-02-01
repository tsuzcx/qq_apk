package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;

public final class a
  extends IListener<oc>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = oc.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(oc paramoc)
  {
    AppMethodBeat.i(30258);
    switch (paramoc.dUe.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.gjz().JGL.b(paramoc);
      continue;
      Object localObject = new gy((byte)0);
      EventCenter.instance.publish((IEvent)localObject);
      g localg = new g();
      localg.JGY = com.tencent.mm.plugin.wenote.b.a.a(paramoc.dUe);
      localg.JGZ = 1;
      com.tencent.mm.plugin.wenote.model.c.gjz().JGL = localg;
      if (paramoc.dUe.dUn != 4)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14789, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramoc.dUe.dUn == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramoc.dUe.field_favProto != null) && (paramoc.dUe.field_favProto.Lya != null)) {
            localg.JHf = paramoc.dUe.field_favProto.Lya.sourceType;
          }
          if (paramoc.dUe.dUl != null)
          {
            localg.JHg = paramoc.dUe.dUl.getLong("edittime", 0L);
            localg.JHj = paramoc.dUe.dUl.getByteArray("key_multi_task_common_info");
          }
          if (i == 0) {
            break label360;
          }
          localg.JHk = true;
          localg.a(paramoc.dUe.field_localId, paramoc.dUe.context, Boolean.valueOf(paramoc.dUe.dUo), 0, 0, paramoc.dUe.dUp, paramoc.dUe.field_favProto, localg.JHj);
          break;
        }
        label360:
        localg.a(paramoc.dUe.field_localId, paramoc.dUe.context, Boolean.valueOf(paramoc.dUe.dUo), paramoc.dUe.dUh, 0, paramoc.dUe.dUp, null, localg.JHj);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14789, new Object[] { Integer.valueOf(4) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramoc.dUe.context;
        anb localanb = paramoc.dUe.field_favProto;
        Bundle localBundle = paramoc.dUe.dUl;
        boolean bool = paramoc.dUe.dUo;
        localObject = "";
        paramoc = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramoc = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.JHa = localBundle.getString("snslocalid");
          localg.JHb = localBundle.getString("notexml", "");
          localg.JHj = localBundle.getByteArray("key_multi_task_common_info");
          localg.JHh = localBundle.getString("snsthumbpath", "");
          localg.JHi = localBundle.getString("snsnotelinkxml", "");
        }
        localg.dUt = System.currentTimeMillis();
        localg.dUo = bool;
        localg.JGV = false;
        localg.JHe = ((String)localObject + ";" + paramoc + ";" + l);
        localg.aw(localContext, 4);
        bg.aAk().postToWorker(new g.1(localg, localanb));
        continue;
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).JGY = com.tencent.mm.plugin.wenote.b.a.a(paramoc.dUe);
        ((g)localObject).JGZ = 1;
        ((g)localObject).dUt = paramoc.dUe.field_localId;
        com.tencent.mm.plugin.wenote.model.c.gjz().JGL = ((d)localObject);
        paramoc = paramoc.dUe.context;
        ((g)localObject).JGV = true;
        ((g)localObject).aw(paramoc, 2);
        continue;
        paramoc.dUf.path = ao.cVh();
        continue;
        switch (paramoc.dUe.dUm)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.bf(paramoc.dUe.lj);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.p(paramoc.dUe.context, paramoc.dUe.path, paramoc.dUe.dUn);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.bbR(paramoc.dUe.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.bbS(paramoc.dUe.dUi);
          }
          catch (JSONException paramoc)
          {
            Log.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramoc, "", new Object[0]);
          }
          continue;
          com.tencent.mm.plugin.wenote.model.h.cb(paramoc.dUe.context, paramoc.dUe.path);
          continue;
          f.O(paramoc.dUe.field_localId, paramoc.dUe.path);
          continue;
          f.be(paramoc.dUe.lj);
          continue;
          paramoc = new gy((byte)0);
          EventCenter.instance.publish(paramoc);
          paramoc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL();
          bg.aAk().postToWorkerDelayed(new c.1(paramoc), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */