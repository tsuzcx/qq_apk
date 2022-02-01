import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahel
  implements View.OnClickListener
{
  ahel(ahek paramahek) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (alnr)this.a.app.getManager(153);
    alvd localalvd = ((alnr)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362755: 
    case 2131362754: 
    case 2131363747: 
    case 2131363746: 
    case 2131379756: 
    case 2131379446: 
    case 2131379796: 
    case 2131379523: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.d(false);
        ((alnr)localObject).a().a(this.a.getCurFriendUin(), 319);
        continue;
        this.a.c(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692035, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
        }
        else
        {
          localalvd.f(this.a.sessionInfo.curFriendUin);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131692035, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
          }
          else
          {
            localalvd.g(this.a.sessionInfo.curFriendUin);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131692035, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
            }
            else
            {
              ahek.a(this.a, (int)(System.currentTimeMillis() / 1000L));
              localalvd.a(ahek.a(this.a).jdField_a_of_type_Int, ahek.a(this.a));
              ahek.a(this.a).a(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { ahek.a(this.a).jdField_a_of_type_Int + "" });
              continue;
              if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131692035, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
              }
              else
              {
                if ((this.a.app != null) && (this.a.sessionInfo != null))
                {
                  if (!alvm.a(this.a.sessionInfo.curFriendUin)) {
                    break label645;
                  }
                  this.a.a(ahek.a(this.a).jdField_a_of_type_Int, ahek.a(this.a).jdField_a_of_type_Long, ahek.a(this.a).a());
                }
                for (;;)
                {
                  ahek.a(this.a).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { ahek.a(this.a).jdField_a_of_type_Int + "" });
                  break;
                  label645:
                  localalvd.a(true, this.a.sessionInfo.curFriendUin, ahek.a(this.a).jdField_a_of_type_Int, ahek.a(this.a).jdField_a_of_type_Long);
                }
                if ((this.a.app != null) && (this.a.sessionInfo != null))
                {
                  localalvd.a(false, this.a.sessionInfo.curFriendUin, ahek.a(this.a).jdField_a_of_type_Int, ahek.a(this.a).jdField_a_of_type_Long);
                  aluz.a(this.a.app, this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, ahek.a(this.a).jdField_a_of_type_Int, ahek.a(this.a).jdField_a_of_type_Long);
                }
                ahek.a(this.a).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { ahek.a(this.a).jdField_a_of_type_Int + "" });
                continue;
                ahek.a(this.a).dismiss();
                if (ahek.b(this.a) >= 2) {
                  this.a.b();
                }
              }
            }
          }
        }
      }
    }
    if (((amsw)this.a.app.getManager(51)).b(this.a.sessionInfo.curFriendUin)) {
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
 * Qualified Name:     ahel
 * JD-Core Version:    0.7.0.1
 */