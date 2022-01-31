import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class akpx
  implements TroopMemberApiClient.Callback
{
  public akpx(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpx
 * JD-Core Version:    0.7.0.1
 */