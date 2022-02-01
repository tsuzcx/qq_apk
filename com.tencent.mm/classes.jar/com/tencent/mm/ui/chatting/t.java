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
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.pluginsdk.ui.tools.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
{
  public ChatFooterCustom HOd;
  public FrameLayout HOe;
  public FrameLayout HOf;
  public TextView HOg;
  public ImageView HOh;
  a HOi;
  public int HOj;
  public boolean HOk;
  String HOl;
  public String HOm;
  public View.OnClickListener HOn;
  public View.OnClickListener HOo;
  private m.a HOp;
  Context mContext;
  long pCa;
  public LinearLayout plH;
  SharedPreferences sp;
  public String vZG;
  String vZH;
  String vZI;
  
  public t(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34622);
    this.plH = null;
    this.HOi = a.HOt;
    this.HOj = -1;
    this.HOl = null;
    this.pCa = -1L;
    this.HOn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34609);
        new Intent().putExtra("composeType", 1);
        d.N(t.this.mContext, "qqmail", ".ui.ComposeUI");
        AppMethodBeat.o(34609);
      }
    };
    this.HOo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34610);
        switch (t.8.HOs[t.this.HOi.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.f(11288, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = t.this;
          if (!ax.isConnected(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView.mContext, com.tencent.mm.cc.a.aw(paramAnonymousView.mContext, 2131757089), "", com.tencent.mm.cc.a.aw(paramAnonymousView.mContext, 2131757084), null);
            AppMethodBeat.o(34610);
            return;
          }
          if (!ax.isWifi(paramAnonymousView.mContext))
          {
            com.tencent.mm.ui.base.h.b(paramAnonymousView.mContext, 2131757086, 0, 2131757082, 2131757081, new t.3(paramAnonymousView), null);
            AppMethodBeat.o(34610);
            return;
          }
          com.tencent.mm.ui.base.h.b(paramAnonymousView.mContext, 2131757087, 0, 2131757082, 2131757081, new t.4(paramAnonymousView), null);
          AppMethodBeat.o(34610);
          return;
          paramAnonymousView = t.this;
          ac.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
          f.bXJ().rS(paramAnonymousView.pCa);
          paramAnonymousView.flv();
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.f(11288, new Object[] { Integer.valueOf(7) });
          paramAnonymousView = t.this;
          ac.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
          com.tencent.mm.pluginsdk.g.i.aH(paramAnonymousView.mContext, paramAnonymousView.HOl);
          AppMethodBeat.o(34610);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.f(11288, new Object[] { Integer.valueOf(5) });
          t localt = t.this;
          ac.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
          ac.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localt.HOm });
          if (bs.isNullOrNil(localt.HOm)) {
            paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
          }
          for (;;)
          {
            ac.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramAnonymousView });
            com.tencent.mm.ci.a.post(new t.5(localt, paramAnonymousView));
            AppMethodBeat.o(34610);
            return;
            Intent localIntent = new Intent();
            localIntent.setData(Uri.parse(localt.HOm));
            localIntent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 11) {
              localIntent.addFlags(32768);
            }
            paramAnonymousView = localIntent;
            if (!bs.ah(localt.mContext, localIntent)) {
              paramAnonymousView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
            }
          }
          if (t.this.HOk) {
            t.a(t.this);
          }
        }
      }
    };
    this.HOp = new m.a()
    {
      public final void drR()
      {
        AppMethodBeat.i(34617);
        t.this.HOg.setText(2131757092);
        AppMethodBeat.o(34617);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(34616);
        t.this.HOj = paramAnonymousInt;
        t.this.flw();
        AppMethodBeat.o(34616);
      }
    };
    this.mContext = paramChatFooterCustom.getContext();
    this.HOd = paramChatFooterCustom;
    AppMethodBeat.o(34622);
  }
  
  public final void flu()
  {
    AppMethodBeat.i(34623);
    if (this.HOi == a.HOx)
    {
      this.HOh.setImageResource(2131691054);
      AppMethodBeat.o(34623);
      return;
    }
    this.HOh.setImageResource(2131691055);
    AppMethodBeat.o(34623);
  }
  
  public final void flv()
  {
    AppMethodBeat.i(34624);
    Object localObject;
    if (q.t(this.mContext, "com.tencent.androidqqmail")) {
      localObject = a.HOx;
    }
    for (;;)
    {
      this.HOi = ((a)localObject);
      flu();
      ac.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.HOi.toString() });
      switch (8.HOs[this.HOi.ordinal()])
      {
      default: 
        m.a(this.HOp);
        AppMethodBeat.o(34624);
        return;
        this.sp = this.mContext.getSharedPreferences("QQMAIL", g.YK());
        this.pCa = this.sp.getLong("qqmail_downloadid", -1L);
        if (this.pCa < 0L)
        {
          if (bs.isNullOrNil(this.vZG)) {
            localObject = a.HOy;
          } else {
            localObject = a.HOu;
          }
        }
        else
        {
          localObject = f.bXJ().rT(this.pCa);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.HOl = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bs.isNullOrNil(this.vZG)) {
              localObject = a.HOy;
            }
            break;
          case 3: 
            if (com.tencent.mm.vfs.i.eA(this.HOl)) {
              localObject = a.HOw;
            } else if (bs.isNullOrNil(this.vZG)) {
              localObject = a.HOy;
            } else {
              localObject = a.HOu;
            }
            break;
          case 1: 
            localObject = a.HOv;
            continue;
            localObject = a.HOu;
          }
        }
        break;
      }
    }
    this.HOg.setText(2131757085);
    AppMethodBeat.o(34624);
    return;
    this.HOg.setText(2131757083);
    AppMethodBeat.o(34624);
    return;
    m.a(this.HOp);
    AppMethodBeat.o(34624);
  }
  
  public final void flw()
  {
    AppMethodBeat.i(34625);
    if (this.HOj == 0)
    {
      this.HOg.setText(2131757092);
      AppMethodBeat.o(34625);
      return;
    }
    if (this.HOj > 99)
    {
      this.HOg.setText(2131757091);
      AppMethodBeat.o(34625);
      return;
    }
    this.HOg.setText(String.format(com.tencent.mm.cc.a.aw(this.mContext, 2131757090), new Object[] { Integer.valueOf(this.HOj) }));
    AppMethodBeat.o(34625);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(34621);
      HOt = new a("DEFAULT", 0);
      HOu = new a("NEED_DOWNLOAD", 1);
      HOv = new a("DOWNLOADING", 2);
      HOw = new a("NEED_INSTALL", 3);
      HOx = new a("INSTALLED", 4);
      HOy = new a("NO_URL", 5);
      HOz = new a[] { HOt, HOu, HOv, HOw, HOx, HOy };
      AppMethodBeat.o(34621);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */