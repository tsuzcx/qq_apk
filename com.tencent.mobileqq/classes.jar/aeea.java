import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aeea
  implements View.OnTouchListener
{
  long jdField_a_of_type_Long = 0L;
  
  aeea(aedo paramaedo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aedo.L) || (!(paramView instanceof ImageView))) {
      return false;
    }
    Object localObject = (ImageView)paramView;
    int i = paramMotionEvent.getAction();
    localObject = null;
    paramMotionEvent = (MotionEvent)localObject;
    if (paramView.getTag() != null)
    {
      paramMotionEvent = (MotionEvent)localObject;
      if ((paramView.getTag() instanceof asbx)) {
        paramMotionEvent = (asbx)paramView.getTag();
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if (paramMotionEvent != null)
      {
        paramView.setAlpha(paramMotionEvent.a() * 0.5F);
      }
      else
      {
        paramView.setAlpha(0.5F);
        continue;
        if (paramMotionEvent != null) {
          paramView.setAlpha(paramMotionEvent.a());
        }
        while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 800L)
        {
          return true;
          paramView.setAlpha(1.0F);
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramView = new Intent(this.jdField_a_of_type_Aedo.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
        localObject = amde.a().a(this.jdField_a_of_type_Aedo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        asau.a(this.jdField_a_of_type_Aedo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aedo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramMotionEvent);
        paramView.putExtra("url", (String)localObject);
        paramView.putExtra("finish_animation_out_to_right", true);
        paramView.putExtra("is_wrap_content", true);
        paramView.putExtra("hide_left_button", false);
        if (this.jdField_a_of_type_Aedo.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
        {
          this.jdField_a_of_type_Aedo.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
          continue;
          if (paramMotionEvent != null) {
            paramView.setAlpha(paramMotionEvent.a());
          } else {
            paramView.setAlpha(1.0F);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeea
 * JD-Core Version:    0.7.0.1
 */