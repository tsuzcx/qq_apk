import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;

public class afls
  extends ajtq
{
  public afls(SystemMsgListView paramSystemMsgListView) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      bcpw.a(this.a.getContext(), 2131699202, 3000).a();
      return;
    }
    bcpw.a(this.a.getContext(), 2131699201, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afls
 * JD-Core Version:    0.7.0.1
 */