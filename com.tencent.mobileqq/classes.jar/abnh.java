import com.tencent.mobileqq.activity.MoveToGroupActivity;

public class abnh
  extends ajxj
{
  public abnh(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      bcql.a(this.a, this.a.getString(2131694324), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      this.a.removeObserver(MoveToGroupActivity.a(this.a));
      return;
      bcql.a(this.a, 2, this.a.getString(2131694326), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnh
 * JD-Core Version:    0.7.0.1
 */