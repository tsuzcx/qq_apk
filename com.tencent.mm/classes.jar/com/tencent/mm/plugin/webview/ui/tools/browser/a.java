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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "", "uiModel", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;)V", "browserChooseDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1;", "browserSettingDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1;", "defaultBrowserIndex", "", "mBrowserChooseDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "mBrowserCount", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserSettingDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "mSessionId", "", "cancelChooseDialog", "", "action", "cancelSettingDialog", "finishUI", "resultCode", "data", "Landroid/content/Intent;", "initBrowserList", "onCreate", "showBrowserChooseDialog", "showBrowserChooseDialogInner", "showSettingDialog", "switchToChooseDialog", "Companion", "plugin-webview_release"})
public final class a
{
  public static final a QiI;
  final List<f> QiA;
  int QiB;
  int QiC;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.b QiD;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.c QiE;
  private final b QiF;
  private final c QiG;
  final com.tencent.mm.plugin.webview.ui.tools.browser.model.a QiH;
  long mSessionId;
  
  static
  {
    AppMethodBeat.i(255755);
    QiI = new a((byte)0);
    AppMethodBeat.o(255755);
  }
  
  public a(com.tencent.mm.plugin.webview.ui.tools.browser.model.a parama)
  {
    AppMethodBeat.i(255754);
    this.QiH = parama;
    this.QiA = ((List)new ArrayList());
    this.QiC = -1;
    this.QiF = new b(this);
    this.QiG = new c(this);
    AppMethodBeat.o(255754);
  }
  
  final void gZG()
  {
    AppMethodBeat.i(255749);
    Log.i("MicroMsg.BrowserChooseController", "alvinluo showBrowserChooseDialog");
    com.tencent.mm.plugin.webview.ui.tools.browser.view.b localb = new com.tencent.mm.plugin.webview.ui.tools.browser.view.b(this.QiH.getUIContext());
    localb.setOnKeyListener((DialogInterface.OnKeyListener)new d(localb, this));
    localb.setOnCancelListener((DialogInterface.OnCancelListener)new e(this));
    localb.Qjk = ((com.tencent.mm.plugin.webview.ui.tools.browser.listener.a)this.QiF);
    List localList = this.QiA;
    p.k(localList, "list");
    localb.QiA = localList;
    this.QiD = localb;
    this.QiH.e((Dialog)this.QiD);
    AppMethodBeat.o(255749);
  }
  
