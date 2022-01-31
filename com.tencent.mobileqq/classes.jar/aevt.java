import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;

public class aevt
  extends FaceScoreCallBack
{
  public aevt(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    ThreadManager.post(new aevu(this, paramFaceScoreConfig), 8, null, false);
    this.a.a = paramFaceScoreConfig;
    this.a.a(paramFaceScoreConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevt
 * JD-Core Version:    0.7.0.1
 */