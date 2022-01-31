import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class alag
  extends bdvu
{
  public alag(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(bdvv parambdvv)
  {
    if (parambdvv == null) {
      return;
    }
    try
    {
      ??? = parambdvv.a().getString("path");
      String str = parambdvv.a().getString("url");
      parambdvv = this.a.a((String)???);
      str = bfhi.d(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, parambdvv);
        return;
      }
      return;
    }
    catch (Exception parambdvv)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", parambdvv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alag
 * JD-Core Version:    0.7.0.1
 */