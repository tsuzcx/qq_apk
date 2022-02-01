import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;

public class aefo
  extends ResourcePluginListener
{
  public aefo(Leba paramLeba) {}
  
  public void a(byte paramByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.leba", 4, "ResourcePluginListener listener notify = " + paramByte);
    }
    if (paramByte != -1) {
      this.a.a.sendEmptyMessage(11340002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefo
 * JD-Core Version:    0.7.0.1
 */