import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class aeyx
{
  private int jdField_a_of_type_Int;
  protected ViewGroup a;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private VoiceTextEditPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel;
  private final String jdField_a_of_type_JavaLangString = "VoiceTextEditStateHelper";
  private ViewGroup b;
  
  private void d()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showEditStatusMask topMaskPanel is nll = ");
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VoiceTextEditStateHelper", 2, bool);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getContext()) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getBottom());
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setOnTouchListener(new aeyy(this));
  }
  
  public int a()
  {
    Rect localRect1 = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    this.b.getGlobalVisibleRect(localRect2);
    Rect localRect3 = new Rect();
    this.jdField_a_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect3);
    int j = localRect3.bottom;
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
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditStateHelper", 2, "initMask height=" + i + " rect.width()=" + localRect1.width() + " inputRect=" + localRect2 + " panelIcons=" + localRect3);
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("dismissTopMaskPanel topMaskPanel is nll = ");
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VoiceTextEditStateHelper", 2, bool);
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEditStateHelper", 2, "dismissTopMaskPanel");
        }
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("initMask topMaskPanel is nll = ");
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
      {
        bool = true;
        QLog.d("VoiceTextEditStateHelper", 2, bool + " isExit =" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.a);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.a) {
        break label75;
      }
    }
    label75:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a();
      e();
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break label126;
      }
    } while (paramInt2 == this.jdField_a_of_type_AndroidWidgetPopupWindow.getHeight());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
    return;
    label126:
    this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
    e();
  }
  
  public void a(ViewGroup paramViewGroup1, VoiceTextEditPanel paramVoiceTextEditPanel, ViewGroup paramViewGroup2, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel = paramVoiceTextEditPanel;
    this.b = paramViewGroup2;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.getContext()) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getBottom());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(false);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aM();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyx
 * JD-Core Version:    0.7.0.1
 */