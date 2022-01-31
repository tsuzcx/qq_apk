import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class aecc
  implements View.OnClickListener
{
  aecc(aecb paramaecb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aifg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    aimr localaimr = ((aifg)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131297058: 
    case 2131297057: 
    case 2131297910: 
    case 2131297909: 
    case 2131312456: 
    case 2131312211: 
    case 2131312491: 
    case 2131312273: 
      label620:
      do
      {
        return;
        bajr.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.w(false);
        ((aifg)localObject).a().a(this.a.a(), 319);
        return;
        this.a.v(false);
        bajr.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(BaseApplication.getContext(), 2131626719, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
          return;
        }
        localaimr.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        bajr.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
        return;
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(BaseApplication.getContext(), 2131626719, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
          return;
        }
        localaimr.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        bajr.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
        return;
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(BaseApplication.getContext(), 2131626719, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
          return;
        }
        aecb.a(this.a, (int)(System.currentTimeMillis() / 1000L));
        localaimr.a(aecb.a(this.a).jdField_a_of_type_Int, aecb.a(this.a));
        aecb.a(this.a).a(1);
        bajr.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { aecb.a(this.a).jdField_a_of_type_Int + "" });
        return;
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(BaseApplication.getContext(), 2131626719, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
          return;
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          if (!aina.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label620;
          }
          this.a.a(aecb.a(this.a).jdField_a_of_type_Int, aecb.a(this.a).jdField_a_of_type_Long, aecb.a(this.a).a());
        }
        for (;;)
        {
          aecb.a(this.a).dismiss();
          bajr.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { aecb.a(this.a).jdField_a_of_type_Int + "" });
          return;
          localaimr.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aecb.a(this.a).jdField_a_of_type_Int, aecb.a(this.a).jdField_a_of_type_Long);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localaimr.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aecb.a(this.a).jdField_a_of_type_Int, aecb.a(this.a).jdField_a_of_type_Long);
          aimn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aecb.a(this.a).jdField_a_of_type_Int, aecb.a(this.a).jdField_a_of_type_Long);
        }
        aecb.a(this.a).dismiss();
        bajr.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { aecb.a(this.a).jdField_a_of_type_Int + "" });
        return;
        aecb.a(this.a).dismiss();
      } while (aecb.b(this.a) < 2);
      this.a.bn();
      return;
    }
    if (((ajjj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    }
    for (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)
    {
      ((ProfileActivity.AllInOne)localObject).f = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((ProfileActivity.AllInOne)localObject).e = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ((ProfileActivity.AllInOne)localObject).g = 2;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      bajr.a(null, "cmshow", "Apollo", "clickArea", 0, 0, new String[] { "" });
      return;
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecc
 * JD-Core Version:    0.7.0.1
 */