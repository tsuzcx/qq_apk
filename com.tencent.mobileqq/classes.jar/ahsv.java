import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ahsv
{
  private int jdField_a_of_type_Int;
  protected ViewGroup a;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private ViewGroup b;
  
  private void d()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.getBottom());
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setOnTouchListener(new ahsw(this));
  }
  
  public int a()
  {
    Rect localRect1 = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    this.b.getGlobalVisibleRect(localRect2);
    localRect2 = new Rect();
    this.jdField_a_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect2);
    int j = localRect2.bottom;
    int i;
    if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
    {
      i = j;
      if (Build.MODEL.startsWith("ivvi"))
      {
        i = j;
        if (Build.VERSION.SDK_INT != 22) {}
      }
    }
    else
    {
      i = j - localRect1.top;
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextMaskViewHelper", 2, "dismissTopMaskPanel");
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
    e();
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      if (paramInt2 != this.jdField_a_of_type_AndroidWidgetPopupWindow.getHeight()) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
    e();
  }
  
  public void a(ViewGroup paramViewGroup1, VoiceTextPanel paramVoiceTextPanel, ViewGroup paramViewGroup2, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.b = paramViewGroup2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.getBottom());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showAudioPanel(false);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAllPanels();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsv
 * JD-Core Version:    0.7.0.1
 */