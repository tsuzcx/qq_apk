package com.tencent.mm.plugin.wenote.event;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hq;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;

public class NotifyWNNoteOperationListener
  extends IListener<ql>
{
  public NotifyWNNoteOperationListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161476);
    this.__eventId = ql.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(ql paramql)
  {
    AppMethodBeat.i(30258);
    switch (paramql.hTy.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.iDT().XzB.b(paramql);
      continue;
      new hq((byte)0).publish();
      g localg = new g();
      localg.XzO = b.a(paramql.hTy);
      localg.XzP = 1;
      com.tencent.mm.plugin.wenote.model.c.iDT().XzB = localg;
      if (paramql.hTy.hTG != 4)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramql.hTy.hTG == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramql.hTy.field_favProto != null) && (paramql.hTy.field_favProto.ZBt != null)) {
            localg.XzV = paramql.hTy.field_favProto.ZBt.sourceType;
          }
          if (paramql.hTy.hTF != null)
          {
            localg.XzW = paramql.hTy.hTF.getLong("edittime", 0L);
            localg.XzZ = paramql.hTy.hTF.getByteArray("key_multi_task_common_info");
          }
          if (i == 0) {
            break label353;
          }
          localg.XAa = true;
          localg.a(paramql.hTy.field_localId, paramql.hTy.context, Boolean.valueOf(paramql.hTy.hTH), 0, 0, paramql.hTy.hTI, paramql.hTy.field_favProto, localg.XzZ);
          break;
        }
        label353:
        localg.a(paramql.hTy.field_localId, paramql.hTy.context, Boolean.valueOf(paramql.hTy.hTH), paramql.hTy.hTB, 0, paramql.hTy.hTI, null, localg.XzZ);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(4) });
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramql.hTy.context;
        arv localarv = paramql.hTy.field_favProto;
        Bundle localBundle = paramql.hTy.hTF;
        boolean bool = paramql.hTy.hTH;
        Object localObject = "";
        paramql = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramql = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.XzQ = localBundle.getString("snslocalid");
          localg.XzR = localBundle.getString("notexml", "");
          localg.XzZ = localBundle.getByteArray("key_multi_task_common_info");
          localg.XzX = localBundle.getString("snsthumbpath", "");
          localg.XzY = localBundle.getString("snsnotelinkxml", "");
        }
        localg.hTN = System.currentTimeMillis();
        localg.hTH = bool;
        localg.XzL = false;
        localg.XzU = ((String)localObject + ";" + paramql + ";" + l);
        localg.bh(localContext, 4);
        bh.baH().postToWorker(new g.1(localg, localarv));
        continue;
        Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).XzO = b.a(paramql.hTy);
        ((g)localObject).XzP = 1;
        ((g)localObject).hTN = paramql.hTy.field_localId;
        com.tencent.mm.plugin.wenote.model.c.iDT().XzB = ((d)localObject);
        paramql = paramql.hTy.context;
        ((g)localObject).XzL = true;
        ((g)localObject).bh(paramql, 2);
        continue;
        paramql.hTz.path = aq.dQZ();
        continue;
        switch (paramql.hTy.itemType)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.bV(paramql.hTy.dvO);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.t(paramql.hTy.context, paramql.hTy.path, paramql.hTy.hTG);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.bnF(paramql.hTy.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.bnG(paramql.hTy.hTC);
          }
          catch (JSONException paramql)
          {
            Log.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramql, "", new Object[0]);
          }
          continue;
          com.tencent.mm.plugin.wenote.model.h.cy(paramql.hTy.context, paramql.hTy.path);
          continue;
          com.tencent.mm.plugin.wenote.model.f.al(paramql.hTy.field_localId, paramql.hTy.path);
          continue;
          com.tencent.mm.plugin.wenote.model.f.bU(paramql.hTy.dvO);
          continue;
          new hq((byte)0).publish();
          paramql = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg();
          bh.baH().postToWorkerDelayed(new c.1(paramql), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.event.NotifyWNNoteOperationListener
 * JD-Core Version:    0.7.0.1
 */