import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class aiwj
  implements aiwl
{
  private AppInterface mApp;
  private final boolean mInMainProcess;
  
  public aiwj(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.mApp = paramAppInterface;
    this.mInMainProcess = paramBoolean;
  }
  
  public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onDownloadGameResDown startCheckParam == null");
    }
    do
    {
      return;
      if (!this.mInMainProcess) {
        break;
      }
    } while (!(this.mApp instanceof QQAppInterface));
    ApolloGameUtil.b((QQAppInterface)this.mApp, paramStartCheckParam);
    return;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onDownloadGameResDown", localBundle, null);
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt) {}
  
  public void onDownloadGameResStart(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onGameCheckRetry(int paramInt) {}
  
  public void onGameCheckStart(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onGameCheckStart startCheckParam == null");
    }
    do
    {
      return;
      if (!this.mInMainProcess) {
        break;
      }
    } while (!(this.mApp instanceof QQAppInterface));
    ApolloGameUtil.a((QQAppInterface)this.mApp, paramStartCheckParam);
    return;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "onGameCheckStart", localBundle, null);
  }
  
  public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
  
  public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void onSsoCmdRuleRsp(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString)
  {
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "onSsoCmdRuleRsp startCheckParam == null");
    }
    Object localObject;
    do
    {
      return;
      if (this.mInMainProcess)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
        ((Bundle)localObject).putString("rule", paramString);
        paramStartCheckParam.mSSORule = paramString;
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_set_sso_rule", (Bundle)localObject, null);
        return;
      }
      localObject = ajae.a();
    } while (localObject == null);
    ((ajcq)localObject).a(paramStartCheckParam.gameId, paramString);
  }
  
  public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwj
 * JD-Core Version:    0.7.0.1
 */