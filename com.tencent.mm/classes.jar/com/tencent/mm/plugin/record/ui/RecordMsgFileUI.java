package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private String cBO;
  private long cpO;
  private aca cuL;
  private ak faV;
  private TextView gzk;
  private TextView ivt;
  private com.tencent.mm.pluginsdk.ui.tools.e kvG = null;
  private boolean mAa = false;
  private Button mzL;
  private Button mzM;
  private Button mzN;
  private MMImageView mzO;
  private TextView mzP;
  private View mzQ;
  private View mzR;
  private boolean mzV = false;
  private boolean mzZ = false;
  private l pZM;
  private ProgressBar progressBar;
  
  private void boV()
  {
    AppMethodBeat.i(24284);
    if (this.mzZ)
    {
      AppMethodBeat.o(24284);
      return;
    }
    this.mzZ = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", n.c(this.cuL, this.cpO));
    localIntent.putExtra("key_detail_fav_thumb_path", n.f(this.cuL, this.cpO));
    localIntent.putExtra("key_detail_fav_video_duration", this.cuL.duration);
    localIntent.putExtra("key_detail_statExtStr", this.cuL.cGU);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    b.b(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
    AppMethodBeat.o(24284);
  }
  
  private void bxY()
  {
    AppMethodBeat.i(24273);
    this.mzN.setVisibility(8);
    this.mzL.setVisibility(8);
    this.mzM.setVisibility(8);
    this.mzQ.setVisibility(8);
    this.ivt.setVisibility(0);
    if (this.cuL.dataType == 4)
    {
      this.ivt.setGravity(17);
      this.ivt.setText(2131299769);
      AppMethodBeat.o(24273);
      return;
    }
    this.ivt.setGravity(17);
    this.ivt.setText(2131299768);
    AppMethodBeat.o(24273);
  }
  
  private void bxZ()
  {
    AppMethodBeat.i(24274);
    this.mzN.setVisibility(8);
    this.mzL.setVisibility(8);
    this.mzM.setVisibility(8);
    this.ivt.setVisibility(8);
    this.mzQ.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(this.cBO));
    AppMethodBeat.o(24274);
  }
  
  private void bya()
  {
    AppMethodBeat.i(24275);
    this.mzQ.setVisibility(8);
    this.mzM.setVisibility(8);
    if (bo.isNullOrNil(this.cuL.wSJ)) {
      this.mzL.setVisibility(8);
    }
    for (;;)
    {
      this.mzN.setVisibility(0);
      this.mzN.setText(2131299746);
      this.ivt.setVisibility(8);
      AppMethodBeat.o(24275);
      return;
      this.mzL.setVisibility(0);
    }
  }
  
  private void byc()
  {
    AppMethodBeat.i(24276);
    if ((getType() == 15) && (this.cuL.wTC != null) && (!bo.isNullOrNil(this.cuL.wTC.fiO)) && (!bo.isNullOrNil(this.cuL.wTC.fiS)))
    {
      this.mAa = true;
      this.mzO.setVisibility(8);
      this.mzQ.setVisibility(8);
      this.mzN.setVisibility(8);
      this.mzL.setVisibility(8);
      this.mzM.setVisibility(8);
      this.ivt.setVisibility(8);
      String str = n.c(this.cuL, this.cpO);
      ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mk() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131824108);
      this.kvG = q.ga(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.kvG, 0, localLayoutParams);
      this.kvG.setVideoCallback(new RecordMsgFileUI.12(this));
      ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mk() + " initView :" + str);
      if (str != null)
      {
        this.kvG.stop();
        this.kvG.setVideoPath(str);
      }
      ab.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Mk() + " initView");
      if (aw.BY() != null) {
        aw.BY().Ic();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.mAa)
      {
        this.mzQ.setVisibility(8);
        this.mzN.setVisibility(8);
        this.mzL.setVisibility(8);
        this.mzM.setVisibility(0);
        this.mzM.setText(2131299748);
        this.ivt.setVisibility(8);
        boV();
        AppMethodBeat.o(24276);
      }
    }
    else
    {
      this.mzQ.setVisibility(8);
      this.mzN.setVisibility(4);
      if (!bo.isNullOrNil(this.cuL.wSJ)) {
        break label472;
      }
      this.mzL.setVisibility(8);
    }
    for (;;)
    {
      this.mzM.setVisibility(0);
      this.ivt.setVisibility(0);
      AppMethodBeat.o(24276);
      return;
      label472:
      this.mzL.setVisibility(0);
    }
  }
  
  private void c(i parami)
  {
    AppMethodBeat.i(24282);
    int j;
    int i;
    int k;
    if (parami != null)
    {
      j = (int)(parami.field_offset / Math.max(1, parami.field_totalLen) * 100.0F);
      i = parami.field_offset;
      k = parami.field_totalLen;
    }
    for (;;)
    {
      this.faV.post(new RecordMsgFileUI.3(this, j, i, k));
      AppMethodBeat.o(24282);
      return;
      k = (int)this.cuL.wSX;
      i = 0;
      j = 0;
    }
  }
  
  private String cgd()
  {
    AppMethodBeat.i(24281);
    Object localObject = new File(n.f(this.cuL, this.cpO));
    if (((File)localObject).exists()) {}
    for (localObject = ((File)localObject).getAbsolutePath();; localObject = com.tencent.mm.model.c.YU() + "web/" + com.tencent.mm.a.g.w(bo.bf(this.cuL.cpH, "").getBytes()))
    {
      AppMethodBeat.o(24281);
      return localObject;
      localObject = new StringBuilder();
      aw.aaz();
    }
  }
  
  private int getType()
  {
    int j = this.cuL.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(24283);
    if (parami == null)
    {
      ab.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
      AppMethodBeat.o(24283);
      return;
    }
    ab.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.cBO, parami.field_mediaId });
    if (!this.cBO.equals(parami.field_mediaId))
    {
      AppMethodBeat.o(24283);
      return;
    }
    switch (parami.field_status)
    {
    default: 
      c(parami);
      AppMethodBeat.o(24283);
      return;
    case 2: 
      this.faV.post(new RecordMsgFileUI.4(this));
      AppMethodBeat.o(24283);
      return;
    case 4: 
      this.faV.post(new RecordMsgFileUI.5(this));
      AppMethodBeat.o(24283);
      return;
    }
    this.faV.post(new RecordMsgFileUI.6(this));
    AppMethodBeat.o(24283);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969579;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24280);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131299009, 2131299010, 5);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(24280);
      return;
    }
    if (paramInt1 == 1001)
    {
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label139;
        }
      }
      Object localObject2;
      label139:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = h.b(getContext(), getString(2131299734), false, null);
        ab.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new RecordMsgFileUI.13(this, (Dialog)localObject2);
        if (!bo.isNullOrNil((String)localObject1)) {
          break label150;
        }
        AppMethodBeat.o(24280);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label150:
      Object localObject1 = bo.P(((String)localObject1).split(","));
      if ((getType() == 4) || (getType() == 15))
      {
        aw.RO().ac(new RecordMsgFileUI.14(this, (List)localObject1, paramIntent, (Runnable)localObject2));
        AppMethodBeat.o(24280);
        return;
      }
      aw.RO().ac(new RecordMsgFileUI.2(this, (List)localObject1, paramIntent, (Runnable)localObject2));
    }
    AppMethodBeat.o(24280);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24272);
    super.onCreate(paramBundle);
    this.faV = new ak();
    this.pZM = new l();
    this.cpO = getIntent().getLongExtra("message_id", -1L);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = n.XS(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      ab.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(24272);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).fjy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject).next();
      if (localaca.mBq.equals(paramBundle)) {
        this.cuL = localaca;
      }
    }
    if (this.cuL == null)
    {
      ab.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(24272);
      return;
    }
    this.cBO = n.h(this.cuL.mBq, this.cpO, true);
    this.mzL = ((Button)findViewById(2131824113));
    this.mzM = ((Button)findViewById(2131824114));
    this.mzN = ((Button)findViewById(2131822726));
    this.mzO = ((MMImageView)findViewById(2131821253));
    this.gzk = ((TextView)findViewById(2131821254));
    this.ivt = ((TextView)findViewById(2131823916));
    this.mzR = findViewById(2131821564);
    this.mzQ = findViewById(2131821562);
    this.progressBar = ((ProgressBar)findViewById(2131821563));
    this.mzP = ((TextView)findViewById(2131824112));
    label365:
    label500:
    int i;
    label528:
    int j;
    if (4 == getType())
    {
      setMMTitle(2131299853);
      if (getType() != 4) {
        break label635;
      }
      this.mzO.setImageResource(2131230826);
      this.gzk.setText(this.cuL.title);
      setBackBtn(new RecordMsgFileUI.1(this));
      this.mzM.setOnClickListener(new RecordMsgFileUI.7(this));
      paramBundle = this.cuL.wSJ;
      if (!bo.isNullOrNil(paramBundle)) {
        this.mzL.setOnClickListener(new RecordMsgFileUI.8(this, paramBundle));
      }
      this.mzN.setOnClickListener(new RecordMsgFileUI.9(this));
      this.mzR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24262);
          RecordMsgFileUI.g(RecordMsgFileUI.this);
          AppMethodBeat.o(24262);
        }
      });
      if ((getType() != 15) || (bo.apV(com.tencent.mm.m.g.Nq().getValue("SightForwardEnable")) == 1)) {
        break label655;
      }
      ab.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      if ((!bo.isNullOrNil(this.cuL.wSC)) && (!bo.isNullOrNil(this.cuL.wSE))) {
        break label674;
      }
      i = 1;
      if ((!bo.isNullOrNil(this.cuL.wTU)) && (!bo.isNullOrNil(this.cuL.wTR))) {
        break label679;
      }
      j = 1;
      label556:
      if ((i != 0) || (j != 0)) {
        break label684;
      }
      bxY();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      AppMethodBeat.o(24272);
      return;
      if (15 == getType())
      {
        setMMTitle(2131299827);
        findViewById(2131824108).setBackgroundResource(2131689763);
        break;
      }
      setMMTitle(2131299732);
      break;
      label635:
      this.mzO.setImageResource(com.tencent.mm.pluginsdk.d.akU(this.cuL.wSR));
      break label365;
      label655:
      addIconOptionMenu(0, 2130839668, new RecordMsgFileUI.11(this));
      break label500;
      label674:
      i = 0;
      break label528;
      label679:
      j = 0;
      break label556;
      label684:
      if (!n.d(this.cuL, this.cpO)) {
        break label710;
      }
      enableOptionMenu(true);
      byc();
    }
    label710:
    paramBundle = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(this.cBO);
    if ((paramBundle == null) || (2 == paramBundle.field_status)) {
      bya();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == paramBundle.field_status)
      {
        bxY();
      }
      else if ((paramBundle.field_status == 0) || (1 == paramBundle.field_status))
      {
        bxZ();
      }
      else
      {
        ab.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        bya();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24277);
    if (this.kvG != null)
    {
      this.kvG.setVideoCallback(null);
      this.kvG.stop();
      this.kvG.onDetach();
      if (aw.BY() != null) {
        aw.BY().Ib();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    this.pZM.destory();
    AppMethodBeat.o(24277);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24279);
    super.onPause();
    if (this.kvG != null) {
      this.kvG.stop();
    }
    AppMethodBeat.o(24279);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24278);
    super.onResume();
    if (this.kvG != null) {
      this.kvG.start();
    }
    AppMethodBeat.o(24278);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI
 * JD-Core Version:    0.7.0.1
 */