package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "", "uiModel", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;)V", "browserChooseDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1;", "browserSettingDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1;", "defaultBrowserIndex", "", "mBrowserChooseDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "mBrowserCount", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserSettingDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "mSessionId", "", "cancelChooseDialog", "", "action", "cancelSettingDialog", "finishUI", "resultCode", "data", "Landroid/content/Intent;", "initBrowserList", "onCreate", "showBrowserChooseDialog", "showBrowserChooseDialogInner", "showSettingDialog", "switchToChooseDialog", "Companion", "plugin-webview_release"})
public final class a
{
  public static final a.a Jlq;
  final List<f> Jli;
  int Jlj;
  int Jlk;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.b Jll;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.c Jlm;
  private final b Jln;
  private final c Jlo;
  final com.tencent.mm.plugin.webview.ui.tools.browser.model.a Jlp;
  long mSessionId;
  
  static
  {
    AppMethodBeat.i(210398);
    Jlq = new a.a((byte)0);
    AppMethodBeat.o(210398);
  }
  
  public a(com.tencent.mm.plugin.webview.ui.tools.browser.model.a parama)
  {
    AppMethodBeat.i(210397);
    this.Jlp = parama;
    this.Jli = ((List)new ArrayList());
    this.Jlk = -1;
    this.Jln = new b(this);
    this.Jlo = new c(this);
    AppMethodBeat.o(210397);
  }
  
  final void ggt()
  {
    AppMethodBeat.i(210395);
    Log.i("MicroMsg.BrowserChooseController", "alvinluo showBrowserChooseDialog");
    com.tencent.mm.plugin.webview.ui.tools.browser.view.b localb = new com.tencent.mm.plugin.webview.ui.tools.browser.view.b(this.Jlp.getUIContext());
    localb.setOnKeyListener((DialogInterface.OnKeyListener)new d(localb, this));
    localb.setOnCancelListener((DialogInterface.OnCancelListener)new e(this));
    localb.JlS = ((com.tencent.mm.plugin.webview.ui.tools.browser.listener.a)this.Jln);
    List localList = this.Jli;
    p.h(localList, "list");
    localb.Jli = localList;
    this.Jll = localb;
    this.Jlp.d((Dialog)this.Jll);
    AppMethodBeat.o(210395);
  }
  
  final void r(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(210396);
    if (paramIntent == null) {
      bool = true;
    }
    Log.i("MicroMsg.BrowserChooseController", "alvinluo finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    this.Jlp.r(paramInt, paramIntent);
    AppMethodBeat.o(210396);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "onCloseClick", "onMoreClick", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.a
  {
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(210379);
      if (parama != null) {}
      for (int i = parama.hashCode();; i = 0)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onCloseClick dialog: %s", new Object[] { Integer.valueOf(i) });
        if (parama != null) {
          parama.setOnDismissListener((DialogInterface.OnDismissListener)new b(this));
        }
        if (parama == null) {
          break;
        }
        parama.dismiss();
        AppMethodBeat.o(210379);
        return;
      }
      AppMethodBeat.o(210379);
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(210381);
      int i;
      Object localObject1;
      label52:
      Object localObject2;
      if (parama != null)
      {
        i = parama.hashCode();
        if (paramf == null) {
          break label238;
        }
        localObject1 = paramf.resolveInfo;
        if (localObject1 == null) {
          break label238;
        }
        localObject1 = ((ResolveInfo)localObject1).activityInfo;
        if (localObject1 == null) {
          break label238;
        }
        localObject1 = ((ActivityInfo)localObject1).packageName;
        if (paramf == null) {
          break label244;
        }
        localObject2 = paramf.resolveInfo;
        if (localObject2 == null) {
          break label244;
        }
        localObject2 = ((ResolveInfo)localObject2).activityInfo;
        if (localObject2 == null) {
          break label244;
        }
        localObject2 = ((ActivityInfo)localObject2).name;
        label86:
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onBrowserItemClick dialog: %s, packageName: %s, targetActivity: %s", new Object[] { Integer.valueOf(i), localObject1, localObject2 });
        if (parama != null) {
          parama.setOnDismissListener((DialogInterface.OnDismissListener)new a(this));
        }
        if (parama != null) {
          parama.dismiss();
        }
        localObject1 = a.e(this.Jlr).getUIContext();
        localObject2 = a.e(this.Jlr).getTargetIntent();
        if (paramf == null) {
          break label250;
        }
      }
      label238:
      label244:
      label250:
      for (parama = paramf.resolveInfo;; parama = null)
      {
        b.a((Context)localObject1, (Intent)localObject2, parama);
        long l = a.b(this.Jlr);
        i = a.c(this.Jlr);
        parama = localObject3;
        if (paramf != null) {
          parama = paramf.resolveInfo;
        }
        c.a(l, paramInt, i, parama);
        AppMethodBeat.o(210381);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label52;
        localObject2 = null;
        break label86;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(210380);
      if (parama != null) {}
      for (int i = parama.hashCode();; i = 0)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onMoreClick dialog: %s", new Object[] { Integer.valueOf(i) });
        if (parama != null) {
          parama.setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
        }
        if (parama != null) {
          parama.dismiss();
        }
        c.q(a.b(this.Jlr), 3, a.c(this.Jlr));
        AppMethodBeat.o(210380);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class a
      implements DialogInterface.OnDismissListener
    {
      a(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210376);
        a.a(this.Jls.Jlr, null);
        AppMethodBeat.o(210376);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b
      implements DialogInterface.OnDismissListener
    {
      b(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210377);
        a.a(this.Jls.Jlr, 4);
        AppMethodBeat.o(210377);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class c
      implements DialogInterface.OnDismissListener
    {
      c(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210378);
        a.h(this.Jls.Jlr);
        AppMethodBeat.o(210378);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "browserItemInfo", "onCancelClick", "onConfirmClick", "setSelectedBrowserInfo", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.c
  {
    f Jlt;
    private int va = -1;
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(210384);
      int i;
      if (parama != null)
      {
        i = parama.hashCode();
        if (paramf == null) {
          break label165;
        }
        parama = Integer.valueOf(paramf.dUm);
        label30:
        if (paramf == null) {
          break label170;
        }
        localObject1 = paramf.resolveInfo;
        if (localObject1 == null) {
          break label170;
        }
        localObject1 = ((ResolveInfo)localObject1).activityInfo;
        if (localObject1 == null) {
          break label170;
        }
      }
      label165:
      label170:
      for (Object localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
      {
        Object localObject2 = localObject3;
        if (paramf != null)
        {
          Object localObject4 = paramf.resolveInfo;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((ResolveInfo)localObject4).activityInfo;
            localObject2 = localObject3;
            if (localObject4 != null) {
              localObject2 = ((ActivityInfo)localObject4).name;
            }
          }
        }
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onBrowserItemClick dialog: %s, itemType: %s, packageName: %s, targetActivity: %s", new Object[] { Integer.valueOf(i), parama, localObject1, localObject2 });
        this.Jlt = paramf;
        this.va = paramInt;
        AppMethodBeat.o(210384);
        return;
        i = 0;
        break;
        parama = null;
        break label30;
      }
    }
    
    public final void c(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      Integer localInteger = null;
      AppMethodBeat.i(210385);
      Object localObject = this.Jlt;
      if (localObject != null)
      {
        localObject = ((f)localObject).resolveInfo;
        if (localObject != null)
        {
          localObject = ((ResolveInfo)localObject).activityInfo;
          if (localObject == null) {}
        }
      }
      for (localObject = ((ActivityInfo)localObject).packageName;; localObject = null)
      {
        f localf = this.Jlt;
        if (localf != null) {
          localInteger = Integer.valueOf(localf.dUm);
        }
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onConfirmClick selected: %s, itemType: %s", new Object[] { localObject, localInteger });
        if (this.Jlt != null) {
          break;
        }
        Log.e("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog selectedInfo is null");
        AppMethodBeat.o(210385);
        return;
      }
      localObject = this.Jlt;
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.a((f)localObject);
      if (parama != null) {
        parama.setOnDismissListener((DialogInterface.OnDismissListener)new b(this));
      }
      if (parama != null) {
        parama.dismiss();
      }
      c.a(a.b(this.Jlr), this.Jlt, a.c(this.Jlr), this.va);
      AppMethodBeat.o(210385);
    }
    
    public final void d(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(210386);
      Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onCancelClick");
      if (parama != null) {
        parama.setOnDismissListener((DialogInterface.OnDismissListener)new a(this));
      }
      if (parama != null)
      {
        parama.dismiss();
        AppMethodBeat.o(210386);
        return;
      }
      AppMethodBeat.o(210386);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class a
      implements DialogInterface.OnDismissListener
    {
      a(a.c paramc) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210382);
        a.a(this.Jlu.Jlr);
        c.r(a.b(this.Jlu.Jlr), 3, a.c(this.Jlu.Jlr));
        AppMethodBeat.o(210382);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b
      implements DialogInterface.OnDismissListener
    {
      b(a.c paramc) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(210383);
        a locala = this.Jlu.Jlr;
        Intent localIntent = new Intent();
        paramDialogInterface = this.Jlu.Jlt;
        if ((paramDialogInterface != null) && (paramDialogInterface.dUm == 2)) {
          p.g(localIntent.putExtra("browser_setting_result", 2), "putExtra(BrowserChooseUI…LT_UNSET_DEFAULT_BROWSER)");
        }
        do
        {
          a.a(locala, localIntent);
          AppMethodBeat.o(210383);
          return;
          paramDialogInterface = this.Jlu.Jlt;
        } while ((paramDialogInterface == null) || (paramDialogInterface.dUm != 1));
        localIntent.putExtra("browser_setting_result", 1);
        paramDialogInterface = this.Jlu.Jlt;
        if (paramDialogInterface != null) {}
        for (paramDialogInterface = paramDialogInterface.resolveInfo;; paramDialogInterface = null)
        {
          localIntent.putExtra("show_browser_resolve_info", (Parcelable)paramDialogInterface);
          localIntent.putExtra("show_browser_with_animation", true);
          break;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$1"})
  static final class d
    implements DialogInterface.OnKeyListener
  {
    d(com.tencent.mm.plugin.webview.ui.tools.browser.view.b paramb, a parama) {}
    
    public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(210388);
      StringBuilder localStringBuilder = new StringBuilder("alvinluo browserChooseDialog keyCode: ").append(paramInt).append(", event: ");
      if (paramKeyEvent != null) {}
      for (paramKeyEvent = Integer.valueOf(paramKeyEvent.getAction());; paramKeyEvent = null)
      {
        Log.i("MicroMsg.BrowserChooseController", paramKeyEvent);
        if (paramInt != 4) {
          break;
        }
        this.Jlv.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(210387);
            a.a(this.Jlw.Jlr, 6);
            AppMethodBeat.o(210387);
          }
        });
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        AppMethodBeat.o(210388);
        return true;
      }
      AppMethodBeat.o(210388);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$2"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(210389);
      a.a(this.Jlr, 5);
      AppMethodBeat.o(210389);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$1"})
  static final class f
    implements DialogInterface.OnKeyListener
  {
    f(com.tencent.mm.plugin.webview.ui.tools.browser.view.c paramc, a parama) {}
    
    public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(210391);
      if (paramInt == 4)
      {
        this.Jlx.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(210390);
            a.a(this.Jly.Jlr);
            c.r(a.b(this.Jly.Jlr), 5, a.c(this.Jly.Jlr));
            AppMethodBeat.o(210390);
          }
        });
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        AppMethodBeat.o(210391);
        return true;
      }
      AppMethodBeat.o(210391);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$2"})
  static final class g
    implements DialogInterface.OnCancelListener
  {
    g(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(210392);
      a.d(this.Jlr);
      AppMethodBeat.o(210392);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210393);
      a.e(this.Jlr).d((Dialog)a.f(this.Jlr));
      c.r(a.b(this.Jlr), 1, a.c(this.Jlr));
      AppMethodBeat.o(210393);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210394);
      a.g(this.Jlr);
      AppMethodBeat.o(210394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.a
 * JD-Core Version:    0.7.0.1
 */