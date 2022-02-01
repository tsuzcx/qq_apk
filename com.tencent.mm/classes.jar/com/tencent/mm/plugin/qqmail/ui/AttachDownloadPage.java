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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.plugin.qqmail.b.w.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage
  extends MMActivity
{
  private TextView fBE;
  private int hYt = 0;
  private long hZe = 0L;
  private long mSs;
  private TextView mce;
  private Button pet;
  private ProgressBar progressBar;
  private Button qPR;
  private View qPU;
  private int retryCount = 0;
  private String vTT;
  private String vUF;
  private long vVK;
  private MMImageView vVU;
  private ImageView vVV;
  private ImageView vVW;
  private TextView vVX;
  private LinearLayout vVY;
  private String vVZ;
  private int vWa;
  private boolean vWb = false;
  private String vWc;
  private boolean vWd = true;
  
  private void drS()
  {
    AppMethodBeat.i(122873);
    this.qPU.setVisibility(0);
    this.pet.setVisibility(8);
    this.qPR.setVisibility(8);
    this.vVV.setVisibility(0);
    this.vVW.setVisibility(8);
    this.vVX.setVisibility(8);
    this.fBE.setVisibility(8);
    this.mce.setVisibility(8);
    this.vVV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122859);
        AttachDownloadPage.a(AttachDownloadPage.this, 2);
        ((o)g.ad(o.class)).getNormalMailAppService().cancel(AttachDownloadPage.b(AttachDownloadPage.this));
        AttachDownloadPage.c(AttachDownloadPage.this);
        AttachDownloadPage.d(AttachDownloadPage.this);
        AppMethodBeat.o(122859);
      }
    });
    this.vVW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122860);
        AttachDownloadPage.e(AttachDownloadPage.this);
        AttachDownloadPage.f(AttachDownloadPage.this);
        AppMethodBeat.o(122860);
      }
    });
    AppMethodBeat.o(122873);
  }
  
  private void drT()
  {
    AppMethodBeat.i(122874);
    if (this.vWa == 1)
    {
      if (FileExplorerUI.aHO(this.vWc))
      {
        if (this.hYt == 3)
        {
          drU();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.hYt == 0) || (this.vWd))
        {
          this.retryCount = 0;
          this.vWd = false;
          drV();
          drS();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.qPU.setVisibility(8);
      this.fBE.setVisibility(0);
      this.vVX.setVisibility(8);
      this.pet.setVisibility(0);
      this.qPR.setVisibility(8);
      this.mce.setVisibility(0);
      this.pet.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          AttachDownloadPage.g(AttachDownloadPage.this);
          AppMethodBeat.o(122861);
        }
      });
      if (this.hYt == 3)
      {
        this.fBE.setText(2131761031);
        this.mce.setText(2131761028);
        this.mce.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122862);
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            AppMethodBeat.o(122862);
          }
        });
        enableOptionMenu(true);
        AppMethodBeat.o(122874);
        return;
      }
      this.fBE.setText(2131761031);
      if (this.hYt == 2) {
        this.mce.setText(2131761030);
      }
      for (;;)
      {
        this.mce.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122863);
            AttachDownloadPage.e(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AttachDownloadPage.h(AttachDownloadPage.this);
            AppMethodBeat.o(122863);
          }
        });
        AppMethodBeat.o(122874);
        return;
        this.mce.setText(2131761029);
      }
    }
    if (this.vWa == 0)
    {
      this.qPU.setVisibility(8);
      this.pet.setVisibility(8);
      this.qPR.setVisibility(0);
      this.vVX.setVisibility(8);
      this.fBE.setVisibility(0);
      this.mce.setVisibility(8);
      if (this.hYt != 3) {
        break label380;
      }
      this.qPR.setText(2131761025);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.fBE.setText(2131761024);
      this.qPR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122864);
          if (AttachDownloadPage.i(AttachDownloadPage.this) == 3)
          {
            AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.a(AttachDownloadPage.this));
            AppMethodBeat.o(122864);
            return;
          }
          AttachDownloadPage.h(AttachDownloadPage.this);
          AttachDownloadPage.e(AttachDownloadPage.this);
          AttachDownloadPage.f(AttachDownloadPage.this);
          AppMethodBeat.o(122864);
        }
      });
      AppMethodBeat.o(122874);
      return;
      label380:
      if (this.hYt == 2) {
        this.qPR.setText(2131761032);
      } else {
        this.qPR.setText(2131761023);
      }
    }
  }
  
  private void drU()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", oZ(false));
    com.tencent.mm.plugin.qqmail.a.a.iyx.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void drV()
  {
    AppMethodBeat.i(122876);
    drY();
    if (this.hYt == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        drV();
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mailid", this.vTT);
      localHashMap.put("attachid", this.vUF);
      localHashMap.put("username", "");
      localHashMap.put("offset", this.hZe);
      localHashMap.put("datalen", this.mSs);
      localHashMap.put("default_attach_name", drW() + ".temp");
      w.c localc = new w.c();
      localc.vUX = false;
      localc.vUY = false;
      this.vVK = ((o)g.ad(o.class)).getNormalMailAppService().a("/cgi-bin/mmdownload", localHashMap, localc, new w.a()
      {
        public final void onComplete() {}
        
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(122867);
          AttachDownloadPage.a(AttachDownloadPage.this, 4);
          if (AttachDownloadPage.m(AttachDownloadPage.this) < 5)
          {
            AttachDownloadPage.n(AttachDownloadPage.this);
            AttachDownloadPage.f(AttachDownloadPage.this);
            AppMethodBeat.o(122867);
            return;
          }
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(122867);
        }
        
        public final void onProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(122865);
          ac.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
        {
          AppMethodBeat.i(122866);
          i.aT(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
          AttachDownloadPage.a(AttachDownloadPage.this, 3);
          Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(2131758120) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(122866);
        }
      });
      AppMethodBeat.o(122876);
      return;
      drT();
      continue;
      if (this.hYt == 3)
      {
        i.aT(this.vVZ, drW() + ".temp", drW());
        this.hYt = 3;
        drT();
      }
    }
  }
  
  private String drW()
  {
    AppMethodBeat.i(122878);
    int i = this.vUF.hashCode();
    int j = this.vWc.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.vWc.substring(0, j);
      str2 = this.vWc;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.vWc;
    }
  }
  
  private String drX()
  {
    AppMethodBeat.i(122880);
    String str = this.vVZ + this.vWc;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void drY()
  {
    AppMethodBeat.i(122881);
    if (i.eA(oZ(true)))
    {
      this.hZe = i.aSp(oZ(true));
      this.hYt = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.eA(oZ(false)))
    {
      this.hYt = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.eA(drX()))
    {
      if (i.aSp(drX()) == this.mSs)
      {
        i.aT(this.vVZ, this.vWc, drW());
        this.hYt = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (i.aSp(drX()) > this.mSs)
      {
        i.deleteFile(drX());
        this.hZe = 0L;
        this.hYt = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.hZe = 0L;
      this.hYt = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.hZe = 0L;
    this.hYt = 0;
    AppMethodBeat.o(122881);
  }
  
  private String oZ(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.vVZ).append(drW());
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
    this.vVU = ((MMImageView)findViewById(2131299226));
    this.qPU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.vVV = ((ImageView)findViewById(2131299221));
    this.vVW = ((ImageView)findViewById(2131299219));
    this.vVX = ((TextView)findViewById(2131296961));
    this.pet = ((Button)findViewById(2131296963));
    this.qPR = ((Button)findViewById(2131296960));
    this.vVY = ((LinearLayout)findViewById(2131296959));
    this.fBE = ((TextView)findViewById(2131296962));
    this.mce = ((TextView)findViewById(2131296964));
    if (FileExplorerUI.aHO(this.vWc)) {
      this.vVU.setBackgroundResource(2131690066);
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
            public final void kG(int paramAnonymous2Int)
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
      drY();
      if (this.hYt != 1) {
        break;
      }
      drS();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.aHP(this.vWc))
      {
        this.vVU.setImageResource(2131689581);
      }
      else
      {
        int i = q.aGb(i.VW(this.vWc));
        if (i > 0) {
          this.vVU.setImageResource(i);
        } else {
          this.vVU.setImageResource(2131689577);
        }
      }
    }
    drT();
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
    paramConfiguration = (FrameLayout.LayoutParams)this.vVY.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = ao.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.vVY.setLayoutParams(paramConfiguration);
      AppMethodBeat.o(122882);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = ao.fromDPToPix(getContext(), 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122868);
    super.onCreate(paramBundle);
    this.vWa = getIntent().getIntExtra("is_preview", 0);
    this.vWb = getIntent().getBooleanExtra("is_compress", false);
    this.vWc = getIntent().getStringExtra("attach_name");
    this.vTT = getIntent().getStringExtra("mail_id");
    this.vUF = getIntent().getStringExtra("attach_id");
    this.mSs = getIntent().getLongExtra("total_size", 0L);
    ((o)g.ad(o.class)).getNormalMailAppService();
    this.vVZ = w.getDownloadPath();
    setMMTitle(this.vWc);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((o)g.ad(o.class)).getNormalMailAppService().cancel(this.vVK);
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