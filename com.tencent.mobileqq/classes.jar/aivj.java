import android.os.Bundle;
import android.text.TextUtils;
import mqq.observer.BusinessObserver;

public class aivj
  implements BusinessObserver
{
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 1) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("btype");
      String str = paramBundle.getString("bid");
      if ((aivh.a(paramInt)) && (!TextUtils.isEmpty(str))) {
        a(paramInt, str, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivj
 * JD-Core Version:    0.7.0.1
 */