import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agbs
  implements View.OnClickListener
{
  agbs(agbr paramagbr, agbe paramagbe, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    Context localContext = agbr.a(this.jdField_a_of_type_Agbr).getContext();
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Agbe.a);
    localContext.startActivity(localIntent);
    agbr.a(this.jdField_a_of_type_Agbr, this.jdField_a_of_type_Agbe, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbs
 * JD-Core Version:    0.7.0.1
 */