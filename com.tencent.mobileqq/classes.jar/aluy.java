import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aluy
  extends BroadcastReceiver
{
  public aluy(QidianWpaWebviewPlugin paramQidianWpaWebviewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (ActionSheet)ActionSheetHelper.a((Activity)paramContext, null);
      paramContext.b(2131438753);
      paramContext.c(2131433029);
      paramContext.a(new aluz(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aluy
 * JD-Core Version:    0.7.0.1
 */