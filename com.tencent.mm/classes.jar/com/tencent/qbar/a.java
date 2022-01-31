package com.tencent.qbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static List<String> wKa;
  private static List<String> wKb;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    wKa = localArrayList;
    localArrayList.add("weixin://wxpay/");
    wKa.add("wxp://");
    wKa.add("https://wx.tenpay.com/");
    wKa.add("https://payapp.weixin.qq.com/");
    wKa.add("https://action.weixin.qq.com/");
    localArrayList = new ArrayList();
    wKb = localArrayList;
    localArrayList.add("https://qr.alipay.com/");
  }
  
  public static boolean afx(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = wKa.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramString != null) && (paramString.startsWith(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean afy(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.toLowerCase();
    Iterator localIterator = wKb.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static QbarNative.QbarAiModelParam hp(Context paramContext)
  {
    try
    {
      Object localObject = new File(com.tencent.mm.compatible.util.e.dOO.replace("/data/user/0", "/data/data") + "files/", "qbar");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str3 = ((File)localObject).getAbsolutePath();
      localObject = str3 + "/detect_model.bin";
      String str1 = str3 + "/detect_model.param";
      String str2 = str3 + "/srnet.bin";
      str3 = str3 + "/srnet.param";
      SharedPreferences localSharedPreferences = ae.cqS();
      boolean bool = localSharedPreferences.getBoolean("qbar_ai_mode_version_1", false);
      if (!bool)
      {
        com.tencent.mm.a.e.deleteFile((String)localObject);
        com.tencent.mm.a.e.deleteFile(str1);
        com.tencent.mm.a.e.deleteFile(str2);
        com.tencent.mm.a.e.deleteFile(str3);
        localSharedPreferences.edit().putBoolean("qbar_ai_mode_version_1", true).apply();
      }
      if ((!bool) || (!com.tencent.mm.a.e.bK((String)localObject)))
      {
        j.copyAssets(paramContext, "qbar/detect_model.bin", (String)localObject);
        j.copyAssets(paramContext, "qbar/detect_model.param", str1);
        j.copyAssets(paramContext, "qbar/srnet.bin", str2);
        j.copyAssets(paramContext, "qbar/srnet.param", str3);
      }
      paramContext = new QbarNative.QbarAiModelParam();
      paramContext.detect_model_bin_path_ = ((String)localObject);
      paramContext.detect_model_param_path_ = str1;
      paramContext.superresolution_model_bin_path_ = str2;
      paramContext.superresolution_model_param_path_ = str3;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.w("MicroMsg.QBarAIModHelper", "getAiModeParam err %s", new Object[] { paramContext.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.a
 * JD-Core Version:    0.7.0.1
 */