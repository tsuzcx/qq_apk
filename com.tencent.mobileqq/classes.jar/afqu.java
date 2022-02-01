import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class afqu
  extends afss
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = atyn.jdField_a_of_type_JavaLangString + "GameMsgChatHelper";
  }
  
  public afqu(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private atyc a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahfp)))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, " param error.");
      return null;
    }
    return ((ahfp)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn != null)
    {
      Object localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353);
      Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn;
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).width = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).height = AIOUtils.dp2px(34.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setVisibility(0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setBackgroundResource(a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setText(2131690709);
        if (AppSetting.c) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setContentDescription(amtj.a(2131713282));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(false);
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
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView.findViewById(2131367353);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mFunBtn.setEnabled(false);
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
      atyc localatyc = a();
      if (localatyc != null) {
        atyf.a(localatyc.c, "1", "145", "920", "92005", "206353", "", "", "20", "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqu
 * JD-Core Version:    0.7.0.1
 */