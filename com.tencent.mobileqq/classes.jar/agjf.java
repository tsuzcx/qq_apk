import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;

public class agjf
  implements View.OnClickListener
{
  public agjf(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    bgtl.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjf
 * JD-Core Version:    0.7.0.1
 */