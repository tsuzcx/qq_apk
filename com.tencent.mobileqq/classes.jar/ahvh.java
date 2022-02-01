import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.11.1;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahvh
  implements EncodeVideoTask.ResultListener
{
  public ahvh(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onEncodeSuccess(String arg1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    BlessSelectMemberActivity.a = ???;
    synchronized (BlessSelectMemberActivity.a())
    {
      BlessSelectMemberActivity.a().set(true);
      BlessSelectMemberActivity.a().notifyAll();
      return;
    }
  }
  
  public void onError(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvh
 * JD-Core Version:    0.7.0.1
 */