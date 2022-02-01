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
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends a
{
  static Map<String, Boolean> EaX;
  private com.tencent.mm.plugin.webview.j.h Bji;
  private String Bjj;
  private int DQc;
  private com.tencent.mm.ui.widget.a.e kuj;
  com.tencent.mm.plugin.webview.modeltools.h lvC;
  private WebView.b lvD;
  private WebView.b lvE;
  ScanCodeSheetItemLogic lvI;
  private h.c lvK;
  private String lvy;
  String mue;
  private int zcL;
  
  static
  {
    AppMethodBeat.i(175784);
    EaX = new HashMap();
    AppMethodBeat.o(175784);
  }
  
  public h(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.mue = "";
    this.lvK = new h.c()
    {
      public final void Rr(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (h.this.ePE())
        {
          AppMethodBeat.o(79838);
          return;
        }
        try
        {
          if (h.this.eRK().lvv != null)
          {
            h.this.eRK().lvv.a(paramAnonymousString, null, h.this.eRK().nYw, h.this.eRK().nYx);
            AppMethodBeat.o(79838);
            return;
          }
        }
        catch (RemoteException paramAnonymousString)
        {
          ad.e("MicroMsg.WebViewLongClickHelper", "recog failed");
          AppMethodBeat.o(79838);
          return;
        }
        ad.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
        AppMethodBeat.o(79838);
      }
    };
    if (eRK().omW != null) {
      eRK().omW.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(79842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          h.a(h.this, new com.tencent.mm.plugin.webview.j.h());
          h.e(h.this).reset(1);
          ad.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
          h.f(h.this);
          if (h.this.eRK().omW == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(79842);
            return false;
          }
          h.a(h.this, h.this.eRK().eNy());
          if ((!h.g(h.this)) && (h.aIK(h.h(h.this)))) {
            h.this.eRK().omW.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(79842);
            return false;
            h.a(h.this, paramAnonymousView);
          }
        }
      });
    }
    this.lvI = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(79840);
        if ((h.a(h.this) != null) && (h.a(h.this).isShowing())) {
          h.b(h.this);
        }
        AppMethodBeat.o(79840);
      }
    });
    AppMethodBeat.o(79848);
  }
  
  private static boolean WM(String paramString)
  {
    AppMethodBeat.i(208004);
    if ((paramString == null) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) == null))
    {
      AppMethodBeat.o(208004);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM(paramString);
    AppMethodBeat.o(208004);
    return bool;
  }
  
  static String WQ(String paramString)
  {
    AppMethodBeat.i(175768);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!WM(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WQ(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aHb(paramb.mExtra);
    if ((bt.isNullOrNil(this.lvy)) && (eRK().lvw.eRh().fgm()) && (ePG()))
    {
      this.lvE = paramb;
      this.lvC = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lvC.a(eRK().omW, this.lvK);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aHb(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (ePE())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!eRZ())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.Bjj = paramString;
    if (this.kuj == null) {
      this.kuj = new com.tencent.mm.ui.widget.a.e(eRK(), 1, false);
    }
    this.kuj.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79843);
        h.a(h.this, paramAnonymousl);
        AppMethodBeat.o(79843);
      }
    };
    this.kuj.KJz = new n.e()
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
          h.a(h.this, 1);
          h.b(h.this, paramString);
          AppMethodBeat.o(79844);
          return;
          h.a(h.this, 2);
          h.c(h.this, paramString);
          AppMethodBeat.o(79844);
          return;
          h.a(h.this, 3);
          h.d(h.this, paramString);
        }
      }
    };
    this.kuj.JXC = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        h.a(h.this, 5);
        if ((h.this.lvC != null) && (h.this.eRK().lvv != null)) {
          try
          {
            h.i(h.this);
            h.j(h.this);
            h.k(h.this).onDismiss();
            h.this.eRK().lvv.aIz(h.this.lvC.DWh);
            h.this.lvC.eQZ();
            AppMethodBeat.o(79845);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(79845);
      }
    };
    if ((!eRK().isFinishing()) && (eSd())) {
      this.kuj.cMW();
    }
    boolean bool = this.kuj.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aHb(paramb.mExtra);
    if ((bt.isNullOrNil(this.lvy)) && (eRK().lvw.eRh().fgm()) && (ePG()))
    {
      this.lvD = paramb;
      this.lvC = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lvC.a(eRK().omW, this.lvK);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  private void ePF()
  {
    AppMethodBeat.i(79849);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79841);
        if (h.c(h.this) != null)
        {
          h.a(h.this, h.c(h.this));
          AppMethodBeat.o(79841);
          return;
        }
        if (h.d(h.this) != null) {
          h.b(h.this, h.d(h.this));
        }
        AppMethodBeat.o(79841);
      }
    });
    AppMethodBeat.o(79849);
  }
  
  private boolean ePG()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = eRK().aGo(bt.nullAsNil(eRK().Edy));
    if ((i == 53) || (i == 52))
    {
      ad.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (eRK().lvv == null)
      {
        ad.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = eRK().lvv.eRE();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(79856);
    return bool1;
  }
  
  private boolean eRZ()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = eRK().lvv.isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(79854);
    return bool1;
  }
  
  private boolean eSa()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = eRK().lvv.eRt();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(79855);
    return bool1;
  }
  
  private boolean eSb()
  {
    AppMethodBeat.i(175765);
    boolean bool = EaX.containsKey(WQ(this.mue));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean eSc()
  {
    AppMethodBeat.i(175766);
    if (!eSb())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)EaX.get(WQ(this.mue))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean eSd()
  {
    AppMethodBeat.i(175767);
    if ((!eSc()) || (!bt.isNullOrNil(this.lvy)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  public static void f(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(208005);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtZ, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(208005);
      return;
    }
    ad.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qub, 500);
    if ((i < 150) || (i > 2500))
    {
      ad.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(208005);
      return;
    }
    ad.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(208005);
  }
  
  private boolean fL(View paramView)
  {
    AppMethodBeat.i(79850);
    if (ePE())
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
        paramView = eRK().omW.getHitTestResult();
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
        ad.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
  
  public final void aC(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208003);
    ad.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    this.lvy = paramString;
    this.DQc = paramInt1;
    this.zcL = paramInt2;
    ePF();
    if (bt.isNullOrNil(this.lvy))
    {
      ad.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(208003);
      return;
    }
    if (f.bT(this.DQc, this.lvy))
    {
      ad.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      paramString = new Bundle();
      try
      {
        paramString.putString("wxa_result", this.lvy);
        paramString.putInt("wxa_code_type", this.DQc);
        paramString.putInt("wxa_code_version", this.zcL);
        eRK().lvv.a(110000, paramString, eRK().DIv.eNj());
        AppMethodBeat.o(208003);
        return;
      }
      catch (RemoteException paramString)
      {
        ad.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(208003);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */