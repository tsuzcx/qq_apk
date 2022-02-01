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
import com.tencent.mm.sdk.platformtools.ad;
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
  private TextView fxX;
  private int hxS = 0;
  private long hyD = 0L;
  private TextView lAi;
  private long mqq;
  private Button oAT;
  private ProgressBar progressBar;
  private Button qhp;
  private View qhs;
  private int retryCount = 0;
  private String uLP;
  private String uLc;
  private long uMU;
  private MMImageView uNe;
  private ImageView uNf;
  private ImageView uNg;
  private TextView uNh;
  private LinearLayout uNi;
  private String uNj;
  private int uNk;
  private boolean uNl = false;
  private String uNm;
  private boolean uNn = true;
  
  private void dek()
  {
    AppMethodBeat.i(122873);
    this.qhs.setVisibility(0);
    this.oAT.setVisibility(8);
    this.qhp.setVisibility(8);
    this.uNf.setVisibility(0);
    this.uNg.setVisibility(8);
    this.uNh.setVisibility(8);
    this.fxX.setVisibility(8);
    this.lAi.setVisibility(8);
    this.uNf.setOnClickListener(new View.OnClickListener()
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
    this.uNg.setOnClickListener(new View.OnClickListener()
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
  
  private void del()
  {
    AppMethodBeat.i(122874);
    if (this.uNk == 1)
    {
      if (FileExplorerUI.aCw(this.uNm))
      {
        if (this.hxS == 3)
        {
          dem();
          AppMethodBeat.o(122874);
          return;
        }
        if ((this.hxS == 0) || (this.uNn))
        {
          this.retryCount = 0;
          this.uNn = false;
          den();
          dek();
          AppMethodBeat.o(122874);
          return;
        }
      }
      this.qhs.setVisibility(8);
      this.fxX.setVisibility(0);
      this.uNh.setVisibility(8);
      this.oAT.setVisibility(0);
      this.qhp.setVisibility(8);
      this.lAi.setVisibility(0);
      this.oAT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122861);
          AttachDownloadPage.g(AttachDownloadPage.this);
          AppMethodBeat.o(122861);
        }
      });
      if (this.hxS == 3)
      {
        this.fxX.setText(2131761031);
        this.lAi.setText(2131761028);
        this.lAi.setOnClickListener(new View.OnClickListener()
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
      this.fxX.setText(2131761031);
      if (this.hxS == 2) {
        this.lAi.setText(2131761030);
      }
      for (;;)
      {
        this.lAi.setOnClickListener(new View.OnClickListener()
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
        this.lAi.setText(2131761029);
      }
    }
    if (this.uNk == 0)
    {
      this.qhs.setVisibility(8);
      this.oAT.setVisibility(8);
      this.qhp.setVisibility(0);
      this.uNh.setVisibility(8);
      this.fxX.setVisibility(0);
      this.lAi.setVisibility(8);
      if (this.hxS != 3) {
        break label380;
      }
      this.qhp.setText(2131761025);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.fxX.setText(2131761024);
      this.qhp.setOnClickListener(new View.OnClickListener()
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
      if (this.hxS == 2) {
        this.qhp.setText(2131761032);
      } else {
        this.qhp.setText(2131761023);
      }
    }
  }
  
  private void dem()
  {
    AppMethodBeat.i(122875);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_favorite", true);
    localIntent.putExtra("key_favorite_source_type", 9);
    localIntent.putExtra("key_image_path", of(false));
    com.tencent.mm.plugin.qqmail.a.a.hYt.d(getContext(), localIntent);
    finish();
    AppMethodBeat.o(122875);
  }
  
  private void den()
  {
    AppMethodBeat.i(122876);
    deq();
    if (this.hxS == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        den();
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mailid", this.uLc);
      localHashMap.put("attachid", this.uLP);
      localHashMap.put("username", "");
      localHashMap.put("offset", this.hyD);
      localHashMap.put("datalen", this.mqq);
      localHashMap.put("default_attach_name", deo() + ".temp");
      w.c localc = new w.c();
      localc.uMh = false;
      localc.uMi = false;
      this.uMU = ((o)g.ad(o.class)).getNormalMailAppService().a("/cgi-bin/mmdownload", localHashMap, localc, new w.a()
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
          ad.d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(paramAnonymousInt)));
          AttachDownloadPage.j(AttachDownloadPage.this);
          AttachDownloadPage.a(AttachDownloadPage.this, 1);
          AppMethodBeat.o(122865);
        }
        
        public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
        {
          AppMethodBeat.i(122866);
          i.aQ(AttachDownloadPage.k(AttachDownloadPage.this), AttachDownloadPage.l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.l(AttachDownloadPage.this));
          AttachDownloadPage.a(AttachDownloadPage.this, 3);
          Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(2131758120) + " : " + AttachDownloadPage.a(AttachDownloadPage.this), 5000).show();
          AttachDownloadPage.d(AttachDownloadPage.this);
          AppMethodBeat.o(122866);
        }
      });
      AppMethodBeat.o(122876);
      return;
      del();
      continue;
      if (this.hxS == 3)
      {
        i.aQ(this.uNj, deo() + ".temp", deo());
        this.hxS = 3;
        del();
      }
    }
  }
  
  private String deo()
  {
    AppMethodBeat.i(122878);
    int i = this.uLP.hashCode();
    int j = this.uNm.lastIndexOf(".");
    String str2 = "";
    String str1;
    if (j != -1)
    {
      str1 = this.uNm.substring(0, j);
      str2 = this.uNm;
      str2 = str2.substring(j, str2.length());
    }
    for (;;)
    {
      str1 = String.format("%s_%d%s", new Object[] { str1, Integer.valueOf(i & 0xFFFF), str2 });
      AppMethodBeat.o(122878);
      return str1;
      str1 = this.uNm;
    }
  }
  
  private String dep()
  {
    AppMethodBeat.i(122880);
    String str = this.uNj + this.uNm;
    AppMethodBeat.o(122880);
    return str;
  }
  
  private void deq()
  {
    AppMethodBeat.i(122881);
    if (i.eK(of(true)))
    {
      this.hyD = i.aMN(of(true));
      this.hxS = 2;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.eK(of(false)))
    {
      this.hxS = 3;
      AppMethodBeat.o(122881);
      return;
    }
    if (i.eK(dep()))
    {
      if (i.aMN(dep()) == this.mqq)
      {
        i.aQ(this.uNj, this.uNm, deo());
        this.hxS = 3;
        AppMethodBeat.o(122881);
        return;
      }
      if (i.aMN(dep()) > this.mqq)
      {
        i.deleteFile(dep());
        this.hyD = 0L;
        this.hxS = 4;
        AppMethodBeat.o(122881);
        return;
      }
      this.hyD = 0L;
      this.hxS = 0;
      AppMethodBeat.o(122881);
      return;
    }
    this.hyD = 0L;
    this.hxS = 0;
    AppMethodBeat.o(122881);
  }
  
  private String of(boolean paramBoolean)
  {
    AppMethodBeat.i(122879);
    StringBuilder localStringBuilder = new StringBuilder().append(this.uNj).append(deo());
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
    this.uNe = ((MMImageView)findViewById(2131299226));
    this.qhs = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.uNf = ((ImageView)findViewById(2131299221));
    this.uNg = ((ImageView)findViewById(2131299219));
    this.uNh = ((TextView)findViewById(2131296961));
    this.oAT = ((Button)findViewById(2131296963));
    this.qhp = ((Button)findViewById(2131296960));
    this.uNi = ((LinearLayout)findViewById(2131296959));
    this.fxX = ((TextView)findViewById(2131296962));
    this.lAi = ((TextView)findViewById(2131296964));
    if (FileExplorerUI.aCw(this.uNm)) {
      this.uNe.setBackgroundResource(2131690066);
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
            public final void kM(int paramAnonymous2Int)
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
      deq();
      if (this.hxS != 1) {
        break;
      }
      dek();
      AppMethodBeat.o(122872);
      return;
      if (FileExplorerUI.aCx(this.uNm))
      {
        this.uNe.setImageResource(2131689581);
      }
      else
      {
        int i = q.aAJ(i.RK(this.uNm));
        if (i > 0) {
          this.uNe.setImageResource(i);
        } else {
          this.uNe.setImageResource(2131689577);
        }
      }
    }
    del();
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
    paramConfiguration = (FrameLayout.LayoutParams)this.uNi.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = ao.fromDPToPix(getContext(), 60);
    }
    for (;;)
    {
      this.uNi.setLayoutParams(paramConfiguration);
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
    this.uNk = getIntent().getIntExtra("is_preview", 0);
    this.uNl = getIntent().getBooleanExtra("is_compress", false);
    this.uNm = getIntent().getStringExtra("attach_name");
    this.uLc = getIntent().getStringExtra("mail_id");
    this.uLP = getIntent().getStringExtra("attach_id");
    this.mqq = getIntent().getLongExtra("total_size", 0L);
    ((o)g.ad(o.class)).getNormalMailAppService();
    this.uNj = w.getDownloadPath();
    setMMTitle(this.uNm);
    initView();
    AppMethodBeat.o(122868);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122871);
    super.onDestroy();
    ((o)g.ad(o.class)).getNormalMailAppService().cancel(this.uMU);
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