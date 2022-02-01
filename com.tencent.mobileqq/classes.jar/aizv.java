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

public class aizv
  extends aiyi
  implements View.OnClickListener
{
  public aizv(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
    this.jdField_a_of_type_Bkos = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aizw localaizw;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizw)))
    {
      localaizw = new aizw();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561560, localaizw);
      localaizw.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaizw.h = ((TextView)paramView.findViewById(2131371720));
      localaizw.i = ((TextView)paramView.findViewById(2131376456));
      localaizw.l = ((TextView)paramView.findViewById(2131362290));
      localaizw.j = ((TextView)paramView.findViewById(2131377713));
      localaizw.k = ((TextView)paramView.findViewById(2131376453));
      localaizw.a = ((Button)paramView.findViewById(2131376443));
      b(localaizw.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaizw);
      localaizw.g.setTag(localaizw);
      localaizw.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajax, localaizw, this);
      a(localaizw.g, false);
      localPhoneContactAdd = ((ajbg)this.jdField_a_of_type_Ajax).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localaizw.h.setVisibility(0);
      localaizw.h.setText(localPhoneContactAdd.name);
      label221:
      localaizw.l.setVisibility(8);
      localaizw.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localaizw.i.setVisibility(0);
      localaizw.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localaizw.k.setVisibility(0);
      localaizw.a.setVisibility(8);
      localaizw.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717330));
      localaizw.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localaizw.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localaizw = (aizw)paramView.getTag();
      break;
      label346:
      localaizw.h.setVisibility(8);
      break label221;
      label358:
      localaizw.i.setVisibility(8);
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
      } while ((localObject == null) || (!(localObject instanceof aizw)));
      localPhoneContactAdd = ((ajbg)this.jdField_a_of_type_Ajax).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 227);
      ((aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
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
 * Qualified Name:     aizv
 * JD-Core Version:    0.7.0.1
 */