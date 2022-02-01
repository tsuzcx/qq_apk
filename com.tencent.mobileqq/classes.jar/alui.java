import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.selectmember.TroopListAdapter.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class alui
  extends niv
{
  alui(aluh paramaluh) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramInt != 0) || (paramArrayOfByte == null) || (localQQAppInterface == null)) {
      return;
    }
    ThreadManager.post(new TroopListAdapter.1.1(this, localQQAppInterface, paramArrayOfByte, paramBundle, new Handler(Looper.getMainLooper())), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alui
 * JD-Core Version:    0.7.0.1
 */