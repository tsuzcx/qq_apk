import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aimh
  extends aijq
{
  public aimh(CmGameLoadingFragment paramCmGameLoadingFragment, AppInterface paramAppInterface)
  {
    super(paramAppInterface, true);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, aijr paramaijr, long paramLong)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
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
          QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((CmGameLoadingFragment.a(this.a) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(this.a).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramLong > 0L) {
          break;
        }
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
      } while (paramaijr == null);
      paramaijr.a(paramStartCheckParam);
      return;
      if ((CmGameLoadingFragment.a(this.a) != null) && (CmGameLoadingFragment.a(this.a).statMap != null)) {
        CmGameLoadingFragment.a(this.a).statMap.put("download_confirm", Long.valueOf(1L));
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramaijr, paramLong);
  }
  
  public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onDownloadGameResDown(paramStartCheckParam);
    if ((CmGameLoadingFragment.a(this.a) != null) && (CmGameLoadingFragment.a(this.a).statMap != null)) {
      CmGameLoadingFragment.a(this.a).statMap.put("download_game_res", Long.valueOf(1L));
    }
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onDownloadGameResFail]");
    onGameFailed(paramStartCheckParam, -12L);
  }
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (CmGameLoadingFragment.a(this.a) != null) {
      CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramInt);
    }
  }
  
  public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    do
    {
      return;
      if (paramStartCheckParam == null)
      {
        QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onCheckGameFinish mStartCheckParam == null");
        return;
      }
      if (paramLong != 0L)
      {
        onGameFailed(paramStartCheckParam, paramLong);
        return;
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramLong, paramStartCheckParam);
  }
  
  public void onGameCheckRetry(int paramInt)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    while (CmGameLoadingFragment.a(this.a) == null) {
      return;
    }
    CmGameLoadingFragment.a(this.a).a(paramInt, CmGameLoadingFragment.a(this.a));
  }
  
  public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    aind.a().a(paramStartCheckParam, paramLong, null);
    if (CmGameLoadingFragment.a(this.a) != null) {
      CmGameLoadingFragment.a(this.a).b(paramStartCheckParam, paramLong);
    }
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (CmGameLoadingFragment.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label38;
      }
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      onGameFailed(paramStartCheckParam, -1L);
      return;
      label38:
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
  
  public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onGetGameData(paramStartCheckParam);
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameLoadingFragment", 1, "onGetGameData startCheckParam == null or game is null");
    }
    do
    {
      return;
      CmGameLoadingFragment.a(this.a).game = paramStartCheckParam.game;
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).b(paramStartCheckParam);
  }
  
  public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (CmGameLoadingFragment.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramCmGameInitParams != null) && (CmGameLoadingFragment.a(this.a) != null))
          {
            paramCmGameInitParams.commFlag = CmGameLoadingFragment.a(this.a).commFlag;
            paramCmGameInitParams.mSSORule = CmGameLoadingFragment.a(this.a).mSSORule;
            if (CmGameLoadingFragment.a(this.a).game != null) {
              paramCmGameInitParams.appId = CmGameLoadingFragment.a(this.a).game.appId;
            }
            paramCmGameInitParams.rpUrl = CmGameLoadingFragment.a(this.a).rpUrl;
            paramCmGameInitParams.rpIconUrl = CmGameLoadingFragment.a(this.a).rpIconUrl;
          }
          if (paramCmGameInitParams != null) {
            paramCmGameInitParams.accessTokenRet = 0;
          }
          aind.a().a(paramStartCheckParam, paramLong, paramCmGameInitParams);
          QLog.d("cmgame_process.CmGameLoadingFragment", 1, new Object[] { "[onCheckGameFinish] resultCode=", Long.valueOf(paramLong) });
          if (paramStartCheckParam != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish mStartCheckParam == null");
        return;
        if ((CmGameLoadingFragment.a(this.a) == null) || (paramStartCheckParam.requestCode == CmGameLoadingFragment.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "onCheckGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (paramLong != 0L)
      {
        onGameFailed(paramStartCheckParam, paramLong);
        return;
      }
    } while (CmGameLoadingFragment.a(this.a) == null);
    CmGameLoadingFragment.a(this.a).a(paramStartCheckParam, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aimh
 * JD-Core Version:    0.7.0.1
 */