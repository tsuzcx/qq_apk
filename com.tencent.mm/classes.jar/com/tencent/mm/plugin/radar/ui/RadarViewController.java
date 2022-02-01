package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.model.b.c;
import com.tencent.mm.plugin.radar.model.b.e;
import com.tencent.mm.plugin.radar.model.c;
import com.tencent.mm.plugin.radar.model.d.a;
import com.tencent.mm.plugin.radar.model.d.c;
import com.tencent.mm.plugin.radar.model.d.d;
import com.tencent.mm.plugin.radar.model.d.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.ell;>;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarViewController
  extends RelativeLayout
  implements b.c, d.d
{
  public static final RadarViewController.b Nub;
  private static final String TAG;
  private boolean EPk;
  private final j Nuc;
  private final j Nud;
  private final j Nue;
  private final j Nuf;
  private final j Nug;
  private final j Nuh;
  private final j Nui;
  private final j Nuj;
  com.tencent.mm.plugin.radar.model.d Nuk;
  com.tencent.mm.plugin.radar.model.b Nul;
  c Num;
  private d.e Nun;
  private final boolean Nuo;
  final View.OnClickListener Nup;
  private final int Nuq;
  private final int Nur;
  private final int Nus;
  
  static
  {
    AppMethodBeat.i(138753);
    Nub = new RadarViewController.b((byte)0);
    TAG = "MicroMsg.Radar.RadarViewController";
    AppMethodBeat.o(138753);
  }
  
  public RadarViewController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138777);
    this.Nuc = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Nud = e.aM((View)this, a.d.NqB);
    this.Nue = e.aM((View)this, a.d.NqQ);
    this.Nuf = e.aM((View)this, a.d.NqS);
    this.Nug = e.aM((View)this, a.d.NqG);
    this.Nuh = e.aM((View)this, a.d.NqH);
    this.Nui = e.aM((View)this, a.d.NqK);
    this.Nuj = e.aM((View)this, a.d.Nqx);
    this.Nun = d.e.Nsn;
    this.Nup = new RadarViewController..ExternalSyntheticLambda1(this);
    this.Nuq = 33554432;
    this.Nur = (this.Nuq + 1);
    this.Nus = (this.Nuq + 2);
    paramAttributeSet = (d.d)this;
    Context localContext = paramContext.getApplicationContext();
    s.s(localContext, "mContext.getApplicationContext()");
    this.Nuk = new com.tencent.mm.plugin.radar.model.d(paramAttributeSet, localContext);
    this.Nul = new com.tencent.mm.plugin.radar.model.b((b.c)this, paramContext);
    AppMethodBeat.o(138777);
  }
  
  private final void a(d.e parame)
  {
    com.tencent.mm.plugin.radar.model.d locald2 = null;
    Object localObject = null;
    com.tencent.mm.plugin.radar.model.d locald1 = null;
    AppMethodBeat.i(138775);
    this.Nun = parame;
    switch (e.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      AppMethodBeat.o(138775);
      return;
    case 1: 
      getRadarBgMask().setVisibility(8);
      getQuitBtn().setText(a.g.Nrg);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      getWaveView().gFw();
      getWaveView().setVisibility(0);
      locald1 = this.Nuk;
      parame = locald1;
      if (locald1 == null)
      {
        s.bIx("radarManager");
        parame = null;
      }
      parame.gEZ();
      AppMethodBeat.o(138775);
      return;
    case 2: 
      getRadarBgMask().setVisibility(8);
      getNewRadarTipLoading().setVisibility(8);
      getNewRadarTip().setText((CharSequence)"");
      AppMethodBeat.o(138775);
      return;
    case 3: 
      gFr();
      getQuitBtn().setText(a.g.app_cancel);
      locald2 = this.Nuk;
      parame = locald2;
      if (locald2 == null)
      {
        s.bIx("radarManager");
        parame = null;
      }
      parame.gFa();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(a.g.Nrh);
      getWaveView().gFx();
      getWaveView().setVisibility(4);
      getGrid().setVisibility(4);
      parame = this.Num;
      if (parame == null)
      {
        s.bIx("adapter");
        parame = locald1;
      }
      for (;;)
      {
        parame.clearAll();
        AppMethodBeat.o(138775);
        return;
      }
    case 4: 
      getRadarBgMask().setVisibility(0);
      parame = this.Nuk;
      if (parame == null)
      {
        s.bIx("radarManager");
        parame = locald2;
      }
      for (;;)
      {
        parame.gFa();
        getNewRadarTipLoading().setVisibility(8);
        getNewRadarTip().setText(a.g.Nrc);
        getGrid().setVisibility(0);
        AppMethodBeat.o(138775);
        return;
      }
    }
    getRadarBgMask().setVisibility(8);
    parame = this.Nuk;
    if (parame == null)
    {
      s.bIx("radarManager");
      parame = localObject;
    }
    for (;;)
    {
      parame.gFa();
      getNewRadarTipLoading().setVisibility(0);
      getNewRadarTip().setText(a.g.Nrd);
      break;
    }
  }
  
  private static final void a(RadarViewController paramRadarViewController, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(267263);
    s.u(paramRadarViewController, "this$0");
    com.tencent.mm.modelgeo.d.dP(paramRadarViewController.getContext());
    AppMethodBeat.o(267263);
  }
  
  private static final void a(RadarViewController paramRadarViewController, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(267261);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRadarViewController);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/radar/ui/RadarViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramRadarViewController, "this$0");
    if ((paramRadarViewController.getRadarStatus() == d.e.Nsn) || (paramRadarViewController.getRadarStatus() == d.e.Nso))
    {
      paramRadarViewController = paramRadarViewController.getContext();
      if (paramRadarViewController == null)
      {
        paramRadarViewController = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(267261);
        throw paramRadarViewController;
      }
      ((Activity)paramRadarViewController).finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267261);
      return;
    }
    localObject2 = paramRadarViewController.Num;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("adapter");
      paramView = null;
    }
    if (paramRadarViewController.bM(paramView.gFv()))
    {
      paramRadarViewController.getWaveView().gFw();
      paramRadarViewController.getWaveView().setVisibility(0);
      localObject2 = paramRadarViewController.Nuk;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("radarManager");
        paramView = null;
      }
      paramView.gEZ();
      paramRadarViewController.a(d.e.Nso);
      label224:
      paramRadarViewController = paramRadarViewController.Num;
      if (paramRadarViewController != null) {
        break label258;
      }
      s.bIx("adapter");
      paramRadarViewController = localObject1;
    }
    label258:
    for (;;)
    {
      paramRadarViewController.cPy();
      break;
      paramRadarViewController.a(d.e.Nsn);
      break label224;
    }
  }
  
  private final void bL(LinkedList<ell> paramLinkedList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(138773);
    s.checkNotNull(paramLinkedList);
    Object localObject1;
    boolean bool;
    if (paramLinkedList.size() == 0)
    {
      c localc = this.Num;
      localObject1 = localc;
      if (localc == null)
      {
        s.bIx("adapter");
        localObject1 = null;
      }
      if (((c)localObject1).getCount() == 0)
      {
        getRadarTips().setNoMember(true);
        Log.d(TAG, s.X("members got, size : ", Integer.valueOf(paramLinkedList.size())));
        bool = bM(paramLinkedList);
        Log.d(TAG, "has friend:%s", new Object[] { String.valueOf(bool) });
        localObject1 = this.Num;
        if (localObject1 != null) {
          break label161;
        }
        s.bIx("adapter");
        localObject1 = localObject2;
      }
    }
    label161:
    for (;;)
    {
      ((c)localObject1).bN(paramLinkedList);
      if ((this.Nuo) && (bool)) {
        a(d.e.Nso);
      }
      AppMethodBeat.o(138773);
      return;
      getRadarTips().setNoMember(false);
      break;
    }
  }
  
  private final boolean bM(LinkedList<ell> paramLinkedList)
  {
    AppMethodBeat.i(138774);
    s.checkNotNull(paramLinkedList);
    Iterator localIterator = paramLinkedList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject2 = (ell)localIterator.next();
      Object localObject1 = this.Nuk;
      paramLinkedList = (LinkedList<ell>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("radarManager");
        paramLinkedList = null;
      }
      s.s(localObject2, "member");
      localObject1 = com.tencent.mm.plugin.radar.model.d.a(paramLinkedList, (ell)localObject2);
      paramLinkedList = (LinkedList<ell>)localObject1;
      if (localObject1 == null)
      {
        paramLinkedList = d.Nua;
        String str = d.a((ell)localObject2);
        localObject1 = this.Nul.aSw(str);
        localObject2 = this.Nuk;
        paramLinkedList = (LinkedList<ell>)localObject2;
        if (localObject2 == null)
        {
          s.bIx("radarManager");
          paramLinkedList = null;
        }
        paramLinkedList.b(str, (b.e)localObject1);
        paramLinkedList = (LinkedList<ell>)localObject1;
      }
      if (paramLinkedList == b.e.NrE) {
        bool = true;
      }
    }
    AppMethodBeat.o(138774);
    return bool;
  }
  
  private final void d(String paramString, b.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(138765);
    com.tencent.mm.plugin.radar.model.d locald = this.Nuk;
    Object localObject1 = locald;
    if (locald == null)
    {
      s.bIx("radarManager");
      localObject1 = null;
    }
    s.checkNotNull(paramString);
    localObject1 = ((com.tencent.mm.plugin.radar.model.d)localObject1).aSx(paramString);
    if ((localObject1 != null) && (localObject1 != parame))
    {
      locald = this.Nuk;
      localObject1 = locald;
      if (locald == null)
      {
        s.bIx("radarManager");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.radar.model.d)localObject1).b(paramString, parame);
      paramString = this.Num;
      if (paramString != null) {
        break label107;
      }
      s.bIx("adapter");
      paramString = localObject2;
    }
    label107:
    for (;;)
    {
      paramString.cPy();
      AppMethodBeat.o(138765);
      return;
    }
  }
  
  private final void gFr()
  {
    AppMethodBeat.i(138776);
    if (getRadarBgMask().getVisibility() != 0)
    {
      getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), a.a.Nqj));
      getRadarBgMask().setVisibility(0);
    }
    AppMethodBeat.o(138776);
  }
  
  private final TextView getNewRadarTip()
  {
    AppMethodBeat.i(138758);
    TextView localTextView = (TextView)this.Nug.getValue();
    AppMethodBeat.o(138758);
    return localTextView;
  }
  
  private final ProgressBar getNewRadarTipLoading()
  {
    AppMethodBeat.i(138759);
    ProgressBar localProgressBar = (ProgressBar)this.Nuh.getValue();
    AppMethodBeat.o(138759);
    return localProgressBar;
  }
  
  private final View getRadarBgMask()
  {
    AppMethodBeat.i(138761);
    View localView = (View)this.Nuj.getValue();
    AppMethodBeat.o(138761);
    return localView;
  }
  
  public final void AP(boolean paramBoolean)
  {
    AppMethodBeat.i(138770);
    if (!paramBoolean)
    {
      RadarTipsView localRadarTipsView = getRadarTips();
      String str = getContext().getString(a.g.Nrj);
      s.s(str, "context.getString(R.stri….radar_tips_location_err)");
      localRadarTipsView.aSy(str);
      if ((!this.EPk) && (!com.tencent.mm.modelgeo.d.bJm()))
      {
        this.EPk = true;
        com.tencent.mm.ui.base.k.a(getContext(), getContext().getString(a.g.gps_disable_tip), getContext().getString(a.g.app_tip), getContext().getString(a.g.jump_to_settings), getContext().getString(a.g.app_cancel), false, new RadarViewController..ExternalSyntheticLambda0(this), null);
      }
    }
    AppMethodBeat.o(138770);
  }
  
  public final void a(int paramInt1, int paramInt2, LinkedList<ell> paramLinkedList)
  {
    AppMethodBeat.i(138771);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(TAG, "radar member return error : %s, type : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (2 == paramInt1)
      {
        paramLinkedList = getRadarTips();
        str = getContext().getString(a.g.net_warn_no_network);
        s.s(str, "context.getString(R.string.net_warn_no_network)");
        paramLinkedList.aSy(str);
        AppMethodBeat.o(138771);
        return;
      }
      paramLinkedList = getRadarTips();
      String str = getContext().getString(a.g.Nrk);
      s.s(str, "context.getString(R.string.radar_tips_network_err)");
      paramLinkedList.aSy(str);
      AppMethodBeat.o(138771);
      return;
    }
    bL(paramLinkedList);
    AppMethodBeat.o(138771);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(138767);
    if (paramBoolean)
    {
      d(paramString2, b.e.NrE);
      paramString1 = this.Nuk;
      if (paramString1 != null) {
        break label146;
      }
      s.bIx("radarManager");
      paramString1 = localObject;
    }
    label146:
    for (;;)
    {
      paramString1.Nsb.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138767);
      return;
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.aSy(paramString2);
      paramString2 = this.Nuk;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        s.bIx("radarManager");
        paramString1 = null;
      }
      paramString1 = (d.c)paramString1.Nsb.get(Long.valueOf(paramLong));
      if (paramString1 == null) {
        break;
      }
      paramString2 = d.Nua;
      d(d.a(paramString1.Nsl), paramString1.Nsm);
      break;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(138766);
    if (paramBoolean1)
    {
      d(paramString2, b.e.NrE);
      paramString1 = this.Nuk;
      if (paramString1 != null) {
        break label190;
      }
      s.bIx("radarManager");
      paramString1 = localObject;
    }
    label190:
    for (;;)
    {
      paramString1.Nsb.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(138766);
      return;
      if (paramBoolean2)
      {
        d(paramString2, b.e.NrD);
        break;
      }
      RadarTipsView localRadarTipsView = getRadarTips();
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "";
      }
      localRadarTipsView.aSy(paramString2);
      paramString2 = this.Nuk;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        s.bIx("radarManager");
        paramString1 = null;
      }
      paramString1 = (d.c)paramString1.Nsb.get(Long.valueOf(paramLong));
      if (paramString1 == null) {
        break;
      }
      paramString2 = d.Nua;
      d(d.a(paramString1.Nsl), paramString1.Nsm);
      paramString2 = d.Nua;
      d(d.b(paramString1.Nsl), paramString1.Nsm);
      break;
    }
  }
  
  public final void as(au paramau)
  {
    AppMethodBeat.i(138769);
    s.u(paramau, "contact");
    if (getMemberDetailView().isShowing())
    {
      RadarMemberView localRadarMemberView = getMemberDetailView();
      String str = paramau.field_encryptUsername;
      s.s(str, "contact.encryptUsername");
      localRadarMemberView.c(str, b.e.NrE);
    }
    d(paramau.field_username, b.e.NrE);
    d(paramau.field_encryptUsername, b.e.NrE);
    AppMethodBeat.o(138769);
  }
  
  public final void at(au paramau)
  {
    String str1 = null;
    AppMethodBeat.i(138768);
    s.u(paramau, "contact");
    Object localObject2 = this.Nuk;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("radarManager");
      localObject1 = null;
    }
    localObject2 = paramau.field_username;
    s.s(localObject2, "contact.username");
    if (((com.tencent.mm.plugin.radar.model.d)localObject1).aSx((String)localObject2) == null)
    {
      localObject1 = this.Nuk;
      if (localObject1 != null) {
        break label265;
      }
      s.bIx("radarManager");
      localObject1 = str1;
    }
    label265:
    for (;;)
    {
      str1 = paramau.field_encryptUsername;
      s.s(str1, "contact.encryptUsername");
      if (((com.tencent.mm.plugin.radar.model.d)localObject1).aSx(str1) == null)
      {
        localObject1 = new LinkedList();
        str1 = paramau.field_username;
        s.s(str1, "contact.username");
        localObject2 = paramau.field_encryptUsername;
        s.s(localObject2, "contact.encryptUsername");
        String str2 = paramau.field_nickname;
        s.s(str2, "contact.nickname");
        ell localell = new ell();
        localell.abpV = 100;
        localell.UserName = str1;
        localell.vhX = str2;
        localell.Zui = "";
        localell.Zyp = ((String)localObject2);
        ((LinkedList)localObject1).add(localell);
        bL((LinkedList)localObject1);
      }
      if (getMemberDetailView().isShowing())
      {
        localObject1 = getMemberDetailView();
        str1 = paramau.field_encryptUsername;
        s.s(str1, "contact.encryptUsername");
        ((RadarMemberView)localObject1).c(str1, b.e.NrF);
      }
      d(paramau.field_username, b.e.NrF);
      d(paramau.field_encryptUsername, b.e.NrF);
      AppMethodBeat.o(138768);
      return;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<Object> paramLinkedList)
  {
    AppMethodBeat.i(138772);
    a(d.e.Nsn);
    paramLinkedList = getRadarTips();
    String str = getContext().getString(a.g.Nrk);
    s.s(str, "context.getString(R.string.radar_tips_network_err)");
    paramLinkedList.aSy(str);
    AppMethodBeat.o(138772);
  }
  
  public final void gEZ()
  {
    AppMethodBeat.i(138763);
    com.tencent.mm.plugin.radar.model.d locald2 = this.Nuk;
    com.tencent.mm.plugin.radar.model.d locald1 = locald2;
    if (locald2 == null)
    {
      s.bIx("radarManager");
      locald1 = null;
    }
    locald1.gEZ();
    AppMethodBeat.o(138763);
  }
  
  final RadarSpecialGridView getGrid()
  {
    AppMethodBeat.i(138756);
    RadarSpecialGridView localRadarSpecialGridView = (RadarSpecialGridView)this.Nue.getValue();
    AppMethodBeat.o(138756);
    return localRadarSpecialGridView;
  }
  
  final RadarMemberView getMemberDetailView()
  {
    AppMethodBeat.i(138755);
    RadarMemberView localRadarMemberView = (RadarMemberView)this.Nud.getValue();
    AppMethodBeat.o(138755);
    return localRadarMemberView;
  }
  
  final Button getQuitBtn()
  {
    AppMethodBeat.i(138760);
    Button localButton = (Button)this.Nui.getValue();
    AppMethodBeat.o(138760);
    return localButton;
  }
  
  public final d.e getRadarStatus()
  {
    return this.Nun;
  }
  
  final RadarTipsView getRadarTips()
  {
    AppMethodBeat.i(138757);
    RadarTipsView localRadarTipsView = (RadarTipsView)this.Nuf.getValue();
    AppMethodBeat.o(138757);
    return localRadarTipsView;
  }
  
  final RadarWaveView getWaveView()
  {
    AppMethodBeat.i(138754);
    Object localObject = this.Nuc.getValue();
    s.s(localObject, "<get-waveView>(...)");
    localObject = (RadarWaveView)localObject;
    AppMethodBeat.o(138754);
    return localObject;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138764);
    s.u(paramKeyEvent, "event");
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
    com.tencent.mm.plugin.radar.model.d locald2 = this.Nuk;
    com.tencent.mm.plugin.radar.model.d locald1 = locald2;
    if (locald2 == null)
    {
      s.bIx("radarManager");
      locald1 = null;
    }
    locald1.onResume();
    AppMethodBeat.o(138762);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    private int Nut;
    final boolean Nuu;
    private final a Nuv;
    
    public a()
    {
      AppMethodBeat.i(138736);
      this$1 = d.Nua;
      this$1 = this.Nuw.getContext();
      s.s(this$1, "context");
      this.Nuu = d.jn(this$1);
      this.Nuv = new a(this);
      AppMethodBeat.o(138736);
    }
    
    private final int iG(View paramView)
    {
      AppMethodBeat.i(138735);
      paramView = paramView.getTag(RadarViewController.f(this.Nuw));
      if ((paramView instanceof Integer)) {}
      for (paramView = (Integer)paramView; paramView == null; paramView = null)
      {
        AppMethodBeat.o(138735);
        return -1;
      }
      int i = paramView.intValue();
      AppMethodBeat.o(138735);
      return i;
    }
    
    public final void cX(View paramView)
    {
      AppMethodBeat.i(138734);
      s.u(paramView, "view");
      int i = iG(paramView);
      if (i > 0) {
        this.Nuv.removeMessages(i);
      }
      paramView.clearAnimation();
      AppMethodBeat.o(138734);
    }
    
    public final Animation gFt()
    {
      AppMethodBeat.i(138732);
      Animation localAnimation = AnimationUtils.loadAnimation(this.Nuw.getContext(), a.a.Nqq);
      s.s(localAnimation, "loadAnimation(context, R.anim.radar_user_turn_out)");
      AppMethodBeat.o(138732);
      return localAnimation;
    }
    
    public final int gFu()
    {
      this.Nut += 1;
      return this.Nut;
    }
    
    public final void t(int paramInt, View paramView)
    {
      AppMethodBeat.i(138733);
      s.u(paramView, "view");
      Message localMessage = this.Nuv.obtainMessage();
      localMessage.what = iG(paramView);
      localMessage.obj = paramView;
      paramView.setVisibility(4);
      this.Nuv.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
      AppMethodBeat.o(138733);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends MMHandler
    {
      a(RadarViewController.a parama) {}
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(138731);
        s.u(paramMessage, "msg");
        View localView;
        if ((paramMessage.obj instanceof View))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new NullPointerException("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(138731);
            throw paramMessage;
          }
          localView = (View)paramMessage;
          localView.setVisibility(0);
          localView.clearAnimation();
          if (!this.Nux.Nuu)
          {
            paramMessage = localView.getTag(RadarViewController.g(this.Nux.Nuw));
            if (!(paramMessage instanceof Animation)) {
              break label123;
            }
          }
        }
        label123:
        for (paramMessage = (Animation)paramMessage;; paramMessage = null)
        {
          Object localObject = paramMessage;
          if (paramMessage == null) {
            localObject = this.Nux.gFt();
          }
          localView.startAnimation((Animation)localObject);
          AppMethodBeat.o(138731);
          return;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends a
  {
    HashMap<String, Integer> NuA;
    private final RadarViewController.a NuB;
    private int NuC;
    HashMap<String, View> NuD;
    private boolean NuE;
    ell[] Nuy;
    HashMap<String, String> Nuz;
    private final Context context;
    
    public c(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(138743);
      this.context = localObject;
      this.Nuy = new ell[12];
      this.Nuz = new HashMap();
      this.NuA = new HashMap();
      this.NuD = new HashMap();
      this.NuB = new RadarViewController.a(RadarViewController.this);
      AppMethodBeat.o(138743);
    }
    
    private final View aL(View paramView, int paramInt)
    {
      AppMethodBeat.i(138741);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, a.e.NqY, null);
        s.checkNotNull(localView);
        localView.setTag(RadarViewController.f(RadarViewController.this), Integer.valueOf(this.NuB.gFu()));
        localView.setTag(RadarViewController.g(RadarViewController.this), this.NuB.gFt());
      }
      localView.findViewById(a.d.NqL).setVisibility(8);
      localView.findViewById(a.d.NqM).setVisibility(8);
      localView.findViewById(a.d.NqN).setVisibility(4);
      localView.findViewById(a.d.NqF).setVisibility(4);
      localView.findViewById(a.d.NqE).setVisibility(4);
      if ((paramInt == 7) || (paramInt % 3 == 1))
      {
        localView.findViewById(a.d.Nqt).setVisibility(0);
        localView.findViewById(a.d.NqX).setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(138741);
        return localView;
        localView.findViewById(a.d.NqX).setVisibility(0);
        localView.findViewById(a.d.Nqt).setVisibility(8);
      }
    }
    
    public final View aK(View paramView, int paramInt)
    {
      AppMethodBeat.i(138739);
      Log.d(RadarViewController.access$getTAG$cp(), "getview RadarStatus%s", new Object[] { RadarViewController.this.getRadarStatus() });
      ell localell = (ell)this.Nuy[paramInt];
      Object localObject1;
      int i;
      label97:
      label103:
      String str;
      Object localObject2;
      if (localell != null)
      {
        localObject1 = (CharSequence)localell.UserName;
        if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label234;
          }
          localObject1 = (CharSequence)localell.Zyp;
          if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
            break label229;
          }
          i = 1;
          if (i == 0) {
            break label234;
          }
          i = 1;
          if (i != 0) {
            break label1702;
          }
          localObject1 = d.Nua;
          str = d.a(localell);
          localObject2 = RadarViewController.this.getRadarStatus();
          if (paramView != null) {
            break label1712;
          }
          localObject1 = View.inflate(this.context, a.e.NqY, null);
          s.checkNotNull(localObject1);
          ((View)localObject1).setTag(RadarViewController.f(RadarViewController.this), Integer.valueOf(this.NuB.gFu()));
          ((View)localObject1).setTag(RadarViewController.g(RadarViewController.this), this.NuB.gFt());
        }
      }
      for (;;)
      {
        Object localObject3 = ((View)localObject1).findViewById(a.d.NqL);
        if (localObject3 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
          i = 0;
          break;
          label229:
          i = 0;
          break label97;
          label234:
          i = 0;
          break label103;
        }
        localObject3 = (ImageView)localObject3;
        Object localObject4 = ((View)localObject1).findViewById(a.d.NqF);
        if (localObject4 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject4 = (RadarStateView)localObject4;
        Object localObject5 = ((View)localObject1).findViewById(a.d.NqN);
        if (localObject5 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject5 = (TextView)localObject5;
        Object localObject6 = ((View)localObject1).findViewById(a.d.NqM);
        if (localObject6 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject6 = (ImageView)localObject6;
        Object localObject7 = ((View)localObject1).findViewById(a.d.NqE);
        if (localObject7 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
          AppMethodBeat.o(138739);
          throw paramView;
        }
        localObject7 = (RadarStateChooseView)localObject7;
        ((ImageView)localObject3).setVisibility(0);
        ((RadarStateView)localObject4).setVisibility(0);
        ((TextView)localObject5).setVisibility(0);
        ((ImageView)localObject6).setVisibility(0);
        if ((localObject2 == d.e.Nsn) || (localObject2 == d.e.Nso))
        {
          ((RadarStateView)localObject4).setVisibility(0);
          ((RadarStateChooseView)localObject7).setVisibility(8);
          ((View)localObject1).setTag(new a((TextView)localObject5, (ImageView)localObject3, (RadarStateView)localObject4, (RadarStateChooseView)localObject7, (ImageView)localObject6));
          if ((paramInt != 7) && (paramInt % 3 != 1)) {
            break label588;
          }
          ((View)localObject1).findViewById(a.d.Nqt).setVisibility(0);
          ((View)localObject1).findViewById(a.d.NqX).setVisibility(8);
        }
        for (;;)
        {
          if ((paramView == null) || (localObject1 != paramView)) {
            this.NuD.put(str, localObject1);
          }
          localObject2 = ((View)localObject1).getTag();
          if (localObject2 != null) {
            break label616;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138739);
          throw paramView;
          ((RadarStateView)localObject4).setVisibility(8);
          ((RadarStateChooseView)localObject7).setVisibility(0);
          break;
          label588:
          ((View)localObject1).findViewById(a.d.NqX).setVisibility(0);
          ((View)localObject1).findViewById(a.d.Nqt).setVisibility(8);
        }
        label616:
        localObject4 = (a)localObject2;
        ((a)localObject4).NuF.setText((CharSequence)p.b(RadarViewController.this.getContext(), (CharSequence)localell.vhX, ((a)localObject4).NuF.getTextSize()));
        localObject2 = b.a.NsB;
        b.a.g(((a)localObject4).NuG, str);
        localObject2 = ((View)localObject1).findViewById(a.d.Nqv);
        s.s(localObject2, "view.findViewById(R.id.radar_avatar_container)");
        ((View)localObject2).setTag(new RadarViewController.d(RadarViewController.this, localell));
        boolean bool;
        if ((RadarViewController.this.getRadarStatus() == d.e.Nsn) || (RadarViewController.this.getRadarStatus() == d.e.Nso))
        {
          ((a)localObject4).NuJ.setBackgroundResource(a.c.Nqs);
          paramView = ((a)localObject4).NuH;
          paramView.Ntu = true;
          paramView.gFk();
          paramView = ((a)localObject4).NuI;
          paramView.Ntq = false;
          paramView.setVisibility(8);
          localObject2 = RadarViewController.b(RadarViewController.this);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            s.bIx("radarManager");
            paramView = null;
          }
          localObject2 = com.tencent.mm.plugin.radar.model.d.a(paramView, localell);
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            localObject2 = RadarViewController.a(RadarViewController.this).aSw(str);
            localObject3 = RadarViewController.b(RadarViewController.this);
            paramView = (View)localObject3;
            if (localObject3 == null)
            {
              s.bIx("radarManager");
              paramView = null;
            }
            s.u(localell, "member");
            s.u(localObject2, "state");
            localObject3 = localell.UserName;
            s.s(localObject3, "member.UserName");
            paramView.b((String)localObject3, (b.e)localObject2);
            localObject3 = localell.Zyp;
            s.s(localObject3, "member.EncodeUserName");
            paramView.b((String)localObject3, (b.e)localObject2);
            paramView = (View)localObject2;
          }
          localObject3 = RadarViewController.b(RadarViewController.this);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("radarManager");
            localObject2 = null;
          }
          localObject3 = ((com.tencent.mm.plugin.radar.model.d)localObject2).a(localell, true);
          localObject5 = ((a)localObject4).NuH;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = b.e.NrC;
          }
          s.u(localObject2, "state");
          ((RadarStateView)localObject5).init();
          ((RadarStateView)localObject5).Ntv.removeMessages(0);
          ((RadarStateView)localObject5).clearAnimation();
          ((RadarStateView)localObject5).Nsm = ((b.e)localObject2);
          ((RadarStateView)localObject5).fhR = false;
          ((RadarStateView)localObject5).gFk();
          localObject2 = ((a)localObject4).NuH;
          s.u(paramView, "state");
          ((RadarStateView)localObject2).init();
          Log.d(RadarStateView.TAG, s.X(" turnToState : ", paramView));
          bool = false;
          if (((RadarStateView)localObject2).Nsm == paramView)
          {
            ((RadarStateView)localObject2).gFk();
            localObject2 = RadarViewController.b(RadarViewController.this);
            paramView = (View)localObject2;
            if (localObject2 == null)
            {
              s.bIx("radarManager");
              paramView = null;
            }
            s.u(localell, "member");
            localObject2 = localell.UserName;
            s.s(localObject2, "member.UserName");
            paramView.a((String)localObject2, null);
            localObject2 = localell.Zyp;
            s.s(localObject2, "member.EncodeUserName");
            paramView.a((String)localObject2, null);
            if (paramInt == 0) {
              this.NuC = this.NuA.size();
            }
            paramView = (View)localObject1;
            if (this.NuA.remove(str) != null)
            {
              this.NuB.t(this.NuC - this.NuA.size(), (View)localObject1);
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
              ((RadarStateView)localObject2).gFm();
              bool = true;
            }
            Log.d(RadarStateView.TAG, s.X(" delay : ", Boolean.valueOf(bool)));
            ((RadarStateView)localObject2).Nsm = paramView;
            if (((RadarStateView)localObject2).Nsm == b.e.NrC) {
              break;
            }
            if (bool) {
              break label1294;
            }
            ((RadarStateView)localObject2).Ntv.sendEmptyMessage(0);
            break;
          }
          label1294:
          ((RadarStateView)localObject2).Ntv.sendEmptyMessageDelayed(0, RadarStateView.Ntx + 20);
          break;
          localObject3 = RadarViewController.b(RadarViewController.this);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("radarManager");
            localObject2 = null;
          }
          localObject2 = ((com.tencent.mm.plugin.radar.model.d)localObject2).NrY;
          localObject3 = d.Nua;
          if (!Util.isNullOrNil((String)((Map)localObject2).get(d.b(localell))))
          {
            paramView = ((a)localObject4).NuH;
            paramView.Ntu = false;
            paramView.setVisibility(8);
            paramView = ((a)localObject4).NuI;
            paramView.Ntq = true;
            paramView.gFk();
            localObject2 = RadarViewController.b(RadarViewController.this);
            paramView = (View)localObject2;
            if (localObject2 == null)
            {
              s.bIx("radarManager");
              paramView = null;
            }
            if (localell == null)
            {
              paramView = null;
              label1438:
              localObject2 = paramView;
              if (paramView == null) {
                localObject2 = d.a.Nsj;
              }
              if (localObject2 != d.a.Nsj) {
                ((a)localObject4).NuJ.setBackgroundDrawable(null);
              }
              paramView = ((a)localObject4).NuI;
              s.u(localObject2, "status");
              if (paramView.Ntr != localObject2)
              {
                paramView.Ntr = ((d.a)localObject2);
                localObject2 = paramView.Ntr;
                switch (RadarStateChooseView.b.$EnumSwitchMapping$0[localObject2.ordinal()])
                {
                }
              }
            }
            for (;;)
            {
              if (paramInt == 0) {
                this.NuC = this.NuA.size();
              }
              localObject2 = this.NuA;
              paramView = d.Nua;
              paramView = (View)localObject1;
              if (((HashMap)localObject2).remove(d.b(localell)) == null) {
                break;
              }
              this.NuB.t(this.NuC - this.NuA.size(), (View)localObject1);
              paramView = (View)localObject1;
              break;
              localObject2 = d.Nua;
              localObject2 = d.a(localell);
              localObject2 = (d.a)paramView.Nsc.get(localObject2);
              paramView = (View)localObject2;
              if (localObject2 != null) {
                break label1438;
              }
              paramView = d.a.Nsj;
              break label1438;
              if (paramView.Ntq)
              {
                paramView.gFk();
                paramView.fhR = true;
                paramView.startAnimation(paramView.getSlideOutAnim());
                continue;
                if (paramView.Ntq)
                {
                  paramView.gFk();
                  paramView.startAnimation(paramView.getSlideInAnim());
                }
              }
            }
          }
          paramView = aL(paramView, paramInt);
          continue;
          label1702:
          paramView = aL(paramView, paramInt);
        }
        label1712:
        localObject1 = paramView;
      }
    }
    
    public final void bN(LinkedList<ell> paramLinkedList)
    {
      AppMethodBeat.i(138738);
      if ((paramLinkedList != null) && (paramLinkedList.size() == 0)) {}
      for (int i = 1; (i != 0) || (paramLinkedList == null); i = 0)
      {
        AppMethodBeat.o(138738);
        return;
      }
      Object localObject1 = (c)this;
      int j = ((c)localObject1).Nuy.length;
      i = 0;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      while (i < j)
      {
        localObject2 = paramLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ell)((Iterator)localObject2).next();
          localObject4 = d.Nua;
          localObject4 = d.b((ell)localObject3);
          d locald = d.Nua;
          if (s.p(localObject4, d.b(localObject1.Nuy[i]))) {
            paramLinkedList.remove(localObject3);
          }
        }
        i += 1;
      }
      localObject1 = paramLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ell)((Iterator)localObject1).next();
        int k = Math.abs((int)System.currentTimeMillis() % 6);
        int m = this.Nuy.length - 1;
        if (m >= 0) {
          for (i = 0;; i = j)
          {
            j = i + 1;
            int n = (i + k) % 12;
            switch (n)
            {
            case 5: 
            case 6: 
            default: 
              localObject3 = this.Nuy[n];
              if (localObject3 != null)
              {
                localObject4 = (CharSequence)((ell)localObject3).UserName;
                if ((localObject4 != null) && (!n.bp((CharSequence)localObject4))) {
                  break label364;
                }
                i = 1;
                label279:
                if (i == 0) {
                  break label374;
                }
                localObject3 = (CharSequence)((ell)localObject3).Zyp;
                if ((localObject3 != null) && (!n.bp((CharSequence)localObject3))) {
                  break label369;
                }
                i = 1;
                label308:
                if (i == 0) {
                  break label374;
                }
              }
              label364:
              label369:
              label374:
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label379;
                }
                this.Nuy[n] = localObject2;
                localObject3 = this.NuA;
                localObject4 = d.Nua;
                s.s(localObject2, "member");
                ((HashMap)localObject3).put(d.a((ell)localObject2), Integer.valueOf(0));
                break;
                i = 0;
                break label279;
                i = 0;
                break label308;
              }
            }
            label379:
            if (j > m) {
              break;
            }
          }
        }
      }
      if (paramLinkedList.size() > 0)
      {
        cPy();
        localObject1 = c.NrL;
        i = paramLinkedList.size();
        if ((c.hQS == 0) && (i > 0))
        {
          float f = (float)(c.gEY() - c.NrP) * 1.0F / 1000.0F;
          Log.d(c.TAG, "FoundFirstFriendTimeSpent %s", new Object[] { Float.valueOf(f) });
          paramLinkedList = h.OAn;
          localObject1 = am.aixg;
          localObject1 = String.format("%s", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
          s.s(localObject1, "java.lang.String.format(format, *args)");
          paramLinkedList.kvStat(10682, (String)localObject1);
        }
        c.hQS += i;
        c.NrQ = i + c.NrQ;
      }
      AppMethodBeat.o(138738);
    }
    
    public final void c(ell paramell)
    {
      Object localObject1 = null;
      AppMethodBeat.i(138742);
      if (paramell != null)
      {
        localObject2 = (CharSequence)paramell.UserName;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label81;
        }
        i = 1;
        if (i == 0) {
          break label91;
        }
        localObject2 = (CharSequence)paramell.Zyp;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label86;
        }
        i = 1;
        label64:
        if (i == 0) {
          break label91;
        }
      }
      label81:
      label86:
      label91:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label96;
        }
        AppMethodBeat.o(138742);
        return;
        i = 0;
        break;
        i = 0;
        break label64;
      }
      label96:
      Object localObject2 = d.Nua;
      s.checkNotNull(paramell);
      localObject2 = d.a(paramell);
      com.tencent.mm.plugin.radar.model.d locald = RadarViewController.b(RadarViewController.this);
      paramell = locald;
      if (locald == null)
      {
        s.bIx("radarManager");
        paramell = null;
      }
      if (paramell.NrY.containsKey(localObject2))
      {
        paramell = RadarViewController.b(RadarViewController.this);
        if (paramell == null)
        {
          s.bIx("radarManager");
          paramell = localObject1;
        }
        for (;;)
        {
          paramell = paramell.NrY.get(localObject2);
          if (paramell != null) {
            break;
          }
          paramell = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(138742);
          throw paramell;
        }
      }
      for (paramell = (String)paramell;; paramell = (ell)localObject2)
      {
        this.Nuz.put(paramell, paramell);
        AppMethodBeat.o(138742);
        return;
      }
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(138740);
      this.NuA.clear();
      this.NuD.clear();
      Iterator localIterator = this.NuD.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (View)this.NuD.get(localObject);
        if (localObject != null) {
          this.NuB.cX((View)localObject);
        }
      }
      cPy();
      AppMethodBeat.o(138740);
    }
    
    public final void d(ell paramell)
    {
      Object localObject1 = null;
      AppMethodBeat.i(267278);
      if (paramell != null)
      {
        localObject2 = (CharSequence)paramell.UserName;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label81;
        }
        i = 1;
        if (i == 0) {
          break label91;
        }
        localObject2 = (CharSequence)paramell.Zyp;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label86;
        }
        i = 1;
        label64:
        if (i == 0) {
          break label91;
        }
      }
      label81:
      label86:
      label91:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label96;
        }
        AppMethodBeat.o(267278);
        return;
        i = 0;
        break;
        i = 0;
        break label64;
      }
      label96:
      Object localObject2 = d.Nua;
      s.checkNotNull(paramell);
      localObject2 = d.a(paramell);
      com.tencent.mm.plugin.radar.model.d locald = RadarViewController.b(RadarViewController.this);
      paramell = locald;
      if (locald == null)
      {
        s.bIx("radarManager");
        paramell = null;
      }
      if (paramell.NrY.containsKey(localObject2))
      {
        paramell = RadarViewController.b(RadarViewController.this);
        if (paramell == null)
        {
          s.bIx("radarManager");
          paramell = localObject1;
        }
        for (;;)
        {
          paramell = paramell.NrY.get(localObject2);
          if (paramell != null) {
            break;
          }
          paramell = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(267278);
          throw paramell;
        }
      }
      for (paramell = (String)paramell;; paramell = (ell)localObject2)
      {
        this.Nuz.remove(paramell);
        AppMethodBeat.o(267278);
        return;
      }
    }
    
    public final boolean gFd()
    {
      return true;
    }
    
    public final LinkedList<ell> gFv()
    {
      AppMethodBeat.i(267259);
      LinkedList localLinkedList = new LinkedList();
      int k = this.Nuy.length;
      int i = 0;
      if (k > 0) {}
      for (;;)
      {
        int j = i + 1;
        ell localell = this.Nuy[i];
        if (localell != null) {
          localLinkedList.add(localell);
        }
        if (j >= k)
        {
          AppMethodBeat.o(267259);
          return localLinkedList;
        }
        i = j;
      }
    }
    
    public final int getCount()
    {
      if (this.NuE) {
        return 0;
      }
      return this.Nuy.length;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
    {
      TextView NuF;
      ImageView NuG;
      RadarStateView NuH;
      RadarStateChooseView NuI;
      ImageView NuJ;
      
      public a(ImageView paramImageView1, RadarStateView paramRadarStateView, RadarStateChooseView paramRadarStateChooseView, ImageView paramImageView2)
      {
        AppMethodBeat.i(138737);
        this.NuF = paramImageView1;
        this.NuG = paramRadarStateView;
        this.NuH = paramRadarStateChooseView;
        this.NuI = paramImageView2;
        this.NuJ = localObject;
        AppMethodBeat.o(138737);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements RadarSpecialGridView.a
  {
    g(RadarViewController paramRadarViewController) {}
    
    private static final void a(RadarViewController paramRadarViewController, View paramView, ell paramell, b.e parame)
    {
      AppMethodBeat.i(267246);
      s.u(paramRadarViewController, "this$0");
      s.u(paramView, "$view");
      s.u(paramell, "$member");
      RadarViewController.e(paramRadarViewController).a(paramView, paramell, parame);
      RadarViewController.d(paramRadarViewController).gFx();
      AppMethodBeat.o(267246);
    }
    
    public final void c(int paramInt, View paramView)
    {
      int i = 1;
      Object localObject2 = null;
      String str = null;
      AppMethodBeat.i(138751);
      s.u(paramView, "view");
      Object localObject3 = RadarViewController.c(this.Nuw);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("adapter");
        localObject1 = null;
      }
      ell localell = (ell)localObject1.Nuy[paramInt];
      if (localell == null)
      {
        AppMethodBeat.o(138751);
        return;
      }
      localObject1 = this.Nuw.getRadarStatus();
      switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        Log.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[] { this.Nuw.getRadarStatus() });
      case 1: 
      case 2: 
        label206:
        label212:
        do
        {
          AppMethodBeat.o(138751);
          return;
          localObject1 = d.Nua;
          localObject3 = d.a(localell);
          localObject1 = (CharSequence)localell.UserName;
          if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
            break;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label341;
          }
          localObject1 = (CharSequence)localell.Zyp;
          if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
            break label336;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label341;
          }
          paramInt = i;
        } while (paramInt != 0);
        localObject2 = RadarViewController.c(this.Nuw);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("adapter");
          localObject1 = null;
        }
        localObject2 = (View)((RadarViewController.c)localObject1).NuD.get(localObject3);
        localObject1 = RadarViewController.b(this.Nuw);
        if (localObject1 == null)
        {
          s.bIx("radarManager");
          localObject1 = str;
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.radar.model.d.a((com.tencent.mm.plugin.radar.model.d)localObject1, localell);
          if ((localObject2 == null) || (localObject1 == b.e.NrC)) {
            break label408;
          }
          localObject2 = ((View)localObject2).getTag();
          if (localObject2 != null) {
            break label349;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
          AppMethodBeat.o(138751);
          throw paramView;
          paramInt = 0;
          break;
          label336:
          paramInt = 0;
          break label206;
          label341:
          paramInt = 0;
          break label212;
        }
        label349:
        ((RadarViewController.c.a)localObject2).NuH.gFm();
        localObject2 = new MMHandler();
        paramView = new RadarViewController.g..ExternalSyntheticLambda0(this.Nuw, paramView, localell, (b.e)localObject1);
        localObject1 = RadarStateView.Ntt;
        ((MMHandler)localObject2).postDelayed(paramView, RadarStateView.gFn());
        AppMethodBeat.o(138751);
        return;
        label408:
        RadarViewController.e(this.Nuw).a(paramView, localell, (b.e)localObject1);
        RadarViewController.d(this.Nuw).gFx();
        AppMethodBeat.o(138751);
        return;
      }
      paramView = (CharSequence)localell.UserName;
      if ((paramView == null) || (n.bp(paramView)))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label646;
        }
        paramView = (CharSequence)localell.Zyp;
        if ((paramView != null) && (!n.bp(paramView))) {
          break label641;
        }
        paramInt = 1;
        label487:
        if (paramInt == 0) {
          break label646;
        }
        paramInt = 1;
        label493:
        if (paramInt != 0) {
          break label709;
        }
        paramView = RadarViewController.c(this.Nuw);
        if (paramView != null) {
          break label651;
        }
        s.bIx("adapter");
        paramView = null;
      }
      label641:
      label646:
      label651:
      for (;;)
      {
        if (localell == null) {
          break label809;
        }
        localObject1 = d.Nua;
        str = d.a(localell);
        localObject3 = RadarViewController.b(paramView.Nuw);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("radarManager");
          localObject1 = null;
        }
        if (!((com.tencent.mm.plugin.radar.model.d)localObject1).NrY.containsKey(str)) {
          break label868;
        }
        localObject3 = RadarViewController.b(paramView.Nuw);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("radarManager");
          localObject1 = null;
        }
        localObject1 = ((com.tencent.mm.plugin.radar.model.d)localObject1).NrY.get(str);
        if (localObject1 != null) {
          break label654;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(138751);
        throw paramView;
        paramInt = 0;
        break;
        paramInt = 0;
        break label487;
        paramInt = 0;
        break label493;
      }
      label654:
      label709:
      label847:
      label865:
      label868:
      for (localObject1 = (String)localObject1;; localObject1 = str)
      {
        if (paramView.Nuz.containsKey(localObject1))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label814;
          }
          localObject1 = RadarViewController.c(this.Nuw);
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            s.bIx("adapter");
            paramView = null;
          }
          paramView.c(localell);
          localObject1 = RadarViewController.b(this.Nuw);
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            s.bIx("radarManager");
            paramView = null;
          }
          if (localell != null)
          {
            localObject1 = d.Nua;
            localObject1 = d.a(localell);
            if (!paramView.Nsc.containsKey(localObject1)) {
              break label847;
            }
            paramView.Nsc.remove(localObject1);
          }
          RadarViewController.gFs();
          paramView = RadarViewController.c(this.Nuw);
          if (paramView != null) {
            break label865;
          }
          s.bIx("adapter");
          paramView = (View)localObject2;
        }
        for (;;)
        {
          paramView.cPy();
          AppMethodBeat.o(138751);
          return;
          paramInt = 0;
          break;
          localObject1 = RadarViewController.c(this.Nuw);
          paramView = (View)localObject1;
          if (localObject1 == null)
          {
            s.bIx("adapter");
            paramView = null;
          }
          paramView.d(localell);
          break label709;
          paramView.Nsc.put(localObject1, d.a.Nsi);
          break label776;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<RadarWaveView>
  {
    h(RadarViewController paramRadarViewController)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController
 * JD-Core Version:    0.7.0.1
 */