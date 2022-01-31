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

public class ahie
  extends ahgy
  implements View.OnClickListener
{
  public ahie(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.jdField_a_of_type_Bhxa = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahif localahif;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahif)))
    {
      localahif = new ahif();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561309, localahif);
      localahif.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahif.h = ((TextView)paramView.findViewById(2131371142));
      localahif.i = ((TextView)paramView.findViewById(2131375678));
      localahif.l = ((TextView)paramView.findViewById(2131362215));
      localahif.j = ((TextView)paramView.findViewById(2131376845));
      localahif.k = ((TextView)paramView.findViewById(2131375675));
      localahif.a = ((Button)paramView.findViewById(2131375665));
      b(localahif.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahif);
      localahif.g.setTag(localahif);
      localahif.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avqe, localahif, this);
      a(localahif.g, false);
      localPhoneContactAdd = ((avqn)this.jdField_a_of_type_Avqe).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localahif.h.setVisibility(0);
      localahif.h.setText(localPhoneContactAdd.name);
      label221:
      localahif.l.setVisibility(8);
      localahif.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localahif.i.setVisibility(0);
      localahif.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localahif.k.setVisibility(0);
      localahif.a.setVisibility(8);
      localahif.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719227));
      localahif.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localahif.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localahif = (ahif)paramView.getTag();
      break;
      label346:
      localahif.h.setVisibility(8);
      break label221;
      label358:
      localahif.i.setVisibility(8);
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
      } while ((paramView == null) || (!(paramView instanceof ahif)));
      localPhoneContactAdd = ((avqn)this.jdField_a_of_type_Avqe).a;
    } while (localPhoneContactAdd == null);
    paramView = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (paramView.c(localPhoneContactAdd.unifiedCode) == null) {
      paramView = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      paramView.h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, paramView, 227);
      ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
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
 * Qualified Name:     ahie
 * JD-Core Version:    0.7.0.1
 */