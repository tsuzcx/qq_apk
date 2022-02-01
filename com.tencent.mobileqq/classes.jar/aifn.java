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

public class aifn
  extends aiea
  implements View.OnClickListener
{
  public aifn(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.jdField_a_of_type_Bjty = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aifo localaifo;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifo)))
    {
      localaifo = new aifo();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561479, localaifo);
      localaifo.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaifo.h = ((TextView)paramView.findViewById(2131371791));
      localaifo.i = ((TextView)paramView.findViewById(2131376354));
      localaifo.l = ((TextView)paramView.findViewById(2131362305));
      localaifo.j = ((TextView)paramView.findViewById(2131377631));
      localaifo.k = ((TextView)paramView.findViewById(2131376351));
      localaifo.a = ((Button)paramView.findViewById(2131376341));
      b(localaifo.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaifo);
      localaifo.g.setTag(localaifo);
      localaifo.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Aigo, localaifo, this);
      a(localaifo.g, false);
      localPhoneContactAdd = ((aigx)this.jdField_a_of_type_Aigo).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      localaifo.h.setVisibility(0);
      localaifo.h.setText(localPhoneContactAdd.name);
      label221:
      localaifo.l.setVisibility(8);
      localaifo.j.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      localaifo.i.setVisibility(0);
      localaifo.i.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      localaifo.k.setVisibility(0);
      localaifo.a.setVisibility(8);
      localaifo.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717690));
      localaifo.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
      localaifo.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      localaifo = (aifo)paramView.getTag();
      break;
      label346:
      localaifo.h.setVisibility(8);
      break label221;
      label358:
      localaifo.i.setVisibility(8);
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
      } while ((localObject == null) || (!(localObject instanceof aifo)));
      localPhoneContactAdd = ((aigx)this.jdField_a_of_type_Aigo).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).h = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 227);
      ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
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
 * Qualified Name:     aifn
 * JD-Core Version:    0.7.0.1
 */