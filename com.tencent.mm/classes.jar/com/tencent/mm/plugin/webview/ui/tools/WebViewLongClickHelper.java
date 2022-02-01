package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.k.h.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ad;
import com.tencent.xweb.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class WebViewLongClickHelper
  extends a
{
  static Map<String, Boolean> GYh;
  private static long GYi;
  private static IListener GYo;
  private static long mSessionId;
  private ArrayList<ImageQBarDataBean> GYe;
  private String GYf;
  private com.tencent.mm.plugin.webview.k.q GYg;
  private HashMap<String, Long> GYj;
  public Long GYk;
  public Long GYl;
  private Long GYm;
  com.tencent.mm.ui.widget.a.f rAK;
  ScanCodeSheetItemLogic rAP;
  com.tencent.mm.plugin.webview.k.h sLJ;
  private WebView.b sLK;
  private WebView.b sLL;
  private h.c sLQ;
  String sML;
  
  static
  {
    AppMethodBeat.i(175784);
    GYh = new HashMap();
    mSessionId = 0L;
    GYi = 0L;
    AppMethodBeat.o(175784);
  }
  
  public WebViewLongClickHelper(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.GYe = new ArrayList();
    this.sML = "";
    this.GYj = new HashMap();
    this.GYk = Long.valueOf(0L);
    this.GYl = Long.valueOf(0L);
    this.GYm = Long.valueOf(0L);
    this.sLQ = new h.c()
    {
      public final void acB(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (WebViewLongClickHelper.this.bpe())
        {
          AppMethodBeat.o(79838);
          return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "onCaptureFinish:".concat(String.valueOf(paramAnonymousString)));
        WebViewLongClickHelper.dL(System.currentTimeMillis());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this).put(paramAnonymousString, Long.valueOf(WebViewLongClickHelper.GYi));
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new WebViewLongClickHelper.ScanImageData(paramAnonymousString, WebViewLongClickHelper.GYi, WebViewLongClickHelper.this.iwO().x_down, WebViewLongClickHelper.this.iwO().y_down, WebViewLongClickHelper.this.iwO().sMP.getMeasuredWidth(), WebViewLongClickHelper.this.iwO().sMP.getMeasuredHeight()), WebViewLongClickHelper.c.class, new WebViewLongClickHelper.b(new WeakReference(WebViewLongClickHelper.this), paramAnonymousString));
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(79838);
      }
    };
    fqh();
    this.rAP = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(79840);
        if ((WebViewLongClickHelper.f(WebViewLongClickHelper.this) != null) && (WebViewLongClickHelper.f(WebViewLongClickHelper.this).isShowing())) {
          WebViewLongClickHelper.d(WebViewLongClickHelper.this);
        }
        AppMethodBeat.o(79840);
      }
    });
    AppMethodBeat.o(79848);
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.GYe)) && (iwO().sLD.iwp().iPP()) && (fqk()))
    {
      this.sLL = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(iwO().sMP, this.sLQ);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aCU(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (bpe())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!fqi())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.GYf = paramString;
    if (this.rAK == null) {
      this.rAK = new com.tencent.mm.ui.widget.a.f(iwO(), 1, false);
    }
    this.rAK.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(79843);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymouss);
        AppMethodBeat.o(79843);
      }
    };
    this.rAK.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(79844);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(79844);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 1, null);
          WebViewLongClickHelper.b(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(79844);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 2, null);
          WebViewLongClickHelper.c(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(79844);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 3, null);
          WebViewLongClickHelper.d(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(79844);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 7, null);
          WebViewLongClickHelper.e(WebViewLongClickHelper.this, paramString);
        }
      }
    };
    this.rAK.aeLi = new f.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, 5, null);
        if ((WebViewLongClickHelper.this.sLJ != null) && (WebViewLongClickHelper.this.iwO().sLC != null)) {
          try
          {
            WebViewLongClickHelper.c(WebViewLongClickHelper.this).clear();
            WebViewLongClickHelper.m(WebViewLongClickHelper.this).onDismiss();
            WebViewLongClickHelper.f(WebViewLongClickHelper.this, WebViewLongClickHelper.this.sLJ.XsV);
            WebViewLongClickHelper.this.sLJ.iCR();
            AppMethodBeat.o(79845);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(79845);
      }
    };
    if ((!iwO().isFinishing()) && (hBj())) {
      this.rAK.dDn();
    }
    boolean bool = this.rAK.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  static String aiC(String paramString)
  {
    AppMethodBeat.i(175768);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!aiy(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiC(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private static boolean aiy(String paramString)
  {
    AppMethodBeat.i(296362);
    if ((paramString == null) || (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class) == null))
    {
      AppMethodBeat.o(296362);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(paramString);
    AppMethodBeat.o(296362);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.GYe)) && (iwO().sLD.iwp().iPP()) && (fqk()))
    {
      this.sLK = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(iwO().sMP, this.sLQ);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  public static void d(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(296366);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yNd, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(296366);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yNe, 500);
    if ((i < 150) || (i > 2500))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(296366);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(296366);
  }
  
  private boolean fqi()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = iwO().sLC.isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(79854);
    return bool1;
  }
  
  private boolean fqj()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = iwO().sLC.iwU();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(79855);
    return bool1;
  }
  
  private boolean fqk()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = iwO().avS(Util.nullAsNil(iwO().WXR));
    if ((i == 53) || (i == 52))
    {
      Log.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (iwO().sLC == null)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = iwO().sLC.ixf();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(79856);
    return bool1;
  }
  
  private boolean hBj()
  {
    AppMethodBeat.i(175767);
    if ((!ixJ()) || (!Util.isNullOrNil(this.GYe)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  private boolean ho(View paramView)
  {
    AppMethodBeat.i(79850);
    if (bpe())
    {
      AppMethodBeat.o(79850);
      return false;
    }
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = iwO().sMP.getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(79850);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          b(paramView);
        }
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
        continue;
      }
      AppMethodBeat.o(79850);
      return false;
      if ((paramView instanceof MMWebView))
      {
        paramView = ((MMWebView)paramView).getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(79850);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          a(paramView);
        }
      }
    }
  }
  
  public static long ixG()
  {
    return mSessionId;
  }
  
  private boolean ixI()
  {
    AppMethodBeat.i(175765);
    boolean bool = GYh.containsKey(aiC(this.sML));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean ixJ()
  {
    AppMethodBeat.i(175766);
    if (!ixI())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)GYh.get(aiC(this.sML))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  public static void xO(long paramLong)
  {
    mSessionId = paramLong;
  }
  
  public final void fqh()
  {
    AppMethodBeat.i(296452);
    if (iwO().sMP == null)
    {
      AppMethodBeat.o(296452);
      return;
    }
    iwO().sMP.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(79842);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, new com.tencent.mm.plugin.webview.k.q());
        WebViewLongClickHelper.i(WebViewLongClickHelper.this).iF(1);
        Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
        WebViewLongClickHelper.j(WebViewLongClickHelper.this);
        if (WebViewLongClickHelper.this.iwO().sMP == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(79842);
          return false;
        }
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, WebViewLongClickHelper.this.iwO().fqa());
        if ((!WebViewLongClickHelper.k(WebViewLongClickHelper.this)) && (WebViewLongClickHelper.blG(WebViewLongClickHelper.l(WebViewLongClickHelper.this)))) {
          WebViewLongClickHelper.this.iwO().sMP.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(79842);
          return false;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymousView);
        }
      }
    });
    AppMethodBeat.o(296452);
  }
  
  final void iuK()
  {
    AppMethodBeat.i(79849);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79841);
        if (WebViewLongClickHelper.g(WebViewLongClickHelper.this) != null)
        {
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, WebViewLongClickHelper.g(WebViewLongClickHelper.this));
          AppMethodBeat.o(79841);
          return;
        }
        if (WebViewLongClickHelper.h(WebViewLongClickHelper.this) != null) {
          WebViewLongClickHelper.b(WebViewLongClickHelper.this, WebViewLongClickHelper.h(WebViewLongClickHelper.this));
        }
        AppMethodBeat.o(79841);
      }
    });
    AppMethodBeat.o(79849);
  }
  
  final void ixH()
  {
    AppMethodBeat.i(296447);
    if (Util.isNullOrNil(this.GYe))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mImageQBarDataList nil");
      AppMethodBeat.o(296447);
      return;
    }
    if (this.GYe.size() != 1)
    {
      AppMethodBeat.o(296447);
      return;
    }
    ImageQBarDataBean localImageQBarDataBean = (ImageQBarDataBean)this.GYe.get(0);
    if (!com.tencent.mm.plugin.scanner.k.cU(localImageQBarDataBean.hDb, localImageQBarDataBean.OGQ))
    {
      AppMethodBeat.o(296447);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
    this.rAP.c(localImageQBarDataBean.hDb, e.a.lE(localImageQBarDataBean.OGQ, this.sML));
    AppMethodBeat.o(296447);
  }
  
  static class CancelRecogQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<CancelRecogQBarData> CREATOR;
    String filePath;
    long hBk;
    
    static
    {
      AppMethodBeat.i(296257);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(296257);
    }
    
    protected CancelRecogQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(296253);
      this.filePath = paramParcel.readString();
      this.hBk = paramParcel.readLong();
      AppMethodBeat.o(296253);
    }
    
    public CancelRecogQBarData(String paramString, long paramLong)
    {
      this.filePath = paramString;
      this.hBk = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(296263);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.hBk);
      AppMethodBeat.o(296263);
    }
  }
  
  static class ImageQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageQBarData> CREATOR;
    String GYs;
    boolean GYt;
    ArrayList<ImageQBarDataBean> mDataList;
    
    static
    {
      AppMethodBeat.i(297509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(297509);
    }
    
    protected ImageQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(297505);
      this.mDataList = paramParcel.createTypedArrayList(ImageQBarDataBean.CREATOR);
      this.GYs = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.GYt = bool;
        AppMethodBeat.o(297505);
        return;
      }
    }
    
    public ImageQBarData(ArrayList<ImageQBarDataBean> paramArrayList, String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(297498);
      this.mDataList = paramArrayList;
      this.GYs = paramString;
      this.GYt = paramBoolean.booleanValue();
      AppMethodBeat.o(297498);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297512);
      paramParcel.writeTypedList(this.mDataList);
      paramParcel.writeString(this.GYs);
      if (this.GYt) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(297512);
        return;
      }
    }
  }
  
  static class ScanImageData
    implements Parcelable
  {
    public static final Parcelable.Creator<ScanImageData> CREATOR;
    String filePath;
    long hBk;
    int height;
    float tZl;
    float tZm;
    int width;
    
    static
    {
      AppMethodBeat.i(296778);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(296778);
    }
    
    protected ScanImageData(Parcel paramParcel)
    {
      AppMethodBeat.i(296772);
      this.filePath = paramParcel.readString();
      this.hBk = paramParcel.readLong();
      this.tZl = paramParcel.readFloat();
      this.tZm = paramParcel.readFloat();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      AppMethodBeat.o(296772);
    }
    
    public ScanImageData(String paramString, long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.filePath = paramString;
      this.hBk = paramLong;
      this.tZl = paramFloat1;
      this.tZm = paramFloat2;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(296787);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.hBk);
      paramParcel.writeFloat(this.tZl);
      paramParcel.writeFloat(this.tZm);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      AppMethodBeat.o(296787);
    }
  }
  
  static final class a
  {
    final int id;
    final String title;
    
    public a(int paramInt, String paramString)
    {
      this.id = paramInt;
      this.title = paramString;
    }
  }
  
  static final class b
    implements com.tencent.mm.ipcinvoker.f<WebViewLongClickHelper.ImageQBarData>
  {
    private WeakReference<WebViewLongClickHelper> GYu;
    private String mPath;
    
    public b(WeakReference<WebViewLongClickHelper> paramWeakReference, String paramString)
    {
      this.GYu = paramWeakReference;
      this.mPath = paramString;
    }
  }
  
  public static class c
    implements d<WebViewLongClickHelper.ScanImageData, WebViewLongClickHelper.ImageQBarData>
  {}
  
  public static class d
    implements d<WebViewLongClickHelper.CancelRecogQBarData, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewLongClickHelper
 * JD-Core Version:    0.7.0.1
 */