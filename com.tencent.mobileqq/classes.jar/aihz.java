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

class aihz
  implements View.OnClickListener
{
  aihz(aihy paramaihy) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (amsx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    anaj localanaj = ((amsx)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362750: 
    case 2131362749: 
    case 2131363718: 
    case 2131363717: 
    case 2131379994: 
    case 2131379664: 
    case 2131380043: 
    case 2131379739: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.y(false);
        ((amsx)localObject).a().a(this.a.a(), 319);
        continue;
        this.a.x(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!bhnv.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131691989, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
        }
        else
        {
          localanaj.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!bhnv.d(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131691989, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
          }
          else
          {
            localanaj.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!bhnv.d(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131691989, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
            }
            else
            {
              aihy.a(this.a, (int)(System.currentTimeMillis() / 1000L));
              localanaj.a(aihy.a(this.a).jdField_a_of_type_Int, aihy.a(this.a));
              aihy.a(this.a).a(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { aihy.a(this.a).jdField_a_of_type_Int + "" });
              continue;
              if (!bhnv.d(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131691989, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
              }
              else
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  if (!anas.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label645;
                  }
                  this.a.a(aihy.a(this.a).jdField_a_of_type_Int, aihy.a(this.a).jdField_a_of_type_Long, aihy.a(this.a).a());
                }
                for (;;)
                {
                  aihy.a(this.a).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { aihy.a(this.a).jdField_a_of_type_Int + "" });
                  break;
                  label645:
                  localanaj.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aihy.a(this.a).jdField_a_of_type_Int, aihy.a(this.a).jdField_a_of_type_Long);
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  localanaj.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aihy.a(this.a).jdField_a_of_type_Int, aihy.a(this.a).jdField_a_of_type_Long);
                  anaf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aihy.a(this.a).jdField_a_of_type_Int, aihy.a(this.a).jdField_a_of_type_Long);
                }
                aihy.a(this.a).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { aihy.a(this.a).jdField_a_of_type_Int + "" });
                continue;
                aihy.a(this.a).dismiss();
                if (aihy.b(this.a) >= 2) {
                  this.a.bp();
                }
              }
            }
          }
        }
      }
    }
    if (((anyw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
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
 * Qualified Name:     aihz
 * JD-Core Version:    0.7.0.1
 */