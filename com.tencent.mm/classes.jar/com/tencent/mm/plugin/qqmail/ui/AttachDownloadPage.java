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
import com.tencent.mm.plugin.qqmail.b.a.a;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.u;

public class AttachDownloadPage
  extends MMActivity
{
  private String Hls;
  private MMImageView HnZ;
  private ImageView Hoa;
  private ImageView Hob;
  private TextView Hoc;
  private LinearLayout Hod;
  private String Hoe;
  private int Hof;
  private boolean Hog = false;
  private String Hoh;
  private String Hoi;
  private boolean Hoj = true;
  private String downloadUrl;
  private TextView jmj;
  private int mfw = 0;
  private long mgh = 0L;
  private ProgressBar progressBar;
  private TextView qVN;
  private long rKZ;
  private int retryCount = 0;
  private Button uId;
  private Button wOa;
  private View wOd;
  private long yjR;
  
  private void eiT()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", wl(false));
    com.tencent.mm.plugin.qqmail.a.a.mIG.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void fsA()
  {
    AppMethodBeat.i(122874);
    if (this.Hof == 1)
    {
      if (FileExplorerUI.brM(this.Hoh))
      {
        if (this.mfw == 3)
        {
          eiT();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.mfw == 0) || (this.Hoj))
        {
          this.retryCount = 0;
          this.Hoj = false;
          fsB();
          fsz();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.wOd.setVisibility(8);
      this.jmj.setVisibility(0);
      this.Hoc.setVisibility(8);
      this.uId.setVisibility(0);
      this.wOa.setVisibility(8);
      this.qVN.setVisibility(0);
      this.uId.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          AttachDownloadPage.g(AttachDownloadPage.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122861);
        }
      });
      if (this.mfw == 3)
      {
        this.jmj.setText(e.i.mail_attach_preview_status);
        this.qVN.setText(e.i.mail_attach_preview_open_downloaded);
        this.qVN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122862);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122862);
          }
        });
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.jmj.setText(e.i.mail_attach_preview_status);
      if (this.mfw == 2) {
        this.qVN.setText(e.i.mail_attach_preview_open_redownload);
      }
      for (;;)
      {
        this.qVN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122863);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AttachDownloadPage.h(AttachDownloadPage.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122863);
          }
        });
        AppMethodBeat.o(122874);
        return;
        this.qVN.setText(e.i.mail_attach_preview_open_notdownload);
      }
    }
    if (this.Hof == 0)
    {
      this.wOd.setVisibility(8);
      this.uId.setVisibility(8);
      this.wOa.setVisibility(0);
      this.Hoc.setVisibility(8);
      this.jmj.setVisibility(0);
      this.qVN.setVisibility(8);
      if (this.mfw != 3) {
        break label380;
      }
      this.wOa.setText(e.i.mail_attach_downloaded);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.jmj.setText(e.i.mail_attach_download_status);
      this.wOa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122864);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      if (this.mfw == 2) {
        this.wOa.setText(e.i.mail_attach_redownload);
      } else {
        this.wOa.setText(e.i.mail_attach_download);
      }
    }
  }
  
  private void fsB()
  {
    AppMethodBeat.i(122876);
    fsE();
    if (this.mfw == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        fsB();
      }
    }
    for (;;)
    {
      String str = wl(true);
      c.b localb = new c.b();
      localb.Hle = false;
      localb.Hlf = false;
      Log.i("MicroMsg.AttachDownloadPage", "download attach url %s", new Object[] { this.downloadUrl });
      c.a(this.downloadUrl, str, getIntent().getStringExtra("qqmail_cookie"), new a.a()
      {
        public final void abM(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          Log.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void ao(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(250014);
          if (paramAnonymousBundle != null)
          {
            int i = paramAnonymousBundle.getInt("result_http_code", -1);
            Log.i("MicroMsg.AttachDownloadPage", "result http code %d", new Object[] { Integer.valueOf(i) });
            if (i == 200)
            {
              u.bj(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
              AttachDownloadPage.a(AttachDownloadPage.this, 3);
              Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(e.i.download_success) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
              AttachDownloadPage.d(AttachDownloadPage.this);
              AppMethodBeat.o(250014);
              return;
            }
          }
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(250014);
            return;
          }
          Toast.makeText(AttachDownloadPage.this, e.i.mail_attach_download_failed, 0).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(250014);
        }
      });
      AppMethodBeat.o(122876);
      return;
      fsA();
      continue;
      if (this.mfw == 3)
      {
        u.bj(this.Hoe, fsC() + ".temp", fsC());
        this.mfw = 3;
        fsA();
      }
    }
  }
  
  private String fsC()
  {
    AppMethodBeat.i(122878);
    int i = this.Hoi.hashCode();
    int j = this.Hoh.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.Hoh.substring(0, j);
      str2 = this.Hoh;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.Hoh;
    }
  }
  
  private String fsD()
  {
    AppMethodBeat.i(122880);
    String str = this.Hoe + this.Hoh;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void fsE()
  {
    AppMethodBeat.i(122881);
    if (u.agG(wl(true)))
    {
      this.mgh = u.bBQ(wl(true));
      this.mfw = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (u.agG(wl(false)))
    {
      this.mfw = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (u.agG(fsD()))
    {
      if (u.bBQ(fsD()) == this.rKZ)
      {
        u.bj(this.Hoe, this.Hoh, fsC());
        this.mfw = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (u.bBQ(fsD()) > this.rKZ)
      {
        u.deleteFile(fsD());
        this.mgh = 0L;
        this.mfw = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.mgh = 0L;
      this.mfw = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.mgh = 0L;
    this.mfw = 0;
    AppMethodBeat.o(122881);
  }
  
  private void fsz()
  {
    AppMethodBeat.i(122873);
    this.wOd.setVisibility(0);
    this.uId.setVisibility(8);
    this.wOa.setVisibility(8);
    this.Hoa.setVisibility(0);
    this.Hob.setVisibility(8);
    this.Hoc.setVisibility(8);
    this.jmj.setVisibility(8);
    this.qVN.setVisibility(8);
    this.Hoa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122859);
      }
    });
    this.Hob.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122860);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AttachDownloadPage.e(AttachDownloadPage.this);
        AttachDownloadPage.f(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122860);
      }
    });
    AppMethodBeat.o(122873);
  }
  
  private String wl(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.Hoe).append(fsC());
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
    return e.f.attach_download_page;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122872);
    this.HnZ = ((MMImageView)findViewById(e.e.download_type_icon));
    this.wOd = findViewById(e.e.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(e.e.download_pb));
    this.Hoa = ((ImageView)findViewById(e.e.download_stop_btn));
    this.Hob = ((ImageView)findViewById(e.e.download_restart_btn));
    this.Hoc = ((TextView)findViewById(e.e.attach_download_speed_tv));
    this.uId = ((Button)findViewById(e.e.attach_preview_btn));
    this.wOa = ((Button)findViewById(e.e.attach_download_btn));
    this.Hod = ((LinearLayout)findViewById(e.e.attach_bottom_ll));
    this.jmj = ((TextView)findViewById(e.e.attach_download_status_tv));
    this.qVN = ((TextView)findViewById(e.e.attach_try_open_tv));
    if (FileExplorerUI.brM(this.Hoh)) {
      this.HnZ.setBackgroundResource(e.h.download_image_icon);
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
      addIconOptionMenu(0, e.h.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(122858);
          paramAnonymousMenuItem = AttachDownloadPage.this;
          String str = AttachDownloadPage.this.getString(e.i.plugin_favorite_opt);
          h.d local1 = new h.d()
          {
            public final void qy(int paramAnonymous2Int)
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
          com.tencent.mm.ui.base.h.b(paramAnonymousMenuItem, "", new String[] { str }, "", local1);
          AppMethodBeat.o(122858);
          return true;
        }
      });
      enableOptionMenu(false);
      fsE();
      if (this.mfw != 1) {
        break;
      }
      fsz();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.brN(this.Hoh))
      {
        this.HnZ.setImageResource(e.h.app_attach_file_icon_video);
      }
      else
      {
        int i = com.tencent.mm.pluginsdk.model.v.bpJ(u.asq(this.Hoh));
        if (i > 0) {
          this.HnZ.setImageResource(i);
        } else {
          this.HnZ.setImageResource(e.h.app_attach_file_icon_unknow);
        }
      }
    }
    fsA();
    AppMethodBeat.o(122872);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(122877);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, e.i.download_no_match_msg, e.i.download_no_match_title, 3);
    AppMethodBeat.o(122877);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(122882);
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    paramConfiguration = (FrameLayout.LayoutParams)this.Hod.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = aw.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.Hod.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(122882);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = aw.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122868);
    super.onCreate(paramBundle);
    this.Hof = getIntent().getIntExtra("is_preview", 0);
    this.Hog = getIntent().getBooleanExtra("is_compress", false);
    this.Hoh = getIntent().getStringExtra("attach_name");
    this.Hls = getIntent().getStringExtra("mail_id");
    this.Hoi = getIntent().getStringExtra("attach_id");
    this.downloadUrl = (com.tencent.mm.plugin.qqmail.d.v.fss() + getIntent().getStringExtra("attach_url"));
    this.rKZ = getIntent().getIntExtra("total_size", 0);
    ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService();
    this.Hoe = com.tencent.mm.plugin.qqmail.d.v.fst();
    setMMTitle(this.Hoh);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().cancel(this.yjR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */