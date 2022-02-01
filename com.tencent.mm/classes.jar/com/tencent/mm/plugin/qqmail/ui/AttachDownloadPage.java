package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.b.a.a;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bd;
import com.tencent.mm.vfs.y;

public class AttachDownloadPage
  extends MMActivity
{
  private Button AkC;
  private View AkF;
  private long Bjl;
  private String Njg;
  private MMImageView NlM;
  private ImageView NlN;
  private ImageView NlO;
  private TextView NlP;
  private LinearLayout NlQ;
  private String NlR;
  private int NlS;
  private boolean NlT = false;
  private String NlU;
  private String NlV;
  private boolean NlW = true;
  private String downloadUrl;
  private TextView lPf;
  private int oYs = 0;
  private long oZd = 0L;
  private ProgressBar progressBar;
  private int retryCount = 0;
  private long uWn;
  private TextView ubv;
  private Button xQS;
  
  private String AL(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.NlR).append(gEl());
    if (!paramBoolean) {}
    for (String str = "";; str = ".temp")
    {
      str = str;
      AppMethodBeat.o(122879);
      return str;
    }
  }
  
  private void fkW()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", AL(false));
    com.tencent.mm.plugin.qqmail.a.a.pFn.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void gEi()
  {
    AppMethodBeat.i(122873);
    this.AkF.setVisibility(0);
    this.xQS.setVisibility(8);
    this.AkC.setVisibility(8);
    this.NlN.setVisibility(0);
    this.NlO.setVisibility(8);
    this.NlP.setVisibility(8);
    this.lPf.setVisibility(8);
    this.ubv.setVisibility(8);
    this.NlN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((j)h.az(j.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/AttachDownloadPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122859);
      }
    });
    this.NlO.setOnClickListener(new AttachDownloadPage.4(this));
    AppMethodBeat.o(122873);
  }
  
  private void gEj()
  {
    AppMethodBeat.i(122874);
    if (this.NlS == 1)
    {
      if (FileExplorerUI.brB(this.NlU))
      {
        if (this.oYs == 3)
        {
          fkW();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.oYs == 0) || (this.NlW))
        {
          this.retryCount = 0;
          this.NlW = false;
          gEk();
          gEi();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.AkF.setVisibility(8);
      this.lPf.setVisibility(0);
      this.NlP.setVisibility(8);
      this.xQS.setVisibility(0);
      this.AkC.setVisibility(8);
      this.ubv.setVisibility(0);
      this.xQS.setOnClickListener(new AttachDownloadPage.5(this));
      if (this.oYs == 3)
      {
        this.lPf.setText(e.i.mail_attach_preview_status);
        this.ubv.setText(e.i.mail_attach_preview_open_downloaded);
        this.ubv.setOnClickListener(new AttachDownloadPage.6(this));
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.lPf.setText(e.i.mail_attach_preview_status);
      if (this.oYs == 2) {
        this.ubv.setText(e.i.mail_attach_preview_open_redownload);
      }
      for (;;)
      {
        this.ubv.setOnClickListener(new AttachDownloadPage.7(this));
        AppMethodBeat.o(122874);
        return;
        this.ubv.setText(e.i.mail_attach_preview_open_notdownload);
      }
    }
    if (this.NlS == 0)
    {
      this.AkF.setVisibility(8);
      this.xQS.setVisibility(8);
      this.AkC.setVisibility(0);
      this.NlP.setVisibility(8);
      this.lPf.setVisibility(0);
      this.ubv.setVisibility(8);
      if (this.oYs != 3) {
        break label380;
      }
      this.AkC.setText(e.i.mail_attach_downloaded);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.lPf.setText(e.i.mail_attach_download_status);
      this.AkC.setOnClickListener(new AttachDownloadPage.8(this));
      AppMethodBeat.o(122874);
      return;
      label380:
      if (this.oYs == 2) {
        this.AkC.setText(e.i.mail_attach_redownload);
      } else {
        this.AkC.setText(e.i.mail_attach_download);
      }
    }
  }
  
  private void gEk()
  {
    AppMethodBeat.i(122876);
    gEn();
    if (this.oYs == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        gEk();
      }
    }
    for (;;)
    {
      String str = AL(true);
      c.b localb = new c.b();
      localb.NiR = false;
      localb.NiS = false;
      Log.i("MicroMsg.AttachDownloadPage", "download attach url %s", new Object[] { this.downloadUrl });
      c.a(this.downloadUrl, str, getIntent().getStringExtra("qqmail_cookie"), new a.a()
      {
        public final void aM(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(266955);
          if (paramAnonymousBundle != null)
          {
            int i = paramAnonymousBundle.getInt("result_http_code", -1);
            Log.i("MicroMsg.AttachDownloadPage", "result http code %d", new Object[] { Integer.valueOf(i) });
            if (i == 200)
            {
              y.bF(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
              AttachDownloadPage.a(AttachDownloadPage.this, 3);
              Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(e.i.download_success) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
              AttachDownloadPage.d(AttachDownloadPage.this);
              AppMethodBeat.o(266955);
              return;
            }
          }
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(266955);
            return;
          }
          Toast.makeText(AttachDownloadPage.this, e.i.mail_attach_download_failed, 0).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(266955);
        }
        
        public final void aga(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          Log.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
      });
      AppMethodBeat.o(122876);
      return;
      gEj();
      continue;
      if (this.oYs == 3)
      {
        y.bF(this.NlR, gEl() + ".temp", gEl());
        this.oYs = 3;
        gEj();
      }
    }
  }
  
  private String gEl()
  {
    AppMethodBeat.i(122878);
    int i = this.NlV.hashCode();
    int j = this.NlU.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.NlU.substring(0, j);
      str2 = this.NlU;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.NlU;
    }
  }
  
  private String gEm()
  {
    AppMethodBeat.i(122880);
    String str = this.NlR + this.NlU;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void gEn()
  {
    AppMethodBeat.i(122881);
    if (y.ZC(AL(true)))
    {
      this.oZd = y.bEl(AL(true));
      this.oYs = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (y.ZC(AL(false)))
    {
      this.oYs = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (y.ZC(gEm()))
    {
      if (y.bEl(gEm()) == this.uWn)
      {
        y.bF(this.NlR, this.NlU, gEl());
        this.oYs = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (y.bEl(gEm()) > this.uWn)
      {
        y.deleteFile(gEm());
        this.oZd = 0L;
        this.oYs = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.oZd = 0L;
      this.oYs = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.oZd = 0L;
    this.oYs = 0;
    AppMethodBeat.o(122881);
  }
  
  public int getLayoutId()
  {
    return e.f.attach_download_page;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122872);
    this.NlM = ((MMImageView)findViewById(e.e.download_type_icon));
    this.AkF = findViewById(e.e.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(e.e.download_pb));
    this.NlN = ((ImageView)findViewById(e.e.download_stop_btn));
    this.NlO = ((ImageView)findViewById(e.e.download_restart_btn));
    this.NlP = ((TextView)findViewById(e.e.attach_download_speed_tv));
    this.xQS = ((Button)findViewById(e.e.attach_preview_btn));
    this.AkC = ((Button)findViewById(e.e.attach_download_btn));
    this.NlQ = ((LinearLayout)findViewById(e.e.attach_bottom_ll));
    this.lPf = ((TextView)findViewById(e.e.attach_download_status_tv));
    this.ubv = ((TextView)findViewById(e.e.attach_try_open_tv));
    if (FileExplorerUI.brB(this.NlU)) {
      this.NlM.setBackgroundResource(e.h.download_image_icon);
    }
    for (;;)
    {
      setBackBtn(new AttachDownloadPage.1(this));
      addIconOptionMenu(0, e.h.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(122858);
          paramAnonymousMenuItem = AttachDownloadPage.this;
          String str = AttachDownloadPage.this.getString(e.i.plugin_favorite_opt);
          k.d local1 = new k.d()
          {
            public final void qz(int paramAnonymous2Int)
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
          k.b(paramAnonymousMenuItem, "", new String[] { str }, "", local1);
          AppMethodBeat.o(122858);
          return true;
        }
      });
      enableOptionMenu(false);
      gEn();
      if (this.oYs != 1) {
        break;
      }
      gEi();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.brC(this.NlU))
      {
        this.NlM.setImageResource(e.h.app_attach_file_icon_video);
      }
      else
      {
        int i = x.bpA(y.alV(this.NlU));
        if (i > 0) {
          this.NlM.setImageResource(i);
        } else {
          this.NlM.setImageResource(e.h.app_attach_file_icon_unknow);
        }
      }
    }
    gEj();
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
    paramConfiguration = (FrameLayout.LayoutParams)this.NlQ.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = bd.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.NlQ.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(122882);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = bd.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122868);
    super.onCreate(paramBundle);
    this.NlS = getIntent().getIntExtra("is_preview", 0);
    this.NlT = getIntent().getBooleanExtra("is_compress", false);
    this.NlU = getIntent().getStringExtra("attach_name");
    this.Njg = getIntent().getStringExtra("mail_id");
    this.NlV = getIntent().getStringExtra("attach_id");
    this.downloadUrl = (u.gEa() + getIntent().getStringExtra("attach_url"));
    this.uWn = getIntent().getIntExtra("total_size", 0);
    ((j)h.az(j.class)).getNormalMailAppService();
    this.NlR = u.gEb();
    setMMTitle(this.NlU);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((j)h.az(j.class)).getNormalMailAppService().cancel(this.Bjl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */