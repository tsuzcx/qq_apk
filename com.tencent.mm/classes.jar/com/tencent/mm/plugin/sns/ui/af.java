package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class af
{
  public static int a(Context paramContext, av paramav)
  {
    AppMethodBeat.i(38468);
    if (paramav == null)
    {
      AppMethodBeat.o(38468);
      return 0;
    }
    if (paramav.jKs == 6)
    {
      if (paramav.wmL == null)
      {
        AppMethodBeat.o(38468);
        return 0;
      }
      if (paramav.wmJ == null)
      {
        AppMethodBeat.o(38468);
        return 0;
      }
      if (a.gmP.u(paramContext, paramav.wmJ.fKw))
      {
        i = paramav.wmL.wpB;
        AppMethodBeat.o(38468);
        return i;
      }
      i = paramav.wmL.wpC;
      AppMethodBeat.o(38468);
      return i;
    }
    int i = paramav.Scene;
    AppMethodBeat.o(38468);
    return i;
  }
  
  public static void a(Context paramContext, aw paramaw, av paramav)
  {
    AppMethodBeat.i(38469);
    if ((paramav != null) && (paramav.wmJ != null))
    {
      Object localObject = paramav.wmJ.fKw;
      boolean bool;
      if (bo.isNullOrNil((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label464;
        }
        paramaw.sak = false;
        if ((paramav.wmN == null) || (paramav.wmO == null)) {
          break label290;
        }
        if (!a.gmP.u(paramContext, paramav.wmJ.fKw)) {
          break label246;
        }
        paramContext = paramav.wmN;
        label84:
        localObject = aa.dsG();
        if (!((String)localObject).equals("zh_CN")) {
          break label254;
        }
        paramContext = paramContext.wpN;
        label104:
        switch (paramav.jKs)
        {
        default: 
          paramaw.sak = false;
        }
      }
      for (;;)
      {
        if (bo.isNullOrNil(paramContext))
        {
          ab.e("MicroMsg.OpenActionContent", "text can not load ?");
          paramaw.sak = false;
        }
        AppMethodBeat.o(38469);
        return;
        localObject = g.ca((String)localObject, true);
        if ((localObject == null) || (bo.isNullOrNil(((f)localObject).field_appId)))
        {
          bool = false;
          break;
        }
        if ((((f)localObject).field_appInfoFlag & 0x20) > 0) {}
        for (bool = true;; bool = false)
        {
          ab.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { ((f)localObject).field_appId, Boolean.valueOf(bool) });
          break;
        }
        label246:
        paramContext = paramav.wmO;
        break label84;
        label254:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.wpO;
          break label104;
        }
        paramContext = paramContext.wpM;
        break label104;
        label290:
        if (paramav == null) {
          localObject = "";
        }
        for (;;)
        {
          try
          {
            if (bo.isNullOrNil((String)localObject)) {
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
          if (paramav.jKs == 6)
          {
            if (paramav.wmM == null) {
              localObject = "";
            } else if (a.gmP.u(paramContext, paramav.wmJ.fKw)) {
              localObject = paramav.wmM.wpP;
            } else {
              localObject = paramav.wmM.wpQ;
            }
          }
          else {
            localObject = paramav.wmK;
          }
        }
        break label104;
        paramaw.sal = paramContext;
        paramaw.sak = true;
        continue;
        if (paramav.Scene == 1)
        {
          paramaw.sal = paramContext;
          paramaw.sak = true;
          continue;
          paramaw.sal = paramContext;
          paramaw.sak = true;
        }
      }
    }
    label464:
    paramaw.sak = false;
    AppMethodBeat.o(38469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */