import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.util.DynamicFaceDrawable;

public class abrb
  implements Runnable
{
  public abrb(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.setImageDrawable(this.a.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrb
 * JD-Core Version:    0.7.0.1
 */