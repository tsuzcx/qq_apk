import android.content.Context;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;

public class alab
{
  public static FrameworkView a(Context paramContext, akyg paramakyg, bhtd parambhtd, akun paramakun, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    switch (paramStartCheckParam.src)
    {
    default: 
      if (paramStartCheckParam.mGameType == 5) {
        paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      }
      break;
    }
    for (;;)
    {
      paramContext.a(paramakyg, parambhtd, paramakun, paramStartCheckParam);
      return paramContext;
      paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameFloatView(paramContext, paramStartCheckParam);
    }
  }
  
  public static FrameworkView a(Context paramContext, akyg paramakyg, bhtd parambhtd, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
    }
    for (;;)
    {
      paramContext.a(paramakyg, parambhtd, null, paramStartCheckParam);
      return paramContext;
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameDebugView(paramContext, paramStartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alab
 * JD-Core Version:    0.7.0.1
 */