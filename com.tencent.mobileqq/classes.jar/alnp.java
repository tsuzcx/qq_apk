import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class alnp
  extends BroadcastReceiver
{
  public alnp(QidianWpaWebviewPlugin paramQidianWpaWebviewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (ActionSheet)ActionSheetHelper.a((Activity)paramContext, null);
      paramContext.b(2131438730);
      paramContext.c(2131433015);
      paramContext.a(new alnq(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnp
 * JD-Core Version:    0.7.0.1
 */