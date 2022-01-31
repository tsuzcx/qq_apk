import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class adsb
  extends ClickableSpan
{
  adsb(adqy paramadqy) {}
  
  public void onClick(View paramView)
  {
    if (bbev.d(this.a.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.a((short)1, localArrayList, false);
      return;
    }
    bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 1).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsb
 * JD-Core Version:    0.7.0.1
 */