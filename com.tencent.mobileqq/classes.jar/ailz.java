import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ailz
  implements EIPCResultCallback
{
  ailz(aily paramaily) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_game_friUin");
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] current game friendUin:" + paramEIPCResult + ",mCurrentFriUin:" + aily.a(this.a));
      if (!aily.a(this.a).equals(paramEIPCResult))
      {
        aily.a(this.a).removeMessages(1);
        aily.a(this.a).sendEmptyMessage(1);
      }
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] game is not exist. exit room");
    aily.a(this.a).removeMessages(1);
    aily.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ailz
 * JD-Core Version:    0.7.0.1
 */