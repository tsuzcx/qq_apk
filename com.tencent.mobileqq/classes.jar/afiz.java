import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;

public class afiz
  extends FaceScoreCallBack
{
  public afiz(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    ThreadManager.post(new afja(this, paramFaceScoreConfig), 8, null, false);
    this.a.a = paramFaceScoreConfig;
    this.a.a(paramFaceScoreConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */