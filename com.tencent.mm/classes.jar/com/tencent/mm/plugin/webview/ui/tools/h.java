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
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  static Map<String, Boolean> EsY;
  private com.tencent.mm.plugin.webview.j.h BAH;
  private String BAI;
  private int Eic;
  private com.tencent.mm.ui.widget.a.e kxz;
  com.tencent.mm.plugin.webview.modeltools.h lAa;
  private WebView.b lAb;
  private WebView.b lAc;
  ScanCodeSheetItemLogic lAg;
  private h.c lAi;
  private String lzW;
  String mzb;
  private int ztB;
  
  static
  {
    AppMethodBeat.i(175784);
    EsY = new HashMap();
    AppMethodBeat.o(175784);
  }
  
  public h(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.mzb = "";
    this.lAi = new h.c()
    {
      public final void Sa(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (h.this.eTq())
        {
          AppMethodBeat.o(79838);
          return;
        }
        try
        {
          if (h.this.eVw().lzT != null)
          {
            h.this.eVw().lzT.a(paramAnonymousString, null, h.this.eVw().oef, h.this.eVw().oeg);
            AppMethodBeat.o(79838);
            return;
          }
        }
        catch (RemoteException paramAnonymousString)
        {
          ae.e("MicroMsg.WebViewLongClickHelper", "recog failed");
          AppMethodBeat.o(79838);
          return;
        }
        ae.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
        AppMethodBeat.o(79838);
      }
    };
    if (eVw().osM != null) {
      eVw().osM.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(79842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          h.a(h.this, new com.tencent.mm.plugin.webview.j.h());
          h.e(h.this).reset(1);
          ae.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
          h.f(h.this);
          if (h.this.eVw().osM == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(79842);
            return false;
          }
          h.a(h.this, h.this.eVw().eRj());
          if ((!h.g(h.this)) && (h.aKd(h.h(h.this)))) {
            h.this.eVw().osM.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
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
    this.lAg = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
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
  
  static String XC(String paramString)
  {
    AppMethodBeat.i(175768);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!Xy(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XC(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private static boolean Xy(String paramString)
  {
    AppMethodBeat.i(198181);
    if ((paramString == null) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) == null))
    {
      AppMethodBeat.o(198181);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy(paramString);
    AppMethodBeat.o(198181);
    return bool;
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = aIv(paramb.mExtra);
    if ((bu.isNullOrNil(this.lzW)) && (eVw().lzU.eUT().fkc()) && (eTs()))
    {
      this.lAc = paramb;
      this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lAa.a(eVw().osM, this.lAi);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean aIv(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (eTq())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!eVL())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.BAI = paramString;
    if (this.kxz == null) {
      this.kxz = new com.tencent.mm.ui.widget.a.e(eVw(), 1, false);
    }
    this.kxz.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79843);
        h.a(h.this, paramAnonymousl);
        AppMethodBeat.o(79843);
      }
    };
    this.kxz.LfT = new n.e()
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
    this.kxz.KtV = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        h.a(h.this, 5);
        if ((h.this.lAa != null) && (h.this.eVw().lzT != null)) {
          try
          {
            h.i(h.this);
            h.j(h.this);
            h.k(h.this).onDismiss();
            h.this.eVw().lzT.aJS(h.this.lAa.Eog);
            h.this.lAa.eUL();
            AppMethodBeat.o(79845);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(79845);
      }
    };
    if ((!eVw().isFinishing()) && (eVP())) {
      this.kxz.cPF();
    }
    boolean bool = this.kxz.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = aIv(paramb.mExtra);
    if ((bu.isNullOrNil(this.lzW)) && (eVw().lzU.eUT().fkc()) && (eTs()))
    {
      this.lAb = paramb;
      this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lAa.a(eVw().osM, this.lAi);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  private void eTr()
  {
    AppMethodBeat.i(79849);
    ar.f(new Runnable()
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
  
  private boolean eTs()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = eVw().aHI(bu.nullAsNil(eVw().EvA));
    if ((i == 53) || (i == 52))
    {
      ae.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (eVw().lzT == null)
      {
        ae.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = eVw().lzT.eVq();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(79856);
    return bool1;
  }
  
  private boolean eVL()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = eVw().lzT.isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(79854);
    return bool1;
  }
  
  private boolean eVM()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = eVw().lzT.eVf();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(79855);
    return bool1;
  }
  
  private boolean eVN()
  {
    AppMethodBeat.i(175765);
    boolean bool = EsY.containsKey(XC(this.mzb));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean eVO()
  {
    AppMethodBeat.i(175766);
    if (!eVN())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)EsY.get(XC(this.mzb))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean eVP()
  {
    AppMethodBeat.i(175767);
    if ((!eVO()) || (!bu.isNullOrNil(this.lzW)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  public static void f(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(198182);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAN, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(198182);
      return;
    }
    ae.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAO, 500);
    if ((i < 150) || (i > 2500))
    {
      ae.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(198182);
      return;
    }
    ae.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(198182);
  }
  
  private boolean fK(View paramView)
  {
    AppMethodBeat.i(79850);
    if (eTq())
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
        paramView = eVw().osM.getHitTestResult();
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
        ae.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
  
  public final void aD(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198180);
    ae.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    this.lzW = paramString;
    this.Eic = paramInt1;
    this.ztB = paramInt2;
    eTr();
    if (bu.isNullOrNil(this.lzW))
    {
      ae.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(198180);
      return;
    }
    if (com.tencent.mm.plugin.scanner.g.bT(this.Eic, this.lzW))
    {
      ae.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      paramString = new Bundle();
      try
      {
        paramString.putString("wxa_result", this.lzW);
        paramString.putInt("wxa_code_type", this.Eic);
        paramString.putInt("wxa_code_version", this.ztB);
        eVw().lzT.a(110000, paramString, eVw().Eat.eQU());
        AppMethodBeat.o(198180);
        return;
      }
      catch (RemoteException paramString)
      {
        ae.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(198180);
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