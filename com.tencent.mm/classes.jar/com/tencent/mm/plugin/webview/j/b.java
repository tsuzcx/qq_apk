package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import com.tencent.xweb.af;
import com.tencent.xweb.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper;", "", "()V", "isShowProgressDialog", "", "isSnapShotMode", "()Z", "setSnapShotMode", "(Z)V", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "pageContentLayoutView", "Landroid/view/View;", "pageMaskContentView", "pageScrollView", "Landroid/widget/ScrollView;", "pageWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "rootView", "Landroid/view/ViewGroup;", "snapShotWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tipsLayout", "tipsTv", "Landroid/widget/TextView;", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "viewFullLayout", "webViewContainer", "Landroid/widget/FrameLayout;", "webViewControllerListener", "com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper$webViewControllerListener$1;", "wvCallbackClient", "Lcom/tencent/xweb/WebViewCallbackClient;", "enterSnapshotMode", "", "context", "pageUrl", "", "wording", "exitSnapshotMode", "getJsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getUI", "initSnapShotView", "onWebViewClick", "releaseSnapShotWebView", "startCheckProgressDialog", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a WQX;
  private TextView DMt;
  private View EBQ;
  private FrameLayout QQO;
  public boolean WQY;
  private View WQZ;
  private ScrollView WRa;
  private MMWebView WRb;
  private View WRc;
  private View WRd;
  private com.tencent.mm.plugin.webview.core.k WRe;
  private boolean WRf;
  private b WRg;
  private af WRh;
  private long lastClickTime;
  public ViewGroup pzj;
  private WeakReference<WebViewUI> tLO;
  
  static
  {
    AppMethodBeat.i(294759);
    WQX = new a((byte)0);
    AppMethodBeat.o(294759);
  }
  
  public b()
  {
    AppMethodBeat.i(294723);
    this.WRg = new b(this);
    this.WRh = ((af)new c(this));
    AppMethodBeat.o(294723);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(294748);
    s.u(paramb, "this$0");
    if (!paramb.WRg.WRi)
    {
      Log.w("MicroMsg.WebViewSnapshotHelper", "show progressBar on time expire");
      paramb.WRg.cxV();
      ba.xM(18L);
    }
    Object localObject = paramb.iwO();
    if (localObject != null)
    {
      localObject = ((WebViewUI)localObject).Wzl;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.webview.core.k)localObject).WyA;
        if (localObject != null) {
          ((ag.c)localObject).dismissLoadingDialog();
        }
      }
    }
    paramb.WRf = false;
    AppMethodBeat.o(294748);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(294736);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.iwO();
    if (paramb != null)
    {
      paramb = paramb.Wzl;
      if (paramb != null) {
        paramb.isA();
      }
    }
    ba.xM(17L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(294736);
  }
  
  private static final void a(b paramb, WebViewUI paramWebViewUI, View paramView)
  {
    AppMethodBeat.i(294743);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramWebViewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramWebViewUI, "$context");
    s.u(paramWebViewUI, "context");
    if ((paramb.WQY) && (Math.abs(System.currentTimeMillis() - paramb.lastClickTime) >= 2000L))
    {
      paramb.lastClickTime = System.currentTimeMillis();
      aa.showTextToast((Context)paramWebViewUI, paramWebViewUI.getString(c.i.webview_snap_shot_tips));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(294743);
  }
  
  private static final void kA(View paramView)
  {
    AppMethodBeat.i(294729);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(294729);
  }
  
  public final void a(WebViewUI paramWebViewUI, String paramString1, String paramString2)
  {
    AppMethodBeat.i(294798);
    s.u(paramWebViewUI, "context");
    s.u(paramString1, "pageUrl");
    if (this.WQY)
    {
      Log.i("MicroMsg.WebViewSnapshotHelper", "enterSnapshotMode already in snap shot mode now");
      AppMethodBeat.o(294798);
      return;
    }
    ba.xM(16L);
    Log.i("MicroMsg.WebViewSnapshotHelper", s.X("enterSnapshotMode pageUrl=", paramString1));
    this.tLO = new WeakReference(paramWebViewUI);
    if (this.pzj == null) {
      this.pzj = ((ViewGroup)((ViewStub)paramWebViewUI.findViewById(c.f.view_stub_web_view_snatshot_mode)).inflate());
    }
    if (this.pzj != null)
    {
      this.WQZ = paramWebViewUI.findViewById(c.f.snap_shot_web_view_layout);
      this.QQO = ((FrameLayout)paramWebViewUI.findViewById(c.f.snap_shot_web_view_container));
      this.WRa = ((ScrollView)paramWebViewUI.findViewById(c.f.snap_shot_cover_scroll_view));
      this.WRc = paramWebViewUI.findViewById(c.f.snap_shot_mask_content_view);
      this.WRd = paramWebViewUI.findViewById(c.f.snap_shot_view_full_layout);
      this.DMt = ((TextView)paramWebViewUI.findViewById(c.f.snap_shot_tips_tv));
      this.EBQ = paramWebViewUI.findViewById(c.f.snap_shot_tips_layout);
      localObject = this.EBQ;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(b..ExternalSyntheticLambda2.INSTANCE);
      }
      o.F(this.WRd, 0.7F);
      float f = com.tencent.mm.cd.a.fromDPToPix((Context)paramWebViewUI, 8);
      localObject = com.tencent.mm.plugin.bizui.a.a.vtB;
      com.tencent.mm.plugin.bizui.a.a.a(this.WQZ, f, false, true);
      localObject = this.WRd;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
    }
    this.WQY = true;
    paramWebViewUI.getController().setMMTitleVisibility(8);
    Object localObject = paramWebViewUI.sMP;
    if (localObject != null) {
      ((MMWebView)localObject).setVisibility(8);
    }
    if (Util.isNullOrNil(paramString2)) {
      paramString2 = paramWebViewUI.getString(c.i.webview_snap_shot_tips);
    }
    for (;;)
    {
      localObject = this.DMt;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramString2);
      }
      this.WRb = c.kR((Context)paramWebViewUI);
      paramString2 = this.WRb;
      if (paramString2 != null) {
        paramString2.setBackgroundColor(0);
      }
      paramString2 = this.WRb;
      if (paramString2 != null) {
        paramString2.setWebViewCallbackClient(this.WRh);
      }
      paramString2 = new FrameLayout.LayoutParams(-1, -1);
      localObject = this.QQO;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.WRb, (ViewGroup.LayoutParams)paramString2);
      }
      paramString2 = this.WRc;
      if (paramString2 != null) {
        paramString2.setOnClickListener(new b..ExternalSyntheticLambda1(this, paramWebViewUI));
      }
      paramWebViewUI = this.WRb;
      paramString2 = this.WRa;
      s.checkNotNull(paramString2);
      c.a(paramWebViewUI, paramString2);
      paramWebViewUI = this.WRb;
      s.checkNotNull(paramWebViewUI);
      this.WRe = c.i(paramWebViewUI);
      paramWebViewUI = this.WRe;
      if (paramWebViewUI != null) {
        paramWebViewUI.init();
      }
      paramWebViewUI = new Intent();
      paramWebViewUI.putExtra("rawUrl", paramString1);
      this.WRf = true;
      com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda3(this), 3000L);
      paramString1 = this.WRe;
      if (paramString1 != null) {
        paramString1.a((l)this.WRg);
      }
      paramString1 = this.WRe;
      if (paramString1 != null) {
        paramString1.bJ(paramWebViewUI);
      }
      AppMethodBeat.o(294798);
      return;
    }
  }
  
  public final WebViewUI iwO()
  {
    AppMethodBeat.i(294782);
    Object localObject = this.tLO;
    if (localObject == null)
    {
      AppMethodBeat.o(294782);
      return null;
    }
    localObject = (WebViewUI)((WeakReference)localObject).get();
    AppMethodBeat.o(294782);
    return localObject;
  }
  
  public final void iwP()
  {
    AppMethodBeat.i(294813);
    Object localObject1;
    if (this.WRe != null)
    {
      localObject1 = this.WRe;
      s.checkNotNull(localObject1);
      ((com.tencent.mm.plugin.webview.core.k)localObject1).b((l)this.WRg);
      localObject1 = this.WRe;
      s.checkNotNull(localObject1);
      ((com.tencent.mm.plugin.webview.core.k)localObject1).destroy();
    }
    if (this.WRb != null)
    {
      if (com.tencent.mm.plugin.webview.modeltools.h.WNp == null) {
        break label158;
      }
      i = com.tencent.mm.plugin.webview.modeltools.h.WNp.size();
      Log.i("MicroMsg.WebView.SysWebViewDataCleanHelper", "clearWebViewData url list size %d", new Object[] { Integer.valueOf(i) });
      if (ao.kgl()) {
        break label163;
      }
      Log.i("MicroMsg.WebView.SysWebViewDataCleanHelper", "not system WebView, clear all data.");
      WebStorage.getInstance().deleteAllData();
    }
    for (;;)
    {
      localObject1 = this.WRb;
      if (localObject1 != null) {
        ((MMWebView)localObject1).setWebViewCallbackClient(null);
      }
      localObject1 = this.WRb;
      s.checkNotNull(localObject1);
      ((MMWebView)localObject1).destroy();
      this.WRb = null;
      AppMethodBeat.o(294813);
      return;
      label158:
      i = 0;
      break;
      label163:
      if (!Util.isNullOrNil(com.tencent.mm.plugin.webview.modeltools.h.WNp))
      {
        localObject1 = com.tencent.mm.plugin.webview.modeltools.h.WNp.iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = com.tencent.mm.plugin.webview.modeltools.c.bkL((String)((Iterator)localObject1).next());
          WebStorage.getInstance().deleteOrigin((String)localObject2);
        }
        if (!Util.isNullOrNil(com.tencent.mm.plugin.webview.modeltools.h.WNp)) {
          try
          {
            localObject1 = com.tencent.mm.plugin.webview.modeltools.h.WNp;
            localObject2 = CookieManager.getInstance();
            Iterator localIterator = ((List)localObject1).iterator();
            while (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Log.i("MicroMsg.WebView.SysWebViewDataCleanHelper", "cookies cleanup: url(%s)", new Object[] { str1 });
              localObject1 = ((CookieManager)localObject2).getCookie(str1);
              if (!Util.isNullOrNil((String)localObject1)) {
                break label357;
              }
              localObject1 = null;
              com.tencent.mm.plugin.webview.modeltools.h.a(str1, (List)localObject1, (CookieManager)localObject2);
            }
            com.tencent.mm.plugin.webview.modeltools.h.WNp.clear();
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.WebView.SysWebViewDataCleanHelper", "clearHostCookies ex %s", new Object[] { localException.getMessage() });
            Log.i("MicroMsg.WebView.SysWebViewDataCleanHelper", "clearHostCookies end");
          }
        }
      }
    }
    label357:
    String[] arrayOfString = localException.split(";");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = arrayOfString[i].trim();
      i += 1;
    }
    LinkedList localLinkedList = new LinkedList();
    j = arrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if ((!Util.isNullOrNil(str2)) && (str2.contains("="))) {
          localLinkedList.add(str2.split("=")[0]);
        }
      }
      else
      {
        boolean bool = localLinkedList.isEmpty();
        if (!bool) {
          break;
        }
        localLinkedList = null;
        break;
      }
      i += 1;
    }
  }
  
  public final JsapiPermissionWrapper iwo()
  {
    AppMethodBeat.i(294787);
    Object localObject = this.WRe;
    if (localObject == null)
    {
      AppMethodBeat.o(294787);
      return null;
    }
    localObject = ((BaseWebViewController)localObject).sLD;
    if (localObject == null)
    {
      AppMethodBeat.o(294787);
      return null;
    }
    localObject = ((g)localObject).iwo();
    AppMethodBeat.o(294787);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "progressBarEnd", "", "getProgressBarEnd", "()Z", "setProgressBarEnd", "(Z)V", "onBinded", "", "onProgressBarEnd", "onProgressBarStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends l
  {
    boolean WRi = true;
    
    b(b paramb) {}
    
    public final void cxV()
    {
      AppMethodBeat.i(294756);
      if (!b.b(this.WRj))
      {
        Object localObject = this.WRj.iwO();
        if (localObject != null)
        {
          localObject = ((WebViewUI)localObject).WWR;
          if (localObject != null) {
            ((MMFalseProgressBar)localObject).start();
          }
        }
      }
      this.WRi = false;
      AppMethodBeat.o(294756);
    }
    
    public final void cxW()
    {
      AppMethodBeat.i(294752);
      Object localObject = this.WRj.iwO();
      if (localObject != null)
      {
        localObject = ((WebViewUI)localObject).WWR;
        if (localObject != null) {
          ((MMFalseProgressBar)localObject).finish();
        }
      }
      localObject = this.WRj.iwO();
      if (localObject != null)
      {
        localObject = ((WebViewUI)localObject).Wzl;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.webview.core.k)localObject).WyA;
          if (localObject != null) {
            ((ag.c)localObject).dismissLoadingDialog();
          }
        }
      }
      this.WRi = true;
      AppMethodBeat.o(294752);
    }
    
    public final void cxX() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/snapshot/WebViewSnapshotHelper$wvCallbackClient$1", "Lcom/tencent/xweb/WebViewCallbackClient;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "invalidate", "onContentHeightChanged", "height", "", "onInterceptTouchEvent", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "event", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements af
  {
    c(b paramb) {}
    
    public final void Bv(int paramInt)
    {
      AppMethodBeat.i(294755);
      Object localObject1 = b.c(this.WRj);
      Object localObject2;
      int i;
      if (localObject1 != null)
      {
        localObject2 = this.WRj;
        float f = ((MMWebView)localObject1).getScale();
        int j = (int)(paramInt * f);
        localObject1 = b.d((b)localObject2);
        if (localObject1 != null) {
          break label151;
        }
        i = 0;
        i = kotlin.k.k.qu(j, i);
        Log.d("MicroMsg.WebViewSnapshotHelper", "SnapShotMode, webViewHeight:" + paramInt + ", contentHeight:" + i + ", density=" + f);
        localObject1 = b.e((b)localObject2);
        if (localObject1 != null) {
          break label160;
        }
      }
      label151:
      label160:
      for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
      {
        if (localObject1 != null)
        {
          ((ViewGroup.LayoutParams)localObject1).height = (i + 2);
          localObject2 = b.e((b)localObject2);
          if (localObject2 != null) {
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
        AppMethodBeat.o(294755);
        return;
        i = ((FrameLayout)localObject1).getMeasuredHeight();
        break;
      }
    }
    
    public final void computeScroll(View paramView)
    {
      AppMethodBeat.i(294733);
      s.u(paramView, "view");
      AppMethodBeat.o(294733);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(294747);
      s.u(paramMotionEvent, "ev");
      s.u(paramView, "view");
      AppMethodBeat.o(294747);
      return false;
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(294750);
      s.u(paramMotionEvent, "ev");
      s.u(paramView, "view");
      AppMethodBeat.o(294750);
      return false;
    }
    
    public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      AppMethodBeat.i(294737);
      s.u(paramView, "view");
      AppMethodBeat.o(294737);
    }
    
    public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      AppMethodBeat.i(294742);
      s.u(paramView, "view");
      AppMethodBeat.o(294742);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(294722);
      s.u(paramMotionEvent, "event");
      s.u(paramView, "view");
      AppMethodBeat.o(294722);
      return false;
    }
    
    public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      AppMethodBeat.i(294727);
      s.u(paramView, "view");
      AppMethodBeat.o(294727);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.b
 * JD-Core Version:    0.7.0.1
 */