package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.a.a;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.o;

public class AttachDownloadPage
  extends MMActivity
{
  private String downloadUrl;
  private TextView fWX;
  private int iuJ = 0;
  private long ivu = 0L;
  private TextView mHr;
  private long nyl;
  private Button pOz;
  private ProgressBar progressBar;
  private Button rIc;
  private View rIf;
  private int retryCount = 0;
  private String xqW;
  private long xsF;
  private MMImageView xtC;
  private ImageView xtD;
  private ImageView xtE;
  private TextView xtF;
  private LinearLayout xtG;
  private String xtH;
  private int xtI;
  private boolean xtJ = false;
  private String xtK;
  private String xtL;
  private boolean xtM = true;
  
  private void dFH()
  {
    AppMethodBeat.i(122873);
    this.rIf.setVisibility(0);
    this.pOz.setVisibility(8);
    this.rIc.setVisibility(8);
    this.xtD.setVisibility(0);
    this.xtE.setVisibility(8);
    this.xtF.setVisibility(8);
    this.fWX.setVisibility(8);
    this.mHr.setVisibility(8);
    this.xtD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((k)g.ad(k.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122859);
      }
    });
    this.xtE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122860);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AttachDownloadPage.e(AttachDownloadPage.this);
        AttachDownloadPage.f(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122860);
      }
    });
    AppMethodBeat.o(122873);
  }
  
  private void dFI()
  {
    AppMethodBeat.i(122874);
    if (this.xtI == 1)
    {
      if (FileExplorerUI.aON(this.xtK))
      {
        if (this.iuJ == 3)
        {
          dFJ();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.iuJ == 0) || (this.xtM))
        {
          this.retryCount = 0;
          this.xtM = false;
          dFK();
          dFH();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.rIf.setVisibility(8);
      this.fWX.setVisibility(0);
      this.xtF.setVisibility(8);
      this.pOz.setVisibility(0);
      this.rIc.setVisibility(8);
      this.mHr.setVisibility(0);
      this.pOz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          AttachDownloadPage.g(AttachDownloadPage.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122861);
        }
      });
      if (this.iuJ == 3)
      {
        this.fWX.setText(2131761031);
        this.mHr.setText(2131761028);
        this.mHr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122862);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122862);
          }
        });
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.fWX.setText(2131761031);
      if (this.iuJ == 2) {
        this.mHr.setText(2131761030);
      }
      for (;;)
      {
        this.mHr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122863);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AttachDownloadPage.h(AttachDownloadPage.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122863);
          }
        });
        AppMethodBeat.o(122874);
        return;
        this.mHr.setText(2131761029);
      }
    }
    if (this.xtI == 0)
    {
      this.rIf.setVisibility(8);
      this.pOz.setVisibility(8);
      this.rIc.setVisibility(0);
      this.xtF.setVisibility(8);
      this.fWX.setVisibility(0);
      this.mHr.setVisibility(8);
      if (this.iuJ != 3) {
        break label380;
      }
      this.rIc.setText(2131761025);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.fWX.setText(2131761024);
      this.rIc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122864);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (AttachDownloadPage.i(AttachDownloadPage.this) == 3) {
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122864);
            return;
            AttachDownloadPage.h(AttachDownloadPage.this);
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
          }
        }
      });
      AppMethodBeat.o(122874);
      return;
      label380:
      if (this.iuJ == 2) {
        this.rIc.setText(2131761032);
      } else {
        this.rIc.setText(2131761023);
      }
    }
  }
  
  private void dFJ()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", pG(false));
    com.tencent.mm.plugin.qqmail.a.a.iUz.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void dFK()
  {
    AppMethodBeat.i(122876);
    dFN();
    if (this.iuJ == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        dFK();
      }
    }
    for (;;)
    {
      String str = pG(true);
      c.b localb = new c.b();
      localb.xqF = false;
      localb.xqG = false;
      ae.i("MicroMsg.AttachDownloadPage", "download attach url %s", new Object[] { this.downloadUrl });
      c.a(this.downloadUrl, str, getIntent().getStringExtra("qqmail_cookie"), new a.a()
      {
        public final void onProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          ae.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void onResult(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(218021);
          if (paramAnonymousBundle != null)
          {
            int i = paramAnonymousBundle.getInt("result_http_code", -1);
            ae.i("MicroMsg.AttachDownloadPage", "result http code %d", new Object[] { Integer.valueOf(i) });
            if (i == 200)
            {
              o.bc(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
              AttachDownloadPage.a(AttachDownloadPage.this, 3);
              Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(2131758120) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
              AttachDownloadPage.d(AttachDownloadPage.this);
              AppMethodBeat.o(218021);
              return;
            }
          }
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(218021);
            return;
          }
          Toast.makeText(AttachDownloadPage.this, 2131767101, 0).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(218021);
        }
      });
      AppMethodBeat.o(122876);
      return;
      dFI();
      continue;
      if (this.iuJ == 3)
      {
        o.bc(this.xtH, dFL() + ".temp", dFL());
        this.iuJ = 3;
        dFI();
      }
    }
  }
  
  private String dFL()
  {
    AppMethodBeat.i(122878);
    int i = this.xtL.hashCode();
    int j = this.xtK.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.xtK.substring(0, j);
      str2 = this.xtK;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.xtK;
    }
  }
  
  private String dFM()
  {
    AppMethodBeat.i(122880);
    String str = this.xtH + this.xtK;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void dFN()
  {
    AppMethodBeat.i(122881);
    if (o.fB(pG(true)))
    {
      this.ivu = o.aZR(pG(true));
      this.iuJ = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (o.fB(pG(false)))
    {
      this.iuJ = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (o.fB(dFM()))
    {
      if (o.aZR(dFM()) == this.nyl)
      {
        o.bc(this.xtH, this.xtK, dFL());
        this.iuJ = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (o.aZR(dFM()) > this.nyl)
      {
        o.deleteFile(dFM());
        this.ivu = 0L;
        this.iuJ = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.ivu = 0L;
      this.iuJ = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.ivu = 0L;
    this.iuJ = 0;
    AppMethodBeat.o(122881);
  }
  
  private String pG(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.xtH).append(dFL());
    if (!paramBoolean) {}
    for (String str = "";; str = ".temp")
    {
      str = str;
      AppMethodBeat.o(122879);
      return str;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493117;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122872);
    this.xtC = ((MMImageView)findViewById(2131299226));
    this.rIf = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.xtD = ((ImageView)findViewById(2131299221));
    this.xtE = ((ImageView)findViewById(2131299219));
    this.xtF = ((TextView)findViewById(2131296961));
    this.pOz = ((Button)findViewById(2131296963));
    this.rIc = ((Button)findViewById(2131296960));
    this.xtG = ((LinearLayout)findViewById(2131296959));
    this.fWX = ((TextView)findViewById(2131296962));
    this.mHr = ((TextView)findViewById(2131296964));
    if (FileExplorerUI.aON(this.xtK)) {
      this.xtC.setBackgroundResource(2131690066);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(122856);
          AttachDownloadPage.this.finish();
          AppMethodBeat.o(122856);
          return true;
        }
      });
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(122858);
          paramAnonymousMenuItem = AttachDownloadPage.this;
          String str = AttachDownloadPage.this.getString(2131761941);
          h.c local1 = new h.c()
          {
            public final void lh(int paramAnonymous2Int)
            {
              AppMethodBeat.i(122857);
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(122857);
                return;
                AttachDownloadPage.a(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
              }
            }
          };
          h.b(paramAnonymousMenuItem, "", new String[] { str }, "", local1);
          AppMethodBeat.o(122858);
          return true;
        }
      });
      enableOptionMenu(false);
      dFN();
      if (this.iuJ != 1) {
        break;
      }
      dFH();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.aOO(this.xtK))
      {
        this.xtC.setImageResource(2131689581);
      }
      else
      {
        int i = q.aMX(o.aaw(this.xtK));
        if (i > 0) {
          this.xtC.setImageResource(i);
        } else {
          this.xtC.setImageResource(2131689577);
        }
      }
    }
    dFI();
    AppMethodBeat.o(122872);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(122877);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758111, 2131758112, 3);
    AppMethodBeat.o(122877);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(122882);
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    paramConfiguration = (FrameLayout.LayoutParams)this.xtG.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = aq.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.xtG.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(122882);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = aq.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122868);
    super.onCreate(paramBundle);
    this.xtI = getIntent().getIntExtra("is_preview", 0);
    this.xtJ = getIntent().getBooleanExtra("is_compress", false);
    this.xtK = getIntent().getStringExtra("attach_name");
    this.xqW = getIntent().getStringExtra("mail_id");
    this.xtL = getIntent().getStringExtra("attach_id");
    this.downloadUrl = (v.dFB() + getIntent().getStringExtra("attach_url"));
    this.nyl = getIntent().getIntExtra("total_size", 0);
    ((k)g.ad(k.class)).getNormalMailAppService();
    this.xtH = v.getDownloadPath();
    setMMTitle(this.xtK);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((k)g.ad(k.class)).getNormalMailAppService().cancel(this.xsF);
    AppMethodBeat.o(122871);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(122870);
    super.onPause();
    AppMethodBeat.o(122870);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122869);
    super.onResume();
    AppMethodBeat.o(122869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */