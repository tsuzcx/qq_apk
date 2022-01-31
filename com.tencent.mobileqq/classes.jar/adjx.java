import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

public class adjx
  implements INetEventHandler
{
  public adjx(GroupVideoManager paramGroupVideoManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjx
 * JD-Core Version:    0.7.0.1
 */