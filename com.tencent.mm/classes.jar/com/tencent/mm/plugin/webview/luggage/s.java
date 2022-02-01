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
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.c.c.a;
import com.tencent.mm.plugin.webview.luggage.c.c.c;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.ab.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class s
{
  a.b CBU;
  int JQr;
  public g PPn;
  int PRi;
  com.tencent.mm.ui.widget.a.e oxl;
  ScanCodeSheetItemLogic oxq;
  String pGF;
  com.tencent.mm.plugin.webview.modeltools.g pGJ;
  WebView.b pGK;
  WebView.b pGL;
  private g.c pGQ;
  
  public s(g paramg)
  {
    AppMethodBeat.i(78461);
    this.pGQ = new g.c()
    {
      public final void ajA(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        s locals = s.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", locals.PPn.syc);
        localBundle.putInt("y_down", locals.PPn.syd);
        j.a(MainProcessIPCService.PROCESS_NAME, localBundle, s.d.class, new s.6(locals));
        AppMethodBeat.o(78435);
      }
    };
    this.CBU = new a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bsM();
        AppMethodBeat.o(78443);
      }
    };
    this.PPn = paramg;
    this.PPn.PPv.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
        Log.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        localObject = s.this;
        ((s)localObject).pGF = null;
        ((s)localObject).pGL = null;
        ((s)localObject).pGK = null;
        ((s)localObject).oxq.onDismiss();
        if (s.this.elX())
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = s.this.eX(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.oxq = new ScanCodeSheetItemLogic(paramg.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(78444);
        if ((s.this.oxl != null) && (s.this.oxl.isShowing())) {
          s.this.gUZ();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aGF(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.oxl == null) {
      this.oxl = new com.tencent.mm.ui.widget.a.e(this.PPn.mContext, 1, false);
    }
    this.oxl.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(78448);
        s locals = s.this;
        boolean bool1;
        Object localObject1;
        int i;
        label272:
        Object localObject2;
        if (MMApplicationContext.isMMProcess())
        {
          bool1 = com.tencent.mm.kernel.h.aHB();
          boolean bool2 = locals.PPn.gUA().blA(locals.PPn.getUrl()).hoX();
          boolean bool3 = locals.PPn.gUA().blA(locals.PPn.getUrl()).hoY();
          Log.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new s.c(1, locals.PPn.mContext.getString(c.i.readerapp_alert_retransmit)));
          }
          ((List)localObject1).add(new s.c(2, locals.PPn.mContext.getString(c.i.save_to_local)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new s.c(3, locals.PPn.mContext.getString(c.i.plugin_favorite_opt)));
          }
          if (locals.pGF != null) {
            ((List)localObject1).add(new s.c(4, locals.oxq.adg(locals.PRi)));
          }
          locals.oxl.setFooterView(null);
          paramAnonymouso.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label411;
          }
          localObject2 = (s.c)((List)localObject1).get(i);
          if (((s.c)localObject2).id != 4) {
            break label393;
          }
          localObject2 = locals.oxl;
          s.3 local3 = new s.3(locals);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(locals.oxq.a(local3, locals.PRi, locals.pGF, 7));
        }
        for (;;)
        {
          i += 1;
          break label272;
          localObject1 = (Bundle)j.a(MainProcessIPCService.PROCESS_NAME, null, c.c.class);
          if (localObject1 != null)
          {
            bool1 = ((Bundle)localObject1).getBoolean("has_set_uin", false);
            break;
          }
          bool1 = true;
          break;
          label393:
          paramAnonymouso.d(((s.c)localObject2).id, ((s.c)localObject2).title);
        }
        label411:
        AppMethodBeat.o(78448);
      }
    };
    this.oxl.ODU = new q.g()
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
          ab.a(paramAnonymousMenuItem.PPn.mContext, str, com.tencent.xweb.c.ivX().getCookie(str), com.tencent.mm.compatible.util.e.avA(), new s.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          ab.b(paramAnonymousMenuItem.PPn.mContext, str, com.tencent.xweb.c.ivX().getCookie(str), com.tencent.mm.compatible.util.e.avA());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          ab.a(paramAnonymousMenuItem.PPn.mContext, str, com.tencent.xweb.c.ivX().getCookie(str), com.tencent.mm.compatible.util.e.avA(), new s.5(paramAnonymousMenuItem));
        }
      }
    };
    this.oxl.XbB = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (s.this.pGJ != null) {
          try
          {
            s.this.PRi = 0;
            s.this.pGF = null;
            s.this.oxq.onDismiss();
            String str = s.this.pGJ.PXC;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            j.a(MainProcessIPCService.PROCESS_NAME, localBundle, s.d.class, null);
            s.this.pGJ.gWy();
            AppMethodBeat.o(78436);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.LuggageWebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(78436);
      }
    };
    if (!((Activity)this.PPn.mContext).isFinishing()) {
      this.oxl.eik();
    }
    boolean bool = this.oxl.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean emg()
  {
    AppMethodBeat.i(78467);
    if (!this.PPn.gUA().blA(this.PPn.getUrl()).hoT())
    {
      AppMethodBeat.o(78467);
      return false;
    }
    IPCBoolean localIPCBoolean = (IPCBoolean)j.a(MainProcessIPCService.PROCESS_NAME, null, b.class);
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
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.pGF)) && (emg()))
    {
      this.pGL = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(this.PPn.PPv, this.pGQ);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.pGF)) && (emg()))
    {
      this.pGK = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(this.PPn.PPv, this.pGQ);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean eX(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.PPn.PPv.getHitTestResult();
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
        Log.e("MicroMsg.LuggageWebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
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
  
  final boolean elX()
  {
    return this.PPn == null;
  }
  
  final void gUZ()
  {
    AppMethodBeat.i(78462);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (s.this.pGK != null)
        {
          s.this.b(s.this.pGK);
          AppMethodBeat.o(78446);
          return;
        }
        if (s.this.pGL != null) {
          s.this.a(s.this.pGL);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.m<IPCBoolean, IPCBoolean>
  {
    private static IPCBoolean gVa()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = Util.getInt(com.tencent.mm.n.h.axc().getValue("EnableWebviewScanQRCode"), 1);
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
          Log.e("MicroMsg.LuggageWebViewLongClickHelper", "isAllowScanQRCode parseInt failed");
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
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {
    private IListener BrS;
    private Map<String, Integer> PRm;
    private com.tencent.mm.ipcinvoker.f jYP;
    private IListener jYc;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.jYc = new IListener() {};
      this.BrS = new IListener() {};
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
      if (ImgUtil.isGif((String)localObject))
      {
        paramBundle = com.tencent.mm.b.g.getMD5((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramBundle);
        if ((paramBundle != null) && (paramBundle.hBp())) {
          break label416;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        MMApplicationContext.getContext();
        paramBundle = paramBundle.auf((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramBundle);
      }
      label263:
      label410:
      label416:
      for (;;)
      {
        long l;
        if (paramBundle == null)
        {
          l = 0L;
          if (paramBundle != null) {
            break label263;
          }
          label116:
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.c.awH())) && (localOptions.outWidth <= com.tencent.mm.n.c.awH())) {
            break label410;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.n.c.awI()) || (i != 0))
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(c.i.i_know_it), null);
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(c.i.i_know_it), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78458);
                parama.C(null);
                AppMethodBeat.o(78458);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78459);
                parama.C(null);
                AppMethodBeat.o(78459);
              }
            });
            AppMethodBeat.o(78460);
            return;
            l = u.bBQ(paramBundle.ifh());
            break;
            localObject = paramBundle.ifh();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.getMd5();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.mIG.j((Intent)localObject, paramContext);
            parama.C(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.mIG.j(paramBundle, paramContext);
          parama.C(null);
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