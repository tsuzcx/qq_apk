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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.a;
import com.tencent.mm.plugin.radar.b.c.c;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.a;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.plugin.radar.b.e.d;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.g.b.z;
import d.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final RadarViewController.b wdJ;
  private boolean udt;
  e wdA;
  c wdB;
  c wdC;
  private e.e wdD;
  private final boolean wdE;
  final View.OnClickListener wdF;
  private final int wdG;
  private final int wdH;
  private final int wdI;
  private final f wds;
  private final f wdt;
  private final f wdu;
  private final f wdv;
  private final f wdw;
  private final f wdx;
  private final f wdy;
  private final f wdz;
  
  static
  {
    AppMethodBeat.i(138753);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bn(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;")) };
    wdJ = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.wds = d.g.K((d.g.a.a)new i(this));
    this.wdt = i.an(this, 2131303683);
    this.wdu = i.an(this, 2131303698);
    this.wdv = i.an(this, 2131303700);
    this.wdw = i.an(this, 2131303688);
    this.wdx = i.an(this, 2131303689);
    this.wdy = i.an(this, 2131303692);
    this.wdz = i.an(this, 2131303677);
    this.wdD = e.e.wbw;
    this.wdF = ((View.OnClickListener)new f(this));
    this.wdG = 33554432;
    this.wdH = (this.wdG + 1);
    this.wdI = (this.wdG + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    d.g.b.k.g(localContext, "mContext.getApplicationContext()");
    this.wdA = new e(paramAttributeSet, localContext);
    this.wdB = new c((c.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(138775);
    this.wdD = parame;
    switch (h.wec[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(2131762149);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().dtb();
      getWaveView().setVisibility(0);
      parame = this.wdA;
      if (parame == null) {
        d.g.b.k.aVY("radarManager");
      }
      parame.dsH();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      dsY();
      getQuitBtn().setText(2131755691);
      parame = this.wdA;
      if (parame == null) {
        d.g.b.k.aVY("radarManager");
      }
      parame.dsI();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762151);
      getWaveView().dtc();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.wdC;
      if (parame == null) {
        d.g.b.k.aVY("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.wdA;
      if (parame == null) {
        d.g.b.k.aVY("radarManager");
      }
      parame.dsI();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131762140);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.wdA;
      if (parame == null) {
        d.g.b.k.aVY("radarManager");
      }
      parame.dsI();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762141);
    }
  }
  
  private final void aJ(LinkedList<cli> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      d.g.b.k.fOy();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.wdC;
      if (localc == null) {
        d.g.b.k.aVY("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      ac.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = aK(paramLinkedList);
      ac.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.wdC;
      if (localc == null) {
        d.g.b.k.aVY("adapter");
      }
      localc.aL(paramLinkedList);
      if ((this.wdE) && (bool)) {
        a(e.e.wbx);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean aK(LinkedList<cli> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      d.g.b.k.fOy();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (cli)localIterator.next();
      paramLinkedList = this.wdA;
      if (paramLinkedList == null) {
        d.g.b.k.aVY("radarManager");
      }
      d.g.b.k.g(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (cli)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.wdr;
      localObject = g.b((cli)localObject);
      paramLinkedList = this.wdB.aqh((String)localObject);
      e locale = this.wdA;
      if (locale == null) {
        d.g.b.k.aVY("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.waI) {
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
  
  private final void d(String paramString, c.e parame)
  {
    AppMethodBeat.i(138765);
    Object localObject = this.wdA;
    if (localObject == null) {
      d.g.b.k.aVY("radarManager");
    }
    if (paramString == null) {
      d.g.b.k.fOy();
    }
    localObject = ((e)localObject).aqi(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.wdA;
      if (localObject == null) {
        d.g.b.k.aVY("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.wdC;
      if (paramString == null) {
        d.g.b.k.aVY("adapter");
      }
      paramString.bzd();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void dsY()
  {
    AppMethodBeat.i(138776);
    if (getRadarBgMask().getVisibility() != 0)
    {
      getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), 2130772110));
      getRadarBgMask().setVisibility(0);
    }
    AppMethodBeat.o(138776);
  }
  
  private final TextView getNewRadarTip()
  {
    AppMethodBeat.i(138758);
    TextView localTextView = (TextView)this.wdw.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.wdx.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.wdz.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void X(ai paramai)
  {
    AppMethodBeat.i(138769);
    d.g.b.k.h(paramai, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramai.Tq();
      d.g.b.k.g(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.waI);
    }
    d(paramai.getUsername(), c.e.waI);
    d(paramai.Tq(), c.e.waI);
    AppMethodBeat.o(138769);
  }
  
  public final void Y(ai paramai)
  {
    AppMethodBeat.i(138768);
    d.g.b.k.h(paramai, "contact");
    Object localObject = this.wdA;
    if (localObject == null) {
      d.g.b.k.aVY("radarManager");
    }
    String str1 = paramai.getUsername();
    d.g.b.k.g(str1, "contact.username");
    if (((e)localObject).aqi(str1) == null)
    {
      localObject = this.wdA;
      if (localObject == null) {
        d.g.b.k.aVY("radarManager");
      }
      str1 = paramai.Tq();
      d.g.b.k.g(str1, "contact.encryptUsername");
      if (((e)localObject).aqi(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramai.getUsername();
        d.g.b.k.g(str1, "contact.username");
        String str2 = paramai.Tq();
        d.g.b.k.g(str2, "contact.encryptUsername");
        String str3 = paramai.Tn();
        d.g.b.k.g(str3, "contact.nickname");
        cli localcli = new cli();
        localcli.FyM = 100;
        localcli.ncR = str1;
        localcli.ndW = str3;
        localcli.SmallImgUrl = "";
        localcli.EyO = str2;
        ((LinkedList)localObject).add(localcli);
        aJ((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramai.Tq();
      d.g.b.k.g(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.waJ);
    }
    d(paramai.getUsername(), c.e.waJ);
    d(paramai.Tq(), c.e.waJ);
    AppMethodBeat.o(138768);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<cli> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131761535);
        d.g.b.k.g(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.aqj(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131762155);
      d.g.b.k.g(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.aqj(str);
      AppMethodBeat.o(138771);
      return;
    }
    aJ(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, c.e.waI);
    }
    for (;;)
    {
      paramString1 = this.wdA;
      if (paramString1 == null) {
        d.g.b.k.aVY("radarManager");
      }
      paramString1.wbi.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.aqj(paramString2);
      paramString1 = this.wdA;
      if (paramString1 == null) {
        d.g.b.k.aVY("radarManager");
      }
      paramString1 = (e.c)paramString1.wbi.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.wdr;
        d(g.b(paramString1.wbu), paramString1.wbv);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, c.e.waI);
    }
    for (;;)
    {
      paramString1 = this.wdA;
      if (paramString1 == null) {
        d.g.b.k.aVY("radarManager");
      }
      paramString1.wbi.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.waH);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.aqj(paramString2);
        paramString1 = this.wdA;
        if (paramString1 == null) {
          d.g.b.k.aVY("radarManager");
        }
        paramString1 = (e.c)paramString1.wbi.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.wdr;
          d(g.b(paramString1.wbu), paramString1.wbv);
          paramString2 = g.wdr;
          d(g.c(paramString1.wbu), paramString1.wbv);
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<clf> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(138772);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.wbz);
      c localc = this.wdC;
      if (localc == null) {
        d.g.b.k.aVY("adapter");
      }
      c(localc.wdN).wbj.clear();
      c(localc.wdN).wbf.clear();
      localc.wdQ.clear();
      localc.wdR.clear();
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
            d.g.b.k.g(localObject2, "radarChatMember[i]");
            localObject2 = (clf)localObject2;
            localObject3 = new clg();
            ((clg)localObject3).FyL = ((clf)localObject2).ncR;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.wdN).wbf;
            Object localObject4 = ((clf)localObject2).EyO;
            d.g.b.k.g(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((clf)localObject2).ncR;
            d.g.b.k.g(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.wdR;
            localObject4 = g.wdr;
            ((HashMap)localObject3).put(g.a((clf)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.wdP.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.wdP[paramInt1];
            localObject2 = c(localc.wdN).wbf;
            localObject3 = g.wdr;
            if (!bs.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.wdN).d(paramLinkedList);
              c(localc.wdN).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.wdN).wbe = ((LinkedList)localObject1);
      paramLinkedList = this.wdC;
      if (paramLinkedList == null) {
        d.g.b.k.aVY("adapter");
      }
      paramLinkedList.bzd();
      AppMethodBeat.o(138772);
      return;
    }
    a(e.e.wbw);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131762155);
    d.g.b.k.g(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.aqj((String)localObject1);
    AppMethodBeat.o(138772);
  }
  
  public final void dsH()
  {
    AppMethodBeat.i(138763);
    e locale = this.wdA;
    if (locale == null) {
      d.g.b.k.aVY("radarManager");
    }
    locale.dsH();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.wdu.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.wdt.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.wdy.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.wdD;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.wdv.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.wds.getValue();
    AppMethodBeat.o(138754);
    return localRadarWaveView;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138764);
    d.g.b.k.h(paramKeyEvent, "event");
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
    e locale = this.wdA;
    if (locale == null) {
      d.g.b.k.aVY("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(138762);
  }
  
  public final void pf(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131762154);
      d.g.b.k.g(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.aqj(str);
      if ((!this.udt) && (!com.tencent.mm.modelgeo.d.aEM()))
      {
        this.udt = true;
        com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(2131760082), getContext().getString(2131755906), getContext().getString(2131760598), getContext().getString(2131755691), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int wdK;
    final boolean wdL;
    private final a wdM;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.wdr;
      this$1 = this$1.getContext();
      d.g.b.k.g(this$1, "context");
      this.wdL = g.fS(this$1);
      this.wdM = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int eo(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.wdN));
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
    
    public final void cv(View paramView)
    {
      AppMethodBeat.i(138734);
      d.g.b.k.h(paramView, "view");
      int i = eo(paramView);
      if (i > 0) {
        this.wdM.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final int dta()
    {
      this.wdK += 1;
      return this.wdK;
    }
    
    public final Animation getInAnimation()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.wdN.getContext(), 2130772117);
      d.g.b.k.g(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final void i(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      d.g.b.k.h(paramView, "view");
      Message localMessage = this.wdM.obtainMessage();
      localMessage.what = eo(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.wdM.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends ao
    {
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(138731);
        d.g.b.k.h(paramMessage, "msg");
        if ((paramMessage.obj instanceof View))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(138731);
            throw paramMessage;
          }
          View localView = (View)paramMessage;
          localView.setVisibility(0);
          localView.clearAnimation();
          if (!this.wdO.wdL)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.wdO.wdN));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.wdO.getInAnimation();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    private final Context context;
    cli[] wdP;
    HashMap<String, String> wdQ;
    HashMap<String, Integer> wdR;
    private final RadarViewController.a wdS;
    private int wdT;
    HashMap<String, View> wdU;
    private boolean wdV;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.wdP = new cli[12];
      this.wdQ = new HashMap();
      this.wdR = new HashMap();
      this.wdU = new HashMap();
      this.wdS = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View am(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, 2131495170, null);
        if (localView == null) {
          d.g.b.k.fOy();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.wdS.dta()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.wdS.getInAnimation());
      }
      paramView = localView.findViewById(2131303693);
      d.g.b.k.g(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131303694);
      d.g.b.k.g(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131303695);
      d.g.b.k.g(paramView, "anotherConvertView.findV…_result_item_username_tv)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131303687);
      d.g.b.k.g(paramView, "anotherConvertView.findV….radar_member_state_view)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131303686);
      d.g.b.k.g(paramView, "anotherConvertView.findV…member_state_choose_view)");
      paramView.setVisibility(4);
      if ((paramInt == 7) || (paramInt % 3 == 1))
      {
        paramView = localView.findViewById(2131297468);
        d.g.b.k.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131306022);
        d.g.b.k.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(138741);
        return localView;
        paramView = localView.findViewById(2131306022);
        d.g.b.k.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131297468);
        d.g.b.k.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(8);
      }
    }
    
    public final void aL(LinkedList<cli> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).wdP.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (cli)((Iterator)localObject2).next();
          localObject4 = g.wdr;
          localObject4 = g.c((cli)localObject3);
          g localg = g.wdr;
          if (d.g.b.k.g(localObject4, g.c(localObject1.wdP[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label280:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cli)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.wdP.length;
        i = 0;
        label174:
        int n;
        if (i < m)
        {
          n = (i + k) % 12;
          if ((n != 4) && (n != 7)) {
            break label209;
          }
        }
        label209:
        label339:
        label345:
        label351:
        label355:
        for (;;)
        {
          i += 1;
          break label174;
          break;
          localObject3 = this.wdP[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((cli)localObject3).ncR;
            if ((localObject4 != null) && (!d.n.n.aD((CharSequence)localObject4))) {
              break label339;
            }
            j = 1;
            label249:
            if (j == 0) {
              break label351;
            }
            localObject3 = (CharSequence)((cli)localObject3).EyO;
            if ((localObject3 != null) && (!d.n.n.aD((CharSequence)localObject3))) {
              break label345;
            }
            j = 1;
            if (j == 0) {
              break label351;
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label355;
            }
            this.wdP[n] = localObject2;
            localObject3 = this.wdR;
            localObject4 = g.wdr;
            d.g.b.k.g(localObject2, "member");
            ((HashMap)localObject3).put(g.b((cli)localObject2), Integer.valueOf(0));
            break;
            j = 0;
            break label249;
            j = 0;
            break label280;
          }
        }
      }
      if (paramLinkedList.size() > 0)
      {
        bzd();
        localObject1 = com.tencent.mm.plugin.radar.b.d.wba;
        i = paramLinkedList.size();
        if ((com.tencent.mm.plugin.radar.b.d.dni == 0) && (i > 0))
        {
          float f = (float)(com.tencent.mm.plugin.radar.b.d.dsG() - com.tencent.mm.plugin.radar.b.d.waW) * 1.0F / 1000.0F;
          ac.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.h.wUl;
          localObject1 = z.KUT;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          d.g.b.k.g(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        com.tencent.mm.plugin.radar.b.d.dni += i;
        com.tencent.mm.plugin.radar.b.d.waX = i + com.tencent.mm.plugin.radar.b.d.waX;
      }
      AppMethodBeat.o(138738);
    }
    
    public final View al(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      ac.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      cli localcli = (cli)this.wdP[paramInt];
      Object localObject1;
      int i;
      label99:
      label105:
      String str;
      Object localObject2;
      if (localcli != null)
      {
        localObject1 = (CharSequence)localcli.ncR;
        if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label238;
          }
          localObject1 = (CharSequence)localcli.EyO;
          if ((localObject1 != null) && (!d.n.n.aD((CharSequence)localObject1))) {
            break label233;
          }
          i = 1;
          if (i == 0) {
            break label238;
          }
          i = 1;
          if (i != 0) {
            break label1631;
          }
          localObject1 = g.wdr;
          str = g.b(localcli);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1641;
          }
          localObject1 = View.inflate(this.context, 2131495170, null);
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.wdS.dta()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.wdS.getInAnimation());
        }
      }
      for (;;)
      {
        Object localObject3 = ((View)localObject1).findViewById(2131303693);
        if (localObject3 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
          i = 0;
          break;
          label233:
          i = 0;
          break label99;
          label238:
          i = 0;
          break label105;
        }
        localObject3 = (ImageView)localObject3;
        Object localObject4 = ((View)localObject1).findViewById(2131303687);
        if (localObject4 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject4 = (RadarStateView)localObject4;
        Object localObject5 = ((View)localObject1).findViewById(2131303695);
        if (localObject5 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject5 = (TextView)localObject5;
        Object localObject6 = ((View)localObject1).findViewById(2131303694);
        if (localObject6 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject6 = (ImageView)localObject6;
        Object localObject7 = ((View)localObject1).findViewById(2131303686);
        if (localObject7 == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject7 = (RadarStateChooseView)localObject7;
        ((ImageView)localObject3).setVisibility(0);
        ((RadarStateView)localObject4).setVisibility(0);
        ((TextView)localObject5).setVisibility(0);
        ((ImageView)localObject6).setVisibility(0);
        if ((localObject2 == e.e.wbw) || (localObject2 == e.e.wbx))
        {
          ((RadarStateView)localObject4).setVisibility(0);
          ((RadarStateChooseView)localObject7).setVisibility(8);
          ((View)localObject1).setTag(new a((TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
          if ((paramInt != 7) && (paramInt % 3 != 1)) {
            break label613;
          }
          localObject2 = ((View)localObject1).findViewById(2131297468);
          d.g.b.k.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131306022);
          d.g.b.k.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(8);
        }
        for (;;)
        {
          if ((paramView == null) || (localObject1 != paramView)) {
            this.wdU.put(str, localObject1);
          }
          localObject2 = ((View)localObject1).getTag();
          if (localObject2 != null) {
            break label661;
          }
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138739);
          throw paramView;
          ((RadarStateView)localObject4).setVisibility(8);
          ((RadarStateChooseView)localObject7).setVisibility(0);
          break;
          label613:
          localObject2 = ((View)localObject1).findViewById(2131306022);
          d.g.b.k.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131297468);
          d.g.b.k.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(8);
        }
        label661:
        localObject4 = (a)localObject2;
        ((a)localObject4).wdW.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(RadarViewController.this.getContext(), (CharSequence)localcli.ndW, ((a)localObject4).wdW.getTextSize()));
        localObject2 = b.a.wbN;
        b.a.c(((a)localObject4).wdX, str);
        localObject2 = ((View)localObject1).findViewById(2131303675);
        d.g.b.k.g(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localcli));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == e.e.wbw) || (RadarViewController.this.getRadarStatus() == e.e.wbx))
        {
          ((a)localObject4).wea.setBackgroundResource(2131233935);
          paramView = ((a)localObject4).wdY;
          paramView.wcI = true;
          paramView.dsR();
          paramView = ((a)localObject4).wdZ;
          paramView.wcD = false;
          paramView.setVisibility(8);
          localObject2 = e.a(RadarViewController.c(RadarViewController.this), localcli);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).aqh(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            d.g.b.k.h(localcli, "member");
            d.g.b.k.h(paramView, "state");
            localObject3 = localcli.ncR;
            d.g.b.k.g(localObject3, "member.UserName");
            ((e)localObject2).b((String)localObject3, paramView);
            localObject3 = localcli.EyO;
            d.g.b.k.g(localObject3, "member.EncodeUserName");
            ((e)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localcli, true);
          localObject5 = ((a)localObject4).wdY;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = c.e.waG;
          }
          d.g.b.k.h(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).wcJ.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).wbv = ((c.e)localObject2);
          ((RadarStateView)localObject5).cBT = false;
          ((RadarStateView)localObject5).dsR();
          localObject2 = ((a)localObject4).wdY;
          d.g.b.k.h(paramView, "state");
          ((RadarStateView)localObject2).init();
          ac.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).wbv == paramView)
          {
            ((RadarStateView)localObject2).dsR();
            paramView = RadarViewController.c(RadarViewController.this);
            d.g.b.k.h(localcli, "member");
            localObject2 = localcli.ncR;
            d.g.b.k.g(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localcli.EyO;
            d.g.b.k.g(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.wdT = this.wdR.size();
            }
            paramView = (View)localObject1;
            if (this.wdR.remove(str) != null)
            {
              this.wdS.i(this.wdT - this.wdR.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).dsT();
              bool = true;
            }
            ac.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).wbv = paramView;
            if (((RadarStateView)localObject2).wbv == c.e.waG) {
              break;
            }
            if (bool) {
              break label1264;
            }
            ((RadarStateView)localObject2).wcJ.sendEmptyMessage(0);
            break;
          }
          label1264:
          ((RadarStateView)localObject2).wcJ.sendEmptyMessageDelayed(0, RadarStateView.wcL + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).wbf;
          localObject3 = g.wdr;
          if (!bs.isNullOrNil((String)((Map)localObject2).get(g.c(localcli))))
          {
            paramView = ((a)localObject4).wdY;
            paramView.wcI = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).wdZ;
            paramView.wcD = true;
            paramView.dsR();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localcli != null)
            {
              localObject2 = g.wdr;
              localObject2 = g.b(localcli);
              localObject2 = (e.a)paramView.wbj.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = e.a.wbs;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = e.a.wbs;
            }
            if (localObject2 != e.a.wbs) {
              ((a)localObject4).wea.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).wdZ;
            d.g.b.k.h(localObject2, "status");
            if (paramView.wcE != localObject2)
            {
              paramView.wcE = ((e.a)localObject2);
              localObject2 = paramView.wcE;
              switch (e.fTL[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.wdT = this.wdR.size();
              }
              localObject2 = this.wdR;
              paramView = g.wdr;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.c(localcli)) == null) {
                break;
              }
              this.wdS.i(this.wdT - this.wdR.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.wcD)
              {
                paramView.dsR();
                paramView.cBT = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.wcD)
                {
                  paramView.dsR();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = am(paramView, paramInt);
          continue;
          label1631:
          paramView = am(paramView, paramInt);
        }
        label1641:
        localObject1 = paramView;
      }
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.wdR.clear();
      this.wdU.clear();
      Iterator localIterator = this.wdU.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.wdU.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.wdS;
          d.g.b.k.g(localObject, "it");
          locala.cv((View)localObject);
        }
      }
      bzd();
      AppMethodBeat.o(138740);
    }
    
    public final void d(cli paramcli)
    {
      AppMethodBeat.i(138742);
      if (paramcli != null)
      {
        localObject = (CharSequence)paramcli.ncR;
        if ((localObject != null) && (!d.n.n.aD((CharSequence)localObject))) {
          break label73;
        }
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = (CharSequence)paramcli.EyO;
        if ((localObject != null) && (!d.n.n.aD((CharSequence)localObject))) {
          break label78;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label83;
        }
      }
      label73:
      label78:
      label83:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label88;
        }
        AppMethodBeat.o(138742);
        return;
        i = 0;
        break;
        i = 0;
        break label56;
      }
      label88:
      Object localObject = g.wdr;
      if (paramcli == null) {
        d.g.b.k.fOy();
      }
      localObject = g.b(paramcli);
      paramcli = (cli)localObject;
      if (RadarViewController.c(RadarViewController.this).wbf.containsKey(localObject))
      {
        paramcli = RadarViewController.c(RadarViewController.this).wbf.get(localObject);
        if (paramcli == null)
        {
          paramcli = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramcli;
        }
        paramcli = (String)paramcli;
      }
      this.wdQ.put(paramcli, paramcli);
      AppMethodBeat.o(138742);
    }
    
    public final int getCount()
    {
      if (this.wdV) {
        return 0;
      }
      return this.wdP.length;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView wdW;
      ImageView wdX;
      RadarStateView wdY;
      RadarStateChooseView wdZ;
      ImageView wea;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.wdW = paramImageView1;
        this.wdX = paramRadarStateView;
        this.wdY = paramRadarStateChooseView;
        this.wdZ = paramImageView2;
        this.wea = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static final class e
    implements RadarMemberView.b
  {
    public final void a(cli paramcli, c.e parame)
    {
      AppMethodBeat.i(138746);
      d.g.b.k.h(paramcli, "member");
      Object localObject1 = g.wdr;
      String str = g.b(paramcli);
      if (parame == null)
      {
        AppMethodBeat.o(138746);
        return;
      }
      switch (h.cfA[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(138746);
        return;
      case 1: 
        l = RadarViewController.e(this.wdN).aqg(str);
        RadarViewController.c(this.wdN).wbi.put(Long.valueOf(l), new e.c(paramcli, parame));
        RadarViewController.a(this.wdN, str, c.e.waH);
        AppMethodBeat.o(138746);
        return;
      }
      Object localObject2 = RadarViewController.e(this.wdN);
      d.g.b.k.h(str, "username");
      localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(str);
      d.g.b.k.g(localObject1, "contact");
      Object localObject3 = (CharSequence)((ai)localObject1).getUsername();
      if ((localObject3 == null) || (d.n.n.aD((CharSequence)localObject3)))
      {
        i = 1;
        label213:
        if (i == 0) {
          break label342;
        }
        localObject1 = str;
        label221:
        localObject3 = (String)((c)localObject2).wax.get(localObject1);
        localObject4 = (CharSequence)localObject3;
        if ((localObject4 != null) && (!d.n.n.aD((CharSequence)localObject4))) {
          break label359;
        }
      }
      label342:
      label359:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label364;
        }
        ac.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
        ((c)localObject2).aqg((String)localObject1);
        l = -1L;
        RadarViewController.c(this.wdN).wbi.put(Long.valueOf(l), new e.c(paramcli, parame));
        RadarViewController.a(this.wdN, str, c.e.waH);
        break;
        i = 0;
        break label213;
        localObject1 = ((ai)localObject1).getUsername();
        d.g.b.k.g(localObject1, "contact.username");
        break label221;
      }
      label364:
      Object localObject4 = bo.d.aOn((String)localObject3);
      long l = System.currentTimeMillis();
      localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
      localObject3 = ((bo.d)localObject4).fco();
      d.g.b.k.g(localObject3, "verify.verifyTicket");
      d.g.b.k.h(localObject3, "verifyTicket");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("username is null", bool);
        ((c.a)localObject2).onStart();
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)new o((String)localObject1, (String)localObject3, 48));
        break;
      }
    }
    
    public final void b(cli paramcli, c.e parame)
    {
      AppMethodBeat.i(138747);
      if (paramcli != null) {
        g localg = g.wdr;
      }
      for (paramcli = g.b(paramcli);; paramcli = null)
      {
        paramcli = (View)((Map)RadarViewController.d(this.wdN).wdU).get(paramcli);
        if (paramcli == null) {
          break label96;
        }
        paramcli = paramcli.getTag();
        if (paramcli != null) {
          break;
        }
        paramcli = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(138747);
        throw paramcli;
      }
      paramcli = (RadarViewController.c.a)paramcli;
      if (parame != c.e.waG) {
        paramcli.wdY.dsS();
      }
      label96:
      RadarViewController.f(this.wdN).dtb();
      AppMethodBeat.o(138747);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      if ((this.wdN.getRadarStatus() == e.e.wbw) || (this.wdN.getRadarStatus() == e.e.wbx))
      {
        paramView = this.wdN.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138748);
          throw paramView;
        }
        ((Activity)paramView).finish();
        AppMethodBeat.o(138748);
        return;
      }
      paramView = this.wdN;
      RadarViewController.c localc = RadarViewController.d(this.wdN);
      LinkedList localLinkedList = new LinkedList();
      int j = localc.wdP.length;
      int i = 0;
      while (i < j)
      {
        cli localcli = localc.wdP[i];
        if (localcli != null) {
          localLinkedList.add(localcli);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.wdN).dtb();
        RadarViewController.f(this.wdN).setVisibility(0);
        RadarViewController.c(this.wdN).dsH();
        RadarViewController.a(this.wdN, e.e.wbx);
      }
      for (;;)
      {
        RadarViewController.d(this.wdN).bzd();
        AppMethodBeat.o(138748);
        return;
        RadarViewController.a(this.wdN, e.e.wbw);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cE(this.wdN.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      AppMethodBeat.i(138751);
      d.g.b.k.h(paramView, "view");
      final cli localcli = (cli)RadarViewController.d(this.wdN).wdP[paramInt];
      if (localcli == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.wdN.getRadarStatus();
      Object localObject2;
      switch (h.fTL[localObject1.ordinal()])
      {
      default: 
        ac.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.wdN.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.wdr;
        localObject1 = g.b(localcli);
        if (localcli != null)
        {
          localObject2 = (CharSequence)localcli.ncR;
          if ((localObject2 != null) && (!d.n.n.aD((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = j;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localcli.EyO;
          if ((localObject2 != null) && (!d.n.n.aD((CharSequence)localObject2))) {
            break label284;
          }
        }
        label279:
        label284:
        for (int i = 1;; i = 0)
        {
          paramInt = j;
          if (i != 0) {
            paramInt = 1;
          }
          label199:
          if (paramInt != 0) {
            break;
          }
          localObject2 = (View)RadarViewController.d(this.wdN).wdU.get(localObject1);
          localObject1 = e.a(RadarViewController.c(this.wdN), localcli);
          if ((localObject2 == null) || (localObject1 == c.e.waG)) {
            break label348;
          }
          localObject2 = ((View)localObject2).getTag();
          if (localObject2 != null) {
            break label289;
          }
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138751);
          throw paramView;
          i = 0;
          break label158;
        }
        label289:
        ((RadarViewController.c.a)localObject2).wdY.dsT();
        localObject2 = new ao();
        paramView = (Runnable)new a(this, paramView, localcli, (c.e)localObject1);
        localObject1 = RadarStateView.wcM;
        ((ao)localObject2).postDelayed(paramView, RadarStateView.dsU());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.wdN).a(paramView, localcli, (c.e)localObject1);
        RadarViewController.f(this.wdN).dtc();
        AppMethodBeat.o(138751);
        return;
      }
      if (localcli != null)
      {
        paramView = (CharSequence)localcli.ncR;
        if ((paramView == null) || (d.n.n.aD(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localcli.EyO;
          if ((paramView != null) && (!d.n.n.aD(paramView))) {
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
          localObject2 = RadarViewController.d(this.wdN);
          if (localcli == null) {
            break label612;
          }
          paramView = g.wdr;
          localObject1 = g.b(localcli);
          paramView = (View)localObject1;
          if (RadarViewController.c(((RadarViewController.c)localObject2).wdN).wbf.containsKey(localObject1))
          {
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).wdN).wbf.get(localObject1);
            if (paramView == null)
            {
              paramView = new v("null cannot be cast to non-null type kotlin.String");
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
          if (!((RadarViewController.c)localObject2).wdQ.containsKey(paramView)) {
            break label612;
          }
          paramInt = 1;
          if (paramInt != 0) {
            break label617;
          }
          RadarViewController.d(this.wdN).d(localcli);
        }
      }
      for (;;)
      {
        RadarViewController.c(this.wdN).a(localcli);
        RadarViewController.dsZ();
        RadarViewController.d(this.wdN).bzd();
        AppMethodBeat.o(138751);
        return;
        label612:
        paramInt = 0;
        break;
        label617:
        localObject2 = RadarViewController.d(this.wdN);
        if (localcli != null)
        {
          paramView = (CharSequence)localcli.ncR;
          if ((paramView != null) && (!d.n.n.aD(paramView))) {
            break label772;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label782;
          }
          paramView = (CharSequence)localcli.EyO;
          if ((paramView != null) && (!d.n.n.aD(paramView))) {
            break label777;
          }
          paramInt = 1;
          label679:
          if (paramInt == 0) {
            break label782;
          }
        }
        label772:
        label777:
        label782:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label785;
          }
          paramView = g.wdr;
          if (localcli == null) {
            d.g.b.k.fOy();
          }
          localObject1 = g.b(localcli);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).wdN).wbf.containsKey(localObject1)) {
            break label792;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).wdN).wbf.get(localObject1);
          if (paramView != null) {
            break label787;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138751);
          throw paramView;
          paramInt = 0;
          break;
          paramInt = 0;
          break label679;
        }
        label785:
        continue;
        label787:
        paramView = (String)paramView;
        label792:
        ((RadarViewController.c)localObject2).wdQ.remove(paramView);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, cli paramcli, c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.wed.wdN).a(paramView, localcli, this.wee);
        RadarViewController.f(this.wed.wdN).dtc();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<RadarWaveView>
  {
    i(RadarViewController paramRadarViewController)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */