import android.content.Context;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;

public class aire
{
  public static FrameworkView a(Context paramContext, aipj paramaipj, befq parambefq, ailv paramailv, CmGameStartChecker.StartCheckParam paramStartCheckParam)
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
      paramContext.a(paramaipj, parambefq, paramailv, paramStartCheckParam);
      return paramContext;
      paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameFloatView(paramContext, paramStartCheckParam);
    }
  }
  
  public static FrameworkView a(Context paramContext, aipj paramaipj, befq parambefq, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
    }
    for (;;)
    {
      paramContext.a(paramaipj, parambefq, null, paramStartCheckParam);
      return paramContext;
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameDebugView(paramContext, paramStartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aire
 * JD-Core Version:    0.7.0.1
 */