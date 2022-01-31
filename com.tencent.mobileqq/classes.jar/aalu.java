import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.arcard.ARCardHeadIconManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aalu
  implements Runnable
{
  public aalu(ARCardHeadIconManager paramARCardHeadIconManager) {}
  
  public void run()
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
    localIntent.putStringArrayListExtra("uinList", ARCardHeadIconManager.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("DingdongHeadManager", 2, "mContactHeadReqRunnable: request contact head whose size=" + ARCardHeadIconManager.a(this.a).size());
    }
    ARCardHeadIconManager.a(this.a).sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
    ARCardHeadIconManager.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalu
 * JD-Core Version:    0.7.0.1
 */