import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class akyv
  extends aknt
{
  public akyv(ApolloGameActivity paramApolloGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface, false);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, aknu paramaknu, long paramLong)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(this.a.b, 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.a.b, 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong > 0L) {
          break;
        }
        QLog.d(this.a.b, 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
      } while (paramaknu == null);
      paramaknu.a(paramStartCheckParam);
      return;
      if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).statMap != null)) {
        ApolloGameActivity.a(this.a).statMap.put("download_confirm", Long.valueOf(1L));
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramaknu, paramLong);
  }
  
  public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onDownloadGameResDown(paramStartCheckParam);
    if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).statMap != null)) {
      ApolloGameActivity.a(this.a).statMap.put("download_game_res", Long.valueOf(1L));
    }
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d(this.a.b, 1, "[onDownloadGameResFail]");
    onGameFailed(paramStartCheckParam, -12L);
  }
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramInt);
    }
  }
  
  public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      return;
      QLog.d(this.a.b, 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
      if (paramStartCheckParam == null)
      {
        QLog.e(this.a.b, 1, "onCheckGameFinish mStartCheckParam == null");
        return;
      }
      if (paramLong != 0L)
      {
        onGameFailed(paramStartCheckParam, paramLong);
        return;
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).a(paramLong, paramStartCheckParam);
  }
  
  public void onGameCheckRetry(int paramInt)
  {
    if (ApolloGameActivity.a(this.a)) {}
    while (ApolloGameActivity.a(this.a) == null) {
      return;
    }
    ApolloGameActivity.a(this.a).a(paramInt, ApolloGameActivity.a(this.a));
  }
  
  public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).b(paramStartCheckParam, paramLong);
    }
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ApolloGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label43;
      }
      QLog.d(this.a.b, 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      onGameFailed(paramStartCheckParam, -1L);
      return;
      label43:
      QLog.d(this.a.b, 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
  
  public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onGetGameData(paramStartCheckParam);
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e(this.a.b, 1, "onGetGameData startCheckParam == null or game is null");
    }
    do
    {
      return;
      ApolloGameActivity.a(this.a).game = paramStartCheckParam.game;
      if (ApolloGameActivity.a(this.a) != null) {
        ApolloGameActivity.a(this.a).a(ApolloGameActivity.a(this.a));
      }
    } while (ApolloGameActivity.a(this.a) == null);
    ApolloGameActivity.a(this.a).b(paramStartCheckParam);
  }
  
  public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      do
      {
        return;
        QLog.d(this.a.b, 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
        if (paramStartCheckParam != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.b, 2, "onVerifyGameFinish mStartCheckParam == null");
      return;
      if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.b, 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
    return;
    if (ApolloGameActivity.a(this.a) != null) {
      ApolloGameActivity.a(this.a).a(paramStartCheckParam, paramLong);
    }
    if (paramLong != 0L)
    {
      onGameFailed(paramStartCheckParam, paramLong);
      return;
    }
    if (paramCmGameInitParams != null)
    {
      paramCmGameInitParams.appId = ApolloGameActivity.a(this.a).game.appId;
      paramCmGameInitParams.commFlag = ApolloGameActivity.a(this.a).commFlag;
      paramCmGameInitParams.rpUrl = ApolloGameActivity.a(this.a).rpUrl;
      paramCmGameInitParams.rpIconUrl = ApolloGameActivity.a(this.a).rpIconUrl;
    }
    if (paramCmGameInitParams != null) {
      paramCmGameInitParams.accessTokenRet = 0;
    }
    this.a.a(paramCmGameInitParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyv
 * JD-Core Version:    0.7.0.1
 */