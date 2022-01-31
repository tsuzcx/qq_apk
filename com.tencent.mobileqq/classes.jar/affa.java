import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;

public class affa
  extends FaceScoreCallBack
{
  public affa(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    ThreadManager.post(new affb(this, paramFaceScoreConfig), 8, null, false);
    this.a.a = paramFaceScoreConfig;
    this.a.a(paramFaceScoreConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affa
 * JD-Core Version:    0.7.0.1
 */