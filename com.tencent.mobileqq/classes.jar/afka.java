import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.1;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.2;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.3;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class afka
  extends afjv
  implements View.OnClickListener
{
  public atyx a;
  
  public afka(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_Atyx = ((atyx)paramatyy);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Aipp.a(this);
      this.jdField_a_of_type_Aipp.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new agjw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    anec.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkb)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561130, null);
      localObject = new afkb(null);
      ((afkb)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361895));
      ((afkb)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      ((afkb)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376701));
      ((afkb)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364259));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Atyx.jdField_a_of_type_Boolean) {
        break label277;
      }
      str3 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.a.a;
      str2 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.a.b;
      str1 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.a.c;
      label149:
      ((afkb)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((afkb)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((afkb)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((afkb)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((afkb)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (this.jdField_a_of_type_Atyx.jdField_a_of_type_Boolean) {
        break label325;
      }
      if (!((akbo)localObject).d)
      {
        ((akbo)localObject).d = true;
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label277:
    label325:
    while (((akbo)localObject).e)
    {
      return paramView;
      localObject = (afkb)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.b.a;
      str2 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.b.b;
      str1 = this.jdField_a_of_type_Atyx.jdField_a_of_type_Amth.b.c;
      break label149;
    }
    ((akbo)localObject).e = true;
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
    return paramView;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendBindContactGuideBuilderV2", 2, "uploadContact");
    }
    ThreadManager.excute(new NewFriendBindContactGuideBuilderV2.1(this), 16, null, false);
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 15, 2, null);
    c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364259)
    {
      ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      c();
    }
    while ((i != 2131361895) && (i != 2131363232)) {
      return;
    }
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = BaseApplicationImpl.getContext();
      bcpw.a(paramView, 1, 2131694672, 0).b(paramView.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (this.jdField_a_of_type_Atyx.jdField_a_of_type_Boolean)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
      b();
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afka
 * JD-Core Version:    0.7.0.1
 */