import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahzd
  implements View.OnClickListener
{
  ahzd(ahzc paramahzc) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (amme)this.a.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    amuf localamuf = ((amme)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362771: 
    case 2131362770: 
    case 2131363818: 
    case 2131363817: 
    case 2131380076: 
    case 2131379751: 
    case 2131380120: 
    case 2131379833: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.d(false);
        ((amme)localObject).a().a(this.a.getCurFriendUin(), 319);
        continue;
        this.a.c(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692125, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
        }
        else
        {
          localamuf.f(this.a.sessionInfo.curFriendUin);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131692125, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
          }
          else
          {
            localamuf.g(this.a.sessionInfo.curFriendUin);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131692125, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
            }
            else
            {
              ahzc.a(this.a, (int)(System.currentTimeMillis() / 1000L));
              localamuf.a(ahzc.a(this.a).jdField_a_of_type_Int, ahzc.a(this.a));
              ahzc.a(this.a).a(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { ahzc.a(this.a).jdField_a_of_type_Int + "" });
              continue;
              if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131692125, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
              }
              else
              {
                if ((this.a.app != null) && (this.a.sessionInfo != null))
                {
                  if (!amuo.a(this.a.sessionInfo.curFriendUin)) {
                    break label645;
                  }
                  this.a.a(ahzc.a(this.a).jdField_a_of_type_Int, ahzc.a(this.a).jdField_a_of_type_Long, ahzc.a(this.a).a());
                }
                for (;;)
                {
                  ahzc.a(this.a).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { ahzc.a(this.a).jdField_a_of_type_Int + "" });
                  break;
                  label645:
                  localamuf.a(true, this.a.sessionInfo.curFriendUin, ahzc.a(this.a).jdField_a_of_type_Int, ahzc.a(this.a).jdField_a_of_type_Long);
                }
                if ((this.a.app != null) && (this.a.sessionInfo != null))
                {
                  localamuf.a(false, this.a.sessionInfo.curFriendUin, ahzc.a(this.a).jdField_a_of_type_Int, ahzc.a(this.a).jdField_a_of_type_Long);
                  amub.a(this.a.app, this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, ahzc.a(this.a).jdField_a_of_type_Int, ahzc.a(this.a).jdField_a_of_type_Long);
                }
                ahzc.a(this.a).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { ahzc.a(this.a).jdField_a_of_type_Int + "" });
                continue;
                ahzc.a(this.a).dismiss();
                if (ahzc.b(this.a) >= 2) {
                  this.a.b();
                }
              }
            }
          }
        }
      }
    }
    if (((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.sessionInfo.curFriendUin)) {
      localObject = new ProfileActivity.AllInOne(this.a.sessionInfo.curFriendUin, 1);
    }
    for (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.sessionInfo.curFriendNick;; ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.sessionInfo.curFriendNick)
    {
      ((ProfileActivity.AllInOne)localObject).f = this.a.sessionInfo.curFriendUin;
      ((ProfileActivity.AllInOne)localObject).e = this.a.sessionInfo.curType;
      ((ProfileActivity.AllInOne)localObject).g = 2;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      VipUtils.a(null, "cmshow", "Apollo", "clickArea", 0, 0, new String[] { "" });
      break;
      localObject = new ProfileActivity.AllInOne(this.a.sessionInfo.curFriendUin, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzd
 * JD-Core Version:    0.7.0.1
 */