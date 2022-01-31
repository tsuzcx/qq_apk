import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class akxo
  implements TroopMemberApiClient.Callback
{
  public akxo(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
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
 * Qualified Name:     akxo
 * JD-Core Version:    0.7.0.1
 */