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
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMActivity
{
  private com.tencent.mm.ui.chatting.g.a Fkw;
  private boolean Fkx;
  private String fVf;
  private String fileName;
  private String filePath;
  private MiniReaderLogic.a<Integer> kNd;
  private boolean kpG;
  private boolean kpH;
  private ValueCallback<String> kpJ;
  private ValueCallback<Integer> kpK;
  private int oTx;
  private c<lw> oTz;
  private String token;
  private HandOffFile xso;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.fVf = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.kpG = true;
    this.kpH = false;
    this.oTz = new c()
    {
      private boolean a(lw paramAnonymouslw)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymouslw != null) && (paramAnonymouslw.dzj != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!bt.lQ(paramAnonymouslw.dzj.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            ad.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymouslw.dzj.action), paramAnonymouslw.dzj.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymouslw.dzj.action == 3)
            {
              com.tencent.mm.cq.a.V(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).bgC();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          ad.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymouslw.dzj.action) });
          switch (paramAnonymouslw.dzj.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).gf(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).gf(false);
            if (MiniQBReaderUI.d(MiniQBReaderUI.this))
            {
              MiniReaderLogic.a(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), false, "");
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.cq.a.V(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.i(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            p.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new p.a()
            {
              public final void bF(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(193536);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764447, new Object[] { b.aRB(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(193536);
              }
              
              public final void bG(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(193537);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(193537);
              }
            });
            continue;
            ad.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.kpK = new ValueCallback() {};
    this.kNd = null;
    this.kpJ = new ValueCallback() {};
    this.Fkx = false;
    AppMethodBeat.o(31970);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.fVf = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.oTx = getIntent().getIntExtra("sence", 0);
    ad.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.fVf, this.fileName, Integer.valueOf(this.oTx) });
    if (bt.isNullOrNil(this.fileName)) {}
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
        ad.e("MicroMsg.MiniQBReaderUI", "get file name error " + localException.getMessage());
        this.fileName = " ";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.Fkw = new com.tencent.mm.ui.chatting.g.a(new e(getContext()));
    this.Fkw.h(this.filePath, this.fVf, this.oTx, false);
    this.Fkw.mn(this.fVf, this.fileName);
    if (this.oTz != null) {
      this.oTz.alive();
    }
    if (this.Fkx) {
      this.Fkw.bgB();
    }
    localHandOff = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).dbL();
    if ((localHandOff instanceof HandOffFile))
    {
      this.xso = ((HandOffFile)localHandOff);
      this.xso.uDJ = 1;
      this.xso.setKey(HandOff.Ik(this.xso.uDJ));
      this.xso.L(this.Fkw.nGj);
      ad.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + localHandOff.key);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(localHandOff);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31964);
        MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).bKz(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "");
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
    ad.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new lw();
    paramBundle.dzj.action = 3;
    paramBundle.dzj.filePath = getIntent().getStringExtra("file_path");
    com.tencent.mm.sdk.b.a.IbL.a(paramBundle, Looper.getMainLooper());
    h.LTJ.r(new Runnable()
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
    ad.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", new Object[] { toString() });
    com.tencent.mm.cq.a.V(this, this.token, this.filePath);
    super.onDestroy();
    if (this.oTz != null) {
      this.oTz.dead();
    }
    if (this.Fkw != null) {
      this.Fkw.onDestroy();
    }
    if (this.xso != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.xso);
    }
    AppMethodBeat.o(31976);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(31973);
    super.onNewIntent(paramIntent);
    ad.i("MicroMsg.MiniQBReaderUI", "onNewIntent %s", new Object[] { toString() });
    setIntent(paramIntent);
    paramIntent = getIntent().getStringExtra("file_path");
    ad.i("MicroMsg.MiniQBReaderUI", "onNewIntent() newFilePath:%s filePath:%s", new Object[] { paramIntent, this.filePath });
    if (!bt.lQ(paramIntent, this.filePath))
    {
      this.kpG = false;
      com.tencent.mm.cq.a.V(this, this.token, this.filePath);
      if (this.Fkw != null)
      {
        this.Fkw.bgC();
        this.Fkw.onDestroy();
      }
      init();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    ad.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.Fkw != null)
    {
      this.Fkx = false;
      this.Fkw.bgC();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    ad.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.Fkw != null)
    {
      this.Fkw.bgB();
      AppMethodBeat.o(31974);
      return;
    }
    this.Fkx = true;
    AppMethodBeat.o(31974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */