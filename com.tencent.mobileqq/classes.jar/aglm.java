import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aglm
  implements View.OnClickListener
{
  aglm(agll paramagll, agky paramagky, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    Context localContext = agll.a(this.jdField_a_of_type_Agll).getContext();
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Agky.a);
    localContext.startActivity(localIntent);
    agll.a(this.jdField_a_of_type_Agll, this.jdField_a_of_type_Agky, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglm
 * JD-Core Version:    0.7.0.1
 */