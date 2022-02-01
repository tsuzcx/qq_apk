import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;

public class aiym
  extends aiyf
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aiyn(this);
  private Button b;
  
  public aiym(aixy paramaixy, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    super(paramQQAppInterface, paramaixy);
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
  }
  
  private void b(boolean paramBoolean)
  {
    a().d(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(paramBoolean);
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("businessinfo_ptt_vt_send_type_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    return bool;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("businessinfo_ptt_vt_send_type_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean).commit();
    }
  }
  
  private void e()
  {
    if (a().a())
    {
      aiyu.a("0X800A1D8", 2, 0);
      return;
    }
    aiyu.a("0X800A1D8", 1, 0);
  }
  
  private void f()
  {
    if (a().a())
    {
      aiyu.a("0X800A1D9", 2, 0);
      return;
    }
    aiyu.a("0X800A1D9", 1, 0);
  }
  
  private void g()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.b.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167023));
    }
  }
  
  private void h()
  {
    View localView = (View)this.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    localView.post(new VoiceTextSendViewHelper.4(this, bdep.a(8.0F), localView));
  }
  
  public void a()
  {
    b(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717898);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramVoiceTextPanel.findViewById(2131377314));
    this.b = ((Button)paramVoiceTextPanel.findViewById(2131364153));
    this.b.setOnClickListener(new aiyo(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aiyp(this));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramVoiceTextPanel.findViewById(2131364511));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    h();
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public void c()
  {
    boolean bool = b();
    b(true);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      a().c(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131717900);
      a(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    a().c(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717898);
    a(false);
  }
  
  public void d()
  {
    a(true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    a().c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiym
 * JD-Core Version:    0.7.0.1
 */