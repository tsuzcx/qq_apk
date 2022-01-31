import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

public class aecf
  implements INetEventHandler
{
  public aecf(GroupVideoManager paramGroupVideoManager) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (GroupVideoManager.a(this.a) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoManager", 2, "onNetChangeEvent connect:" + paramBoolean + " isMSFConnect:" + GroupVideoManager.a(this.a).e);
      }
    } while (!paramBoolean);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecf
 * JD-Core Version:    0.7.0.1
 */