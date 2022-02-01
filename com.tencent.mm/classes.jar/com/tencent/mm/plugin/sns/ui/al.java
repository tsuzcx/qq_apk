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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
    if (paramba.nJA == 6)
    {
      if (paramba.FKY == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (paramba.FKW == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.iUA.s(paramContext, paramba.FKW.ikm))
      {
        i = paramba.FKY.FOv;
        AppMethodBeat.o(98140);
        return i;
      }
      i = paramba.FKY.FOw;
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
    if ((paramba != null) && (paramba.FKW != null))
    {
      Object localObject = paramba.FKW.ikm;
      boolean bool;
      if (bu.isNullOrNil((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label465;
        }
        parambi.AEE = false;
        if ((paramba.FLa == null) || (paramba.FLb == null)) {
          break label291;
        }
        if (!a.iUA.s(paramContext, paramba.FKW.ikm)) {
          break label247;
        }
        paramContext = paramba.FLa;
        label84:
        localObject = ad.fom();
        if (!((String)localObject).equals("zh_CN")) {
          break label255;
        }
        paramContext = paramContext.FOM;
        label104:
        switch (paramba.nJA)
        {
        default: 
          parambi.AEE = false;
        }
      }
      for (;;)
      {
        if (bu.isNullOrNil(paramContext))
        {
          ae.e("MicroMsg.OpenActionContent", "text can not load ?");
          parambi.AEE = false;
        }
        AppMethodBeat.o(98141);
        return;
        localObject = h.m((String)localObject, true, false);
        if ((localObject == null) || (bu.isNullOrNil(((g)localObject).field_appId)))
        {
          bool = false;
          break;
        }
        if ((((g)localObject).field_appInfoFlag & 0x20) > 0) {}
        for (bool = true;; bool = false)
        {
          ae.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { ((g)localObject).field_appId, Boolean.valueOf(bool) });
          break;
        }
        label247:
        paramContext = paramba.FLb;
        break label84;
        label255:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.FON;
          break label104;
        }
        paramContext = paramContext.FOL;
        break label104;
        label291:
        if (paramba == null) {
          localObject = "";
        }
        for (;;)
        {
          try
          {
            if (bu.isNullOrNil((String)localObject)) {
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
          if (paramba.nJA == 6)
          {
            if (paramba.FKZ == null) {
              localObject = "";
            } else if (a.iUA.s(paramContext, paramba.FKW.ikm)) {
              localObject = paramba.FKZ.FOO;
            } else {
              localObject = paramba.FKZ.FOP;
            }
          }
          else {
            localObject = paramba.FKX;
          }
        }
        break label104;
        parambi.AEF = paramContext;
        parambi.AEE = true;
        continue;
        if (paramba.Scene == 1)
        {
          parambi.AEF = paramContext;
          parambi.AEE = true;
          continue;
          parambi.AEF = paramContext;
          parambi.AEE = true;
        }
      }
    }
    label465:
    parambi.AEE = false;
    AppMethodBeat.o(98141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al
 * JD-Core Version:    0.7.0.1
 */