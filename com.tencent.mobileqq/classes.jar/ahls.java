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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahls
  extends ahln
  implements View.OnClickListener
{
  public avum a;
  
  public ahls(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_Avum = ((avum)paramavun);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Akln.a(this);
      this.jdField_a_of_type_Akln.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new aimn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    aozx.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahlt)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561334, null);
      localObject = new ahlt(null);
      ((ahlt)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361894));
      ((ahlt)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377938));
      ((ahlt)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377267));
      ((ahlt)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364327));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Avum.jdField_a_of_type_Boolean) {
        break label277;
      }
      str3 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.a.a;
      str2 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.a.b;
      str1 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.a.c;
      label149:
      ((ahlt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((ahlt)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((ahlt)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((ahlt)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((ahlt)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (this.jdField_a_of_type_Avum.jdField_a_of_type_Boolean) {
        break label325;
      }
      if (!((alxr)localObject).d)
      {
        ((alxr)localObject).d = true;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label277:
    label325:
    while (((alxr)localObject).e)
    {
      return paramView;
      localObject = (ahlt)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.b.a;
      str2 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.b.b;
      str1 = this.jdField_a_of_type_Avum.jdField_a_of_type_Aoor.b.c;
      break label149;
    }
    ((alxr)localObject).e = true;
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
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
    if (i == 2131364327)
    {
      ((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      c();
    }
    while ((i != 2131361894) && (i != 2131363268)) {
      return;
    }
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = BaseApplicationImpl.getContext();
      QQToast.a(paramView, 1, 2131694831, 0).b(paramView.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if (this.jdField_a_of_type_Avum.jdField_a_of_type_Boolean)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
      b();
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahls
 * JD-Core Version:    0.7.0.1
 */