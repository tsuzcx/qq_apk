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

public class afjn
  extends afjt
  implements View.OnClickListener
{
  private ajxl jdField_a_of_type_Ajxl;
  private akbn jdField_a_of_type_Akbn;
  
  public afjn(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Akbn = ((akbn)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bfwd = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afjo localafjo;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjo)))
    {
      localafjo = new afjo();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561122, localafjo);
      a(paramView, this.b);
      localafjo.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafjo.h = ((TextView)paramView.findViewById(2131370832));
      localafjo.i = ((TextView)paramView.findViewById(2131375196));
      localafjo.l = ((TextView)paramView.findViewById(2131362195));
      localafjo.j = ((TextView)paramView.findViewById(2131376341));
      localafjo.k = ((TextView)paramView.findViewById(2131375193));
      localafjo.a = ((Button)paramView.findViewById(2131375183));
      b(localafjo.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjo);
      localafjo.g.setTag(localafjo);
      localafjo.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atza, localafjo, this);
      localObject = localafjo.g;
      if (this.jdField_a_of_type_Atza.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((atyu)this.jdField_a_of_type_Atza).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localafjo.h.setVisibility(0);
      localafjo.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.d) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localafjo.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localafjo.i.setVisibility(8);
      localafjo.j.setText(ajya.a(2131702520));
      localafjo.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Ajxl.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localafjo.a.setVisibility(8);
      localafjo.k.setVisibility(0);
      localafjo.k.setText(ajya.a(2131702517));
      if (AppSetting.d)
      {
        localStringBuilder.append(",等待验证");
        localafjo.k.setContentDescription(ajya.a(2131702521));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localafjo.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localafjo.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localafjo = (afjo)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localafjo.h.setVisibility(8);
      break label293;
      label513:
      localafjo.a.setVisibility(0);
      localafjo.a.setText(ajya.a(2131689628));
      localafjo.a.setTag(localObject);
      localafjo.a.setOnClickListener(this);
      localafjo.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",添加");
        localafjo.a.setContentDescription(ajya.a(2131702518));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
        } while ((paramView == null) || (!(paramView instanceof afjo)));
        localObject = ((atyu)this.jdField_a_of_type_Atza).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_Akbn.h();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(c());
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
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, ajya.a(2131702519), null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_Akbn.h();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjn
 * JD-Core Version:    0.7.0.1
 */