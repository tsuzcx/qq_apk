import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;

public class aifl
  implements Runnable
{
  public aifl(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 0);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130844422);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.a.getString(2131430325));
    if (this.a.b != null) {
      this.a.b.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aifl
 * JD-Core Version:    0.7.0.1
 */