import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

public class afwj
  implements View.OnClickListener
{
  public afwj(BusinessEggsAnimation paramBusinessEggsAnimation, afwm paramafwm, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    afuw localafuw = (afuw)BusinessEggsAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation).get(Long.valueOf(this.jdField_a_of_type_Afwm.a));
    if (localafuw != null)
    {
      if (!"HTML".equals(localafuw.b)) {
        break label116;
      }
      if (!TextUtils.isEmpty(localafuw.a))
      {
        Context localContext = paramView.getContext();
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("url", localafuw.a);
        localContext.startActivity(localIntent);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        afvi.a(null, "0X800B072", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localafuw);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      QLog.e("BusinessEggsAnimation", 1, "[initElementPathStrategy] jump type not define: " + localafuw.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwj
 * JD-Core Version:    0.7.0.1
 */