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

public class aflb
  extends afjv
  implements View.OnClickListener
{
  public aflb(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_Bfvm = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aflc localaflc;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof aflc)))
    {
      localaflc = new aflc();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561123, localaflc);
      localaflc.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaflc.h = ((TextView)paramView.findViewById(2131370832));
      localaflc.i = ((TextView)paramView.findViewById(2131375194));
      localaflc.l = ((TextView)paramView.findViewById(2131362196));
      localaflc.j = ((TextView)paramView.findViewById(2131376339));
      localaflc.k = ((TextView)paramView.findViewById(2131375191));
      localaflc.a = ((Button)paramView.findViewById(2131375181));
      b(localaflc.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaflc);
      localaflc.g.setTag(localaflc);
      localaflc.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localaflc, this);
      a(localaflc.g, false);
      localPhoneContactAdd = ((atzh)this.jdField_a_of_type_Atyy).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localaflc.h.setVisibility(0);
      localaflc.h.setText(localPhoneContactAdd.name);
      label221:
      localaflc.l.setVisibility(8);
      localaflc.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localaflc.i.setVisibility(0);
      localaflc.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localaflc.k.setVisibility(0);
      localaflc.a.setVisibility(8);
      localaflc.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718743));
      localaflc.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localaflc.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localaflc = (aflc)paramView.getTag();
      break;
      label346:
      localaflc.h.setVisibility(8);
      break label221;
      label358:
      localaflc.i.setVisibility(8);
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
      } while ((paramView == null) || (!(paramView instanceof aflc)));
      localPhoneContactAdd = ((atzh)this.jdField_a_of_type_Atyy).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
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
 * Qualified Name:     aflb
 * JD-Core Version:    0.7.0.1
 */