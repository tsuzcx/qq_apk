package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.m.e;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.c
{
  private long bIt;
  private xv bNt;
  private String bUi;
  private ah dPi;
  private TextView fhD;
  private ProgressBar frw;
  private TextView gSy;
  private com.tencent.mm.pluginsdk.ui.tools.f iuC = null;
  private Button kfc;
  private Button kfd;
  private Button kfe;
  private MMImageView kff;
  private TextView kfg;
  private View kfh;
  private View kfi;
  private boolean kfm = false;
  private boolean kfq = false;
  private boolean kfr = false;
  private com.tencent.mm.plugin.record.b.f nud;
  
  private void aKM()
  {
    if (this.kfq) {
      return;
    }
    this.kfq = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", com.tencent.mm.plugin.record.b.h.c(this.bNt, this.bIt));
    localIntent.putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.record.b.h.f(this.bNt, this.bIt));
    localIntent.putExtra("key_detail_fav_video_duration", this.bNt.duration);
    localIntent.putExtra("key_detail_statExtStr", this.bNt.bYN);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    b.a(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
  }
  
  private void aRI()
  {
    this.kfe.setVisibility(8);
    this.kfc.setVisibility(8);
    this.kfd.setVisibility(8);
    this.kfh.setVisibility(8);
    this.gSy.setVisibility(0);
    if (this.bNt.aYU == 4)
    {
      this.gSy.setGravity(17);
      this.gSy.setText(R.l.favorite_out_of_date_video);
      return;
    }
    this.gSy.setGravity(17);
    this.gSy.setText(R.l.favorite_out_of_date_file);
  }
  
  private void aRJ()
  {
    this.kfe.setVisibility(8);
    this.kfc.setVisibility(8);
    this.kfd.setVisibility(8);
    this.gSy.setVisibility(8);
    this.kfh.setVisibility(0);
    c(n.getRecordMsgCDNStorage().LG(this.bUi));
  }
  
  private void aRK()
  {
    this.kfh.setVisibility(8);
    this.kfd.setVisibility(8);
    if (bk.bl(this.bNt.sUN)) {
      this.kfc.setVisibility(8);
    }
    for (;;)
    {
      this.kfe.setVisibility(0);
      this.kfe.setText(R.l.favorite_item_download);
      this.gSy.setVisibility(8);
      return;
      this.kfc.setVisibility(0);
    }
  }
  
  private void bvM()
  {
    if ((getType() == 15) && (this.bNt.sVG != null) && (!bk.bl(this.bNt.sVG.dSP)) && (!bk.bl(this.bNt.sVG.dST)))
    {
      this.kfr = true;
      this.kff.setVisibility(8);
      this.kfh.setVisibility(8);
      this.kfe.setVisibility(8);
      this.kfc.setVisibility(8);
      this.kfd.setVisibility(8);
      this.gSy.setVisibility(8);
      String str = com.tencent.mm.plugin.record.b.h.c(this.bNt, this.bIt);
      y.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zH() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(R.h.video_container);
      this.iuC = o.fb(this.mController.uMN);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.iuC, 0, localLayoutParams);
      this.iuC.setVideoCallback(new RecordMsgFileUI.12(this));
      y.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zH() + " initView :" + str);
      if (str != null)
      {
        this.iuC.stop();
        this.iuC.setVideoPath(str);
      }
      y.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zH() + " initView");
      if (au.tu() != null) {
        au.tu().vT();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.kfr)
      {
        this.kfh.setVisibility(8);
        this.kfe.setVisibility(8);
        this.kfc.setVisibility(8);
        this.kfd.setVisibility(0);
        this.kfd.setText(R.l.favorite_item_preview);
        this.gSy.setVisibility(8);
        aKM();
      }
      return;
    }
    this.kfh.setVisibility(8);
    this.kfe.setVisibility(4);
    if (bk.bl(this.bNt.sUN)) {
      this.kfc.setVisibility(8);
    }
    for (;;)
    {
      this.kfd.setVisibility(0);
      this.gSy.setVisibility(0);
      return;
      this.kfc.setVisibility(0);
    }
  }
  
  private String bvN()
  {
    Object localObject = new File(com.tencent.mm.plugin.record.b.h.f(this.bNt, this.bIt));
    if (((File)localObject).exists()) {
      return ((File)localObject).getAbsolutePath();
    }
    localObject = new StringBuilder();
    au.Hx();
    return com.tencent.mm.model.c.FQ() + "web/" + com.tencent.mm.a.g.o(bk.aM(this.bNt.bIm, "").getBytes());
  }
  
  private void c(com.tencent.mm.plugin.record.a.f paramf)
  {
    int j;
    int i;
    int k;
    if (paramf != null)
    {
      j = (int)(paramf.field_offset / Math.max(1, paramf.field_totalLen) * 100.0F);
      i = paramf.field_offset;
      k = paramf.field_totalLen;
    }
    for (;;)
    {
      this.dPi.post(new RecordMsgFileUI.3(this, j, i, k));
      return;
      k = (int)this.bNt.sVb;
      i = 0;
      j = 0;
    }
  }
  
  private int getType()
  {
    int j = this.bNt.aYU;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    if (paramf == null) {
      y.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
    }
    do
    {
      return;
      y.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.bUi, paramf.field_mediaId });
    } while (!this.bUi.equals(paramf.field_mediaId));
    switch (paramf.field_status)
    {
    default: 
      c(paramf);
      return;
    case 2: 
      this.dPi.post(new RecordMsgFileUI.4(this));
      return;
    case 4: 
      this.dPi.post(new RecordMsgFileUI.5(this));
      return;
    }
    this.dPi.post(new RecordMsgFileUI.6(this));
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.file_download_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 5);
    if (paramInt2 != -1) {
      break label27;
    }
    label27:
    while (paramInt1 != 1001) {
      return;
    }
    Object localObject1;
    if (paramIntent == null)
    {
      localObject1 = null;
      label42:
      if (paramIntent != null) {
        break label174;
      }
    }
    Object localObject2;
    label174:
    for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
    {
      localObject2 = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(R.l.favorite_forward_tips), false, null);
      y.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
      localObject2 = new RecordMsgFileUI.13(this, (Dialog)localObject2);
      if (bk.bl((String)localObject1)) {
        break;
      }
      localObject1 = bk.G(((String)localObject1).split(","));
      if ((getType() != 4) && (getType() != 15)) {
        break label185;
      }
      au.DS().O(new RecordMsgFileUI.14(this, (List)localObject1, paramIntent, (Runnable)localObject2));
      return;
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      break label42;
    }
    label185:
    au.DS().O(new RecordMsgFileUI.2(this, (List)localObject1, paramIntent, (Runnable)localObject2));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dPi = new ah();
    this.nud = new com.tencent.mm.plugin.record.b.f();
    this.bIt = getIntent().getLongExtra("message_id", -1L);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = com.tencent.mm.plugin.record.b.h.LH(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      y.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).dTx.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xv localxv = (xv)((Iterator)localObject).next();
      if (localxv.kgC.equals(paramBundle)) {
        this.bNt = localxv;
      }
    }
    if (this.bNt == null)
    {
      y.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      return;
    }
    this.bUi = com.tencent.mm.plugin.record.b.h.h(this.bNt.kgC, this.bIt, true);
    this.kfc = ((Button)findViewById(R.h.preview_btn));
    this.kfd = ((Button)findViewById(R.h.open_btn));
    this.kfe = ((Button)findViewById(R.h.download_btn));
    this.kff = ((MMImageView)findViewById(R.h.icon_iv));
    this.fhD = ((TextView)findViewById(R.h.name_tv));
    this.gSy = ((TextView)findViewById(R.h.tips_tv));
    this.kfi = findViewById(R.h.download_stop_btn);
    this.kfh = findViewById(R.h.download_progress_area);
    this.frw = ((ProgressBar)findViewById(R.h.download_pb));
    this.kfg = ((TextView)findViewById(R.h.download_progress_tips));
    label347:
    label482:
    int i;
    label510:
    int j;
    if (4 == getType())
    {
      setMMTitle(R.l.favorite_video);
      if (getType() != 4) {
        break label602;
      }
      this.kff.setImageResource(R.k.app_attach_file_icon_video);
      this.fhD.setText(this.bNt.title);
      setBackBtn(new RecordMsgFileUI.1(this));
      this.kfd.setOnClickListener(new RecordMsgFileUI.7(this));
      paramBundle = this.bNt.sUN;
      if (!bk.bl(paramBundle)) {
        this.kfc.setOnClickListener(new RecordMsgFileUI.8(this, paramBundle));
      }
      this.kfe.setOnClickListener(new RecordMsgFileUI.9(this));
      this.kfi.setOnClickListener(new RecordMsgFileUI.10(this));
      if ((getType() != 15) || (bk.ZR(com.tencent.mm.m.g.AA().getValue("SightForwardEnable")) == 1)) {
        break label622;
      }
      y.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      if ((!bk.bl(this.bNt.sUG)) && (!bk.bl(this.bNt.sUI))) {
        break label641;
      }
      i = 1;
      if ((!bk.bl(this.bNt.sVY)) && (!bk.bl(this.bNt.sVV))) {
        break label646;
      }
      j = 1;
      label538:
      if ((i != 0) || (j != 0)) {
        break label651;
      }
      aRI();
    }
    for (;;)
    {
      n.getRecordMsgCDNStorage().a(this);
      return;
      if (15 == getType())
      {
        setMMTitle(R.l.favorite_sight);
        findViewById(R.h.video_container).setBackgroundResource(R.e.black);
        break;
      }
      setMMTitle(R.l.favorite_file);
      break;
      label602:
      this.kff.setImageResource(com.tencent.mm.pluginsdk.c.Vy(this.bNt.sUV));
      break label347;
      label622:
      addIconOptionMenu(0, R.g.mm_title_btn_menu, new RecordMsgFileUI.11(this));
      break label482;
      label641:
      i = 0;
      break label510;
      label646:
      j = 0;
      break label538;
      label651:
      if (!com.tencent.mm.plugin.record.b.h.d(this.bNt, this.bIt)) {
        break label677;
      }
      enableOptionMenu(true);
      bvM();
    }
    label677:
    paramBundle = n.getRecordMsgCDNStorage().LG(this.bUi);
    if ((paramBundle == null) || (2 == paramBundle.field_status)) {
      aRK();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == paramBundle.field_status)
      {
        aRI();
      }
      else if ((paramBundle.field_status == 0) || (1 == paramBundle.field_status))
      {
        aRJ();
      }
      else
      {
        y.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        aRK();
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.iuC != null)
    {
      this.iuC.setVideoCallback(null);
      this.iuC.stop();
      this.iuC.onDetach();
      if (au.tu() != null) {
        au.tu().vS();
      }
    }
    super.onDestroy();
    n.getRecordMsgCDNStorage().b(this);
    this.nud.destory();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.iuC != null) {
      this.iuC.stop();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.iuC != null) {
      this.iuC.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI
 * JD-Core Version:    0.7.0.1
 */