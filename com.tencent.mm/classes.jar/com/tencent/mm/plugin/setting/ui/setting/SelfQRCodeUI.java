package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class SelfQRCodeUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private static final String PATH;
  private ProgressDialog eeN = null;
  private Bitmap frG = null;
  private ImageView ivs = null;
  private TextView jXY = null;
  private long kRf;
  private ImageView qFD = null;
  private byte[] qFE = null;
  private TextView qGv = null;
  private boolean qGw = false;
  private LinearLayout qGx;
  private SelfQRCodeUI.b qGy;
  private String userName = "";
  
  static
  {
    AppMethodBeat.i(127039);
    PATH = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(127039);
  }
  
  private void CX(int paramInt)
  {
    AppMethodBeat.i(127031);
    if (this.qGw) {}
    for (int i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(66561, null));; i = 0)
    {
      Object localObject;
      if (t.nK(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131297087);
        this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131303082), true, new SelfQRCodeUI.9(this, (com.tencent.mm.ai.m)localObject));
        AppMethodBeat.o(127031);
        return;
        localObject = new com.tencent.mm.bb.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, SelfQRCodeUI.a parama)
  {
    AppMethodBeat.i(127033);
    if (com.tencent.mm.plugin.setting.b.gmP.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(127033);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131300095, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(127033);
      return;
    }
    this.qFE = parama.cjX();
    this.frG = d.bT(this.qFE);
    if ((t.nI(this.userName)) || (com.tencent.mm.aj.f.rX(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.cjY();
      if (!bo.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131821068)).setText(paramString);
      }
    }
    for (;;)
    {
      this.qFD.setImageBitmap(this.frG);
      AppMethodBeat.o(127033);
      return;
      if (this.qGw)
      {
        paramString = parama.cjZ();
        parama = (TextView)findViewById(2131827562);
        View localView = (View)parama.getParent();
        if (!bo.isNullOrNil(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new SelfQRCodeUI.4(this));
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  public static void cjW()
  {
    AppMethodBeat.i(127034);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 14L, 1L, true);
    AppMethodBeat.o(127034);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970671;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127030);
    this.userName = getIntent().getStringExtra("from_userName");
    if (bo.isNullOrNil(this.userName)) {
      this.userName = r.Zn();
    }
    if (r.Zn().equals(this.userName)) {
      this.qGw = true;
    }
    Object localObject1;
    Object localObject2;
    if (t.nI(this.userName))
    {
      setMMTitle(2131303404);
      ((TextView)findViewById(2131821068)).setText("");
      enableOptionMenu(false);
      this.qGx = ((LinearLayout)findViewById(2131827560));
      this.qFD = ((ImageView)findViewById(2131821065));
      this.ivs = ((ImageView)findViewById(2131821061));
      this.jXY = ((TextView)findViewById(2131821063));
      this.qGv = ((TextView)findViewById(2131821064));
      this.qGx.getViewTreeObserver().addOnPreDrawListener(new SelfQRCodeUI.5(this));
      if ((!t.nI(this.userName)) && (!com.tencent.mm.aj.f.rX(this.userName))) {
        break label471;
      }
      CX(1);
      a.b.c(this.ivs, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.userName);
      this.jXY.setSingleLine(false);
      this.jXY.setMaxLines(3);
      if (!t.nK(this.userName)) {
        break label445;
      }
      localObject2 = getResources().getDrawable(2131231831);
      this.jXY.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label287:
      if (localObject1 == null) {
        break label459;
      }
      localObject2 = ((aq)localObject1).field_nickname;
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ().oV(this.userName).field_displayname;
      }
      this.jXY.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, this.jXY.getTextSize()));
      label351:
      this.qGv.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2130839668, new SelfQRCodeUI.6(this));
      setBackBtn(new SelfQRCodeUI.7(this));
      AppMethodBeat.o(127030);
      return;
      if (com.tencent.mm.aj.f.rX(this.userName))
      {
        setMMTitle(2131299319);
        ((TextView)findViewById(2131821068)).setText(2131299320);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131303392);
      break;
      label445:
      this.jXY.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label287;
      label459:
      this.jXY.setVisibility(8);
      break label351;
      label471:
      localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(42, null);
      localObject1 = getString(2131296950);
      if (!bo.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label521:
        ab.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.frG != null) {
          break label813;
        }
        ab.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        CX(1);
      }
      for (;;)
      {
        a.b.c(this.ivs, r.Zn());
        localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(4, null);
        ab.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.jXY.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, com.tencent.mm.cb.a.ao(getContext(), 2131427758)));
        localObject2 = bp.aba();
        localObject1 = bo.nullAsNil(((bp)localObject2).getProvince());
        localObject2 = bo.nullAsNil(((bp)localObject2).getCity());
        localObject1 = s.nG((String)localObject1) + " " + (String)localObject2;
        ab.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.qGv.setText((CharSequence)localObject1);
        switch (bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.jXY.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.k(this, 2131231426), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          ad.ari((String)localObject2);
          break label521;
          label813:
          this.qFD.setImageBitmap(this.frG);
        }
      }
      this.jXY.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.k(this, 2131231425), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127027);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.qGy = new SelfQRCodeUI.b(this, this);
    this.qGy.start();
    com.tencent.mm.kernel.g.Rc().a(168, this);
    com.tencent.mm.kernel.g.Rc().a(890, this);
    initView();
    this.qFD.post(new SelfQRCodeUI.1(this));
    AppMethodBeat.o(127027);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127028);
    com.tencent.mm.kernel.g.Rc().b(168, this);
    com.tencent.mm.kernel.g.Rc().b(890, this);
    if (this.qGy != null) {
      this.qGy.stop();
    }
    if ((this.frG != null) && (!this.frG.isRecycled()))
    {
      ab.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.frG.toString() });
      this.frG.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(127028);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127029);
    super.onResume();
    if ((t.nI(this.userName)) || (com.tencent.mm.aj.f.rX(this.userName)))
    {
      AppMethodBeat.o(127029);
      return;
    }
    View localView = findViewById(2131821066);
    this.kRf = r.Zs();
    ab.d("MicroMsg.SelfQRCodeNewUI", (this.kRf & 0x2) + ",extstatus:" + this.kRf);
    if ((this.kRf & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.qFD.setAlpha(0.1F);
      findViewById(2131821067).setOnClickListener(new SelfQRCodeUI.8(this));
      AppMethodBeat.o(127029);
      return;
    }
    localView.setVisibility(8);
    this.qFD.setAlpha(1.0F);
    AppMethodBeat.o(127029);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(127032);
    ab.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramm instanceof com.tencent.mm.bb.a))
    {
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.2(this, (com.tencent.mm.bb.a)paramm));
      AppMethodBeat.o(127032);
      return;
    }
    if ((paramm instanceof com.tencent.mm.openim.b.g))
    {
      paramm = (ana)((com.tencent.mm.ai.b)((com.tencent.mm.openim.b.g)paramm).getReqResp()).fsW.fta;
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.3(this, paramm.xdB.pW, paramm.wma));
    }
    AppMethodBeat.o(127032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */