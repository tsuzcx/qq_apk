import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;

public abstract interface aksk
{
  public abstract void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, aksj paramaksj, long paramLong);
  
  public abstract void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt);
  
  public abstract void onDownloadGameResStart(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
  
  public abstract void onGameCheckRetry(int paramInt);
  
  public abstract void onGameCheckStart(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong);
  
  public abstract void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  
  public abstract void onSsoCmdRuleRsp(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString);
  
  public abstract void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */