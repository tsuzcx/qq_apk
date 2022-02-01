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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.i;

public class AttachDownloadPage
  extends MMActivity
{
  private String downloadUrl;
  private TextView fUR;
  private int irP = 0;
  private long isA = 0L;
  private TextView mCm;
  private long nsQ;
  private Button pHV;
  private ProgressBar progressBar;
  private int retryCount = 0;
  private Button rzR;
  private View rzU;
  private String xbf;
  private long xcO;
  private MMImageView xdL;
  private ImageView xdM;
  private ImageView xdN;
  private TextView xdO;
  private LinearLayout xdP;
  private String xdQ;
  private int xdR;
  private boolean xdS = false;
  private String xdT;
  private String xdU;
  private boolean xdV = true;
  
  private void dCq()
  {
    AppMethodBeat.i(122873);
    this.rzU.setVisibility(0);
    this.pHV.setVisibility(8);
    this.rzR.setVisibility(8);
    this.xdM.setVisibility(0);
    this.xdN.setVisibility(8);
    this.xdO.setVisibility(8);
    this.fUR.setVisibility(8);
    this.mCm.setVisibility(8);
    this.xdM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((k)g.ad(k.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122859);
      }
    });
    this.xdN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122860);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AttachDownloadPage.e(AttachDownloadPage.this);
        AttachDownloadPage.f(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122860);
      }
    });
    AppMethodBeat.o(122873);
  }
  
  private void dCr()
  {
    AppMethodBeat.i(122874);
    if (this.xdR == 1)
    {
      if (FileExplorerUI.aNq(this.xdT))
      {
        if (this.irP == 3)
        {
          dCs();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.irP == 0) || (this.xdV))
        {
          this.retryCount = 0;
          this.xdV = false;
          dCt();
          dCq();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.rzU.setVisibility(8);
      this.fUR.setVisibility(0);
      this.xdO.setVisibility(8);
      this.pHV.setVisibility(0);
      this.rzR.setVisibility(8);
      this.mCm.setVisibility(0);
      this.pHV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          AttachDownloadPage.g(AttachDownloadPage.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122861);
        }
      });
      if (this.irP == 3)
      {
        this.fUR.setText(2131761031);
        this.mCm.setText(2131761028);
        this.mCm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122862);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122862);
          }
        });
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.fUR.setText(2131761031);
      if (this.irP == 2) {
        this.mCm.setText(2131761030);
      }
      for (;;)
      {
        this.mCm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122863);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AttachDownloadPage.h(AttachDownloadPage.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122863);
          }
        });
        AppMethodBeat.o(122874);
        return;
        this.mCm.setText(2131761029);
      }
    }
    if (this.xdR == 0)
    {
      this.rzU.setVisibility(8);
      this.pHV.setVisibility(8);
      this.rzR.setVisibility(0);
      this.xdO.setVisibility(8);
      this.fUR.setVisibility(0);
      this.mCm.setVisibility(8);
      if (this.irP != 3) {
        break label380;
      }
      this.rzR.setText(2131761025);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.fUR.setText(2131761024);
      this.rzR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122864);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      if (this.irP == 2) {
        this.rzR.setText(2131761032);
      } else {
        this.rzR.setText(2131761023);
      }
    }
  }
  
  private void dCs()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", py(false));
    com.tencent.mm.plugin.qqmail.a.a.iRG.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void dCt()
  {
    AppMethodBeat.i(122876);
    dCw();
    if (this.irP == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        dCt();
      }
    }
    for (;;)
    {
      String str = py(true);
      c.b localb = new c.b();
      localb.xaO = false;
      localb.xaP = false;
      ad.i("MicroMsg.AttachDownloadPage", "download attach url %s", new Object[] { this.downloadUrl });
      c.a(this.downloadUrl, str, getIntent().getStringExtra("qqmail_cookie"), new a.a()
      {
        public final void onProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          ad.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void onResult(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(215275);
          if (paramAnonymousBundle != null)
          {
            int i = paramAnonymousBundle.getInt("result_http_code", -1);
            ad.i("MicroMsg.AttachDownloadPage", "result http code %d", new Object[] { Integer.valueOf(i) });
            if (i == 200)
            {
              i.bb(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
              AttachDownloadPage.a(AttachDownloadPage.this, 3);
              Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(2131758120) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
              AttachDownloadPage.d(AttachDownloadPage.this);
              AppMethodBeat.o(215275);
              return;
            }
          }
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(215275);
            return;
          }
          Toast.makeText(AttachDownloadPage.this, 2131767101, 0).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(215275);
        }
      });
      AppMethodBeat.o(122876);
      return;
      dCr();
      continue;
      if (this.irP == 3)
      {
        i.bb(this.xdQ, dCu() + ".temp", dCu());
        this.irP = 3;
        dCr();
      }
    }
  }
  
  private String dCu()
  {
    AppMethodBeat.i(122878);
    int i = this.xdU.hashCode();
    int j = this.xdT.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.xdT.substring(0, j);
      str2 = this.xdT;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.xdT;
    }
  }
  
  private String dCv()
  {
    AppMethodBeat.i(122880);
    String str = this.xdQ + this.xdT;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void dCw()
  {
    AppMethodBeat.i(122881);
    if (i.fv(py(true)))
    {
      this.isA = i.aYo(py(true));
      this.irP = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.fv(py(false)))
    {
      this.irP = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.fv(dCv()))
    {
      if (i.aYo(dCv()) == this.nsQ)
      {
        i.bb(this.xdQ, this.xdT, dCu());
        this.irP = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (i.aYo(dCv()) > this.nsQ)
      {
        i.deleteFile(dCv());
        this.isA = 0L;
        this.irP = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.isA = 0L;
      this.irP = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.isA = 0L;
    this.irP = 0;
    AppMethodBeat.o(122881);
  }
  
  private String py(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.xdQ).append(dCu());
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
    this.xdL = ((MMImageView)findViewById(2131299226));
    this.rzU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.xdM = ((ImageView)findViewById(2131299221));
    this.xdN = ((ImageView)findViewById(2131299219));
    this.xdO = ((TextView)findViewById(2131296961));
    this.pHV = ((Button)findViewById(2131296963));
    this.rzR = ((Button)findViewById(2131296960));
    this.xdP = ((LinearLayout)findViewById(2131296959));
    this.fUR = ((TextView)findViewById(2131296962));
    this.mCm = ((TextView)findViewById(2131296964));
    if (FileExplorerUI.aNq(this.xdT)) {
      this.xdL.setBackgroundResource(2131690066);
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
            public final void lf(int paramAnonymous2Int)
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
      dCw();
      if (this.irP != 1) {
        break;
      }
      dCq();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.aNr(this.xdT))
      {
        this.xdL.setImageResource(2131689581);
      }
      else
      {
        int i = q.aLB(i.ZF(this.xdT));
        if (i > 0) {
          this.xdL.setImageResource(i);
        } else {
          this.xdL.setImageResource(2131689577);
        }
      }
    }
    dCr();
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
    paramConfiguration = (FrameLayout.LayoutParams)this.xdP.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = aq.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.xdP.setLayoutParams(paramConfiguration);
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
    this.xdR = getIntent().getIntExtra("is_preview", 0);
    this.xdS = getIntent().getBooleanExtra("is_compress", false);
    this.xdT = getIntent().getStringExtra("attach_name");
    this.xbf = getIntent().getStringExtra("mail_id");
    this.xdU = getIntent().getStringExtra("attach_id");
    this.downloadUrl = (v.dCk() + getIntent().getStringExtra("attach_url"));
    this.nsQ = getIntent().getIntExtra("total_size", 0);
    ((k)g.ad(k.class)).getNormalMailAppService();
    this.xdQ = v.getDownloadPath();
    setMMTitle(this.xdT);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((k)g.ad(k.class)).getNormalMailAppService().cancel(this.xcO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */