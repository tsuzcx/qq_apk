package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class ai
{
  public static int a(Context paramContext, ba paramba)
  {
    AppMethodBeat.i(98140);
    if (paramba == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (paramba.ndI == 6)
    {
      if (paramba.DNv == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (paramba.DNt == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.iyy.t(paramContext, paramba.DNt.hOf))
      {
        i = paramba.DNv.DQI;
        AppMethodBeat.o(98140);
        return i;
      }
      i = paramba.DNv.DQJ;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = paramba.Scene;
    AppMethodBeat.o(98140);
    return i;
  }
  
  public static void a(Context paramContext, bf parambf, ba paramba)
  {
    AppMethodBeat.i(98141);
    if ((paramba != null) && (paramba.DNt != null))
    {
      Object localObject = paramba.DNt.hOf;
      boolean bool;
      if (bs.isNullOrNil((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label465;
        }
        parambf.yVH = false;
        if ((paramba.DNx == null) || (paramba.DNy == null)) {
          break label291;
        }
        if (!a.iyy.t(paramContext, paramba.DNt.hOf)) {
          break label247;
        }
        paramContext = paramba.DNx;
        label84:
        localObject = ab.eUO();
        if (!((String)localObject).equals("zh_CN")) {
          break label255;
        }
        paramContext = paramContext.DQW;
        label104:
        switch (paramba.ndI)
        {
        default: 
          parambf.yVH = false;
        }
      }
      for (;;)
      {
        if (bs.isNullOrNil(paramContext))
        {
          ac.e("MicroMsg.OpenActionContent", "text can not load ?");
          parambf.yVH = false;
        }
        AppMethodBeat.o(98141);
        return;
        localObject = h.k((String)localObject, true, false);
        if ((localObject == null) || (bs.isNullOrNil(((g)localObject).field_appId)))
        {
          bool = false;
          break;
        }
        if ((((g)localObject).field_appInfoFlag & 0x20) > 0) {}
        for (bool = true;; bool = false)
        {
          ac.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { ((g)localObject).field_appId, Boolean.valueOf(bool) });
          break;
        }
        label247:
        paramContext = paramba.DNy;
        break label84;
        label255:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.DQX;
          break label104;
        }
        paramContext = paramContext.DQV;
        break label104;
        label291:
        if (paramba == null) {
          localObject = "";
        }
        for (;;)
        {
          try
          {
            if (bs.isNullOrNil((String)localObject)) {
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
          if (paramba.ndI == 6)
          {
            if (paramba.DNw == null) {
              localObject = "";
            } else if (a.iyy.t(paramContext, paramba.DNt.hOf)) {
              localObject = paramba.DNw.DQY;
            } else {
              localObject = paramba.DNw.DQZ;
            }
          }
          else {
            localObject = paramba.DNu;
          }
        }
        break label104;
        parambf.yVI = paramContext;
        parambf.yVH = true;
        continue;
        if (paramba.Scene == 1)
        {
          parambf.yVI = paramContext;
          parambf.yVH = true;
          continue;
          parambf.yVI = paramContext;
          parambf.yVH = true;
        }
      }
    }
    label465:
    parambf.yVH = false;
    AppMethodBeat.o(98141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */