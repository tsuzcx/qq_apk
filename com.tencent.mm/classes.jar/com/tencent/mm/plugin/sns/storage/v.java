package com.tencent.mm.plugin.sns.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class v
{
  public static boolean Zq(String paramString)
  {
    AppMethodBeat.i(38020);
    if ((paramString != null) && (paramString.startsWith("sns_table_")))
    {
      AppMethodBeat.o(38020);
      return true;
    }
    AppMethodBeat.o(38020);
    return false;
  }
  
  public static String aE(String paramString, long paramLong)
  {
    AppMethodBeat.i(38017);
    paramString = paramString + paramLong;
    AppMethodBeat.o(38017);
    return paramString;
  }
  
  public static String aF(String paramString, long paramLong)
  {
    AppMethodBeat.i(38018);
    paramString = paramString + paramLong;
    AppMethodBeat.o(38018);
    return paramString;
  }
  
  public static boolean abN(String paramString)
  {
    AppMethodBeat.i(38019);
    if ((paramString != null) && (paramString.startsWith("ad_table_")))
    {
      AppMethodBeat.o(38019);
      return true;
    }
    AppMethodBeat.o(38019);
    return false;
  }
  
  public static long abO(String paramString)
  {
    AppMethodBeat.i(38021);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(38021);
      return 0L;
    }
    if (paramString.startsWith("ad_table_"))
    {
      l = bo.apW(paramString.substring(9));
      AppMethodBeat.o(38021);
      return l;
    }
    if (paramString.startsWith("sns_table_"))
    {
      l = bo.apW(paramString.substring(10));
      AppMethodBeat.o(38021);
      return l;
    }
    long l = bo.apW(paramString);
    AppMethodBeat.o(38021);
    return l;
  }
  
  public static int abP(String paramString)
  {
    AppMethodBeat.i(38022);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(38022);
      return 0;
    }
    if (paramString.startsWith("ad_table_"))
    {
      i = bo.apV(paramString.substring(9));
      AppMethodBeat.o(38022);
      return i;
    }
    int i = bo.apV(paramString.substring(10));
    AppMethodBeat.o(38022);
    return i;
  }
  
  public static boolean abQ(String paramString)
  {
    AppMethodBeat.i(38023);
    if (paramString.startsWith("ad_table_"))
    {
      if (bo.apW(paramString.substring(9)) != 0L)
      {
        AppMethodBeat.o(38023);
        return true;
      }
      AppMethodBeat.o(38023);
      return false;
    }
    if (bo.apW(paramString.substring(10)) != 0L)
    {
      AppMethodBeat.o(38023);
      return true;
    }
    AppMethodBeat.o(38023);
    return false;
  }
  
  public static boolean abR(String paramString)
  {
    AppMethodBeat.i(38024);
    if (!abQ(paramString))
    {
      AppMethodBeat.o(38024);
      return true;
    }
    AppMethodBeat.o(38024);
    return false;
  }
  
  public static int ao(String paramString1, String paramString2, String paramString3)
  {
    int k = 0;
    AppMethodBeat.i(38026);
    paramString1 = ap(paramString1, paramString2, paramString3);
    int j = k;
    int i;
    if (!bo.isNullOrNil(paramString1))
    {
      paramString1 = paramString1.split("&");
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < paramString1.length)
      {
        if ((paramString1[i] != null) && (paramString1[i].contains("voteResultIndex="))) {
          j = Integer.valueOf(paramString1[i].substring(16)).intValue();
        }
      }
      else
      {
        AppMethodBeat.o(38026);
        return j;
      }
      i += 1;
    }
  }
  
  public static String ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(38027);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label84;
      }
      label27:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label90;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      if (localStringBuilder.length() <= 0) {
        break label96;
      }
      paramString1 = ah.getContext().getSharedPreferences("SnsAdVote", 0).getString(localStringBuilder.toString(), "");
      AppMethodBeat.o(38027);
      return paramString1;
      paramString1 = "";
      break;
      label84:
      paramString2 = "";
      break label27;
      label90:
      paramString3 = "";
    }
    label96:
    AppMethodBeat.o(38027);
    return "";
  }
  
  public static int gG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(38025);
    g.RJ();
    int i = ao(paramString1, paramString2, a.QC());
    AppMethodBeat.o(38025);
    return i;
  }
  
  public static void h(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38028);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(38028);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label80;
      }
      label42:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label86;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      if (localStringBuilder.length() > 0) {
        break label92;
      }
      AppMethodBeat.o(38028);
      return;
      paramString1 = "";
      break;
      label80:
      paramString2 = "";
      break label42;
      label86:
      paramString3 = "";
    }
    label92:
    paramString1 = ah.getContext().getSharedPreferences("SnsAdVote", 0).edit();
    paramString1.putString(localStringBuilder.toString(), "voteResultIndex=" + paramInt1 + "&isUpdate=" + paramInt2);
    paramString1.commit();
    AppMethodBeat.o(38028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */