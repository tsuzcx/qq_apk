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
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.lx.a;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.miniutil.MiniReaderLogic.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMActivity
{
  private com.tencent.mm.ui.chatting.g.a FCU;
  private boolean FCV;
  private String fXl;
  private String fileName;
  private String filePath;
  private MiniReaderLogic.a<Integer> kQA;
  private boolean ksV;
  private boolean ksW;
  private ValueCallback<String> ksY;
  private ValueCallback<Integer> ksZ;
  private int oZZ;
  private c<lx> pab;
  private String token;
  private HandOffFile xIl;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(31970);
    this.filePath = "";
    this.fXl = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    this.ksV = true;
    this.ksW = false;
    this.pab = new c()
    {
      private boolean a(lx paramAnonymouslx)
      {
        AppMethodBeat.i(31961);
        if ((paramAnonymouslx != null) && (paramAnonymouslx.dAo != null) && (MiniQBReaderUI.a(MiniQBReaderUI.this) != null)) {
          if (!bu.lX(paramAnonymouslx.dAo.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this)))
          {
            ae.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s event.data.filePath:%s filePath:%s", new Object[] { Integer.valueOf(paramAnonymouslx.dAo.action), paramAnonymouslx.dAo.filePath, MiniQBReaderUI.b(MiniQBReaderUI.this) });
            if (paramAnonymouslx.dAo.action == 3)
            {
              com.tencent.mm.cp.a.V(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              if (MiniQBReaderUI.a(MiniQBReaderUI.this) != null) {
                MiniQBReaderUI.a(MiniQBReaderUI.this).bhk();
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31961);
          return false;
          ae.i("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent event.data.action:%s", new Object[] { Integer.valueOf(paramAnonymouslx.dAo.action) });
          switch (paramAnonymouslx.dAo.action)
          {
          case 3: 
          default: 
            break;
          case 1: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).o(true, 2);
            break;
          case 2: 
            MiniQBReaderUI.a(MiniQBReaderUI.this).o(false, 2);
            if (MiniQBReaderUI.d(MiniQBReaderUI.this))
            {
              MiniReaderLogic.a(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.h(MiniQBReaderUI.this), false, "");
            }
            else
            {
              MiniQBReaderUI.a(MiniQBReaderUI.this, false);
              com.tencent.mm.cp.a.V(MiniQBReaderUI.this, MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this));
              MiniReaderLogic.a(false, false, MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, false), MiniQBReaderUI.i(MiniQBReaderUI.this));
            }
            break;
          case 4: 
            p.c(MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), new p.a()
            {
              public final void bF(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(186822);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764447, new Object[] { b.aSY(paramAnonymous2String2) }), 1).show();
                AppMethodBeat.o(186822);
              }
              
              public final void bG(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(186823);
                Toast.makeText(MiniQBReaderUI.this, MiniQBReaderUI.this.getString(2131764446), 1).show();
                AppMethodBeat.o(186823);
              }
            });
            continue;
            ae.e("MicroMsg.MiniQBReaderUI", "MiniQbFloatBallMenuActionEvent fail");
          }
        }
      }
    };
    this.ksZ = new ValueCallback() {};
    this.kQA = null;
    this.ksY = new ValueCallback() {};
    this.FCV = false;
    AppMethodBeat.o(31970);
  }
  
  private void init()
  {
    AppMethodBeat.i(31972);
    this.filePath = getIntent().getStringExtra("file_path");
    this.fXl = getIntent().getStringExtra("file_ext");
    this.fileName = getIntent().getStringExtra("file_name");
    this.oZZ = getIntent().getIntExtra("sence", 0);
    ae.i("MicroMsg.MiniQBReaderUI", "init() filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { this.filePath, this.fXl, this.fileName, Integer.valueOf(this.oZZ) });
    if (bu.isNullOrNil(this.fileName)) {}
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
        ae.e("MicroMsg.MiniQBReaderUI", "get file name error " + localException.getMessage());
        this.fileName = " ";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    this.FCU = new com.tencent.mm.ui.chatting.g.a(new e(getContext()));
    this.FCU.h(this.filePath, this.fXl, this.oZZ, false);
    this.FCU.mu(this.fXl, this.fileName);
    if (this.pab != null) {
      this.pab.alive();
    }
    if (this.FCV) {
      this.FCU.bhj();
    }
    localHandOff = ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).deC();
    if ((localHandOff instanceof HandOffFile))
    {
      this.xIl = ((HandOffFile)localHandOff);
      this.xIl.uPo = 1;
      this.xIl.setKey(HandOff.II(this.xIl.uPo));
      this.xIl.N(this.FCU.nLK);
      ae.i("MicroMsg.MiniQBReaderUI", "[handoff] Call onFileCreate, key = " + localHandOff.key);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(localHandOff);
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31964);
        MiniReaderLogic.a(MiniQBReaderUI.a(MiniQBReaderUI.this).bLw(), MiniQBReaderUI.this, MiniQBReaderUI.b(MiniQBReaderUI.this), MiniQBReaderUI.e(MiniQBReaderUI.this), MiniQBReaderUI.f(MiniQBReaderUI.this), MiniQBReaderUI.c(MiniQBReaderUI.this), MiniQBReaderUI.g(MiniQBReaderUI.this), MiniQBReaderUI.b(MiniQBReaderUI.this, true), false, "");
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
    ae.i("MicroMsg.MiniQBReaderUI", "onCreate filePath:%s %s", new Object[] { this.filePath, toString() });
    paramBundle = new lx();
    paramBundle.dAo.action = 3;
    paramBundle.dAo.filePath = getIntent().getStringExtra("file_path");
    com.tencent.mm.sdk.b.a.IvT.a(paramBundle, Looper.getMainLooper());
    h.MqF.r(new Runnable()
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
    ae.i("MicroMsg.MiniQBReaderUI", "onDestroy %s", new Object[] { toString() });
    com.tencent.mm.cp.a.V(this, this.token, this.filePath);
    super.onDestroy();
    if (this.pab != null) {
      this.pab.dead();
    }
    if (this.FCU != null) {
      this.FCU.onDestroy();
    }
    if (this.xIl != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.xIl);
    }
    AppMethodBeat.o(31976);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(31973);
    super.onNewIntent(paramIntent);
    ae.i("MicroMsg.MiniQBReaderUI", "onNewIntent %s", new Object[] { toString() });
    setIntent(paramIntent);
    paramIntent = getIntent().getStringExtra("file_path");
    ae.i("MicroMsg.MiniQBReaderUI", "onNewIntent() newFilePath:%s filePath:%s", new Object[] { paramIntent, this.filePath });
    if (!bu.lX(paramIntent, this.filePath))
    {
      this.ksV = false;
      com.tencent.mm.cp.a.V(this, this.token, this.filePath);
      if (this.FCU != null)
      {
        this.FCU.bhk();
        this.FCU.onDestroy();
      }
      init();
    }
    AppMethodBeat.o(31973);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(31975);
    ae.i("MicroMsg.MiniQBReaderUI", "onPause %s", new Object[] { toString() });
    super.onPause();
    if (this.FCU != null)
    {
      this.FCV = false;
      this.FCU.bhk();
    }
    AppMethodBeat.o(31975);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31974);
    ae.i("MicroMsg.MiniQBReaderUI", "onResume %s", new Object[] { toString() });
    super.onResume();
    if (this.FCU != null)
    {
      this.FCU.bhj();
      AppMethodBeat.o(31974);
      return;
    }
    this.FCV = true;
    AppMethodBeat.o(31974);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */