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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialogView", "Landroid/view/View;", "release", "Companion", "plugin-webview_release"})
public abstract class a
  extends e
{
  public static final a Qji = new a((byte)0);
  
  public a(Context paramContext)
  {
    super(paramContext, c.j.BrowserDialog);
  }
  
  public abstract View gZK();
  
  public void onCreate(Bundle paramBundle)
  {
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
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getDecorView();
      if (paramBundle != null)
      {
        p.j(paramBundle, "this");
        localObject = paramBundle.getContext();
        if (localObject == null) {
          break label187;
        }
        localObject = ((Context)localObject).getResources();
        if (localObject == null) {
          break label187;
        }
        localObject = ((Resources)localObject).getDisplayMetrics();
        if (localObject == null) {
          break label187;
        }
      }
    }
    label187:
    for (int i = ((DisplayMetrics)localObject).widthPixels;; i = com.tencent.mm.ci.a.kr(paramBundle.getContext()))
    {
      paramBundle.setMinimumWidth(i);
      paramBundle.setPadding(0, 0, 0, 0);
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
      setContentView(gZK());
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.a
 * JD-Core Version:    0.7.0.1
 */