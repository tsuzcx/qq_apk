import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.List;

public class acev
  implements View.OnClickListener
{
  public acev(EmoticonMainPanel paramEmoticonMainPanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    EmoticonMainPanel.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "emoticon_panel", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      paramView = (EmotionPanelInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList.get(0);
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(paramView);
      if ((paramView != null) && ((paramView instanceof SystemAndEmojiAdapter))) {
        ((SystemAndEmojiAdapter)paramView).d();
      }
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X8008232", this.jdField_a_of_type_JavaLangString, 0, 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acev
 * JD-Core Version:    0.7.0.1
 */