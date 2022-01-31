import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;

class abaj
  extends ResourcePluginListener
{
  abaj(abai paramabai) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abaj
 * JD-Core Version:    0.7.0.1
 */