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

public class afjy
  extends afjt
  implements View.OnClickListener
{
  public atyz a;
  
  public afjy(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_Atyz = ((atyz)paramatza);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Aipn.a(this);
      this.jdField_a_of_type_Aipn.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new agju(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    aneh.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjz)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561129, null);
      localObject = new afjz(null);
      ((afjz)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361894));
      ((afjz)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      ((afjz)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376703));
      ((afjz)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364258));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Atyz.jdField_a_of_type_Boolean) {
        break label277;
      }
      str3 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.a.a;
      str2 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.a.b;
      str1 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.a.c;
      label149:
      ((afjz)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((afjz)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((afjz)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((afjz)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((afjz)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (this.jdField_a_of_type_Atyz.jdField_a_of_type_Boolean) {
        break label325;
      }
      if (!((akbn)localObject).d)
      {
        ((akbn)localObject).d = true;
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label277:
    label325:
    while (((akbn)localObject).e)
    {
      return paramView;
      localObject = (afjz)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.b.a;
      str2 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.b.b;
      str1 = this.jdField_a_of_type_Atyz.jdField_a_of_type_Amtg.b.c;
      break label149;
    }
    ((akbn)localObject).e = true;
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
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
    if (i == 2131364258)
    {
      ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      c();
    }
    while ((i != 2131361894) && (i != 2131363231)) {
      return;
    }
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = BaseApplicationImpl.getContext();
      bcql.a(paramView, 1, 2131694673, 0).b(paramView.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (this.jdField_a_of_type_Atyz.jdField_a_of_type_Boolean)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
      b();
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjy
 * JD-Core Version:    0.7.0.1
 */