import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.widget.QQToast;

public class ajlt
  extends anuw
{
  public ajlt(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      QQToast.a(this.a.getContext(), 2131698208, 3000).a();
      return;
    }
    QQToast.a(this.a.getContext(), 2131698207, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlt
 * JD-Core Version:    0.7.0.1
 */