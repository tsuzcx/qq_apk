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
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMActivity
{
  private com.tencent.mm.ui.chatting.f.a CmZ;
  private boolean Cna;
  private String fileName;
  private String filePath;
  private String fyk;
  private MiniReaderLogic.a<Integer> jQW;
  private boolean juX;
  private boolean juY;
  private ValueCallback<String> jva;
  private ValueCallback<Integer> jvb;
  private int nNc;
  private c<le> nNe;
  private String token;
  private HandOffFile vbG;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.fyk = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.juX = true;
    this.juY = false;
    this.nNe = new c()
    {
      private boolean a(le paramAnonymousle)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymousle != null) && (paramAnonymousle.dpK != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!bt.kU(paramAnonymousle.dpK.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            ad.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymousle.dpK.action), paramAnonymousle.dpK.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymousle.dpK.action == 3)
            {
              com.tencent.mm.cr.a.T(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).aWa();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          ad.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymousle.dpK.action) });
          switch (paramAnonymousle.dpK.action)
          {
          default: 
            break;
          case 1: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).fE(true);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).fE(false);
            if (MiniQBReaderUI.d(MiniQBReaderUI.this))
            {
              MiniReaderLogic.a(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), false, "");
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.cr.a.T(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.i(MiniQBReaderUI.this));
              continue;
              ad.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
            }
            break;
          }
        }
      }
    };
    this.jvb = new MiniQBReaderUI.4(this);
    this.jQW = null;
    this.jva = new ValueCallback() {};
    this.Cna = false;
    AppMethodBeat.o(31970);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.fyk = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.nNc = getIntent().getIntExtra("sence", 0);
    ad.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.fyk, this.fileName, Integer.valueOf(this.nNc) });
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
    this.CmZ = new com.tencent.mm.ui.chatting.f.a(new e(getContext()));
    this.CmZ.h(this.filePath, this.fyk, this.nNc, false);
    this.CmZ.ls(this.fyk, this.fileName);
    if (this.nNe != null) {
      this.nNe.alive();
    }
    if (this.Cna) {
      this.CmZ.aVZ();
    }
    localHandOff = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cFu();
    if ((localHandOff instanceof HandOffFile))
    {
      this.vbG = ((HandOffFile)localHandOff);
      this.vbG.stk = 1;
      this.vbG.setKey(HandOff.ES(this.vbG.stk));
      this.vbG.K(this.CmZ.mDH);
      ad.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + localHandOff.key);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(localHandOff);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31964);
        MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).bzs(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "");
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
    ad.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new le();
    paramBundle.dpK.action = 3;
    paramBundle.dpK.filePath = getIntent().getStringExtra("file_path");
    com.tencent.mm.sdk.b.a.ESL.a(paramBundle, Looper.getMainLooper());
    h.Iye.q(new Runnable()
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
    com.tencent.mm.cr.a.T(this, this.token, this.filePath);
    super.onDestroy();
    if (this.nNe != null) {
      this.nNe.dead();
    }
    if (this.CmZ != null) {
      this.CmZ.onDestroy();
    }
    if (this.vbG != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.vbG);
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
    if (!bt.kU(paramIntent, this.filePath))
    {
      this.juX = false;
      com.tencent.mm.cr.a.T(this, this.token, this.filePath);
      if (this.CmZ != null)
      {
        this.CmZ.aWa();
        this.CmZ.onDestroy();
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
    if (this.CmZ != null)
    {
      this.Cna = false;
      this.CmZ.aWa();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    ad.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.CmZ != null)
    {
      this.CmZ.aVZ();
      AppMethodBeat.o(31974);
      return;
    }
    this.Cna = true;
    AppMethodBeat.o(31974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */