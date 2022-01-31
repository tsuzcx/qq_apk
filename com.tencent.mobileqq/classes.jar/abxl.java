import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import java.util.List;

public class abxl
  implements Runnable
{
  public abxl(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    EmotionPanelInfo localEmotionPanelInfo;
    int i;
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      localEmotionPanelInfo = null;
      i = 0;
      int j = this.a.jdField_a_of_type_JavaUtilList.size();
      if (i >= j) {
        break label104;
      }
      localEmotionPanelInfo = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
      if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.a != 9)) {
        break label68;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label68:
      while ((EmoticonMainPanel.c != i) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter == null))
      {
        return;
        i += 1;
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localEmotionPanelInfo);
      return;
      label104:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxl
 * JD-Core Version:    0.7.0.1
 */