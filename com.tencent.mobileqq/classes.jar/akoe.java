import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;

public class akoe
  implements View.OnClickListener
{
  public akoe(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    bmof.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoe
 * JD-Core Version:    0.7.0.1
 */