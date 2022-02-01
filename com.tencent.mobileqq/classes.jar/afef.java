import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afef
  implements View.OnClickListener
{
  afef(afee paramafee, afdr paramafdr, ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    Context localContext = afee.a(this.jdField_a_of_type_Afee).getContext();
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Afdr.a);
    localContext.startActivity(localIntent);
    afee.a(this.jdField_a_of_type_Afee, this.jdField_a_of_type_Afdr, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afef
 * JD-Core Version:    0.7.0.1
 */