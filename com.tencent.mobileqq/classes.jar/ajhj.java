import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

public class ajhj
  implements Action.OnActionEndListener
{
  public ajhj(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView) {}
  
  public void a()
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, TroopGiftToAllSurfaceView.a(this.a), TroopGiftToAllSurfaceView.a(this.a) * 0.95F), new ScaleAction(400, TroopGiftToAllSurfaceView.a(this.a) * 0.95F, TroopGiftToAllSurfaceView.a(this.a)) });
    localSequenceAction.a = true;
    TroopGiftToAllSurfaceView.a(this.a).a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajhj
 * JD-Core Version:    0.7.0.1
 */