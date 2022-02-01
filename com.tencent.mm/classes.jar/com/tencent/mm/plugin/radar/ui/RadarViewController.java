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
import com.tencent.mm.al.q;
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
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.d;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final RadarViewController.b uUU;
  private boolean sVh;
  private final f uUD;
  private final f uUE;
  private final f uUF;
  private final f uUG;
  private final f uUH;
  private final f uUI;
  private final f uUJ;
  private final f uUK;
  e uUL;
  c uUM;
  c uUN;
  private e.e uUO;
  private final boolean uUP;
  final View.OnClickListener uUQ;
  private final int uUR;
  private final int uUS;
  private final int uUT;
  
  static
  {
    AppMethodBeat.i(138753);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bk(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;")) };
    uUU = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.uUD = d.g.E((d.g.a.a)new i(this));
    this.uUE = i.am(this, 2131303683);
    this.uUF = i.am(this, 2131303698);
    this.uUG = i.am(this, 2131303700);
    this.uUH = i.am(this, 2131303688);
    this.uUI = i.am(this, 2131303689);
    this.uUJ = i.am(this, 2131303692);
    this.uUK = i.am(this, 2131303677);
    this.uUO = e.e.uSH;
    this.uUQ = ((View.OnClickListener)new f(this));
    this.uUR = 33554432;
    this.uUS = (this.uUR + 1);
    this.uUT = (this.uUR + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    d.g.b.k.g(localContext, "mContext.getApplicationContext()");
    this.uUL = new e(paramAttributeSet, localContext);
    this.uUM = new c((c.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(138775);
    this.uUO = parame;
    switch (h.uVn[parame.ordinal()])
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
      getWaveView().dfu();
      getWaveView().setVisibility(0);
      parame = this.uUL;
      if (parame == null) {
        d.g.b.k.aPZ("radarManager");
      }
      parame.dfa();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      dfr();
      getQuitBtn().setText(2131755691);
      parame = this.uUL;
      if (parame == null) {
        d.g.b.k.aPZ("radarManager");
      }
      parame.dfb();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762151);
      getWaveView().dfv();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.uUN;
      if (parame == null) {
        d.g.b.k.aPZ("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.uUL;
      if (parame == null) {
        d.g.b.k.aPZ("radarManager");
      }
      parame.dfb();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131762140);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.uUL;
      if (parame == null) {
        d.g.b.k.aPZ("radarManager");
      }
      parame.dfb();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762141);
    }
  }
  
  private final void aC(LinkedList<cgf> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      d.g.b.k.fvU();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.uUN;
      if (localc == null) {
        d.g.b.k.aPZ("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      ad.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = aD(paramLinkedList);
      ad.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.uUN;
      if (localc == null) {
        d.g.b.k.aPZ("adapter");
      }
      localc.aE(paramLinkedList);
      if ((this.uUP) && (bool)) {
        a(e.e.uSI);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean aD(LinkedList<cgf> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      d.g.b.k.fvU();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (cgf)localIterator.next();
      paramLinkedList = this.uUL;
      if (paramLinkedList == null) {
        d.g.b.k.aPZ("radarManager");
      }
      d.g.b.k.g(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (cgf)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.uUC;
      localObject = g.b((cgf)localObject);
      paramLinkedList = this.uUM.ali((String)localObject);
      e locale = this.uUL;
      if (locale == null) {
        d.g.b.k.aPZ("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.uRT) {
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
    Object localObject = this.uUL;
    if (localObject == null) {
      d.g.b.k.aPZ("radarManager");
    }
    if (paramString == null) {
      d.g.b.k.fvU();
    }
    localObject = ((e)localObject).alj(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.uUL;
      if (localObject == null) {
        d.g.b.k.aPZ("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.uUN;
      if (paramString == null) {
        d.g.b.k.aPZ("adapter");
      }
      paramString.bsd();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void dfr()
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
    TextView localTextView = (TextView)this.uUH.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.uUI.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.uUK.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void W(af paramaf)
  {
    AppMethodBeat.i(138769);
    d.g.b.k.h(paramaf, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramaf.Sx();
      d.g.b.k.g(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.uRT);
    }
    d(paramaf.getUsername(), c.e.uRT);
    d(paramaf.Sx(), c.e.uRT);
    AppMethodBeat.o(138769);
  }
  
  public final void X(af paramaf)
  {
    AppMethodBeat.i(138768);
    d.g.b.k.h(paramaf, "contact");
    Object localObject = this.uUL;
    if (localObject == null) {
      d.g.b.k.aPZ("radarManager");
    }
    String str1 = paramaf.getUsername();
    d.g.b.k.g(str1, "contact.username");
    if (((e)localObject).alj(str1) == null)
    {
      localObject = this.uUL;
      if (localObject == null) {
        d.g.b.k.aPZ("radarManager");
      }
      str1 = paramaf.Sx();
      d.g.b.k.g(str1, "contact.encryptUsername");
      if (((e)localObject).alj(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramaf.getUsername();
        d.g.b.k.g(str1, "contact.username");
        String str2 = paramaf.Sx();
        d.g.b.k.g(str2, "contact.encryptUsername");
        String str3 = paramaf.Su();
        d.g.b.k.g(str3, "contact.nickname");
        cgf localcgf = new cgf();
        localcgf.EbR = 100;
        localcgf.mAQ = str1;
        localcgf.mBV = str3;
        localcgf.SmallImgUrl = "";
        localcgf.DfI = str2;
        ((LinkedList)localObject).add(localcgf);
        aC((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramaf.Sx();
      d.g.b.k.g(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.uRU);
    }
    d(paramaf.getUsername(), c.e.uRU);
    d(paramaf.Sx(), c.e.uRU);
    AppMethodBeat.o(138768);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<cgf> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131761535);
        d.g.b.k.g(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.alk(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131762155);
      d.g.b.k.g(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.alk(str);
      AppMethodBeat.o(138771);
      return;
    }
    aC(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, c.e.uRT);
    }
    for (;;)
    {
      paramString1 = this.uUL;
      if (paramString1 == null) {
        d.g.b.k.aPZ("radarManager");
      }
      paramString1.uSt.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.alk(paramString2);
      paramString1 = this.uUL;
      if (paramString1 == null) {
        d.g.b.k.aPZ("radarManager");
      }
      paramString1 = (e.c)paramString1.uSt.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.uUC;
        d(g.b(paramString1.uSF), paramString1.uSG);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, c.e.uRT);
    }
    for (;;)
    {
      paramString1 = this.uUL;
      if (paramString1 == null) {
        d.g.b.k.aPZ("radarManager");
      }
      paramString1.uSt.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.uRS);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.alk(paramString2);
        paramString1 = this.uUL;
        if (paramString1 == null) {
          d.g.b.k.aPZ("radarManager");
        }
        paramString1 = (e.c)paramString1.uSt.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.uUC;
          d(g.b(paramString1.uSF), paramString1.uSG);
          paramString2 = g.uUC;
          d(g.c(paramString1.uSF), paramString1.uSG);
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<cgc> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(138772);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.uSK);
      c localc = this.uUN;
      if (localc == null) {
        d.g.b.k.aPZ("adapter");
      }
      c(localc.uUY).uSu.clear();
      c(localc.uUY).uSq.clear();
      localc.uVb.clear();
      localc.uVc.clear();
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
            localObject2 = (cgc)localObject2;
            localObject3 = new cgd();
            ((cgd)localObject3).EbQ = ((cgc)localObject2).mAQ;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.uUY).uSq;
            Object localObject4 = ((cgc)localObject2).DfI;
            d.g.b.k.g(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((cgc)localObject2).mAQ;
            d.g.b.k.g(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.uVc;
            localObject4 = g.uUC;
            ((HashMap)localObject3).put(g.a((cgc)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.uVa.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.uVa[paramInt1];
            localObject2 = c(localc.uUY).uSq;
            localObject3 = g.uUC;
            if (!bt.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.uUY).d(paramLinkedList);
              c(localc.uUY).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.uUY).uSp = ((LinkedList)localObject1);
      paramLinkedList = this.uUN;
      if (paramLinkedList == null) {
        d.g.b.k.aPZ("adapter");
      }
      paramLinkedList.bsd();
      AppMethodBeat.o(138772);
      return;
    }
    a(e.e.uSH);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131762155);
    d.g.b.k.g(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.alk((String)localObject1);
    AppMethodBeat.o(138772);
  }
  
  public final void dfa()
  {
    AppMethodBeat.i(138763);
    e locale = this.uUL;
    if (locale == null) {
      d.g.b.k.aPZ("radarManager");
    }
    locale.dfa();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.uUF.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.uUE.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.uUJ.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.uUO;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.uUG.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.uUD.getValue();
    AppMethodBeat.o(138754);
    return localRadarWaveView;
  }
  
  public final void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131762154);
      d.g.b.k.g(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.alk(str);
      if ((!this.sVh) && (!com.tencent.mm.modelgeo.d.axU()))
      {
        this.sVh = true;
        com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(2131760082), getContext().getString(2131755906), getContext().getString(2131760598), getContext().getString(2131755691), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
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
    e locale = this.uUL;
    if (locale == null) {
      d.g.b.k.aPZ("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(138762);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int uUV;
    final boolean uUW;
    private final a uUX;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.uUC;
      this$1 = this$1.getContext();
      d.g.b.k.g(this$1, "context");
      this.uUW = g.fH(this$1);
      this.uUX = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int ef(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.uUY));
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
      int i = ef(paramView);
      if (i > 0) {
        this.uUX.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final int dft()
    {
      this.uUV += 1;
      return this.uUV;
    }
    
    public final Animation getInAnimation()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.uUY.getContext(), 2130772117);
      d.g.b.k.g(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final void i(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      d.g.b.k.h(paramView, "view");
      Message localMessage = this.uUX.obtainMessage();
      localMessage.what = ef(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.uUX.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends ap
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
          if (!this.uUZ.uUW)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.uUZ.uUY));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.uUZ.getInAnimation();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    private final Context context;
    cgf[] uVa;
    HashMap<String, String> uVb;
    HashMap<String, Integer> uVc;
    private final RadarViewController.a uVd;
    private int uVe;
    HashMap<String, View> uVf;
    private boolean uVg;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.uVa = new cgf[12];
      this.uVb = new HashMap();
      this.uVc = new HashMap();
      this.uVf = new HashMap();
      this.uVd = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View al(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, 2131495170, null);
        if (localView == null) {
          d.g.b.k.fvU();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.uVd.dft()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.uVd.getInAnimation());
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
    
    public final void aE(LinkedList<cgf> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).uVa.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (cgf)((Iterator)localObject2).next();
          localObject4 = g.uUC;
          localObject4 = g.c((cgf)localObject3);
          g localg = g.uUC;
          if (d.g.b.k.g(localObject4, g.c(localObject1.uVa[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label280:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cgf)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.uVa.length;
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
          localObject3 = this.uVa[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((cgf)localObject3).mAQ;
            if ((localObject4 != null) && (!d.n.n.aC((CharSequence)localObject4))) {
              break label339;
            }
            j = 1;
            label249:
            if (j == 0) {
              break label351;
            }
            localObject3 = (CharSequence)((cgf)localObject3).DfI;
            if ((localObject3 != null) && (!d.n.n.aC((CharSequence)localObject3))) {
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
            this.uVa[n] = localObject2;
            localObject3 = this.uVc;
            localObject4 = g.uUC;
            d.g.b.k.g(localObject2, "member");
            ((HashMap)localObject3).put(g.b((cgf)localObject2), Integer.valueOf(0));
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
        bsd();
        localObject1 = com.tencent.mm.plugin.radar.b.d.uSl;
        i = paramLinkedList.size();
        if ((com.tencent.mm.plugin.radar.b.d.dpx == 0) && (i > 0))
        {
          float f = (float)(com.tencent.mm.plugin.radar.b.d.deZ() - com.tencent.mm.plugin.radar.b.d.uSh) * 1.0F / 1000.0F;
          ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.h.vKh;
          localObject1 = z.Jhz;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          d.g.b.k.g(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        com.tencent.mm.plugin.radar.b.d.dpx += i;
        com.tencent.mm.plugin.radar.b.d.uSi = i + com.tencent.mm.plugin.radar.b.d.uSi;
      }
      AppMethodBeat.o(138738);
    }
    
    public final View ak(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      ad.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      cgf localcgf = (cgf)this.uVa[paramInt];
      Object localObject1;
      int i;
      label99:
      label105:
      String str;
      Object localObject2;
      if (localcgf != null)
      {
        localObject1 = (CharSequence)localcgf.mAQ;
        if ((localObject1 == null) || (d.n.n.aC((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label238;
          }
          localObject1 = (CharSequence)localcgf.DfI;
          if ((localObject1 != null) && (!d.n.n.aC((CharSequence)localObject1))) {
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
          localObject1 = g.uUC;
          str = g.b(localcgf);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1641;
          }
          localObject1 = View.inflate(this.context, 2131495170, null);
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.uVd.dft()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.uVd.getInAnimation());
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
        if ((localObject2 == e.e.uSH) || (localObject2 == e.e.uSI))
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
            this.uVf.put(str, localObject1);
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
        ((a)localObject4).uVh.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(RadarViewController.this.getContext(), (CharSequence)localcgf.mBV, ((a)localObject4).uVh.getTextSize()));
        localObject2 = b.a.uSY;
        b.a.c(((a)localObject4).uVi, str);
        localObject2 = ((View)localObject1).findViewById(2131303675);
        d.g.b.k.g(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localcgf));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == e.e.uSH) || (RadarViewController.this.getRadarStatus() == e.e.uSI))
        {
          ((a)localObject4).uVl.setBackgroundResource(2131233935);
          paramView = ((a)localObject4).uVj;
          paramView.uTT = true;
          paramView.dfk();
          paramView = ((a)localObject4).uVk;
          paramView.uTO = false;
          paramView.setVisibility(8);
          localObject2 = e.a(RadarViewController.c(RadarViewController.this), localcgf);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).ali(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            d.g.b.k.h(localcgf, "member");
            d.g.b.k.h(paramView, "state");
            localObject3 = localcgf.mAQ;
            d.g.b.k.g(localObject3, "member.UserName");
            ((e)localObject2).b((String)localObject3, paramView);
            localObject3 = localcgf.DfI;
            d.g.b.k.g(localObject3, "member.EncodeUserName");
            ((e)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localcgf, true);
          localObject5 = ((a)localObject4).uVj;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = c.e.uRR;
          }
          d.g.b.k.h(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).uTU.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).uSG = ((c.e)localObject2);
          ((RadarStateView)localObject5).cEL = false;
          ((RadarStateView)localObject5).dfk();
          localObject2 = ((a)localObject4).uVj;
          d.g.b.k.h(paramView, "state");
          ((RadarStateView)localObject2).init();
          ad.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).uSG == paramView)
          {
            ((RadarStateView)localObject2).dfk();
            paramView = RadarViewController.c(RadarViewController.this);
            d.g.b.k.h(localcgf, "member");
            localObject2 = localcgf.mAQ;
            d.g.b.k.g(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localcgf.DfI;
            d.g.b.k.g(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.uVe = this.uVc.size();
            }
            paramView = (View)localObject1;
            if (this.uVc.remove(str) != null)
            {
              this.uVd.i(this.uVe - this.uVc.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).dfm();
              bool = true;
            }
            ad.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).uSG = paramView;
            if (((RadarStateView)localObject2).uSG == c.e.uRR) {
              break;
            }
            if (bool) {
              break label1264;
            }
            ((RadarStateView)localObject2).uTU.sendEmptyMessage(0);
            break;
          }
          label1264:
          ((RadarStateView)localObject2).uTU.sendEmptyMessageDelayed(0, RadarStateView.uTW + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).uSq;
          localObject3 = g.uUC;
          if (!bt.isNullOrNil((String)((Map)localObject2).get(g.c(localcgf))))
          {
            paramView = ((a)localObject4).uVj;
            paramView.uTT = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).uVk;
            paramView.uTO = true;
            paramView.dfk();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localcgf != null)
            {
              localObject2 = g.uUC;
              localObject2 = g.b(localcgf);
              localObject2 = (e.a)paramView.uSu.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = e.a.uSD;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = e.a.uSD;
            }
            if (localObject2 != e.a.uSD) {
              ((a)localObject4).uVl.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).uVk;
            d.g.b.k.h(localObject2, "status");
            if (paramView.uTP != localObject2)
            {
              paramView.uTP = ((e.a)localObject2);
              localObject2 = paramView.uTP;
              switch (e.fPQ[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.uVe = this.uVc.size();
              }
              localObject2 = this.uVc;
              paramView = g.uUC;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.c(localcgf)) == null) {
                break;
              }
              this.uVd.i(this.uVe - this.uVc.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.uTO)
              {
                paramView.dfk();
                paramView.cEL = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.uTO)
                {
                  paramView.dfk();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = al(paramView, paramInt);
          continue;
          label1631:
          paramView = al(paramView, paramInt);
        }
        label1641:
        localObject1 = paramView;
      }
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.uVc.clear();
      this.uVf.clear();
      Iterator localIterator = this.uVf.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.uVf.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.uVd;
          d.g.b.k.g(localObject, "it");
          locala.cv((View)localObject);
        }
      }
      bsd();
      AppMethodBeat.o(138740);
    }
    
    public final void d(cgf paramcgf)
    {
      AppMethodBeat.i(138742);
      if (paramcgf != null)
      {
        localObject = (CharSequence)paramcgf.mAQ;
        if ((localObject != null) && (!d.n.n.aC((CharSequence)localObject))) {
          break label73;
        }
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = (CharSequence)paramcgf.DfI;
        if ((localObject != null) && (!d.n.n.aC((CharSequence)localObject))) {
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
      Object localObject = g.uUC;
      if (paramcgf == null) {
        d.g.b.k.fvU();
      }
      localObject = g.b(paramcgf);
      paramcgf = (cgf)localObject;
      if (RadarViewController.c(RadarViewController.this).uSq.containsKey(localObject))
      {
        paramcgf = RadarViewController.c(RadarViewController.this).uSq.get(localObject);
        if (paramcgf == null)
        {
          paramcgf = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramcgf;
        }
        paramcgf = (String)paramcgf;
      }
      this.uVb.put(paramcgf, paramcgf);
      AppMethodBeat.o(138742);
    }
    
    public final int getCount()
    {
      if (this.uVg) {
        return 0;
      }
      return this.uVa.length;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView uVh;
      ImageView uVi;
      RadarStateView uVj;
      RadarStateChooseView uVk;
      ImageView uVl;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.uVh = paramImageView1;
        this.uVi = paramRadarStateView;
        this.uVj = paramRadarStateChooseView;
        this.uVk = paramImageView2;
        this.uVl = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$TagItem;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "plugin-radar_release"})
  public final class d
  {
    private cgf uSF;
    
    public d()
    {
      AppMethodBeat.i(138744);
      this.uSF = localObject;
      AppMethodBeat.o(138744);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static final class e
    implements RadarMemberView.b
  {
    public final void a(cgf paramcgf, c.e parame)
    {
      AppMethodBeat.i(138746);
      d.g.b.k.h(paramcgf, "member");
      Object localObject1 = g.uUC;
      String str = g.b(paramcgf);
      if (parame == null)
      {
        AppMethodBeat.o(138746);
        return;
      }
      switch (h.ciE[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(138746);
        return;
      case 1: 
        l = RadarViewController.e(this.uUY).alh(str);
        RadarViewController.c(this.uUY).uSt.put(Long.valueOf(l), new e.c(paramcgf, parame));
        RadarViewController.a(this.uUY, str, c.e.uRS);
        AppMethodBeat.o(138746);
        return;
      }
      Object localObject2 = RadarViewController.e(this.uUY);
      d.g.b.k.h(str, "username");
      localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).apM().aHY(str);
      d.g.b.k.g(localObject1, "contact");
      Object localObject3 = (CharSequence)((af)localObject1).getUsername();
      if ((localObject3 == null) || (d.n.n.aC((CharSequence)localObject3)))
      {
        i = 1;
        label213:
        if (i == 0) {
          break label342;
        }
        localObject1 = str;
        label221:
        localObject3 = (String)((c)localObject2).uRI.get(localObject1);
        localObject4 = (CharSequence)localObject3;
        if ((localObject4 != null) && (!d.n.n.aC((CharSequence)localObject4))) {
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
        ad.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
        ((c)localObject2).alh((String)localObject1);
        l = -1L;
        RadarViewController.c(this.uUY).uSt.put(Long.valueOf(l), new e.c(paramcgf, parame));
        RadarViewController.a(this.uUY, str, c.e.uRS);
        break;
        i = 0;
        break label213;
        localObject1 = ((af)localObject1).getUsername();
        d.g.b.k.g(localObject1, "contact.username");
        break label221;
      }
      label364:
      Object localObject4 = bl.d.aIR((String)localObject3);
      long l = System.currentTimeMillis();
      localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
      localObject3 = ((bl.d)localObject4).eMJ();
      d.g.b.k.g(localObject3, "verify.verifyTicket");
      d.g.b.k.h(localObject3, "verifyTicket");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("username is null", bool);
        ((c.a)localObject2).onStart();
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)new o((String)localObject1, (String)localObject3, 48));
        break;
      }
    }
    
    public final void b(cgf paramcgf, c.e parame)
    {
      AppMethodBeat.i(138747);
      if (paramcgf != null) {
        g localg = g.uUC;
      }
      for (paramcgf = g.b(paramcgf);; paramcgf = null)
      {
        paramcgf = (View)((Map)RadarViewController.d(this.uUY).uVf).get(paramcgf);
        if (paramcgf == null) {
          break label96;
        }
        paramcgf = paramcgf.getTag();
        if (paramcgf != null) {
          break;
        }
        paramcgf = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(138747);
        throw paramcgf;
      }
      paramcgf = (RadarViewController.c.a)paramcgf;
      if (parame != c.e.uRR) {
        paramcgf.uVj.dfl();
      }
      label96:
      RadarViewController.f(this.uUY).dfu();
      AppMethodBeat.o(138747);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      if ((this.uUY.getRadarStatus() == e.e.uSH) || (this.uUY.getRadarStatus() == e.e.uSI))
      {
        paramView = this.uUY.getContext();
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
      paramView = this.uUY;
      RadarViewController.c localc = RadarViewController.d(this.uUY);
      LinkedList localLinkedList = new LinkedList();
      int j = localc.uVa.length;
      int i = 0;
      while (i < j)
      {
        cgf localcgf = localc.uVa[i];
        if (localcgf != null) {
          localLinkedList.add(localcgf);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.uUY).dfu();
        RadarViewController.f(this.uUY).setVisibility(0);
        RadarViewController.c(this.uUY).dfa();
        RadarViewController.a(this.uUY, e.e.uSI);
      }
      for (;;)
      {
        RadarViewController.d(this.uUY).bsd();
        AppMethodBeat.o(138748);
        return;
        RadarViewController.a(this.uUY, e.e.uSH);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cv(this.uUY.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      AppMethodBeat.i(138751);
      d.g.b.k.h(paramView, "view");
      final cgf localcgf = (cgf)RadarViewController.d(this.uUY).uVa[paramInt];
      if (localcgf == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.uUY.getRadarStatus();
      Object localObject2;
      switch (h.fPQ[localObject1.ordinal()])
      {
      default: 
        ad.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.uUY.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.uUC;
        localObject1 = g.b(localcgf);
        if (localcgf != null)
        {
          localObject2 = (CharSequence)localcgf.mAQ;
          if ((localObject2 != null) && (!d.n.n.aC((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = j;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localcgf.DfI;
          if ((localObject2 != null) && (!d.n.n.aC((CharSequence)localObject2))) {
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
          localObject2 = (View)RadarViewController.d(this.uUY).uVf.get(localObject1);
          localObject1 = e.a(RadarViewController.c(this.uUY), localcgf);
          if ((localObject2 == null) || (localObject1 == c.e.uRR)) {
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
        ((RadarViewController.c.a)localObject2).uVj.dfm();
        localObject2 = new ap();
        paramView = (Runnable)new a(this, paramView, localcgf, (c.e)localObject1);
        localObject1 = RadarStateView.uTX;
        ((ap)localObject2).postDelayed(paramView, RadarStateView.dfn());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.uUY).a(paramView, localcgf, (c.e)localObject1);
        RadarViewController.f(this.uUY).dfv();
        AppMethodBeat.o(138751);
        return;
      }
      if (localcgf != null)
      {
        paramView = (CharSequence)localcgf.mAQ;
        if ((paramView == null) || (d.n.n.aC(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localcgf.DfI;
          if ((paramView != null) && (!d.n.n.aC(paramView))) {
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
          localObject2 = RadarViewController.d(this.uUY);
          if (localcgf == null) {
            break label612;
          }
          paramView = g.uUC;
          localObject1 = g.b(localcgf);
          paramView = (View)localObject1;
          if (RadarViewController.c(((RadarViewController.c)localObject2).uUY).uSq.containsKey(localObject1))
          {
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).uUY).uSq.get(localObject1);
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
          if (!((RadarViewController.c)localObject2).uVb.containsKey(paramView)) {
            break label612;
          }
          paramInt = 1;
          if (paramInt != 0) {
            break label617;
          }
          RadarViewController.d(this.uUY).d(localcgf);
        }
      }
      for (;;)
      {
        RadarViewController.c(this.uUY).a(localcgf);
        RadarViewController.dfs();
        RadarViewController.d(this.uUY).bsd();
        AppMethodBeat.o(138751);
        return;
        label612:
        paramInt = 0;
        break;
        label617:
        localObject2 = RadarViewController.d(this.uUY);
        if (localcgf != null)
        {
          paramView = (CharSequence)localcgf.mAQ;
          if ((paramView != null) && (!d.n.n.aC(paramView))) {
            break label772;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label782;
          }
          paramView = (CharSequence)localcgf.DfI;
          if ((paramView != null) && (!d.n.n.aC(paramView))) {
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
          paramView = g.uUC;
          if (localcgf == null) {
            d.g.b.k.fvU();
          }
          localObject1 = g.b(localcgf);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).uUY).uSq.containsKey(localObject1)) {
            break label792;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).uUY).uSq.get(localObject1);
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
        ((RadarViewController.c)localObject2).uVb.remove(paramView);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, cgf paramcgf, c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.uVo.uUY).a(paramView, localcgf, this.uVp);
        RadarViewController.f(this.uVo.uUY).dfv();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
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