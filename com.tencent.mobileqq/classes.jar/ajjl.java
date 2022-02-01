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

public class ajjl
  extends ajjr
  implements View.OnClickListener
{
  private ajka jdField_a_of_type_Ajka;
  private anyw jdField_a_of_type_Anyw;
  
  public ajjl(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_Anyw = ((anyw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Ajka = ((ajka)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297370);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajjm localajjm;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjm)))
    {
      localajjm = new ajjm();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561601, localajjm);
      a(paramView, this.b);
      localajjm.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajjm.h = ((TextView)paramView.findViewById(2131371827));
      localajjm.i = ((TextView)paramView.findViewById(2131376588));
      localajjm.l = ((TextView)paramView.findViewById(2131362302));
      localajjm.j = ((TextView)paramView.findViewById(2131377861));
      localajjm.k = ((TextView)paramView.findViewById(2131376585));
      localajjm.a = ((Button)paramView.findViewById(2131376575));
      b(localajjm.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajjm);
      localajjm.g.setTag(localajjm);
      localajjm.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajjm, this);
      localObject = localajjm.g;
      if (this.jdField_a_of_type_Ajmf.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((ajlz)this.jdField_a_of_type_Ajmf).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localajjm.h.setVisibility(0);
      localajjm.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localajjm.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localajjm.i.setVisibility(8);
      localajjm.j.setText(anzj.a(2131701418));
      localajjm.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Anyw.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localajjm.a.setVisibility(8);
      localajjm.k.setVisibility(0);
      localajjm.k.setText(anzj.a(2131701415));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localajjm.k.setContentDescription(anzj.a(2131701419));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localajjm.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localajjm.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localajjm = (ajjm)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localajjm.h.setVisibility(8);
      break label293;
      label513:
      localajjm.a.setVisibility(0);
      localajjm.a.setText(anzj.a(2131689551));
      localajjm.a.setTag(localObject);
      localajjm.a.setOnClickListener(this);
      localajjm.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localajjm.a.setContentDescription(anzj.a(2131701416));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
      if ((localObject1 != null) && ((localObject1 instanceof ajjm)))
      {
        Object localObject2 = ((ajlz)this.jdField_a_of_type_Ajmf).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).h = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_Ajka.h();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(c());
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
                localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, anzj.a(2131701417), null);
                ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_Ajka.h();
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjl
 * JD-Core Version:    0.7.0.1
 */