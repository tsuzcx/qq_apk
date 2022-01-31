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

public class aezl
  extends aeyf
  implements View.OnClickListener
{
  public aezl(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_Bens = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aezm localaezm;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezm)))
    {
      localaezm = new aezm();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495535, localaezm);
      localaezm.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaezm.h = ((TextView)paramView.findViewById(2131305159));
      localaezm.i = ((TextView)paramView.findViewById(2131309446));
      localaezm.l = ((TextView)paramView.findViewById(2131296655));
      localaezm.j = ((TextView)paramView.findViewById(2131310547));
      localaezm.k = ((TextView)paramView.findViewById(2131309443));
      localaezm.a = ((Button)paramView.findViewById(2131309433));
      b(localaezm.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaezm);
      localaezm.g.setTag(localaezm);
      localaezm.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaezm, this);
      a(localaezm.g, false);
      localPhoneContactAdd = ((atdd)this.jdField_a_of_type_Atcu).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localaezm.h.setVisibility(0);
      localaezm.h.setText(localPhoneContactAdd.name);
      label221:
      localaezm.l.setVisibility(8);
      localaezm.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localaezm.i.setVisibility(0);
      localaezm.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localaezm.k.setVisibility(0);
      localaezm.a.setVisibility(8);
      localaezm.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131652918));
      localaezm.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localaezm.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localaezm = (aezm)paramView.getTag();
      break;
      label346:
      localaezm.h.setVisibility(8);
      break label221;
      label358:
      localaezm.i.setVisibility(8);
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
      } while ((paramView == null) || (!(paramView instanceof aezm)));
      localPhoneContactAdd = ((atdd)this.jdField_a_of_type_Atcu).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
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
 * Qualified Name:     aezl
 * JD-Core Version:    0.7.0.1
 */