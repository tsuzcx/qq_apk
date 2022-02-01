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
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.luggage.c.b.a;
import com.tencent.mm.plugin.webview.luggage.c.b.c;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.pluginsdk.ui.tools.z.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.xweb.WebView.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class s
{
  int DDM;
  public g ISU;
  int IUQ;
  com.tencent.mm.ui.widget.a.e lBM;
  String mHk;
  com.tencent.mm.plugin.webview.modeltools.h mHo;
  WebView.b mHp;
  WebView.b mHq;
  ScanCodeSheetItemLogic mHu;
  private h.c mHw;
  a.b xxK;
  
  public s(g paramg)
  {
    AppMethodBeat.i(78461);
    this.mHw = new h.c()
    {
      public final void abF(String paramAnonymousString)
      {
        AppMethodBeat.i(78435);
        s locals = s.this;
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 1);
        localBundle.putString("img_path", paramAnonymousString);
        localBundle.putInt("x_down", locals.ISU.ppd);
        localBundle.putInt("y_down", locals.ISU.ppe);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, localBundle, s.d.class, new s.6(locals));
        AppMethodBeat.o(78435);
      }
    };
    this.xxK = new a.b()
    {
      public final void bDZ()
      {
        AppMethodBeat.i(78443);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(78443);
      }
    };
    this.ISU = paramg;
    this.ISU.ITd.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78447);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.v("MicroMsg.LuggageWebViewLongClickHelper", "registerForContextMenu normal view long click");
        localObject = s.this;
        ((s)localObject).mHk = null;
        ((s)localObject).mHq = null;
        ((s)localObject).mHp = null;
        ((s)localObject).mHu.onDismiss();
        if (s.this.gcd())
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(78447);
          return false;
        }
        boolean bool = s.this.gd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/LuggageWebViewLongClickHelper$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(78447);
        return bool;
      }
    });
    this.mHu = new ScanCodeSheetItemLogic(paramg.mContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(78444);
        if ((s.this.lBM != null) && (s.this.lBM.isShowing())) {
          s.this.gce();
        }
        AppMethodBeat.o(78444);
      }
    });
    AppMethodBeat.o(78461);
  }
  
  private boolean aYx(final String paramString)
  {
    AppMethodBeat.i(78466);
    if (this.lBM == null) {
      this.lBM = new com.tencent.mm.ui.widget.a.e(this.ISU.mContext, 1, false);
    }
    this.lBM.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(78448);
        s locals = s.this;
        boolean bool1;
        Object localObject1;
        int i;
        label269:
        Object localObject2;
        if (MMApplicationContext.isMMProcess())
        {
          bool1 = com.tencent.mm.kernel.g.aAc();
          boolean bool2 = locals.ISU.gbF().aZF(locals.ISU.getUrl()).gtH();
          boolean bool3 = locals.ISU.gbF().aZF(locals.ISU.getUrl()).gtI();
          Log.i("MicroMsg.LuggageWebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          localObject1 = new ArrayList();
          if ((bool1) && (bool2)) {
            ((List)localObject1).add(new s.c(1, locals.ISU.mContext.getString(2131764184)));
          }
          ((List)localObject1).add(new s.c(2, locals.ISU.mContext.getString(2131764870)));
          if ((bool1) && (bool3)) {
            ((List)localObject1).add(new s.c(3, locals.ISU.mContext.getString(2131763947)));
          }
          if (locals.mHk != null) {
            ((List)localObject1).add(new s.c(4, locals.mHu.Wp(locals.IUQ)));
          }
          locals.lBM.setFooterView(null);
          paramAnonymousm.clear();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label408;
          }
          localObject2 = (s.c)((List)localObject1).get(i);
          if (((s.c)localObject2).id != 4) {
            break label390;
          }
          localObject2 = locals.lBM;
          s.3 local3 = new s.3(locals);
          ((com.tencent.mm.ui.widget.a.e)localObject2).setFooterView(locals.mHu.a(local3, locals.IUQ, locals.mHk, 7));
        }
        for (;;)
        {
          i += 1;
          break label269;
          localObject1 = (Bundle)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, null, b.c.class);
          if (localObject1 != null)
          {
            bool1 = ((Bundle)localObject1).getBoolean("has_set_uin", false);
            break;
          }
          bool1 = true;
          break;
          label390:
          paramAnonymousm.d(((s.c)localObject2).id, ((s.c)localObject2).title);
        }
        label408:
        AppMethodBeat.o(78448);
      }
    };
    this.lBM.HLY = new o.g()
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
          z.a(paramAnonymousMenuItem.ISU.mContext, str, com.tencent.xweb.c.hsp().getCookie(str), com.tencent.mm.compatible.util.e.apn(), new s.4(paramAnonymousMenuItem));
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          z.b(paramAnonymousMenuItem.ISU.mContext, str, com.tencent.xweb.c.hsp().getCookie(str), com.tencent.mm.compatible.util.e.apn());
          AppMethodBeat.o(78449);
          return;
          paramAnonymousMenuItem = s.this;
          str = paramString;
          z.a(paramAnonymousMenuItem.ISU.mContext, str, com.tencent.xweb.c.hsp().getCookie(str), com.tencent.mm.compatible.util.e.apn(), new s.5(paramAnonymousMenuItem));
        }
      }
    };
    this.lBM.PGl = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(78436);
        if (s.this.mHo != null) {
          try
          {
            s.this.IUQ = 0;
            s.this.mHk = null;
            s.this.mHu.onDismiss();
            String str = s.this.mHo.Jbk;
            Bundle localBundle = new Bundle();
            localBundle.putInt("type", 2);
            localBundle.putString("img_path", str);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, localBundle, s.d.class, null);
            s.this.mHo.gdA();
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
    if (!((Activity)this.ISU.mContext).isFinishing()) {
      this.lBM.dGm();
    }
    boolean bool = this.lBM.isShowing();
    AppMethodBeat.o(78466);
    return bool;
  }
  
  private boolean gcf()
  {
    AppMethodBeat.i(78467);
    if (!this.ISU.gbF().aZF(this.ISU.getUrl()).gtD())
    {
      AppMethodBeat.o(78467);
      return false;
    }
    IPCBoolean localIPCBoolean = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, null, b.class);
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
    boolean bool = aYx(paramb.mExtra);
    if ((Util.isNullOrNil(this.mHk)) && (gcf()))
    {
      this.mHq = paramb;
      this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
      this.mHo.a(this.ISU.ITd, this.mHw);
    }
    AppMethodBeat.o(78464);
    return bool;
  }
  
  final boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(78465);
    boolean bool = aYx(paramb.mExtra);
    if ((Util.isNullOrNil(this.mHk)) && (gcf()))
    {
      this.mHp = paramb;
      this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
      this.mHo.a(this.ISU.ITd, this.mHw);
    }
    AppMethodBeat.o(78465);
    return bool;
  }
  
  final boolean gcd()
  {
    return this.ISU == null;
  }
  
  final void gce()
  {
    AppMethodBeat.i(78462);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78446);
        if (s.this.mHp != null)
        {
          s.this.b(s.this.mHp);
          AppMethodBeat.o(78446);
          return;
        }
        if (s.this.mHq != null) {
          s.this.a(s.this.mHq);
        }
        AppMethodBeat.o(78446);
      }
    });
    AppMethodBeat.o(78462);
  }
  
  final boolean gd(View paramView)
  {
    AppMethodBeat.i(78463);
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = this.ISU.ITd.getHitTestResult();
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
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  static class b
    implements k<IPCBoolean, IPCBoolean>
  {
    private static IPCBoolean gcg()
    {
      boolean bool = true;
      AppMethodBeat.i(78451);
      IPCBoolean localIPCBoolean = new IPCBoolean();
      try
      {
        i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("EnableWebviewScanQRCode"), 1);
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
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {
    private Map<String, Integer> IUV;
    private IListener IUW;
    private IListener hms;
    private com.tencent.mm.ipcinvoker.d hnd;
    
    private d()
    {
      AppMethodBeat.i(78456);
      this.hms = new IListener() {};
      this.IUW = new IListener() {};
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
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramBundle);
        if ((paramBundle != null) && (paramBundle.hRx())) {
          break label412;
        }
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
        MMApplicationContext.getContext();
        paramBundle = paramBundle.amn((String)localObject);
        paramBundle = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramBundle);
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
          if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.c.aqo())) && (localOptions.outWidth <= com.tencent.mm.n.c.aqo())) {
            break label406;
          }
        }
        for (int i = 1;; i = 0)
        {
          if ((l > com.tencent.mm.n.c.aqp()) || (i != 0))
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758534), "", paramContext.getString(2131761757), null);
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758534), "", paramContext.getString(2131761757), "", false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78458);
                parama.v(null);
                AppMethodBeat.o(78458);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(78459);
                parama.v(null);
                AppMethodBeat.o(78459);
              }
            });
            AppMethodBeat.o(78460);
            return;
            l = com.tencent.mm.vfs.s.boW(paramBundle.hRM());
            break;
            localObject = paramBundle.hRM();
            break label116;
          }
          localObject = new Intent();
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.getMd5();; paramBundle = "")
          {
            ((Intent)localObject).putExtra("Retr_File_Name", paramBundle);
            ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
            ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.webview.a.a.jRt.k((Intent)localObject, paramContext);
            parama.v(null);
            AppMethodBeat.o(78460);
            return;
          }
          paramBundle = new Intent();
          paramBundle.putExtra("Retr_File_Name", (String)localObject);
          paramBundle.putExtra("Retr_Compress_Type", 0);
          paramBundle.putExtra("Retr_Msg_Type", 0);
          paramBundle.addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.jRt.k(paramBundle, paramContext);
          parama.v(null);
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