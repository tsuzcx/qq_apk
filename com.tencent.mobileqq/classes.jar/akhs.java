import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;

public class akhs
  implements View.OnClickListener
{
  public akhs(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    bmdv.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    String str = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(bmdk.o, bmdk.j);
    localBundle.putInt(bmdk.p, QQPimGetTipsInfoIPC.a().a.b);
    localBundle.putString(bmdk.l, str);
    new bmdq().a(ContactListView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhs
 * JD-Core Version:    0.7.0.1
 */