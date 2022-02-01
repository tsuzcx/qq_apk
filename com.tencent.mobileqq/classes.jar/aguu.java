import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class aguu
  extends agwl
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = avln.jdField_a_of_type_JavaLangString + "GameMsgChatHelper";
  }
  
  public aguu(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private avlc a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aikg)))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, " param error.");
      return null;
    }
    return ((aikg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a();
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
    {
      Object localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131367329);
      Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).width = agej.a(60.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).height = agej.a(34.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690669);
        if (AppSetting.c) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(anzj.a(2131713050));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
    }
  }
  
  public void c()
  {
    super.c();
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131367329);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      avlc localavlc = a();
      if (localavlc != null) {
        avlf.a(localavlc.c, "1", "145", "920", "92005", "206353", "", "", "20", "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */