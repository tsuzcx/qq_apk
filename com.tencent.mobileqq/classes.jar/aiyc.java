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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class aiyc
  extends aiyi
  implements View.OnClickListener
{
  private aiyr jdField_a_of_type_Aiyr;
  private anmw jdField_a_of_type_Anmw;
  
  public aiyc(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aiyr = ((aiyr)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bkos = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297358);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aiyd localaiyd;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyd)))
    {
      localaiyd = new aiyd();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561560, localaiyd);
      a(paramView, this.b);
      localaiyd.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaiyd.h = ((TextView)paramView.findViewById(2131371720));
      localaiyd.i = ((TextView)paramView.findViewById(2131376456));
      localaiyd.l = ((TextView)paramView.findViewById(2131362290));
      localaiyd.j = ((TextView)paramView.findViewById(2131377713));
      localaiyd.k = ((TextView)paramView.findViewById(2131376453));
      localaiyd.a = ((Button)paramView.findViewById(2131376443));
      b(localaiyd.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaiyd);
      localaiyd.g.setTag(localaiyd);
      localaiyd.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajax, localaiyd, this);
      localObject = localaiyd.g;
      if (this.jdField_a_of_type_Ajax.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((ajar)this.jdField_a_of_type_Ajax).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localaiyd.h.setVisibility(0);
      localaiyd.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localaiyd.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localaiyd.i.setVisibility(8);
      localaiyd.j.setText(anni.a(2131701311));
      localaiyd.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Anmw.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localaiyd.a.setVisibility(8);
      localaiyd.k.setVisibility(0);
      localaiyd.k.setText(anni.a(2131701308));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localaiyd.k.setContentDescription(anni.a(2131701312));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaiyd.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localaiyd.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localaiyd = (aiyd)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localaiyd.h.setVisibility(8);
      break label293;
      label513:
      localaiyd.a.setVisibility(0);
      localaiyd.a.setText(anni.a(2131689550));
      localaiyd.a.setTag(localObject);
      localaiyd.a.setOnClickListener(this);
      localaiyd.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localaiyd.a.setContentDescription(anni.a(2131701309));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
      if ((localObject1 != null) && ((localObject1 instanceof aiyd)))
      {
        Object localObject2 = ((ajar)this.jdField_a_of_type_Ajax).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_Aiyr.h();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691985), 0).b(c());
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
                localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, anni.a(2131701310), null);
                ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_Aiyr.h();
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyc
 * JD-Core Version:    0.7.0.1
 */