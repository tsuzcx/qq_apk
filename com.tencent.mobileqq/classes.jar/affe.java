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

public class affe
  implements View.OnClickListener
{
  public affe(BusinessEggsAnimation paramBusinessEggsAnimation, affh paramaffh, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    afdr localafdr = (afdr)BusinessEggsAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation).get(Long.valueOf(this.jdField_a_of_type_Affh.a));
    if (localafdr != null)
    {
      if (!"HTML".equals(localafdr.b)) {
        break label116;
      }
      if (!TextUtils.isEmpty(localafdr.a))
      {
        Context localContext = paramView.getContext();
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("url", localafdr.a);
        localContext.startActivity(localIntent);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        afed.a(null, "0X800B072", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localafdr);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label116:
      QLog.e("BusinessEggsAnimation", 1, "[initElementPathStrategy] jump type not define: " + localafdr.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affe
 * JD-Core Version:    0.7.0.1
 */