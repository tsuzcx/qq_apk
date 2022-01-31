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

public class ahgs
  extends ahgy
  implements View.OnClickListener
{
  private aloz jdField_a_of_type_Aloz;
  private altc jdField_a_of_type_Altc;
  
  public ahgs(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Altc = ((altc)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Bhxa = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahgt localahgt;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahgt)))
    {
      localahgt = new ahgt();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561309, localahgt);
      a(paramView, this.b);
      localahgt.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahgt.h = ((TextView)paramView.findViewById(2131371142));
      localahgt.i = ((TextView)paramView.findViewById(2131375678));
      localahgt.l = ((TextView)paramView.findViewById(2131362215));
      localahgt.j = ((TextView)paramView.findViewById(2131376845));
      localahgt.k = ((TextView)paramView.findViewById(2131375675));
      localahgt.a = ((Button)paramView.findViewById(2131375665));
      b(localahgt.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahgt);
      localahgt.g.setTag(localahgt);
      localahgt.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avqe, localahgt, this);
      localObject = localahgt.g;
      if (this.jdField_a_of_type_Avqe.a()) {
        break label495;
      }
      bool = true;
      a((View)localObject, bool);
      localObject = ((avpy)this.jdField_a_of_type_Avqe).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      localahgt.h.setVisibility(0);
      localahgt.h.setText(((ContactMatch)localObject).name);
      if (AppSetting.c) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(localahgt.l, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      localahgt.i.setVisibility(8);
      localahgt.j.setText(alpo.a(2131702892));
      localahgt.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.jdField_a_of_type_Aloz.a(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      localahgt.a.setVisibility(8);
      localahgt.k.setVisibility(0);
      localahgt.k.setText(alpo.a(2131702889));
      if (AppSetting.c)
      {
        localStringBuilder.append(",等待验证");
        localahgt.k.setContentDescription(alpo.a(2131702893));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localahgt.jdField_f_of_type_JavaLangString = ((ContactMatch)localObject).unifiedCode;
      localahgt.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      localahgt = (ahgt)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      localahgt.h.setVisibility(8);
      break label293;
      label513:
      localahgt.a.setVisibility(0);
      localahgt.a.setText(alpo.a(2131689628));
      localahgt.a.setTag(localObject);
      localahgt.a.setOnClickListener(this);
      localahgt.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",添加");
        localahgt.a.setContentDescription(alpo.a(2131702890));
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
        } while ((paramView == null) || (!(paramView instanceof ahgt)));
        localObject = ((avpy)this.jdField_a_of_type_Avqe).a;
      } while (localObject == null);
      if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
      for (paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((ContactMatch)localObject).unifiedCode, 29))
      {
        paramView.h = ((ContactMatch)localObject).name;
        ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 229);
        this.jdField_a_of_type_Altc.h();
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).b(c());
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
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, "ContactMatchBuilder", i, j, paramView.name, null, null, alpo.a(2131702891), null);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 229);
    }
    this.jdField_a_of_type_Altc.h();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgs
 * JD-Core Version:    0.7.0.1
 */