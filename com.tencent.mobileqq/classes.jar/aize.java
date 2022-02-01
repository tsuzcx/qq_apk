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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aize
  extends aiyz
  implements View.OnClickListener
{
  public ajbm a;
  
  public aize(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_Ajbm = ((ajbm)paramajbn);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Ajav.a(this);
      this.jdField_a_of_type_Ajav.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new akif(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    ajcr.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizf)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561548, null);
      localObject = new aizf(null);
      ((aizf)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361948));
      ((aizf)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
      ((aizf)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378293));
      ((aizf)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364699));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Ajbm.jdField_a_of_type_Boolean) {
        break label278;
      }
      str3 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.a.a;
      str2 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.a.b;
      str1 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.a.c;
      label149:
      ((aizf)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((aizf)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((aizf)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((aizf)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((aizf)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      if (this.jdField_a_of_type_Ajbm.jdField_a_of_type_Boolean) {
        break label326;
      }
      if (!((aizi)localObject).d)
      {
        ((aizi)localObject).d = true;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label278:
    label326:
    while (((aizi)localObject).e)
    {
      return paramView;
      localObject = (aizf)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.b.a;
      str2 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.b.b;
      str1 = this.jdField_a_of_type_Ajbm.jdField_a_of_type_Arcd.b.c;
      break label149;
    }
    ((aizi)localObject).e = true;
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
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
    if (i == 2131364699)
    {
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a();
      c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131361948) || (i == 2131363578)) {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 1, 2131694305, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299080));
        }
        else if (this.jdField_a_of_type_Ajbm.jdField_a_of_type_Boolean)
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
          b();
        }
        else
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
          d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aize
 * JD-Core Version:    0.7.0.1
 */