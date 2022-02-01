package com.tencent.mm.plugin.sns.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class x
{
  public static boolean aBM(String paramString)
  {
    AppMethodBeat.i(97638);
    if ((paramString != null) && (paramString.startsWith("ad_table_")))
    {
      AppMethodBeat.o(97638);
      return true;
    }
    AppMethodBeat.o(97638);
    return false;
  }
  
  public static int aBN(String paramString)
  {
    AppMethodBeat.i(97641);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(97641);
      return 0;
    }
    if (paramString.startsWith("ad_table_"))
    {
      i = bu.aSB(paramString.substring(9));
      AppMethodBeat.o(97641);
      return i;
    }
    int i = bu.aSB(paramString.substring(10));
    AppMethodBeat.o(97641);
    return i;
  }
  
  public static boolean aBO(String paramString)
  {
    AppMethodBeat.i(97642);
    if (paramString.startsWith("ad_table_"))
    {
      if (bu.aSC(paramString.substring(9)) != 0L)
      {
        AppMethodBeat.o(97642);
        return true;
      }
      AppMethodBeat.o(97642);
      return false;
    }
    if (bu.aSC(paramString.substring(10)) != 0L)
    {
      AppMethodBeat.o(97642);
      return true;
    }
    AppMethodBeat.o(97642);
    return false;
  }
  
  public static boolean aBP(String paramString)
  {
    AppMethodBeat.i(97643);
    if (!aBO(paramString))
    {
      AppMethodBeat.o(97643);
      return true;
    }
    AppMethodBeat.o(97643);
    return false;
  }
  
  public static String aBQ(String paramString)
  {
    AppMethodBeat.i(179142);
    str1 = "";
    for (;;)
    {
      try
      {
        g.ajP();
        String str2 = a.aiF();
        if (bu.V(new String[] { paramString, str2 }))
        {
          ae.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
          AppMethodBeat.o(179142);
          return "";
        }
        localStringBuilder = new StringBuilder();
        if (bu.isNullOrNil(paramString)) {
          continue;
        }
        localStringBuilder.append(paramString);
        if (bu.isNullOrNil(str2)) {
          continue;
        }
        paramString = str2;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        ae.e("StorageHelper", paramString.toString());
        paramString = str1;
        continue;
        paramString = "";
        continue;
      }
      localStringBuilder.append(paramString);
      if (localStringBuilder.length() > 0) {
        continue;
      }
      ae.e("StorageHelper", "HalfScreenSubscribe, key is empty");
      AppMethodBeat.o(179142);
      return "";
      paramString = "";
    }
    paramString = localStringBuilder.toString();
    paramString = ak.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).getString(paramString, "");
    AppMethodBeat.o(179142);
    return paramString;
  }
  
  public static int aH(String paramString1, String paramString2, String paramString3)
  {
    int k = 0;
    AppMethodBeat.i(97645);
    paramString1 = aI(paramString1, paramString2, paramString3);
    int j = k;
    int i;
    if (!bu.isNullOrNil(paramString1))
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
          j = bu.getInt(paramString1[i].substring(16), 0);
        }
      }
      else
      {
        ae.d("StorageHelper", "getSnsAdVoteIndex, voteIdx=".concat(String.valueOf(j)));
        AppMethodBeat.o(97645);
        return j;
      }
      i += 1;
    }
  }
  
  public static String aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97646);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label101;
      }
      label27:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label107;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      paramString1 = "";
      if (localStringBuilder.length() > 0) {
        paramString1 = ak.getContext().getSharedPreferences("SnsAdVote", 0).getString(localStringBuilder.toString(), "");
      }
      ae.d("StorageHelper", "getSnsAdVoteInfo, ret=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(97646);
      return paramString1;
      paramString1 = "";
      break;
      label101:
      paramString2 = "";
      break label27;
      label107:
      paramString3 = "";
    }
  }
  
  public static boolean ayP(String paramString)
  {
    AppMethodBeat.i(97639);
    if ((paramString != null) && (paramString.startsWith("sns_table_")))
    {
      AppMethodBeat.o(97639);
      return true;
    }
    AppMethodBeat.o(97639);
    return false;
  }
  
  public static long aze(String paramString)
  {
    AppMethodBeat.i(97640);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(97640);
      return 0L;
    }
    if (paramString.startsWith("ad_table_"))
    {
      l = bu.aSC(paramString.substring(9));
      AppMethodBeat.o(97640);
      return l;
    }
    if (paramString.startsWith("sns_table_"))
    {
      l = bu.aSC(paramString.substring(10));
      AppMethodBeat.o(97640);
      return l;
    }
    long l = bu.aSC(paramString);
    AppMethodBeat.o(97640);
    return l;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(97647);
    if (TextUtils.isEmpty(paramString1))
    {
      ae.e("StorageHelper", "saveSnsAdVoteInfo, url is empty");
      AppMethodBeat.o(97647);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label94;
      }
      label49:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label100;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      if (localStringBuilder.length() > 0) {
        break label106;
      }
      ae.e("StorageHelper", "saveSnsAdVoteInfo, key is empty");
      AppMethodBeat.o(97647);
      return;
      paramString1 = "";
      break;
      label94:
      paramString2 = "";
      break label49;
      label100:
      paramString3 = "";
    }
    label106:
    paramString1 = localStringBuilder.toString();
    paramString2 = ak.getContext().getSharedPreferences("SnsAdVote", 0).edit();
    paramString2.putString(paramString1, "voteResultIndex=" + paramInt1 + "&isUpdate=" + paramInt2);
    paramString2.putString(paramString1 + "_voteRet", paramString4);
    paramString2.commit();
    ae.i("StorageHelper", "saveSnsAdVoteInfo, voteIdx=" + paramInt1 + ", isUpdate=" + paramInt2 + ", content=" + paramString4);
    AppMethodBeat.o(97647);
  }
  
  public static String bn(String paramString, long paramLong)
  {
    AppMethodBeat.i(97636);
    paramString = paramString + paramLong;
    AppMethodBeat.o(97636);
    return paramString;
  }
  
  public static String bo(String paramString, long paramLong)
  {
    AppMethodBeat.i(97637);
    paramString = paramString + paramLong;
    AppMethodBeat.o(97637);
    return paramString;
  }
  
  public static int jZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97644);
    g.ajP();
    int i = aH(paramString1, paramString2, a.aiF());
    AppMethodBeat.o(97644);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.x
 * JD-Core Version:    0.7.0.1
 */