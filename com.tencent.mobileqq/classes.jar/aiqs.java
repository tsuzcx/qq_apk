import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiqs
  implements View.OnClickListener
{
  aiqs(aiqr paramaiqr) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str1 = (String)paramView.getTag(-1);
      String str2 = (String)paramView.getTag(-2);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Contacts.PublicAccountFragment", 2, "onClick - uin = " + str1 + ", name = " + str2);
        }
      }
      else {
        npt.a(PublicAccountFragment.a(this.a.a), PublicAccountFragment.b(this.a.a), str2, str1, "IvrEnterpriseDetailEngineFalse");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqs
 * JD-Core Version:    0.7.0.1
 */