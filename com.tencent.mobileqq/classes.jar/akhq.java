import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.vas.FlashCarGameManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class akhq
  extends SosoInterface.OnLocationListener
{
  public akhq(FlashCarGameManager paramFlashCarGameManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (FlashCarGameManager.d) {
      return;
    }
    String str = "{\"isFromSplash\":1}";
    Object localObject = str;
    if (paramInt == 0)
    {
      localObject = str;
      if (paramSosoLbsInfo != null)
      {
        localObject = str;
        if (paramSosoLbsInfo.a != null) {
          if (QLog.isColorLevel()) {
            QLog.d("FlashCarGame", 2, "onLocationFinish errCode = " + paramInt + " location = " + paramSosoLbsInfo.a.e + paramSosoLbsInfo.a.d + paramSosoLbsInfo.a.g + paramSosoLbsInfo.a.j);
          }
        }
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("isFromSplash", 1);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nation", paramSosoLbsInfo.a.c);
      localJSONObject.put("province", paramSosoLbsInfo.a.d);
      localJSONObject.put("city", paramSosoLbsInfo.a.e);
      localJSONObject.put("district", paramSosoLbsInfo.a.g);
      localJSONObject.put("street", paramSosoLbsInfo.a.j);
      localJSONObject.put("streetNo", paramSosoLbsInfo.a.k);
      localJSONObject.put("town", paramSosoLbsInfo.a.h);
      localJSONObject.put("village", paramSosoLbsInfo.a.i);
      ((JSONObject)localObject).put("Location", localJSONObject);
      localObject = ((JSONObject)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("FlashCarGame", 2, "gameParam = " + (String)localObject);
      }
      if (FlashCarGameManager.a(this.a) != null)
      {
        FlashCarGameManager.a(this.a).removeMessages(261);
        FlashCarGameManager.a(this.a).sendEmptyMessageDelayed(259, 2000L);
      }
      ApolloGameActivity.a(FlashCarGameManager.a(this.a), 3003, 1, (String)localObject, null);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      for (;;)
      {
        QLog.e("FlashCarGame", 2, "onLocationFinish error: " + paramSosoLbsInfo.getMessage());
        localObject = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhq
 * JD-Core Version:    0.7.0.1
 */