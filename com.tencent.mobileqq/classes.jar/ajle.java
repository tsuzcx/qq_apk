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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajle
  extends ajjr
  implements View.OnClickListener
{
  public ajle(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_Blpv = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajlf localajlf;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlf)))
    {
      localajlf = new ajlf();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561601, localajlf);
      localajlf.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajlf.h = ((TextView)paramView.findViewById(2131371827));
      localajlf.i = ((TextView)paramView.findViewById(2131376588));
      localajlf.l = ((TextView)paramView.findViewById(2131362302));
      localajlf.j = ((TextView)paramView.findViewById(2131377861));
      localajlf.k = ((TextView)paramView.findViewById(2131376585));
      localajlf.a = ((Button)paramView.findViewById(2131376575));
      b(localajlf.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajlf);
      localajlf.g.setTag(localajlf);
      localajlf.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajlf, this);
      a(localajlf.g, false);
      localPhoneContactAdd = ((ajmo)this.jdField_a_of_type_Ajmf).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localajlf.h.setVisibility(0);
      localajlf.h.setText(localPhoneContactAdd.name);
      label221:
      localajlf.l.setVisibility(8);
      localajlf.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localajlf.i.setVisibility(0);
      localajlf.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localajlf.k.setVisibility(0);
      localajlf.a.setVisibility(8);
      localajlf.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717458));
      localajlf.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localajlf.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localajlf = (ajlf)paramView.getTag();
      break;
      label346:
      localajlf.h.setVisibility(8);
      break label221;
      label358:
      localajlf.i.setVisibility(8);
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
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = paramView.getTag();
      } while ((localObject == null) || (!(localObject instanceof ajlf)));
      localPhoneContactAdd = ((ajmo)this.jdField_a_of_type_Ajmf).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 227);
      ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
      break;
      if (((PhoneContactManagerImp)localObject).i()) {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajle
 * JD-Core Version:    0.7.0.1
 */