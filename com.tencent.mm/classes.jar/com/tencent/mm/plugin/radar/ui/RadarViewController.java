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
import com.tencent.mm.plugin.radar.b.c.c;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.a;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.plugin.radar.b.e.d;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final RadarViewController.b xls;
  private boolean vgd;
  private final f xlb;
  private final f xlc;
  private final f xld;
  private final f xle;
  private final f xlf;
  private final f xlg;
  private final f xlh;
  private final f xli;
  e xlj;
  c xlk;
  c xll;
  private e.e xlm;
  private final boolean xln;
  final View.OnClickListener xlo;
  private final int xlp;
  private final int xlq;
  private final int xlr;
  
  static
  {
    AppMethodBeat.i(138753);
    xls = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.xlb = d.g.O((d.g.a.a)new i(this));
    this.xlc = i.ao(this, 2131303683);
    this.xld = i.ao(this, 2131303698);
    this.xle = i.ao(this, 2131303700);
    this.xlf = i.ao(this, 2131303688);
    this.xlg = i.ao(this, 2131303689);
    this.xlh = i.ao(this, 2131303692);
    this.xli = i.ao(this, 2131303677);
    this.xlm = e.e.xjf;
    this.xlo = ((View.OnClickListener)new f(this));
    this.xlp = 33554432;
    this.xlq = (this.xlp + 1);
    this.xlr = (this.xlp + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    p.g(localContext, "mContext.getApplicationContext()");
    this.xlj = new e(paramAttributeSet, localContext);
    this.xlk = new c((c.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(138775);
    this.xlm = parame;
    switch (h.xlL[parame.ordinal()])
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
      getWaveView().dDy();
      getWaveView().setVisibility(0);
      parame = this.xlj;
      if (parame == null) {
        p.bcb("radarManager");
      }
      parame.dDe();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      dDv();
      getQuitBtn().setText(2131755691);
      parame = this.xlj;
      if (parame == null) {
        p.bcb("radarManager");
      }
      parame.dDf();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762151);
      getWaveView().dDz();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.xll;
      if (parame == null) {
        p.bcb("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.xlj;
      if (parame == null) {
        p.bcb("radarManager");
      }
      parame.dDf();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131762140);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.xlj;
      if (parame == null) {
        p.bcb("radarManager");
      }
      parame.dDf();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762141);
    }
  }
  
  private final void aK(LinkedList<cqi> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      p.gfZ();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.xll;
      if (localc == null) {
        p.bcb("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = aL(paramLinkedList);
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.xll;
      if (localc == null) {
        p.bcb("adapter");
      }
      localc.aM(paramLinkedList);
      if ((this.xln) && (bool)) {
        a(e.e.xjg);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean aL(LinkedList<cqi> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      p.gfZ();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (cqi)localIterator.next();
      paramLinkedList = this.xlj;
      if (paramLinkedList == null) {
        p.bcb("radarManager");
      }
      p.g(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (cqi)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.xla;
      localObject = g.b((cqi)localObject);
      paramLinkedList = this.xlk.avg((String)localObject);
      e locale = this.xlj;
      if (locale == null) {
        p.bcb("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.xis) {
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
    Object localObject = this.xlj;
    if (localObject == null) {
      p.bcb("radarManager");
    }
    if (paramString == null) {
      p.gfZ();
    }
    localObject = ((e)localObject).avh(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.xlj;
      if (localObject == null) {
        p.bcb("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.xll;
      if (paramString == null) {
        p.bcb("adapter");
      }
      paramString.bDh();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void dDv()
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
    TextView localTextView = (TextView)this.xlf.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.xlg.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.xli.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void X(am paramam)
  {
    AppMethodBeat.i(138769);
    p.h(paramam, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramam.VF();
      p.g(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.xis);
    }
    d(paramam.getUsername(), c.e.xis);
    d(paramam.VF(), c.e.xis);
    AppMethodBeat.o(138769);
  }
  
  public final void Y(am paramam)
  {
    AppMethodBeat.i(138768);
    p.h(paramam, "contact");
    Object localObject = this.xlj;
    if (localObject == null) {
      p.bcb("radarManager");
    }
    String str1 = paramam.getUsername();
    p.g(str1, "contact.username");
    if (((e)localObject).avh(str1) == null)
    {
      localObject = this.xlj;
      if (localObject == null) {
        p.bcb("radarManager");
      }
      str1 = paramam.VF();
      p.g(str1, "contact.encryptUsername");
      if (((e)localObject).avh(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paramam.getUsername();
        p.g(str1, "contact.username");
        String str2 = paramam.VF();
        p.g(str2, "contact.encryptUsername");
        String str3 = paramam.VC();
        p.g(str3, "contact.nickname");
        cqi localcqi = new cqi();
        localcqi.HiR = 100;
        localcqi.nDo = str1;
        localcqi.nEt = str3;
        localcqi.SmallImgUrl = "";
        localcqi.GgA = str2;
        ((LinkedList)localObject).add(localcqi);
        aK((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paramam.VF();
      p.g(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.xit);
    }
    d(paramam.getUsername(), c.e.xit);
    d(paramam.VF(), c.e.xit);
    AppMethodBeat.o(138768);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<cqi> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131761535);
        p.g(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.avi(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131762155);
      p.g(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.avi(str);
      AppMethodBeat.o(138771);
      return;
    }
    aK(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, c.e.xis);
    }
    for (;;)
    {
      paramString1 = this.xlj;
      if (paramString1 == null) {
        p.bcb("radarManager");
      }
      paramString1.xiR.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.avi(paramString2);
      paramString1 = this.xlj;
      if (paramString1 == null) {
        p.bcb("radarManager");
      }
      paramString1 = (e.c)paramString1.xiR.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.xla;
        d(g.b(paramString1.xjd), paramString1.xje);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, c.e.xis);
    }
    for (;;)
    {
      paramString1 = this.xlj;
      if (paramString1 == null) {
        p.bcb("radarManager");
      }
      paramString1.xiR.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.xir);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.avi(paramString2);
        paramString1 = this.xlj;
        if (paramString1 == null) {
          p.bcb("radarManager");
        }
        paramString1 = (e.c)paramString1.xiR.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.xla;
          d(g.b(paramString1.xjd), paramString1.xje);
          paramString2 = g.xla;
          d(g.c(paramString1.xjd), paramString1.xje);
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<cqf> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(138772);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.xji);
      c localc = this.xll;
      if (localc == null) {
        p.bcb("adapter");
      }
      c(localc.xlw).xiS.clear();
      c(localc.xlw).xiO.clear();
      localc.xlz.clear();
      localc.xlA.clear();
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
            p.g(localObject2, "radarChatMember[i]");
            localObject2 = (cqf)localObject2;
            localObject3 = new cqg();
            ((cqg)localObject3).HiQ = ((cqf)localObject2).nDo;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.xlw).xiO;
            Object localObject4 = ((cqf)localObject2).GgA;
            p.g(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((cqf)localObject2).nDo;
            p.g(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.xlA;
            localObject4 = g.xla;
            ((HashMap)localObject3).put(g.a((cqf)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.xly.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.xly[paramInt1];
            localObject2 = c(localc.xlw).xiO;
            localObject3 = g.xla;
            if (!bt.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.xlw).d(paramLinkedList);
              c(localc.xlw).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.xlw).xiN = ((LinkedList)localObject1);
      paramLinkedList = this.xll;
      if (paramLinkedList == null) {
        p.bcb("adapter");
      }
      paramLinkedList.bDh();
      AppMethodBeat.o(138772);
      return;
    }
    a(e.e.xjf);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131762155);
    p.g(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.avi((String)localObject1);
    AppMethodBeat.o(138772);
  }
  
  public final void dDe()
  {
    AppMethodBeat.i(138763);
    e locale = this.xlj;
    if (locale == null) {
      p.bcb("radarManager");
    }
    locale.dDe();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.xld.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.xlc.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.xlh.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.xlm;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.xle.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.xlb.getValue();
    AppMethodBeat.o(138754);
    return localRadarWaveView;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138764);
    p.h(paramKeyEvent, "event");
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
    e locale = this.xlj;
    if (locale == null) {
      p.bcb("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(138762);
  }
  
  public final void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131762154);
      p.g(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.avi(str);
      if ((!this.vgd) && (!com.tencent.mm.modelgeo.d.aHR()))
      {
        this.vgd = true;
        h.a(getContext(), getContext().getString(2131760082), getContext().getString(2131755906), getContext().getString(2131760598), getContext().getString(2131755691), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int xlt;
    final boolean xlu;
    private final a xlv;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.xla;
      this$1 = this$1.getContext();
      p.g(this$1, "context");
      this.xlu = g.fX(this$1);
      this.xlv = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int eA(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.xlw));
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
      p.h(paramView, "view");
      int i = eA(paramView);
      if (i > 0) {
        this.xlv.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final int dDx()
    {
      this.xlt += 1;
      return this.xlt;
    }
    
    public final Animation getInAnimation()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.xlw.getContext(), 2130772117);
      p.g(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final void i(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      p.h(paramView, "view");
      Message localMessage = this.xlv.obtainMessage();
      localMessage.what = eA(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.xlv.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends ap
    {
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(138731);
        p.h(paramMessage, "msg");
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
          if (!this.xlx.xlu)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.xlx.xlw));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.xlx.getInAnimation();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    private final Context context;
    HashMap<String, Integer> xlA;
    private final RadarViewController.a xlB;
    private int xlC;
    HashMap<String, View> xlD;
    private boolean xlE;
    cqi[] xly;
    HashMap<String, String> xlz;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.xly = new cqi[12];
      this.xlz = new HashMap();
      this.xlA = new HashMap();
      this.xlD = new HashMap();
      this.xlB = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View an(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, 2131495170, null);
        if (localView == null) {
          p.gfZ();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.xlB.dDx()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.xlB.getInAnimation());
      }
      paramView = localView.findViewById(2131303693);
      p.g(paramView, "anotherConvertView.findV…ar_result_item_avatar_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131303694);
      p.g(paramView, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
      paramView.setVisibility(8);
      paramView = localView.findViewById(2131303695);
      p.g(paramView, "anotherConvertView.findV…_result_item_username_tv)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131303687);
      p.g(paramView, "anotherConvertView.findV….radar_member_state_view)");
      paramView.setVisibility(4);
      paramView = localView.findViewById(2131303686);
      p.g(paramView, "anotherConvertView.findV…member_state_choose_view)");
      paramView.setVisibility(4);
      if ((paramInt == 7) || (paramInt % 3 == 1))
      {
        paramView = localView.findViewById(2131297468);
        p.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131306022);
        p.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(138741);
        return localView;
        paramView = localView.findViewById(2131306022);
        p.g(paramView, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
        paramView.setVisibility(0);
        paramView = localView.findViewById(2131297468);
        p.g(paramView, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
        paramView.setVisibility(8);
      }
    }
    
    public final void aM(LinkedList<cqi> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).xly.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (cqi)((Iterator)localObject2).next();
          localObject4 = g.xla;
          localObject4 = g.c((cqi)localObject3);
          g localg = g.xla;
          if (p.i(localObject4, g.c(localObject1.xly[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label280:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cqi)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.xly.length;
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
          localObject3 = this.xly[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((cqi)localObject3).nDo;
            if ((localObject4 != null) && (!n.aE((CharSequence)localObject4))) {
              break label339;
            }
            j = 1;
            label249:
            if (j == 0) {
              break label351;
            }
            localObject3 = (CharSequence)((cqi)localObject3).GgA;
            if ((localObject3 != null) && (!n.aE((CharSequence)localObject3))) {
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
            this.xly[n] = localObject2;
            localObject3 = this.xlA;
            localObject4 = g.xla;
            p.g(localObject2, "member");
            ((HashMap)localObject3).put(g.b((cqi)localObject2), Integer.valueOf(0));
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
        bDh();
        localObject1 = com.tencent.mm.plugin.radar.b.d.xiJ;
        i = paramLinkedList.size();
        if ((com.tencent.mm.plugin.radar.b.d.dyW == 0) && (i > 0))
        {
          float f = (float)(com.tencent.mm.plugin.radar.b.d.dDd() - com.tencent.mm.plugin.radar.b.d.xiF) * 1.0F / 1000.0F;
          com.tencent.mm.sdk.platformtools.ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.g.yhR;
          localObject1 = d.g.b.ad.MLZ;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          p.g(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        com.tencent.mm.plugin.radar.b.d.dyW += i;
        com.tencent.mm.plugin.radar.b.d.xiG = i + com.tencent.mm.plugin.radar.b.d.xiG;
      }
      AppMethodBeat.o(138738);
    }
    
    public final View am(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      com.tencent.mm.sdk.platformtools.ad.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      cqi localcqi = (cqi)this.xly[paramInt];
      Object localObject1;
      int i;
      label99:
      label105:
      String str;
      Object localObject2;
      if (localcqi != null)
      {
        localObject1 = (CharSequence)localcqi.nDo;
        if ((localObject1 == null) || (n.aE((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label238;
          }
          localObject1 = (CharSequence)localcqi.GgA;
          if ((localObject1 != null) && (!n.aE((CharSequence)localObject1))) {
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
          localObject1 = g.xla;
          str = g.b(localcqi);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1641;
          }
          localObject1 = View.inflate(this.context, 2131495170, null);
          if (localObject1 == null) {
            p.gfZ();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.xlB.dDx()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.xlB.getInAnimation());
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
        if ((localObject2 == e.e.xjf) || (localObject2 == e.e.xjg))
        {
          ((RadarStateView)localObject4).setVisibility(0);
          ((RadarStateChooseView)localObject7).setVisibility(8);
          ((View)localObject1).setTag(new a((TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
          if ((paramInt != 7) && (paramInt % 3 != 1)) {
            break label613;
          }
          localObject2 = ((View)localObject1).findViewById(2131297468);
          p.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131306022);
          p.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(8);
        }
        for (;;)
        {
          if ((paramView == null) || (localObject1 != paramView)) {
            this.xlD.put(str, localObject1);
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
          p.g(localObject2, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
          ((View)localObject2).setVisibility(0);
          localObject2 = ((View)localObject1).findViewById(2131297468);
          p.g(localObject2, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
          ((View)localObject2).setVisibility(8);
        }
        label661:
        localObject4 = (a)localObject2;
        ((a)localObject4).xlF.setText((CharSequence)k.b(RadarViewController.this.getContext(), (CharSequence)localcqi.nEt, ((a)localObject4).xlF.getTextSize()));
        localObject2 = b.a.xjw;
        b.a.c(((a)localObject4).xlG, str);
        localObject2 = ((View)localObject1).findViewById(2131303675);
        p.g(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localcqi));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == e.e.xjf) || (RadarViewController.this.getRadarStatus() == e.e.xjg))
        {
          ((a)localObject4).xlJ.setBackgroundResource(2131233935);
          paramView = ((a)localObject4).xlH;
          paramView.xkr = true;
          paramView.dDo();
          paramView = ((a)localObject4).xlI;
          paramView.xkm = false;
          paramView.setVisibility(8);
          localObject2 = e.a(RadarViewController.c(RadarViewController.this), localcqi);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).avg(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            p.h(localcqi, "member");
            p.h(paramView, "state");
            localObject3 = localcqi.nDo;
            p.g(localObject3, "member.UserName");
            ((e)localObject2).b((String)localObject3, paramView);
            localObject3 = localcqi.GgA;
            p.g(localObject3, "member.EncodeUserName");
            ((e)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localcqi, true);
          localObject5 = ((a)localObject4).xlH;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = c.e.xiq;
          }
          p.h(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).xks.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).xje = ((c.e)localObject2);
          ((RadarStateView)localObject5).cMS = false;
          ((RadarStateView)localObject5).dDo();
          localObject2 = ((a)localObject4).xlH;
          p.h(paramView, "state");
          ((RadarStateView)localObject2).init();
          com.tencent.mm.sdk.platformtools.ad.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).xje == paramView)
          {
            ((RadarStateView)localObject2).dDo();
            paramView = RadarViewController.c(RadarViewController.this);
            p.h(localcqi, "member");
            localObject2 = localcqi.nDo;
            p.g(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localcqi.GgA;
            p.g(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.xlC = this.xlA.size();
            }
            paramView = (View)localObject1;
            if (this.xlA.remove(str) != null)
            {
              this.xlB.i(this.xlC - this.xlA.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).dDq();
              bool = true;
            }
            com.tencent.mm.sdk.platformtools.ad.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).xje = paramView;
            if (((RadarStateView)localObject2).xje == c.e.xiq) {
              break;
            }
            if (bool) {
              break label1264;
            }
            ((RadarStateView)localObject2).xks.sendEmptyMessage(0);
            break;
          }
          label1264:
          ((RadarStateView)localObject2).xks.sendEmptyMessageDelayed(0, RadarStateView.xku + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).xiO;
          localObject3 = g.xla;
          if (!bt.isNullOrNil((String)((Map)localObject2).get(g.c(localcqi))))
          {
            paramView = ((a)localObject4).xlH;
            paramView.xkr = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).xlI;
            paramView.xkm = true;
            paramView.dDo();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localcqi != null)
            {
              localObject2 = g.xla;
              localObject2 = g.b(localcqi);
              localObject2 = (e.a)paramView.xiS.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = e.a.xjb;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = e.a.xjb;
            }
            if (localObject2 != e.a.xjb) {
              ((a)localObject4).xlJ.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).xlI;
            p.h(localObject2, "status");
            if (paramView.xkn != localObject2)
            {
              paramView.xkn = ((e.a)localObject2);
              localObject2 = paramView.xkn;
              switch (e.gnp[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.xlC = this.xlA.size();
              }
              localObject2 = this.xlA;
              paramView = g.xla;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.c(localcqi)) == null) {
                break;
              }
              this.xlB.i(this.xlC - this.xlA.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.xkm)
              {
                paramView.dDo();
                paramView.cMS = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.xkm)
                {
                  paramView.dDo();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = an(paramView, paramInt);
          continue;
          label1631:
          paramView = an(paramView, paramInt);
        }
        label1641:
        localObject1 = paramView;
      }
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.xlA.clear();
      this.xlD.clear();
      Iterator localIterator = this.xlD.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.xlD.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.xlB;
          p.g(localObject, "it");
          locala.cv((View)localObject);
        }
      }
      bDh();
      AppMethodBeat.o(138740);
    }
    
    public final void d(cqi paramcqi)
    {
      AppMethodBeat.i(138742);
      if (paramcqi != null)
      {
        localObject = (CharSequence)paramcqi.nDo;
        if ((localObject != null) && (!n.aE((CharSequence)localObject))) {
          break label73;
        }
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = (CharSequence)paramcqi.GgA;
        if ((localObject != null) && (!n.aE((CharSequence)localObject))) {
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
      Object localObject = g.xla;
      if (paramcqi == null) {
        p.gfZ();
      }
      localObject = g.b(paramcqi);
      paramcqi = (cqi)localObject;
      if (RadarViewController.c(RadarViewController.this).xiO.containsKey(localObject))
      {
        paramcqi = RadarViewController.c(RadarViewController.this).xiO.get(localObject);
        if (paramcqi == null)
        {
          paramcqi = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramcqi;
        }
        paramcqi = (String)paramcqi;
      }
      this.xlz.put(paramcqi, paramcqi);
      AppMethodBeat.o(138742);
    }
    
    public final int getCount()
    {
      if (this.xlE) {
        return 0;
      }
      return this.xly.length;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView xlF;
      ImageView xlG;
      RadarStateView xlH;
      RadarStateChooseView xlI;
      ImageView xlJ;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.xlF = paramImageView1;
        this.xlG = paramRadarStateView;
        this.xlH = paramRadarStateChooseView;
        this.xlI = paramImageView2;
        this.xlJ = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      if ((this.xlw.getRadarStatus() == e.e.xjf) || (this.xlw.getRadarStatus() == e.e.xjg))
      {
        paramView = this.xlw.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138748);
          throw paramView;
        }
        ((Activity)paramView).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138748);
        return;
      }
      paramView = this.xlw;
      localObject = RadarViewController.d(this.xlw);
      LinkedList localLinkedList = new LinkedList();
      int j = ((RadarViewController.c)localObject).xly.length;
      int i = 0;
      while (i < j)
      {
        cqi localcqi = localObject.xly[i];
        if (localcqi != null) {
          localLinkedList.add(localcqi);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.xlw).dDy();
        RadarViewController.f(this.xlw).setVisibility(0);
        RadarViewController.c(this.xlw).dDe();
        RadarViewController.a(this.xlw, e.e.xjg);
      }
      for (;;)
      {
        RadarViewController.d(this.xlw).bDh();
        break;
        RadarViewController.a(this.xlw, e.e.xjf);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cB(this.xlw.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      AppMethodBeat.i(138751);
      p.h(paramView, "view");
      final cqi localcqi = (cqi)RadarViewController.d(this.xlw).xly[paramInt];
      if (localcqi == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.xlw.getRadarStatus();
      Object localObject2;
      switch (h.gnp[localObject1.ordinal()])
      {
      default: 
        com.tencent.mm.sdk.platformtools.ad.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.xlw.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.xla;
        localObject1 = g.b(localcqi);
        if (localcqi != null)
        {
          localObject2 = (CharSequence)localcqi.nDo;
          if ((localObject2 != null) && (!n.aE((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = j;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localcqi.GgA;
          if ((localObject2 != null) && (!n.aE((CharSequence)localObject2))) {
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
          localObject2 = (View)RadarViewController.d(this.xlw).xlD.get(localObject1);
          localObject1 = e.a(RadarViewController.c(this.xlw), localcqi);
          if ((localObject2 == null) || (localObject1 == c.e.xiq)) {
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
        ((RadarViewController.c.a)localObject2).xlH.dDq();
        localObject2 = new ap();
        paramView = (Runnable)new a(this, paramView, localcqi, (c.e)localObject1);
        localObject1 = RadarStateView.xkv;
        ((ap)localObject2).postDelayed(paramView, RadarStateView.dDr());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.xlw).a(paramView, localcqi, (c.e)localObject1);
        RadarViewController.f(this.xlw).dDz();
        AppMethodBeat.o(138751);
        return;
      }
      if (localcqi != null)
      {
        paramView = (CharSequence)localcqi.nDo;
        if ((paramView == null) || (n.aE(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localcqi.GgA;
          if ((paramView != null) && (!n.aE(paramView))) {
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
          localObject2 = RadarViewController.d(this.xlw);
          if (localcqi == null) {
            break label612;
          }
          paramView = g.xla;
          localObject1 = g.b(localcqi);
          paramView = (View)localObject1;
          if (RadarViewController.c(((RadarViewController.c)localObject2).xlw).xiO.containsKey(localObject1))
          {
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).xlw).xiO.get(localObject1);
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
          if (!((RadarViewController.c)localObject2).xlz.containsKey(paramView)) {
            break label612;
          }
          paramInt = 1;
          if (paramInt != 0) {
            break label617;
          }
          RadarViewController.d(this.xlw).d(localcqi);
        }
      }
      for (;;)
      {
        RadarViewController.c(this.xlw).a(localcqi);
        RadarViewController.dDw();
        RadarViewController.d(this.xlw).bDh();
        AppMethodBeat.o(138751);
        return;
        label612:
        paramInt = 0;
        break;
        label617:
        localObject2 = RadarViewController.d(this.xlw);
        if (localcqi != null)
        {
          paramView = (CharSequence)localcqi.nDo;
          if ((paramView != null) && (!n.aE(paramView))) {
            break label772;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label782;
          }
          paramView = (CharSequence)localcqi.GgA;
          if ((paramView != null) && (!n.aE(paramView))) {
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
          paramView = g.xla;
          if (localcqi == null) {
            p.gfZ();
          }
          localObject1 = g.b(localcqi);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).xlw).xiO.containsKey(localObject1)) {
            break label792;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).xlw).xiO.get(localObject1);
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
        ((RadarViewController.c)localObject2).xlz.remove(paramView);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, cqi paramcqi, c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.xlM.xlw).a(paramView, localcqi, this.xlN);
        RadarViewController.f(this.xlM.xlw).dDz();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<RadarWaveView>
  {
    i(RadarViewController paramRadarViewController)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */