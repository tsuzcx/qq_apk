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
import org.apache.commons.a.c;

public final class a
{
  public static ArrayList<DetectCode> G(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
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
  
  public static int cL(String paramString)
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
  
  private static void d(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(3506);
    paramString = new File(paramString);
    if ((!paramString.exists()) || (paramString.exists())) {
      try
      {
        paramString.delete();
        c.c(paramInputStream, paramString);
        AppMethodBeat.o(3506);
        return;
      }
      catch (IOException paramInputStream) {}
    }
    AppMethodBeat.o(3506);
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
  
  public static QbarNative.QbarAiModelParam lb(Context paramContext)
  {
    AppMethodBeat.i(3509);
    try
    {
      String str4 = paramContext.getFilesDir().getAbsolutePath() + "/qbar";
      String str1 = str4 + "/detect_model.bin";
      String str2 = str4 + "/detect_model.param";
      String str3 = str4 + "/srnet.bin";
      str4 = str4 + "/srnet.param";
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("qbar_ai_preference_file", 0);
      int i = localSharedPreferences.getInt("qbar_ai_model_version", 0);
      int j = localSharedPreferences.getInt("qbar_ai_model_copy_version", 0);
      Log.i("ScanUtil", String.format("version %d, copyVersion %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      if ((i != 103) || (i != j))
      {
        d(paramContext.getResources().getAssets().open("qbar/detect_model.bin"), str1);
        d(paramContext.getResources().getAssets().open("qbar/detect_model.param"), str2);
        d(paramContext.getResources().getAssets().open("qbar/srnet.bin"), str3);
        d(paramContext.getResources().getAssets().open("qbar/srnet.param"), str4);
        localSharedPreferences.edit().putInt("qbar_ai_model_version", 103).apply();
        localSharedPreferences.edit().putInt("qbar_ai_model_copy_version", 103).commit();
      }
      paramContext = new QbarNative.QbarAiModelParam();
      paramContext.detect_model_bin_path_ = str1;
      paramContext.detect_model_param_path_ = str2;
      paramContext.superresolution_model_bin_path_ = str3;
      paramContext.superresolution_model_param_path_ = str4;
      AppMethodBeat.o(3509);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("ScanUtil", "copy qbar ai model file error! " + paramContext.getMessage());
      AppMethodBeat.o(3509);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a
 * JD-Core Version:    0.7.0.1
 */