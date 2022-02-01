import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPttPlayView;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

public class aioc
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VoiceTextPttPlayView jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView;
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramVoiceTextPanel.findViewById(2131377365));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramVoiceTextPanel.findViewById(2131381354));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView = ((VoiceTextPttPlayView)paramVoiceTextPanel.findViewById(2131377858));
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, int paramInt, VoiceTextPanel paramVoiceTextPanel)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView.setDuration(paramInt, paramString, paramRecorderParam, paramVoiceTextPanel);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView.a();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPttPlayView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */