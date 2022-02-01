import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.11.1;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajax
  implements amhc
{
  public ajax(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    this.a.runOnUiThread(new BlessSelectMemberActivity.11.1(this));
    if (BlessSelectMemberActivity.a() != null) {
      BlessSelectMemberActivity.a().sendEmptyMessage(1);
    }
    synchronized (BlessSelectMemberActivity.a())
    {
      BlessSelectMemberActivity.a().set(true);
      BlessSelectMemberActivity.a().notifyAll();
      this.a.finish();
      return;
    }
  }
  
  public void a(String arg1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    BlessSelectMemberActivity.a = ???;
    synchronized (BlessSelectMemberActivity.a())
    {
      BlessSelectMemberActivity.a().set(true);
      BlessSelectMemberActivity.a().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajax
 * JD-Core Version:    0.7.0.1
 */