import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class ajca
  implements TVK_SDKMgr.InstallListener
{
  public ajca(CmGameAppInterface paramCmGameAppInterface) {}
  
  public void onInstallProgress(float paramFloat)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstallProgress] v:" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstalledFailed], i:" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onInstalledSuccessed]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajca
 * JD-Core Version:    0.7.0.1
 */