import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;

public class afac
  extends ajfo
{
  public afac(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      bbmy.a(this.a.getContext(), 2131633452, 3000).a();
      return;
    }
    bbmy.a(this.a.getContext(), 2131633451, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afac
 * JD-Core Version:    0.7.0.1
 */