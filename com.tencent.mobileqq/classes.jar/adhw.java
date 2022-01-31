import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.1;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class adhw
  implements adif, View.OnClickListener
{
  public Context a;
  public View a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public ImageButton a;
  public LinearLayout a;
  public BaseChatPie a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PatchedButton a;
  private boolean jdField_a_of_type_Boolean;
  public ImageButton b;
  
  public adhw(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new FullScreenInputHelper.4(this));
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    if ((i >= 1000) && (i <= 1038)) {
      return 3;
    }
    switch (i)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    c(true);
    actj.k = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m();
    ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "full_screen_input", true);
    actj.l = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno.k();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno.d = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bm();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Anow != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Anow.c();
    }
    ((anoi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(214)).c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.E();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bl();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.B());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    this.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(actj.a(24.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(24.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -1;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 11) {
      b();
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131366871);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131366868));
    this.b = ((ImageButton)paramViewGroup.findViewById(2131367518));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131366884));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)paramViewGroup.findViewById(2131366869));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(ajya.a(2131704972));
      this.b.setContentDescription(ajya.a(2131704969));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new adhx(this) });
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramViewGroup = new adhy(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomInsertionActionModeCallback(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomSelectionActionModeCallback(paramViewGroup);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    c(false);
    actj.k = false;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) {
        ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "full_screen_input", false);
      }
    }
    actj.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Azno.d = false;
    }
    ((anoi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(214)).c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.s(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.b.setVisibility(8);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.F();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, actj.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(actj.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(actj.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, actj.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(actj.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(actj.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), actj.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().postDelayed(new FullScreenInputHelper.1(this), 100L);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramEditable != null) && (paramEditable.length() > 0))
      {
        b(true);
        return true;
      }
      b(false);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) && (!axmv.b())) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  public int[] a()
  {
    return new int[] { 11 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new adhz(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367518: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F36", "0X8009F36", a(), 0, "", "", "", "");
      a(false);
      return;
    case 2131366868: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F27", "0X8009F27", a(), 0, "", "", "", "");
      a();
      return;
    }
    if (a()) {
      a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhw
 * JD-Core Version:    0.7.0.1
 */