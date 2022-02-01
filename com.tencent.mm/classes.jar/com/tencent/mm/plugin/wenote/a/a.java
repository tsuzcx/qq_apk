package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<nk>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(nk paramnk)
  {
    AppMethodBeat.i(30258);
    switch (paramnk.dCo.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.fau().EQZ.b(paramnk);
      continue;
      Object localObject = new gu((byte)0);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.wenote.model.g localg = new com.tencent.mm.plugin.wenote.model.g();
      localg.ERm = com.tencent.mm.plugin.wenote.b.b.a(paramnk.dCo);
      localg.ERn = 1;
      com.tencent.mm.plugin.wenote.model.c.fau().EQZ = localg;
      if (paramnk.dCo.dCx != 4)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14789, new Object[] { Integer.valueOf(1) });
        ae.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramnk.dCo.dCx == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramnk.dCo.field_favProto != null) && (paramnk.dCo.field_favProto.GCe != null)) {
            localg.ERt = paramnk.dCo.field_favProto.GCe.sourceType;
          }
          if (paramnk.dCo.dCv != null) {
            localg.ERu = paramnk.dCo.dCv.getLong("edittime", 0L);
          }
          if (i == 0) {
            break label338;
          }
          localg.ERx = true;
          localg.a(paramnk.dCo.field_localId, paramnk.dCo.context, Boolean.valueOf(paramnk.dCo.dCy), 0, 0, paramnk.dCo.dCz, paramnk.dCo.field_favProto);
          break;
        }
        label338:
        localg.a(paramnk.dCo.field_localId, paramnk.dCo.context, Boolean.valueOf(paramnk.dCo.dCy), paramnk.dCo.dCr, 0, paramnk.dCo.dCz, null);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14789, new Object[] { Integer.valueOf(4) });
        ae.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramnk.dCo.context;
        akn localakn = paramnk.dCo.field_favProto;
        Bundle localBundle = paramnk.dCo.dCv;
        boolean bool = paramnk.dCo.dCy;
        localObject = "";
        paramnk = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramnk = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.ERo = localBundle.getString("snslocalid");
          localg.ERp = localBundle.getString("notexml", "");
          localg.ERv = localBundle.getString("snsthumbpath", "");
          localg.ERw = localBundle.getString("snsnotelinkxml", "");
        }
        localg.dCD = System.currentTimeMillis();
        localg.dCy = bool;
        localg.ERj = false;
        localg.ERs = ((String)localObject + ";" + paramnk + ";" + l);
        localg.an(localContext, 4);
        bc.ajU().aw(new g.1(localg, localakn));
        continue;
        ae.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new com.tencent.mm.plugin.wenote.model.g();
        ((com.tencent.mm.plugin.wenote.model.g)localObject).ERm = com.tencent.mm.plugin.wenote.b.b.a(paramnk.dCo);
        ((com.tencent.mm.plugin.wenote.model.g)localObject).ERn = 1;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).dCD = paramnk.dCo.field_localId;
        com.tencent.mm.plugin.wenote.model.c.fau().EQZ = ((d)localObject);
        paramnk = paramnk.dCo.context;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).ERj = true;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).an(paramnk, 2);
        continue;
        paramnk.dCp.path = ao.cxd();
        continue;
        switch (paramnk.dCo.dCw)
        {
        default: 
          break;
        case 2: 
          h.aN(paramnk.dCo.lh);
          break;
        case 4: 
          h.p(paramnk.dCo.context, paramnk.dCo.path, paramnk.dCo.dCx);
          break;
        case 5: 
          h.aLB(paramnk.dCo.path);
          break;
        case 3: 
          try
          {
            h.aLC(paramnk.dCo.dCs);
          }
          catch (JSONException paramnk)
          {
            ae.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramnk, "", new Object[0]);
          }
          continue;
          h.bH(paramnk.dCo.context, paramnk.dCo.path);
          continue;
          f.J(paramnk.dCo.field_localId, paramnk.dCo.path);
          continue;
          f.aM(paramnk.dCo.lh);
          continue;
          paramnk = new gu((byte)0);
          com.tencent.mm.sdk.b.a.IvT.l(paramnk);
          paramnk = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG();
          bc.ajU().n(new c.1(paramnk), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */