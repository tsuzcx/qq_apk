package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ar
{
  private static String a(Context paramContext, bh parambh)
  {
    AppMethodBeat.i(308432);
    if (parambh == null)
    {
      AppMethodBeat.o(308432);
      return "";
    }
    if (parambh.vhJ == 6)
    {
      if (parambh.YCF == null)
      {
        AppMethodBeat.o(308432);
        return "";
      }
      if (a.pFo.y(paramContext, parambh.YCC.oOI))
      {
        paramContext = parambh.YCF.YHh;
        AppMethodBeat.o(308432);
        return paramContext;
      }
      paramContext = parambh.YCF.YHi;
      AppMethodBeat.o(308432);
      return paramContext;
    }
    paramContext = parambh.YCD;
    AppMethodBeat.o(308432);
    return paramContext;
  }
  
  public static void a(Context paramContext, bo parambo, bh parambh)
  {
    AppMethodBeat.i(98141);
    String str2;
    String str1;
    if ((parambh != null) && (parambh.YCC != null) && (h.bpL(parambh.YCC.oOI)))
    {
      parambo.RCf = false;
      str2 = "";
      if ((parambh.YCG != null) && (parambh.YCH != null)) {
        if (a.pFo.y(paramContext, parambh.YCC.oOI))
        {
          paramContext = parambh.YCG;
          str1 = LocaleUtil.getApplicationLanguage();
          if (!str1.equals("zh_CN")) {
            break label167;
          }
          str1 = paramContext.YHf;
        }
      }
    }
    for (;;)
    {
      label97:
      switch (parambh.vhJ)
      {
      default: 
        parambo.RCf = false;
      }
      for (;;)
      {
        for (;;)
        {
          if (Util.isNullOrNil(str1))
          {
            Log.e("MicroMsg.OpenActionContent", "text can not load ?");
            parambo.RCf = false;
          }
          AppMethodBeat.o(98141);
          return;
          paramContext = parambh.YCH;
          break;
          label167:
          if ((str1.equals("zh_TW")) || (str1.equals("zh_HK")))
          {
            str1 = paramContext.YHg;
            break label97;
          }
          str1 = paramContext.YHe;
          break label97;
          String str3 = a(paramContext, parambh);
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
        parambo.RCg = str1;
        parambo.RCf = true;
        continue;
        if (parambh.IJG == 1)
        {
          parambo.RCg = str1;
          parambo.RCf = true;
          continue;
          parambo.RCg = str1;
          parambo.RCf = true;
        }
      }
      parambo.RCf = false;
      AppMethodBeat.o(98141);
      return;
    }
  }
  
  public static int b(Context paramContext, bh parambh)
  {
    AppMethodBeat.i(98140);
    if (parambh == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (parambh.vhJ == 6)
    {
      if (parambh.YCE == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (parambh.YCC == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.pFo.y(paramContext, parambh.YCC.oOI))
      {
        i = parambh.YCE.YGN;
        AppMethodBeat.o(98140);
        return i;
      }
      i = parambh.YCE.YGO;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = parambh.IJG;
    AppMethodBeat.o(98140);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */