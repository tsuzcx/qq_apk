import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.1;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;

public class ahmt
  extends ahln
  implements View.OnClickListener
{
  public ahmt(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_Bibh = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahmu localahmu;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmu)))
    {
      localahmu = new ahmu();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561327, localahmu);
      localahmu.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahmu.h = ((TextView)paramView.findViewById(2131371161));
      localahmu.i = ((TextView)paramView.findViewById(2131375729));
      localahmu.l = ((TextView)paramView.findViewById(2131362215));
      localahmu.j = ((TextView)paramView.findViewById(2131376899));
      localahmu.k = ((TextView)paramView.findViewById(2131375726));
      localahmu.a = ((Button)paramView.findViewById(2131375716));
      b(localahmu.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahmu);
      localahmu.g.setTag(localahmu);
      localahmu.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avun, localahmu, this);
      a(localahmu.g, false);
      localPhoneContactAdd = ((avuw)this.jdField_a_of_type_Avun).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localahmu.h.setVisibility(0);
      localahmu.h.setText(localPhoneContactAdd.name);
      label221:
      localahmu.l.setVisibility(8);
      localahmu.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localahmu.i.setVisibility(0);
      localahmu.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localahmu.k.setVisibility(0);
      localahmu.a.setVisibility(8);
      localahmu.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719239));
      localahmu.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localahmu.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localahmu = (ahmu)paramView.getTag();
      break;
      label346:
      localahmu.h.setVisibility(8);
      break label221;
      label358:
      localahmu.i.setVisibility(8);
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new PhoneContactAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    PhoneContactAdd localPhoneContactAdd;
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof ahmu)));
      localPhoneContactAdd = ((avuw)this.jdField_a_of_type_Avun).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
      return;
      if (paramView.h()) {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmt
 * JD-Core Version:    0.7.0.1
 */