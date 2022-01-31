import android.os.Handler;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aber
  implements ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler
{
  public aber(ArkRecommendLogic paramArkRecommendLogic, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void a(String paramString, Object paramObject, ArrayList paramArrayList)
  {
    ArkRecommendLogic.a().post(new abes(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aber
 * JD-Core Version:    0.7.0.1
 */