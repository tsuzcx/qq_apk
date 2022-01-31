import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class akqc
  implements EIPCResultCallback
{
  akqc(akqb paramakqb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_game_friUin");
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] current game friendUin:" + paramEIPCResult + ",mCurrentFriUin:" + akqb.a(this.a));
      if (!akqb.a(this.a).equals(paramEIPCResult))
      {
        akqb.a(this.a).removeMessages(1);
        akqb.a(this.a).sendEmptyMessage(1);
      }
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] game is not exist. exit room");
    akqb.a(this.a).removeMessages(1);
    akqb.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqc
 * JD-Core Version:    0.7.0.1
 */