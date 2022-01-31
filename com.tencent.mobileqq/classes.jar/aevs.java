import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aevs
  implements aevq
{
  aevs(aevr paramaevr) {}
  
  public void a()
  {
    aevr.a(this.a, aevr.a(this.a));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.1.1(this));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "onSurfaceDestroyed");
    }
    aevr.b(this.a, aevr.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aevs
 * JD-Core Version:    0.7.0.1
 */