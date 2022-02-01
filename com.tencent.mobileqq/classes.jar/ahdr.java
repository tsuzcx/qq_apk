import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ahdr
  extends VasQuickUpdateManager.CallBacker
{
  ahdr(ahdk paramahdk) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramString1.equals("poke.effectList")) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "download vas poke list from GivingHeartItemBuilder, update pokeSvipMap now.");
      }
      ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdr
 * JD-Core Version:    0.7.0.1
 */