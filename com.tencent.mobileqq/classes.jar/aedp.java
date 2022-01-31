import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;

public class aedp
  implements TroopMemberApiClient.Callback
{
  public aedp(NowWebViewPlugin paramNowWebViewPlugin) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 91)
    {
      NowWebViewPlugin.a(this.a, paramBundle.getInt("state"));
      NowWebViewPlugin.a(this.a, NowWebViewPlugin.a(this.a), NowWebViewPlugin.b(this.a));
    }
    while (i != 92) {
      return;
    }
    i = paramBundle.getInt("errCode");
    paramBundle = paramBundle.getString("desc");
    NowWebViewPlugin.a(this.a, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedp
 * JD-Core Version:    0.7.0.1
 */