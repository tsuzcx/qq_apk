package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.WebView;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.luggage.c.b.a;
import com.tencent.mm.plugin.webview.luggage.c.b.c;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class r
{
  public f CkZ;
  int CmH;
  com.tencent.mm.ui.widget.a.e jZN;
  com.tencent.mm.plugin.webview.modeltools.h kYA;
  WebView.b kYB;
  WebView.b kYC;
  ScanCodeSheetItemLogic kYG;
  private h.c kYI;
  String kYw;
  a.b sXH;
  int xMT;
  
  public r(f paramf)
  {
    AppMethodBeat.i(78461);
    this.kYI = new h.c()
    {
      public final void NS(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        r localr = r.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", localr.CkZ.nwY);
        localBundle.putInt("y_down", localr.CkZ.nwZ);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, r.d.class, new r.6(localr));
        AppMethodBeat.o(78435);
      }
    };
    this.sXH = new a.b()
    {
      public final void beL()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78443);
      }
    };
    this.CkZ = paramf;
    this.CkZ.getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        ac.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        r localr = r.this;
        localr.kYw = null;
        localr.kYC = null;
        localr.kYB = null;
        localr.kYG.wVE = null;
        if (r.this.eAM())
        {
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = r.this.fw(paramAnonymousView);
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.kYG = new ScanCodeSheetItemLogic(paramf.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
      {
        AppMethodBeat.i(78444);
        if ((r.this.jZN != null) && (r.this.jZN.isShowing())) {
          r.this.eAN();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aBD(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.jZN == null) {
      this.jZN = new com.tencent.mm.ui.widget.a.e(this.CkZ.mContext, 1, false);
    }
    this.jZN.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(78448);
        r localr = r.this;
        boolean bool1;
        Object localObject1;
        int i;
        label269:
        Object localObject2;
        if (ai.ciE())
        {
          bool1 = com.tencent.mm.kernel.g.agM();
          boolean bool2 = localr.CkZ.eAs().aCD(localr.CkZ.getUrl()).eRm();
          boolean bool3 = localr.CkZ.eAs().aCD(localr.CkZ.getUrl()).eRn();
          ac.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new r.c(1, localr.CkZ.mContext.getString(2131762163)));
          }
          ((List)localObject1).add(new r.c(2, localr.CkZ.mContext.getString(2131762783)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new r.c(3, localr.CkZ.mContext.getString(2131761941)));
          }
          if (localr.kYw != null) {
            ((List)localObject1).add(new r.c(4, localr.kYG.ML(localr.CmH)));
          }
          localr.jZN.setFooterView(null);
          paramAnonymousl.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label407;
          }
          localObject2 = (r.c)((List)localObject1).get(i);
          if (((r.c)localObject2).id != 4) {
            break label389;
          }
          localObject2 = localr.jZN;
          r.3 local3 = new r.3(localr);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(localr.kYG.a(local3, localr.CmH, localr.kYw, 7));
        }
        for (;;)
        {
          i += 1;
          break label269;
          localObject1 = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, b.c.class);
          if (localObject1 != null)
          {
            bool1 = ((Bundle)localObject1).getBoolean("has_set_uin", false);
            break;
          }
          bool1 = true;
          break;
          label389:
          paramAnonymousl.c(((r.c)localObject2).id, ((r.c)localObject2).title);
        }
        label407:
        AppMethodBeat.o(78448);
      }
    };
    this.jZN.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(78449);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = r.this;
          String str = paramString;
          x.a(paramAnonymousMenuItem.CkZ.mContext, str, com.tencent.xweb.c.fJa().getCookie(str), com.tencent.mm.compatible.util.e.YD(), new r.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = r.this;
          str = paramString;
          x.b(paramAnonymousMenuItem.CkZ.mContext, str, com.tencent.xweb.c.fJa().getCookie(str), com.tencent.mm.compatible.util.e.YD());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = r.this;
          str = paramString;
          x.a(paramAnonymousMenuItem.CkZ.mContext, str, com.tencent.xweb.c.fJa().getCookie(str), com.tencent.mm.compatible.util.e.YD(), new r.5(paramAnonymousMenuItem));
        }
      }
    };
    this.jZN.Ihj = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (r.this.kYA != null) {
          try
          {
            r.this.CmH = 0;
            r.this.kYw = null;
            r.this.kYG.wVE = null;
            String str = r.this.kYA.CsC;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, r.d.class, null);
            r.this.kYA.eCf();
            AppMethodBeat.o(78436);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.LuggageWebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(78436);
      }
    };
    if (!((Activity)this.CkZ.mContext).isFinishing()) {
      this.jZN.cED();
    }
    boolean bool = this.jZN.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean eAO()
  {
    AppMethodBeat.i(78467);
    if (!this.CkZ.eAs().aCD(this.CkZ.getUrl()).eRi())
    {
      AppMethodBeat.o(78467);
      return false;
    }
    IPCBoolean localIPCBoolean = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, b.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(78467);
      return true;
    }
    AppMethodBeat.o(78467);
    return false;
  }
  
  final boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(78464);
    boolean bool = aBD(paramb.mExtra);
    if ((bs.isNullOrNil(this.kYw)) && (eAO()))
    {
      this.kYC = paramb;
      this.kYA = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kYA.a(this.CkZ.getWebView(), this.kYI);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aBD(paramb.mExtra);
    if ((bs.isNullOrNil(this.kYw)) && (eAO()))
    {
      this.kYB = paramb;
      this.kYA = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kYA.a(this.CkZ.getWebView(), this.kYI);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean eAM()
  {
    return this.CkZ == null;
  }
  
  final void eAN()
  {
    AppMethodBeat.i(78462);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (r.this.kYB != null)
        {
          r.this.b(r.this.kYB);
          AppMethodBeat.o(78446);
          return;
        }
        if (r.this.kYC != null) {
          r.this.a(r.this.kYC);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  final boolean fw(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.CkZ.getWebView().getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(78463);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          b(paramView);
        }
      }
      catch (Exception paramView)
      {
        ac.e("MicroMsg.LuggageWebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
        continue;
      }
      AppMethodBeat.o(78463);
      return false;
      if ((paramView instanceof MMWebView))
      {
        paramView = ((MMWebView)paramView).getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(78463);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          a(paramView);
        }
      }
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  static class b
    implements k<IPCBoolean, IPCBoolean>
  {
    private static IPCBoolean eAP()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("EnableWebviewScanQRCode"), 1);
        if (i == 1)
        {
          localIPCBoolean.value = bool;
          AppMethodBeat.o(78451);
          return localIPCBoolean;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.LuggageWebViewLongClickHelper", "isAllowScanQRCode parseInt failed");
          int i = 0;
          continue;
          bool = false;
        }
      }
    }
  }
  
  static final class c
  {
    final int id;
    final String title;
    
    public c(int paramInt, String paramString)
    {
      this.id = paramInt;
      this.title = paramString;
    }
  }
  
  static class d
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    private Map<String, Integer> CmM;
    private com.tencent.mm.sdk.b.c CmN;
    private com.tencent.mm.ipcinvoker.d gdX;
    private com.tencent.mm.sdk.b.c gdo;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.gdo = new com.tencent.mm.sdk.b.c() {};
      this.CmN = new com.tencent.mm.sdk.b.c() {};
      AppMethodBeat.o(78456);
    }
  }
  
  static class e
    implements com.tencent.mm.plugin.webview.luggage.ipc.c
  {
    public final void a(Context paramContext, Bundle paramBundle, final com.tencent.mm.plugin.webview.luggage.ipc.a parama)
    {
      AppMethodBeat.i(78460);
      Object localObject = paramBundle.getString("img_path");
      if (s.aKD((String)localObject))
      {
        paramBundle = com.tencent.mm.b.g.getMD5((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramBundle);
        if ((paramBundle != null) && (paramBundle.fdp())) {
          break label412;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        ai.getContext();
        paramBundle = paramBundle.XN((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramBundle);
      }
      label259:
      label406:
      label412:
      for (;;)
      {
        long l;
        if (paramBundle == null)
        {
          l = 0L;
          if (paramBundle != null) {
            break label259;
          }
          label116:
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          if (((com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.m.b.ZF())) && (localOptions.outWidth <= com.tencent.mm.m.b.ZF())) {
            break label406;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.m.b.ZG()) || (i != 0))
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758246), "", paramContext.getString(2131760315), null);
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758246), "", paramContext.getString(2131760315), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78458);
                parama.q(null);
                AppMethodBeat.o(78458);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78459);
                parama.q(null);
                AppMethodBeat.o(78459);
              }
            });
            AppMethodBeat.o(78460);
            return;
            l = i.aSp(paramBundle.ghd());
            break;
            localObject = paramBundle.ghd();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.JC();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.iyx.k((Intent)localObject, paramContext);
            parama.q(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.iyx.k(paramBundle, paramContext);
          parama.q(null);
          AppMethodBeat.o(78460);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */