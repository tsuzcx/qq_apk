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
import com.tencent.mm.hellhoundlib.b.b;
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
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import kotlin.f;
import kotlin.g.b.ae;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  public static final RadarViewController.b BBq;
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  private final f BAZ;
  private final f BBa;
  private final f BBb;
  private final f BBc;
  private final f BBd;
  private final f BBe;
  private final f BBf;
  private final f BBg;
  e BBh;
  c BBi;
  c BBj;
  private e.e BBk;
  private final boolean BBl;
  final View.OnClickListener BBm;
  private final int BBn;
  private final int BBo;
  private final int BBp;
  private boolean uSu;
  
  static
  {
    AppMethodBeat.i(138753);
    BBq = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.BAZ = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.BBa = i.aq(this, 2131306462);
    this.BBb = i.aq(this, 2131306477);
    this.BBc = i.aq(this, 2131306479);
    this.BBd = i.aq(this, 2131306467);
    this.BBe = i.aq(this, 2131306468);
    this.BBf = i.aq(this, 2131306471);
    this.BBg = i.aq(this, 2131306456);
    this.BBk = e.e.Bzd;
    this.BBm = ((View.OnClickListener)new f(this));
    this.BBn = 33554432;
    this.BBo = (this.BBn + 1);
    this.BBp = (this.BBn + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    kotlin.g.b.p.g(localContext, "mContext.getApplicationContext()");
    this.BBh = new e(paramAttributeSet, localContext);
    this.BBi = new c((c.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(138775);
    this.BBk = parame;
    switch (h.uqL[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(2131764170);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().eHD();
      getWaveView().setVisibility(0);
      parame = this.BBh;
      if (parame == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      parame.eHj();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      eHA();
      getQuitBtn().setText(2131755761);
      parame = this.BBh;
      if (parame == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      parame.eHk();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131764172);
      getWaveView().eHE();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.BBj;
      if (parame == null) {
        kotlin.g.b.p.btv("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.BBh;
      if (parame == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      parame.eHk();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131764161);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.BBh;
      if (parame == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      parame.eHk();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131764162);
    }
  }
  
  private final void bi(LinkedList<djb> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      kotlin.g.b.p.hyc();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.BBj;
      if (localc == null) {
        kotlin.g.b.p.btv("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      Log.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = bj(paramLinkedList);
      Log.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.BBj;
      if (localc == null) {
        kotlin.g.b.p.btv("adapter");
      }
      localc.bk(paramLinkedList);
      if ((this.BBl) && (bool)) {
        a(e.e.Bze);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean bj(LinkedList<djb> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      kotlin.g.b.p.hyc();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (djb)localIterator.next();
      paramLinkedList = this.BBh;
      if (paramLinkedList == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      kotlin.g.b.p.g(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (djb)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.BAY;
      localObject = g.b((djb)localObject);
      paramLinkedList = this.BBi.aKN((String)localObject);
      e locale = this.BBh;
      if (locale == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.Byr) {
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
    Object localObject = this.BBh;
    if (localObject == null) {
      kotlin.g.b.p.btv("radarManager");
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    localObject = ((e)localObject).aKO(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.BBh;
      if (localObject == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.BBj;
      if (paramString == null) {
        kotlin.g.b.p.btv("adapter");
      }
      paramString.cax();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void eHA()
  {
    AppMethodBeat.i(138776);
    if (getRadarBgMask().getVisibility() != 0)
    {
      getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), 2130772134));
      getRadarBgMask().setVisibility(0);
    }
    AppMethodBeat.o(138776);
  }
  
  private final TextView getNewRadarTip()
  {
    AppMethodBeat.i(138758);
    TextView localTextView = (TextView)this.BBd.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.BBe.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.BBg.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<djb> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131763501);
        kotlin.g.b.p.g(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.aKP(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131764176);
      kotlin.g.b.p.g(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.aKP(str);
      AppMethodBeat.o(138771);
      return;
    }
    bi(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, c.e.Byr);
    }
    for (;;)
    {
      paramString1 = this.BBh;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      paramString1.ByP.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.aKP(paramString2);
      paramString1 = this.BBh;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      paramString1 = (e.c)paramString1.ByP.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.BAY;
        d(g.b(paramString1.Bzb), paramString1.Bzc);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, c.e.Byr);
    }
    for (;;)
    {
      paramString1 = this.BBh;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      paramString1.ByP.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.Byq);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.aKP(paramString2);
        paramString1 = this.BBh;
        if (paramString1 == null) {
          kotlin.g.b.p.btv("radarManager");
        }
        paramString1 = (e.c)paramString1.ByP.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.BAY;
          d(g.b(paramString1.Bzb), paramString1.Bzc);
          paramString2 = g.BAY;
          d(g.c(paramString1.Bzb), paramString1.Bzc);
        }
      }
    }
  }
  
  public final void ag(as paramas)
  {
    AppMethodBeat.i(138769);
    kotlin.g.b.p.h(paramas, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramas.ajB();
      kotlin.g.b.p.g(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.Byr);
    }
    d(paramas.getUsername(), c.e.Byr);
    d(paramas.ajB(), c.e.Byr);
    AppMethodBeat.o(138769);
  }
  
  public final void ah(as paramas)
  {
    AppMethodBeat.i(138768);
    kotlin.g.b.p.h(paramas, "contact");
    Object localObject = this.BBh;
    if (localObject == null) {
      kotlin.g.b.p.btv("radarManager");
    }
    String str1 = paramas.getUsername();
    kotlin.g.b.p.g(str1, "contact.username");
    if (((e)localObject).aKO(str1) == null)
    {
      localObject = this.BBh;
      if (localObject == null) {
        kotlin.g.b.p.btv("radarManager");
      }
      str1 = paramas.ajB();
      kotlin.g.b.p.g(str1, "contact.encryptUsername");
      if (((e)localObject).aKO(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramas.getUsername();
        kotlin.g.b.p.g(str1, "contact.username");
        String str2 = paramas.ajB();
        kotlin.g.b.p.g(str2, "contact.encryptUsername");
        String str3 = paramas.getNickname();
        kotlin.g.b.p.g(str3, "contact.nickname");
        djb localdjb = new djb();
        localdjb.MNf = 100;
        localdjb.UserName = str1;
        localdjb.oUJ = str3;
        localdjb.SmallImgUrl = "";
        localdjb.LuX = str2;
        ((LinkedList)localObject).add(localdjb);
        bi((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramas.ajB();
      kotlin.g.b.p.g(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.Bys);
    }
    d(paramas.getUsername(), c.e.Bys);
    d(paramas.ajB(), c.e.Bys);
    AppMethodBeat.o(138768);
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<diy> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(138772);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.Bzg);
      c localc = this.BBj;
      if (localc == null) {
        kotlin.g.b.p.btv("adapter");
      }
      c(localc.BBu).ByQ.clear();
      c(localc.BBu).ByM.clear();
      localc.BBx.clear();
      localc.BBy.clear();
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
            kotlin.g.b.p.g(localObject2, "radarChatMember[i]");
            localObject2 = (diy)localObject2;
            localObject3 = new diz();
            ((diz)localObject3).MNe = ((diy)localObject2).UserName;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.BBu).ByM;
            Object localObject4 = ((diy)localObject2).LuX;
            kotlin.g.b.p.g(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((diy)localObject2).UserName;
            kotlin.g.b.p.g(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.BBy;
            localObject4 = g.BAY;
            ((HashMap)localObject3).put(g.a((diy)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.BBw.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.BBw[paramInt1];
            localObject2 = c(localc.BBu).ByM;
            localObject3 = g.BAY;
            if (!Util.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.BBu).d(paramLinkedList);
              c(localc.BBu).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.BBu).ByL = ((LinkedList)localObject1);
      paramLinkedList = this.BBj;
      if (paramLinkedList == null) {
        kotlin.g.b.p.btv("adapter");
      }
      paramLinkedList.cax();
      AppMethodBeat.o(138772);
      return;
    }
    a(e.e.Bzd);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131764176);
    kotlin.g.b.p.g(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.aKP((String)localObject1);
    AppMethodBeat.o(138772);
  }
  
  public final void eHj()
  {
    AppMethodBeat.i(138763);
    e locale = this.BBh;
    if (locale == null) {
      kotlin.g.b.p.btv("radarManager");
    }
    locale.eHj();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.BBb.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.BBa.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.BBf.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.BBk;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.BBc.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.BAZ.getValue();
    AppMethodBeat.o(138754);
    return localRadarWaveView;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138764);
    kotlin.g.b.p.h(paramKeyEvent, "event");
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
    e locale = this.BBh;
    if (locale == null) {
      kotlin.g.b.p.btv("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(138762);
  }
  
  public final void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131764175);
      kotlin.g.b.p.g(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.aKP(str);
      if ((!this.uSu) && (!com.tencent.mm.modelgeo.d.bcc()))
      {
        this.uSu = true;
        com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(2131761461), getContext().getString(2131755998), getContext().getString(2131762043), getContext().getString(2131755761), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int BBr;
    final boolean BBs;
    private final a BBt;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.BAY;
      this$1 = this$1.getContext();
      kotlin.g.b.p.g(this$1, "context");
      this.BBs = g.gM(this$1);
      this.BBt = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int eI(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.BBu));
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
    
    public final void cl(View paramView)
    {
      AppMethodBeat.i(138734);
      kotlin.g.b.p.h(paramView, "view");
      int i = eI(paramView);
      if (i > 0) {
        this.BBt.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final int eHC()
    {
      this.BBr += 1;
      return this.BBr;
    }
    
    public final Animation getInAnimation()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.BBu.getContext(), 2130772141);
      kotlin.g.b.p.g(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final void j(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      kotlin.g.b.p.h(paramView, "view");
      Message localMessage = this.BBt.obtainMessage();
      localMessage.what = eI(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.BBt.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends MMHandler
    {
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(138731);
        kotlin.g.b.p.h(paramMessage, "msg");
        if ((paramMessage.obj instanceof View))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(138731);
            throw paramMessage;
          }
          View localView = (View)paramMessage;
          localView.setVisibility(0);
          localView.clearAnimation();
          if (!this.BBv.BBs)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.BBv.BBu));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.BBv.getInAnimation();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    private int BBA;
    HashMap<String, View> BBB;
    private boolean BBC;
    djb[] BBw;
    HashMap<String, String> BBx;
    HashMap<String, Integer> BBy;
    private final RadarViewController.a BBz;
    private final Context context;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.BBw = new djb[12];
      this.BBx = new HashMap();
      this.BBy = new HashMap();
      this.BBB = new HashMap();
      this.BBz = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View ap(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, 2131496013, null);
        if (localView == null) {
          kotlin.g.b.p.hyc();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.BBz.eHC()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.BBz.getInAnimation());
      }
      paramView = localView.findViewById(2131306472);
      kotlin.g.b.p.g(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131306473);
      kotlin.g.b.p.g(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131306474);
      kotlin.g.b.p.g(paramView, "anotherConvertView.findV…_result_item_username_tv)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131306466);
      kotlin.g.b.p.g(paramView, "anotherConvertView.findV….radar_member_state_view)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131306465);
      kotlin.g.b.p.g(paramView, "anotherConvertView.findV…member_state_choose_view)");
      paramView.setVisibility(4);
      if ((paramInt == 7) || (paramInt % 3 == 1))
      {
        paramView = localView.findViewById(2131297703);
        kotlin.g.b.p.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131309334);
        kotlin.g.b.p.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(138741);
        return localView;
        paramView = localView.findViewById(2131309334);
        kotlin.g.b.p.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131297703);
        kotlin.g.b.p.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(8);
      }
    }
    
    public final View ao(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      Log.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      djb localdjb = (djb)this.BBw[paramInt];
      Object localObject1;
      int i;
      label97:
      label103:
      String str;
      Object localObject2;
      if (localdjb != null)
      {
        localObject1 = (CharSequence)localdjb.UserName;
        if ((localObject1 == null) || (n.aL((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label235;
          }
          localObject1 = (CharSequence)localdjb.LuX;
          if ((localObject1 != null) && (!n.aL((CharSequence)localObject1))) {
            break label230;
          }
          i = 1;
          if (i == 0) {
            break label235;
          }
          i = 1;
          if (i != 0) {
            break label1619;
          }
          localObject1 = g.BAY;
          str = g.b(localdjb);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1629;
          }
          localObject1 = View.inflate(this.context, 2131496013, null);
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.BBz.eHC()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.BBz.getInAnimation());
        }
      }
      for (;;)
      {
        Object localObject3 = ((View)localObject1).findViewById(2131306472);
        if (localObject3 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
          i = 0;
          break;
          label230:
          i = 0;
          break label97;
          label235:
          i = 0;
          break label103;
        }
        localObject3 = (ImageView)localObject3;
        Object localObject4 = ((View)localObject1).findViewById(2131306466);
        if (localObject4 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject4 = (RadarStateView)localObject4;
        Object localObject5 = ((View)localObject1).findViewById(2131306474);
        if (localObject5 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject5 = (TextView)localObject5;
        Object localObject6 = ((View)localObject1).findViewById(2131306473);
        if (localObject6 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject6 = (ImageView)localObject6;
        Object localObject7 = ((View)localObject1).findViewById(2131306465);
        if (localObject7 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject7 = (RadarStateChooseView)localObject7;
        ((ImageView)localObject3).setVisibility(0);
        ((RadarStateView)localObject4).setVisibility(0);
        ((TextView)localObject5).setVisibility(0);
        ((ImageView)localObject6).setVisibility(0);
        if ((localObject2 == e.e.Bzd) || (localObject2 == e.e.Bze))
        {
          ((RadarStateView)localObject4).setVisibility(0);
          ((RadarStateChooseView)localObject7).setVisibility(8);
          ((View)localObject1).setTag(new a((TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
          if ((paramInt != 7) && (paramInt % 3 != 1)) {
            break label605;
          }
          localObject2 = ((View)localObject1).findViewById(2131297703);
          kotlin.g.b.p.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131309334);
          kotlin.g.b.p.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(8);
        }
        for (;;)
        {
          if ((paramView == null) || (localObject1 != paramView)) {
            this.BBB.put(str, localObject1);
          }
          localObject2 = ((View)localObject1).getTag();
          if (localObject2 != null) {
            break label653;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138739);
          throw paramView;
          ((RadarStateView)localObject4).setVisibility(8);
          ((RadarStateChooseView)localObject7).setVisibility(0);
          break;
          label605:
          localObject2 = ((View)localObject1).findViewById(2131309334);
          kotlin.g.b.p.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131297703);
          kotlin.g.b.p.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(8);
        }
        label653:
        localObject4 = (a)localObject2;
        ((a)localObject4).BBD.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(RadarViewController.this.getContext(), (CharSequence)localdjb.oUJ, ((a)localObject4).BBD.getTextSize()));
        localObject2 = b.a.Bzu;
        b.a.c(((a)localObject4).BBE, str);
        localObject2 = ((View)localObject1).findViewById(2131306454);
        kotlin.g.b.p.g(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localdjb));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == e.e.Bzd) || (RadarViewController.this.getRadarStatus() == e.e.Bze))
        {
          ((a)localObject4).BBH.setBackgroundResource(2131234771);
          paramView = ((a)localObject4).BBF;
          paramView.BAp = true;
          paramView.eHt();
          paramView = ((a)localObject4).BBG;
          paramView.BAk = false;
          paramView.setVisibility(8);
          localObject2 = e.a(RadarViewController.c(RadarViewController.this), localdjb);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).aKN(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            kotlin.g.b.p.h(localdjb, "member");
            kotlin.g.b.p.h(paramView, "state");
            localObject3 = localdjb.UserName;
            kotlin.g.b.p.g(localObject3, "member.UserName");
            ((e)localObject2).b((String)localObject3, paramView);
            localObject3 = localdjb.LuX;
            kotlin.g.b.p.g(localObject3, "member.EncodeUserName");
            ((e)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localdjb, true);
          localObject5 = ((a)localObject4).BBF;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = c.e.Byp;
          }
          kotlin.g.b.p.h(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).BAq.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).Bzc = ((c.e)localObject2);
          ((RadarStateView)localObject5).ddZ = false;
          ((RadarStateView)localObject5).eHt();
          localObject2 = ((a)localObject4).BBF;
          kotlin.g.b.p.h(paramView, "state");
          ((RadarStateView)localObject2).init();
          Log.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).Bzc == paramView)
          {
            ((RadarStateView)localObject2).eHt();
            paramView = RadarViewController.c(RadarViewController.this);
            kotlin.g.b.p.h(localdjb, "member");
            localObject2 = localdjb.UserName;
            kotlin.g.b.p.g(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localdjb.LuX;
            kotlin.g.b.p.g(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.BBA = this.BBy.size();
            }
            paramView = (View)localObject1;
            if (this.BBy.remove(str) != null)
            {
              this.BBz.j(this.BBA - this.BBy.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).eHv();
              bool = true;
            }
            Log.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).Bzc = paramView;
            if (((RadarStateView)localObject2).Bzc == c.e.Byp) {
              break;
            }
            if (bool) {
              break label1255;
            }
            ((RadarStateView)localObject2).BAq.sendEmptyMessage(0);
            break;
          }
          label1255:
          ((RadarStateView)localObject2).BAq.sendEmptyMessageDelayed(0, RadarStateView.BAs + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).ByM;
          localObject3 = g.BAY;
          if (!Util.isNullOrNil((String)((Map)localObject2).get(g.c(localdjb))))
          {
            paramView = ((a)localObject4).BBF;
            paramView.BAp = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).BBG;
            paramView.BAk = true;
            paramView.eHt();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localdjb != null)
            {
              localObject2 = g.BAY;
              localObject2 = g.b(localdjb);
              localObject2 = (e.a)paramView.ByQ.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = e.a.ByZ;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = e.a.ByZ;
            }
            if (localObject2 != e.a.ByZ) {
              ((a)localObject4).BBH.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).BBG;
            kotlin.g.b.p.h(localObject2, "status");
            if (paramView.BAl != localObject2)
            {
              paramView.BAl = ((e.a)localObject2);
              localObject2 = paramView.BAl;
              switch (e.haE[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.BBA = this.BBy.size();
              }
              localObject2 = this.BBy;
              paramView = g.BAY;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.c(localdjb)) == null) {
                break;
              }
              this.BBz.j(this.BBA - this.BBy.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.BAk)
              {
                paramView.eHt();
                paramView.ddZ = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.BAk)
                {
                  paramView.eHt();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = ap(paramView, paramInt);
          continue;
          label1619:
          paramView = ap(paramView, paramInt);
        }
        label1629:
        localObject1 = paramView;
      }
    }
    
    public final void bk(LinkedList<djb> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).BBw.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (djb)((Iterator)localObject2).next();
          localObject4 = g.BAY;
          localObject4 = g.c((djb)localObject3);
          g localg = g.BAY;
          if (kotlin.g.b.p.j(localObject4, g.c(localObject1.BBw[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label282:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (djb)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.BBw.length;
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
          localObject3 = this.BBw[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((djb)localObject3).UserName;
            if ((localObject4 != null) && (!n.aL((CharSequence)localObject4))) {
              break label341;
            }
            j = 1;
            label251:
            if (j == 0) {
              break label353;
            }
            localObject3 = (CharSequence)((djb)localObject3).LuX;
            if ((localObject3 != null) && (!n.aL((CharSequence)localObject3))) {
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
            this.BBw[n] = localObject2;
            localObject3 = this.BBy;
            localObject4 = g.BAY;
            kotlin.g.b.p.g(localObject2, "member");
            ((HashMap)localObject3).put(g.b((djb)localObject2), Integer.valueOf(0));
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
        cax();
        localObject1 = com.tencent.mm.plugin.radar.b.d.ByH;
        i = paramLinkedList.size();
        if ((com.tencent.mm.plugin.radar.b.d.dRN == 0) && (i > 0))
        {
          float f = (float)(com.tencent.mm.plugin.radar.b.d.eHi() - com.tencent.mm.plugin.radar.b.d.ByD) * 1.0F / 1000.0F;
          Log.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.h.CyF;
          localObject1 = ae.SYK;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          kotlin.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        com.tencent.mm.plugin.radar.b.d.dRN += i;
        com.tencent.mm.plugin.radar.b.d.ByE = i + com.tencent.mm.plugin.radar.b.d.ByE;
      }
      AppMethodBeat.o(138738);
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.BBy.clear();
      this.BBB.clear();
      Iterator localIterator = this.BBB.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.BBB.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.BBz;
          kotlin.g.b.p.g(localObject, "it");
          locala.cl((View)localObject);
        }
      }
      cax();
      AppMethodBeat.o(138740);
    }
    
    public final void d(djb paramdjb)
    {
      AppMethodBeat.i(138742);
      if (paramdjb != null)
      {
        localObject = (CharSequence)paramdjb.UserName;
        if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
          break label73;
        }
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = (CharSequence)paramdjb.LuX;
        if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
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
      Object localObject = g.BAY;
      if (paramdjb == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = g.b(paramdjb);
      paramdjb = (djb)localObject;
      if (RadarViewController.c(RadarViewController.this).ByM.containsKey(localObject))
      {
        paramdjb = RadarViewController.c(RadarViewController.this).ByM.get(localObject);
        if (paramdjb == null)
        {
          paramdjb = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramdjb;
        }
        paramdjb = (String)paramdjb;
      }
      this.BBx.put(paramdjb, paramdjb);
      AppMethodBeat.o(138742);
    }
    
    public final int getCount()
    {
      if (this.BBC) {
        return 0;
      }
      return this.BBw.length;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView BBD;
      ImageView BBE;
      RadarStateView BBF;
      RadarStateChooseView BBG;
      ImageView BBH;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.BBD = paramImageView1;
        this.BBE = paramRadarStateView;
        this.BBF = paramRadarStateChooseView;
        this.BBG = paramImageView2;
        this.BBH = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$TagItem;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "plugin-radar_release"})
  public final class d
  {
    private djb Bzb;
    
    public d()
    {
      AppMethodBeat.i(138744);
      this.Bzb = localObject;
      AppMethodBeat.o(138744);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static final class e
    implements RadarMemberView.b
  {
    public final void a(djb paramdjb, c.e parame)
    {
      AppMethodBeat.i(138746);
      kotlin.g.b.p.h(paramdjb, "member");
      Object localObject1 = g.BAY;
      String str = g.b(paramdjb);
      if (parame == null)
      {
        AppMethodBeat.o(138746);
        return;
      }
      switch (h.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(138746);
        return;
      case 1: 
        l = RadarViewController.e(this.BBu).aKM(str);
        RadarViewController.c(this.BBu).ByP.put(Long.valueOf(l), new e.c(paramdjb, parame));
        RadarViewController.a(this.BBu, str, c.e.Byq);
        AppMethodBeat.o(138746);
        return;
      }
      Object localObject2 = RadarViewController.e(this.BBu);
      kotlin.g.b.p.h(str, "username");
      localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      kotlin.g.b.p.g(localObject1, "service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(str);
      kotlin.g.b.p.g(localObject1, "contact");
      Object localObject3 = (CharSequence)((as)localObject1).getUsername();
      if ((localObject3 == null) || (n.aL((CharSequence)localObject3)))
      {
        i = 1;
        label213:
        if (i == 0) {
          break label342;
        }
        localObject1 = str;
        label221:
        localObject3 = (String)((c)localObject2).Byg.get(localObject1);
        localObject4 = (CharSequence)localObject3;
        if ((localObject4 != null) && (!n.aL((CharSequence)localObject4))) {
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
        Log.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
        ((c)localObject2).aKM((String)localObject1);
        l = -1L;
        RadarViewController.c(this.BBu).ByP.put(Long.valueOf(l), new e.c(paramdjb, parame));
        RadarViewController.a(this.BBu, str, c.e.Byq);
        break;
        i = 0;
        break label213;
        localObject1 = ((as)localObject1).getUsername();
        kotlin.g.b.p.g(localObject1, "contact.username");
        break label221;
      }
      label364:
      Object localObject4 = ca.d.bkD((String)localObject3);
      long l = System.currentTimeMillis();
      localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
      localObject3 = ((ca.d)localObject4).gEc();
      kotlin.g.b.p.g(localObject3, "verify.verifyTicket");
      kotlin.g.b.p.h(localObject3, "verifyTicket");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("username is null", bool);
        ((c.a)localObject2).onStart();
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.pluginsdk.model.p((String)localObject1, (String)localObject3, 48));
        break;
      }
    }
    
    public final void b(djb paramdjb, c.e parame)
    {
      AppMethodBeat.i(138747);
      if (paramdjb != null) {
        g localg = g.BAY;
      }
      for (paramdjb = g.b(paramdjb);; paramdjb = null)
      {
        paramdjb = (View)((Map)RadarViewController.d(this.BBu).BBB).get(paramdjb);
        if (paramdjb == null) {
          break label96;
        }
        paramdjb = paramdjb.getTag();
        if (paramdjb != null) {
          break;
        }
        paramdjb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(138747);
        throw paramdjb;
      }
      paramdjb = (RadarViewController.c.a)paramdjb;
      if (parame != c.e.Byp) {
        paramdjb.BBF.eHu();
      }
      label96:
      RadarViewController.f(this.BBu).eHD();
      AppMethodBeat.o(138747);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if ((this.BBu.getRadarStatus() == e.e.Bzd) || (this.BBu.getRadarStatus() == e.e.Bze))
      {
        paramView = this.BBu.getContext();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138748);
          throw paramView;
        }
        ((Activity)paramView).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138748);
        return;
      }
      paramView = this.BBu;
      localObject = RadarViewController.d(this.BBu);
      LinkedList localLinkedList = new LinkedList();
      int j = ((RadarViewController.c)localObject).BBw.length;
      int i = 0;
      while (i < j)
      {
        djb localdjb = localObject.BBw[i];
        if (localdjb != null) {
          localLinkedList.add(localdjb);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.BBu).eHD();
        RadarViewController.f(this.BBu).setVisibility(0);
        RadarViewController.c(this.BBu).eHj();
        RadarViewController.a(this.BBu, e.e.Bze);
      }
      for (;;)
      {
        RadarViewController.d(this.BBu).cax();
        break;
        RadarViewController.a(this.BBu, e.e.Bzd);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cZ(this.BBu.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      AppMethodBeat.i(138751);
      kotlin.g.b.p.h(paramView, "view");
      final djb localdjb = (djb)RadarViewController.d(this.BBu).BBw[paramInt];
      if (localdjb == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.BBu.getRadarStatus();
      Object localObject2;
      switch (h.haE[localObject1.ordinal()])
      {
      default: 
        Log.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.BBu.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.BAY;
        localObject1 = g.b(localdjb);
        if (localdjb != null)
        {
          localObject2 = (CharSequence)localdjb.UserName;
          if ((localObject2 != null) && (!n.aL((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = j;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localdjb.LuX;
          if ((localObject2 != null) && (!n.aL((CharSequence)localObject2))) {
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
          localObject2 = (View)RadarViewController.d(this.BBu).BBB.get(localObject1);
          localObject1 = e.a(RadarViewController.c(this.BBu), localdjb);
          if ((localObject2 == null) || (localObject1 == c.e.Byp)) {
            break label348;
          }
          localObject2 = ((View)localObject2).getTag();
          if (localObject2 != null) {
            break label289;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138751);
          throw paramView;
          i = 0;
          break label158;
        }
        label289:
        ((RadarViewController.c.a)localObject2).BBF.eHv();
        localObject2 = new MMHandler();
        paramView = (Runnable)new a(this, paramView, localdjb, (c.e)localObject1);
        localObject1 = RadarStateView.BAt;
        ((MMHandler)localObject2).postDelayed(paramView, RadarStateView.eHw());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.BBu).a(paramView, localdjb, (c.e)localObject1);
        RadarViewController.f(this.BBu).eHE();
        AppMethodBeat.o(138751);
        return;
      }
      if (localdjb != null)
      {
        paramView = (CharSequence)localdjb.UserName;
        if ((paramView == null) || (n.aL(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localdjb.LuX;
          if ((paramView != null) && (!n.aL(paramView))) {
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
          localObject2 = RadarViewController.d(this.BBu);
          if (localdjb == null) {
            break label612;
          }
          paramView = g.BAY;
          localObject1 = g.b(localdjb);
          paramView = (View)localObject1;
          if (RadarViewController.c(((RadarViewController.c)localObject2).BBu).ByM.containsKey(localObject1))
          {
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).BBu).ByM.get(localObject1);
            if (paramView == null)
            {
              paramView = new kotlin.t("null cannot be cast to non-null type kotlin.String");
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
          if (!((RadarViewController.c)localObject2).BBx.containsKey(paramView)) {
            break label612;
          }
          paramInt = 1;
          if (paramInt != 0) {
            break label617;
          }
          RadarViewController.d(this.BBu).d(localdjb);
        }
      }
      for (;;)
      {
        RadarViewController.c(this.BBu).a(localdjb);
        RadarViewController.eHB();
        RadarViewController.d(this.BBu).cax();
        AppMethodBeat.o(138751);
        return;
        label612:
        paramInt = 0;
        break;
        label617:
        localObject2 = RadarViewController.d(this.BBu);
        if (localdjb != null)
        {
          paramView = (CharSequence)localdjb.UserName;
          if ((paramView != null) && (!n.aL(paramView))) {
            break label772;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label782;
          }
          paramView = (CharSequence)localdjb.LuX;
          if ((paramView != null) && (!n.aL(paramView))) {
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
          paramView = g.BAY;
          if (localdjb == null) {
            kotlin.g.b.p.hyc();
          }
          localObject1 = g.b(localdjb);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).BBu).ByM.containsKey(localObject1)) {
            break label792;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).BBu).ByM.get(localObject1);
          if (paramView != null) {
            break label787;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type kotlin.String");
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
        ((RadarViewController.c)localObject2).BBx.remove(paramView);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, djb paramdjb, c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.BBJ.BBu).a(paramView, localdjb, this.BBK);
        RadarViewController.f(this.BBJ.BBu).eHE();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RadarWaveView>
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