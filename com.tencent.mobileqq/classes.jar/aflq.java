import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;

public class aflq
  extends ajto
{
  public aflq(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      bcql.a(this.a.getContext(), 2131699212, 3000).a();
      return;
    }
    bcql.a(this.a.getContext(), 2131699211, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflq
 * JD-Core Version:    0.7.0.1
 */