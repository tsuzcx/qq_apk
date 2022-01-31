import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import java.lang.ref.WeakReference;

public class aaxz
  implements ArkMessageServerLogic.IPassiveSearchIntentByServerHandler
{
  public aaxz(ArkRecommendLogic paramArkRecommendLogic, WeakReference paramWeakReference1, WeakReference paramWeakReference2, RecommendCommonMessage paramRecommendCommonMessage) {}
  
  public void a(String paramString, Object paramObject, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo)
  {
    ArkAppCenter.a().post(new aaya(this, paramArkPassiveSearchInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxz
 * JD-Core Version:    0.7.0.1
 */