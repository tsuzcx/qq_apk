package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG = "MicroMsg.VoiceTransTextUI";
  private long djE;
  private int gUK;
  private ScrollView gqx = null;
  private View iUL = null;
  private Button jQx = null;
  private int jb;
  private ah mHandler = new VoiceTransTextUI.6(this);
  private long nni = 0L;
  private cc pum;
  private a pus;
  private c put;
  private b puu;
  private com.tencent.mm.modelvoice.b puv;
  private volatile boolean pux = false;
  private boolean puy = false;
  private am puz;
  private LinearLayout pyA = null;
  private TextView pyB = null;
  private int pyC = 6;
  private boolean pyD = false;
  private com.tencent.mm.modelvoice.p pyE;
  private bi pyF;
  private com.tencent.mm.sdk.b.c pyG;
  private boolean pyH = false;
  private boolean pyI = false;
  private int pyJ;
  private View.OnTouchListener pyK;
  private View.OnClickListener pyL = new VoiceTransTextUI.1(this);
  private ClipboardManager pyM;
  private View.OnLongClickListener pyN = new VoiceTransTextUI.2(this);
  private View pyy = null;
  private View pyz = null;
  private int sU;
  
  private void PF(String paramString)
  {
    this.puy = true;
    if (!bk.bl(paramString))
    {
      cd localcd = com.tencent.mm.modelvoice.m.Th();
      cc localcc = new cc();
      localcc.field_msgId = this.djE;
      localcc.acv(bMj());
      localcc.field_content = paramString;
      localcd.a(localcc);
    }
    a(VoiceTransTextUI.b.pyZ, paramString);
  }
  
  private void a(VoiceTransTextUI.a parama)
  {
    bMi();
    switch (VoiceTransTextUI.9.pyS[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      y.i("MicroMsg.VoiceTransTextUI", "net check");
      if (vu() > 0L) {
        y.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(vu()) });
      }
      for (this.pus = new a(bMj(), bMk(), bMl().getFormat(), vu(), getFileName());; this.pus = new a(bMj(), bMk(), getFileName()))
      {
        au.Dk().a(this.pus, 0);
        au.Dk().a(this.pus.getType(), this);
        if (this.pyG != null) {
          break;
        }
        if (this.pyG == null) {
          this.pyG = new VoiceTransTextUI.5(this);
        }
        com.tencent.mm.sdk.b.a.udP.c(this.pyG);
        return;
        y.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(vu()) });
      }
    case 2: 
      y.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.pus == null)
      {
        y.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        return;
      }
      if (bMl() == null)
      {
        y.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
        return;
      }
      this.put = new c(bMj(), this.pus.pyu, bMl().getFormat(), getFileName());
      au.Dk().a(this.put, 0);
      au.Dk().a(this.put.getType(), this);
      return;
    case 3: 
      y.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.put == null)
      {
        y.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        return;
      }
      this.put = new c(this.put);
      au.Dk().a(this.put, 0);
      au.Dk().a(this.put.getType(), this);
      return;
    }
    this.pyD = false;
    if (this.pux)
    {
      y.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
      return;
    }
    y.i("MicroMsg.VoiceTransTextUI", "net get");
    if (this.pus == null)
    {
      y.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
      return;
    }
    this.pux = true;
    this.puu = new b(bMj());
    au.Dk().a(this.puu, 0);
    au.Dk().a(this.puu.getType(), this);
  }
  
  private void a(VoiceTransTextUI.b paramb, String paramString)
  {
    switch (VoiceTransTextUI.9.pyT[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != VoiceTransTextUI.b.pyZ) && (paramb != VoiceTransTextUI.b.pzb)) {
        break label229;
      }
      this.gqx.setOnTouchListener(this.pyK);
      this.iUL.setOnClickListener(this.pyL);
      return;
      if (bk.bl(paramString))
      {
        paramb = VoiceTransTextUI.b.pzb;
        paramString = null;
        break;
      }
      this.pyA.setVisibility(0);
      this.pyy.setVisibility(8);
      this.jQx.setVisibility(4);
      this.pyz.setVisibility(8);
      this.pyB.setText(paramString);
      jF(true);
      continue;
      this.pyA.setVisibility(0);
      this.pyy.setVisibility(0);
      this.jQx.setVisibility(0);
      if (paramString != null)
      {
        this.pyB.setText(paramString);
        jF(false);
        continue;
        this.pyA.setVisibility(8);
        this.pyy.setVisibility(8);
        this.jQx.setHeight(0);
        this.jQx.setVisibility(8);
        this.pyz.setVisibility(0);
      }
    }
    label229:
    this.gqx.setOnTouchListener(null);
    this.iUL.setOnClickListener(null);
  }
  
  private void bMi()
  {
    y.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.pus != null)
    {
      au.Dk().c(this.pus);
      au.Dk().b(this.pus.getType(), this);
    }
    if (this.put != null)
    {
      au.Dk().c(this.put);
      au.Dk().b(this.put.getType(), this);
    }
    if (this.puu != null)
    {
      au.Dk().c(this.puu);
      au.Dk().b(this.puu.getType(), this);
    }
  }
  
  private String bMj()
  {
    if (this.pyE != null) {
      return this.pyE.clientId;
    }
    return this.pyF.field_talker + this.pyF.field_msgId + "T" + this.pyF.field_createTime;
  }
  
  private int bMk()
  {
    if (this.pyE != null) {
      return this.pyE.ebK;
    }
    return o.nU(this.pyF.field_imgPath);
  }
  
  private com.tencent.mm.modelvoice.b bMl()
  {
    if (this.puv == null)
    {
      if (this.pyE == null) {
        break label33;
      }
      this.puv = q.ox(this.pyE.fileName);
    }
    for (;;)
    {
      return this.puv;
      label33:
      if (this.pyF != null) {
        this.puv = q.ox(this.pyF.field_imgPath);
      } else {
        y.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
      }
    }
  }
  
  private String getFileName()
  {
    if (this.pyE != null) {
      return this.pyE.fileName;
    }
    return this.pyF.field_imgPath;
  }
  
  private void jF(boolean paramBoolean)
  {
    if ((this.gqx == null) || (this.pyA == null)) {
      return;
    }
    this.mHandler.postDelayed(new VoiceTransTextUI.7(this, paramBoolean), 5L);
  }
  
  private long vu()
  {
    if (this.pyE == null) {
      return -1L;
    }
    return this.pyE.bXr;
  }
  
  protected final int getLayoutId()
  {
    return R.i.voice_trans_text_view;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.voice_trans_text_title);
    this.jQx.setOnClickListener(this);
    if ((this.pum != null) && (!bk.bl(this.pum.field_content)))
    {
      a(VoiceTransTextUI.b.pyZ, this.pum.field_content);
      if ((this.gqx != null) && (this.pyA != null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label97;
      }
      return;
      this.mHandler.postDelayed(new VoiceTransTextUI.8(this), 5L);
      break;
    }
    label97:
    a(VoiceTransTextUI.b.pza, null);
    a(VoiceTransTextUI.a.pyU);
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Cursor localCursor = null;
    super.onCreate(paramBundle);
    this.jb = ViewConfiguration.get(this.mController.uMN).getScaledTouchSlop();
    this.pyM = ((ClipboardManager)getSystemService("clipboard"));
    this.iUL = findViewById(R.h.voice_trans_text_root);
    this.pyy = findViewById(R.h.voice_trans_load);
    this.pyz = findViewById(R.h.voice_trans_text_fail_root);
    this.pyB = ((TextView)findViewById(R.h.voice_trans_text_content));
    this.jQx = ((Button)findViewById(R.h.voice_trans_text_cancel));
    this.pyA = ((LinearLayout)findViewById(R.h.voice_trans_text_content_layout));
    this.gqx = ((ScrollView)findViewById(R.h.full_screen_scroll_container));
    this.pyK = new VoiceTransTextUI.3(this);
    this.pyB.setOnLongClickListener(this.pyN);
    this.pyB.setOnClickListener(this.pyL);
    this.djE = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.djE < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        y.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        return;
        y.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.djE) });
        cd localcd = com.tencent.mm.modelvoice.m.Th();
        long l = this.djE;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.pum = paramBundle;
          if ((this.pum == null) || (bk.bl(this.pum.field_content))) {
            break label353;
          }
          y.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cc();
          localCursor = localcd.dXw.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.d(localCursor);
          }
          localCursor.close();
        }
        label353:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (bk.bl(paramBundle))
        {
          i = 0;
          continue;
        }
        this.pyE = com.tencent.mm.modelvoice.m.Tg().oJ(paramBundle);
        if (this.pyE != null)
        {
          y.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        au.Hx();
        this.pyF = com.tencent.mm.model.c.Fy().fd(this.djE);
        if (this.pyF != null)
        {
          y.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
          i = 1;
        }
      }
      else
      {
        paramBundle = getSupportActionBar();
        if (paramBundle != null) {
          paramBundle.hide();
        }
        initView();
        return;
      }
      i = 0;
    }
  }
  
  protected void onDestroy()
  {
    bMi();
    if (this.puz != null) {
      this.puz.stopTimer();
    }
    if (this.pyG != null)
    {
      com.tencent.mm.sdk.b.a.udP.d(this.pyG);
      this.pyG = null;
    }
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    paramString = null;
    Object localObject = null;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      do
      {
        do
        {
          return;
          if (this.pus.mState == a.pys)
          {
            y.i("MicroMsg.VoiceTransTextUI", "check result: done");
            paramString = localObject;
            if (this.pus.bMf()) {
              paramString = this.pus.pyt.tSA;
            }
            PF(paramString);
            return;
          }
          if (this.pus.mState == a.pyr)
          {
            if ((this.pus.pyt != null) && (bk.bl(this.pus.pyt.tSA))) {
              a(VoiceTransTextUI.b.pza, this.pus.pyt.tSA);
            }
            y.i("MicroMsg.VoiceTransTextUI", "check result: processing");
            a(VoiceTransTextUI.a.pyX);
            return;
          }
          if (this.pus.mState == a.pyq)
          {
            y.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
            a(VoiceTransTextUI.a.pyV);
            return;
          }
        } while (this.pus.pyv == null);
        this.pyC = this.pus.pyv.tCw;
        return;
        if (this.put.bMh())
        {
          y.i("MicroMsg.VoiceTransTextUI", "succeed upload");
          a(VoiceTransTextUI.a.pyX);
          return;
        }
        y.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.put.pyu.ndg), Integer.valueOf(this.put.pyu.ndh) });
        a(VoiceTransTextUI.a.pyW);
        return;
        this.pyC = this.puu.pyx;
        this.pux = false;
        if ((!this.puu.isComplete()) && (this.puu.bMf()))
        {
          paramm = this.puu.pyt.tSA;
          a(VoiceTransTextUI.b.pza, paramm);
          y.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.puu.pyt.tSA });
        }
        while (this.puu.isComplete())
        {
          y.i("MicroMsg.VoiceTransTextUI", "succeed get");
          if (this.puu.bMf()) {
            paramString = this.puu.pyt.tSA;
          }
          PF(paramString);
          return;
          if (!this.puu.bMf()) {
            y.d("MicroMsg.VoiceTransTextUI", "result not valid");
          }
        }
        if (this.pyD)
        {
          y.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
          a(VoiceTransTextUI.a.pyX);
          return;
        }
        y.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.pyC) });
        paramInt1 = this.pyC;
      } while (this.puy);
      if (this.puz == null) {
        this.puz = new am(new VoiceTransTextUI.4(this, paramInt1), false);
      }
      paramString = this.puz;
      long l = paramInt1 * 1000;
      paramString.S(l, l);
      return;
    }
    this.puy = true;
    a(VoiceTransTextUI.b.pzb, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */