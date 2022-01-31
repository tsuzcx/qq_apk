import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;

public class acfv
  implements Runnable
{
  public acfv(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, EmotionPanelInfo paramEmotionPanelInfo, BaseEmotionAdapter paramBaseEmotionAdapter, ListView paramListView) {}
  
  public void run()
  {
    Object localObject = EmotionPanelDataBuilder.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.jdField_a_of_type_Int;
    EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.a;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localObject = ((EmotionPanelDataBuilder)localObject).a(localQQAppInterface, j, localEmoticonPackage, i, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Boolean);
      EmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.a, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBaseEmotionAdapter, (List)localObject);
      ThreadManager.getUIHandler().post(new acfw(this, (List)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfv
 * JD-Core Version:    0.7.0.1
 */