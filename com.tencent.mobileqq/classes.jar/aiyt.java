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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class aiyt
  extends aiyz
  implements View.OnClickListener
{
  private aizi jdField_a_of_type_Aizi;
  private anvk jdField_a_of_type_Anvk;
  
  public aiyt(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_Anvk = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_Aizi = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297426);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aiyu localaiyu;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyu)))
    {
      localaiyu = new aiyu();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561541, localaiyu);
      a(paramView, this.b);
      localaiyu.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localaiyu.h = ((TextView)paramView.findViewById(2131371981));
      localaiyu.i = ((TextView)paramView.findViewById(2131376609));
      localaiyu.l = ((TextView)paramView.findViewById(2131362310));
      localaiyu.j = ((TextView)paramView.findViewById(2131377905));
      localaiyu.k = ((TextView)paramView.findViewById(2131376606));
      localaiyu.a = ((Button)paramView.findViewById(2131376596));
      b(localaiyu.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaiyu);
      localaiyu.g.setTag(localaiyu);
      localaiyu.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localaiyu, this);
      localObject = localaiyu.g;
      if (this.jdField_a_of_type_Ajbn.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((ajbh)this.jdField_a_of_type_Ajbn).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localaiyu.h.setVisibility(0);
      localaiyu.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localaiyu.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localaiyu.i.setVisibility(8);
      localaiyu.j.setText(anvx.a(2131702004));
      localaiyu.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Anvk.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localaiyu.a.setVisibility(8);
      localaiyu.k.setVisibility(0);
      localaiyu.k.setText(anvx.a(2131702001));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localaiyu.k.setContentDescription(anvx.a(2131702005));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaiyu.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localaiyu.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localaiyu = (aiyu)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localaiyu.h.setVisibility(8);
      break label293;
      label513:
      localaiyu.a.setVisibility(0);
      localaiyu.a.setText(anvx.a(2131689550));
      localaiyu.a.setTag(localObject);
      localaiyu.a.setOnClickListener(this);
      localaiyu.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localaiyu.a.setContentDescription(anvx.a(2131702002));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
      if ((localObject1 != null) && ((localObject1 instanceof aiyu)))
      {
        Object localObject2 = ((ajbh)this.jdField_a_of_type_Ajbn).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).i()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_Aizi.h();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(c());
            }
            else
            {
              localObject1 = (ContactMatch)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
                int i = 3006;
                int j = 3;
                if (!((PhoneContactManagerImp)localObject2).i())
                {
                  i = 3075;
                  j = 1;
                }
                localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, anvx.a(2131702003), null);
                ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_Aizi.h();
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyt
 * JD-Core Version:    0.7.0.1
 */