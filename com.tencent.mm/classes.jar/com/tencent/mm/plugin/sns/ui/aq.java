package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class aq
{
  private static String a(Context paramContext, bc parambc)
  {
    AppMethodBeat.i(194965);
    if (parambc == null)
    {
      AppMethodBeat.o(194965);
      return "";
    }
    if (parambc.rWu == 6)
    {
      if (parambc.RFR == null)
      {
        AppMethodBeat.o(194965);
        return "";
      }
      if (a.mIH.u(paramContext, parambc.RFO.lVG))
      {
        paramContext = parambc.RFR.RJN;
        AppMethodBeat.o(194965);
        return paramContext;
      }
      paramContext = parambc.RFR.RJO;
      AppMethodBeat.o(194965);
      return paramContext;
    }
    paramContext = parambc.RFP;
    AppMethodBeat.o(194965);
    return paramContext;
  }
  
  public static void a(Context paramContext, bn parambn, bc parambc)
  {
    AppMethodBeat.i(98141);
    String str2;
    String str1;
    if ((parambc != null) && (parambc.RFO != null) && (h.bpV(parambc.RFO.lVG)))
    {
      parambn.Lcb = false;
      str2 = "";
      if ((parambc.RFS != null) && (parambc.RFT != null)) {
        if (a.mIH.u(paramContext, parambc.RFO.lVG))
        {
          paramContext = parambc.RFS;
          str1 = LocaleUtil.getApplicationLanguage();
          if (!str1.equals("zh_CN")) {
            break label167;
          }
          str1 = paramContext.RJL;
        }
      }
    }
    for (;;)
    {
      label97:
      switch (parambc.rWu)
      {
      default: 
        parambn.Lcb = false;
      }
      for (;;)
      {
        for (;;)
        {
          if (Util.isNullOrNil(str1))
          {
            Log.e("MicroMsg.OpenActionContent", "text can not load ?");
            parambn.Lcb = false;
          }
          AppMethodBeat.o(98141);
          return;
          paramContext = parambc.RFT;
          break;
          label167:
          if ((str1.equals("zh_TW")) || (str1.equals("zh_HK")))
          {
            str1 = paramContext.RJM;
            break label97;
          }
          str1 = paramContext.RJK;
          break label97;
          String str3 = a(paramContext, parambc);
          str1 = str2;
          try
          {
            if (Util.isNullOrNil(str3)) {
              break label97;
            }
            int i = paramContext.getResources().getIdentifier(str3, "string", paramContext.getPackageName());
            str1 = str2;
            if (i <= 0) {
              break label97;
            }
            str1 = paramContext.getString(i);
          }
          catch (Exception paramContext)
          {
            str1 = str2;
          }
        }
        parambn.Lcc = str1;
        parambn.Lcb = true;
        continue;
        if (parambc.CPw == 1)
        {
          parambn.Lcc = str1;
          parambn.Lcb = true;
          continue;
          parambn.Lcc = str1;
          parambn.Lcb = true;
        }
      }
      parambn.Lcb = false;
      AppMethodBeat.o(98141);
      return;
    }
  }
  
  public static int b(Context paramContext, bc parambc)
  {
    AppMethodBeat.i(98140);
    if (parambc == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (parambc.rWu == 6)
    {
      if (parambc.RFQ == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (parambc.RFO == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.mIH.u(paramContext, parambc.RFO.lVG))
      {
        i = parambc.RFQ.RJt;
        AppMethodBeat.o(98140);
        return i;
      }
      i = parambc.RFQ.RJu;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = parambc.CPw;
    AppMethodBeat.o(98140);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */