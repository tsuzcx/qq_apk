import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahhc
  implements View.OnClickListener
{
  ahhc(ahgz paramahgz, String paramString) {}
  
  public void onClick(View paramView)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_Ahgz.app.getManager(60)).a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ahgz.a.a(localHotChatInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhc
 * JD-Core Version:    0.7.0.1
 */