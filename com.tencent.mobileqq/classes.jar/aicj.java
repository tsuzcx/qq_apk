import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aicj
  implements View.OnClickListener
{
  aicj(aibv paramaibv, String paramString) {}
  
  public void onClick(View paramView)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_Aibv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aibv.jdField_a_of_type_Anoc.a(localHotChatInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicj
 * JD-Core Version:    0.7.0.1
 */