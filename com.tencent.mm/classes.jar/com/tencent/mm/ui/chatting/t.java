package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.pluginsdk.ui.tools.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
{
  public ChatFooterCustom Gom;
  public FrameLayout Gon;
  public FrameLayout Goo;
  public TextView Gop;
  public ImageView Goq;
  a Gor;
  public int Gos;
  public boolean Got;
  String Gou;
  public String Gov;
  public View.OnClickListener Gow;
  public View.OnClickListener Gox;
  private m.a Goy;
  Context mContext;
  public LinearLayout oIh;
  long oYP;
  SharedPreferences sp;
  public String uQR;
  String uQS;
  String uQT;
  
  public t(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.oIh = null;
    this.Gor = a.GoC;
    this.Gos = -1;
    this.Gou = null;
    this.oYP = -1L;
    this.Gow = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34609);
        new Intent().putExtra("composeType", 1);
        d.O(t.this.mContext, "qqmail", ".ui.ComposeUI");
        AppMethodBeat.o(34609);
      }
    };
    this.Gox = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        switch (t.8.GoB[t.this.Gor.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.vKh.f(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = t.this;
          if (!ay.isConnected(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, com.tencent.mm.cd.a.aq(paramAnonymousView.mContext, 2131757089), "", com.tencent.mm.cd.a.aq(paramAnonymousView.mContext, 2131757084), null);
            AppMethodBeat.o(34610);
            return;
          }
          if (!ay.isWifi(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.b(paramAnonymousView.mContext, 2131757086, 0, 2131757082, 2131757081, new t.3(paramAnonymousView), null);
            AppMethodBeat.o(34610);
            return;
          }
          com.tencent.mm.ui.base.h.b(paramAnonymousView.mContext, 2131757087, 0, 2131757082, 2131757081, new t.4(paramAnonymousView), null);
          AppMethodBeat.o(34610);
          return;
          paramAnonymousView = t.this;
          ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
          f.bQt().og(paramAnonymousView.oYP);
          paramAnonymousView.eVJ();
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.vKh.f(11288, new Object[] { Integer.valueOf(7) });
          paramAnonymousView = t.this;
          ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
          com.tencent.mm.pluginsdk.g.i.aG(paramAnonymousView.mContext, paramAnonymousView.Gou);
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.vKh.f(11288, new Object[] { Integer.valueOf(5) });
          t localt = t.this;
          ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
          ad.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localt.Gov });
          if (bt.isNullOrNil(localt.Gov)) {
            paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
          }
          for (;;)
          {
            ad.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
            com.tencent.mm.cj.a.post(new t.5(localt, paramAnonymousView));
            AppMethodBeat.o(34610);
            return;
            Intent localIntent = new Intent();
            localIntent.setData(Uri.parse(localt.Gov));
            localIntent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 11) {
              localIntent.addFlags(32768);
            }
            paramAnonymousView = localIntent;
            if (!bt.T(localt.mContext, localIntent)) {
              paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
          }
          if (t.this.Got) {
            t.a(t.this);
          }
        }
      }
    };
    this.Goy = new m.a()
    {
      public final void dej()
      {
        AppMethodBeat.i(34617);
        t.this.Gop.setText(2131757092);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        t.this.Gos = paramAnonymousInt;
        t.this.eVK();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.Gom = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void eVI()
  {
    AppMethodBeat.i(34623);
    if (this.Gor == a.GoG)
    {
      this.Goq.setImageResource(2131691054);
      AppMethodBeat.o(34623);
      return;
    }
    this.Goq.setImageResource(2131691055);
    AppMethodBeat.o(34623);
  }
  
  public final void eVJ()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (q.t(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.GoG;
    }
    for (;;)
    {
      this.Gor = ((a)localObject);
      eVI();
      ad.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.Gor.toString() });
      switch (8.GoB[this.Gor.ordinal()])
      {
      default: 
        m.a(this.Goy);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", g.XN());
        this.oYP = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.oYP < 0L)
        {
          if (bt.isNullOrNil(this.uQR)) {
            localObject = a.GoH;
          } else {
            localObject = a.GoD;
          }
        }
        else
        {
          localObject = f.bQt().oh(this.oYP);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.Gou = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bt.isNullOrNil(this.uQR)) {
              localObject = a.GoH;
            }
            break;
          case 3: 
            if (com.tencent.mm.vfs.i.eK(this.Gou)) {
              localObject = a.GoF;
            } else if (bt.isNullOrNil(this.uQR)) {
              localObject = a.GoH;
            } else {
              localObject = a.GoD;
            }
            break;
          case 1: 
            localObject = a.GoE;
            continue;
            localObject = a.GoD;
          }
        }
        break;
      }
    }
    this.Gop.setText(2131757085);
    AppMethodBeat.o(34624);
    return;
    this.Gop.setText(2131757083);
    AppMethodBeat.o(34624);
    return;
    m.a(this.Goy);
    AppMethodBeat.o(34624);
  }
  
  public final void eVK()
  {
    AppMethodBeat.i(34625);
    if (this.Gos == 0)
    {
      this.Gop.setText(2131757092);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.Gos > 99)
    {
      this.Gop.setText(2131757091);
      AppMethodBeat.o(34625);
      return;
    }
    this.Gop.setText(String.format(com.tencent.mm.cd.a.aq(this.mContext, 2131757090), new Object[] { Integer.valueOf(this.Gos) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      GoC = new a("DEFAULT", 0);
      GoD = new a("NEED_DOWNLOAD", 1);
      GoE = new a("DOWNLOADING", 2);
      GoF = new a("NEED_INSTALL", 3);
      GoG = new a("INSTALLED", 4);
      GoH = new a("NO_URL", 5);
      GoI = new a[] { GoC, GoD, GoE, GoF, GoG, GoH };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */