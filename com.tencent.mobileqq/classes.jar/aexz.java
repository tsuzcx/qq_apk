import android.content.Context;
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
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import mqq.os.MqqHandler;

public class aexz
  extends aeyf
  implements View.OnClickListener
{
  private ajjj jdField_a_of_type_Ajjj;
  private ajnf jdField_a_of_type_Ajnf;
  
  public aexz(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Ajnf = ((ajnf)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bens = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166195);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aeya localaeya;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeya)))
    {
      localaeya = new aeya();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495535, localaeya);
      a(paramView, this.b);
      localaeya.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaeya.h = ((TextView)paramView.findViewById(2131305159));
      localaeya.i = ((TextView)paramView.findViewById(2131309446));
      localaeya.l = ((TextView)paramView.findViewById(2131296655));
      localaeya.j = ((TextView)paramView.findViewById(2131310547));
      localaeya.k = ((TextView)paramView.findViewById(2131309443));
      localaeya.a = ((Button)paramView.findViewById(2131309433));
      b(localaeya.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaeya);
      localaeya.g.setTag(localaeya);
      localaeya.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaeya, this);
      localObject = localaeya.g;
      if (this.jdField_a_of_type_Atcu.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((atco)this.jdField_a_of_type_Atcu).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localaeya.h.setVisibility(0);
      localaeya.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localaeya.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localaeya.i.setVisibility(8);
      localaeya.j.setText(ajjy.a(2131636725));
      localaeya.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Ajjj.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localaeya.a.setVisibility(8);
      localaeya.k.setVisibility(0);
      localaeya.k.setText(ajjy.a(2131636722));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localaeya.k.setContentDescription(ajjy.a(2131636726));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaeya.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localaeya.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localaeya = (aeya)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localaeya.h.setVisibility(8);
      break label293;
      label513:
      localaeya.a.setVisibility(0);
      localaeya.a.setText(ajjy.a(2131624088));
      localaeya.a.setTag(localObject);
      localaeya.a.setOnClickListener(this);
      localaeya.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localaeya.a.setContentDescription(ajjy.a(2131636723));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof aeya)));
        localObject = ((atco)this.jdField_a_of_type_Atcu).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_Ajnf.h();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(c());
      return;
    }
    paramView = (ContactMatch)paramView;
    if (paramView != null)
    {
      localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      int i = 3006;
      int j = 3;
      if (!((PhoneContactManagerImp)localObject).h())
      {
        i = 3075;
        j = 1;
      }
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, ajjy.a(2131636724), null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_Ajnf.h();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexz
 * JD-Core Version:    0.7.0.1
 */