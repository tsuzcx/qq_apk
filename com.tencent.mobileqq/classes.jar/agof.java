import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class agof
  implements View.OnClickListener
{
  agof(agoe paramagoe) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aknx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    akvj localakvj = ((aknx)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362624: 
    case 2131362623: 
    case 2131363497: 
    case 2131363496: 
    case 2131378923: 
    case 2131378639: 
    case 2131378967: 
    case 2131378704: 
      label620:
      do
      {
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.w(false);
        ((aknx)localObject).a().a(this.a.a(), 319);
        return;
        this.a.v(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692398, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          return;
        }
        localakvj.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
        return;
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692398, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          return;
        }
        localakvj.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
        return;
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692398, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          return;
        }
        agoe.a(this.a, (int)(System.currentTimeMillis() / 1000L));
        localakvj.a(agoe.a(this.a).jdField_a_of_type_Int, agoe.a(this.a));
        agoe.a(this.a).a(1);
        VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { agoe.a(this.a).jdField_a_of_type_Int + "" });
        return;
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692398, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          if (!akvs.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label620;
          }
          this.a.a(agoe.a(this.a).jdField_a_of_type_Int, agoe.a(this.a).jdField_a_of_type_Long, agoe.a(this.a).a());
        }
        for (;;)
        {
          agoe.a(this.a).dismiss();
          VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { agoe.a(this.a).jdField_a_of_type_Int + "" });
          return;
          localakvj.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, agoe.a(this.a).jdField_a_of_type_Int, agoe.a(this.a).jdField_a_of_type_Long);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localakvj.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, agoe.a(this.a).jdField_a_of_type_Int, agoe.a(this.a).jdField_a_of_type_Long);
          akvf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, agoe.a(this.a).jdField_a_of_type_Int, agoe.a(this.a).jdField_a_of_type_Long);
        }
        agoe.a(this.a).dismiss();
        VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { agoe.a(this.a).jdField_a_of_type_Int + "" });
        return;
        agoe.a(this.a).dismiss();
      } while (agoe.b(this.a) < 2);
      this.a.bs();
      return;
    }
    if (((alto)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    }
    for (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)
    {
      ((ProfileActivity.AllInOne)localObject).f = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((ProfileActivity.AllInOne)localObject).e = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ((ProfileActivity.AllInOne)localObject).g = 2;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      VipUtils.a(null, "cmshow", "Apollo", "clickArea", 0, 0, new String[] { "" });
      return;
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agof
 * JD-Core Version:    0.7.0.1
 */