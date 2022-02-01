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
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.s;

public class AttachDownloadPage
  extends MMActivity
{
  private String BqZ;
  private MMImageView BtF;
  private ImageView BtG;
  private ImageView BtH;
  private TextView BtI;
  private LinearLayout BtJ;
  private String BtK;
  private int BtL;
  private boolean BtM = false;
  private String BtN;
  private String BtO;
  private boolean BtP = true;
  private String downloadUrl;
  private TextView gCd;
  private int jpV = 0;
  private long jqG = 0L;
  private TextView nUp;
  private long oJj;
  private ProgressBar progressBar;
  private Button reX;
  private int retryCount = 0;
  private Button thJ;
  private View thM;
  private long ulj;
  
  private void dGU()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", sR(false));
    com.tencent.mm.plugin.qqmail.a.a.jRt.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private String eGA()
  {
    AppMethodBeat.i(122880);
    String str = this.BtK + this.BtN;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void eGB()
  {
    AppMethodBeat.i(122881);
    if (s.YS(sR(true)))
    {
      this.jqG = s.boW(sR(true));
      this.jpV = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (s.YS(sR(false)))
    {
      this.jpV = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (s.YS(eGA()))
    {
      if (s.boW(eGA()) == this.oJj)
      {
        s.bo(this.BtK, this.BtN, eGz());
        this.jpV = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (s.boW(eGA()) > this.oJj)
      {
        s.deleteFile(eGA());
        this.jqG = 0L;
        this.jpV = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.jqG = 0L;
      this.jpV = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.jqG = 0L;
    this.jpV = 0;
    AppMethodBeat.o(122881);
  }
  
  private void eGw()
  {
    AppMethodBeat.i(122873);
    this.thM.setVisibility(0);
    this.reX.setVisibility(8);
    this.thJ.setVisibility(8);
    this.BtG.setVisibility(0);
    this.BtH.setVisibility(8);
    this.BtI.setVisibility(8);
    this.gCd.setVisibility(8);
    this.nUp.setVisibility(8);
    this.BtG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((k)g.ah(k.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122859);
      }
    });
    this.BtH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122860);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AttachDownloadPage.e(AttachDownloadPage.this);
        AttachDownloadPage.f(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122860);
      }
    });
    AppMethodBeat.o(122873);
  }
  
  private void eGx()
  {
    AppMethodBeat.i(122874);
    if (this.BtL == 1)
    {
      if (FileExplorerUI.bfr(this.BtN))
      {
        if (this.jpV == 3)
        {
          dGU();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.jpV == 0) || (this.BtP))
        {
          this.retryCount = 0;
          this.BtP = false;
          eGy();
          eGw();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.thM.setVisibility(8);
      this.gCd.setVisibility(0);
      this.BtI.setVisibility(8);
      this.reX.setVisibility(0);
      this.thJ.setVisibility(8);
      this.nUp.setVisibility(0);
      this.reX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          AttachDownloadPage.g(AttachDownloadPage.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122861);
        }
      });
      if (this.jpV == 3)
      {
        this.gCd.setText(2131762812);
        this.nUp.setText(2131762809);
        this.nUp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122862);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122862);
          }
        });
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.gCd.setText(2131762812);
      if (this.jpV == 2) {
        this.nUp.setText(2131762811);
      }
      for (;;)
      {
        this.nUp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122863);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AttachDownloadPage.h(AttachDownloadPage.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122863);
          }
        });
        AppMethodBeat.o(122874);
        return;
        this.nUp.setText(2131762810);
      }
    }
    if (this.BtL == 0)
    {
      this.thM.setVisibility(8);
      this.reX.setVisibility(8);
      this.thJ.setVisibility(0);
      this.BtI.setVisibility(8);
      this.gCd.setVisibility(0);
      this.nUp.setVisibility(8);
      if (this.jpV != 3) {
        break label380;
      }
      this.thJ.setText(2131762806);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.gCd.setText(2131762805);
      this.thJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122864);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      if (this.jpV == 2) {
        this.thJ.setText(2131762813);
      } else {
        this.thJ.setText(2131762803);
      }
    }
  }
  
  private void eGy()
  {
    AppMethodBeat.i(122876);
    eGB();
    if (this.jpV == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        eGy();
      }
    }
    for (;;)
    {
      String str = sR(true);
      c.b localb = new c.b();
      localb.BqL = false;
      localb.BqM = false;
      Log.i("MicroMsg.AttachDownloadPage", "download attach url %s", new Object[] { this.downloadUrl });
      c.a(this.downloadUrl, str, getIntent().getStringExtra("qqmail_cookie"), new a.a()
      {
        public final void onProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          Log.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void onResult(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(198677);
          if (paramAnonymousBundle != null)
          {
            int i = paramAnonymousBundle.getInt("result_http_code", -1);
            Log.i("MicroMsg.AttachDownloadPage", "result http code %d", new Object[] { Integer.valueOf(i) });
            if (i == 200)
            {
              s.bo(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
              AttachDownloadPage.a(AttachDownloadPage.this, 3);
              Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(2131758392) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
              AttachDownloadPage.d(AttachDownloadPage.this);
              AppMethodBeat.o(198677);
              return;
            }
          }
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(198677);
            return;
          }
          Toast.makeText(AttachDownloadPage.this, 2131762804, 0).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(198677);
        }
      });
      AppMethodBeat.o(122876);
      return;
      eGx();
      continue;
      if (this.jpV == 3)
      {
        s.bo(this.BtK, eGz() + ".temp", eGz());
        this.jpV = 3;
        eGx();
      }
    }
  }
  
  private String eGz()
  {
    AppMethodBeat.i(122878);
    int i = this.BtO.hashCode();
    int j = this.BtN.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.BtN.substring(0, j);
      str2 = this.BtN;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.BtN;
    }
  }
  
  private String sR(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.BtK).append(eGz());
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
    return 2131493159;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122872);
    this.BtF = ((MMImageView)findViewById(2131299790));
    this.thM = findViewById(2131299778);
    this.progressBar = ((ProgressBar)findViewById(2131299776));
    this.BtG = ((ImageView)findViewById(2131299784));
    this.BtH = ((ImageView)findViewById(2131299782));
    this.BtI = ((TextView)findViewById(2131297070));
    this.reX = ((Button)findViewById(2131297072));
    this.thJ = ((Button)findViewById(2131297069));
    this.BtJ = ((LinearLayout)findViewById(2131297068));
    this.gCd = ((TextView)findViewById(2131297071));
    this.nUp = ((TextView)findViewById(2131297073));
    if (FileExplorerUI.bfr(this.BtN)) {
      this.BtF.setBackgroundResource(2131690098);
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
      addIconOptionMenu(0, 2131690907, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(122858);
          paramAnonymousMenuItem = AttachDownloadPage.this;
          String str = AttachDownloadPage.this.getString(2131763947);
          h.d local1 = new h.d()
          {
            public final void oj(int paramAnonymous2Int)
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
      eGB();
      if (this.jpV != 1) {
        break;
      }
      eGw();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.bfs(this.BtN))
      {
        this.BtF.setImageResource(2131689584);
      }
      else
      {
        int i = r.bdt(s.akC(this.BtN));
        if (i > 0) {
          this.BtF.setImageResource(i);
        } else {
          this.BtF.setImageResource(2131689580);
        }
      }
    }
    eGx();
    AppMethodBeat.o(122872);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(122877);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758379, 2131758380, 3);
    AppMethodBeat.o(122877);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(122882);
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    paramConfiguration = (FrameLayout.LayoutParams)this.BtJ.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = at.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.BtJ.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(122882);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = at.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122868);
    super.onCreate(paramBundle);
    this.BtL = getIntent().getIntExtra("is_preview", 0);
    this.BtM = getIntent().getBooleanExtra("is_compress", false);
    this.BtN = getIntent().getStringExtra("attach_name");
    this.BqZ = getIntent().getStringExtra("mail_id");
    this.BtO = getIntent().getStringExtra("attach_id");
    this.downloadUrl = (v.eGq() + getIntent().getStringExtra("attach_url"));
    this.oJj = getIntent().getIntExtra("total_size", 0);
    ((k)g.ah(k.class)).getNormalMailAppService();
    this.BtK = v.getDownloadPath();
    setMMTitle(this.BtN);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((k)g.ah(k.class)).getNormalMailAppService().cancel(this.ulj);
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