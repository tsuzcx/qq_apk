package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.z.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;

public final class i
  extends a
{
  static Map<String, Boolean> Jgg;
  private int DDM;
  private com.tencent.mm.plugin.webview.k.i FLs;
  private String FLt;
  private int IUQ;
  private com.tencent.mm.ui.widget.a.e lBM;
  private String mHk;
  h mHo;
  private WebView.b mHp;
  private WebView.b mHq;
  ScanCodeSheetItemLogic mHu;
  private h.c mHw;
  String nKc;
  
  static
  {
    AppMethodBeat.i(175784);
    Jgg = new HashMap();
    AppMethodBeat.o(175784);
  }
  
  public i(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.nKc = "";
    this.mHw = new h.c()
    {
      public final void abF(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (i.this.gcd())
        {
          AppMethodBeat.o(79838);
          return;
        }
        try
        {
          if (i.this.geo().mHh != null)
          {
            i.this.geo().mHh.a(paramAnonymousString, null, i.this.geo().ppd, i.this.geo().ppe);
            AppMethodBeat.o(79838);
            return;
          }
        }
        catch (RemoteException paramAnonymousString)
        {
          Log.e("MicroMsg.WebViewLongClickHelper", "recog failed");
          AppMethodBeat.o(79838);
          return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
        AppMethodBeat.o(79838);
      }
    };
    if (geo().pGj != null) {
      geo().pGj.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(79842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          i.a(i.this, new com.tencent.mm.plugin.webview.k.i());
          i.e(i.this).reset(1);
          Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
          i.f(i.this);
          if (i.this.geo().pGj == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(79842);
            return false;
          }
          i.a(i.this, i.this.geo().fZM());
          if ((!i.g(i.this)) && (i.bak(i.h(i.this)))) {
            i.this.geo().pGj.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(79842);
            return false;
            i.a(i.this, paramAnonymousView);
          }
        }
      });
    }
    this.mHu = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(79840);
        if ((i.a(i.this) != null) && (i.a(i.this).isShowing())) {
          i.b(i.this);
        }
        AppMethodBeat.o(79840);
      }
    });
    AppMethodBeat.o(79848);
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aYx(paramb.mExtra);
    if ((Util.isNullOrNil(this.mHk)) && (geo().mHi.gdI().gtD()) && (gcf()))
    {
      this.mHq = paramb;
      this.mHo = new h();
      this.mHo.a(geo().pGj, this.mHw);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aYx(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (gcd())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!geE())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.FLt = paramString;
    if (this.lBM == null) {
      this.lBM = new com.tencent.mm.ui.widget.a.e(geo(), 1, false);
    }
    this.lBM.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(79843);
        i.a(i.this, paramAnonymousm);
        AppMethodBeat.o(79843);
      }
    };
    this.lBM.HLY = new o.g()
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
          i.a(i.this, 1);
          i.b(i.this, paramString);
          AppMethodBeat.o(79844);
          return;
          i.a(i.this, 2);
          i.c(i.this, paramString);
          AppMethodBeat.o(79844);
          return;
          i.a(i.this, 3);
          i.d(i.this, paramString);
        }
      }
    };
    this.lBM.PGl = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        i.a(i.this, 5);
        if ((i.this.mHo != null) && (i.this.geo().mHh != null)) {
          try
          {
            i.i(i.this);
            i.j(i.this);
            i.k(i.this).onDismiss();
            i.this.geo().mHh.aZZ(i.this.mHo.Jbk);
            i.this.mHo.gdA();
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
    if ((!geo().isFinishing()) && (geI())) {
      this.lBM.dGm();
    }
    boolean bool = this.lBM.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private static boolean ahv(String paramString)
  {
    AppMethodBeat.i(211048);
    if ((paramString == null) || (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) == null))
    {
      AppMethodBeat.o(211048);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(paramString);
    AppMethodBeat.o(211048);
    return bool;
  }
  
  static String ahz(String paramString)
  {
    AppMethodBeat.i(175768);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!ahv(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aYx(paramb.mExtra);
    if ((Util.isNullOrNil(this.mHk)) && (geo().mHi.gdI().gtD()) && (gcf()))
    {
      this.mHp = paramb;
      this.mHo = new h();
      this.mHo.a(geo().pGj, this.mHw);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  public static void f(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(211049);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTb, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(211049);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTc, 500);
    if ((i < 150) || (i > 2500))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(211049);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(211049);
  }
  
  private void gce()
  {
    AppMethodBeat.i(79849);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79841);
        if (i.c(i.this) != null)
        {
          i.a(i.this, i.c(i.this));
          AppMethodBeat.o(79841);
          return;
        }
        if (i.d(i.this) != null) {
          i.b(i.this, i.d(i.this));
        }
        AppMethodBeat.o(79841);
      }
    });
    AppMethodBeat.o(79849);
  }
  
  private boolean gcf()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = geo().aXI(Util.nullAsNil(geo().JiT));
    if ((i == 53) || (i == 52))
    {
      Log.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (geo().mHh == null)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = geo().mHh.geh();
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
  
  private boolean gd(View paramView)
  {
    AppMethodBeat.i(79850);
    if (gcd())
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
        paramView = geo().pGj.getHitTestResult();
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
  
  private boolean geE()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = geo().mHh.isSDCardAvailable();
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
  
  private boolean geF()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = geo().mHh.gdW();
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
  
  private boolean geG()
  {
    AppMethodBeat.i(175765);
    boolean bool = Jgg.containsKey(ahz(this.nKc));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean geH()
  {
    AppMethodBeat.i(175766);
    if (!geG())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)Jgg.get(ahz(this.nKc))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean geI()
  {
    AppMethodBeat.i(175767);
    if ((!geH()) || (!Util.isNullOrNil(this.mHk)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  public final void aF(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211047);
    Log.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    this.mHk = paramString;
    this.IUQ = paramInt1;
    this.DDM = paramInt2;
    gce();
    if (Util.isNullOrNil(this.mHk))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(211047);
      return;
    }
    if (com.tencent.mm.plugin.scanner.g.ci(this.IUQ, this.mHk))
    {
      Log.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      paramString = new Bundle();
      try
      {
        paramString.putString("wxa_result", this.mHk);
        paramString.putInt("wxa_code_type", this.IUQ);
        paramString.putInt("wxa_code_version", this.DDM);
        geo().mHh.a(110000, paramString, geo().IMH.fZu());
        AppMethodBeat.o(211047);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(211047);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */