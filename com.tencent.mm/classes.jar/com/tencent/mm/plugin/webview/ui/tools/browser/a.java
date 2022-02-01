package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "", "uiModel", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;)V", "browserChooseDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1;", "browserSettingDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1;", "defaultBrowserIndex", "", "mBrowserChooseDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "mBrowserCount", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserSettingDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "mSessionId", "", "cancelChooseDialog", "", "action", "cancelSettingDialog", "finishUI", "resultCode", "data", "Landroid/content/Intent;", "initBrowserList", "onCreate", "showBrowserChooseDialog", "showBrowserChooseDialogInner", "showSettingDialog", "switchToChooseDialog", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a XaE;
  final com.tencent.mm.plugin.webview.ui.tools.browser.model.a XaF;
  final List<f> XaG;
  int XaH;
  int XaI;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.b XaJ;
  private com.tencent.mm.plugin.webview.ui.tools.browser.view.c XaK;
  private final b XaL;
  private final c XaM;
  long mSessionId;
  
  static
  {
    AppMethodBeat.i(296652);
    XaE = new a((byte)0);
    AppMethodBeat.o(296652);
  }
  
  public a(com.tencent.mm.plugin.webview.ui.tools.browser.model.a parama)
  {
    AppMethodBeat.i(296543);
    this.XaF = parama;
    this.XaG = ((List)new ArrayList());
    this.XaI = -1;
    this.XaL = new b(this);
    this.XaM = new c(this);
    AppMethodBeat.o(296543);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(296593);
    s.u(parama, "this$0");
    parama.XaF.e((Dialog)parama.XaK);
    c.B(parama.mSessionId, 1, parama.XaH);
    AppMethodBeat.o(296593);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(296573);
    s.u(parama, "this$0");
    parama.izJ();
    c.B(parama.mSessionId, 5, parama.XaH);
    AppMethodBeat.o(296573);
  }
  
  private static final boolean a(com.tencent.mm.plugin.webview.ui.tools.browser.view.b paramb, a parama, DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(296605);
    s.u(paramb, "$this_apply");
    s.u(parama, "this$0");
    StringBuilder localStringBuilder = new StringBuilder("alvinluo browserChooseDialog keyCode: ").append(paramInt).append(", event: ");
    if (paramKeyEvent == null) {}
    for (paramKeyEvent = null;; paramKeyEvent = Integer.valueOf(paramKeyEvent.getAction()))
    {
      Log.i("MicroMsg.BrowserChooseController", paramKeyEvent);
      if (paramInt != 4) {
        break;
      }
      paramb.setOnDismissListener(new a..ExternalSyntheticLambda3(parama));
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      AppMethodBeat.o(296605);
      return true;
    }
    AppMethodBeat.o(296605);
    return false;
  }
  
  private static final boolean a(com.tencent.mm.plugin.webview.ui.tools.browser.view.c paramc, a parama, DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(296581);
    s.u(paramc, "$this_apply");
    s.u(parama, "this$0");
    if (paramInt == 4)
    {
      paramc.setOnDismissListener(new a..ExternalSyntheticLambda2(parama));
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      AppMethodBeat.o(296581);
      return true;
    }
    AppMethodBeat.o(296581);
    return false;
  }
  
  private final void auB(int paramInt)
  {
    AppMethodBeat.i(296557);
    Intent localIntent = new Intent();
    if (paramInt != 5) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("show_webview_menu", bool);
      ah localah = ah.aiuX;
      u(0, localIntent);
      c.A(this.mSessionId, paramInt, this.XaH);
      AppMethodBeat.o(296557);
      return;
    }
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(296616);
    s.u(parama, "this$0");
    parama.izI();
    AppMethodBeat.o(296616);
  }
  
  private static final void b(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(296588);
    s.u(parama, "this$0");
    parama.u(0, null);
    c.B(parama.mSessionId, 4, parama.XaH);
    AppMethodBeat.o(296588);
  }
  
  private static final void c(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(296600);
    s.u(parama, "this$0");
    parama.auB(6);
    AppMethodBeat.o(296600);
  }
  
  private static final void d(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(296610);
    s.u(parama, "this$0");
    parama.auB(5);
    AppMethodBeat.o(296610);
  }
  
  private final void izI()
  {
    AppMethodBeat.i(296550);
    Log.i("MicroMsg.BrowserChooseController", "alvinluo showBrowserChooseDialog");
    com.tencent.mm.plugin.webview.ui.tools.browser.view.b localb = new com.tencent.mm.plugin.webview.ui.tools.browser.view.b(this.XaF.getUIContext());
    localb.setOnKeyListener(new a..ExternalSyntheticLambda4(localb, this));
    localb.setOnCancelListener(new a..ExternalSyntheticLambda1(this));
    localb.Xbh = ((com.tencent.mm.plugin.webview.ui.tools.browser.listener.a)this.XaL);
    localb.setBrowserList(this.XaG);
    ah localah = ah.aiuX;
    this.XaJ = localb;
    this.XaF.e((Dialog)this.XaJ);
    AppMethodBeat.o(296550);
  }
  
  private final void izJ()
  {
    AppMethodBeat.i(296566);
    h.ahAA.o(new a..ExternalSyntheticLambda7(this), 100L);
    AppMethodBeat.o(296566);
  }
  
  public final void izH()
  {
    AppMethodBeat.i(296689);
    izI();
    c.A(this.mSessionId, 1, this.XaH);
    AppMethodBeat.o(296689);
  }
  
  final void u(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(296693);
    if (paramIntent == null) {
      bool = true;
    }
    Log.i("MicroMsg.BrowserChooseController", "alvinluo finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    this.XaF.u(paramInt, paramIntent);
    AppMethodBeat.o(296693);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$Companion;", "", "()V", "SHOW_DIALOG_DELAY_MS", "", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "onCloseClick", "onMoreClick", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.a
  {
    b(a parama) {}
    
    private static final void e(a parama, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(296506);
      s.u(parama, "this$0");
      a.f(parama);
      AppMethodBeat.o(296506);
    }
    
    private static final void f(a parama, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(296509);
      s.u(parama, "this$0");
      a.g(parama);
      AppMethodBeat.o(296509);
    }
    
    private static final void g(a parama, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(296514);
      s.u(parama, "this$0");
      a.a(parama, null);
      AppMethodBeat.o(296514);
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(296535);
      if (parama != null) {}
      for (int i = parama.hashCode();; i = 0)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onCloseClick dialog: %s", new Object[] { Integer.valueOf(i) });
        if (parama != null) {
          parama.setOnDismissListener(new a.b..ExternalSyntheticLambda0(this.XaN));
        }
        if (parama != null) {
          parama.dismiss();
        }
        AppMethodBeat.o(296535);
        return;
      }
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(296551);
      int i;
      Object localObject1;
      label25:
      Object localObject2;
      label32:
      label122:
      long l;
      if (parama != null)
      {
        i = parama.hashCode();
        if (paramf != null) {
          break label176;
        }
        localObject1 = null;
        if (paramf != null) {
          break label221;
        }
        localObject2 = null;
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onBrowserItemClick dialog: %s, packageName: %s, targetActivity: %s", new Object[] { Integer.valueOf(i), localObject1, localObject2 });
        if (parama != null) {
          parama.setOnDismissListener(new a.b..ExternalSyntheticLambda1(this.XaN));
        }
        if (parama != null) {
          parama.dismiss();
        }
        localObject1 = a.e(this.XaN).getUIContext();
        localObject2 = a.e(this.XaN).izK();
        if (paramf != null) {
          break label266;
        }
        parama = null;
        b.a((Context)localObject1, (Intent)localObject2, parama);
        l = a.c(this.XaN);
        i = a.d(this.XaN);
        if (paramf != null) {
          break label274;
        }
      }
      label266:
      label274:
      for (parama = localObject3;; parama = paramf.qK)
      {
        c.a(l, paramInt, i, parama);
        AppMethodBeat.o(296551);
        return;
        i = 0;
        break;
        label176:
        localObject1 = paramf.qK;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label25;
        }
        localObject1 = ((ResolveInfo)localObject1).activityInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label25;
        }
        localObject1 = ((ActivityInfo)localObject1).packageName;
        break label25;
        label221:
        localObject2 = paramf.qK;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label32;
        }
        localObject2 = ((ResolveInfo)localObject2).activityInfo;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label32;
        }
        localObject2 = ((ActivityInfo)localObject2).name;
        break label32;
        parama = paramf.qK;
        break label122;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(296540);
      if (parama != null) {}
      for (int i = parama.hashCode();; i = 0)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onMoreClick dialog: %s", new Object[] { Integer.valueOf(i) });
        if (parama != null) {
          parama.setOnDismissListener(new a.b..ExternalSyntheticLambda2(this.XaN));
        }
        if (parama != null) {
          parama.dismiss();
        }
        c.A(a.c(this.XaN), 3, a.d(this.XaN));
        AppMethodBeat.o(296540);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "browserItemInfo", "onCancelClick", "onConfirmClick", "setSelectedBrowserInfo", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.c
  {
    f XaO;
    private int dyx = -1;
    
    c(a parama) {}
    
    private static final void a(a parama, c paramc, DialogInterface paramDialogInterface)
    {
      int j = 0;
      AppMethodBeat.i(296505);
      s.u(parama, "this$0");
      s.u(paramc, "this$1");
      paramDialogInterface = new Intent();
      f localf = paramc.XaO;
      int i;
      if ((localf != null) && (localf.itemType == 2))
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        paramDialogInterface.putExtra("browser_setting_result", 2);
      }
      label82:
      do
      {
        paramc = ah.aiuX;
        a.a(parama, paramDialogInterface);
        AppMethodBeat.o(296505);
        return;
        i = 0;
        break;
        localf = paramc.XaO;
        i = j;
        if (localf != null)
        {
          i = j;
          if (localf.itemType == 1) {
            i = 1;
          }
        }
      } while (i == 0);
      paramDialogInterface.putExtra("browser_setting_result", 1);
      paramc = paramc.XaO;
      if (paramc == null) {}
      for (paramc = null;; paramc = paramc.qK)
      {
        paramDialogInterface.putExtra("show_browser_resolve_info", (Parcelable)paramc);
        paramDialogInterface.putExtra("show_browser_with_animation", true);
        break;
      }
    }
    
    private static final void h(a parama, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(296511);
      s.u(parama, "this$0");
      a.h(parama);
      c.B(a.c(parama), 3, a.d(parama));
      AppMethodBeat.o(296511);
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama, int paramInt, f paramf)
    {
      Object localObject2 = null;
      AppMethodBeat.i(296530);
      int i;
      Integer localInteger;
      label25:
      label31:
      Object localObject1;
      if (parama != null)
      {
        i = parama.hashCode();
        if (paramf != null) {
          break label94;
        }
        localInteger = null;
        if (paramf != null) {
          break label106;
        }
        parama = null;
        if (paramf != null) {
          break label142;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onBrowserItemClick dialog: %s, itemType: %s, packageName: %s, targetActivity: %s", new Object[] { Integer.valueOf(i), localInteger, parama, localObject1 });
        this.XaO = paramf;
        this.dyx = paramInt;
        AppMethodBeat.o(296530);
        return;
        i = 0;
        break;
        label94:
        localInteger = Integer.valueOf(paramf.itemType);
        break label25;
        label106:
        parama = paramf.qK;
        if (parama == null)
        {
          parama = null;
          break label31;
        }
        parama = parama.activityInfo;
        if (parama == null)
        {
          parama = null;
          break label31;
        }
        parama = parama.packageName;
        break label31;
        label142:
        Object localObject3 = paramf.qK;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((ResolveInfo)localObject3).activityInfo;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ActivityInfo)localObject3).name;
          }
        }
      }
    }
    
    public final void c(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      Integer localInteger = null;
      AppMethodBeat.i(296537);
      Object localObject = this.XaO;
      f localf;
      if (localObject == null)
      {
        localObject = null;
        localf = this.XaO;
        if (localf != null) {
          break label104;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onConfirmClick selected: %s, itemType: %s", new Object[] { localObject, localInteger });
        if (this.XaO != null) {
          break label116;
        }
        Log.e("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog selectedInfo is null");
        AppMethodBeat.o(296537);
        return;
        localObject = ((f)localObject).qK;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = ((ResolveInfo)localObject).activityInfo;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = ((ActivityInfo)localObject).packageName;
        break;
        label104:
        localInteger = Integer.valueOf(localf.itemType);
      }
      label116:
      localObject = this.XaO;
      s.checkNotNull(localObject);
      com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.a((f)localObject);
      if (parama != null) {
        parama.setOnDismissListener(new a.c..ExternalSyntheticLambda1(this.XaN, this));
      }
      if (parama != null) {
        parama.dismiss();
      }
      c.a(a.c(this.XaN), this.XaO, a.d(this.XaN), this.dyx);
      AppMethodBeat.o(296537);
    }
    
    public final void d(com.tencent.mm.plugin.webview.ui.tools.browser.view.a parama)
    {
      AppMethodBeat.i(296542);
      Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onCancelClick");
      if (parama != null) {
        parama.setOnDismissListener(new a.c..ExternalSyntheticLambda0(this.XaN));
      }
      if (parama != null) {
        parama.dismiss();
      }
      AppMethodBeat.o(296542);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.a
 * JD-Core Version:    0.7.0.1
 */