  final void r(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(255751);
    if (paramIntent == null) {
      bool = true;
    }
    Log.i("MicroMsg.BrowserChooseController", "alvinluo finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    this.QiH.r(paramInt, paramIntent);
    AppMethodBeat.o(255751);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$Companion;", "", "()V", "SHOW_DIALOG_DELAY_MS", "", "TAG", "", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "onCloseClick", "onMoreClick", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.a
  {
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(229850);
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
        AppMethodBeat.o(229850);
        return;
      }
      AppMethodBeat.o(229850);
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(229853);
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
        localObject1 = paramf.pN;
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
        localObject2 = paramf.pN;
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
        localObject1 = a.e(this.QiJ).getUIContext();
        localObject2 = a.e(this.QiJ).gZH();
        if (paramf == null) {
          break label250;
        }
      }
      label238:
      label244:
      label250:
      for (parama = paramf.pN;; parama = null)
      {
        b.a((Context)localObject1, (Intent)localObject2, parama);
        long l = a.b(this.QiJ);
        i = a.c(this.QiJ);
        parama = localObject3;
        if (paramf != null) {
          parama = paramf.pN;
        }
        c.a(l, paramInt, i, parama);
        AppMethodBeat.o(229853);
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
      AppMethodBeat.i(229851);
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
        c.r(a.b(this.QiJ), 3, a.c(this.QiJ));
        AppMethodBeat.o(229851);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class a
      implements DialogInterface.OnDismissListener
    {
      a(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(266633);
        a.a(this.QiK.QiJ, null);
        AppMethodBeat.o(266633);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b
      implements DialogInterface.OnDismissListener
    {
      b(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(233508);
        a.a(this.QiK.QiJ, 4);
        AppMethodBeat.o(233508);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class c
      implements DialogInterface.OnDismissListener
    {
      c(a.b paramb) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(265932);
        a.h(this.QiK.QiJ);
        AppMethodBeat.o(265932);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "browserItemInfo", "onCancelClick", "onConfirmClick", "setSelectedBrowserInfo", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.c
  {
    f QiL;
    private int bFx = -1;
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(257111);
      int i;
      if (parama != null)
      {
        i = parama.hashCode();
        if (paramf == null) {
          break label165;
        }
        parama = Integer.valueOf(paramf.fNO);
        label30:
        if (paramf == null) {
          break label170;
        }
        localObject1 = paramf.pN;
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
          Object localObject4 = paramf.pN;
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
        this.QiL = paramf;
        this.bFx = paramInt;
        AppMethodBeat.o(257111);
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
      AppMethodBeat.i(257113);
      Object localObject = this.QiL;
      if (localObject != null)
      {
        localObject = ((f)localObject).pN;
        if (localObject != null)
        {
          localObject = ((ResolveInfo)localObject).activityInfo;
          if (localObject == null) {}
        }
      }
      for (localObject = ((ActivityInfo)localObject).packageName;; localObject = null)
      {
        f localf = this.QiL;
        if (localf != null) {
          localInteger = Integer.valueOf(localf.fNO);
        }
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onConfirmClick selected: %s, itemType: %s", new Object[] { localObject, localInteger });
        if (this.QiL != null) {
          break;
        }
        Log.e("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog selectedInfo is null");
        AppMethodBeat.o(257113);
        return;
      }
      localObject = this.QiL;
      if (localObject == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.a((f)localObject);
      if (parama != null) {
        parama.setOnDismissListener((DialogInterface.OnDismissListener)new b(this));
      }
      if (parama != null) {
        parama.dismiss();
      }
      c.a(a.b(this.QiJ), this.QiL, a.c(this.QiJ), this.bFx);
      AppMethodBeat.o(257113);
    }
    
    public final void d(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(257114);
      Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onCancelClick");
      if (parama != null) {
        parama.setOnDismissListener((DialogInterface.OnDismissListener)new a(this));
      }
      if (parama != null)
      {
        parama.dismiss();
        AppMethodBeat.o(257114);
        return;
      }
      AppMethodBeat.o(257114);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class a
      implements DialogInterface.OnDismissListener
    {
      a(a.c paramc) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(265951);
        a.a(this.QiM.QiJ);
        c.s(a.b(this.QiM.QiJ), 3, a.c(this.QiM.QiJ));
        AppMethodBeat.o(265951);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b
      implements DialogInterface.OnDismissListener
    {
      b(a.c paramc) {}
      
      public final void onDismiss(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(220715);
        a locala = this.QiM.QiJ;
        Intent localIntent = new Intent();
        paramDialogInterface = a.c.a(this.QiM);
        if ((paramDialogInterface != null) && (paramDialogInterface.fNO == 2)) {
          p.j(localIntent.putExtra("browser_setting_result", 2), "putExtra(BrowserChooseUI…LT_UNSET_DEFAULT_BROWSER)");
        }
        do
        {
          a.a(locala, localIntent);
          AppMethodBeat.o(220715);
          return;
          paramDialogInterface = a.c.a(this.QiM);
        } while ((paramDialogInterface == null) || (paramDialogInterface.fNO != 1));
        localIntent.putExtra("browser_setting_result", 1);
        paramDialogInterface = a.c.a(this.QiM);
        if (paramDialogInterface != null) {}
        for (paramDialogInterface = paramDialogInterface.pN;; paramDialogInterface = null)
        {
          localIntent.putExtra("show_browser_resolve_info", (Parcelable)paramDialogInterface);
          localIntent.putExtra("show_browser_with_animation", true);
          break;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$1"})
  static final class d
    implements DialogInterface.OnKeyListener
  {
    d(com.tencent.mm.plugin.webview.ui.tools.browser.view.b paramb, a parama) {}
    
    public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(255001);
      StringBuilder localStringBuilder = new StringBuilder("alvinluo browserChooseDialog keyCode: ").append(paramInt).append(", event: ");
      if (paramKeyEvent != null) {}
      for (paramKeyEvent = Integer.valueOf(paramKeyEvent.getAction());; paramKeyEvent = null)
      {
        Log.i("MicroMsg.BrowserChooseController", paramKeyEvent);
        if (paramInt != 4) {
          break;
        }
        this.QiN.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(215113);
            a.a(this.QiO.QiJ, 6);
            AppMethodBeat.o(215113);
          }
        });
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        AppMethodBeat.o(255001);
        return true;
      }
      AppMethodBeat.o(255001);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$2"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(220853);
      a.a(this.QiJ, 5);
      AppMethodBeat.o(220853);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$1"})
  static final class f
    implements DialogInterface.OnKeyListener
  {
    f(com.tencent.mm.plugin.webview.ui.tools.browser.view.c paramc, a parama) {}
    
    public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(220697);
      if (paramInt == 4)
      {
        this.QiP.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(249700);
            a.a(this.QiQ.QiJ);
            c.s(a.b(this.QiQ.QiJ), 5, a.c(this.QiQ.QiJ));
            AppMethodBeat.o(249700);
          }
        });
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        AppMethodBeat.o(220697);
        return true;
      }
      AppMethodBeat.o(220697);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$2"})
  static final class g
    implements DialogInterface.OnCancelListener
  {
    g(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(260103);
      a.d(this.QiJ);
      AppMethodBeat.o(260103);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(250016);
      a.e(this.QiJ).e((Dialog)a.f(this.QiJ));
      c.s(a.b(this.QiJ), 1, a.c(this.QiJ));
      AppMethodBeat.o(250016);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(268228);
      a.g(this.QiJ);
      AppMethodBeat.o(268228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.a
 * JD-Core Version:    0.7.0.1
 */