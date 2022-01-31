import android.os.Handler;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aaqv
  implements ArkMessageServerLogic.IAnalyzeTextIntentByServerHandler
{
  public aaqv(ArkRecommendLogic paramArkRecommendLogic, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void a(String paramString, Object paramObject, ArrayList paramArrayList)
  {
    ArkRecommendLogic.a().post(new aaqw(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqv
 * JD-Core Version:    0.7.0.1
 */