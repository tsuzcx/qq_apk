package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hf;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;

public final class a
  extends IListener<oz>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(oz paramoz)
  {
    AppMethodBeat.i(30258);
    switch (paramoz.fNG.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.hdm().QGd.b(paramoz);
      continue;
      Object localObject = new hf((byte)0);
      EventCenter.instance.publish((IEvent)localObject);
      g localg = new g();
      localg.QGq = b.a(paramoz.fNG);
      localg.QGr = 1;
      com.tencent.mm.plugin.wenote.model.c.hdm().QGd = localg;
      if (paramoz.fNG.fNP != 4)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramoz.fNG.fNP == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramoz.fNG.field_favProto != null) && (paramoz.fNG.field_favProto.SAB != null)) {
            localg.QGx = paramoz.fNG.field_favProto.SAB.sourceType;
          }
          if (paramoz.fNG.fNN != null)
          {
            localg.QGy = paramoz.fNG.fNN.getLong("edittime", 0L);
            localg.QGB = paramoz.fNG.fNN.getByteArray("key_multi_task_common_info");
          }
          if (i == 0) {
            break label360;
          }
          localg.QGC = true;
          localg.a(paramoz.fNG.field_localId, paramoz.fNG.context, Boolean.valueOf(paramoz.fNG.fNQ), 0, 0, paramoz.fNG.fNR, paramoz.fNG.field_favProto, localg.QGB);
          break;
        }
        label360:
        localg.a(paramoz.fNG.field_localId, paramoz.fNG.context, Boolean.valueOf(paramoz.fNG.fNQ), paramoz.fNG.fNJ, 0, paramoz.fNG.fNR, null, localg.QGB);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(4) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramoz.fNG.context;
        aoc localaoc = paramoz.fNG.field_favProto;
        Bundle localBundle = paramoz.fNG.fNN;
        boolean bool = paramoz.fNG.fNQ;
        localObject = "";
        paramoz = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramoz = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.QGs = localBundle.getString("snslocalid");
          localg.QGt = localBundle.getString("notexml", "");
          localg.QGB = localBundle.getByteArray("key_multi_task_common_info");
          localg.QGz = localBundle.getString("snsthumbpath", "");
          localg.QGA = localBundle.getString("snsnotelinkxml", "");
        }
        localg.fNV = System.currentTimeMillis();
        localg.fNQ = bool;
        localg.QGn = false;
        localg.QGw = ((String)localObject + ";" + paramoz + ";" + l);
        localg.aO(localContext, 4);
        bh.aHJ().postToWorker(new g.1(localg, localaoc));
        continue;
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).QGq = b.a(paramoz.fNG);
        ((g)localObject).QGr = 1;
        ((g)localObject).fNV = paramoz.fNG.field_localId;
        com.tencent.mm.plugin.wenote.model.c.hdm().QGd = ((d)localObject);
        paramoz = paramoz.fNG.context;
        ((g)localObject).QGn = true;
        ((g)localObject).aO(paramoz, 2);
        continue;
        paramoz.fNH.path = ap.dkn();
        continue;
        switch (paramoz.fNG.fNO)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.bu(paramoz.fNG.bCM);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.r(paramoz.fNG.context, paramoz.fNG.path, paramoz.fNG.fNP);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.bnR(paramoz.fNG.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.bnS(paramoz.fNG.fNK);
          }
          catch (JSONException paramoz)
          {
            Log.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramoz, "", new Object[0]);
          }
          continue;
          com.tencent.mm.plugin.wenote.model.h.cn(paramoz.fNG.context, paramoz.fNG.path);
          continue;
          f.W(paramoz.fNG.field_localId, paramoz.fNG.path);
          continue;
          f.bt(paramoz.fNG.bCM);
          continue;
          paramoz = new hf((byte)0);
          EventCenter.instance.publish(paramoz);
          paramoz = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz();
          bh.aHJ().postToWorkerDelayed(new c.1(paramoz), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */