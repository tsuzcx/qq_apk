import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class aidu
  extends aiea
  implements View.OnClickListener
{
  private aiej jdField_a_of_type_Aiej;
  private amsw jdField_a_of_type_Amsw;
  
  public aidu(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aiej = ((aiej)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bjty = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297425);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aidv localaidv;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof aidv)))
    {
      localaidv = new aidv();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561479, localaidv);
      a(paramView, this.b);
      localaidv.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaidv.h = ((TextView)paramView.findViewById(2131371791));
      localaidv.i = ((TextView)paramView.findViewById(2131376354));
      localaidv.l = ((TextView)paramView.findViewById(2131362305));
      localaidv.j = ((TextView)paramView.findViewById(2131377631));
      localaidv.k = ((TextView)paramView.findViewById(2131376351));
      localaidv.a = ((Button)paramView.findViewById(2131376341));
      b(localaidv.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaidv);
      localaidv.g.setTag(localaidv);
      localaidv.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Aigo, localaidv, this);
      localObject = localaidv.g;
      if (this.jdField_a_of_type_Aigo.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((aigi)this.jdField_a_of_type_Aigo).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localaidv.h.setVisibility(0);
      localaidv.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localaidv.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localaidv.i.setVisibility(8);
      localaidv.j.setText(amtj.a(2131701653));
      localaidv.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Amsw.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localaidv.a.setVisibility(8);
      localaidv.k.setVisibility(0);
      localaidv.k.setText(amtj.a(2131701650));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localaidv.k.setContentDescription(amtj.a(2131701654));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaidv.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localaidv.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localaidv = (aidv)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localaidv.h.setVisibility(8);
      break label293;
      label513:
      localaidv.a.setVisibility(0);
      localaidv.a.setText(amtj.a(2131689550));
      localaidv.a.setTag(localObject);
      localaidv.a.setOnClickListener(this);
      localaidv.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localaidv.a.setContentDescription(amtj.a(2131701651));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof aidv)))
      {
        Object localObject2 = ((aigi)this.jdField_a_of_type_Aigo).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_Aiej.h();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(c());
            }
            else
            {
              localObject1 = (ContactMatch)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
                int i = 3006;
                int j = 3;
                if (!((PhoneContactManagerImp)localObject2).i())
                {
                  i = 3075;
                  j = 1;
                }
                localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, amtj.a(2131701652), null);
                ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_Aiej.h();
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidu
 * JD-Core Version:    0.7.0.1
 */