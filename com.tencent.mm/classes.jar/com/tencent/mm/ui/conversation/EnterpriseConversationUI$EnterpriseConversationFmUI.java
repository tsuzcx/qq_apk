package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c.a;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import java.util.HashMap;

public class EnterpriseConversationUI$EnterpriseConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
  implements com.tencent.mm.ai.f, n.b
{
  private ListView Ahc;
  private String Ahe;
  private com.tencent.mm.ui.tools.m AkH;
  private View AkI;
  private i AkJ;
  private String AkK;
  private ak AkL;
  private int AkM;
  private String AkN;
  private l contextMenuHelper;
  private long eaj;
  private TextView emptyTipTv;
  long fSl;
  private int fromScene;
  private String fuO;
  private boolean isDeleteCancel;
  private String jUp;
  private n.d jWw;
  private long jzc;
  private com.tencent.mm.ui.base.p tipDialog;
  private LinearLayout zto;
  private int ztr;
  private c.a ztu;
  
  public EnterpriseConversationUI$EnterpriseConversationFmUI()
  {
    AppMethodBeat.i(34439);
    this.zto = null;
    this.AkI = null;
    this.AkK = null;
    this.jUp = "";
    this.ztr = 0;
    this.isDeleteCancel = false;
    this.eaj = 0L;
    this.fSl = 0L;
    this.AkM = -2;
    this.jzc = 0L;
    this.AkN = null;
    this.ztu = new EnterpriseConversationUI.EnterpriseConversationFmUI.10(this);
    AppMethodBeat.o(34439);
  }
  
  private void dEU()
  {
    AppMethodBeat.i(34445);
    this.ztr = com.tencent.mm.ui.g.bJ(getContext(), this.fuO);
    Object localObject;
    if ((this.ztr == 2) && (this.zto == null))
    {
      this.zto = ((LinearLayout)findViewById(2131823738));
      localObject = this.zto.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.ao(getContext(), 2131427563);
      this.zto.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.AkI = w.hM(getContext()).inflate(2130969437, this.zto, false);
      float f = com.tencent.mm.cb.a.dr(getContext());
      localObject = (ImageView)this.AkI.findViewById(2131821253);
      int i = ((ImageView)localObject).getLayoutParams().height;
      ((ImageView)localObject).getLayoutParams().height = ((int)(i * f));
      ((ImageView)localObject).getLayoutParams().width = ((int)(f * i));
      ((ImageView)localObject).requestLayout();
      localObject = (TextView)this.AkI.findViewById(2131821212);
      com.tencent.mm.aj.b localb = z.afr().rx(this.fuO);
      z.afr();
      z.afr();
      String str = com.tencent.mm.aj.c.kX(0);
      if ((localb == null) || (localb.field_use_preset_banner_tips) || (str == null)) {
        break label316;
      }
      ((TextView)localObject).setText(str);
    }
    for (;;)
    {
      com.tencent.mm.ui.g.aE(this.fuO, 1, 2);
      this.zto.addView(this.AkI);
      this.AkI.setOnClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.13(this));
      com.tencent.mm.ui.g.s(getContext(), this.fuO, 3);
      com.tencent.mm.ui.g.bK(getContext(), this.fuO);
      if (this.zto == null) {
        break label335;
      }
      if (this.ztr != 2) {
        break;
      }
      this.zto.setVisibility(0);
      dMO();
      AppMethodBeat.o(34445);
      return;
      label316:
      ((TextView)localObject).setText(2131299325);
    }
    this.zto.setVisibility(8);
    label335:
    AppMethodBeat.o(34445);
  }
  
  private void dMO()
  {
    AppMethodBeat.i(34446);
    com.tencent.mm.aj.b localb = z.afr().rx(this.fuO);
    int i;
    int j;
    label40:
    long l1;
    if (localb != null)
    {
      i = localb.field_qyUin;
      if (localb == null) {
        break label190;
      }
      j = localb.field_userUin;
      if (localb == null) {
        break label195;
      }
      l1 = localb.field_wwCorpId;
      label51:
      if (localb == null) {
        break label200;
      }
    }
    label190:
    label195:
    label200:
    for (long l2 = localb.field_wwUserVid;; l2 = 0L)
    {
      h.qsU.e(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
      ab.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(34446);
      return;
      i = 0;
      break;
      j = 0;
      break label40;
      l1 = 0L;
      break label51;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject) {}
  
  public int getLayoutId()
  {
    return 2130969436;
  }
  
  public String getUserName()
  {
    return this.fuO;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(34440);
    super.onActivityCreated(paramBundle);
    this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    this.Ahe = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
    setMMTitle(this.Ahe);
    this.Ahc = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131299312);
    setBackBtn(new EnterpriseConversationUI.EnterpriseConversationFmUI.1(this));
    setToTop(new EnterpriseConversationUI.EnterpriseConversationFmUI.11(this));
    if (com.tencent.mm.aj.f.rS(this.fuO) != null)
    {
      dEU();
      if (this.fuO != null)
      {
        paramBundle = new EnterpriseConversationUI.EnterpriseConversationFmUI.12(this);
        z.afr();
        com.tencent.mm.aj.c.a(this.fuO, paramBundle);
        ab.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.fuO });
        addIconOptionMenu(1, 2131304318, 2131230741, new EnterpriseConversationUI.EnterpriseConversationFmUI.14(this));
        addIconOptionMenu(2, 2131296407, 2131230736, new EnterpriseConversationUI.EnterpriseConversationFmUI.15(this));
        this.AkJ = new i(thisActivity(), this.fuO, new EnterpriseConversationUI.EnterpriseConversationFmUI.16(this));
        this.AkJ.setGetViewPositionCallback(new EnterpriseConversationUI.EnterpriseConversationFmUI.17(this));
        this.AkJ.setPerformItemClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.18(this));
        this.AkJ.a(new EnterpriseConversationUI.EnterpriseConversationFmUI.2(this));
        this.Ahc.setAdapter(this.AkJ);
        this.Ahc.setOnItemClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.3(this));
        this.contextMenuHelper = new l(thisActivity());
        this.jWw = new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this);
        this.Ahc.setOnItemLongClickListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.5(this));
      }
    }
    else
    {
      this.eaj = (System.currentTimeMillis() / 1000L);
      aw.aaz();
      paramBundle = com.tencent.mm.model.c.YF().arH(this.fuO);
      if (paramBundle != null)
      {
        this.AkM = paramBundle.field_unReadCount;
        if ((this.AkM == 0) && (paramBundle.field_unReadMuteCount > 0)) {
          this.AkM = -1;
        }
        this.jzc = (paramBundle.field_conversationTime / 1000L);
        if (paramBundle.field_isSend != 1) {
          break label558;
        }
        paramBundle = null;
        label454:
        this.AkN = paramBundle;
      }
      z.afr().a(this.ztu, thisActivity().getMainLooper());
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this);
      aw.aaz();
      com.tencent.mm.model.c.YA().a(this);
      if (this.AkJ != null)
      {
        if (this.AkL != null) {
          break label566;
        }
        this.AkL = new EnterpriseConversationUI.EnterpriseConversationFmUI.9(this);
      }
    }
    for (;;)
    {
      this.AkL.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(34440);
      return;
      ab.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
      break;
      label558:
      paramBundle = paramBundle.field_digestUser;
      break label454;
      label566:
      this.AkL.removeMessages(1);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34444);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(34444);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.bPJ().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.bPJ().fh(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.l(thisActivity(), getContext().getString(2131299979));
      AppMethodBeat.o(34444);
      return;
    }
    AppMethodBeat.o(34444);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(34448);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(this.jUp);
    if (localad == null)
    {
      ab.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.jUp);
      AppMethodBeat.o(34448);
      return;
    }
    String str = localad.Of();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bo.isNullOrNil(localad.field_nickname)) {
        paramView = getString(2131298302);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(j.b(thisActivity(), paramView));
    if (localad.Oa()) {
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131301406);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131299316);
      paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131301410);
      AppMethodBeat.o(34448);
      return;
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131299323);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34441);
    z.afr().a(this.ztu);
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this);
      aw.aaz();
      com.tencent.mm.model.c.YA().b(this);
    }
    if (this.AkJ != null)
    {
      localObject = this.AkJ;
      ((i)localObject).AhQ.stopTimer();
      if (((i)localObject).zte != null)
      {
        ((i)localObject).zte.clear();
        ((i)localObject).zte = null;
      }
      ((i)localObject).bKb();
      ((i)localObject).dAW();
      aw.aaz();
      com.tencent.mm.model.c.YF().b((n.b)localObject);
    }
    aw.Rc().b(1394, this);
    if ((this.eaj <= 0L) || (this.fSl <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(34441);
      return;
    }
    long l = this.fSl - this.eaj;
    Object localObject = z.afr().rx(this.fuO);
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.aj.b)localObject).field_qyUin;
      label187:
      if (localObject == null) {
        break label307;
      }
    }
    label307:
    for (int j = ((com.tencent.mm.aj.b)localObject).field_userUin;; j = 0)
    {
      h.qsU.e(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
      ab.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
      break;
      i = 0;
      break label187;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34443);
    ab.v("MicroMsg.EnterpriseConversationUI", "on pause");
    aw.aaz();
    com.tencent.mm.model.c.YF().arJ(this.fuO);
    if (this.AkJ != null) {
      this.AkJ.onPause();
    }
    super.onPause();
    AppMethodBeat.o(34443);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34442);
    ab.v("MicroMsg.EnterpriseConversationUI", "on resume");
    if (this.AkJ != null) {
      this.AkJ.onResume();
    }
    super.onResume();
    if (!t.nT(this.fuO)) {
      finish();
    }
    AppMethodBeat.o(34442);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(34447);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(34447);
      return;
    }
    if (paramm.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramm).cbP();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramm).cbO();
      if ((localObject == null) || (((cit)localObject).wyn == null) || (((cit)localObject).wyn.ret != 0))
      {
        if ((localObject != null) && (((cit)localObject).wyn != null))
        {
          ab.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((cit)localObject).wyn.ret) });
          AppMethodBeat.o(34447);
          return;
        }
        ab.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
        AppMethodBeat.o(34447);
        return;
      }
      if (!paramString.xTc)
      {
        AppMethodBeat.o(34447);
        return;
      }
      paramm = com.tencent.mm.aj.f.rS(paramString.wyh);
      paramm.field_brandFlag |= 0x1;
      localObject = new bdm();
      ((bdm)localObject).gxd = paramm.field_brandFlag;
      ((bdm)localObject).jJA = paramString.wyh;
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new j.a(47, (com.tencent.mm.bv.a)localObject));
      z.afi().update(paramm, new String[0]);
      aw.aaz();
      com.tencent.mm.model.c.YF().arF(paramm.field_username);
      aw.aaz();
      if (com.tencent.mm.model.c.YF().arS(paramm.field_enterpriseFather) <= 0)
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arF(paramm.field_enterpriseFather);
        AppMethodBeat.o(34447);
        return;
      }
      aw.aaz();
      com.tencent.mm.model.c.YE().aqR(paramm.field_enterpriseFather);
    }
    AppMethodBeat.o(34447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI
 * JD-Core Version:    0.7.0.1
 */