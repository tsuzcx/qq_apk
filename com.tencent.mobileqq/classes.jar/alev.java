import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class alev
  extends bead
{
  public alev(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(beae parambeae)
  {
    if (parambeae == null) {
      return;
    }
    try
    {
      ??? = parambeae.a().getString("path");
      String str = parambeae.a().getString("url");
      parambeae = this.a.a((String)???);
      str = bflr.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambeae);
        return;
      }
      return;
    }
    catch (Exception parambeae)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambeae);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alev
 * JD-Core Version:    0.7.0.1
 */