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
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
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
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class s
{
  public g Egl;
  int Eic;
  com.tencent.mm.ui.widget.a.e kxz;
  com.tencent.mm.plugin.webview.modeltools.h lAa;
  WebView.b lAb;
  WebView.b lAc;
  ScanCodeSheetItemLogic lAg;
  private h.c lAi;
  String lzW;
  a.b ufz;
  int ztB;
  
  public s(g paramg)
  {
    AppMethodBeat.i(78461);
    this.lAi = new h.c()
    {
      public final void Sa(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        s locals = s.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", locals.Egl.oef);
        localBundle.putInt("y_down", locals.Egl.oeg);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, s.d.class, new s.6(locals));
        AppMethodBeat.o(78435);
      }
    };
    this.ufz = new a.b()
    {
      public final void biY()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78443);
      }
    };
    this.Egl = paramg;
    this.Egl.getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        localObject = s.this;
        ((s)localObject).lzW = null;
        ((s)localObject).lAc = null;
        ((s)localObject).lAb = null;
        ((s)localObject).lAg.onDismiss();
        if (s.this.eTq())
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = s.this.fK(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.lAg = new ScanCodeSheetItemLogic(paramg.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
      {
        AppMethodBeat.i(78444);
        if ((s.this.kxz != null) && (s.this.kxz.isShowing())) {
          s.this.eTr();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aIv(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.kxz == null) {
      this.kxz = new com.tencent.mm.ui.widget.a.e(this.Egl.mContext, 1, false);
    }
    this.kxz.LfS = new n.d()
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
        if (ak.cpe())
        {
          bool1 = com.tencent.mm.kernel.g.ajM();
          boolean bool2 = locals.Egl.eSU().aJy(locals.Egl.getUrl()).fkg();
          boolean bool3 = locals.Egl.eSU().aJy(locals.Egl.getUrl()).fkh();
          ae.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new s.c(1, locals.Egl.mContext.getString(2131762163)));
          }
          ((List)localObject1).add(new s.c(2, locals.Egl.mContext.getString(2131762783)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new s.c(3, locals.Egl.mContext.getString(2131761941)));
          }
          if (locals.lzW != null) {
            ((List)localObject1).add(new s.c(4, locals.lAg.OT(locals.Eic)));
          }
          locals.kxz.setFooterView(null);
          paramAnonymousl.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label407;
          }
          localObject2 = (s.c)((List)localObject1).get(i);
          if (((s.c)localObject2).id != 4) {
            break label389;
          }
          localObject2 = locals.kxz;
          s.3 local3 = new s.3(locals);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(locals.lAg.a(local3, locals.Eic, locals.lzW, 7));
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
          paramAnonymousl.d(((s.c)localObject2).id, ((s.c)localObject2).title);
        }
        label407:
        AppMethodBeat.o(78448);
      }
    };
    this.kxz.LfT = new n.e()
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
          x.a(paramAnonymousMenuItem.Egl.mContext, str, com.tencent.xweb.c.geY().getCookie(str), com.tencent.mm.compatible.util.e.abo(), new s.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          x.b(paramAnonymousMenuItem.Egl.mContext, str, com.tencent.xweb.c.geY().getCookie(str), com.tencent.mm.compatible.util.e.abo());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          x.a(paramAnonymousMenuItem.Egl.mContext, str, com.tencent.xweb.c.geY().getCookie(str), com.tencent.mm.compatible.util.e.abo(), new s.5(paramAnonymousMenuItem));
        }
      }
    };
    this.kxz.KtV = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (s.this.lAa != null) {
          try
          {
            s.this.Eic = 0;
            s.this.lzW = null;
            s.this.lAg.onDismiss();
            String str = s.this.lAa.Eog;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, s.d.class, null);
            s.this.lAa.eUL();
            AppMethodBeat.o(78436);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.LuggageWebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(78436);
      }
    };
    if (!((Activity)this.Egl.mContext).isFinishing()) {
      this.kxz.cPF();
    }
    boolean bool = this.kxz.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean eTs()
  {
    AppMethodBeat.i(78467);
    if (!this.Egl.eSU().aJy(this.Egl.getUrl()).fkc())
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
    boolean bool = aIv(paramb.mExtra);
    if ((bu.isNullOrNil(this.lzW)) && (eTs()))
    {
      this.lAc = paramb;
      this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lAa.a(this.Egl.getWebView(), this.lAi);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aIv(paramb.mExtra);
    if ((bu.isNullOrNil(this.lzW)) && (eTs()))
    {
      this.lAb = paramb;
      this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
      this.lAa.a(this.Egl.getWebView(), this.lAi);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean eTq()
  {
    return this.Egl == null;
  }
  
  final void eTr()
  {
    AppMethodBeat.i(78462);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (s.this.lAb != null)
        {
          s.this.b(s.this.lAb);
          AppMethodBeat.o(78446);
          return;
        }
        if (s.this.lAc != null) {
          s.this.a(s.this.lAc);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  final boolean fK(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.Egl.getWebView().getHitTestResult();
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
        ae.e("MicroMsg.LuggageWebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
    private static IPCBoolean eTt()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = bu.getInt(com.tencent.mm.n.g.acL().getValue("EnableWebviewScanQRCode"), 1);
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
          ae.e("MicroMsg.LuggageWebViewLongClickHelper", "isAllowScanQRCode parseInt failed");
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
    private Map<String, Integer> Eih;
    private com.tencent.mm.sdk.b.c Eii;
    private com.tencent.mm.ipcinvoker.d gAo;
    private com.tencent.mm.sdk.b.c gzF;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.gzF = new com.tencent.mm.sdk.b.c() {};
      this.Eii = new com.tencent.mm.sdk.b.c() {};
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
      if (u.aRG((String)localObject))
      {
        paramBundle = com.tencent.mm.b.g.getMD5((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramBundle);
        if ((paramBundle != null) && (paramBundle.fxn())) {
          break label412;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        ak.getContext();
        paramBundle = paramBundle.ack((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramBundle);
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
          if (((com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.b.acp())) && (localOptions.outWidth <= com.tencent.mm.n.b.acp())) {
            break label406;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.n.b.acq()) || (i != 0))
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758246), "", paramContext.getString(2131760315), null);
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758246), "", paramContext.getString(2131760315), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78458);
                parama.r(null);
                AppMethodBeat.o(78458);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78459);
                parama.r(null);
                AppMethodBeat.o(78459);
              }
            });
            AppMethodBeat.o(78460);
            return;
            l = o.aZR(paramBundle.fSQ());
            break;
            localObject = paramBundle.fSQ();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.Lj();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.iUz.k((Intent)localObject, paramContext);
            parama.r(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.iUz.k(paramBundle, paramContext);
          parama.r(null);
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