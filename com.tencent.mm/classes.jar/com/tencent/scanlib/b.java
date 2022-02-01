package com.tencent.scanlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import com.tencent.scanlib.model.DetectCode;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static String ahvA;
  public static final Object ahvB;
  private static String ahvu;
  private static String ahvv;
  private static String ahvw;
  private static String ahvx;
  private static String ahvy;
  private static String ahvz;
  
  static
  {
    AppMethodBeat.i(216761);
    ahvu = "";
    ahvv = "";
    ahvw = "";
    ahvx = "";
    ahvy = "";
    ahvz = "";
    ahvA = "";
    ahvB = new Object();
    AppMethodBeat.o(216761);
  }
  
  public static ArrayList<DetectCode> Z(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
  {
    AppMethodBeat.i(3508);
    ArrayList localArrayList1 = new ArrayList();
    if (!paramList.isEmpty())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QbarNative.QBarCodeDetectInfo localQBarCodeDetectInfo = (QbarNative.QBarCodeDetectInfo)paramList.get(i);
        QbarNative.QBarPoint localQBarPoint = (QbarNative.QBarPoint)paramList1.get(i);
        ArrayList localArrayList2 = new ArrayList(localQBarPoint.point_cnt);
        if (localQBarPoint.point_cnt > 0) {
          localArrayList2.add(new Point((int)localQBarPoint.x0, (int)localQBarPoint.y0));
        }
        if (localQBarPoint.point_cnt > 1) {
          localArrayList2.add(new Point((int)localQBarPoint.x1, (int)localQBarPoint.y1));
        }
        if (localQBarPoint.point_cnt > 2) {
          localArrayList2.add(new Point((int)localQBarPoint.x2, (int)localQBarPoint.y2));
        }
        if (localQBarPoint.point_cnt > 3) {
          localArrayList2.add(new Point((int)localQBarPoint.x3, (int)localQBarPoint.y3));
        }
        localArrayList1.add(new DetectCode(localQBarCodeDetectInfo.readerId, localArrayList2, localQBarCodeDetectInfo.prob));
        i += 1;
      }
    }
    AppMethodBeat.o(3508);
    return localArrayList1;
  }
  
  public static void bG(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(216750);
    try
    {
      paramContext.getSharedPreferences("qbar_ai_preference_file", 0).edit().putInt("qbar_ai_backend", paramInt).commit();
      Log.i("ScanUtil", "setQbarBackend:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(216750);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("ScanUtil", paramContext, "");
      AppMethodBeat.o(216750);
    }
  }
  
  private static void e(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(3506);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.exists())) {
      try
      {
        localFile.delete();
        org.apache.commons.b.b.c(paramInputStream, localFile);
        AppMethodBeat.o(3506);
        return;
      }
      catch (IOException paramInputStream)
      {
        Log.e("ScanUtil", "copyFile IOException:".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(3506);
  }
  
  public static int ew(String paramString)
  {
    AppMethodBeat.i(3507);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(3507);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(3507);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(3507);
    }
    return 0;
  }
  
  private static int g(SharedPreferences paramSharedPreferences)
  {
    int i = 0;
    AppMethodBeat.i(216752);
    try
    {
      int j = paramSharedPreferences.getInt("qbar_ai_backend", 0);
      i = j;
    }
    catch (Exception paramSharedPreferences)
    {
      for (;;)
      {
        Log.e("ScanUtil", paramSharedPreferences, "");
      }
    }
    Log.i("ScanUtil", "getQBarBackend:".concat(String.valueOf(i)));
    AppMethodBeat.o(216752);
    return i;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(3505);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(3505);
      return true;
    }
    AppMethodBeat.o(3505);
    return false;
  }
  
  public static QbarNative.QbarAiModelParam oe(Context paramContext)
  {
    AppMethodBeat.i(3509);
    try
    {
      String str1 = og(paramContext);
      String str2 = oh(paramContext);
      String str3 = oi(paramContext);
      String str4 = oj(paramContext);
      String str5 = ok(paramContext);
      String str6 = ol(paramContext);
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("qbar_ai_preference_file", 0);
      int i = localSharedPreferences.getInt("qbar_ai_model_version", 0);
      Log.i("ScanUtil", "version %d, copyVersion %d  QBAR_AI_MODEL_VERSION_CODE %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localSharedPreferences.getInt("qbar_ai_model_copy_version", 0)), Integer.valueOf(105) });
      if (i != 105)
      {
        e(paramContext.getResources().getAssets().open("qbar/detect_model.bin"), str1);
        e(paramContext.getResources().getAssets().open("qbar/detect_model.param"), str2);
        e(paramContext.getResources().getAssets().open("qbar/srnet.bin"), str3);
        e(paramContext.getResources().getAssets().open("qbar/srnet.param"), str4);
        e(paramContext.getResources().getAssets().open("qbar/detect_model_fp16.xnet"), str5);
        e(paramContext.getResources().getAssets().open("qbar/sr_fp16.xnet"), str6);
        localSharedPreferences.edit().putInt("qbar_ai_model_version", 105).apply();
      }
      paramContext = new QbarNative.QbarAiModelParam();
      paramContext.detect_model_param_path_ = str2;
      paramContext.superresolution_model_param_path_ = str4;
      if (g(localSharedPreferences) == 1) {
        paramContext.superresolution_model_bin_path_ = str6;
      }
      for (paramContext.detect_model_bin_path_ = str5;; paramContext.detect_model_bin_path_ = str1)
      {
        AppMethodBeat.o(3509);
        return paramContext;
        paramContext.superresolution_model_bin_path_ = str3;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      Log.e("ScanUtil", "copy qbar ai model file error! " + paramContext.getMessage());
      AppMethodBeat.o(3509);
    }
  }
  
  public static int of(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(216753);
    try
    {
      int j = paramContext.getSharedPreferences("qbar_ai_preference_file", 0).getInt("qbar_ai_backend", 0);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("ScanUtil", paramContext, "");
      }
    }
    Log.i("ScanUtil", "getQBarBackend:".concat(String.valueOf(i)));
    AppMethodBeat.o(216753);
    return i;
  }
  
  public static String og(Context paramContext)
  {
    AppMethodBeat.i(216754);
    if ((ahvu != null) && (!ahvu.isEmpty()))
    {
      paramContext = ahvu;
      AppMethodBeat.o(216754);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvu;
      AppMethodBeat.o(216754);
      return paramContext;
    }
    paramContext = paramContext + "/detect_model.bin";
    ahvu = paramContext;
    AppMethodBeat.o(216754);
    return paramContext;
  }
  
  public static String oh(Context paramContext)
  {
    AppMethodBeat.i(216755);
    if ((ahvv != null) && (!ahvv.isEmpty()))
    {
      paramContext = ahvv;
      AppMethodBeat.o(216755);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvv;
      AppMethodBeat.o(216755);
      return paramContext;
    }
    paramContext = paramContext + "/detect_model.param";
    ahvv = paramContext;
    AppMethodBeat.o(216755);
    return paramContext;
  }
  
  public static String oi(Context paramContext)
  {
    AppMethodBeat.i(216756);
    if ((ahvw != null) && (!ahvw.isEmpty()))
    {
      paramContext = ahvw;
      AppMethodBeat.o(216756);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvw;
      AppMethodBeat.o(216756);
      return paramContext;
    }
    paramContext = paramContext + "/srnet.bin";
    ahvw = paramContext;
    AppMethodBeat.o(216756);
    return paramContext;
  }
  
  public static String oj(Context paramContext)
  {
    AppMethodBeat.i(216757);
    if ((ahvx != null) && (!ahvx.isEmpty()))
    {
      paramContext = ahvx;
      AppMethodBeat.o(216757);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvx;
      AppMethodBeat.o(216757);
      return paramContext;
    }
    paramContext = paramContext + "/srnet.param";
    ahvx = paramContext;
    AppMethodBeat.o(216757);
    return paramContext;
  }
  
  public static String ok(Context paramContext)
  {
    AppMethodBeat.i(216758);
    if ((ahvy != null) && (!ahvy.isEmpty()))
    {
      paramContext = ahvy;
      AppMethodBeat.o(216758);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvy;
      AppMethodBeat.o(216758);
      return paramContext;
    }
    paramContext = paramContext + "/detect_model_fp16.xnet";
    ahvy = paramContext;
    AppMethodBeat.o(216758);
    return paramContext;
  }
  
  public static String ol(Context paramContext)
  {
    AppMethodBeat.i(216759);
    if ((ahvz != null) && (!ahvz.isEmpty()))
    {
      paramContext = ahvz;
      AppMethodBeat.o(216759);
      return paramContext;
    }
    paramContext = om(paramContext);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      paramContext = ahvz;
      AppMethodBeat.o(216759);
      return paramContext;
    }
    paramContext = paramContext + "/sr_fp16.xnet";
    ahvz = paramContext;
    AppMethodBeat.o(216759);
    return paramContext;
  }
  
  private static String om(Context paramContext)
  {
    AppMethodBeat.i(216760);
    try
    {
      if ((ahvA == null) || (ahvA.isEmpty())) {
        ahvA = paramContext.getFilesDir().getAbsolutePath() + "/qbar";
      }
      Log.i("ScanUtil", "getQBarAIDataDir :" + ahvA);
      paramContext = ahvA;
      AppMethodBeat.o(216760);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("ScanUtil", "getQBarAIDataDir ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(216760);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.scanlib.b
 * JD-Core Version:    0.7.0.1
 */