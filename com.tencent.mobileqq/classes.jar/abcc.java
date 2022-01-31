import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

public final class abcc
  implements Runnable
{
  public abcc(String paramString) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkAppLastUsedTime", 0).edit();
    localEditor.putLong(this.a, System.currentTimeMillis());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcc
 * JD-Core Version:    0.7.0.1
 */