package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.k;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;

public class MailImageDownloadUI
  extends MMActivity
  implements com.tencent.mm.ai.f, com.tencent.mm.ai.g
{
  private long cFn;
  private long cpO;
  private int fDP;
  private ak handler;
  private TextView lbt;
  private ProgressBar pNT;
  private TextView pNU;
  private TextView pNV;
  private TextView pNW;
  private RelativeLayout pNX;
  private com.tencent.mm.at.e pNY;
  private k pNZ;
  private ImageView pOa;
  private LinearLayout pOb;
  private String username;
  
  public MailImageDownloadUI()
  {
    AppMethodBeat.i(68382);
    this.handler = new ak(Looper.getMainLooper());
    this.cpO = 0L;
    this.cFn = 0L;
    AppMethodBeat.o(68382);
  }
  
  private void Cb(int paramInt)
  {
    AppMethodBeat.i(68387);
    this.pNU.setText(getString(2131300064, new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt < this.pNT.getMax())
    {
      AppMethodBeat.o(68387);
      return;
    }
    com.tencent.mm.at.e locale = o.ahC().b(Long.valueOf(this.pNZ.fFk));
    if (this.fDP == 1) {
      com.tencent.mm.at.f.c(locale);
    }
    finish();
    startActivity(getIntent());
    AppMethodBeat.o(68387);
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(68388);
    ab.d("MicroMsg.MailImageDownloadUI", "offset " + paramInt1 + "totaolLen  " + paramInt2);
    if (paramm.getType() == 109) {
      if (paramInt2 == 0) {
        break label72;
      }
    }
    label72:
    for (paramInt1 = paramInt1 * 100 / paramInt2 - 1;; paramInt1 = 0)
    {
      Cb(Math.max(0, paramInt1));
      AppMethodBeat.o(68388);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970065;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68386);
    this.pNU = ((TextView)findViewById(2131825880));
    this.pNV = ((TextView)findViewById(2131825880));
    this.lbt = ((TextView)findViewById(2131825881));
    this.pNW = ((TextView)findViewById(2131825882));
    this.pOa = ((ImageView)findViewById(2131825878));
    this.pNU.setVisibility(0);
    this.pOb = ((LinearLayout)findViewById(2131825879));
    this.pNX = ((RelativeLayout)findViewById(2131825876));
    this.pNV.setVisibility(8);
    this.lbt.setVisibility(8);
    this.pNW.setVisibility(8);
    setTitleVisibility(8);
    setBackBtn(new MailImageDownloadUI.1(this));
    this.pNT = ((ProgressBar)findViewById(2131825877));
    AppMethodBeat.o(68386);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68383);
    super.onCreate(paramBundle);
    this.cpO = getIntent().getLongExtra("img_msg_id", 0L);
    this.cFn = getIntent().getLongExtra("img_server_id", 0L);
    this.fDP = getIntent().getIntExtra("img_download_compress_type", 0);
    this.username = getIntent().getStringExtra("img_download_username");
    initView();
    if (this.cpO > 0L) {
      this.pNY = o.ahC().gT(this.cpO);
    }
    if (((this.pNY == null) || (this.pNY.fDL <= 0L)) && (this.cFn > 0L)) {
      this.pNY = o.ahC().gS(this.cFn);
    }
    if ((this.pNY == null) || (this.pNY.fDL <= 0L))
    {
      ab.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.cpO + ", or msgSvrId = " + this.cFn);
      AppMethodBeat.o(68383);
      return;
    }
    if ((this.cpO <= 0L) && (this.cFn > 0L)) {
      this.cpO = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().ag(this.username, this.cFn).field_msgId;
    }
    paramBundle = this.pNY.fDM;
    String str = o.ahC().q(paramBundle, null, null);
    if ((!bo.isNullOrNil(paramBundle)) && (com.tencent.mm.vfs.e.cN(str)))
    {
      ab.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[] { paramBundle, Boolean.valueOf(this.pNY.ahh()), str });
      if ((str == null) || (str.equals("")) || (!com.tencent.mm.vfs.e.cN(str)))
      {
        ab.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
        AppMethodBeat.o(68383);
        return;
      }
      this.pOb.setVisibility(8);
      this.pNT.setVisibility(8);
      this.pOa.setVisibility(0);
      paramBundle = d.aoV(str);
      this.pOa.setImageBitmap(paramBundle);
      this.pNX.invalidate();
      AppMethodBeat.o(68383);
      return;
    }
    this.pNZ = new k(this.pNY.fDL, this.cpO, this.fDP, this);
    com.tencent.mm.kernel.g.RK().eHt.a(this.pNZ, 0);
    AppMethodBeat.o(68383);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68384);
    super.onPause();
    com.tencent.mm.kernel.g.RK().eHt.b(109, this);
    AppMethodBeat.o(68384);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68385);
    super.onResume();
    com.tencent.mm.kernel.g.RK().eHt.a(109, this);
    AppMethodBeat.o(68385);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(68389);
    if (paramm.getType() != 109)
    {
      AppMethodBeat.o(68389);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Cb(this.pNT.getMax());
      AppMethodBeat.o(68389);
      return;
    }
    ab.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    Toast.makeText(this, 2131300726, 1).show();
    AppMethodBeat.o(68389);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI
 * JD-Core Version:    0.7.0.1
 */