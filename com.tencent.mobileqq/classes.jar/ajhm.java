import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class ajhm
  implements Action.OnActionEndListener
{
  ajhm(ajhl paramajhl) {}
  
  public void a()
  {
    TroopGiftToAllSurfaceView.a(this.a.a).a(new Action[] { new OpacityAction(600, 0, 255), new SequenceAction(new Action[] { new ScaleAction(300, 0.0F, 1.2F), new ScaleAction(300, 1.2F, 1.0F) }) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajhm
 * JD-Core Version:    0.7.0.1
 */