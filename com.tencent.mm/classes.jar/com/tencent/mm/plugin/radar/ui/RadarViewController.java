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
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.ui.base.h;
import d.f;
import d.g.b.ad;
import d.g.b.p;
import d.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController
  extends RelativeLayout
  implements c.c, e.d
{
  private static final String TAG = "MicroMsg.Radar.RadarViewController";
  public static final RadarViewController.b xBp;
  private boolean vsk;
  private final f xAY;
  private final f xAZ;
  private final f xBa;
  private final f xBb;
  private final f xBc;
  private final f xBd;
  private final f xBe;
  private final f xBf;
  e xBg;
  c xBh;
  c xBi;
  private e.e xBj;
  private final boolean xBk;
  final View.OnClickListener xBl;
  private final int xBm;
  private final int xBn;
  private final int xBo;
  
  static
  {
    AppMethodBeat.i(138753);
    xBp = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.xAY = d.g.O((d.g.a.a)new i(this));
    this.xAZ = i.ao(this, 2131303683);
    this.xBa = i.ao(this, 2131303698);
    this.xBb = i.ao(this, 2131303700);
    this.xBc = i.ao(this, 2131303688);
    this.xBd = i.ao(this, 2131303689);
    this.xBe = i.ao(this, 2131303692);
    this.xBf = i.ao(this, 2131303677);
    this.xBj = e.e.xzc;
    this.xBl = ((View.OnClickListener)new f(this));
    this.xBm = 33554432;
    this.xBn = (this.xBm + 1);
    this.xBo = (this.xBm + 2);
    paramAttributeSet = (e.d)this;
    Context localContext = paramContext.getApplicationContext();
    p.g(localContext, "mContext.getApplicationContext()");
    this.xBg = new e(paramAttributeSet, localContext);
    this.xBh = new c((c.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(e.e parame)
  {
    AppMethodBeat.i(138775);
    this.xBj = parame;
    switch (h.xBI[parame.ordinal()])
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
      getWaveView().dGP();
      getWaveView().setVisibility(0);
      parame = this.xBg;
      if (parame == null) {
        p.bdF("radarManager");
      }
      parame.dGv();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
      dGM();
      getQuitBtn().setText(2131755691);
      parame = this.xBg;
      if (parame == null) {
        p.bdF("radarManager");
      }
      parame.dGw();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762151);
      getWaveView().dGQ();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.xBi;
      if (parame == null) {
        p.bdF("adapter");
      }
      parame.clearAll();
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(0);
      parame = this.xBg;
      if (parame == null) {
        p.bdF("radarManager");
      }
      parame.dGw();
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText(2131762140);
      getGrid().setVisibility(0);
      AppMethodBeat.o(138775);
      return;
      getRadarBgMask().setVisibility(8);
      parame = this.xBg;
      if (parame == null) {
        p.bdF("radarManager");
      }
      parame.dGw();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(2131762141);
    }
  }
  
  private final void aL(LinkedList<crc> paramLinkedList)
  {
    AppMethodBeat.i(138773);
    if (paramLinkedList == null) {
      p.gkB();
    }
    c localc;
    if (paramLinkedList.size() == 0)
    {
      localc = this.xBi;
      if (localc == null) {
        p.bdF("adapter");
      }
      if (localc.getCount() == 0) {
        getRadarTips().setNoMember(true);
      }
    }
    for (;;)
    {
      ae.d(TAG, "members got, size : " + paramLinkedList.size());
      boolean bool = aM(paramLinkedList);
      ae.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
      localc = this.xBi;
      if (localc == null) {
        p.bdF("adapter");
      }
      localc.aN(paramLinkedList);
      if ((this.xBk) && (bool)) {
        a(e.e.xzd);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
    }
  }
  
  private final boolean aM(LinkedList<crc> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    boolean bool = false;
    if (paramLinkedList == null) {
      p.gkB();
    }
    Iterator localIterator = paramLinkedList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (crc)localIterator.next();
      paramLinkedList = this.xBg;
      if (paramLinkedList == null) {
        p.bdF("radarManager");
      }
      p.g(localObject, "member");
      paramLinkedList = e.a(paramLinkedList, (crc)localObject);
      if (paramLinkedList != null) {
        break label143;
      }
      paramLinkedList = g.xAX;
      localObject = g.b((crc)localObject);
      paramLinkedList = this.xBh.awv((String)localObject);
      e locale = this.xBg;
      if (locale == null) {
        p.bdF("radarManager");
      }
      locale.b((String)localObject, paramLinkedList);
    }
    label143:
    for (;;)
    {
      if (paramLinkedList == c.e.xyo) {
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
    Object localObject = this.xBg;
    if (localObject == null) {
      p.bdF("radarManager");
    }
    if (paramString == null) {
      p.gkB();
    }
    localObject = ((e)localObject).aww(paramString);
    if ((localObject != null) && (localObject != parame))
    {
      localObject = this.xBg;
      if (localObject == null) {
        p.bdF("radarManager");
      }
      ((e)localObject).b(paramString, parame);
      paramString = this.xBi;
      if (paramString == null) {
        p.bdF("adapter");
      }
      paramString.bDZ();
    }
    AppMethodBeat.o(138765);
  }
  
  private final void dGM()
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
    TextView localTextView = (TextView)this.xBc.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.xBd.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.xBf.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<crc> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(2131761535);
        p.g(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.awx(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(2131762155);
      p.g(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.awx(str);
      AppMethodBeat.o(138771);
      return;
    }
    aL(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138767);
    if (paramBoolean) {
      d(paramString2, c.e.xyo);
    }
    for (;;)
    {
      paramString1 = this.xBg;
      if (paramString1 == null) {
        p.bdF("radarManager");
      }
      paramString1.xyO.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.awx(paramString2);
      paramString1 = this.xBg;
      if (paramString1 == null) {
        p.bdF("radarManager");
      }
      paramString1 = (e.c)paramString1.xyO.get(Long.valueOf(paramLong));
      if (paramString1 != null)
      {
        paramString2 = g.xAX;
        d(g.b(paramString1.xza), paramString1.xzb);
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138766);
    if (paramBoolean1) {
      d(paramString2, c.e.xyo);
    }
    for (;;)
    {
      paramString1 = this.xBg;
      if (paramString1 == null) {
        p.bdF("radarManager");
      }
      paramString1.xyO.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, c.e.xyn);
      }
      else
      {
        RadarTipsView localRadarTipsView = getRadarTips();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        localRadarTipsView.awx(paramString2);
        paramString1 = this.xBg;
        if (paramString1 == null) {
          p.bdF("radarManager");
        }
        paramString1 = (e.c)paramString1.xyO.get(Long.valueOf(paramLong));
        if (paramString1 != null)
        {
          paramString2 = g.xAX;
          d(g.b(paramString1.xza), paramString1.xzb);
          paramString2 = g.xAX;
          d(g.c(paramString1.xza), paramString1.xzb);
        }
      }
    }
  }
  
  public final void ae(an paraman)
  {
    AppMethodBeat.i(138769);
    p.h(paraman, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paraman.VN();
      p.g(str, "contact.encryptUsername");
      localRadarMemberView.c(str, c.e.xyo);
    }
    d(paraman.getUsername(), c.e.xyo);
    d(paraman.VN(), c.e.xyo);
    AppMethodBeat.o(138769);
  }
  
  public final void af(an paraman)
  {
    AppMethodBeat.i(138768);
    p.h(paraman, "contact");
    Object localObject = this.xBg;
    if (localObject == null) {
      p.bdF("radarManager");
    }
    String str1 = paraman.getUsername();
    p.g(str1, "contact.username");
    if (((e)localObject).aww(str1) == null)
    {
      localObject = this.xBg;
      if (localObject == null) {
        p.bdF("radarManager");
      }
      str1 = paraman.VN();
      p.g(str1, "contact.encryptUsername");
      if (((e)localObject).aww(str1) == null)
      {
        localObject = new LinkedList();
        str1 = paraman.getUsername();
        p.g(str1, "contact.username");
        String str2 = paraman.VN();
        p.g(str2, "contact.encryptUsername");
        String str3 = paraman.VK();
        p.g(str3, "contact.nickname");
        crc localcrc = new crc();
        localcrc.HCr = 100;
        localcrc.nIJ = str1;
        localcrc.nJO = str3;
        localcrc.SmallImgUrl = "";
        localcrc.Gzj = str2;
        ((LinkedList)localObject).add(localcrc);
        aL((LinkedList)localObject);
      }
    }
    if (getMemberDetailView().isShowing())
    {
      localObject = getMemberDetailView();
      str1 = paraman.VN();
      p.g(str1, "contact.encryptUsername");
      ((RadarMemberView)localObject).c(str1, c.e.xyp);
    }
    d(paraman.getUsername(), c.e.xyp);
    d(paraman.VN(), c.e.xyp);
    AppMethodBeat.o(138768);
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<cqz> paramLinkedList)
  {
    int i = 0;
    AppMethodBeat.i(138772);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramLinkedList != null))
    {
      a(e.e.xzf);
      c localc = this.xBi;
      if (localc == null) {
        p.bdF("adapter");
      }
      c(localc.xBt).xyP.clear();
      c(localc.xBt).xyL.clear();
      localc.xBw.clear();
      localc.xBx.clear();
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
            localObject2 = (cqz)localObject2;
            localObject3 = new cra();
            ((cra)localObject3).HCq = ((cqz)localObject2).nIJ;
            ((LinkedList)localObject1).add(localObject3);
            localObject3 = c(localc.xBt).xyL;
            Object localObject4 = ((cqz)localObject2).Gzj;
            p.g(localObject4, "radarchatroomMember.EncodeUserName");
            String str = ((cqz)localObject2).nIJ;
            p.g(str, "radarchatroomMember.UserName");
            ((Map)localObject3).put(localObject4, str);
            localObject3 = localc.xBx;
            localObject4 = g.xAX;
            ((HashMap)localObject3).put(g.a((cqz)localObject2), Integer.valueOf(0));
            paramInt1 += 1;
          }
          paramInt2 = localc.xBv.length;
          paramInt1 = i;
          while (paramInt1 < paramInt2)
          {
            paramLinkedList = localc.xBv[paramInt1];
            localObject2 = c(localc.xBt).xyL;
            localObject3 = g.xAX;
            if (!bu.isNullOrNil((String)((Map)localObject2).get(g.c(paramLinkedList))))
            {
              d(localc.xBt).d(paramLinkedList);
              c(localc.xBt).a(paramLinkedList);
            }
            paramInt1 += 1;
          }
        }
      }
      c(localc.xBt).xyK = ((LinkedList)localObject1);
      paramLinkedList = this.xBi;
      if (paramLinkedList == null) {
        p.bdF("adapter");
      }
      paramLinkedList.bDZ();
      AppMethodBeat.o(138772);
      return;
    }
    a(e.e.xzc);
    paramLinkedList = getRadarTips();
    Object localObject1 = getContext().getString(2131762155);
    p.g(localObject1, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.awx((String)localObject1);
    AppMethodBeat.o(138772);
  }
  
  public final void dGv()
  {
    AppMethodBeat.i(138763);
    e locale = this.xBg;
    if (locale == null) {
      p.bdF("radarManager");
    }
    locale.dGv();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.xBa.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.xAZ.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.xBe.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final e.e getRadarStatus()
  {
    return this.xBj;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.xBb.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    RadarWaveView localRadarWaveView = (RadarWaveView)this.xAY.getValue();
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
    e locale = this.xBg;
    if (locale == null) {
      p.bdF("radarManager");
    }
    locale.onResume();
    AppMethodBeat.o(138762);
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(2131762154);
      p.g(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.awx(str);
      if ((!this.vsk) && (!com.tencent.mm.modelgeo.d.aIi()))
      {
        this.vsk = true;
        h.a(getContext(), getContext().getString(2131760082), getContext().getString(2131755906), getContext().getString(2131760598), getContext().getString(2131755691), false, (DialogInterface.OnClickListener)new g(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
  final class a
  {
    private int xBq;
    final boolean xBr;
    private final a xBs;
    
    public a()
    {
      AppMethodBeat.i(138736);
      g localg = g.xAX;
      this$1 = this$1.getContext();
      p.g(this$1, "context");
      this.xBr = g.gd(this$1);
      this.xBs = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int eA(View paramView)
    {
      AppMethodBeat.i(138735);
      Object localObject = paramView.getTag(RadarViewController.a(this.xBt));
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
        this.xBs.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final int dGO()
    {
      this.xBq += 1;
      return this.xBq;
    }
    
    public final Animation getInAnimation()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.xBt.getContext(), 2130772117);
      p.g(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final void i(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      p.h(paramView, "view");
      Message localMessage = this.xBs.obtainMessage();
      localMessage.what = eA(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.xBs.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class a
      extends aq
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
          if (!this.xBu.xBr)
          {
            Object localObject = localView.getTag(RadarViewController.b(this.xBu.xBt));
            paramMessage = (Message)localObject;
            if (!(localObject instanceof Animation)) {
              paramMessage = null;
            }
            localObject = (Animation)paramMessage;
            paramMessage = (Message)localObject;
            if (localObject == null) {
              paramMessage = this.xBu.getInAnimation();
            }
            localView.startAnimation(paramMessage);
          }
        }
        AppMethodBeat.o(138731);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
  public final class c
    extends a
  {
    private final Context context;
    HashMap<String, View> xBA;
    private boolean xBB;
    crc[] xBv;
    HashMap<String, String> xBw;
    HashMap<String, Integer> xBx;
    private final RadarViewController.a xBy;
    private int xBz;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.xBv = new crc[12];
      this.xBw = new HashMap();
      this.xBx = new HashMap();
      this.xBA = new HashMap();
      this.xBy = new RadarViewController.a(RadarViewController.this);
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
          p.gkB();
        }
        localView.setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.xBy.dGO()));
        localView.setTag(RadarViewController.b(RadarViewController.this), this.xBy.getInAnimation());
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
    
    public final void aN(LinkedList<crc> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if (((paramLinkedList != null) && (paramLinkedList.size() == 0)) || (paramLinkedList == null))
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).xBv.length;
      int i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (crc)((Iterator)localObject2).next();
          localObject4 = g.xAX;
          localObject4 = g.c((crc)localObject3);
          g localg = g.xAX;
          if (p.i(localObject4, g.c(localObject1.xBv[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      label280:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (crc)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.xBv.length;
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
          localObject3 = this.xBv[n];
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)((crc)localObject3).nIJ;
            if ((localObject4 != null) && (!d.n.n.aD((CharSequence)localObject4))) {
              break label339;
            }
            j = 1;
            label249:
            if (j == 0) {
              break label351;
            }
            localObject3 = (CharSequence)((crc)localObject3).Gzj;
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
            this.xBv[n] = localObject2;
            localObject3 = this.xBx;
            localObject4 = g.xAX;
            p.g(localObject2, "member");
            ((HashMap)localObject3).put(g.b((crc)localObject2), Integer.valueOf(0));
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
        bDZ();
        localObject1 = com.tencent.mm.plugin.radar.b.d.xyG;
        i = paramLinkedList.size();
        if ((com.tencent.mm.plugin.radar.b.d.dAb == 0) && (i > 0))
        {
          float f = (float)(com.tencent.mm.plugin.radar.b.d.dGu() - com.tencent.mm.plugin.radar.b.d.xyC) * 1.0F / 1000.0F;
          ae.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = com.tencent.mm.plugin.report.service.g.yxI;
          localObject1 = ad.Njc;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          p.g(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        com.tencent.mm.plugin.radar.b.d.dAb += i;
        com.tencent.mm.plugin.radar.b.d.xyD = i + com.tencent.mm.plugin.radar.b.d.xyD;
      }
      AppMethodBeat.o(138738);
    }
    
    public final View am(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      ae.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      crc localcrc = (crc)this.xBv[paramInt];
      Object localObject1;
      int i;
      label99:
      label105:
      String str;
      Object localObject2;
      if (localcrc != null)
      {
        localObject1 = (CharSequence)localcrc.nIJ;
        if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label238;
          }
          localObject1 = (CharSequence)localcrc.Gzj;
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
          localObject1 = g.xAX;
          str = g.b(localcrc);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1641;
          }
          localObject1 = View.inflate(this.context, 2131495170, null);
          if (localObject1 == null) {
            p.gkB();
          }
          ((View)localObject1).setTag(RadarViewController.a(RadarViewController.this), Integer.valueOf(this.xBy.dGO()));
          ((View)localObject1).setTag(RadarViewController.b(RadarViewController.this), this.xBy.getInAnimation());
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
        if ((localObject2 == e.e.xzc) || (localObject2 == e.e.xzd))
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
            this.xBA.put(str, localObject1);
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
        ((a)localObject4).xBC.setText((CharSequence)k.b(RadarViewController.this.getContext(), (CharSequence)localcrc.nJO, ((a)localObject4).xBC.getTextSize()));
        localObject2 = b.a.xzt;
        b.a.c(((a)localObject4).xBD, str);
        localObject2 = ((View)localObject1).findViewById(2131303675);
        p.g(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localcrc));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == e.e.xzc) || (RadarViewController.this.getRadarStatus() == e.e.xzd))
        {
          ((a)localObject4).xBG.setBackgroundResource(2131233935);
          paramView = ((a)localObject4).xBE;
          paramView.xAo = true;
          paramView.dGF();
          paramView = ((a)localObject4).xBF;
          paramView.xAj = false;
          paramView.setVisibility(8);
          localObject2 = e.a(RadarViewController.c(RadarViewController.this), localcrc);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = RadarViewController.e(RadarViewController.this).awv(str);
            localObject2 = RadarViewController.c(RadarViewController.this);
            p.h(localcrc, "member");
            p.h(paramView, "state");
            localObject3 = localcrc.nIJ;
            p.g(localObject3, "member.UserName");
            ((e)localObject2).b((String)localObject3, paramView);
            localObject3 = localcrc.Gzj;
            p.g(localObject3, "member.EncodeUserName");
            ((e)localObject2).b((String)localObject3, paramView);
          }
          localObject3 = RadarViewController.c(RadarViewController.this).a(localcrc, true);
          localObject5 = ((a)localObject4).xBE;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = c.e.xym;
          }
          p.h(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).xAp.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).xzb = ((c.e)localObject2);
          ((RadarStateView)localObject5).cNB = false;
          ((RadarStateView)localObject5).dGF();
          localObject2 = ((a)localObject4).xBE;
          p.h(paramView, "state");
          ((RadarStateView)localObject2).init();
          ae.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(paramView)));
          bool = false;
          if (((RadarStateView)localObject2).xzb == paramView)
          {
            ((RadarStateView)localObject2).dGF();
            paramView = RadarViewController.c(RadarViewController.this);
            p.h(localcrc, "member");
            localObject2 = localcrc.nIJ;
            p.g(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localcrc.Gzj;
            p.g(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.xBz = this.xBx.size();
            }
            paramView = (View)localObject1;
            if (this.xBx.remove(str) != null)
            {
              this.xBy.i(this.xBz - this.xBx.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).dGH();
              bool = true;
            }
            ae.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(bool)));
            ((RadarStateView)localObject2).xzb = paramView;
            if (((RadarStateView)localObject2).xzb == c.e.xym) {
              break;
            }
            if (bool) {
              break label1264;
            }
            ((RadarStateView)localObject2).xAp.sendEmptyMessage(0);
            break;
          }
          label1264:
          ((RadarStateView)localObject2).xAp.sendEmptyMessageDelayed(0, RadarStateView.xAr + 20);
          break;
          localObject2 = RadarViewController.c(RadarViewController.this).xyL;
          localObject3 = g.xAX;
          if (!bu.isNullOrNil((String)((Map)localObject2).get(g.c(localcrc))))
          {
            paramView = ((a)localObject4).xBE;
            paramView.xAo = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).xBF;
            paramView.xAj = true;
            paramView.dGF();
            paramView = RadarViewController.c(RadarViewController.this);
            if (localcrc != null)
            {
              localObject2 = g.xAX;
              localObject2 = g.b(localcrc);
              localObject2 = (e.a)paramView.xyP.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 == null) {
                paramView = e.a.xyY;
              }
              localObject2 = paramView;
              if (paramView != null) {}
            }
            else
            {
              localObject2 = e.a.xyY;
            }
            if (localObject2 != e.a.xyY) {
              ((a)localObject4).xBG.setBackgroundDrawable(null);
            }
            paramView = ((a)localObject4).xBF;
            p.h(localObject2, "status");
            if (paramView.xAk != localObject2)
            {
              paramView.xAk = ((e.a)localObject2);
              localObject2 = paramView.xAk;
              switch (e.gpL[localObject2.ordinal()])
              {
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.xBz = this.xBx.size();
              }
              localObject2 = this.xBx;
              paramView = g.xAX;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(g.c(localcrc)) == null) {
                break;
              }
              this.xBy.i(this.xBz - this.xBx.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              if (paramView.xAj)
              {
                paramView.dGF();
                paramView.cNB = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.xAj)
                {
                  paramView.dGF();
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
      this.xBx.clear();
      this.xBA.clear();
      Iterator localIterator = this.xBA.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.xBA.get(localObject);
        if (localObject != null)
        {
          RadarViewController.a locala = this.xBy;
          p.g(localObject, "it");
          locala.cv((View)localObject);
        }
      }
      bDZ();
      AppMethodBeat.o(138740);
    }
    
    public final void d(crc paramcrc)
    {
      AppMethodBeat.i(138742);
      if (paramcrc != null)
      {
        localObject = (CharSequence)paramcrc.nIJ;
        if ((localObject != null) && (!d.n.n.aD((CharSequence)localObject))) {
          break label73;
        }
        i = 1;
        if (i == 0) {
          break label83;
        }
        localObject = (CharSequence)paramcrc.Gzj;
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
      Object localObject = g.xAX;
      if (paramcrc == null) {
        p.gkB();
      }
      localObject = g.b(paramcrc);
      paramcrc = (crc)localObject;
      if (RadarViewController.c(RadarViewController.this).xyL.containsKey(localObject))
      {
        paramcrc = RadarViewController.c(RadarViewController.this).xyL.get(localObject);
        if (paramcrc == null)
        {
          paramcrc = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramcrc;
        }
        paramcrc = (String)paramcrc;
      }
      this.xBw.put(paramcrc, paramcrc);
      AppMethodBeat.o(138742);
    }
    
    public final int getCount()
    {
      if (this.xBB) {
        return 0;
      }
      return this.xBv.length;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
    public final class a
    {
      TextView xBC;
      ImageView xBD;
      RadarStateView xBE;
      RadarStateChooseView xBF;
      ImageView xBG;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.xBC = paramImageView1;
        this.xBD = paramRadarStateView;
        this.xBE = paramRadarStateChooseView;
        this.xBF = paramImageView2;
        this.xBG = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static final class e
    implements RadarMemberView.b
  {
    public final void a(crc paramcrc, c.e parame)
    {
      AppMethodBeat.i(138746);
      p.h(paramcrc, "member");
      Object localObject1 = g.xAX;
      String str = g.b(paramcrc);
      if (parame == null)
      {
        AppMethodBeat.o(138746);
        return;
      }
      switch (h.cqt[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(138746);
        return;
      case 1: 
        l = RadarViewController.e(this.xBt).awu(str);
        RadarViewController.c(this.xBt).xyO.put(Long.valueOf(l), new e.c(paramcrc, parame));
        RadarViewController.a(this.xBt, str, c.e.xyn);
        AppMethodBeat.o(138746);
        return;
      }
      Object localObject2 = RadarViewController.e(this.xBt);
      p.h(str, "username");
      localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().BH(str);
      p.g(localObject1, "contact");
      Object localObject3 = (CharSequence)((an)localObject1).getUsername();
      if ((localObject3 == null) || (d.n.n.aD((CharSequence)localObject3)))
      {
        i = 1;
        label213:
        if (i == 0) {
          break label342;
        }
        localObject1 = str;
        label221:
        localObject3 = (String)((c)localObject2).xyd.get(localObject1);
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
        ae.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
        ((c)localObject2).awu((String)localObject1);
        l = -1L;
        RadarViewController.c(this.xBt).xyO.put(Long.valueOf(l), new e.c(paramcrc, parame));
        RadarViewController.a(this.xBt, str, c.e.xyn);
        break;
        i = 0;
        break label213;
        localObject1 = ((an)localObject1).getUsername();
        p.g(localObject1, "contact.username");
        break label221;
      }
      label364:
      Object localObject4 = bv.d.aVF((String)localObject3);
      long l = System.currentTimeMillis();
      localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
      localObject3 = ((bv.d)localObject4).fww();
      p.g(localObject3, "verify.verifyTicket");
      p.h(localObject3, "verifyTicket");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("username is null", bool);
        ((c.a)localObject2).onStart();
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)new o((String)localObject1, (String)localObject3, 48));
        break;
      }
    }
    
    public final void b(crc paramcrc, c.e parame)
    {
      AppMethodBeat.i(138747);
      if (paramcrc != null) {
        g localg = g.xAX;
      }
      for (paramcrc = g.b(paramcrc);; paramcrc = null)
      {
        paramcrc = (View)((Map)RadarViewController.d(this.xBt).xBA).get(paramcrc);
        if (paramcrc == null) {
          break label96;
        }
        paramcrc = paramcrc.getTag();
        if (paramcrc != null) {
          break;
        }
        paramcrc = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
        AppMethodBeat.o(138747);
        throw paramcrc;
      }
      paramcrc = (RadarViewController.c.a)paramcrc;
      if (parame != c.e.xym) {
        paramcrc.xBE.dGG();
      }
      label96:
      RadarViewController.f(this.xBt).dGP();
      AppMethodBeat.o(138747);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(RadarViewController paramRadarViewController) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138748);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarViewController$mOnQuitActionButtonListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      if ((this.xBt.getRadarStatus() == e.e.xzc) || (this.xBt.getRadarStatus() == e.e.xzd))
      {
        paramView = this.xBt.getContext();
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
      paramView = this.xBt;
      localObject = RadarViewController.d(this.xBt);
      LinkedList localLinkedList = new LinkedList();
      int j = ((RadarViewController.c)localObject).xBv.length;
      int i = 0;
      while (i < j)
      {
        crc localcrc = localObject.xBv[i];
        if (localcrc != null) {
          localLinkedList.add(localcrc);
        }
        i += 1;
      }
      if (RadarViewController.a(paramView, localLinkedList))
      {
        RadarViewController.f(this.xBt).dGP();
        RadarViewController.f(this.xBt).setVisibility(0);
        RadarViewController.c(this.xBt).dGv();
        RadarViewController.a(this.xBt, e.e.xzd);
      }
      for (;;)
      {
        RadarViewController.d(this.xBt).bDZ();
        break;
        RadarViewController.a(this.xBt, e.e.xzc);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(RadarViewController paramRadarViewController) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138749);
      com.tencent.mm.modelgeo.d.cD(this.xBt.getContext());
      AppMethodBeat.o(138749);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
  public static final class h
    implements RadarSpecialGridView.a
  {
    public final void b(int paramInt, final View paramView)
    {
      int j = 0;
      AppMethodBeat.i(138751);
      p.h(paramView, "view");
      final crc localcrc = (crc)RadarViewController.d(this.xBt).xBv[paramInt];
      if (localcrc == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      Object localObject1 = this.xBt.getRadarStatus();
      Object localObject2;
      switch (h.gpL[localObject1.ordinal()])
      {
      default: 
        ae.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.xBt.getRadarStatus() });
        AppMethodBeat.o(138751);
        return;
      case 1: 
      case 2: 
        localObject1 = g.xAX;
        localObject1 = g.b(localcrc);
        if (localcrc != null)
        {
          localObject2 = (CharSequence)localcrc.nIJ;
          if ((localObject2 != null) && (!d.n.n.aD((CharSequence)localObject2))) {
            break label279;
          }
          i = 1;
          label158:
          paramInt = j;
          if (i == 0) {
            break label199;
          }
          localObject2 = (CharSequence)localcrc.Gzj;
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
          localObject2 = (View)RadarViewController.d(this.xBt).xBA.get(localObject1);
          localObject1 = e.a(RadarViewController.c(this.xBt), localcrc);
          if ((localObject2 == null) || (localObject1 == c.e.xym)) {
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
        ((RadarViewController.c.a)localObject2).xBE.dGH();
        localObject2 = new aq();
        paramView = (Runnable)new a(this, paramView, localcrc, (c.e)localObject1);
        localObject1 = RadarStateView.xAs;
        ((aq)localObject2).postDelayed(paramView, RadarStateView.dGI());
        AppMethodBeat.o(138751);
        return;
        label348:
        RadarViewController.g(this.xBt).a(paramView, localcrc, (c.e)localObject1);
        RadarViewController.f(this.xBt).dGQ();
        AppMethodBeat.o(138751);
        return;
      }
      if (localcrc != null)
      {
        paramView = (CharSequence)localcrc.nIJ;
        if ((paramView == null) || (d.n.n.aD(paramView)))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label541;
          }
          paramView = (CharSequence)localcrc.Gzj;
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
          localObject2 = RadarViewController.d(this.xBt);
          if (localcrc == null) {
            break label612;
          }
          paramView = g.xAX;
          localObject1 = g.b(localcrc);
          paramView = (View)localObject1;
          if (RadarViewController.c(((RadarViewController.c)localObject2).xBt).xyL.containsKey(localObject1))
          {
            paramView = RadarViewController.c(((RadarViewController.c)localObject2).xBt).xyL.get(localObject1);
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
          if (!((RadarViewController.c)localObject2).xBw.containsKey(paramView)) {
            break label612;
          }
          paramInt = 1;
          if (paramInt != 0) {
            break label617;
          }
          RadarViewController.d(this.xBt).d(localcrc);
        }
      }
      for (;;)
      {
        RadarViewController.c(this.xBt).a(localcrc);
        RadarViewController.dGN();
        RadarViewController.d(this.xBt).bDZ();
        AppMethodBeat.o(138751);
        return;
        label612:
        paramInt = 0;
        break;
        label617:
        localObject2 = RadarViewController.d(this.xBt);
        if (localcrc != null)
        {
          paramView = (CharSequence)localcrc.nIJ;
          if ((paramView != null) && (!d.n.n.aD(paramView))) {
            break label772;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label782;
          }
          paramView = (CharSequence)localcrc.Gzj;
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
          paramView = g.xAX;
          if (localcrc == null) {
            p.gkB();
          }
          localObject1 = g.b(localcrc);
          paramView = (View)localObject1;
          if (!RadarViewController.c(((RadarViewController.c)localObject2).xBt).xyL.containsKey(localObject1)) {
            break label792;
          }
          paramView = RadarViewController.c(((RadarViewController.c)localObject2).xBt).xyL.get(localObject1);
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
        ((RadarViewController.c)localObject2).xBw.remove(paramView);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(RadarViewController.h paramh, View paramView, crc paramcrc, c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(138750);
        RadarViewController.g(this.xBJ.xBt).a(paramView, localcrc, this.xBK);
        RadarViewController.f(this.xBJ.xBt).dGQ();
        AppMethodBeat.o(138750);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends d.g.b.q
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