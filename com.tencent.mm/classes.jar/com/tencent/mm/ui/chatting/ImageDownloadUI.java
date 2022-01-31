package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public class ImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ah.f, com.tencent.mm.ah.g
{
  private long bIt = 0L;
  private long bXr = 0L;
  private int ent;
  private TextView iSJ;
  private ProgressBar niG;
  private TextView niH;
  private TextView niI;
  private TextView niJ;
  private com.tencent.mm.as.e niL;
  private k niM;
  private String username;
  private ImageView vmt;
  
  private void wp(int paramInt)
  {
    this.niG.setProgress(paramInt);
    this.niH.setText(getString(R.l.fmt_percent, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.niG.getMax()) {
      return;
    }
    Object localObject = o.OJ().b(Long.valueOf(this.niM.eoN));
    String str = ((com.tencent.mm.as.e)localObject).enq;
    if (this.ent == 1) {
      str = com.tencent.mm.as.f.c((com.tencent.mm.as.e)localObject);
    }
    str = o.OJ().o(str, null, null);
    if ((str == null) || (str.equals("")) || (!com.tencent.mm.vfs.e.bK(str)))
    {
      y.d("ImageDownloadUI", "showImg : imgPath is null");
      return;
    }
    localObject = new Intent(this, ImageGalleryUI.class);
    ((Intent)localObject).putExtra("key_message_id", this.bIt);
    ((Intent)localObject).putExtra("key_image_path", str);
    ((Intent)localObject).putExtra("key_compress_type", this.ent);
    ((Intent)localObject).putExtra("key_favorite", true);
    ((Intent)localObject).putExtra("img_gallery_msg_id", this.bIt);
    ((Intent)localObject).putExtra("img_gallery_talker", this.username);
    finish();
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    y.d("ImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
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
    return R.i.video_download;
  }
  
  protected final void initView()
  {
    this.niH = ((TextView)findViewById(R.h.image_download_percent_tv));
    this.niI = ((TextView)findViewById(R.h.video_download_percent_tv));
    this.iSJ = ((TextView)findViewById(R.h.video_download_size_tv));
    this.niJ = ((TextView)findViewById(R.h.video_download_length_tv));
    this.vmt = ((ImageView)findViewById(R.h.down_background));
    this.vmt.setImageResource(R.k.download_image_icon);
    this.niH.setVisibility(0);
    this.niI.setVisibility(8);
    this.iSJ.setVisibility(8);
    this.niJ.setVisibility(8);
    setBackBtn(new ImageDownloadUI.1(this));
    this.niG = ((ProgressBar)findViewById(R.h.video_download_pb));
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
      y.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bIt + ", or msgSvrId = " + this.bXr);
      return;
    }
    if ((this.bIt <= 0L) && (this.bXr > 0L))
    {
      au.Hx();
      this.bIt = c.Fy().O(this.username, this.bXr).field_msgId;
    }
    this.niM = new k(this.niL.enp, this.bIt, this.ent, this);
    au.Dk().a(this.niM, 0);
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Dk().b(109, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(109, this);
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
    y.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, R.l.imgdownload_fail, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */