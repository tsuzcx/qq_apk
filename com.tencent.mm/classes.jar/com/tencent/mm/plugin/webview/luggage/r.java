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
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
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
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
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
  public f ASM;
  int AUu;
  com.tencent.mm.ui.widget.a.e jzq;
  String kxi;
  com.tencent.mm.plugin.webview.modeltools.h kxm;
  WebView.b kxn;
  WebView.b kxo;
  ScanCodeSheetItemLogic kxs;
  private h.c kxu;
  a.b rPQ;
  int wAA;
  
  public r(f paramf)
  {
    AppMethodBeat.i(78461);
    this.kxu = new h.c()
    {
      public final void JL(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        r localr = r.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", localr.ASM.mUE);
        localBundle.putInt("y_down", localr.ASM.mUF);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, r.d.class, new r.6(localr));
        AppMethodBeat.o(78435);
      }
    };
    this.rPQ = new a.b()
    {
      public final void aXO()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78443);
      }
    };
    this.ASM = paramf;
    this.ASM.getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        ad.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        r localr = r.this;
        localr.kxi = null;
        localr.kxo = null;
        localr.kxn = null;
        localr.kxs.vLD = null;
        if (r.this.elq())
        {
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = r.this.fj(paramAnonymousView);
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.kxs = new ScanCodeSheetItemLogic(paramf.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
      {
        AppMethodBeat.i(78444);
        if ((r.this.jzq != null) && (r.this.jzq.isShowing())) {
          r.this.elr();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean awl(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.jzq == null) {
      this.jzq = new com.tencent.mm.ui.widget.a.e(this.ASM.mContext, 1, false);
    }
    this.jzq.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(78448);
        r localr = r.this;
        boolean bool1;
        Object localObject1;
        int i;
        label264:
        Object localObject2;
        if (aj.cbv())
        {
          bool1 = com.tencent.mm.kernel.g.afw();
          boolean bool2 = localr.ASM.ekW().axl(localr.ASM.getUrl()).eBR();
          boolean bool3 = localr.ASM.ekW().axl(localr.ASM.getUrl()).eBS();
          ad.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new r.c(1, localr.ASM.mContext.getString(2131762163)));
          }
          ((List)localObject1).add(new r.c(2, localr.ASM.mContext.getString(2131762783)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new r.c(3, localr.ASM.mContext.getString(2131761941)));
          }
          if (localr.kxi != null) {
            ((List)localObject1).add(new r.c(4, localr.kxs.dkU()));
          }
          localr.jzq.setFooterView(null);
          paramAnonymousl.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label402;
          }
          localObject2 = (r.c)((List)localObject1).get(i);
          if (((r.c)localObject2).id != 4) {
            break label384;
          }
          localObject2 = localr.jzq;
          r.3 local3 = new r.3(localr);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(localr.kxs.a(local3, localr.AUu, localr.kxi, 7));
        }
        for (;;)
        {
          i += 1;
          break label264;
          localObject1 = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, b.c.class);
          if (localObject1 != null)
          {
            bool1 = ((Bundle)localObject1).getBoolean("has_set_uin", false);
            break;
          }
          bool1 = true;
          break;
          label384:
          paramAnonymousl.c(((r.c)localObject2).id, ((r.c)localObject2).title);
        }
        label402:
        AppMethodBeat.o(78448);
      }
    };
    this.jzq.HrY = new n.d()
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
          x.a(paramAnonymousMenuItem.ASM.mContext, str, com.tencent.xweb.c.fqC().getCookie(str), com.tencent.mm.compatible.util.e.XG(), new r.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = r.this;
          str = paramString;
          x.b(paramAnonymousMenuItem.ASM.mContext, str, com.tencent.xweb.c.fqC().getCookie(str), com.tencent.mm.compatible.util.e.XG());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = r.this;
          str = paramString;
          x.a(paramAnonymousMenuItem.ASM.mContext, str, com.tencent.xweb.c.fqC().getCookie(str), com.tencent.mm.compatible.util.e.XG(), new r.5(paramAnonymousMenuItem));
        }
      }
    };
    this.jzq.GHn = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (r.this.kxm != null) {
          try
          {
            r.this.AUu = 0;
            r.this.kxi = null;
            r.this.kxs.vLD = null;
            String str = r.this.kxm.Bap;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, r.d.class, null);
            r.this.kxm.emK();
            AppMethodBeat.o(78436);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.LuggageWebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(78436);
      }
    };
    if (!((Activity)this.ASM.mContext).isFinishing()) {
      this.jzq.csG();
    }
    boolean bool = this.jzq.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean els()
  {
    AppMethodBeat.i(78467);
    if (!this.ASM.ekW().axl(this.ASM.getUrl()).eBN())
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
    boolean bool = awl(paramb.mExtra);
    if ((bt.isNullOrNil(this.kxi)) && (els()))
    {
      this.kxo = paramb;
      this.kxm = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kxm.a(this.ASM.getWebView(), this.kxu);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = awl(paramb.mExtra);
    if ((bt.isNullOrNil(this.kxi)) && (els()))
    {
      this.kxn = paramb;
      this.kxm = new com.tencent.mm.plugin.webview.modeltools.h();
      this.kxm.a(this.ASM.getWebView(), this.kxu);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean elq()
  {
    return this.ASM == null;
  }
  
  final void elr()
  {
    AppMethodBeat.i(78462);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (r.this.kxn != null)
        {
          r.this.b(r.this.kxn);
          AppMethodBeat.o(78446);
          return;
        }
        if (r.this.kxo != null) {
          r.this.a(r.this.kxo);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  final boolean fj(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.ASM.getWebView().getHitTestResult();
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
        ad.e("MicroMsg.LuggageWebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
    private static IPCBoolean elt()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("EnableWebviewScanQRCode"), 1);
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
          ad.e("MicroMsg.LuggageWebViewLongClickHelper", "isAllowScanQRCode parseInt failed");
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
    private com.tencent.mm.sdk.b.c AUA;
    private Map<String, Integer> AUz;
    private com.tencent.mm.sdk.b.c fYI;
    private com.tencent.mm.ipcinvoker.d fZr;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.fYI = new com.tencent.mm.sdk.b.c() {};
      this.AUA = new com.tencent.mm.sdk.b.c() {};
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
      if (t.aFm((String)localObject))
      {
        paramBundle = com.tencent.mm.b.g.getMD5((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramBundle);
        if ((paramBundle != null) && (paramBundle.fZM())) {
          break label412;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        aj.getContext();
        paramBundle = paramBundle.TB((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramBundle);
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
          if (((com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.m.b.YI())) && (localOptions.outWidth <= com.tencent.mm.m.b.YI())) {
            break label406;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.m.b.YJ()) || (i != 0))
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
            l = i.aMN(paramBundle.gaa());
            break;
            localObject = paramBundle.gaa();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.JS();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.hYt.k((Intent)localObject, paramContext);
            parama.q(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.hYt.k(paramBundle, paramContext);
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