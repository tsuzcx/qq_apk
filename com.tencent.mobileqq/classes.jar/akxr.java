import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

class akxr
  implements View.OnTouchListener
{
  akxr(akxq paramakxq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if ((ARWorldCupGameLogicManager.a(this.a.a) != null) && ((ARWorldCupGameLogicManager.a(this.a.a) instanceof ARWorldCupGlobalSceneRenderable))) {
        ((ARWorldCupGlobalSceneRenderable)ARWorldCupGameLogicManager.a(this.a.a)).e();
      }
      ARWorldCupGameLogicManager.a(this.a.a).setVisibility(8);
      QLog.d(ARWorldCupGameLogicManager.a, 2, "showCameraTranvesalDoorTouchView MotionEvent.ACTION_DOWN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxr
 * JD-Core Version:    0.7.0.1
 */