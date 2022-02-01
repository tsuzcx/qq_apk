import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ajka
  extends ajjs
{
  private bily a;
  
  public ajka(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    if (paramQQAppInterface.isCreateManager(165)) {
      this.jdField_a_of_type_Bily = ((bily)paramQQAppInterface.getManager(165));
    }
    this.c = true;
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    label176:
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getParent();
      if ((localObject1 instanceof ViewGroup)) {}
      for (localObject1 = (ViewGroup)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label176;
        }
        if (bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          int i = ((ViewGroup)localObject1).indexOfChild(this.jdField_a_of_type_AndroidWidgetTextView);
          localObject2 = baql.a(this.jdField_a_of_type_AndroidContentContext);
          if (localObject2 == null) {
            break;
          }
          ((View)localObject2).setId(2131376666);
          ((View)localObject2).setPadding(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), 0, 0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(1, 2131378707);
          localLayoutParams.addRule(6, 2131378707);
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject1).addView((View)localObject2, i);
          return;
        }
        Object localObject2 = ((ViewGroup)localObject1).findViewById(2131376666);
        if (localObject2 == null) {
          break;
        }
        ((ViewGroup)localObject1).removeView((View)localObject2);
        return;
      }
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void f()
  {
    if (!this.d) {}
    label592:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnline = false;
                this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isTimUserOnline = false;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
                {
                  ahcd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  ahov.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                }
                if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnline) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnlineIcon)) {
                  break;
                }
                this.b.setTextColor(-1);
                this.b.setAlpha(0.8F);
                localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
                if ((localObject != null) && ((ContactUtils.getFriendStatus(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
                {
                  localObject = ContactUtils.getStatusName((Friends)localObject);
                  this.b.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
                  this.b.setCompoundDrawables(ahcd.a().b(5), null, null, null);
                  this.b.setOnClickListener(null);
                  this.b.setText((CharSequence)localObject);
                  e(true);
                  return;
                }
              } while (this.b.getVisibility() != 0);
              e(false);
              return;
              if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isTimUserOnline) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isTimUserTitleForm)) {
                break;
              }
              this.b.setTextColor(-1);
              this.b.setAlpha(0.8F);
              localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
              if ((localObject != null) && ((ContactUtils.getFriendStatus(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
              {
                localObject = ContactUtils.getStatusName((Friends)localObject);
                this.b.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.b.setCompoundDrawables(ahov.a().b(5), null, null, null);
                this.b.setText((CharSequence)localObject);
                e(true);
                return;
              }
            } while (this.b.getVisibility() != 0);
            e(false);
            return;
            this.b.setTextColor(-1);
            this.b.setAlpha(0.8F);
            this.b.setCompoundDrawables(null, null, null, null);
            this.b.setOnClickListener(null);
            System.currentTimeMillis();
          } while ((!this.c) || ((this.jdField_a_of_type_Bily != null) && (this.jdField_a_of_type_Bily.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))));
          localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008);
        localObject = ((amsw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        if ((localObject == null) || ((ContactUtils.getFriendStatus(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && ((TextUtils.isEmpty(((Friends)localObject).strTermDesc)) || (!((Friends)localObject).strTermDesc.contains("TIM"))))) {
          break label592;
        }
        localObject = ContactUtils.getStatusName((Friends)localObject);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
          break;
        }
        this.b.setText((CharSequence)localObject);
        e(true);
      } while (!AppSetting.c);
      this.b.setContentDescription((CharSequence)localObject);
      return;
      e(false);
      return;
    } while (this.b.getVisibility() != 0);
    e(false);
  }
  
  protected void g()
  {
    this.e = true;
    super.g();
    if (this.d)
    {
      f();
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        ViewUtils.setVisible(this.jdField_a_of_type_AndroidWidgetImageView, 0);
      }
    }
    A();
  }
  
  protected void u()
  {
    super.u();
  }
  
  protected void v()
  {
    super.v();
  }
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForC2C";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajka
 * JD-Core Version:    0.7.0.1
 */