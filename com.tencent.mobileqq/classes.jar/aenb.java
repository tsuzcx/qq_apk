import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;

class aenb
  implements View.OnClickListener
{
  aenb(aena paramaena) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (airz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    aizk localaizk = ((airz)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362597: 
    case 2131362596: 
    case 2131363456: 
    case 2131363455: 
    case 2131378283: 
    case 2131378034: 
    case 2131378317: 
    case 2131378093: 
      label620:
      do
      {
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.w(false);
        ((airz)localObject).a().a(this.a.a(), 319);
        return;
        this.a.v(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(BaseApplication.getContext(), 2131692321, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          return;
        }
        localaizk.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
        return;
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(BaseApplication.getContext(), 2131692321, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          return;
        }
        localaizk.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
        return;
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(BaseApplication.getContext(), 2131692321, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          return;
        }
        aena.a(this.a, (int)(System.currentTimeMillis() / 1000L));
        localaizk.a(aena.a(this.a).jdField_a_of_type_Int, aena.a(this.a));
        aena.a(this.a).a(1);
        VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { aena.a(this.a).jdField_a_of_type_Int + "" });
        return;
        if (!bbev.d(BaseApplication.getContext()))
        {
          bcpw.a(BaseApplication.getContext(), 2131692321, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          if (!aizt.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label620;
          }
          this.a.a(aena.a(this.a).jdField_a_of_type_Int, aena.a(this.a).jdField_a_of_type_Long, aena.a(this.a).a());
        }
        for (;;)
        {
          aena.a(this.a).dismiss();
          VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { aena.a(this.a).jdField_a_of_type_Int + "" });
          return;
          localaizk.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aena.a(this.a).jdField_a_of_type_Int, aena.a(this.a).jdField_a_of_type_Long);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localaizk.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aena.a(this.a).jdField_a_of_type_Int, aena.a(this.a).jdField_a_of_type_Long);
          aizg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aena.a(this.a).jdField_a_of_type_Int, aena.a(this.a).jdField_a_of_type_Long);
        }
        aena.a(this.a).dismiss();
        VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { aena.a(this.a).jdField_a_of_type_Int + "" });
        return;
        aena.a(this.a).dismiss();
      } while (aena.b(this.a) < 2);
      this.a.bp();
      return;
    }
    if (((ajxn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenb
 * JD-Core Version:    0.7.0.1
 */