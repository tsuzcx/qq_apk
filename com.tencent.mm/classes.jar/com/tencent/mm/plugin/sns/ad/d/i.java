package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.appbrand.ui.au;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static Map<String, Boolean> PNR;
  
  static
  {
    AppMethodBeat.i(309962);
    PNR = new HashMap();
    AppMethodBeat.o(309962);
  }
  
  public static void a(String paramString, ImageView paramImageView, ADInfo paramADInfo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(309948);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("AdWeAppHelper", "refreshWeAppAuthIcon, weAppUserName==null");
      AppMethodBeat.o(309948);
      return;
    }
    paramImageView.setTag(paramString);
    boolean bool1;
    boolean bool3;
    if (((c)h.ax(c.class)).a(c.a.znj, 0) == 1)
    {
      bool1 = true;
      bool3 = aWm(paramString);
      paramADInfo.forbiddenShowRelievedBuy = true;
      if ((paramADInfo.forbiddenShowRelievedBuy) || (!bool1) || (!bool3)) {
        break label179;
      }
      label83:
      if (!bool2) {
        break label185;
      }
      paramImageView.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        PNR.put(paramString, Boolean.valueOf(bool2));
        Log.i("AdWeAppHelper", "refreshWeAppGuaranteeAuthIcon, isExptShow=" + bool1 + ", isForbid=" + paramADInfo.forbiddenShowRelievedBuy + ", cache=" + bool3);
        if (!paramADInfo.forbiddenShowRelievedBuy) {}
        return;
      }
      finally
      {
        label179:
        label185:
        AppMethodBeat.o(309948);
      }
      bool1 = false;
      break;
      bool2 = false;
      break label83;
      if (paramImageView.getVisibility() == 0) {
        paramImageView.setVisibility(4);
      }
    }
  }
  
  public static boolean aWm(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(309952);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(309952);
          return bool;
        }
        if (PNR.containsKey(paramString))
        {
          bool = ((Boolean)PNR.get(paramString)).booleanValue();
          AppMethodBeat.o(309952);
        }
        else
        {
          AppMethodBeat.o(309952);
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.i
 * JD-Core Version:    0.7.0.1
 */