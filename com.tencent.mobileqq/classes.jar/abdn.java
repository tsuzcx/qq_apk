import com.tencent.mobileqq.activity.MoveToGroupActivity;

public class abdn
  extends ajjh
{
  public abdn(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      bbmy.a(this.a, this.a.getString(2131628671), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.removeObserver(MoveToGroupActivity.a(this.a));
      return;
      bbmy.a(this.a, 2, this.a.getString(2131628673), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdn
 * JD-Core Version:    0.7.0.1
 */