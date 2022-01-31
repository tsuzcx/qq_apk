package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage
  extends MMActivity
{
  private int eFr = 0;
  private long eGc = 0L;
  private TextView eXu;
  private ProgressBar frw;
  private long hFz;
  private TextView hdh;
  private Button kfc;
  private Button kfe;
  private View kfh;
  private String nds;
  private String neg;
  private MMImageView nfB;
  private ImageView nfC;
  private ImageView nfD;
  private TextView nfE;
  private LinearLayout nfF;
  private String nfG;
  private int nfH;
  private boolean nfI = false;
  private String nfJ;
  private boolean nfK = true;
  private long nfq;
  private int retryCount = 0;
  
  private void btL()
  {
    this.kfh.setVisibility(0);
    this.kfc.setVisibility(8);
    this.kfe.setVisibility(8);
    this.nfC.setVisibility(0);
    this.nfD.setVisibility(8);
    this.nfE.setVisibility(8);
    this.eXu.setVisibility(8);
    this.hdh.setVisibility(8);
    this.nfC.setOnClickListener(new AttachDownloadPage.3(this));
    this.nfD.setOnClickListener(new AttachDownloadPage.4(this));
  }
  
  private void btM()
  {
    if (this.nfH == 1) {
      if (FileExplorerUI.WW(this.nfJ)) {
        if (this.eFr == 3)
        {
          localIntent = new Intent();
          localIntent.putExtra("key_favorite", true);
          localIntent.putExtra("key_favorite_source_type", 9);
          localIntent.putExtra("key_image_path", ii(false));
          com.tencent.mm.plugin.qqmail.a.a.eUR.b(this.mController.uMN, localIntent);
          finish();
        }
      }
    }
    while (this.nfH != 0)
    {
      Intent localIntent;
      return;
      if ((this.eFr == 0) || (this.nfK))
      {
        this.retryCount = 0;
        this.nfK = false;
        btN();
        btL();
        return;
      }
      this.kfh.setVisibility(8);
      this.eXu.setVisibility(0);
      this.nfE.setVisibility(8);
      this.kfc.setVisibility(0);
      this.kfe.setVisibility(8);
      this.hdh.setVisibility(0);
      this.kfc.setOnClickListener(new AttachDownloadPage.5(this));
      if (this.eFr == 3)
      {
        this.eXu.setText(b.j.mail_attach_preview_status);
        this.hdh.setText(b.j.mail_attach_preview_open_downloaded);
        this.hdh.setOnClickListener(new AttachDownloadPage.6(this));
        enableOptionMenu(true);
        return;
      }
      this.eXu.setText(b.j.mail_attach_preview_status);
      if (this.eFr == 2) {
        this.hdh.setText(b.j.mail_attach_preview_open_redownload);
      }
      for (;;)
      {
        this.hdh.setOnClickListener(new AttachDownloadPage.7(this));
        return;
        this.hdh.setText(b.j.mail_attach_preview_open_notdownload);
      }
    }
    this.kfh.setVisibility(8);
    this.kfc.setVisibility(8);
    this.kfe.setVisibility(0);
    this.nfE.setVisibility(8);
    this.eXu.setVisibility(0);
    this.hdh.setVisibility(8);
    if (this.eFr == 3)
    {
      this.kfe.setText(b.j.mail_attach_downloaded);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.eXu.setText(b.j.mail_attach_download_status);
      this.kfe.setOnClickListener(new AttachDownloadPage.8(this));
      return;
      if (this.eFr == 2) {
        this.kfe.setText(b.j.mail_attach_redownload);
      } else {
        this.kfe.setText(b.j.mail_attach_download);
      }
    }
  }
  
  private void btN()
  {
    btQ();
    if (this.eFr == 4) {
      if (this.retryCount < 5)
      {
        this.retryCount += 1;
        btN();
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mailid", this.nds);
      localHashMap.put("attachid", this.neg);
      localHashMap.put("username", "");
      localHashMap.put("offset", this.eGc);
      localHashMap.put("datalen", this.hFz);
      localHashMap.put("default_attach_name", btO() + ".temp");
      v.c localc = new v.c();
      localc.nez = false;
      localc.neA = false;
      this.nfq = ac.btF().a("/cgi-bin/mmdownload", localHashMap, localc, new AttachDownloadPage.9(this));
      return;
      btM();
      continue;
      if (this.eFr == 3)
      {
        e.f(this.nfG, btO() + ".temp", btO());
        this.eFr = 3;
        btM();
      }
    }
  }
  
  private String btO()
  {
    int i = this.neg.hashCode();
    int j = this.nfJ.lastIndexOf(".");
    String str1 = "";
    String str2;
    if (j != -1)
    {
      str2 = this.nfJ.substring(0, j);
      str1 = this.nfJ.substring(j, this.nfJ.length());
    }
    for (;;)
    {
      return String.format("%s_%d%s", new Object[] { str2, Integer.valueOf(i & 0xFFFF), str1 });
      str2 = this.nfJ;
    }
  }
  
  private String btP()
  {
    return this.nfG + this.nfJ;
  }
  
  private void btQ()
  {
    if (e.bK(ii(true)))
    {
      this.eGc = e.aeQ(ii(true));
      this.eFr = 2;
      return;
    }
    if (e.bK(ii(false)))
    {
      this.eFr = 3;
      return;
    }
    if (e.bK(btP()))
    {
      if (e.aeQ(btP()) == this.hFz)
      {
        e.f(this.nfG, this.nfJ, btO());
        this.eFr = 3;
        return;
      }
      if (e.aeQ(btP()) > this.hFz)
      {
        e.deleteFile(btP());
        this.eGc = 0L;
        this.eFr = 4;
        return;
      }
      this.eGc = 0L;
      this.eFr = 0;
      return;
    }
    this.eGc = 0L;
    this.eFr = 0;
  }
  
  private String ii(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.nfG).append(btO());
    if (!paramBoolean) {}
    for (String str = "";; str = ".temp") {
      return str;
    }
  }
  
  protected final int getLayoutId()
  {
    return b.g.attach_download_page;
  }
  
  protected final void initView()
  {
    this.nfB = ((MMImageView)findViewById(b.f.download_type_icon));
    this.kfh = findViewById(b.f.download_progress_area);
    this.frw = ((ProgressBar)findViewById(b.f.download_pb));
    this.nfC = ((ImageView)findViewById(b.f.download_stop_btn));
    this.nfD = ((ImageView)findViewById(b.f.download_restart_btn));
    this.nfE = ((TextView)findViewById(b.f.attach_download_speed_tv));
    this.kfc = ((Button)findViewById(b.f.attach_preview_btn));
    this.kfe = ((Button)findViewById(b.f.attach_download_btn));
    this.nfF = ((LinearLayout)findViewById(b.f.attach_bottom_ll));
    this.eXu = ((TextView)findViewById(b.f.attach_download_status_tv));
    this.hdh = ((TextView)findViewById(b.f.attach_try_open_tv));
    if (FileExplorerUI.WW(this.nfJ)) {
      this.nfB.setBackgroundResource(b.i.download_image_icon);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AttachDownloadPage.this.finish();
          return true;
        }
      });
      addIconOptionMenu(0, b.i.ofm_send_icon, new AttachDownloadPage.2(this));
      enableOptionMenu(false);
      btQ();
      if (this.eFr != 1) {
        break;
      }
      btL();
      return;
      if (FileExplorerUI.WX(this.nfJ))
      {
        this.nfB.setImageResource(b.i.app_attach_file_icon_video);
      }
      else
      {
        int i = o.VP(e.bM(this.nfJ));
        if (i > 0) {
          this.nfB.setImageResource(i);
        } else {
          this.nfB.setImageResource(b.i.app_attach_file_icon_unknow);
        }
      }
    }
    btM();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, b.j.download_no_match_msg, b.j.download_no_match_title, 3);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    paramConfiguration = (FrameLayout.LayoutParams)this.nfF.getLayoutParams();
    if (i == 2) {
      paramConfiguration.bottomMargin = ap.fromDPToPix(this.mController.uMN, 60);
    }
    for (;;)
    {
      this.nfF.setLayoutParams(paramConfiguration);
      return;
      if (i == 1) {
        paramConfiguration.bottomMargin = ap.fromDPToPix(this.mController.uMN, 120);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nfH = getIntent().getIntExtra("is_preview", 0);
    this.nfI = getIntent().getBooleanExtra("is_compress", false);
    this.nfJ = getIntent().getStringExtra("attach_name");
    this.nds = getIntent().getStringExtra("mail_id");
    this.neg = getIntent().getStringExtra("attach_id");
    this.hFz = getIntent().getLongExtra("total_size", 0L);
    ac.btF();
    this.nfG = v.getDownloadPath();
    setMMTitle(this.nfJ);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ac.btF().cancel(this.nfq);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage
 * JD-Core Version:    0.7.0.1
 */