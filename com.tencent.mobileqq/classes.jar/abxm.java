import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import java.util.List;

public class abxm
  implements Runnable
{
  public abxm(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    int i;
    EmotionPanelInfo localEmotionPanelInfo;
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      i = 0;
      if (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
        if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.a != 4)) {}
      }
    }
    for (;;)
    {
      if ((localEmotionPanelInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localEmotionPanelInfo);
      }
      return;
      i += 1;
      break;
      localEmotionPanelInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxm
 * JD-Core Version:    0.7.0.1
 */