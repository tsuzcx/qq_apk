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
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends a
{
  static Map<String, Boolean> Cxp;
  private int CmH;
  private com.tencent.mm.ui.widget.a.e jZN;
  com.tencent.mm.plugin.webview.modeltools.h kYA;
  private WebView.b kYB;
  private WebView.b kYC;
  ScanCodeSheetItemLogic kYG;
  private h.c kYI;
  private String kYw;
  String lUn;
  private int xMT;
  private com.tencent.mm.plugin.webview.j.g zRE;
  private String zRF;
  
  static
  {
    AppMethodBeat.i(175784);
    Cxp = new HashMap();
    AppMethodBeat.o(175784);
  }
  
  public h(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.lUn = "";
    this.kYI = new h.c()
    {
      public final void NS(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (h.this.eAM())
        {
          AppMethodBeat.o(79838);
          return;
        }
        try
        {
          if (h.this.eCT().kYt != null)
          {
            h.this.eCT().kYt.a(paramAnonymousString, null, h.this.eCT().nwY, h.this.eCT().nwZ);
            AppMethodBeat.o(79838);
            return;
          }
        }
        catch (RemoteException paramAnonymousString)
        {
          ac.e("MicroMsg.WebViewLongClickHelper", "recog failed");
          AppMethodBeat.o(79838);
          return;
        }
        ac.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
        AppMethodBeat.o(79838);
      }
    };
    if (eCT().nKq != null) {
      eCT().nKq.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(79842);
          h.a(h.this, new com.tencent.mm.plugin.webview.j.g());
          h.e(h.this).reset(1);
          ac.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
          h.f(h.this);
          if (h.this.eCT().nKq == null)
          {
            AppMethodBeat.o(79842);
            return false;
          }
          h.a(h.this, h.this.eCT().eyJ());
          if ((!h.g(h.this)) && (h.aDj(h.h(h.this)))) {
            h.this.eCT().nKq.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
          }
          for (;;)
          {
            AppMethodBeat.o(79842);
            return false;
            h.a(h.this, paramAnonymousView);
          }
        }
      });
    }
    this.kYG = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
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
  
  private static boolean Tg(String paramString)
  {
    AppMethodBeat.i(188372);
    if (paramString == null)
    {
      AppMethodBeat.o(188372);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg(paramString);
    AppMethodBeat.o(188372);
    return bool;
  }
  
  static String Tk(String paramString)
  {
    AppMethodBeat.i(175768);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!Tg(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tk(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aBD(paramb.mExtra);
    if ((bs.isNullOrNil(this.kYw)) && (eCT().kYu.eCn().eRi()) && (eAO()))
    {
      this.kYC = paramb;
      this.kYA = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kYA.a(eCT().nKq, this.kYI);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aBD(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (eAM())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!eDh())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.zRF = paramString;
    if (this.jZN == null) {
      this.jZN = new com.tencent.mm.ui.widget.a.e(eCT(), 1, false);
    }
    this.jZN.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79843);
        h.a(h.this, paramAnonymousl);
        AppMethodBeat.o(79843);
      }
    };
    this.jZN.ISv = new n.d()
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
    this.jZN.Ihj = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        h.a(h.this, 5);
        if ((h.this.kYA != null) && (h.this.eCT().kYt != null)) {
          try
          {
            h.i(h.this);
            h.j(h.this);
            h.k(h.this).wVE = null;
            h.this.eCT().kYt.aCY(h.this.kYA.CsC);
            h.this.kYA.eCf();
            AppMethodBeat.o(79845);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(79845);
      }
    };
    if ((!eCT().isFinishing()) && (eDl())) {
      this.jZN.cED();
    }
    boolean bool = this.jZN.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aBD(paramb.mExtra);
    if ((bs.isNullOrNil(this.kYw)) && (eCT().kYu.eCn().eRi()) && (eAO()))
    {
      this.kYB = paramb;
      this.kYA = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kYA.a(eCT().nKq, this.kYI);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  public static void e(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(188373);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPW, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(188373);
      return;
    }
    ac.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPX, 500);
    if ((i < 150) || (i > 2500))
    {
      ac.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(188373);
      return;
    }
    ac.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(188373);
  }
  
  private void eAN()
  {
    AppMethodBeat.i(79849);
    ap.f(new Runnable()
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
  
  private boolean eAO()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = eCT().aAT(bs.nullAsNil(eCT().CzQ));
    if ((i == 53) || (i == 52))
    {
      ac.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (eCT().kYt == null)
      {
        ac.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = eCT().kYt.eCN();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(79856);
    return bool1;
  }
  
  private boolean eDh()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = eCT().kYt.isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(79854);
    return bool1;
  }
  
  private boolean eDi()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = eCT().kYt.eCC();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(79855);
    return bool1;
  }
  
  private boolean eDj()
  {
    AppMethodBeat.i(175765);
    boolean bool = Cxp.containsKey(Tk(this.lUn));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean eDk()
  {
    AppMethodBeat.i(175766);
    if (!eDj())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)Cxp.get(Tk(this.lUn))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean eDl()
  {
    AppMethodBeat.i(175767);
    if ((!eDk()) || (!bs.isNullOrNil(this.kYw)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  private boolean fw(View paramView)
  {
    AppMethodBeat.i(79850);
    if (eAM())
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
        paramView = eCT().nKq.getHitTestResult();
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
        ac.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
  
  public final void ay(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188371);
    ac.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    this.kYw = paramString;
    this.CmH = paramInt1;
    this.xMT = paramInt2;
    eAN();
    if (bs.isNullOrNil(this.kYw))
    {
      ac.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(188371);
      return;
    }
    if (f.bN(this.CmH, this.kYw))
    {
      ac.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      paramString = new Bundle();
      try
      {
        paramString.putString("wxa_result", this.kYw);
        paramString.putInt("wxa_code_type", this.CmH);
        paramString.putInt("wxa_code_version", this.xMT);
        eCT().kYt.a(110000, paramString, eCT().Cfr.eyt());
        AppMethodBeat.o(188371);
        return;
      }
      catch (RemoteException paramString)
      {
        ac.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(188371);
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