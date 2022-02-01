package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ao
{
  private static String a(Context paramContext, be parambe)
  {
    AppMethodBeat.i(203353);
    if (parambe == null)
    {
      AppMethodBeat.o(203353);
      return "";
    }
    if (parambe.oUv == 6)
    {
      if (parambe.KEz == null)
      {
        AppMethodBeat.o(203353);
        return "";
      }
      if (a.jRu.s(paramContext, parambe.KEw.jfi))
      {
        paramContext = parambe.KEz.KIw;
        AppMethodBeat.o(203353);
        return paramContext;
      }
      paramContext = parambe.KEz.KIx;
      AppMethodBeat.o(203353);
      return paramContext;
    }
    paramContext = parambe.KEx;
    AppMethodBeat.o(203353);
    return paramContext;
  }
  
  public static void a(Context paramContext, bl parambl, be parambe)
  {
    AppMethodBeat.i(98141);
    String str2;
    String str1;
    if ((parambe != null) && (parambe.KEw != null) && (h.bdA(parambe.KEw.jfi)))
    {
      parambl.EOf = false;
      str2 = "";
      if ((parambe.KEA != null) && (parambe.KEB != null)) {
        if (a.jRu.s(paramContext, parambe.KEw.jfi))
        {
          paramContext = parambe.KEA;
          str1 = LocaleUtil.getApplicationLanguage();
          if (!str1.equals("zh_CN")) {
            break label167;
          }
          str1 = paramContext.KIu;
        }
      }
    }
    for (;;)
    {
      label97:
      switch (parambe.oUv)
      {
      default: 
        parambl.EOf = false;
      }
      for (;;)
      {
        for (;;)
        {
          if (Util.isNullOrNil(str1))
          {
            Log.e("MicroMsg.OpenActionContent", "text can not load ?");
            parambl.EOf = false;
          }
          AppMethodBeat.o(98141);
          return;
          paramContext = parambe.KEB;
          break;
          label167:
          if ((str1.equals("zh_TW")) || (str1.equals("zh_HK")))
          {
            str1 = paramContext.KIv;
            break label97;
          }
          str1 = paramContext.KIt;
          break label97;
          String str3 = a(paramContext, parambe);
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
        parambl.EOg = str1;
        parambl.EOf = true;
        continue;
        if (parambe.Scene == 1)
        {
          parambl.EOg = str1;
          parambl.EOf = true;
          continue;
          parambl.EOg = str1;
          parambl.EOf = true;
        }
      }
      parambl.EOf = false;
      AppMethodBeat.o(98141);
      return;
    }
  }
  
  public static int b(Context paramContext, be parambe)
  {
    AppMethodBeat.i(98140);
    if (parambe == null)
    {
      AppMethodBeat.o(98140);
      return 0;
    }
    if (parambe.oUv == 6)
    {
      if (parambe.KEy == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (parambe.KEw == null)
      {
        AppMethodBeat.o(98140);
        return 0;
      }
      if (a.jRu.s(paramContext, parambe.KEw.jfi))
      {
        i = parambe.KEy.KIc;
        AppMethodBeat.o(98140);
        return i;
      }
      i = parambe.KEy.KIe;
      AppMethodBeat.o(98140);
      return i;
    }
    int i = parambe.Scene;
    AppMethodBeat.o(98140);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ao
 * JD-Core Version:    0.7.0.1
 */