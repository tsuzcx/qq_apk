package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.b.b.c;
import com.tencent.mm.plugin.radar.b.b.e;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.d.a;
import com.tencent.mm.plugin.radar.b.d.c;
import com.tencent.mm.plugin.radar.b.d.d;
import com.tencent.mm.plugin.radar.b.d.e;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements b.c, d.d
{
  public static final RadarViewController.b HwL;
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  private final f HwA;
  private final f HwB;
  com.tencent.mm.plugin.radar.b.d HwC;
  com.tencent.mm.plugin.radar.b.b HwD;
  c HwE;
  private d.e HwF;
  private final boolean HwG;
  final View.OnClickListener HwH;
  private final int HwI;
  private final int HwJ;
  private final int HwK;
  private final f Hwu;
  private final f Hwv;
  private final f Hww;
  private final f Hwx;
  private final f Hwy;
  private final f Hwz;
  private boolean zHI;
  
  static
  {
    AppMethodBeat.i(138753);
    HwL = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.Hwu = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.Hwv = i.au(this, a.d.HsM);
    this.Hww = i.au(this, a.d.Htb);
    this.Hwx = i.au(this, a.d.Htd);
    this.Hwy = i.au(this, a.d.HsR);
    this.Hwz = i.au(this, a.d.HsS);
    this.HwA = i.au(this, a.d.HsV);
    this.HwB = i.au(this, a.d.HsI);
    this.HwF = d.e.Huz;
    this.HwH = ((View.OnClickListener)new f(this));
    this.HwI = 33554432;
    this.HwJ = (this.HwI + 1);
    this.HwK = (this.HwI + 2);
    paramAttributeSet = (d.d)this;
    Context localContext = paramContext.getApplicationContext();
    p.j(localContext, "mContext.getApplicationContext()");
    this.HwC = new com.tencent.mm.plugin.radar.b.d(paramAttributeSet, localContext);
    this.HwD = new com.tencent.mm.plugin.radar.b.b((b.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(d.e parame)
  {
    AppMethodBeat.i(138775);
    this.HwF = parame;
    switch (h.tKM[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(a.g.Htq);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().ftI();
      getWaveView().setVisibility(0);
      parame = this.HwC;
      if (parame == null) {
        p.bGy("radarManager");
      }
      parame.ftn();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      ftE();
      getQuitBtn().setText(a.g.app_cancel);
      parame = this.HwC;
      if (parame == null) {
        p.bGy("radarManager");
      }
      parame.fto();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(a.g.Htr);
      getWaveView().ftJ();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.HwE;
      if (parame == null) {
        p.bGy("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.HwC;
      if (parame == null) {
        p.bGy("radarManager");
      }
      parame.fto();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(a.g.Htn);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.HwC;
      if (parame == null) {
        p.bGy("radarManager");
      }
      parame.fto();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(a.g.Hto);
    }
  }
  
  private final void bC(LinkedList<dsq> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      p.iCn();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.HwE;
      if (localc == null) {
        p.bGy("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      Log.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = bD(paramLinkedList);
      Log.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.HwE;
      if (localc == null) {
        p.bGy("adapter");
      }
      localc.bE(paramLinkedList);
      if ((this.HwG) && (bool)) {
        a(d.e.HuA);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean bD(LinkedList<dsq> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      p.iCn();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (dsq)localIterator.next();
      paramLinkedList = this.HwC;
      if (paramLinkedList == null) {
        p.bGy("radarManager");
      }
      p.j(localObject, "member");
      paramLinkedList = com.tencent.mm.plugin.radar.b.d.a(paramLinkedList, (dsq)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.Hwt;
      localObject = g.a((dsq)localObject);
      paramLinkedList = this.HwD.aVo((String)localObject);
      com.tencent.mm.plugin.radar.b.d locald = this.HwC;
      if (locald == null) {
        p.bGy("radarManager");
      }
      locald.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == b.e.HtO) {
        bool = true;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(138774);
        return bool;
      }
    }
  }
  
  private final void d(String paramString, b.e parame)
  {
    AppMethodBeat.i(138765);
    Object localObject = this.HwC;
    if (localObject == null) {
      p.bGy("radarManager");
    }
    if (paramString == null) {
      p.iCn();
    }
    localObject = ((com.tencent.mm.plugin.radar.b.d)localObject).aVp(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.HwC;
      if (localObject == null) {
        p.bGy("radarManager");
      }
      ((com.tencent.mm.plugin.radar.b.d)localObject).b(paramString, parame);
      paramString = this.HwE;
      if (paramString == null) {
        p.bGy("adapter");
      }
      paramString.cnv();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void ftE()
  {
    AppMethodBeat.i(138776);
    if (getRadarBgMask().getVisibility() != 0)
    {
      getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), a.a.Hsu));
      getRadarBgMask().setVisibility(0);
    }
    AppMethodBeat.o(138776);
  }
  
  private final TextView getNewRadarTip()
  {
    AppMethodBeat.i(138758);
    TextView localTextView = (TextView)this.Hwy.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.Hwz.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.HwB.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<dsq> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(a.g.net_warn_no_network);
        p.j(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.aVq(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(a.g.Htu);
      p.j(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.aVq(str);
      AppMethodBeat.o(138771);
      return;
    }
    bC(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, b.e.HtO);
    }
    for (;;)
    {
      paramString1 = this.HwC;
      if (paramString1 == null) {
        p.bGy("radarManager");
      }
      paramString1.Hul.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.aVq(paramString2);
      paramString1 = this.HwC;
      if (paramString1 == null) {
        p.bGy("radarManager");
      }
      paramString1 = (d.c)paramString1.Hul.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.Hwt;
        d(g.a(paramString1.Hux), paramString1.Huy);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, b.e.HtO);
    }
    for (;;)
    {
      paramString1 = this.HwC;
      if (paramString1 == null) {
        p.bGy("radarManager");
      }
      paramString1.Hul.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, b.e.HtN);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.aVq(paramString2);
        paramString1 = this.HwC;
        if (paramString1 == null) {
          p.bGy("radarManager");
        }
        paramString1 = (d.c)paramString1.Hul.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.Hwt;
          d(g.a(paramString1.Hux), paramString1.Huy);
          paramString2 = g.Hwt;
          d(g.b(paramString1.Hux), paramString1.Huy);
        }
      }
    }
  }
  
  public final void am(as paramas)
  {
    AppMethodBeat.i(138769);
    p.k(paramas, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramas.apn();
      p.j(str, "contact.encryptUsername");
      localRadarMemberView.c(str, b.e.HtO);
    }
    d(paramas.getUsername(), b.e.HtO);
    d(paramas.apn(), b.e.HtO);
    AppMethodBeat.o(138769);
  }
  
  public final void an(as paramas)
  {
    AppMethodBeat.i(138768);
    p.k(paramas, "contact");
    Object localObject = this.HwC;
    if (localObject == null) {
      p.bGy("radarManager");
    }
    String str1 = paramas.getUsername();
    p.j(str1, "contact.username");
    if (((com.tencent.mm.plugin.radar.b.d)localObject).aVp(str1) == null)
    {
      localObject = this.HwC;
      if (localObject == null) {
        p.bGy("radarManager");
      }
      str1 = paramas.apn();
      p.j(str1, "contact.encryptUsername");
      if (((com.tencent.mm.plugin.radar.b.d)localObject).aVp(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramas.getUsername();
        p.j(str1, "contact.username");
        String str2 = paramas.apn();
        p.j(str2, "contact.encryptUsername");
        String str3 = paramas.getNickname();
        p.j(str3, "contact.nickname");
        dsq localdsq = new dsq();
        localdsq.TYY = 100;
        localdsq.UserName = str1;
        localdsq.rWI = str3;
        localdsq.Sus = "";
        localdsq.Sxx = str2;
        ((LinkedList)localObject).add(localdsq);
        bC((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramas.apn();
      p.j(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, b.e.HtP);
    }
    d(paramas.getUsername(), b.e.HtP);
    d(paramas.apn(), b.e.HtP);
    AppMethodBeat.o(138768);
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<Object> paramLinkedList)
  {
    AppMethodBeat.i(138772);
    a(d.e.Huz);
    paramLinkedList = getRadarTips();
    String str = getContext().getString(a.g.Htu);
    p.j(str, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.aVq(str);
    AppMethodBeat.o(138772);
  }
  
  public final void ftn()
  {
    AppMethodBeat.i(138763);
    com.tencent.mm.plugin.radar.b.d locald = this.HwC;
    if (locald == null) {
      p.bGy("radarManager");
    }
    locald.ftn();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.Hww.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.Hwv.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.HwA.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final d.e getRadarStatus()
  {
    return this.HwF;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.Hwx.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.Hwu.getValue();
    AppMethodBeat.o(138754);
    return localRadarWaveView;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138764);
    p.k(paramKeyEvent, "event");
    if ((paramInt == 4) && (getMemberDetailView().isShowing() == true))
    {
      getMemberDetailView().dismiss();
      AppMethodBeat.o(138764);
      return true;
    }
    AppMethodBeat.o(138764);
    return false;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138762);
    com.tencent.mm.plugin.radar.b.d locald = this.HwC;
    if (locald == null) {
      p.bGy("radarManager");
    }
    locald.onResume();
    AppMethodBeat.o(138762);
  }
  
  public final void wp(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(a.g.Htt);
      p.j(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.aVq(str);
      if ((!this.zHI) && (!com.tencent.mm.modelgeo.d.blr()))
      {
        this.zHI = true;
        com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(a.g.gps_disable_tip), getContext().getString(a.g.app_tip), getContext().getString(a.g.jump_to_settings), getContext().getString(a.g.app_cancel), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int HwM;
    final boolean HwN;
    private final a HwO;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.Hwt;
      this$1 = this$1.getContext();
      p.j(this$1, "context");
      this.HwN = g.hM(this$1);
      this.HwO = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int fM(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.HwP));
      paramView = localObject;
      if (!(localObject instanceof Integer)) {
        paramView = null;
      }
      paramView = (Integer)paramView;
      if (paramView != null)
      {
        int i = paramView.intValue();
        AppMethodBeat.o(138735);
        return i;
      }
      AppMethodBeat.o(138735);
      return -1;
    }
    
    public final void cD(View paramView)
    {
      AppMethodBeat.i(138734);
      p.k(paramView, "view");
      int i = fM(paramView);
      if (i > 0) {
        this.HwO.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final Animation ftG()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.HwP.getContext(), a.a.HsB);
      p.j(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final int ftH()
    {
      this.HwM += 1;
      return this.HwM;
    }
    
    public final void m(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      p.k(paramView, "view");
      Message localMessage = this.HwO.obtainMessage();
      localMessage.what = fM(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.HwO.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends MMHandler
    {
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(138731);
        p.k(paramMessage, "msg");
        if ((paramMessage.obj instanceof View))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(138731);
            throw paramMessage;
          }
          View localView = (View)paramMessage;
          localView.setVisibility(0);
          localView.clearAnimation();
          if (!this.HwQ.HwN)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.HwQ.HwP));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.HwQ.ftG();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    dsq[] HwR;
    HashMap<String, String> HwS;
    HashMap<String, Integer> HwT;
    private final RadarViewController.a HwU;
    private int HwV;
    HashMap<String, View> HwW;
    private boolean HwX;
    private final Context context;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.HwR = new dsq[12];
      this.HwS = new HashMap();
      this.HwT = new HashMap();
      this.HwW = new HashMap();
      this.HwU = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View at(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, a.e.Htj, null);
        if (localView == null) {
          p.iCn();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.HwU.ftH()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.HwU.ftG());
      }
      paramView = localView.findViewById(a.d.HsW);
      p.j(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(a.d.HsX);
      p.j(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(a.d.HsY);
      p.j(paramView, "anotherConvertView.findV…_result_item_username_tv)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(a.d.HsQ);
      p.j(paramView, "anotherConvertView.findV….radar_member_state_view)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(a.d.HsP);
      p.j(paramView, "anotherConvertView.findV…member_state_choose_view)");
      paramView.setVisibility(4);
      if ((paramInt == 7) || (paramInt % 3 == 1))
      {
        paramView = localView.findViewById(a.d.HsE);
        p.j(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(a.d.Hti);
        p.j(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(138741);
        return localView;
        paramView = localView.findViewById(a.d.Hti);
        p.j(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(a.d.HsE);
        p.j(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(8);
      }
    }
    
    public final View as(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      Log.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      dsq localdsq = (dsq)this.HwR[paramInt];
      Object localObject1;
      int i;
      label97:
      label103:
      String str;
      Object localObject2;
      if (localdsq != null)
      {
        localObject1 = (CharSequence)localdsq.UserName;
        if ((localObject1 == null) || (n.ba((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label237;
          }
          localObject1 = (CharSequence)localdsq.Sxx;
          if ((localObject1 != null) && (!n.ba((CharSequence)localObject1))) {
            break label232;
          }
          i = 1;
          if (i == 0) {
            break label237;
          }
          i = 1;
          if (i != 0) {
            break label1631;
          }
          localObject1 = g.Hwt;
          str = g.a(localdsq);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1641;
          }
          localObject1 = View.inflate(this.context, a.e.Htj, null);
          if (localObject1 == null) {
            p.iCn();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.HwU.ftH()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.HwU.ftG());
        }
      }
      for (;;)
      {
        Object localObject3 = ((View)localObject1).findViewById(a.d.HsW);
        if (localObject3 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
          i = 0;
          break;
          label232:
          i = 0;
          break label97;
          label237:
          i = 0;
          break label103;
        }
        localObject3 = (ImageView)localObject3;
        Object localObject4 = ((View)localObject1).findViewById(a.d.HsQ);
        if (localObject4 == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject4 = (RadarStateView)localObject4;
        Object localObject5 = ((View)localObject1).findViewById(a.d.HsY);
        if (localObject5 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject5 = (TextView)localObject5;
        Object localObject6 = ((View)localObject1).findViewById(a.d.HsX);
        if (localObject6 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject6 = (ImageView)localObject6;
        Object localObject7 = ((View)localObject1).findViewById(a.d.HsP);
        if (localObject7 == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject7 = (RadarStateChooseView)localObject7;
        ((ImageView)localObject3).setVisibility(0);
        ((RadarStateView)localObject4).setVisibility(0);
        ((TextView)localObject5).setVisibility(0);
        ((ImageView)localObject6).setVisibility(0);
        if ((localObject2 == d.e.Huz) || (localObject2 == d.e.HuA))
        {
          ((RadarStateView)localObject4).setVisibility(0);
          ((RadarStateChooseView)localObject7).setVisibility(8);
          ((View)localObject1).setTag(new a((TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
          if ((paramInt != 7) && (paramInt % 3 != 1)) {
            break label613;
          }
          localObject2 = ((View)localObject1).findViewById(a.d.HsE);
          p.j(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(a.d.Hti);
          p.j(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(8);
        }
        for (;;)
        {
          if ((paramView == null) || (localObject1 != paramView)) {
            this.HwW.put(str, localObject1);
          }
          localObject2 = ((View)localObject1).getTag();
          if (localObject2 != null) {
            break label663;
          }
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138739);
          throw paramView;
          ((RadarStateView)localObject4).setVisibility(8);
          ((RadarStateChooseView)localObject7).setVisibility(0);
          break;
          label613:
          localObject2 = ((View)localObject1).findViewById(a.d.Hti);
          p.j(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(a.d.HsE);
          p.j(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(8);
        }
        label663:
        localObject4 = (a)localObject2;
        ((a)localObject4).HwY.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(RadarViewController.this.getContext(), (CharSequence)localdsq.rWI, ((a)localObject4).HwY.getTextSize()));
        localObject2 = b.a.HuQ;
        b.a.c(((a)localObject4).HwZ, str);
        localObject2 = ((View)localObject1).findViewById(a.d.HsG);
        p.j(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localdsq));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == d.e.Huz) || (RadarViewController.this.getRadarStatus() == d.e.HuA))
        {
          ((a)localObject4).Hxc.setBackgroundResource(a.c.HsD);
          paramView = ((a)localObject4).Hxa;
          paramView.HvK = true;
          paramView.ftx();
          paramView = ((a)localObject4).Hxb;
          paramView.HvF = false;
          paramView.setVisibility(8);
          localObject2 = com.tencent.mm.plugin.radar.b.d.a(RadarViewController.c(RadarViewController.this), localdsq);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).aVo(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            p.k(localdsq, "member");
            p.k(paramView, "state");
            localObject3 = localdsq.UserName;
            p.j(localObject3, "member.UserName");
            ((com.tencent.mm.plugin.radar.b.d)localObject2).b((String)localObject3, paramView);
            localObject3 = localdsq.Sxx;
            p.j(localObject3, "member.EncodeUserName");
            ((com.tencent.mm.plugin.radar.b.d)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localdsq, true);
          localObject5 = ((a)localObject4).Hxa;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = b.e.HtM;
          }
          p.k(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).HvL.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).Huy = ((b.e)localObject2);
          ((RadarStateView)localObject5).dic = false;
          ((RadarStateView)localObject5).ftx();
          localObject2 = ((a)localObject4).Hxa;
          p.k(paramView, "state");
          ((RadarStateView)localObject2).init();
          Log.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).Huy == paramView)
          {
            ((RadarStateView)localObject2).ftx();
            paramView = RadarViewController.c(RadarViewController.this);
            p.k(localdsq, "member");
            localObject2 = localdsq.UserName;
            p.j(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localdsq.Sxx;
            p.j(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.HwV = this.HwT.size();
            }
            paramView = (View)localObject1;
            if (this.HwT.remove(str) != null)
            {
              this.HwU.m(this.HwV - this.HwT.size(), (View)localObject1);
              paramView = (View)localObject1;
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(138739);
          return paramView;
          if (((RadarStateView)localObject2).getVisibility() == 0) {}
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              ((RadarStateView)localObject2).ftz();
              bool = true;
            }
            Log.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).Huy = paramView;
            if (((RadarStateView)localObject2).Huy == b.e.HtM) {
              break;
            }
            if (bool) {
              break label1265;
            }
            ((RadarStateView)localObject2).HvL.sendEmptyMessage(0);
            break;
          }
          label1265:
          ((RadarStateView)localObject2).HvL.sendEmptyMessageDelayed(0, RadarStateView.HvN + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).Hui;
          localObject3 = g.Hwt;
          if (!Util.isNullOrNil((String)((Map)localObject2).get(g.b(localdsq))))
          {
            paramView = ((a)localObject4).Hxa;
            paramView.HvK = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).Hxb;
            paramView.HvF = true;
            paramView.ftx();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localdsq != null)
            {
              localObject2 = g.Hwt;
              localObject2 = g.a(localdsq);
              localObject2 = (d.a)paramView.Hum.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = d.a.Huv;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = d.a.Huv;
            }
            if (localObject2 != d.a.Huv) {
              ((a)localObject4).Hxc.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).Hxb;
            p.k(localObject2, "status");
            if (paramView.HvG != localObject2)
            {
              paramView.HvG = ((d.a)localObject2);
              localObject2 = paramView.HvG;
              switch (e.jLJ[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.HwV = this.HwT.size();
              }
              localObject2 = this.HwT;
              paramView = g.Hwt;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.b(localdsq)) == null) {
                break;
              }
              this.HwU.m(this.HwV - this.HwT.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.HvF)
              {
                paramView.ftx();
                paramView.dic = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.HvF)
                {
                  paramView.ftx();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = at(paramView, paramInt);
          continue;
          label1631:
          paramView = at(paramView, paramInt);
        }
        label1641:
        localObject1 = paramView;
      }
    }
    
    public final void bE(LinkedList<dsq> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).HwR.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (dsq)((Iterator)localObject2).next();
          localObject4 = g.Hwt;
          localObject4 = g.b((dsq)localObject3);
          g localg = g.Hwt;
          if (p.h(localObject4, g.b(localObject1.HwR[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label282:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dsq)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.HwR.length;
        i = 0;
        label176:
        int n;
        if (i < m)
        {
          n = (i + k) % 12;
          if ((n != 4) && (n != 7)) {
            break label211;
          }
        }
        label211:
        label341:
        label347:
        label353:
        label357:
        for (;;)
        {
          i += 1;
          break label176;
          break;
          localObject3 = this.HwR[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((dsq)localObject3).UserName;
            if ((localObject4 != null) && (!n.ba((CharSequence)localObject4))) {
              break label341;
            }
            j = 1;
            label251:
            if (j == 0) {
              break label353;
            }
            localObject3 = (CharSequence)((dsq)localObject3).Sxx;
            if ((localObject3 != null) && (!n.ba((CharSequence)localObject3))) {
              break label347;
            }
            j = 1;
            if (j == 0) {
              break label353;
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label357;
            }
            this.HwR[n] = localObject2;
            localObject3 = this.HwT;
            localObject4 = g.Hwt;
            p.j(localObject2, "member");
            ((HashMap)localObject3).put(g.a((dsq)localObject2), Integer.valueOf(0));
            break;
            j = 0;
            break label251;
            j = 0;
            break label282;
          }
        }
      }
      if (paramLinkedList.size() > 0)
      {
        cnv();
        localObject1 = c.Hue;
        i = paramLinkedList.size();
        if ((c.fLk == 0) && (i > 0))
        {
          float f = (float)(c.ftm() - c.Hua) * 1.0F / 1000.0F;
          Log.d(c.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.h.IzE;
          localObject1 = af.aaBG;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          p.j(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        c.fLk += i;
        c.Hub = i + c.Hub;
      }
      AppMethodBeat.o(138738);
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.HwT.clear();
      this.HwW.clear();
      Iterator localIterator = this.HwW.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.HwW.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.HwU;
          p.j(localObject, "it");
          locala.cD((View)localObject);
        }
      }
      cnv();
      AppMethodBeat.o(138740);
    }
    
    public final int getCount()
    {
      if (this.HwX) {
        return 0;
      }
      return this.HwR.length;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView HwY;
      ImageView HwZ;
      RadarStateView Hxa;
      RadarStateChooseView Hxb;
      ImageView Hxc;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.HwY = paramImageView1;
        this.HwZ = paramRadarStateView;
        this.Hxa = paramRadarStateChooseView;
        this.Hxb = paramImageView2;
        this.Hxc = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if ((this.HwP.getRadarStatus() == d.e.Huz) || (this.HwP.getRadarStatus() == d.e.HuA))
      {
        paramView = this.HwP.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138748);
          throw paramView;
        }
        ((Activity)paramView).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138748);
        return;
      }
      paramView = this.HwP;
      localObject = RadarViewController.d(this.HwP);
      LinkedList localLinkedList = new LinkedList();
      int j = ((RadarViewController.c)localObject).HwR.length;
      int i = 0;
      while (i < j)
      {
        dsq localdsq = localObject.HwR[i];
        if (localdsq != null) {
          localLinkedList.add(localdsq);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.HwP).ftI();
        RadarViewController.f(this.HwP).setVisibility(0);
        RadarViewController.c(this.HwP).ftn();
        RadarViewController.a(this.HwP, d.e.HuA);
      }
      for (;;)
      {
        RadarViewController.d(this.HwP).cnv();
        break;
        RadarViewController.a(this.HwP, d.e.Huz);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cW(this.HwP.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      int k = 0;
      AppMethodBeat.i(138751);
      p.k(paramView, "view");
      final dsq localdsq = (dsq)RadarViewController.d(this.HwP).HwR[paramInt];
      if (localdsq == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.HwP.getRadarStatus();
      Object localObject2;
      int i;
      switch (h.jLJ[localObject1.ordinal()])
      {
      default: 
        Log.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.HwP.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.Hwt;
        localObject1 = g.a(localdsq);
        if (localdsq != null)
        {
          localObject2 = (CharSequence)localdsq.UserName;
          if ((localObject2 != null) && (!n.ba((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = k;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localdsq.Sxx;
          if ((localObject2 != null) && (!n.ba((CharSequence)localObject2))) {
            break label284;
          }
        }
        label279:
        label284:
        for (i = 1;; i = 0)
        {
          paramInt = k;
          if (i != 0) {
            paramInt = 1;
          }
          label199:
          if (paramInt != 0) {
            break;
          }
          localObject2 = (View)RadarViewController.d(this.HwP).HwW.get(localObject1);
          localObject1 = com.tencent.mm.plugin.radar.b.d.a(RadarViewController.c(this.HwP), localdsq);
          if ((localObject2 == null) || (localObject1 == b.e.HtM)) {
            break label348;
          }
          localObject2 = ((View)localObject2).getTag();
          if (localObject2 != null) {
            break label289;
          }
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138751);
          throw paramView;
          i = 0;
          break label158;
        }
        label289:
        ((RadarViewController.c.a)localObject2).Hxa.ftz();
        localObject2 = new MMHandler();
        paramView = (Runnable)new a(this, paramView, localdsq, (b.e)localObject1);
        localObject1 = RadarStateView.HvO;
        ((MMHandler)localObject2).postDelayed(paramView, RadarStateView.ftA());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.HwP).a(paramView, localdsq, (b.e)localObject1);
        RadarViewController.f(this.HwP).ftJ();
        AppMethodBeat.o(138751);
        return;
      }
      if (localdsq != null)
      {
        paramView = (CharSequence)localdsq.UserName;
        if ((paramView == null) || (n.ba(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localdsq.Sxx;
          if ((paramView != null) && (!n.ba(paramView))) {
            break label536;
          }
          paramInt = 1;
          label432:
          if (paramInt == 0) {
            break label541;
          }
        }
      }
      else
      {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt == 0)
        {
          localObject2 = RadarViewController.d(this.HwP);
          if (localdsq != null)
          {
            paramView = g.Hwt;
            localObject1 = g.a(localdsq);
            paramView = (View)localObject1;
            if (RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.containsKey(localObject1))
            {
              paramView = RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.get(localObject1);
              if (paramView == null)
              {
                paramView = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(138751);
                throw paramView;
                paramInt = 0;
                break;
                label536:
                paramInt = 0;
                break label432;
                label541:
                paramInt = 0;
                continue;
              }
              paramView = (String)paramView;
            }
            if (((RadarViewController.c)localObject2).HwS.containsKey(paramView))
            {
              paramInt = 1;
              if (paramInt != 0) {
                break label831;
              }
              localObject2 = RadarViewController.d(this.HwP);
              if (localdsq != null)
              {
                paramView = (CharSequence)localdsq.UserName;
                if ((paramView != null) && (!n.ba(paramView))) {
                  break label735;
                }
                i = 1;
                label605:
                paramInt = j;
                if (i == 0) {
                  break label643;
                }
                paramView = (CharSequence)localdsq.Sxx;
                if ((paramView != null) && (!n.ba(paramView))) {
                  break label740;
                }
              }
            }
          }
          label643:
          label735:
          label740:
          for (i = 1;; i = 0)
          {
            paramInt = j;
            if (i != 0) {
              paramInt = 1;
            }
            if (paramInt != 0) {
              break label761;
            }
            paramView = g.Hwt;
            if (localdsq == null) {
              p.iCn();
            }
            localObject1 = g.a(localdsq);
            paramView = (View)localObject1;
            if (!RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.containsKey(localObject1)) {
              break label750;
            }
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.get(localObject1);
            if (paramView != null) {
              break label745;
            }
            paramView = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(138751);
            throw paramView;
            paramInt = 0;
            break;
            i = 0;
            break label605;
          }
          label745:
          paramView = (String)paramView;
          label750:
          ((RadarViewController.c)localObject2).HwS.put(paramView, paramView);
        }
      }
      label761:
      paramView = RadarViewController.c(this.HwP);
      if (localdsq != null)
      {
        localObject1 = g.Hwt;
        localObject1 = g.a(localdsq);
        if (!paramView.Hum.containsKey(localObject1)) {
          break label1019;
        }
        paramView.Hum.remove(localObject1);
      }
      for (;;)
      {
        RadarViewController.ftF();
        RadarViewController.d(this.HwP).cnv();
        AppMethodBeat.o(138751);
        return;
        label831:
        localObject2 = RadarViewController.d(this.HwP);
        if (localdsq != null)
        {
          paramView = (CharSequence)localdsq.UserName;
          if ((paramView != null) && (!n.ba(paramView))) {
            break label986;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label996;
          }
          paramView = (CharSequence)localdsq.Sxx;
          if ((paramView != null) && (!n.ba(paramView))) {
            break label991;
          }
          paramInt = 1;
          label893:
          if (paramInt == 0) {
            break label996;
          }
        }
        label986:
        label991:
        label996:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label999;
          }
          paramView = g.Hwt;
          if (localdsq == null) {
            p.iCn();
          }
          localObject1 = g.a(localdsq);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.containsKey(localObject1)) {
            break label1006;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).HwP).Hui.get(localObject1);
          if (paramView != null) {
            break label1001;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138751);
          throw paramView;
          paramInt = 0;
          break;
          paramInt = 0;
          break label893;
        }
        label999:
        break;
        label1001:
        paramView = (String)paramView;
        label1006:
        ((RadarViewController.c)localObject2).HwS.remove(paramView);
        break;
        label1019:
        paramView.Hum.put(localObject1, d.a.Huu);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, dsq paramdsq, b.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.Hxe.HwP).a(paramView, localdsq, this.Hxf);
        RadarViewController.f(this.Hxe.HwP).ftJ();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<RadarWaveView>
  {
    i(RadarViewController paramRadarViewController)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */