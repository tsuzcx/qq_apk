package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<nb>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = nb.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(nb paramnb)
  {
    AppMethodBeat.i(30258);
    switch (paramnb.dpw.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.eHP().CUG.b(paramnb);
      continue;
      Object localObject = new gq((byte)0);
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      g localg = new g();
      localg.CUT = com.tencent.mm.plugin.wenote.b.b.a(paramnb.dpw);
      localg.CUU = 1;
      com.tencent.mm.plugin.wenote.model.c.eHP().CUG = localg;
      if (paramnb.dpw.dpF != 4)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14789, new Object[] { Integer.valueOf(1) });
        ac.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramnb.dpw.dpF == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramnb.dpw.field_favProto != null) && (paramnb.dpw.field_favProto.EBJ != null)) {
            localg.CVa = paramnb.dpw.field_favProto.EBJ.sourceType;
          }
          if (paramnb.dpw.dpD != null) {
            localg.CVb = paramnb.dpw.dpD.getLong("edittime", 0L);
          }
          if (i == 0) {
            break label338;
          }
          localg.CVe = true;
          localg.a(paramnb.dpw.field_localId, paramnb.dpw.context, Boolean.valueOf(paramnb.dpw.dpG), 0, 0, paramnb.dpw.dpH, paramnb.dpw.field_favProto);
          break;
        }
        label338:
        localg.a(paramnb.dpw.field_localId, paramnb.dpw.context, Boolean.valueOf(paramnb.dpw.dpG), paramnb.dpw.dpz, 0, paramnb.dpw.dpH, null);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14789, new Object[] { Integer.valueOf(4) });
        ac.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramnb.dpw.context;
        ahn localahn = paramnb.dpw.field_favProto;
        Bundle localBundle = paramnb.dpw.dpD;
        boolean bool = paramnb.dpw.dpG;
        localObject = "";
        paramnb = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramnb = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.CUV = localBundle.getString("snslocalid");
          localg.CUW = localBundle.getString("notexml", "");
          localg.CVc = localBundle.getString("snsthumbpath", "");
          localg.CVd = localBundle.getString("snsnotelinkxml", "");
        }
        localg.dpL = System.currentTimeMillis();
        localg.dpG = bool;
        localg.CUQ = false;
        localg.CUZ = ((String)localObject + ";" + paramnb + ";" + l);
        localg.ak(localContext, 4);
        az.agU().az(new g.1(localg, localahn));
        continue;
        ac.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).CUT = com.tencent.mm.plugin.wenote.b.b.a(paramnb.dpw);
        ((g)localObject).CUU = 1;
        ((g)localObject).dpL = paramnb.dpw.field_localId;
        com.tencent.mm.plugin.wenote.model.c.eHP().CUG = ((d)localObject);
        paramnb = paramnb.dpw.context;
        ((g)localObject).CUQ = true;
        ((g)localObject).ak(paramnb, 2);
        continue;
        paramnb.dpx.path = ao.cpX();
        continue;
        switch (paramnb.dpw.dpE)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.aP(paramnb.dpw.jq);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.q(paramnb.dpw.context, paramnb.dpw.path, paramnb.dpw.dpF);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.aEF(paramnb.dpw.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.aEG(paramnb.dpw.dpA);
          }
          catch (JSONException paramnb)
          {
            ac.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramnb, "", new Object[0]);
          }
          continue;
          com.tencent.mm.plugin.wenote.model.h.bC(paramnb.dpw.context, paramnb.dpw.path);
          continue;
          f.D(paramnb.dpw.field_localId, paramnb.dpw.path);
          continue;
          f.aO(paramnb.dpw.jq);
          continue;
          paramnb = new gq((byte)0);
          com.tencent.mm.sdk.b.a.GpY.l(paramnb);
          paramnb = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb();
          az.agU().m(new c.1(paramnb), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */