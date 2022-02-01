import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;

public class akof
  implements View.OnClickListener
{
  public akof(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    bmof.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    String str = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(bmnu.o, bmnu.j);
    localBundle.putInt(bmnu.p, QQPimGetTipsInfoIPC.a().a.b);
    localBundle.putString(bmnu.l, str);
    new bmoa().a(ContactListView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akof
 * JD-Core Version:    0.7.0.1
 */