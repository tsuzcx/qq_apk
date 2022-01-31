import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class aafx
  implements Runnable
{
  aafx(aafw paramaafw) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (ARWorldCupGlobalSceneRenderable.a(this.a.a) != null) && (ARWorldCupGlobalSceneRenderable.a(this.a.a).a()))
    {
      long l = ARWorldCupGlobalSceneRenderable.a(this.a.a).a();
      this.a.a.a.postDelayed(ARWorldCupGlobalSceneRenderable.a(this.a.a), 4700L - l);
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, "start Post  mRepeatCheckRunnable " + l);
    }
    ARWorldCupGameLogicManager.a().a(true);
    ReportController.b(null, "dc00898", "", "", "0X8009313", "0X8009313", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafx
 * JD-Core Version:    0.7.0.1
 */