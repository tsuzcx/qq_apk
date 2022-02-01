import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class ainq
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextBottomViewHelper", 2, "hideBottom");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramVoiceTextPanel.findViewById(2131363733));
    this.jdField_a_of_type_AndroidViewView = paramVoiceTextPanel.findViewById(2131370108);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextBottomViewHelper", 2, "showBottom");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = ScreenUtil.dip2px(75.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainq
 * JD-Core Version:    0.7.0.1
 */