package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialogView", "Landroid/view/View;", "release", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends e
{
  public static final a Xbe = new a((byte)0);
  
  public a(Context paramContext)
  {
    super(paramContext, c.j.BrowserDialog);
  }
  
  public abstract View izN();
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.onCreate(paramBundle);
    Log.i("MicroMsg.BrowseChooseDialog", "alvinluo BrowserDialog onCreate");
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -2);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(c.j.BottomToTopSlowAnimation);
    }
    paramBundle = getWindow();
    View localView;
    if (paramBundle != null)
    {
      localView = paramBundle.getDecorView();
      if (localView != null)
      {
        paramBundle = localView.getContext();
        if (paramBundle != null) {
          break label180;
        }
        paramBundle = localObject1;
        if (paramBundle != null) {
          break label219;
        }
      }
    }
    label180:
    label219:
    for (int i = com.tencent.mm.cd.a.ms(localView.getContext());; i = paramBundle.intValue())
    {
      localView.setMinimumWidth(i);
      localView.setPadding(0, 0, 0, 0);
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getAttributes();
        if (paramBundle != null)
        {
          paramBundle.width = -1;
          paramBundle.height = -2;
          paramBundle.gravity = 80;
        }
      }
      setContentView(izN());
      return;
      Object localObject2 = paramBundle.getResources();
      paramBundle = localObject1;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      paramBundle = localObject1;
      if (localObject2 == null) {
        break;
      }
      paramBundle = Integer.valueOf(((DisplayMetrics)localObject2).widthPixels);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.a
 * JD-Core Version:    0.7.0.1
 */