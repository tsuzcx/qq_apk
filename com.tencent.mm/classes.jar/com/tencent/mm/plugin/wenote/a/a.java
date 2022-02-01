package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.ms.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<ms>
{
  public a()
  {
    AppMethodBeat.i(161476);
    this.__eventId = ms.class.getName().hashCode();
    AppMethodBeat.o(161476);
  }
  
  private static boolean a(ms paramms)
  {
    AppMethodBeat.i(30258);
    switch (paramms.drL.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30258);
      return false;
      com.tencent.mm.plugin.wenote.model.c.esw().BCA.b(paramms);
      continue;
      Object localObject = new gp((byte)0);
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      g localg = new g();
      localg.BCN = com.tencent.mm.plugin.wenote.b.b.a(paramms.drL);
      localg.BCO = 1;
      com.tencent.mm.plugin.wenote.model.c.esw().BCA = localg;
      if (paramms.drL.drU != 4)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(14789, new Object[] { Integer.valueOf(1) });
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramms.drL.drU == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramms.drL.field_favProto != null) && (paramms.drL.field_favProto.DiD != null)) {
            localg.BCU = paramms.drL.field_favProto.DiD.sourceType;
          }
          if (paramms.drL.drS != null) {
            localg.BCV = paramms.drL.drS.getLong("edittime", 0L);
          }
          if (i == 0) {
            break label338;
          }
          localg.BCY = true;
          localg.a(paramms.drL.field_localId, paramms.drL.context, Boolean.valueOf(paramms.drL.drV), 0, 0, paramms.drL.drW, paramms.drL.field_favProto);
          break;
        }
        label338:
        localg.a(paramms.drL.field_localId, paramms.drL.context, Boolean.valueOf(paramms.drL.drV), paramms.drL.drO, 0, paramms.drL.drW, null);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(14789, new Object[] { Integer.valueOf(4) });
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
        Context localContext = paramms.drL.context;
        ago localago = paramms.drL.field_favProto;
        Bundle localBundle = paramms.drL.drS;
        boolean bool = paramms.drL.drV;
        localObject = "";
        paramms = "";
        long l = 0L;
        if (localBundle != null)
        {
          localObject = localBundle.getString("noteauthor", "");
          paramms = localBundle.getString("noteeditor", "");
          l = localBundle.getLong("edittime", 0L);
          localg.BCP = localBundle.getString("snslocalid");
          localg.BCQ = localBundle.getString("notexml", "");
          localg.BCW = localBundle.getString("snsthumbpath", "");
          localg.BCX = localBundle.getString("snsnotelinkxml", "");
        }
        localg.dsa = System.currentTimeMillis();
        localg.drV = bool;
        localg.BCK = false;
        localg.BCT = ((String)localObject + ";" + paramms + ";" + l);
        localg.ae(localContext, 4);
        az.afE().ax(new g.1(localg, localago));
        continue;
        ad.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).BCN = com.tencent.mm.plugin.wenote.b.b.a(paramms.drL);
        ((g)localObject).BCO = 1;
        ((g)localObject).dsa = paramms.drL.field_localId;
        com.tencent.mm.plugin.wenote.model.c.esw().BCA = ((d)localObject);
        paramms = paramms.drL.context;
        ((g)localObject).BCK = true;
        ((g)localObject).ae(paramms, 2);
        continue;
        paramms.drM.path = ao.ciq();
        continue;
        switch (paramms.drL.drT)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.aD(paramms.drL.iq);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.q(paramms.drL.context, paramms.drL.path, paramms.drL.drU);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.azo(paramms.drL.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.azp(paramms.drL.drP);
          }
          catch (JSONException paramms)
          {
            ad.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramms, "", new Object[0]);
          }
          continue;
          com.tencent.mm.plugin.wenote.model.h.bB(paramms.drL.context, paramms.drL.path);
          continue;
          f.F(paramms.drL.field_localId, paramms.drL.path);
          continue;
          f.aC(paramms.drL.iq);
          continue;
          paramms = new gp((byte)0);
          com.tencent.mm.sdk.b.a.ESL.l(paramms);
          paramms = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI();
          az.afE().m(new c.1(paramms), 700L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */