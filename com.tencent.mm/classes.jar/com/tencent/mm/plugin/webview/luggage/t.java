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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.k.h.c;
import com.tencent.mm.plugin.webview.luggage.c.c.a;
import com.tencent.mm.plugin.webview.luggage.c.c.c;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class t
{
  a.b IvJ;
  int QmY;
  public g WFG;
  int WHF;
  com.tencent.mm.ui.widget.a.f rAK;
  ScanCodeSheetItemLogic rAP;
  String sLF;
  com.tencent.mm.plugin.webview.k.h sLJ;
  WebView.b sLK;
  WebView.b sLL;
  private h.c sLQ;
  
  public t(g paramg)
  {
    AppMethodBeat.i(78461);
    this.sLQ = new h.c()
    {
      public final void acB(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        t localt = t.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", localt.WFG.x_down);
        localBundle.putInt("y_down", localt.WFG.y_down);
        j.a(MainProcessIPCService.PROCESS_NAME, localBundle, t.d.class, new t.6(localt));
        AppMethodBeat.o(78435);
      }
    };
    this.IvJ = new a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bQt();
        AppMethodBeat.o(78443);
      }
    };
    this.WFG = paramg;
    this.WFG.WFO.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
        Log.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        localObject = t.this;
        ((t)localObject).sLF = null;
        ((t)localObject).sLL = null;
        ((t)localObject).sLK = null;
        ((t)localObject).rAP.onDismiss();
        if (t.this.bpe())
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = t.this.ho(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.rAP = new ScanCodeSheetItemLogic(paramg.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(78444);
        if ((t.this.rAK != null) && (t.this.rAK.isShowing())) {
          t.this.iuK();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aCU(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.rAK == null) {
      this.rAK = new com.tencent.mm.ui.widget.a.f(this.WFG.mContext, 1, false);
    }
    this.rAK.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(78448);
        t localt = t.this;
        boolean bool1;
        Object localObject1;
        int i;
        label272:
        Object localObject2;
        if (MMApplicationContext.isMMProcess())
        {
          bool1 = com.tencent.mm.kernel.h.baz();
          boolean bool2 = localt.WFG.iuj().blc(localt.WFG.getUrl()).iPR();
          boolean bool3 = localt.WFG.iuj().blc(localt.WFG.getUrl()).iPS();
          Log.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new t.c(1, localt.WFG.mContext.getString(c.i.readerapp_alert_retransmit)));
          }
          ((List)localObject1).add(new t.c(2, localt.WFG.mContext.getString(c.i.save_to_local)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new t.c(3, localt.WFG.mContext.getString(c.i.plugin_favorite_opt)));
          }
          if (localt.sLF != null) {
            ((List)localObject1).add(new t.c(4, localt.rAP.ahD(localt.WHF)));
          }
          localt.rAK.setFooterView(null);
          paramAnonymouss.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label411;
          }
          localObject2 = (t.c)((List)localObject1).get(i);
          if (((t.c)localObject2).id != 4) {
            break label393;
          }
          localObject2 = localt.rAK;
          t.3 local3 = new t.3(localt);
          ((com.tencent.mm.ui.widget.a.f)localObject2).setFooterView(localt.rAP.a(local3, localt.WHF, localt.sLF, 7));
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
          paramAnonymouss.c(((t.c)localObject2).id, ((t.c)localObject2).title);
        }
        label411:
        AppMethodBeat.o(78448);
      }
    };
    this.rAK.GAC = new u.i()
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
          paramAnonymousMenuItem = t.this;
          String str = paramString;
          aa.a(paramAnonymousMenuItem.WFG.mContext, str, ao.getCookie(str), com.tencent.mm.compatible.util.e.aPU(), new t.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = t.this;
          str = paramString;
          aa.b(paramAnonymousMenuItem.WFG.mContext, str, ao.getCookie(str), com.tencent.mm.compatible.util.e.aPU());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = t.this;
          str = paramString;
          aa.a(paramAnonymousMenuItem.WFG.mContext, str, ao.getCookie(str), com.tencent.mm.compatible.util.e.aPU(), new t.5(paramAnonymousMenuItem));
        }
      }
    };
    this.rAK.aeLi = new f.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (t.this.sLJ != null) {
          try
          {
            t.this.WHF = 0;
            t.this.sLF = null;
            t.this.rAP.onDismiss();
            String str = t.this.sLJ.XsV;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            j.a(MainProcessIPCService.PROCESS_NAME, localBundle, t.d.class, null);
            t.this.sLJ.iCR();
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
    if (!((Activity)this.WFG.mContext).isFinishing()) {
      this.rAK.dDn();
    }
    boolean bool = this.rAK.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean fqk()
  {
    AppMethodBeat.i(78467);
    if (!this.WFG.iuj().blc(this.WFG.getUrl()).iPP())
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
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.sLF)) && (fqk()))
    {
      this.sLL = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(this.WFG.WFO, this.sLQ);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.sLF)) && (fqk()))
    {
      this.sLK = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(this.WFG.WFO, this.sLQ);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean bpe()
  {
    return this.WFG == null;
  }
  
  final boolean ho(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.WFG.WFO.getHitTestResult();
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
  
  final void iuK()
  {
    AppMethodBeat.i(78462);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (t.this.sLK != null)
        {
          t.this.b(t.this.sLK);
          AppMethodBeat.o(78446);
          return;
        }
        if (t.this.sLL != null) {
          t.this.a(t.this.sLL);
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
    private static IPCBoolean iuL()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = Util.getInt(i.aRC().getValue("EnableWebviewScanQRCode"), 1);
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
    private IListener GYo;
    private Map<String, Integer> WHJ;
    private IListener mxW;
    private com.tencent.mm.ipcinvoker.f myL;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.mxW = new LuggageWebViewLongClickHelper.QBarLogicTask.1(this, com.tencent.mm.app.f.hfK);
      this.GYo = new LuggageWebViewLongClickHelper.QBarLogicTask.2(this, com.tencent.mm.app.f.hfK);
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
        paramBundle = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramBundle);
        if ((paramBundle != null) && (paramBundle.kLZ())) {
          break label416;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr();
        MMApplicationContext.getContext();
        paramBundle = paramBundle.aog((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramBundle);
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
          if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.k.c.aRh())) && (localOptions.outWidth <= com.tencent.mm.k.c.aRh())) {
            break label410;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.k.c.aRi()) || (i != 0))
          {
            k.a(paramContext, paramContext.getString(c.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(c.i.i_know_it), null);
            k.a(paramContext, paramContext.getString(c.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramContext.getString(c.i.i_know_it), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78458);
                parama.J(null);
                AppMethodBeat.o(78458);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78459);
                parama.J(null);
                AppMethodBeat.o(78459);
              }
            });
            AppMethodBeat.o(78460);
            return;
            l = y.bEl(paramBundle.kMn());
            break;
            localObject = paramBundle.kMn();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.getMd5();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.pFn.j((Intent)localObject, paramContext);
            parama.J(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.pFn.j(paramBundle, paramContext);
          parama.J(null);
          AppMethodBeat.o(78460);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */