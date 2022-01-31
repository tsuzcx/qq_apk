import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ajiw
  extends bbwf
{
  public ajiw(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bbwg parambbwg)
  {
    if (parambbwg == null) {
      return;
    }
    try
    {
      ??? = parambbwg.a().getString("path");
      String str = parambbwg.a().getString("url");
      parambbwg = this.a.a((String)???);
      str = bdhv.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambbwg);
        return;
      }
      return;
    }
    catch (Exception parambbwg)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambbwg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajiw
 * JD-Core Version:    0.7.0.1
 */