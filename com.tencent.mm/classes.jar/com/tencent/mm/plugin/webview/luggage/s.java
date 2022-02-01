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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.luggage.c.b.a;
import com.tencent.mm.plugin.webview.luggage.c.b.c;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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

public final class s
{
  public g DOl;
  int DQc;
  com.tencent.mm.ui.widget.a.e kuj;
  com.tencent.mm.plugin.webview.modeltools.h lvC;
  WebView.b lvD;
  WebView.b lvE;
  ScanCodeSheetItemLogic lvI;
  private h.c lvK;
  String lvy;
  a.b tUH;
  int zcL;
  
  public s(g paramg)
  {
    AppMethodBeat.i(78461);
    this.lvK = new h.c()
    {
      public final void Rr(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        s locals = s.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", locals.DOl.nYw);
        localBundle.putInt("y_down", locals.DOl.nYx);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, s.d.class, new s.6(locals));
        AppMethodBeat.o(78435);
      }
    };
    this.tUH = new a.b()
    {
      public final void bip()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78443);
      }
    };
    this.DOl = paramg;
    this.DOl.getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        localObject = s.this;
        ((s)localObject).lvy = null;
        ((s)localObject).lvE = null;
        ((s)localObject).lvD = null;
        ((s)localObject).lvI.onDismiss();
        if (s.this.ePE())
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = s.this.fL(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.lvI = new ScanCodeSheetItemLogic(paramg.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(78444);
        if ((s.this.kuj != null) && (s.this.kuj.isShowing())) {
          s.this.ePF();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aHb(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.kuj == null) {
      this.kuj = new com.tencent.mm.ui.widget.a.e(this.DOl.mContext, 1, false);
    }
    this.kuj.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(78448);
        s locals = s.this;
        boolean bool1;
        Object localObject1;
        int i;
        label269:
        Object localObject2;
        if (aj.cnC())
        {
          bool1 = com.tencent.mm.kernel.g.ajx();
          boolean bool2 = locals.DOl.ePi().aIf(locals.DOl.getUrl()).fgq();
          boolean bool3 = locals.DOl.ePi().aIf(locals.DOl.getUrl()).fgr();
          ad.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new s.c(1, locals.DOl.mContext.getString(2131762163)));
          }
          ((List)localObject1).add(new s.c(2, locals.DOl.mContext.getString(2131762783)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new s.c(3, locals.DOl.mContext.getString(2131761941)));
          }
          if (locals.lvy != null) {
            ((List)localObject1).add(new s.c(4, locals.lvI.On(locals.DQc)));
          }
          locals.kuj.setFooterView(null);
          paramAnonymousl.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label407;
          }
          localObject2 = (s.c)((List)localObject1).get(i);
          if (((s.c)localObject2).id != 4) {
            break label389;
          }
          localObject2 = locals.kuj;
          s.3 local3 = new s.3(locals);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(locals.lvI.a(local3, locals.DQc, locals.lvy, 7));
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
          paramAnonymousl.c(((s.c)localObject2).id, ((s.c)localObject2).title);
        }
        label407:
        AppMethodBeat.o(78448);
      }
    };
    this.kuj.KJz = new n.e()
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
          paramAnonymousMenuItem = s.this;
          String str = paramString;
          x.a(paramAnonymousMenuItem.DOl.mContext, str, com.tencent.xweb.c.gaw().getCookie(str), com.tencent.mm.compatible.util.e.abf(), new s.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          x.b(paramAnonymousMenuItem.DOl.mContext, str, com.tencent.xweb.c.gaw().getCookie(str), com.tencent.mm.compatible.util.e.abf());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          x.a(paramAnonymousMenuItem.DOl.mContext, str, com.tencent.xweb.c.gaw().getCookie(str), com.tencent.mm.compatible.util.e.abf(), new s.5(paramAnonymousMenuItem));
        }
      }
    };
    this.kuj.JXC = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (s.this.lvC != null) {
          try
          {
            s.this.DQc = 0;
            s.this.lvy = null;
            s.this.lvI.onDismiss();
            String str = s.this.lvC.DWh;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, s.d.class, null);
            s.this.lvC.eQZ();
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
    if (!((Activity)this.DOl.mContext).isFinishing()) {
      this.kuj.cMW();
    }
    boolean bool = this.kuj.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean ePG()
  {
    AppMethodBeat.i(78467);
    if (!this.DOl.ePi().aIf(this.DOl.getUrl()).fgm())
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
    boolean bool = aHb(paramb.mExtra);
    if ((bt.isNullOrNil(this.lvy)) && (ePG()))
    {
      this.lvE = paramb;
      this.lvC = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lvC.a(this.DOl.getWebView(), this.lvK);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aHb(paramb.mExtra);
    if ((bt.isNullOrNil(this.lvy)) && (ePG()))
    {
      this.lvD = paramb;
      this.lvC = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lvC.a(this.DOl.getWebView(), this.lvK);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean ePE()
  {
    return this.DOl == null;
  }
  
  final void ePF()
  {
    AppMethodBeat.i(78462);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (s.this.lvD != null)
        {
          s.this.b(s.this.lvD);
          AppMethodBeat.o(78446);
          return;
        }
        if (s.this.lvE != null) {
          s.this.a(s.this.lvE);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  final boolean fL(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.DOl.getWebView().getHitTestResult();
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
    private static IPCBoolean ePH()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = bt.getInt(com.tencent.mm.n.g.acA().getValue("EnableWebviewScanQRCode"), 1);
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
    private Map<String, Integer> DQh;
    private com.tencent.mm.sdk.b.c DQi;
    private com.tencent.mm.sdk.b.c gwY;
    private com.tencent.mm.ipcinvoker.d gxH;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.gwY = new com.tencent.mm.sdk.b.c() {};
      this.DQi = new com.tencent.mm.sdk.b.c() {};
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
      if (t.aQj((String)localObject))
      {
        paramBundle = com.tencent.mm.b.g.getMD5((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramBundle);
        if ((paramBundle != null) && (paramBundle.fOu())) {
          break label412;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        aj.getContext();
        paramBundle = paramBundle.abt((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramBundle);
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
          if (((com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.b.acf())) && (localOptions.outWidth <= com.tencent.mm.n.b.acf())) {
            break label406;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.n.b.acg()) || (i != 0))
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
            l = i.aYo(paramBundle.gzQ());
            break;
            localObject = paramBundle.gzQ();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.Lb();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.iRG.k((Intent)localObject, paramContext);
            parama.q(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.iRG.k(paramBundle, paramContext);
          parama.q(null);
          AppMethodBeat.o(78460);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */