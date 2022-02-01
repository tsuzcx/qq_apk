package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class ai
{
  public static int a(Context paramContext, ay paramay)
  {
    AppMethodBeat.i(98140);
    if (paramay == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (paramay.mBH == 6)
    {
      if (paramay.Cva == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (paramay.CuY == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.hYu.t(paramContext, paramay.CuY.hnC))
      {
        i = paramay.Cva.Cym;
        AppMethodBeat.o(98140);
        return i;
      }
      i = paramay.Cva.Cyn;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = paramay.Scene;
    AppMethodBeat.o(98140);
    return i;
  }
  
  public static void a(Context paramContext, bf parambf, ay paramay)
  {
    AppMethodBeat.i(98141);
    if ((paramay != null) && (paramay.CuY != null))
    {
      Object localObject = paramay.CuY.hnC;
      boolean bool;
      if (bt.isNullOrNil((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label465;
        }
        parambf.xIR = false;
        if ((paramay.Cvc == null) || (paramay.Cvd == null)) {
          break label291;
        }
        if (!a.hYu.t(paramContext, paramay.CuY.hnC)) {
          break label247;
        }
        paramContext = paramay.Cvc;
        label84:
        localObject = ac.eFu();
        if (!((String)localObject).equals("zh_CN")) {
          break label255;
        }
        paramContext = paramContext.CyA;
        label104:
        switch (paramay.mBH)
        {
        default: 
          parambf.xIR = false;
        }
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramContext))
        {
          ad.e("MicroMsg.OpenActionContent", "text can not load ?");
          parambf.xIR = false;
        }
        AppMethodBeat.o(98141);
        return;
        localObject = h.j((String)localObject, true, false);
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
        paramContext = paramay.Cvd;
        break label84;
        label255:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.CyB;
          break label104;
        }
        paramContext = paramContext.Cyz;
        break label104;
        label291:
        if (paramay == null) {
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
          if (paramay.mBH == 6)
          {
            if (paramay.Cvb == null) {
              localObject = "";
            } else if (a.hYu.t(paramContext, paramay.CuY.hnC)) {
              localObject = paramay.Cvb.CyC;
            } else {
              localObject = paramay.Cvb.CyD;
            }
          }
          else {
            localObject = paramay.CuZ;
          }
        }
        break label104;
        parambf.xIS = paramContext;
        parambf.xIR = true;
        continue;
        if (paramay.Scene == 1)
        {
          parambf.xIS = paramContext;
          parambf.xIR = true;
          continue;
          parambf.xIS = paramContext;
          parambf.xIR = true;
        }
      }
    }
    label465:
    parambf.xIR = false;
    AppMethodBeat.o(98141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */