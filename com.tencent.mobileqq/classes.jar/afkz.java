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

public class afkz
  extends afjt
  implements View.OnClickListener
{
  public afkz(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_Bfwd = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afla localafla;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof afla)))
    {
      localafla = new afla();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561122, localafla);
      localafla.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafla.h = ((TextView)paramView.findViewById(2131370832));
      localafla.i = ((TextView)paramView.findViewById(2131375196));
      localafla.l = ((TextView)paramView.findViewById(2131362195));
      localafla.j = ((TextView)paramView.findViewById(2131376341));
      localafla.k = ((TextView)paramView.findViewById(2131375193));
      localafla.a = ((Button)paramView.findViewById(2131375183));
      b(localafla.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafla);
      localafla.g.setTag(localafla);
      localafla.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atza, localafla, this);
      a(localafla.g, false);
      localPhoneContactAdd = ((atzj)this.jdField_a_of_type_Atza).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localafla.h.setVisibility(0);
      localafla.h.setText(localPhoneContactAdd.name);
      label221:
      localafla.l.setVisibility(8);
      localafla.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localafla.i.setVisibility(0);
      localafla.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localafla.k.setVisibility(0);
      localafla.a.setVisibility(8);
      localafla.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718754));
      localafla.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localafla.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localafla = (afla)paramView.getTag();
      break;
      label346:
      localafla.h.setVisibility(8);
      break label221;
      label358:
      localafla.i.setVisibility(8);
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
      } while ((paramView == null) || (!(paramView instanceof afla)));
      localPhoneContactAdd = ((atzj)this.jdField_a_of_type_Atza).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
      return;
      if (paramView.h()) {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkz
 * JD-Core Version:    0.7.0.1
 */