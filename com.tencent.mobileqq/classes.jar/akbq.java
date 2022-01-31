import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class akbq
  implements TroopMemberApiClient.Callback
{
  public akbq(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("fontSize", 1);
    if (i != this.a.b)
    {
      this.a.b = i;
      this.a.b(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */