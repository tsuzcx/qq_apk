import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class aetn
  extends aeom
  implements Handler.Callback, awgc
{
  public RobotChatPanelLayout a;
  private RobotChatTipLayout a;
  private View o;
  
  public aetn(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean D()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Xbm != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Xbm.a())
      {
        this.jdField_a_of_type_Xbm.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void bo()
  {
    if (bbkb.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (!(this.jdField_a_of_type_AndroidViewView instanceof ViewGroup)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = new RobotChatTipLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a(this);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout, 0);
  }
  
  private void bp()
  {
    Object localObject = (ViewGroup)this.e.getParent();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a();
    localObject = (ImageView)this.c.findViewById(2131377393);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(awgd.a(this.jdField_a_of_type_AndroidContentContext));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (adjp)this.jdField_a_of_type_Adia.a(23);
    if (localObject != null) {
      ((adjp)localObject).b();
    }
    if (this.jdField_a_of_type_Alua != null)
    {
      this.jdField_a_of_type_Alua.b();
      this.jdField_a_of_type_Alua = null;
    }
  }
  
  public void A()
  {
    super.A();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(d());
    }
  }
  
  public boolean E()
  {
    return false;
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy:");
    }
    adjp localadjp = (adjp)this.jdField_a_of_type_Adia.a(23);
    if (localadjp != null) {
      localadjp.c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    if ((this.o != null) && (this.o.getParent() != null))
    {
      ((ViewGroup)this.o.getParent()).removeView(this.o);
      this.o = null;
    }
    super.G();
  }
  
  public void M()
  {
    super.M();
    adjb localadjb = (adjb)a(36);
    if ((localadjb != null) && (localadjb.a())) {
      localadjb.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void O()
  {
    super.O();
    adjb localadjb = (adjb)a(36);
    if ((localadjb != null) && (localadjb.a())) {
      localadjb.a(a());
    }
  }
  
  public void Z()
  {
    super.Z();
    adjb localadjb = (adjb)a(36);
    if ((localadjb != null) && (localadjb.a())) {
      localadjb.a(a());
    }
  }
  
  public adfp a()
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "RobotChatPie";
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    adjb localadjb = (adjb)a(36);
    if ((localadjb != null) && (localadjb.a())) {
      localadjb.c();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    bo();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(d());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, d(), this, new aeto(this));
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    adjp localadjp = (adjp)this.jdField_a_of_type_Adia.a(23);
    if ((localadjp != null) && (localadjp.a(paramMotionEvent, this.L))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    bbkb.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ViewGroup)))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_f_of_type_AndroidViewView != null) {
      super.a(paramBoolean1, paramBoolean2);
    }
    adjp localadjp;
    do
    {
      return;
      super.a(paramBoolean1, paramBoolean2);
      localadjp = (adjp)this.jdField_a_of_type_Adia.a(23);
    } while (localadjp == null);
    localadjp.a(this.jdField_f_of_type_AndroidViewView);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void af()
  {
    super.af();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onShow_otherThings:");
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.afterTextChanged(paramEditable);
      if (this.jdField_f_of_type_Int == 0)
      {
        paramEditable = (adjb)a(36);
        if ((paramEditable != null) && (paramEditable.a())) {
          paramEditable.b(bool);
        }
      }
      return;
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new aetp(this));
  }
  
  public void bi() {}
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    adjb localadjb = (adjb)a(36);
    if ((localadjb != null) && (localadjb.a())) {
      localadjb.a(paramInt1, paramInt2);
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    adjp localadjp = (adjp)this.jdField_a_of_type_Adia.a(23);
    if (localadjp != null) {
      localadjp.a(paramIntent);
    }
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void f()
  {
    super.f();
    bp();
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "leftBackEvent begin:" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "no confirm dialog");
    }
    super.f(paramBoolean);
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    adjp localadjp = (adjp)this.jdField_a_of_type_Adia.a(23);
    if (localadjp != null) {
      localadjp.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (D()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "no confirm dialog");
    }
    return super.i();
  }
  
  public void o() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      adjb localadjb = (adjb)a(36);
      if ((localadjb != null) && (localadjb.a())) {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0)
        {
          localadjb.a(false);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
        }
        else
        {
          localadjb.a(true);
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
    }
    paramCharSequence = (adjp)a(23);
    if (paramCharSequence != null) {
      paramCharSequence.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
    }
  }
  
  public void s()
  {
    if (this.d != null)
    {
      this.d.setVisibility(4);
      ThreadManager.post(new RobotChatPie.3(this), 5, null, false);
    }
  }
  
  public void x()
  {
    bail.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    axqy.b(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetn
 * JD-Core Version:    0.7.0.1
 */