import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;

public class aizr
  implements Runnable
{
  public aizr(PublicCommentWindow paramPublicCommentWindow) {}
  
  public void run()
  {
    this.a.b = false;
    if ((this.a.isShowing()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844610);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430345));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizr
 * JD-Core Version:    0.7.0.1
 */