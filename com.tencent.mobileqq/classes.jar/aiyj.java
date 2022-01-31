import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;

public class aiyj
  extends aiwh
{
  public aiyj(ApolloWebGameActivity paramApolloWebGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface, false);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, aiwi paramaiwi, long paramLong)
  {
    if (ApolloWebGameActivity.a(this.a)) {}
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
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloWebGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
    } while (paramaiwi == null);
    paramaiwi.a(paramStartCheckParam);
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.ApolloWebGameActivity", 1, "[onDownloadGameResFail]");
    paramStartCheckParam = ApolloWebGameActivity.a(this.a).obtainMessage(17);
    paramStartCheckParam.obj = ajya.a(2131700586);
    ApolloWebGameActivity.a(this.a).sendMessage(paramStartCheckParam);
  }
  
  public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloWebGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onGameCheckFinish] resultCode=", Long.valueOf(paramLong) });
          if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloWebGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
    } while (paramLong == 0L);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish resultCode != 0");
    }
    paramCmGameInitParams = ApolloWebGameActivity.a(this.a).obtainMessage(17);
    paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
    ApolloWebGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label39;
      }
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      onGameCheckFinish(-1L, paramStartCheckParam, null);
      return;
      label39:
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
  
  public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onGetGameData(paramStartCheckParam);
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.ApolloWebGameActivity", 1, "onGetGameData startCheckParam == null or game is null");
    }
    do
    {
      return;
      ApolloWebGameActivity.a(this.a).game = paramStartCheckParam.game;
    } while (ApolloWebGameActivity.a(this.a) == null);
    ApolloWebGameActivity.a(this.a).a(ApolloWebGameActivity.a(this.a));
  }
  
  public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloWebGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onVerifyGameFinish] resultCode=", Long.valueOf(paramLong) });
          if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloWebGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (paramLong != 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onVerifyGameFinish resultCode != 0");
        }
        paramCmGameInitParams = ApolloWebGameActivity.a(this.a).obtainMessage(17);
        paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
        ApolloWebGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
        return;
      }
      ApolloWebGameActivity.a(this.a).startCallEngine = System.currentTimeMillis();
      ApolloGameStateMachine.a().a(1, "ApolloWebGameActivity.openGame");
      ApolloGameStateMachine.a().a(2, "ApolloWebGameActivity.openGame");
    } while (ApolloWebGameActivity.a(this.a) == null);
    ApolloWebGameActivity.a(this.a).a(this.a, paramCmGameInitParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyj
 * JD-Core Version:    0.7.0.1
 */