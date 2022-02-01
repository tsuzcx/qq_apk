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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajam
  extends aiyz
  implements View.OnClickListener
{
  public ajam(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_Blfk = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajan localajan;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajan)))
    {
      localajan = new ajan();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561541, localajan);
      localajan.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localajan.h = ((TextView)paramView.findViewById(2131371981));
      localajan.i = ((TextView)paramView.findViewById(2131376609));
      localajan.l = ((TextView)paramView.findViewById(2131362310));
      localajan.j = ((TextView)paramView.findViewById(2131377905));
      localajan.k = ((TextView)paramView.findViewById(2131376606));
      localajan.a = ((Button)paramView.findViewById(2131376596));
      b(localajan.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajan);
      localajan.g.setTag(localajan);
      localajan.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localajan, this);
      a(localajan.g, false);
      localPhoneContactAdd = ((ajbw)this.jdField_a_of_type_Ajbn).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localajan.h.setVisibility(0);
      localajan.h.setText(localPhoneContactAdd.name);
      label221:
      localajan.l.setVisibility(8);
      localajan.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localajan.i.setVisibility(0);
      localajan.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localajan.k.setVisibility(0);
      localajan.a.setVisibility(8);
      localajan.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718061));
      localajan.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localajan.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localajan = (ajan)paramView.getTag();
      break;
      label346:
      localajan.h.setVisibility(8);
      break label221;
      label358:
      localajan.i.setVisibility(8);
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
      } while ((localObject == null) || (!(localObject instanceof ajan)));
      localPhoneContactAdd = ((ajbw)this.jdField_a_of_type_Ajbn).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 227);
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).g();
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
 * Qualified Name:     ajam
 * JD-Core Version:    0.7.0.1
 */