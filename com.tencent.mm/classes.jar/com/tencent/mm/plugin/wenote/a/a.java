package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<li>
{
  public a()
  {
    AppMethodBeat.i(26585);
    this.__eventId = li.class.getName().hashCode();
    AppMethodBeat.o(26585);
  }
  
  private static boolean a(li paramli)
  {
    AppMethodBeat.i(26586);
    g localg;
    label301:
    Context localContext;
    acq localacq;
    boolean bool;
    Object localObject;
    long l;
    switch (paramli.cBr.type)
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(26586);
        return false;
        com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.b(paramli);
        continue;
        localg = new g();
        com.tencent.mm.plugin.wenote.model.c.dhH().vvQ = localg;
        if (paramli.cBr.cBx == 4) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(14789, new Object[] { Integer.valueOf(1) });
        ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramli.cBr.cBx == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramli.cBr.field_favProto != null) && (paramli.cBr.field_favProto.wVa != null)) {
            localg.vwp = paramli.cBr.field_favProto.wVa.cpG;
          }
          if (paramli.cBr.cBw != null) {
            localg.vwq = paramli.cBr.cBw.getLong("edittime", 0L);
          }
          if (i == 0) {
            break label301;
          }
          localg.vwt = true;
          localg.a(paramli.cBr.field_localId, paramli.cBr.context, Boolean.valueOf(paramli.cBr.cBz), 0, 0, paramli.cBr.cBA, paramli.cBr.field_favProto);
          break;
        }
        localg.a(paramli.cBr.field_localId, paramli.cBr.context, Boolean.valueOf(paramli.cBr.cBz), 0, 0, paramli.cBr.cBA, null);
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(14789, new Object[] { Integer.valueOf(4) });
      ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
      localContext = paramli.cBr.context;
      localacq = paramli.cBr.field_favProto;
      Bundle localBundle = paramli.cBr.cBw;
      bool = paramli.cBr.cBz;
      localObject = "";
      paramli = "";
      if (localBundle != null)
      {
        localObject = localBundle.getString("noteauthor", "");
        paramli = localBundle.getString("noteeditor", "");
        l = localBundle.getLong("edittime", 0L);
        localg.vwj = localBundle.getString("snslocalid");
        localg.vwk = localBundle.getString("notexml", "");
        localg.vwr = localBundle.getString("snsthumbpath", "");
        localg.vws = localBundle.getString("snsnotelinkxml", "");
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localg.cBE = System.currentTimeMillis();
        localg.cBz = bool;
        localg.vwb = false;
        localg.vwo = ((String)localObject + ";" + paramli + ";" + l);
        localg.ae(localContext, 4);
        aw.RO().ac(new g.1(localg, localacq));
        break;
        ab.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
        localObject = new g();
        ((g)localObject).cBE = paramli.cBr.field_localId;
        com.tencent.mm.plugin.wenote.model.c.dhH().vvQ = ((d)localObject);
        paramli = paramli.cBr.context;
        ((g)localObject).vwb = true;
        ((g)localObject).ae(paramli, 2);
        break;
        paramli.cBs.path = an.bxa();
        break;
        switch (paramli.cBr.itemType)
        {
        default: 
          break;
        case 2: 
          com.tencent.mm.plugin.wenote.model.h.af(paramli.cBr.cBy);
          break;
        case 4: 
          com.tencent.mm.plugin.wenote.model.h.p(paramli.cBr.context, paramli.cBr.path, paramli.cBr.cBx);
          break;
        case 5: 
          com.tencent.mm.plugin.wenote.model.h.ajH(paramli.cBr.path);
          break;
        case 3: 
          try
          {
            com.tencent.mm.plugin.wenote.model.h.ajI(paramli.cBr.cBu);
          }
          catch (JSONException paramli)
          {
            ab.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramli, "", new Object[0]);
          }
        }
      }
      break;
      com.tencent.mm.plugin.wenote.model.h.bo(paramli.cBr.context, paramli.cBr.path);
      break;
      f.z(paramli.cBr.field_localId, paramli.cBr.path);
      break;
      f.ae(paramli.cBr.cBy);
      break;
      paramli = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din();
      aw.RO().o(new c.1(paramli), 700L);
      break;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */