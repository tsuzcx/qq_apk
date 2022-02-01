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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiyn
  extends aiyi
  implements View.OnClickListener
{
  public ajaw a;
  
  public aiyn(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
    this.jdField_a_of_type_Ajaw = ((ajaw)paramajax);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Ajae.a(this);
      this.jdField_a_of_type_Ajae.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new akdh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    ajca.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyo)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561567, null);
      localObject = new aiyo(null);
      ((aiyo)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361946));
      ((aiyo)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378776));
      ((aiyo)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378078));
      ((aiyo)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364539));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Boolean) {
        break label277;
      }
      str3 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.a.a;
      str2 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.a.b;
      str1 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.a.c;
      label149:
      ((aiyo)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((aiyo)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((aiyo)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((aiyo)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((aiyo)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Boolean) {
        break label325;
      }
      if (!((aiyr)localObject).d)
      {
        ((aiyr)localObject).d = true;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label277:
    label325:
    while (((aiyr)localObject).e)
    {
      return paramView;
      localObject = (aiyo)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.b.a;
      str2 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.b.b;
      str1 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Aqqc.b.c;
      break label149;
    }
    ((aiyr)localObject).e = true;
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
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
    if (i == 2131364539)
    {
      ((aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a();
      c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131361946) || (i == 2131363457)) {
        if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 1, 2131693991, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131298998));
        }
        else if (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Boolean)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
          b();
        }
        else
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
          d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyn
 * JD-Core Version:    0.7.0.1
 */