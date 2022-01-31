import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aiuu
  extends batl
{
  public aiuu(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(batm parambatm)
  {
    if (parambatm == null) {
      return;
    }
    try
    {
      ??? = parambatm.a().getString("path");
      String str = parambatm.a().getString("url");
      parambatm = this.a.a((String)???);
      str = bcdu.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambatm);
        return;
      }
      return;
    }
    catch (Exception parambatm)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambatm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiuu
 * JD-Core Version:    0.7.0.1
 */