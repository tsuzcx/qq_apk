import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;

public class agjg
  implements View.OnClickListener
{
  public agjg(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    bgtl.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    paramView = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(bgta.o, bgta.j);
    localBundle.putInt(bgta.p, QQPimGetTipsInfoIPC.a().a.b);
    localBundle.putString(bgta.l, paramView);
    new bgtg().a(ContactListView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjg
 * JD-Core Version:    0.7.0.1
 */