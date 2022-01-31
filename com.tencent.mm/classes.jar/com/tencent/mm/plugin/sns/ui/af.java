package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class af
{
  public static int a(Context paramContext, av paramav)
  {
    if (paramav == null) {}
    do
    {
      return 0;
      if (paramav.hQR != 6) {
        break;
      }
    } while (paramav.sui == null);
    if (a.eUS.o(paramContext, paramav.sug.euK)) {
      return paramav.sui.swp;
    }
    return paramav.sui.swq;
    return paramav.pyo;
  }
  
  public static void a(Context paramContext, ax paramax, av paramav)
  {
    if ((paramav != null) && (paramav.sug != null))
    {
      Object localObject = paramav.sug.euK;
      boolean bool;
      if (bk.bl((String)localObject))
      {
        bool = false;
        if (!bool) {
          break label451;
        }
        paramax.phD = false;
        if ((paramav.suk == null) || (paramav.sul == null)) {
          break label277;
        }
        if (!a.eUS.o(paramContext, paramav.sug.euK)) {
          break label233;
        }
        paramContext = paramav.suk;
        label79:
        localObject = x.cqJ();
        if (!((String)localObject).equals("zh_CN")) {
          break label241;
        }
        paramContext = paramContext.swL;
        label99:
        switch (paramav.hQR)
        {
        default: 
          paramax.phD = false;
        }
      }
      for (;;)
      {
        if (bk.bl(paramContext))
        {
          y.e("MicroMsg.OpenActionContent", "text can not load ?");
          paramax.phD = false;
        }
        return;
        localObject = g.by((String)localObject, true);
        if ((localObject == null) || (bk.bl(((f)localObject).field_appId)))
        {
          bool = false;
          break;
        }
        if ((((f)localObject).field_appInfoFlag & 0x20) > 0) {}
        for (bool = true;; bool = false)
        {
          y.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { ((f)localObject).field_appId, Boolean.valueOf(bool) });
          break;
        }
        label233:
        paramContext = paramav.sul;
        break label79;
        label241:
        if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK")))
        {
          paramContext = paramContext.swM;
          break label99;
        }
        paramContext = paramContext.swK;
        break label99;
        label277:
        if (paramav == null) {
          localObject = "";
        }
        for (;;)
        {
          try
          {
            if (bk.bl((String)localObject)) {
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
          if (paramav.hQR == 6)
          {
            if (paramav.suj == null) {
              localObject = "";
            } else if (a.eUS.o(paramContext, paramav.sug.euK)) {
              localObject = paramav.suj.swN;
            } else {
              localObject = paramav.suj.swO;
            }
          }
          else {
            localObject = paramav.suh;
          }
        }
        break label99;
        paramax.phE = paramContext;
        paramax.phD = true;
        continue;
        if (paramav.pyo == 1)
        {
          paramax.phE = paramContext;
          paramax.phD = true;
          continue;
          paramax.phE = paramContext;
          paramax.phD = true;
        }
      }
    }
    label451:
    paramax.phD = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af
 * JD-Core Version:    0.7.0.1
 */