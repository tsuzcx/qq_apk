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
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class ahlh
  extends ahln
  implements View.OnClickListener
{
  private alto jdField_a_of_type_Alto;
  private alxr jdField_a_of_type_Alxr;
  
  public ahlh(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Alxr = ((alxr)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bibh = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahli localahli;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahli)))
    {
      localahli = new ahli();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561327, localahli);
      a(paramView, this.b);
      localahli.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahli.h = ((TextView)paramView.findViewById(2131371161));
      localahli.i = ((TextView)paramView.findViewById(2131375729));
      localahli.l = ((TextView)paramView.findViewById(2131362215));
      localahli.j = ((TextView)paramView.findViewById(2131376899));
      localahli.k = ((TextView)paramView.findViewById(2131375726));
      localahli.a = ((Button)paramView.findViewById(2131375716));
      b(localahli.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahli);
      localahli.g.setTag(localahli);
      localahli.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avun, localahli, this);
      localObject = localahli.g;
      if (this.jdField_a_of_type_Avun.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((avuh)this.jdField_a_of_type_Avun).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localahli.h.setVisibility(0);
      localahli.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localahli.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localahli.i.setVisibility(8);
      localahli.j.setText(alud.a(2131702904));
      localahli.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Alto.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localahli.a.setVisibility(8);
      localahli.k.setVisibility(0);
      localahli.k.setText(alud.a(2131702901));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localahli.k.setContentDescription(alud.a(2131702905));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localahli.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localahli.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localahli = (ahli)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localahli.h.setVisibility(8);
      break label293;
      label513:
      localahli.a.setVisibility(0);
      localahli.a.setText(alud.a(2131689628));
      localahli.a.setTag(localObject);
      localahli.a.setOnClickListener(this);
      localahli.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localahli.a.setContentDescription(alud.a(2131702902));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
        } while ((paramView == null) || (!(paramView instanceof ahli)));
        localObject = ((avuh)this.jdField_a_of_type_Avun).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_Alxr.h();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692398), 0).b(c());
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
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, alud.a(2131702903), null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_Alxr.h();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlh
 * JD-Core Version:    0.7.0.1
 */