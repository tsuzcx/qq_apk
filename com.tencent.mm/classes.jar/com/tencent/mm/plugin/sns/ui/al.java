package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class al
{
  public static int a(Context paramContext, ba paramba)
  {
    AppMethodBeat.i(98140);
    if (paramba == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (paramba.nEf == 6)
    {
      if (paramba.FsA == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (paramba.Fsy == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.iRH.s(paramContext, paramba.Fsy.iht))
      {
        i = paramba.FsA.FvX;
        AppMethodBeat.o(98140);
        return i;
      }
      i = paramba.FsA.FvY;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = paramba.Scene;
    AppMethodBeat.o(98140);
    return i;
  }
  
  public static void a(Context paramContext, bi parambi, ba paramba)
  {
    AppMethodBeat.i(98141);
    if ((paramba != null) && (paramba.Fsy != null))
    {
      Object localObject = paramba.Fsy.iht;
      boolean bool;
      if (bt.isNullOrNil((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label465;
        }
        parambi.Anq = false;
        if ((paramba.FsC == null) || (paramba.FsD == null)) {
          break label291;
        }
        if (!a.iRH.s(paramContext, paramba.Fsy.iht)) {
          break label247;
        }
        paramContext = paramba.FsC;
        label84:
        localObject = ac.fks();
        if (!((String)localObject).equals("zh_CN")) {
          break label255;
        }
        paramContext = paramContext.Fwo;
        label104:
        switch (paramba.nEf)
        {
        default: 
          parambi.Anq = false;
        }
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramContext))
        {
          ad.e("MicroMsg.OpenActionContent", "text can not load ?");
          parambi.Anq = false;
        }
        AppMethodBeat.o(98141);
        return;
        localObject = h.m((String)localObject, true, false);
        if ((localObject == null) || (bt.isNullOrNil(((g)localObject).field_appId)))
        {
          bool = false;
          break;
        }
        if ((((g)localObject).field_appInfoFlag & 0x20) > 0) {}
        for (bool = true;; bool = false)
        {
          ad.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { ((g)localObject).field_appId, Boolean.valueOf(bool) });
          break;
        }
        label247:
        paramContext = paramba.FsD;
        break label84;
        label255:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.Fwp;
          break label104;
        }
        paramContext = paramContext.Fwn;
        break label104;
        label291:
        if (paramba == null) {
          localObject = "";
        }
        for (;;)
        {
          try
          {
            if (bt.isNullOrNil((String)localObject)) {
              continue;
            }
            int i = paramContext.getResources().getIdentifier((String)localObject, "string", paramContext.getPackageName());
            if (i <= 0) {
              continue;
            }
            paramContext = paramContext.getString(i);
          }
          catch (Exception paramContext)
          {
            paramContext = "";
          }
          if (paramba.nEf == 6)
          {
            if (paramba.FsB == null) {
              localObject = "";
            } else if (a.iRH.s(paramContext, paramba.Fsy.iht)) {
              localObject = paramba.FsB.Fwq;
            } else {
              localObject = paramba.FsB.Fwr;
            }
          }
          else {
            localObject = paramba.Fsz;
          }
        }
        break label104;
        parambi.Ans = paramContext;
        parambi.Anq = true;
        continue;
        if (paramba.Scene == 1)
        {
          parambi.Ans = paramContext;
          parambi.Anq = true;
          continue;
          parambi.Ans = paramContext;
          parambi.Anq = true;
        }
      }
    }
    label465:
    parambi.Anq = false;
    AppMethodBeat.o(98141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al
 * JD-Core Version:    0.7.0.1
 */