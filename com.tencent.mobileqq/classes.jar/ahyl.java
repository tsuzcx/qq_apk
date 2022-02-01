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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyl
  implements View.OnClickListener
{
  ahyl(ahyk paramahyk) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (amhd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    amop localamop = ((amhd)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362732: 
    case 2131362731: 
    case 2131363693: 
    case 2131363692: 
    case 2131379814: 
    case 2131379495: 
    case 2131379863: 
    case 2131379566: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.y(false);
        ((amhd)localObject).a().a(this.a.a(), 319);
        continue;
        this.a.x(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!bgnt.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131691985, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
        }
        else
        {
          localamop.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!bgnt.d(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131691985, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
          }
          else
          {
            localamop.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!bgnt.d(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131691985, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
            }
            else
            {
              ahyk.a(this.a, (int)(System.currentTimeMillis() / 1000L));
              localamop.a(ahyk.a(this.a).jdField_a_of_type_Int, ahyk.a(this.a));
              ahyk.a(this.a).a(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { ahyk.a(this.a).jdField_a_of_type_Int + "" });
              continue;
              if (!bgnt.d(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131691985, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
              }
              else
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  if (!amoy.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label645;
                  }
                  this.a.a(ahyk.a(this.a).jdField_a_of_type_Int, ahyk.a(this.a).jdField_a_of_type_Long, ahyk.a(this.a).a());
                }
                for (;;)
                {
                  ahyk.a(this.a).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { ahyk.a(this.a).jdField_a_of_type_Int + "" });
                  break;
                  label645:
                  localamop.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ahyk.a(this.a).jdField_a_of_type_Int, ahyk.a(this.a).jdField_a_of_type_Long);
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  localamop.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ahyk.a(this.a).jdField_a_of_type_Int, ahyk.a(this.a).jdField_a_of_type_Long);
                  amol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ahyk.a(this.a).jdField_a_of_type_Int, ahyk.a(this.a).jdField_a_of_type_Long);
                }
                ahyk.a(this.a).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { ahyk.a(this.a).jdField_a_of_type_Int + "" });
                continue;
                ahyk.a(this.a).dismiss();
                if (ahyk.b(this.a) >= 2) {
                  this.a.bp();
                }
              }
            }
          }
        }
      }
    }
    if (((anmw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
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
      break;
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyl
 * JD-Core Version:    0.7.0.1
 */