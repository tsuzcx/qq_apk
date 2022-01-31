import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.ArkPassiveSearchInfo;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IPassiveSearchIntentByServerHandler;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import java.lang.ref.WeakReference;

public class aaqy
  implements ArkMessageServerLogic.IPassiveSearchIntentByServerHandler
{
  public aaqy(ArkRecommendLogic paramArkRecommendLogic, WeakReference paramWeakReference1, WeakReference paramWeakReference2, RecommendCommonMessage paramRecommendCommonMessage) {}
  
  public void a(String paramString, Object paramObject, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo)
  {
    ArkAppCenter.a().post(new aaqz(this, paramArkPassiveSearchInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqy
 * JD-Core Version:    0.7.0.1
 */