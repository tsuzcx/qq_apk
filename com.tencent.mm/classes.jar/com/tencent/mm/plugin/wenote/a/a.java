package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.h.a.ku.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.1;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;

public final class a
  extends com.tencent.mm.sdk.b.c<ku>
{
  public a()
  {
    this.udX = ku.class.getName().hashCode();
  }
  
  private static boolean a(ku paramku)
  {
    g localg;
    Context localContext;
    yj localyj;
    boolean bool;
    Object localObject;
    long l;
    switch (paramku.bTL.type)
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return false;
    case 0: 
      com.tencent.mm.plugin.wenote.model.c.chu().rFh.b(paramku);
      return false;
    case 2: 
      localg = new g();
      com.tencent.mm.plugin.wenote.model.c.chu().rFh = localg;
      if (paramku.bTL.bTR != 4)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14789, new Object[] { Integer.valueOf(1) });
        y.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
        if (paramku.bTL.bTR == 5) {}
        for (int i = 1;; i = 0)
        {
          if ((paramku.bTL.field_favProto != null) && (paramku.bTL.field_favProto.sXa != null)) {
            localg.rFG = paramku.bTL.field_favProto.sXa.bIl;
          }
          if (paramku.bTL.bTQ != null) {
            localg.rFH = paramku.bTL.bTQ.getLong("edittime", 0L);
          }
          if (i == 0) {
            break;
          }
          localg.rFK = true;
          localg.a(paramku.bTL.field_localId, paramku.bTL.context, Boolean.valueOf(paramku.bTL.bTT), 0, 0, paramku.bTL.bTU, paramku.bTL.field_favProto);
          return false;
        }
        localg.a(paramku.bTL.field_localId, paramku.bTL.context, Boolean.valueOf(paramku.bTL.bTT), 0, 0, paramku.bTL.bTU, null);
        return false;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(14789, new Object[] { Integer.valueOf(4) });
      y.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
      localContext = paramku.bTL.context;
      localyj = paramku.bTL.field_favProto;
      Bundle localBundle = paramku.bTL.bTQ;
      bool = paramku.bTL.bTT;
      localObject = "";
      paramku = "";
      if (localBundle != null)
      {
        localObject = localBundle.getString("noteauthor", "");
        paramku = localBundle.getString("noteeditor", "");
        l = localBundle.getLong("edittime", 0L);
        localg.rFA = localBundle.getString("snslocalid");
        localg.rFB = localBundle.getString("notexml", "");
        localg.rFI = localBundle.getString("snsthumbpath", "");
        localg.rFJ = localBundle.getString("snsnotelinkxml", "");
      }
      break;
    }
    for (;;)
    {
      localg.bTZ = System.currentTimeMillis();
      localg.bTT = bool;
      localg.rFs = false;
      localg.rFF = ((String)localObject + ";" + paramku + ";" + l);
      localg.P(localContext, 4);
      au.DS().O(new g.1(localg, localyj));
      return false;
      y.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
      localObject = new g();
      ((g)localObject).bTZ = paramku.bTL.field_localId;
      com.tencent.mm.plugin.wenote.model.c.chu().rFh = ((d)localObject);
      paramku = paramku.bTL.context;
      ((g)localObject).rFs = true;
      ((g)localObject).P(paramku, 2);
      return false;
      paramku.bTM.path = an.aQL();
      return false;
      switch (paramku.bTL.itemType)
      {
      default: 
        return false;
      case 2: 
        com.tencent.mm.plugin.wenote.model.h.Z(paramku.bTL.bTS);
        return false;
      case 4: 
        com.tencent.mm.plugin.wenote.model.h.k(paramku.bTL.context, paramku.bTL.path, paramku.bTL.bTR);
        return false;
      case 5: 
        com.tencent.mm.plugin.wenote.model.h.Ut(paramku.bTL.path);
        return false;
      }
      try
      {
        com.tencent.mm.plugin.wenote.model.h.Uu(paramku.bTL.bTO);
        return false;
      }
      catch (JSONException paramku)
      {
        y.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", paramku, "", new Object[0]);
        return false;
      }
      com.tencent.mm.plugin.wenote.model.h.bc(paramku.bTL.context, paramku.bTL.path);
      return false;
      f.y(paramku.bTL.field_localId, paramku.bTL.path);
      return false;
      f.Y(paramku.bTL.bTS);
      return false;
      paramku = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX();
      au.DS().k(new c.1(paramku), 700L);
      return false;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */