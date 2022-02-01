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
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebView.b;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends a
{
  static Map<String, Boolean> Bfd;
  private int AUu;
  private com.tencent.mm.ui.widget.a.e jzq;
  private String kxi;
  com.tencent.mm.plugin.webview.modeltools.h kxm;
  private WebView.b kxn;
  private WebView.b kxo;
  ScanCodeSheetItemLogic kxs;
  private h.c kxu;
  String lst;
  private int wAA;
  private com.tencent.mm.plugin.webview.j.g yEq;
  private String yEr;
  
  static
  {
    AppMethodBeat.i(175784);
    Bfd = new HashMap();
    AppMethodBeat.o(175784);
  }
  
  public h(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79848);
    this.lst = "";
    this.kxu = new h.c()
    {
      public final void JL(String paramAnonymousString)
      {
        AppMethodBeat.i(79838);
        if (h.this.elq())
        {
          AppMethodBeat.o(79838);
          return;
        }
        try
        {
          if (h.this.enA().kxf != null)
          {
            h.this.enA().kxf.a(paramAnonymousString, null, h.this.enA().mUE, h.this.enA().mUF);
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
    if (enA().nhy != null) {
      enA().nhy.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(79842);
          h.a(h.this, new com.tencent.mm.plugin.webview.j.g());
          h.e(h.this).reset(1);
          ad.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
          h.f(h.this);
          if (h.this.enA().nhy == null)
          {
            AppMethodBeat.o(79842);
            return false;
          }
          h.a(h.this, h.this.enA().ejo());
          if ((!h.g(h.this)) && (h.axR(h.h(h.this)))) {
            h.this.enA().nhy.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback() {});
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
    this.kxs = new ScanCodeSheetItemLogic(paramWebViewUI, new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
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
  
  static String Pa(String paramString)
  {
    AppMethodBeat.i(175768);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175768);
      return "";
    }
    if (!isMpUrl(paramString))
    {
      AppMethodBeat.o(175768);
      return paramString;
    }
    paramString = ((b)com.tencent.mm.kernel.g.ab(b.class)).Pa(paramString);
    AppMethodBeat.o(175768);
    return paramString;
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(79851);
    boolean bool = awl(paramb.mExtra);
    if ((bt.isNullOrNil(this.kxi)) && (enA().kxg.emS().eBN()) && (els()))
    {
      this.kxo = paramb;
      this.kxm = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kxm.a(enA().nhy, this.kxu);
    }
    AppMethodBeat.o(79851);
    return bool;
  }
  
  private boolean awl(final String paramString)
  {
    AppMethodBeat.i(79853);
    if (elq())
    {
      AppMethodBeat.o(79853);
      return false;
    }
    if (!enO())
    {
      AppMethodBeat.o(79853);
      return true;
    }
    this.yEr = paramString;
    if (this.jzq == null) {
      this.jzq = new com.tencent.mm.ui.widget.a.e(enA(), 1, false);
    }
    this.jzq.HrX = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(79843);
        h.a(h.this, paramAnonymousl);
        AppMethodBeat.o(79843);
      }
    };
    this.jzq.HrY = new n.d()
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
    this.jzq.GHn = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(79845);
        h.a(h.this, 5);
        if ((h.this.kxm != null) && (h.this.enA().kxf != null)) {
          try
          {
            h.i(h.this);
            h.j(h.this);
            h.k(h.this).vLD = null;
            h.this.enA().kxf.axG(h.this.kxm.Bap);
            h.this.kxm.emK();
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
    if ((!enA().isFinishing()) && (enS())) {
      this.jzq.csG();
    }
    boolean bool = this.jzq.isShowing();
    AppMethodBeat.o(79853);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(79852);
    boolean bool = awl(paramb.mExtra);
    if ((bt.isNullOrNil(this.kxi)) && (enA().kxg.emS().eBN()) && (els()))
    {
      this.kxn = paramb;
      this.kxm = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kxm.a(enA().nhy, this.kxu);
    }
    AppMethodBeat.o(79852);
    return bool;
  }
  
  private void elr()
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
  
  private boolean els()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79856);
    int i = enA().avB(bt.nullAsNil(enA().BhD));
    if ((i == 53) || (i == 52))
    {
      ad.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
      AppMethodBeat.o(79856);
      return false;
    }
    try
    {
      if (enA().kxf == null)
      {
        ad.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(79856);
        return false;
      }
      boolean bool2 = enA().kxf.enu();
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
  
  private boolean enO()
  {
    AppMethodBeat.i(79854);
    boolean bool1 = false;
    try
    {
      boolean bool2 = enA().kxf.isSDCardAvailable();
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
  
  private boolean enP()
  {
    boolean bool1 = false;
    AppMethodBeat.i(79855);
    try
    {
      boolean bool2 = enA().kxf.enj();
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
  
  private boolean enQ()
  {
    AppMethodBeat.i(175765);
    boolean bool = Bfd.containsKey(Pa(this.lst));
    AppMethodBeat.o(175765);
    return bool;
  }
  
  private boolean enR()
  {
    AppMethodBeat.i(175766);
    if (!enQ())
    {
      AppMethodBeat.o(175766);
      return false;
    }
    boolean bool = ((Boolean)Bfd.get(Pa(this.lst))).booleanValue();
    AppMethodBeat.o(175766);
    return bool;
  }
  
  private boolean enS()
  {
    AppMethodBeat.i(175767);
    if ((!enR()) || (!bt.isNullOrNil(this.kxi)))
    {
      AppMethodBeat.o(175767);
      return true;
    }
    AppMethodBeat.o(175767);
    return false;
  }
  
  private boolean fj(View paramView)
  {
    AppMethodBeat.i(79850);
    if (elq())
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
        paramView = enA().nhy.getHitTestResult();
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
  
  private static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(175769);
    if (paramString == null)
    {
      AppMethodBeat.o(175769);
      return false;
    }
    boolean bool = ((b)com.tencent.mm.kernel.g.ab(b.class)).isMpUrl(paramString);
    AppMethodBeat.o(175769);
    return bool;
  }
  
  public final void az(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187943);
    ad.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    this.kxi = paramString;
    this.AUu = paramInt1;
    this.wAA = paramInt2;
    elr();
    if (bt.isNullOrNil(this.kxi))
    {
      ad.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(187943);
      return;
    }
    if (com.tencent.mm.plugin.scanner.e.bK(this.AUu, this.kxi))
    {
      ad.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      paramString = new Bundle();
      try
      {
        paramString.putString("wxa_result", this.kxi);
        paramString.putInt("wxa_code_type", this.AUu);
        paramString.putInt("wxa_code_version", this.wAA);
        enA().kxf.a(110000, paramString, enA().AMZ.eiZ());
        AppMethodBeat.o(187943);
        return;
      }
      catch (RemoteException paramString)
      {
        ad.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(187943);
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