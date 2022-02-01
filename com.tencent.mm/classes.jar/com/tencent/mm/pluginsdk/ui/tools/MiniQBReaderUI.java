package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMActivity
{
  private com.tencent.mm.ui.chatting.f.a DFr;
  private boolean DFs;
  private String fBR;
  private String fileName;
  private String filePath;
  private boolean jVs;
  private boolean jVt;
  private ValueCallback<String> jVv;
  private ValueCallback<Integer> jVw;
  private MiniReaderLogic.a<Integer> krH;
  private int oqc;
  private c<ln> oqe;
  private String token;
  private HandOffFile wku;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.fBR = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.jVs = true;
    this.jVt = false;
    this.oqe = new c()
    {
      private boolean a(ln paramAnonymousln)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymousln != null) && (paramAnonymousln.dnv != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!bs.lr(paramAnonymousln.dnv.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            ac.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymousln.dnv.action), paramAnonymousln.dnv.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymousln.dnv.action == 3)
            {
              com.tencent.mm.cq.a.S(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).bcY();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          ac.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousln.dnv.action) });
          switch (paramAnonymousln.dnv.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ga(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).ga(false);
            if (MiniQBReaderUI.d(MiniQBReaderUI.this))
            {
              MiniReaderLogic.a(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), false, "");
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.cq.a.S(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.i(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            p.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new p.a()
            {
              public final void bD(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(196195);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764447, new Object[] { b.aLU(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(196195);
              }
              
              public final void bE(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(196196);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(196196);
              }
            });
            continue;
            ac.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.jVw = new ValueCallback() {};
    this.krH = null;
    this.jVv = new ValueCallback() {};
    this.DFs = false;
    AppMethodBeat.o(31970);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.fBR = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.oqc = getIntent().getIntExtra("sence", 0);
    ac.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.fBR, this.fileName, Integer.valueOf(this.oqc) });
    if (bs.isNullOrNil(this.fileName)) {}
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label409;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        HandOff localHandOff;
        ac.e("MicroMsg.MiniQBReaderUI", "get file name error " + localException.getMessage());
        this.fileName = " ";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.DFr = new com.tencent.mm.ui.chatting.f.a(new e(getContext()));
    this.DFr.h(this.filePath, this.fBR, this.oqc, false);
    this.DFr.lP(this.fBR, this.fileName);
    if (this.oqe != null) {
      this.oqe.alive();
    }
    if (this.DFs) {
      this.DFr.bcX();
    }
    localHandOff = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cSE();
    if ((localHandOff instanceof HandOffFile))
    {
      this.wku = ((HandOffFile)localHandOff);
      this.wku.tBa = 1;
      this.wku.setKey(HandOff.GO(this.wku.tBa));
      this.wku.K(this.DFr.nfN);
      ac.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + localHandOff.key);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(localHandOff);
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31964);
        MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).bGo(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "");
        AppMethodBeat.o(31964);
      }
    });
    AppMethodBeat.o(31972);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31971);
    super.onCreate(paramBundle);
    this.filePath = getIntent().getStringExtra("file_path");
    ac.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new ln();
    paramBundle.dnv.action = 3;
    paramBundle.dnv.filePath = getIntent().getStringExtra("file_path");
    com.tencent.mm.sdk.b.a.GpY.a(paramBundle, Looper.getMainLooper());
    h.JZN.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31963);
        MiniQBReaderUI.j(MiniQBReaderUI.this);
        AppMethodBeat.o(31963);
      }
    }, 300L);
    AppMethodBeat.o(31971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31976);
    ac.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", new Object[] { toString() });
    com.tencent.mm.cq.a.S(this, this.token, this.filePath);
    super.onDestroy();
    if (this.oqe != null) {
      this.oqe.dead();
    }
    if (this.DFr != null) {
      this.DFr.onDestroy();
    }
    if (this.wku != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.wku);
    }
    AppMethodBeat.o(31976);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(31973);
    super.onNewIntent(paramIntent);
    ac.i("MicroMsg.MiniQBReaderUI", "onNewIntent %s", new Object[] { toString() });
    setIntent(paramIntent);
    paramIntent = getIntent().getStringExtra("file_path");
    ac.i("MicroMsg.MiniQBReaderUI", "onNewIntent() newFilePath:%s filePath:%s", new Object[] { paramIntent, this.filePath });
    if (!bs.lr(paramIntent, this.filePath))
    {
      this.jVs = false;
      com.tencent.mm.cq.a.S(this, this.token, this.filePath);
      if (this.DFr != null)
      {
        this.DFr.bcY();
        this.DFr.onDestroy();
      }
      init();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    ac.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.DFr != null)
    {
      this.DFs = false;
      this.DFr.bcY();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    ac.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.DFr != null)
    {
      this.DFr.bcX();
      AppMethodBeat.o(31974);
      return;
    }
    this.DFs = true;
    AppMethodBeat.o(31974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */