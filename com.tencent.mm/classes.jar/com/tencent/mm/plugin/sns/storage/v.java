package com.tencent.mm.plugin.sns.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class v
{
  public static boolean MJ(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("sns_table_"));
  }
  
  public static boolean OT(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("ad_table_"));
  }
  
  public static long OU(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0L;
    }
    if (paramString.startsWith("ad_table_")) {
      return bk.ZS(paramString.substring(9));
    }
    if (paramString.startsWith("sns_table_")) {
      return bk.ZS(paramString.substring(10));
    }
    return bk.ZS(paramString);
  }
  
  public static int OV(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    if (paramString.startsWith("ad_table_")) {
      return bk.ZR(paramString.substring(9));
    }
    return bk.ZR(paramString.substring(10));
  }
  
  public static boolean OW(String paramString)
  {
    if (paramString.startsWith("ad_table_")) {
      if (bk.ZS(paramString.substring(9)) == 0L) {}
    }
    while (bk.ZS(paramString.substring(10)) != 0L)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean OX(String paramString)
  {
    return !OW(paramString);
  }
  
  public static int ac(String paramString1, String paramString2, String paramString3)
  {
    int k = 0;
    paramString1 = ad(paramString1, paramString2, paramString3);
    int j = k;
    int i;
    if (!bk.bl(paramString1))
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
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public static String ad(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label72;
      }
      label22:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label78;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      if (localStringBuilder.length() <= 0) {
        break label84;
      }
      return ae.getContext().getSharedPreferences("SnsAdVote", 0).getString(localStringBuilder.toString(), "");
      paramString1 = "";
      break;
      label72:
      paramString2 = "";
      break label22;
      label78:
      paramString3 = "";
    }
    label84:
    return "";
  }
  
  public static String ak(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public static String al(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public static int eY(String paramString1, String paramString2)
  {
    g.DN();
    return ac(paramString1, paramString2, a.CL());
  }
  
  public static void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      label21:
      localStringBuilder.append(paramString1);
      if (paramString2 == null) {
        break label125;
      }
      label32:
      localStringBuilder.append(paramString2);
      if (paramString3 == null) {
        break label131;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramString3);
      if (localStringBuilder.length() <= 0) {
        break;
      }
      paramString1 = ae.getContext().getSharedPreferences("SnsAdVote", 0).edit();
      paramString1.putString(localStringBuilder.toString(), "voteResultIndex=" + paramInt1 + "&isUpdate=" + paramInt2);
      paramString1.commit();
      return;
      paramString1 = "";
      break label21;
      label125:
      paramString2 = "";
      break label32;
      label131:
      paramString3 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */