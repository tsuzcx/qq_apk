import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class afff
  implements View.OnClickListener
{
  afff(affe paramaffe) {}
  
  public void onClick(View paramView)
  {
    noq localnoq = (noq)paramView.getTag();
    paramView = (akdh)this.a.a.a.getManager(56);
    if ((paramView != null) && (paramView.c(localnoq.jdField_a_of_type_JavaLangString) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramView = new Intent(this.a.a.a(), ChatActivity.class);
        if (localnoq.jdField_a_of_type_Boolean)
        {
          paramView.putExtra("uintype", 1008);
          paramView.putExtra("uin", localnoq.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uinname", localnoq.b);
          paramView.putExtra("start_time", System.currentTimeMillis());
          this.a.a.a().startActivity(paramView);
          if (!affe.a(this.a)) {
            break label360;
          }
        }
      }
      label360:
      for (paramView = "houtai";; paramView = "duan")
      {
        nol.a(this.a.a.a, localnoq.jdField_a_of_type_JavaLangString, "0X8007404", "0X8007404", 0, 0, "", "", paramView, "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("clickRecommendAccount->");
          localStringBuilder.append("source:").append(paramView);
          localStringBuilder.append(", puin:").append(localnoq.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", isFollow:").append(bool);
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
        return;
        paramView.putExtra("uintype", 1024);
        break;
        if (localnoq.jdField_a_of_type_Boolean)
        {
          paramView = new Intent(this.a.a.a(), AccountDetailActivity.class);
          paramView.putExtra("uintype", 1008);
          paramView.putExtra("source", 118);
        }
        for (;;)
        {
          paramView.putExtra("uin", localnoq.jdField_a_of_type_JavaLangString);
          paramView.addFlags(67108864);
          this.a.a.a().startActivity(paramView);
          break;
          paramView = naz.a(this.a.a.a(), null, "", false, -1, false, -1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afff
 * JD-Core Version:    0.7.0.1
 */