package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.c;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.plugin.radar.b.e.d;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "setRadarStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;)V", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final RadarViewController.b pSZ;
  private boolean ogA;
  private final f pSI;
  private final f pSJ;
  private final f pSK;
  private final f pSL;
  private final f pSM;
  private final f pSN;
  private final f pSO;
  private final f pSP;
  e pSQ;
  c pSR;
  RadarViewController.c pSS;
  private e.e pST;
  private final boolean pSU;
  final View.OnClickListener pSV;
  private final int pSW;
  private final int pSX;
  private final int pSY;
  
  static
  {
    AppMethodBeat.i(103102);
    eOJ = new k[] { (k)v.a(new t(v.aG(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), (k)v.a(new t(v.aG(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), (k)v.a(new t(v.aG(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), (k)v.a(new t(v.aG(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), (k)v.a(new t(v.aG(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), (k)v.a(new t(v.aG(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), (k)v.a(new t(v.aG(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), (k)v.a(new t(v.aG(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;")) };
    pSZ = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(103102);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103126);
    this.pSI = a.g.j((a)new RadarViewController.i(this));
    this.pSJ = i.ae(this, 2131826976);
    this.pSK = i.ae(this, 2131827006);
    this.pSL = i.ae(this, 2131827008);
    this.pSM = i.ae(this, 2131827004);
    this.pSN = i.ae(this, 2131827003);
    this.pSO = i.ae(this, 2131827007);
    this.pSP = i.ae(this, 2131826998);
    this.pST = e.e.pQK;
    this.pSV = ((View.OnClickListener)new RadarViewController.f(this));
    this.pSW = 33554432;
    this.pSX = (this.pSW + 1);
    this.pSY = (this.pSW + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    j.p(localContext, "mContext.getApplicationContext()");
    this.pSQ = new e(paramAttributeSet, localContext);
    this.pSR = new c((c.c)this, paramContext);
    AppMethodBeat.o(103126);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(103124);
    this.pST = parame;
    switch (h.pTs[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103124);
      return;
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(2131302269);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().cfg();
      getWaveView().setVisibility(0);
      parame = this.pSQ;
      if (parame == null) {
        j.ays("radarManager");
      }
      parame.ceM();
      AppMethodBeat.o(103124);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(103124);
      return;
      cfd();
      getQuitBtn().setText(2131296888);
      parame = this.pSQ;
      if (parame == null) {
        j.ays("radarManager");
      }
      parame.ceN();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131302271);
      getWaveView().cfh();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.pSS;
      if (parame == null) {
        j.ays("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(103124);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.pSQ;
      if (parame == null) {
        j.ays("radarManager");
      }
      parame.ceN();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131302260);
      getGrid().setVisibility(0);
      AppMethodBeat.o(103124);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.pSQ;
      if (parame == null) {
        j.ays("radarManager");
      }
      parame.ceN();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131302261);
    }
  }
  
  private final void an(LinkedList<brg> paramLinkedList)
  {
    AppMethodBeat.i(103122);
    if (paramLinkedList == null) {
      j.ebi();
    }
    RadarViewController.c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.pSS;
      if (localc == null) {
        j.ays("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      ab.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = ao(paramLinkedList);
      ab.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.pSS;
      if (localc == null) {
        j.ays("adapter");
      }
      localc.ap(paramLinkedList);
      if ((this.pSU) && (bool)) {
        a(e.e.pQL);
      }
      AppMethodBeat.o(103122);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean ao(LinkedList<brg> paramLinkedList)
  {
    AppMethodBeat.i(103123);
    boolean bool = false;
    if (paramLinkedList == null) {
      j.ebi();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (brg)localIterator.next();
      paramLinkedList = this.pSQ;
      if (paramLinkedList == null) {
        j.ays("radarManager");
      }
      j.p(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (brg)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.pSH;
      localObject = g.b((brg)localObject);
      paramLinkedList = this.pSR.XH((String)localObject);
      e locale = this.pSQ;
      if (locale == null) {
        j.ays("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.pPW) {
        bool = true;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(103123);
        return bool;
      }
    }
  }
  
  private final void cfd()
  {
    AppMethodBeat.i(103125);
    if (getRadarBgMask().getVisibility() != 0)
    {
      getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), 2131034232));
      getRadarBgMask().setVisibility(0);
    }
    AppMethodBeat.o(103125);
  }
  
  private final void d(String paramString, c.e parame)
  {
    AppMethodBeat.i(103114);
    Object localObject = this.pSQ;
    if (localObject == null) {
      j.ays("radarManager");
    }
    if (paramString == null) {
      j.ebi();
    }
    localObject = ((e)localObject).XI(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.pSQ;
      if (localObject == null) {
        j.ays("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.pSS;
      if (paramString == null) {
        j.ays("adapter");
      }
      paramString.aPD();
    }
    AppMethodBeat.o(103114);
  }
  
  private final TextView getNewRadarTip()
  {
    AppMethodBeat.i(103107);
    TextView localTextView = (TextView)this.pSM.getValue();
    AppMethodBeat.o(103107);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(103108);
    ProgressBar localProgressBar = (ProgressBar)this.pSN.getValue();
    AppMethodBeat.o(103108);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(103110);
    View localView = (View)this.pSP.getValue();
    AppMethodBeat.o(103110);
    return localView;
  }
  
  private final void setRadarStatus(e.e parame)
  {
    this.pST = parame;
  }
  
  public final void P(ad paramad)
  {
    AppMethodBeat.i(103118);
    j.q(paramad, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramad.Hv();
      j.p(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.pPW);
    }
    d(paramad.getUsername(), c.e.pPW);
    d(paramad.Hv(), c.e.pPW);
    AppMethodBeat.o(103118);
  }
  
  public final void Q(ad paramad)
  {
    AppMethodBeat.i(103117);
    j.q(paramad, "contact");
    Object localObject = this.pSQ;
    if (localObject == null) {
      j.ays("radarManager");
    }
    String str1 = paramad.getUsername();
    j.p(str1, "contact.username");
    if (((e)localObject).XI(str1) == null)
    {
      localObject = this.pSQ;
      if (localObject == null) {
        j.ays("radarManager");
      }
      str1 = paramad.Hv();
      j.p(str1, "contact.encryptUsername");
      if (((e)localObject).XI(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramad.getUsername();
        j.p(str1, "contact.username");
        String str2 = paramad.Hv();
        j.p(str2, "contact.encryptUsername");
        String str3 = paramad.Hs();
        j.p(str3, "contact.nickname");
        brg localbrg = new brg();
        localbrg.xER = 100;
        localbrg.jJA = str1;
        localbrg.jKG = str3;
        localbrg.SmallImgUrl = "";
        localbrg.wSo = str2;
        ((LinkedList)localObject).add(localbrg);
        an((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramad.Hv();
      j.p(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.pPX);
    }
    d(paramad.getUsername(), c.e.pPX);
    d(paramad.Hv(), c.e.pPX);
    AppMethodBeat.o(103117);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<brg> paramLinkedList)
  {
    AppMethodBeat.i(103120);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131301788);
        j.p(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.XJ(str);
        AppMethodBeat.o(103120);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131302275);
      j.p(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.XJ(str);
      AppMethodBeat.o(103120);
      return;
    }
    an(paramLinkedList);
    AppMethodBeat.o(103120);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(103116);
    if (paramBoolean) {
      d(paramString2, c.e.pPW);
    }
    for (;;)
    {
      paramString1 = this.pSQ;
      if (paramString1 == null) {
        j.ays("radarManager");
      }
      paramString1.pQw.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(103116);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.XJ(paramString2);
      paramString1 = this.pSQ;
      if (paramString1 == null) {
        j.ays("radarManager");
      }
      paramString1 = (e.c)paramString1.pQw.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.pSH;
        d(g.b(paramString1.pQI), paramString1.pQJ);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(103115);
    if (paramBoolean1) {
      d(paramString2, c.e.pPW);
    }
    for (;;)
    {
      paramString1 = this.pSQ;
      if (paramString1 == null) {
        j.ays("radarManager");
      }
      paramString1.pQw.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(103115);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.pPV);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.XJ(paramString2);
        paramString1 = this.pSQ;
        if (paramString1 == null) {
          j.ays("radarManager");
        }
        paramString1 = (e.c)paramString1.pQw.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.pSH;
          d(g.b(paramString1.pQI), paramString1.pQJ);
          paramString2 = g.pSH;
          d(g.c(paramString1.pQI), paramString1.pQJ);
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<brd> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(103121);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.pQN);
      RadarViewController.c localc = this.pSS;
      if (localc == null) {
        j.ays("adapter");
      }
      c(localc.pTd).pQx.clear();
      c(localc.pTd).pQt.clear();
      localc.pTg.clear();
      localc.pTh.clear();
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramLinkedList != null)
      {
        localObject1 = localObject2;
        if (paramLinkedList.size() > 0)
        {
          localObject1 = new LinkedList();
          paramInt2 = paramLinkedList.size();
          paramInt1 = 0;
          Object localObject3;
          while (paramInt1 < paramInt2)
          {
            localObject2 = paramLinkedList.get(paramInt1);
            j.p(localObject2, "radarChatMember[i]");
            localObject2 = (brd)localObject2;
            localObject3 = new bre();
            ((bre)localObject3).xEQ = ((brd)localObject2).jJA;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.pTd).pQt;
            Object localObject4 = ((brd)localObject2).wSo;
            j.p(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((brd)localObject2).jJA;
            j.p(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.pTh;
            localObject4 = g.pSH;
            ((HashMap)localObject3).put(g.a((brd)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.pTf.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.pTf[paramInt1];
            localObject2 = c(localc.pTd).pQt;
            localObject3 = g.pSH;
            if (!bo.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.pTd).d(paramLinkedList);
              c(localc.pTd).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.pTd).pQs = ((LinkedList)localObject1);
      paramLinkedList = this.pSS;
      if (paramLinkedList == null) {
        j.ays("adapter");
      }
      paramLinkedList.aPD();
      AppMethodBeat.o(103121);
      return;
    }
    a(e.e.pQK);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131302275);
    j.p(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.XJ((String)localObject1);
    AppMethodBeat.o(103121);
  }
  
  public final void ceM()
  {
    AppMethodBeat.i(103112);
    e locale = this.pSQ;
    if (locale == null) {
      j.ays("radarManager");
    }
    locale.ceM();
    AppMethodBeat.o(103112);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(103105);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.pSK.getValue();
    AppMethodBeat.o(103105);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(103104);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.pSJ.getValue();
    AppMethodBeat.o(103104);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(103109);
    Button localButton = (Button)this.pSO.getValue();
    AppMethodBeat.o(103109);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.pST;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(103106);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.pSL.getValue();
    AppMethodBeat.o(103106);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(103103);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.pSI.getValue();
    AppMethodBeat.o(103103);
    return localRadarWaveView;
  }
  
  public final void ko(boolean paramBoolean)
  {
    AppMethodBeat.i(103119);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131302274);
      j.p(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.XJ(str);
      if ((!this.ogA) && (!d.agR()))
      {
        this.ogA = true;
        h.a(getContext(), getContext().getString(2131300538), getContext().getString(2131297087), getContext().getString(2131300996), getContext().getString(2131296888), false, (DialogInterface.OnClickListener)new RadarViewController.g(this), null);
      }
    }
    AppMethodBeat.o(103119);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(103113);
    j.q(paramKeyEvent, "event");
    if ((paramInt == 4) && (getMemberDetailView().isShowing() == true))
    {
      getMemberDetailView().dismiss();
      AppMethodBeat.o(103113);
      return true;
    }
    AppMethodBeat.o(103113);
    return false;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103111);
    e locale = this.pSQ;
    if (locale == null) {
      j.ays("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(103111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */