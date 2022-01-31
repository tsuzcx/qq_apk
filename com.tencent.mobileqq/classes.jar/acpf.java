import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.5.1;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.5.2;

public class acpf
  extends View
{
  acpf(acpd paramacpd, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a()) || (this.a.b.a())) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.5.1(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.a.b.d)) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new XBubbleAnimation.5.2(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acpf
 * JD-Core Version:    0.7.0.1
 */