import android.graphics.Bitmap;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupGameUtil;
import com.tencent.mobileqq.worldcup.ARWorldCupVideoInfo;
import com.tencent.mobileqq.worldcup.ARWorldCupVideoInfo.BigScreenShowInfo;
import com.tencent.qphone.base.util.QLog;

public class aagf
  implements Runnable
{
  public aagf(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    boolean bool2 = true;
    ARWorldCupVideoInfo.BigScreenShowInfo localBigScreenShowInfo = null;
    Object localObject = ARWorldCupGameLogicManager.a().a(ARWorldCupGlobalSceneRenderable.a(this.a).a() + "/res/worldcup/");
    if (localObject != null)
    {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("initBigScreenTexture info != null", new Object[0]));
      localBigScreenShowInfo = ((ARWorldCupVideoInfo)localObject).a();
    }
    localObject = ARWorldCupGameUtil.a(ARWorldCupGlobalSceneRenderable.a(this.a).a() + "/res/worldcup/", ARWorldCupGlobalSceneRenderable.a(this.a), ARWorldCupGlobalSceneRenderable.b(this.a), ARWorldCupGlobalSceneRenderable.c(this.a), ARWorldCupGlobalSceneRenderable.d(this.a));
    if ((localObject != null) && (localBigScreenShowInfo != null))
    {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("initBigScreenTexture bmp != null && bigScreenShowInfo != null", new Object[0]));
      ARWorldCupGameLogicManager.a().a(localBigScreenShowInfo);
      ARWorldCupGlobalSceneRenderable.a(this.a, new aagg(this, (Bitmap)localObject, localBigScreenShowInfo));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("initBigScreenTexture bmp == null is ");
    if (localObject == null)
    {
      bool1 = true;
      localObject = localStringBuilder.append(bool1).append(" | bigScreenShowInfo == null is");
      if (localBigScreenShowInfo != null) {
        break label238;
      }
    }
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagf
 * JD-Core Version:    0.7.0.1
 */