import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.widget.QQToast;

public class ahiv
  extends allb
{
  public ahiv(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      QQToast.a(this.a.getContext(), 2131699558, 3000).a();
      return;
    }
    QQToast.a(this.a.getContext(), 2131699557, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiv
 * JD-Core Version:    0.7.0.1
 */