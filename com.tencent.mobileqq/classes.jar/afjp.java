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

public class afjp
  extends afjv
  implements View.OnClickListener
{
  private ajxn jdField_a_of_type_Ajxn;
  private akbo jdField_a_of_type_Akbo;
  
  public afjp(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_Ajxn = ((ajxn)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Akbo = ((akbo)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bfvm = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afjq localafjq;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjq)))
    {
      localafjq = new afjq();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561123, localafjq);
      a(paramView, this.b);
      localafjq.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafjq.h = ((TextView)paramView.findViewById(2131370832));
      localafjq.i = ((TextView)paramView.findViewById(2131375194));
      localafjq.l = ((TextView)paramView.findViewById(2131362196));
      localafjq.j = ((TextView)paramView.findViewById(2131376339));
      localafjq.k = ((TextView)paramView.findViewById(2131375191));
      localafjq.a = ((Button)paramView.findViewById(2131375181));
      b(localafjq.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjq);
      localafjq.g.setTag(localafjq);
      localafjq.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localafjq, this);
      localObject = localafjq.g;
      if (this.jdField_a_of_type_Atyy.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((atys)this.jdField_a_of_type_Atyy).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localafjq.h.setVisibility(0);
      localafjq.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.d) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localafjq.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localafjq.i.setVisibility(8);
      localafjq.j.setText(ajyc.a(2131702509));
      localafjq.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Ajxn.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localafjq.a.setVisibility(8);
      localafjq.k.setVisibility(0);
      localafjq.k.setText(ajyc.a(2131702506));
      if (AppSetting.d)
      {
        localStringBuilder.append(",等待验证");
        localafjq.k.setContentDescription(ajyc.a(2131702510));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localafjq.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localafjq.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localafjq = (afjq)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localafjq.h.setVisibility(8);
      break label293;
      label513:
      localafjq.a.setVisibility(0);
      localafjq.a.setText(ajyc.a(2131689628));
      localafjq.a.setTag(localObject);
      localafjq.a.setOnClickListener(this);
      localafjq.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",添加");
        localafjq.a.setContentDescription(ajyc.a(2131702507));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
        } while ((paramView == null) || (!(paramView instanceof afjq)));
        localObject = ((atys)this.jdField_a_of_type_Atyy).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_Akbo.h();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(c());
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
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, ajyc.a(2131702508), null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_Akbo.h();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjp
 * JD-Core Version:    0.7.0.1
 */