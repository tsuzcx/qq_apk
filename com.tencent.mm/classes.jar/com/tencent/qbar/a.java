package com.tencent.qbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static List<String> BhA;
  private static List<String> BhB;
  
  static
  {
    AppMethodBeat.i(108291);
    ArrayList localArrayList = new ArrayList();
    BhA = localArrayList;
    localArrayList.add("weixin://wxpay/");
    BhA.add("wxp://");
    BhA.add("https://wx.tenpay.com/");
    BhA.add("https://payapp.weixin.qq.com/");
    BhA.add("https://action.weixin.qq.com/");
    localArrayList = new ArrayList();
    BhB = localArrayList;
    localArrayList.add("https://qr.alipay.com/");
    AppMethodBeat.o(108291);
  }
  
  public static void a(QbarNative paramQbarNative)
  {
    AppMethodBeat.i(108290);
    if (paramQbarNative == null)
    {
      ab.w("MicroMsg.QBarAIModHelper", "config qbarNative is null");
      AppMethodBeat.o(108290);
      return;
    }
    Iterator localIterator = BhA.iterator();
    while (localIterator.hasNext()) {
      paramQbarNative.AddWhiteList((String)localIterator.next(), paramQbarNative.BhG);
    }
    localIterator = BhB.iterator();
    while (localIterator.hasNext()) {
      paramQbarNative.AddBlackList((String)localIterator.next(), paramQbarNative.BhG);
    }
    paramQbarNative.AddBlackInternal(6, paramQbarNative.BhG);
    AppMethodBeat.o(108290);
  }
  
  public static QbarNative.QbarAiModelParam iQ(Context paramContext)
  {
    AppMethodBeat.i(108289);
    try
    {
      Object localObject = new File(com.tencent.mm.compatible.util.e.eQu.replace("/data/user/0", "/data/data") + "files/", "qbar");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str3 = ((File)localObject).getAbsolutePath();
      localObject = str3 + "/detect_model.bin";
      String str1 = str3 + "/detect_model.param";
      String str2 = str3 + "/srnet.bin";
      str3 = str3 + "/srnet.param";
      SharedPreferences localSharedPreferences = ah.dsQ();
      boolean bool = localSharedPreferences.getBoolean("qbar_ai_mode_version_1", false);
      if (!bool)
      {
        com.tencent.mm.a.e.deleteFile((String)localObject);
        com.tencent.mm.a.e.deleteFile(str1);
        com.tencent.mm.a.e.deleteFile(str2);
        com.tencent.mm.a.e.deleteFile(str3);
        localSharedPreferences.edit().putBoolean("qbar_ai_mode_version_1", true).apply();
      }
      if ((!bool) || (!com.tencent.mm.a.e.cN((String)localObject)))
      {
        m.copyAssets(paramContext, "qbar/detect_model.bin", (String)localObject);
        m.copyAssets(paramContext, "qbar/detect_model.param", str1);
        m.copyAssets(paramContext, "qbar/srnet.bin", str2);
        m.copyAssets(paramContext, "qbar/srnet.param", str3);
      }
      paramContext = new QbarNative.QbarAiModelParam();
      paramContext.detect_model_bin_path_ = ((String)localObject);
      paramContext.detect_model_param_path_ = str1;
      paramContext.superresolution_model_bin_path_ = str2;
      paramContext.superresolution_model_param_path_ = str3;
      AppMethodBeat.o(108289);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.w("MicroMsg.QBarAIModHelper", "getAiModeParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(108289);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qbar.a
 * JD-Core Version:    0.7.0.1
 */