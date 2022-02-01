package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
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
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.webview.k.m;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.pluginsdk.ui.tools.ab.a;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class WebViewLongClickHelper
  extends a
{
  static Map<String, Boolean> BrL;
  private static long BrM;
  private static IListener BrS;
  private static long mSessionId;
  private ArrayList<ImageQBarDataBean> BrI;
  private String BrJ;
  private m BrK;
  private HashMap<String, Long> BrN;
  public Long BrO;
  public Long BrP;
  private Long BrQ;
  com.tencent.mm.ui.widget.a.e oxl;
  ScanCodeSheetItemLogic oxq;
  com.tencent.mm.plugin.webview.modeltools.g pGJ;
  private WebView.b pGK;
  private WebView.b pGL;
  private g.c pGQ;
  String pHO;
  
  static
  {
    AppMethodBeat.i(175784);
    BrL = new HashMap();
    mSessionId = 0L;
    BrM = 0L;
    AppMethodBeat.o(175784);
  }
  
  public WebViewLongClickHelper(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.BrI = new ArrayList();
    this.pHO = "";
    this.BrN = new HashMap();
    this.BrO = Long.valueOf(0L);
    this.BrP = Long.valueOf(0L);
    this.BrQ = Long.valueOf(0L);
    this.pGQ = new g.c()
    {
      public final void ajA(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (WebViewLongClickHelper.this.elX())
        {
          AppMethodBeat.o(79838);
          return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "onCaptureFinish:".concat(String.valueOf(paramAnonymousString)));
        WebViewLongClickHelper.bq(System.currentTimeMillis());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this).put(paramAnonymousString, Long.valueOf(WebViewLongClickHelper.BrM));
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new WebViewLongClickHelper.ScanImageData(paramAnonymousString, WebViewLongClickHelper.BrM, WebViewLongClickHelper.this.gXq().syc, WebViewLongClickHelper.this.gXq().syd, WebViewLongClickHelper.this.gXq().pHS.getMeasuredWidth(), WebViewLongClickHelper.this.gXq().pHS.getMeasuredHeight()), WebViewLongClickHelper.c.class, new WebViewLongClickHelper.b(new WeakReference(WebViewLongClickHelper.this), paramAnonymousString));
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(79838);
      }
    };
    emd();
    this.oxq = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
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
  
  public static void TE(long paramLong)
  {
    mSessionId = paramLong;
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.BrI)) && (gXq().pGD.gWJ().hoT()) && (emg()))
    {
      this.pGL = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(gXq().pHS, this.pGQ);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aGF(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (elX())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!eme())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.BrJ = paramString;
    if (this.oxl == null) {
      this.oxl = new com.tencent.mm.ui.widget.a.e(gXq(), 1, false);
    }
    this.oxl.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(79843);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymouso);
        AppMethodBeat.o(79843);
      }
    };
    this.oxl.ODU = new q.g()
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
    this.oxl.XbB = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, 5, null);
        if ((WebViewLongClickHelper.this.pGJ != null) && (WebViewLongClickHelper.this.gXq().pGC != null)) {
          try
          {
            WebViewLongClickHelper.c(WebViewLongClickHelper.this).clear();
            WebViewLongClickHelper.m(WebViewLongClickHelper.this).onDismiss();
            WebViewLongClickHelper.f(WebViewLongClickHelper.this, WebViewLongClickHelper.this.pGJ.PXC);
            WebViewLongClickHelper.this.pGJ.gWy();
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
    if ((!gXq().isFinishing()) && (gXO())) {
      this.oxl.eik();
    }
    boolean bool = this.oxl.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private static boolean apb(String paramString)
  {
    AppMethodBeat.i(266512);
    if ((paramString == null) || (h.ae(c.class) == null))
    {
      AppMethodBeat.o(266512);
      return false;
    }
    boolean bool = ((c)h.ae(c.class)).apb(paramString);
    AppMethodBeat.o(266512);
    return bool;
  }
  
  static String apf(String paramString)
  {
    AppMethodBeat.i(175768);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!apb(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((c)h.ae(c.class)).apf(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.BrI)) && (gXq().pGD.gWJ().hoT()) && (emg()))
    {
      this.pGK = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(gXq().pHS, this.pGQ);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  public static void d(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(266513);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzy, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(266513);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzz, 500);
    if ((i < 150) || (i > 2500))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(266513);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(266513);
  }
  
  private boolean eX(View paramView)
  {
    AppMethodBeat.i(79850);
    if (elX())
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
        paramView = gXq().pHS.getHitTestResult();
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
  
  private boolean eme()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = gXq().pGC.isSDCardAvailable();
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
  
  private boolean emf()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = gXq().pGC.gWY();
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
  
  private boolean emg()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = gXq().bjD(Util.nullAsNil(gXq().QfT));
    if ((i == 53) || (i == 52))
    {
      Log.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (gXq().pGC == null)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = gXq().pGC.gXj();
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
  
  public static long gXK()
  {
    return mSessionId;
  }
  
  private boolean gXM()
  {
    AppMethodBeat.i(175765);
    boolean bool = BrL.containsKey(apf(this.pHO));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean gXN()
  {
    AppMethodBeat.i(175766);
    if (!gXM())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)BrL.get(apf(this.pHO))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean gXO()
  {
    AppMethodBeat.i(175767);
    if ((!gXN()) || (!Util.isNullOrNil(this.BrI)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  public final void emd()
  {
    AppMethodBeat.i(266507);
    if (gXq().pHS == null)
    {
      AppMethodBeat.o(266507);
      return;
    }
    gXq().pHS.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(79842);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, new m());
        WebViewLongClickHelper.i(WebViewLongClickHelper.this).fs(1);
        Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
        WebViewLongClickHelper.j(WebViewLongClickHelper.this);
        if (WebViewLongClickHelper.this.gXq().pHS == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(79842);
          return false;
        }
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, WebViewLongClickHelper.this.gXq().elY());
        if ((!WebViewLongClickHelper.k(WebViewLongClickHelper.this)) && (WebViewLongClickHelper.bmf(WebViewLongClickHelper.l(WebViewLongClickHelper.this)))) {
          WebViewLongClickHelper.this.gXq().pHS.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new WebViewLongClickHelper.8.1(this, paramAnonymousView));
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
    AppMethodBeat.o(266507);
  }
  
  final void gUZ()
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
  
  final void gXL()
  {
    AppMethodBeat.i(266505);
    if (Util.isNullOrNil(this.BrI))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mImageQBarDataList nil");
      AppMethodBeat.o(266505);
      return;
    }
    if (this.BrI.size() != 1)
    {
      AppMethodBeat.o(266505);
      return;
    }
    ImageQBarDataBean localImageQBarDataBean = (ImageQBarDataBean)this.BrI.get(0);
    if (!k.ci(localImageQBarDataBean.fys, localImageQBarDataBean.IAH))
    {
      AppMethodBeat.o(266505);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
    this.oxq.cl(localImageQBarDataBean.fys, localImageQBarDataBean.IAH);
    AppMethodBeat.o(266505);
  }
  
  static class CancelRecogQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<CancelRecogQBarData> CREATOR;
    String filePath;
    long fwK;
    
    static
    {
      AppMethodBeat.i(267533);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(267533);
    }
    
    protected CancelRecogQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(267530);
      this.filePath = paramParcel.readString();
      this.fwK = paramParcel.readLong();
      AppMethodBeat.o(267530);
    }
    
    public CancelRecogQBarData(String paramString, long paramLong)
    {
      this.filePath = paramString;
      this.fwK = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(267532);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.fwK);
      AppMethodBeat.o(267532);
    }
  }
  
  static class ImageQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageQBarData> CREATOR;
    String BrW;
    boolean BrX;
    ArrayList<ImageQBarDataBean> mDataList;
    
    static
    {
      AppMethodBeat.i(224564);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(224564);
    }
    
    protected ImageQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(224555);
      this.mDataList = paramParcel.createTypedArrayList(ImageQBarDataBean.CREATOR);
      this.BrW = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.BrX = bool;
        AppMethodBeat.o(224555);
        return;
      }
    }
    
    public ImageQBarData(ArrayList<ImageQBarDataBean> paramArrayList, String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(224552);
      this.mDataList = paramArrayList;
      this.BrW = paramString;
      this.BrX = paramBoolean.booleanValue();
      AppMethodBeat.o(224552);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(224559);
      paramParcel.writeTypedList(this.mDataList);
      paramParcel.writeString(this.BrW);
      if (this.BrX) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(224559);
        return;
      }
    }
  }
  
  static class ScanImageData
    implements Parcelable
  {
    public static final Parcelable.Creator<ScanImageData> CREATOR;
    String filePath;
    long fwK;
    int height;
    float qUk;
    float qUl;
    int width;
    
    static
    {
      AppMethodBeat.i(218837);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(218837);
    }
    
    protected ScanImageData(Parcel paramParcel)
    {
      AppMethodBeat.i(218833);
      this.filePath = paramParcel.readString();
      this.fwK = paramParcel.readLong();
      this.qUk = paramParcel.readFloat();
      this.qUl = paramParcel.readFloat();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      AppMethodBeat.o(218833);
    }
    
    public ScanImageData(String paramString, long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.filePath = paramString;
      this.fwK = paramLong;
      this.qUk = paramFloat1;
      this.qUl = paramFloat2;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(218835);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.fwK);
      paramParcel.writeFloat(this.qUk);
      paramParcel.writeFloat(this.qUl);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      AppMethodBeat.o(218835);
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
    implements f<WebViewLongClickHelper.ImageQBarData>
  {
    private WeakReference<WebViewLongClickHelper> BrY;
    private String mPath;
    
    public b(WeakReference<WebViewLongClickHelper> paramWeakReference, String paramString)
    {
      this.BrY = paramWeakReference;
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