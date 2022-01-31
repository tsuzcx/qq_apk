package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cd;
import com.tencent.mm.ui.MMActivity;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private final String TAG;
  private long eaY;
  private ScrollView hLr;
  private int ixT;
  private bi kEz;
  private View ldP;
  private ak mHandler;
  private int mTouchSlop;
  private Button mkS;
  private long pSw;
  private cc sVM;
  private a sVT;
  private c sVU;
  private b sVV;
  private com.tencent.mm.modelvoice.b sVW;
  private volatile boolean sVY;
  private boolean sVZ;
  private ap sWa;
  private int tW;
  private View.OnLongClickListener taA;
  private View tam;
  private View tan;
  private LinearLayout tao;
  private TextView tap;
  private int taq;
  private boolean tar;
  private r tas;
  private com.tencent.mm.sdk.b.c tat;
  private boolean tau;
  private boolean tav;
  private int taw;
  private View.OnTouchListener tax;
  private View.OnClickListener tay;
  private ClipboardManager taz;
  
  public VoiceTransTextUI()
  {
    AppMethodBeat.i(25609);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.ldP = null;
    this.tam = null;
    this.tan = null;
    this.tao = null;
    this.tap = null;
    this.mkS = null;
    this.hLr = null;
    this.sVY = false;
    this.taq = 6;
    this.sVZ = false;
    this.tar = false;
    this.tau = false;
    this.tav = false;
    this.pSw = 0L;
    this.tay = new VoiceTransTextUI.1(this);
    this.taA = new VoiceTransTextUI.2(this);
    this.mHandler = new VoiceTransTextUI.6(this);
    AppMethodBeat.o(25609);
  }
  
  private long HA()
  {
    if (this.tas == null) {
      return -1L;
    }
    return this.tas.cFn;
  }
  
  private void a(VoiceTransTextUI.a parama)
  {
    AppMethodBeat.i(25612);
    cHg();
    switch (9.taF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25612);
      return;
      ab.i("MicroMsg.VoiceTransTextUI", "net check");
      if (HA() > 0L) {
        ab.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(HA()) });
      }
      for (this.sVT = new a(cHh(), cHi(), cHj().getFormat(), HA(), getFileName());; this.sVT = new a(cHh(), cHi(), getFileName()))
      {
        aw.Rc().a(this.sVT, 0);
        aw.Rc().a(this.sVT.getType(), this);
        if (this.tat != null) {
          break;
        }
        cHk();
        AppMethodBeat.o(25612);
        return;
        ab.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(HA()) });
      }
      ab.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.sVT == null)
      {
        ab.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        AppMethodBeat.o(25612);
        return;
      }
      if (cHj() == null)
      {
        ab.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
        AppMethodBeat.o(25612);
        return;
      }
      this.sVU = new c(cHh(), this.sVT.tai, cHj().getFormat(), getFileName());
      aw.Rc().a(this.sVU, 0);
      aw.Rc().a(this.sVU.getType(), this);
      AppMethodBeat.o(25612);
      return;
      ab.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.sVU == null)
      {
        ab.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        AppMethodBeat.o(25612);
        return;
      }
      this.sVU = new c(this.sVU);
      aw.Rc().a(this.sVU, 0);
      aw.Rc().a(this.sVU.getType(), this);
      AppMethodBeat.o(25612);
      return;
      this.tar = false;
      if (this.sVY)
      {
        ab.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        AppMethodBeat.o(25612);
        return;
      }
      ab.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.sVT == null)
      {
        ab.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        AppMethodBeat.o(25612);
        return;
      }
      this.sVY = true;
      this.sVV = new b(cHh());
      aw.Rc().a(this.sVV, 0);
      aw.Rc().a(this.sVV.getType(), this);
    }
  }
  
  private void a(b paramb, String paramString)
  {
    AppMethodBeat.i(25613);
    switch (9.taG[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if ((paramb != b.taM) && (paramb != b.taO)) {
        break label239;
      }
      this.hLr.setOnTouchListener(this.tax);
      this.ldP.setOnClickListener(this.tay);
      AppMethodBeat.o(25613);
      return;
      if (bo.isNullOrNil(paramString))
      {
        paramb = b.taO;
        paramString = null;
        break;
      }
      this.tao.setVisibility(0);
      this.tam.setVisibility(8);
      this.mkS.setVisibility(4);
      this.tan.setVisibility(8);
      this.tap.setText(paramString);
      mx(true);
      continue;
      this.tao.setVisibility(0);
      this.tam.setVisibility(0);
      this.mkS.setVisibility(0);
      if (paramString != null)
      {
        this.tap.setText(paramString);
        mx(false);
        continue;
        this.tao.setVisibility(8);
        this.tam.setVisibility(8);
        this.mkS.setHeight(0);
        this.mkS.setVisibility(8);
        this.tan.setVisibility(0);
      }
    }
    label239:
    this.hLr.setOnTouchListener(null);
    this.ldP.setOnClickListener(null);
    AppMethodBeat.o(25613);
  }
  
  private cc adO(String paramString)
  {
    AppMethodBeat.i(25616);
    cc localcc = new cc();
    localcc.field_msgId = this.eaY;
    localcc.asH(cHh());
    localcc.field_content = paramString;
    AppMethodBeat.o(25616);
    return localcc;
  }
  
  private void adY(String paramString)
  {
    AppMethodBeat.i(25620);
    this.sVZ = true;
    if (!bo.isNullOrNil(paramString)) {
      o.amt().a(adO(paramString));
    }
    a(b.taM, paramString);
    AppMethodBeat.o(25620);
  }
  
  private void cHg()
  {
    AppMethodBeat.i(25614);
    ab.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.sVT != null)
    {
      aw.Rc().a(this.sVT);
      aw.Rc().b(this.sVT.getType(), this);
    }
    if (this.sVU != null)
    {
      aw.Rc().a(this.sVU);
      aw.Rc().b(this.sVU.getType(), this);
    }
    if (this.sVV != null)
    {
      aw.Rc().a(this.sVV);
      aw.Rc().b(this.sVV.getType(), this);
    }
    AppMethodBeat.o(25614);
  }
  
  private String cHh()
  {
    AppMethodBeat.i(25615);
    if (this.tas != null)
    {
      str = this.tas.clientId;
      AppMethodBeat.o(25615);
      return str;
    }
    String str = this.kEz.field_talker + this.kEz.field_msgId + "T" + this.kEz.field_createTime;
    AppMethodBeat.o(25615);
    return str;
  }
  
  private int cHi()
  {
    AppMethodBeat.i(25617);
    if (this.tas != null)
    {
      i = this.tas.fsd;
      AppMethodBeat.o(25617);
      return i;
    }
    int i = q.vh(this.kEz.field_imgPath);
    AppMethodBeat.o(25617);
    return i;
  }
  
  private com.tencent.mm.modelvoice.b cHj()
  {
    AppMethodBeat.i(25618);
    if (this.sVW == null)
    {
      if (this.tas == null) {
        break label47;
      }
      this.sVW = s.vK(this.tas.fileName);
    }
    for (;;)
    {
      com.tencent.mm.modelvoice.b localb = this.sVW;
      AppMethodBeat.o(25618);
      return localb;
      label47:
      if (this.kEz != null) {
        this.sVW = s.vK(this.kEz.field_imgPath);
      } else {
        ab.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
      }
    }
  }
  
  private void cHk()
  {
    AppMethodBeat.i(25622);
    if (this.tat == null) {
      this.tat = new VoiceTransTextUI.5(this);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.tat);
    AppMethodBeat.o(25622);
  }
  
  private String getFileName()
  {
    if (this.tas != null) {
      return this.tas.fileName;
    }
    return this.kEz.field_imgPath;
  }
  
  private void mx(boolean paramBoolean)
  {
    AppMethodBeat.i(25624);
    if ((this.hLr == null) || (this.tao == null))
    {
      AppMethodBeat.o(25624);
      return;
    }
    this.mHandler.postDelayed(new VoiceTransTextUI.7(this, paramBoolean), 5L);
    AppMethodBeat.o(25624);
  }
  
  public int getLayoutId()
  {
    return 2130971106;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25611);
    setMMTitle(2131304602);
    this.mkS.setOnClickListener(this);
    if ((this.sVM != null) && (!bo.isNullOrNil(this.sVM.field_content)))
    {
      a(b.taM, this.sVM.field_content);
      if ((this.hLr != null) && (this.tao != null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label109;
      }
      AppMethodBeat.o(25611);
      return;
      this.mHandler.postDelayed(new VoiceTransTextUI.8(this), 5L);
      break;
    }
    label109:
    a(b.taN, null);
    a(VoiceTransTextUI.a.taH);
    AppMethodBeat.o(25611);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(25623);
    finish();
    AppMethodBeat.o(25623);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(25610);
    super.onCreate(paramBundle);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.taz = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    this.ldP = findViewById(2131828807);
    this.tam = findViewById(2131828812);
    this.tan = findViewById(2131828814);
    this.tap = ((TextView)findViewById(2131828811));
    this.mkS = ((Button)findViewById(2131828809));
    this.tao = ((LinearLayout)findViewById(2131828808));
    this.hLr = ((ScrollView)findViewById(2131822700));
    this.tax = new VoiceTransTextUI.3(this);
    this.tap.setOnLongClickListener(this.taA);
    this.tap.setOnClickListener(this.tay);
    this.eaY = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.eaY < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        AppMethodBeat.o(25610);
        return;
        ab.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.eaY) });
        cd localcd = o.amt();
        long l = this.eaY;
        if (l < 0L) {
          paramBundle = localCursor;
        }
        for (;;)
        {
          this.sVM = paramBundle;
          if ((this.sVM == null) || (bo.isNullOrNil(this.sVM.field_content))) {
            break label364;
          }
          ab.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new cc();
          localCursor = localcd.db.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (localCursor.moveToFirst()) {
            paramBundle.convertFrom(localCursor);
          }
          localCursor.close();
        }
        label364:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (bo.isNullOrNil(paramBundle))
        {
          i = 0;
          continue;
        }
        this.tas = o.ams().vW(paramBundle);
        if (this.tas != null)
        {
          ab.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        aw.aaz();
        this.kEz = com.tencent.mm.model.c.YC().kB(this.eaY);
        if (this.kEz != null)
        {
          ab.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
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
        AppMethodBeat.o(25610);
        return;
      }
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25621);
    cHg();
    if (this.sWa != null) {
      this.sWa.stopTimer();
    }
    if (this.tat != null)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.tat);
      this.tat = null;
    }
    super.onDestroy();
    AppMethodBeat.o(25621);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(25619);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramm.getType())
    {
    default: 
      AppMethodBeat.o(25619);
      return;
    case 546: 
      if (this.sVT.mState == a.taf)
      {
        ab.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = localObject;
        if (this.sVT.cHd()) {
          paramString = this.sVT.tah.xZS;
        }
        adY(paramString);
        AppMethodBeat.o(25619);
        return;
      }
      if (this.sVT.mState == a.tae)
      {
        if ((this.sVT.tah != null) && (bo.isNullOrNil(this.sVT.tah.xZS))) {
          a(b.taN, this.sVT.tah.xZS);
        }
        ab.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        a(VoiceTransTextUI.a.taK);
        AppMethodBeat.o(25619);
        return;
      }
      if (this.sVT.mState == a.tad)
      {
        ab.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        a(VoiceTransTextUI.a.taI);
        AppMethodBeat.o(25619);
        return;
      }
      if (this.sVT.taj != null)
      {
        this.taq = this.sVT.taj.xEz;
        AppMethodBeat.o(25619);
        return;
      }
      break;
    case 547: 
      if (this.sVU.cHf())
      {
        ab.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        a(VoiceTransTextUI.a.taK);
        AppMethodBeat.o(25619);
        return;
      }
      ab.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.sVU.tai.pIy), Integer.valueOf(this.sVU.tai.pIz) });
      a(VoiceTransTextUI.a.taJ);
      AppMethodBeat.o(25619);
      return;
    case 548: 
      this.taq = this.sVV.tal;
      this.sVY = false;
      if ((!this.sVV.isComplete()) && (this.sVV.cHd()))
      {
        paramm = this.sVV.tah.xZS;
        a(b.taN, paramm);
        ab.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.sVV.tah.xZS });
      }
      while (this.sVV.isComplete())
      {
        ab.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.sVV.cHd()) {
          paramString = this.sVV.tah.xZS;
        }
        adY(paramString);
        AppMethodBeat.o(25619);
        return;
        if (!this.sVV.cHd()) {
          ab.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.tar)
      {
        ab.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        a(VoiceTransTextUI.a.taK);
        AppMethodBeat.o(25619);
        return;
      }
      ab.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.taq) });
      paramInt1 = this.taq;
      if (!this.sVZ)
      {
        if (this.sWa == null) {
          this.sWa = new ap(new VoiceTransTextUI.4(this, paramInt1), false);
        }
        paramString = this.sWa;
        long l = paramInt1 * 1000;
        paramString.ag(l, l);
      }
      AppMethodBeat.o(25619);
      return;
      this.sVZ = true;
      a(b.taO, null);
    }
    AppMethodBeat.o(25619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(25608);
      taM = new b("done", 0);
      taN = new b("loading", 1);
      taO = new b("fail", 2);
      taP = new b[] { taM, taN, taO };
      AppMethodBeat.o(25608);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI
 * JD-Core Version:    0.7.0.1
 */