package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.nj.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<nj>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = nj.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(nj paramnj)
  {
    AppMethodBeat.i(30258);
    switch (paramnj.dBj.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.eWI().EyD.b(paramnj);
      continue;
      Object localObject = new gt((byte)0);
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.wenote.model.g localg = new com.tencent.mm.plugin.wenote.model.g();
      localg.EyQ = com.tencent.mm.plugin.wenote.b.b.a(paramnj.dBj);
      localg.EyR = 1;
      com.tencent.mm.plugin.wenote.model.c.eWI().EyD = localg;
      if (paramnj.dBj.dBs != 4)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(14789, new Object[] { Integer.valueOf(1) });
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramnj.dBj.dBs == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramnj.dBj.field_favProto != null) && (paramnj.dBj.field_favProto.Gjv != null)) {
            localg.EyX = paramnj.dBj.field_favProto.Gjv.sourceType;
          }
          if (paramnj.dBj.dBq != null) {
            localg.EyY = paramnj.dBj.dBq.getLong("edittime", 0L);
          }
          if (i == 0) {
            break label338;
          }
          localg.Ezb = true;
          localg.a(paramnj.dBj.field_localId, paramnj.dBj.context, Boolean.valueOf(paramnj.dBj.dBt), 0, 0, paramnj.dBj.dBu, paramnj.dBj.field_favProto);
          break;
        }
        label338:
        localg.a(paramnj.dBj.field_localId, paramnj.dBj.context, Boolean.valueOf(paramnj.dBj.dBt), paramnj.dBj.dBm, 0, paramnj.dBj.dBu, null);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(14789, new Object[] { Integer.valueOf(4) });
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramnj.dBj.context;
        akd localakd = paramnj.dBj.field_favProto;
        Bundle localBundle = paramnj.dBj.dBq;
        boolean bool = paramnj.dBj.dBt;
        localObject = "";
        paramnj = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramnj = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.EyS = localBundle.getString("snslocalid");
          localg.EyT = localBundle.getString("notexml", "");
          localg.EyZ = localBundle.getString("snsthumbpath", "");
          localg.Eza = localBundle.getString("snsnotelinkxml", "");
        }
        localg.dBy = System.currentTimeMillis();
        localg.dBt = bool;
        localg.EyN = false;
        localg.EyW = ((String)localObject + ";" + paramnj + ";" + l);
        localg.an(localContext, 4);
        ba.ajF().ay(new g.1(localg, localakd));
        continue;
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new com.tencent.mm.plugin.wenote.model.g();
        ((com.tencent.mm.plugin.wenote.model.g)localObject).EyQ = com.tencent.mm.plugin.wenote.b.b.a(paramnj.dBj);
        ((com.tencent.mm.plugin.wenote.model.g)localObject).EyR = 1;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).dBy = paramnj.dBj.field_localId;
        com.tencent.mm.plugin.wenote.model.c.eWI().EyD = ((d)localObject);
        paramnj = paramnj.dBj.context;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).EyN = true;
        ((com.tencent.mm.plugin.wenote.model.g)localObject).an(paramnj, 2);
        continue;
        paramnj.dBk.path = ao.cvC();
        continue;
        switch (paramnj.dBj.dBr)
        {
        default: 
          break;
        case 2: 
          h.aM(paramnj.dBj.lh);
          break;
        case 4: 
          h.q(paramnj.dBj.context, paramnj.dBj.path, paramnj.dBj.dBs);
          break;
        case 5: 
          h.aKf(paramnj.dBj.path);
          break;
        case 3: 
          try
          {
            h.aKg(paramnj.dBj.dBn);
          }
          catch (JSONException paramnj)
          {
            ad.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramnj, "", new Object[0]);
          }
          continue;
          h.bG(paramnj.dBj.context, paramnj.dBj.path);
          continue;
          f.I(paramnj.dBj.field_localId, paramnj.dBj.path);
          continue;
          f.aL(paramnj.dBj.lh);
          continue;
          paramnj = new gt((byte)0);
          com.tencent.mm.sdk.b.a.IbL.l(paramnj);
          paramnj = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU();
          ba.ajF().n(new c.1(paramnj), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */