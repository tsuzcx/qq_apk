package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ah.f, com.tencent.mm.ah.g
{
  private long bIt = 0L;
  private long bXr = 0L;
  private int ent;
  private ah handler = new ah(Looper.getMainLooper());
  private TextView iSJ;
  private ProgressBar niG;
  private TextView niH;
  private TextView niI;
  private TextView niJ;
  private RelativeLayout niK;
  private com.tencent.mm.as.e niL;
  private k niM;
  private ImageView niN;
  private LinearLayout niO;
  private String username;
  
  private void wp(int paramInt)
  {
    this.niH.setText(getString(b.j.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.niG.getMax()) {
      return;
    }
    com.tencent.mm.as.e locale = o.OJ().b(Long.valueOf(this.niM.eoN));
    if (this.ent == 1) {
      com.tencent.mm.as.f.c(locale);
    }
    finish();
    startActivity(getIntent());
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    y.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramm.getType() == 109) {
      if (paramInt2 == 0) {
        break label62;
      }
    }
    label62:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      wp(Math.max(0, paramInt1));
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return b.g.mail_image_download;
  }
  
  protected final void initView()
  {
    this.niH = ((TextView)findViewById(b.f.image_download_percent_tv));
    this.niI = ((TextView)findViewById(b.f.image_download_percent_tv));
    this.iSJ = ((TextView)findViewById(b.f.image_download_size_tv));
    this.niJ = ((TextView)findViewById(b.f.image_download_length_tv));
    this.niN = ((ImageView)findViewById(b.f.mail_image));
    this.niH.setVisibility(0);
    this.niO = ((LinearLayout)findViewById(b.f.image_bottom_info_layout));
    this.niK = ((RelativeLayout)findViewById(b.f.mail_img_download_layout));
    this.niI.setVisibility(8);
    this.iSJ.setVisibility(8);
    this.niJ.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MailImageDownloadUI.1(this));
    this.niG = ((ProgressBar)findViewById(b.f.image_download_pb));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bIt = getIntent().getLongExtra("img_msg_id", 0L);
    this.bXr = getIntent().getLongExtra("img_server_id", 0L);
    this.ent = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.bIt > 0L) {
      this.niL = o.OJ().bY(this.bIt);
    }
    if (((this.niL == null) || (this.niL.enp <= 0L)) && (this.bXr > 0L)) {
      this.niL = o.OJ().bX(this.bXr);
    }
    if ((this.niL == null) || (this.niL.enp <= 0L))
    {
      y.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bIt + ", or msgSvrId = " + this.bXr);
      return;
    }
    if ((this.bIt <= 0L) && (this.bXr > 0L)) {
      this.bIt = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(this.username, this.bXr).field_msgId;
    }
    paramBundle = this.niL.enq;
    String str = o.OJ().o(paramBundle, null, null);
    if ((!bk.bl(paramBundle)) && (com.tencent.mm.vfs.e.bK(str)))
    {
      y.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.niL.Or()), str });
      if ((str == null) || (str.equals("")) || (!com.tencent.mm.vfs.e.bK(str)))
      {
        y.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        return;
      }
      this.niO.setVisibility(8);
      this.niG.setVisibility(8);
      this.niN.setVisibility(0);
      paramBundle = c.YW(str);
      this.niN.setImageBitmap(paramBundle);
      this.niK.invalidate();
      return;
    }
    this.niM = new k(this.niL.enp, this.bIt, this.ent, this);
    com.tencent.mm.kernel.g.DO().dJT.a(this.niM, 0);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.DO().dJT.b(109, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.DO().dJT.a(109, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 109) {
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      wp(this.niG.getMax());
      return;
    }
    y.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, b.j.imgdownload_fail, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */