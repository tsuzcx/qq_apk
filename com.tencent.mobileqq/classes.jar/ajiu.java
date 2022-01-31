import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ajiu
  extends bbwt
{
  public ajiu(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bbwu parambbwu)
  {
    if (parambbwu == null) {
      return;
    }
    try
    {
      ??? = parambbwu.a().getString("path");
      String str = parambbwu.a().getString("url");
      parambbwu = this.a.a((String)???);
      str = bdik.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambbwu);
        return;
      }
      return;
    }
    catch (Exception parambbwu)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambbwu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajiu
 * JD-Core Version:    0.7.0.1
 */