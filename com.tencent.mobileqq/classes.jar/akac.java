import com.tencent.mobileqq.app.MayknowRecommendManager.3.1;
import com.tencent.mobileqq.app.MayknowRecommendManager.3.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class akac
  extends ajxj
{
  akac(akaa paramakaa) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "onAddFriend " + paramString);
    }
    ThreadManager.getSubThreadHandler().post(new MayknowRecommendManager.3.1(this, paramString));
  }
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new MayknowRecommendManager.3.2(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akac
 * JD-Core Version:    0.7.0.1
 */