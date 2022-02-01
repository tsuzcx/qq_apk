package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.model.b.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.f.f;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarMemberView
  extends RelativeLayout
{
  public static final RadarMemberView.a NsD;
  private static final int NsT = 0;
  private static final int NsU;
  private static final String TAG;
  private TextView DSB;
  private TextView NaQ;
  private View NsE;
  private final j NsF;
  private final j NsG;
  private final j NsH;
  private final j NsI;
  private final j NsJ;
  private final j NsK;
  private final j NsL;
  private final j NsM;
  private int[] NsN;
  private final j NsO;
  private cr NsP;
  private b NsQ;
  private final View.OnClickListener NsR;
  private final e NsS;
  private ell Nsl;
  private b.e Nsm;
  private au contact;
  private View pRt;
  private com.tencent.mm.ui.widget.a.e pRv;
  private boolean pzm;
  private EditText tID;
  
  static
  {
    AppMethodBeat.i(138609);
    NsD = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    NsU = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.NsF = e.aM((View)this, a.d.NqJ);
    this.NsG = e.aM((View)this, a.d.Nqw);
    this.NsH = e.aM((View)this, a.d.Nqv);
    this.NsI = e.aM((View)this, a.d.Nqy);
    this.NsJ = e.aM((View)this, a.d.Nqz);
    this.NsK = e.aM((View)this, a.d.NqD);
    this.NsL = e.aM((View)this, a.d.NqC);
    this.NsM = e.aM((View)this, a.d.NqP);
    this.NsO = e.aM((View)this, a.d.Nqu);
    this.NsR = new RadarMemberView..ExternalSyntheticLambda2(this);
    this.NsS = new e(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.NsF = e.aM((View)this, a.d.NqJ);
    this.NsG = e.aM((View)this, a.d.Nqw);
    this.NsH = e.aM((View)this, a.d.Nqv);
    this.NsI = e.aM((View)this, a.d.Nqy);
    this.NsJ = e.aM((View)this, a.d.Nqz);
    this.NsK = e.aM((View)this, a.d.NqD);
    this.NsL = e.aM((View)this, a.d.NqC);
    this.NsM = e.aM((View)this, a.d.NqP);
    this.NsO = e.aM((View)this, a.d.Nqu);
    this.NsR = new RadarMemberView..ExternalSyntheticLambda2(this);
    this.NsS = new e(this);
    AppMethodBeat.o(138627);
  }
  
  private final void a(b.e parame)
  {
    AppMethodBeat.i(138621);
    getExposeTv().setVisibility(0);
    int i;
    if (parame == null)
    {
      i = -1;
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138621);
      return;
      i = RadarMemberView.c.$EnumSwitchMapping$0[parame.ordinal()];
      break;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(a.g.Nri);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.g.Nrm);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.g.Nrb);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(a.g.Nra);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setText((CharSequence)getContext().getString(a.g.NqP));
      getSayHiTv().setVisibility(0);
    }
  }
  
  private static final void a(RadarMemberView paramRadarMemberView)
  {
    AppMethodBeat.i(267277);
    s.u(paramRadarMemberView, "this$0");
    Object localObject;
    if ((paramRadarMemberView.getContext() instanceof Activity))
    {
      paramRadarMemberView = paramRadarMemberView.getContext();
      if (paramRadarMemberView == null)
      {
        paramRadarMemberView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(267277);
        throw paramRadarMemberView;
      }
      localObject = (Activity)paramRadarMemberView;
      s.u(localObject, "ac");
      paramRadarMemberView = ((Activity)localObject).getSystemService("input_method");
      if (!(paramRadarMemberView instanceof InputMethodManager)) {
        break label116;
      }
    }
    label116:
    for (paramRadarMemberView = (InputMethodManager)paramRadarMemberView;; paramRadarMemberView = null)
    {
      if (paramRadarMemberView != null)
      {
        localObject = ((Activity)localObject).getCurrentFocus();
        if ((localObject != null) && (((View)localObject).getWindowToken() != null)) {
          paramRadarMemberView.toggleSoftInput(0, 2);
        }
      }
      AppMethodBeat.o(267277);
      return;
    }
  }
  
  private static final void a(RadarMemberView paramRadarMemberView, DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(267270);
    s.u(paramRadarMemberView, "this$0");
    if (paramRadarMemberView.pRv != null)
    {
      paramDialogInterface = paramRadarMemberView.pRv;
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      paramRadarMemberView.pRv = null;
    }
    label81:
    label94:
    String str;
    label143:
    label168:
    Object localObject2;
    if (paramRadarMemberView.tID != null)
    {
      paramDialogInterface = paramRadarMemberView.tID;
      int j;
      int i;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = null;
        paramDialogInterface = (CharSequence)String.valueOf(paramDialogInterface);
        paramInt = paramDialogInterface.length() - 1;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        if (i > paramInt) {
          break label168;
        }
        int k;
        if (j == 0)
        {
          k = i;
          if (s.compare(paramDialogInterface.charAt(k), 32) > 0) {
            break label143;
          }
          k = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            if (k == 0)
            {
              j = 1;
              break label81;
              paramDialogInterface = paramDialogInterface.getText();
              break;
              k = paramInt;
              break label94;
              k = 0;
              continue;
            }
            i += 1;
            break label81;
          }
        }
        if (k == 0) {
          break label168;
        }
        paramInt -= 1;
      }
      str = paramDialogInterface.subSequence(i, paramInt + 1).toString();
      paramDialogInterface = paramRadarMemberView.Nsl;
      if (paramDialogInterface != null) {
        break label475;
      }
      paramDialogInterface = "";
      if (!Util.isNullOrNil(paramDialogInterface))
      {
        localObject2 = paramRadarMemberView.contact;
        if ((localObject2 == null) || (com.tencent.mm.contact.d.rs(((az)localObject2).field_type) != true)) {
          break label499;
        }
        paramInt = 1;
        label228:
        if (paramInt == 0) {
          break label543;
        }
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB();
        paramDialogInterface = paramRadarMemberView.contact;
        if (paramDialogInterface != null) {
          break label504;
        }
        paramDialogInterface = null;
        label259:
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject2).aMi(paramDialogInterface);
        if (localObject2 != null)
        {
          paramDialogInterface = (CharSequence)((cr)localObject2).field_encryptUsername;
          if ((paramDialogInterface != null) && (!kotlin.n.n.bp(paramDialogInterface))) {
            break label512;
          }
          paramInt = 1;
          label296:
          if (paramInt == 0) {
            break label597;
          }
        }
        paramDialogInterface = paramRadarMemberView.contact;
        if (paramDialogInterface != null) {
          break label517;
        }
        paramDialogInterface = null;
        label311:
        paramDialogInterface = (CharSequence)paramDialogInterface;
        if ((paramDialogInterface != null) && (!kotlin.n.n.bp(paramDialogInterface))) {
          break label525;
        }
        paramInt = 1;
        label329:
        if (paramInt != 0) {
          break label597;
        }
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB();
        paramDialogInterface = paramRadarMemberView.contact;
        if (paramDialogInterface != null) {
          break label530;
        }
        paramDialogInterface = (DialogInterface)localObject1;
      }
    }
    label361:
    for (paramDialogInterface = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject2).aMi(paramDialogInterface);; paramDialogInterface = (DialogInterface)localObject2)
    {
      if (paramDialogInterface != null)
      {
        localObject1 = (CharSequence)paramDialogInterface.field_encryptUsername;
        if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
          break label538;
        }
        paramInt = 1;
        if (paramInt == 0) {
          ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMj(paramDialogInterface.field_encryptUsername);
        }
      }
      paramDialogInterface = paramRadarMemberView.contact;
      if (paramDialogInterface != null) {
        paramDialogInterface.AW(str);
      }
      ab.c(paramRadarMemberView.contact, str);
      for (;;)
      {
        paramRadarMemberView = paramRadarMemberView.getMemberNameTv();
        if (paramRadarMemberView != null) {
          paramRadarMemberView.setText((CharSequence)str);
        }
        AppMethodBeat.o(267270);
        return;
        localObject2 = d.Nua;
        paramDialogInterface = d.a(paramDialogInterface);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = "";
          break;
        }
        break;
        label499:
        paramInt = 0;
        break label228;
        label504:
        paramDialogInterface = paramDialogInterface.field_username;
        break label259;
        paramInt = 0;
        break label296;
        paramDialogInterface = paramDialogInterface.field_encryptUsername;
        break label311;
        paramInt = 0;
        break label329;
        paramDialogInterface = paramDialogInterface.field_encryptUsername;
        break label361;
        paramInt = 0;
        break label398;
        localObject1 = paramRadarMemberView.contact;
        if (localObject1 != null) {
          ((au)localObject1).AW(str);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().replace((IAutoDBItem)new cr(paramDialogInterface, str));
      }
    }
  }
  
  private static final void a(RadarMemberView paramRadarMemberView, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(267260);
    Object localObject1 = new Object();
    Object localObject3 = new b();
    ((b)localObject3).cH(paramRadarMemberView);
    ((b)localObject3).cH(paramView);
    a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject3).aYj());
    s.u(paramRadarMemberView, "this$0");
    localObject3 = "";
    paramView = (View)localObject3;
    int i;
    if (paramRadarMemberView.contact != null)
    {
      paramView = paramRadarMemberView.contact;
      if ((paramView == null) || (com.tencent.mm.contact.d.rs(paramView.field_type) != true)) {
        break label443;
      }
      i = 1;
      if (i == 0) {
        break label456;
      }
      paramView = paramRadarMemberView.contact;
      if (paramView != null) {
        break label448;
      }
    }
    label136:
    label162:
    label443:
    label448:
    for (paramView = null;; paramView = paramView.field_conRemark)
    {
      localObject1 = (CharSequence)paramView;
      if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
        break label635;
      }
      i = 1;
      localObject1 = paramView;
      if (i != 0)
      {
        localObject1 = paramView;
        if (paramRadarMemberView.getMember() != null)
        {
          paramView = paramRadarMemberView.getMember();
          if (paramView != null) {
            break label640;
          }
          paramView = null;
          localObject1 = paramView;
        }
      }
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      paramRadarMemberView.pRt = View.inflate(paramRadarMemberView.getContext(), a.e.sendrequest_dialog, null);
      localObject1 = paramRadarMemberView.pRt;
      if (localObject1 != null) {
        break label648;
      }
      localObject1 = null;
      label200:
      paramRadarMemberView.DSB = ((TextView)localObject1);
      localObject1 = paramRadarMemberView.DSB;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
      localObject1 = paramRadarMemberView.pRt;
      if (localObject1 != null) {
        break label662;
      }
      localObject1 = null;
      label235:
      paramRadarMemberView.tID = ((EditText)localObject1);
      localObject1 = paramRadarMemberView.pRt;
      if (localObject1 != null) {
        break label676;
      }
      localObject1 = localObject2;
      label252:
      paramRadarMemberView.NaQ = ((TextView)localObject1);
      localObject1 = paramRadarMemberView.NaQ;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = paramRadarMemberView.tID;
      if (localObject1 != null) {
        ((EditText)localObject1).setText((CharSequence)paramView);
      }
      paramView = paramRadarMemberView.NaQ;
      if (paramView != null) {
        paramView.setText((CharSequence)"50");
      }
      paramView = paramRadarMemberView.tID;
      if (paramView != null) {
        paramView.setFilters(com.tencent.mm.pluginsdk.ui.tools.k.Ytp);
      }
      paramView = paramRadarMemberView.tID;
      if (paramView != null) {
        paramView.addTextChangedListener((TextWatcher)new g(paramRadarMemberView));
      }
      paramView = new RadarMemberView..ExternalSyntheticLambda0(paramRadarMemberView);
      localObject1 = new RadarMemberView..ExternalSyntheticLambda1(paramRadarMemberView);
      paramRadarMemberView.pRv = com.tencent.mm.ui.base.k.a(paramRadarMemberView.getContext(), paramRadarMemberView.getContext().getString(a.g.Nrf), paramRadarMemberView.pRt, paramView, (DialogInterface.OnClickListener)localObject1);
      paramView = paramRadarMemberView.tID;
      if (paramView != null) {
        paramView.post(new RadarMemberView..ExternalSyntheticLambda6(paramRadarMemberView));
      }
      a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267260);
      return;
      i = 0;
      break;
    }
    label456:
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB();
    paramView = paramRadarMemberView.contact;
    if (paramView == null)
    {
      paramView = null;
      label482:
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject1).aMi(paramView);
      if (localObject1 != null)
      {
        paramView = (CharSequence)((cr)localObject1).field_encryptUsername;
        if ((paramView != null) && (!kotlin.n.n.bp(paramView))) {
          break label609;
        }
        i = 1;
        label515:
        if (i == 0) {
          break label690;
        }
      }
      paramView = paramRadarMemberView.contact;
      if (paramView != null) {
        break label614;
      }
      paramView = null;
      label530:
      paramView = (CharSequence)paramView;
      if ((paramView != null) && (!kotlin.n.n.bp(paramView))) {
        break label622;
      }
      i = 1;
      label548:
      if (i != 0) {
        break label690;
      }
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB();
      paramView = paramRadarMemberView.contact;
      if (paramView != null) {
        break label627;
      }
      paramView = null;
      label578:
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject1).aMi(paramView);
    }
    label640:
    label648:
    label662:
    label676:
    label690:
    for (;;)
    {
      paramView = (View)localObject3;
      if (localObject1 == null) {
        break;
      }
      paramView = ((cr)localObject1).field_conRemark;
      break;
      paramView = paramView.field_username;
      break label482;
      label609:
      i = 0;
      break label515;
      label614:
      paramView = paramView.field_encryptUsername;
      break label530;
      label622:
      i = 0;
      break label548;
      label627:
      paramView = paramView.field_encryptUsername;
      break label578;
      label635:
      i = 0;
      break label136;
      paramView = paramView.vhX;
      break label162;
      localObject1 = (TextView)((View)localObject1).findViewById(a.d.sendrequest_tip);
      break label200;
      localObject1 = (EditText)((View)localObject1).findViewById(a.d.sendrequest_content);
      break label235;
      localObject1 = (TextView)((View)localObject1).findViewById(a.d.wordcount);
      break label252;
    }
  }
  
  private static final void a(RadarMemberView paramRadarMemberView, ell paramell, View paramView)
  {
    AppMethodBeat.i(267262);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRadarMemberView);
    localb.cH(paramell);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRadarMemberView, "this$0");
    s.u(paramell, "$member");
    if ((paramRadarMemberView.getState() == null) || (paramRadarMemberView.NsQ == null))
    {
      a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267262);
      return;
    }
    paramView = paramRadarMemberView.NsQ;
    if (paramView != null) {
      paramView.a(paramell, paramRadarMemberView.getState());
    }
    paramRadarMemberView.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267262);
  }
  
  private static final boolean a(RadarMemberView paramRadarMemberView, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(267264);
    s.u(paramRadarMemberView, "this$0");
    if ((paramView != paramRadarMemberView.getConfirmBtn()) && (paramMotionEvent.getAction() == 1) && (paramRadarMemberView.isShowing())) {
      paramRadarMemberView.dismiss();
    }
    AppMethodBeat.o(267264);
    return true;
  }
  
  private static final void b(RadarMemberView paramRadarMemberView, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(267274);
    s.u(paramRadarMemberView, "this$0");
    paramDialogInterface = paramRadarMemberView.pRv;
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramRadarMemberView.pRv = null;
    AppMethodBeat.o(267274);
  }
  
  private static final void b(RadarMemberView paramRadarMemberView, View paramView)
  {
    AppMethodBeat.i(267268);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRadarMemberView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRadarMemberView, "this$0");
    localObject = new Intent();
    paramView = paramRadarMemberView.contact;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.field_username)
    {
      ((Intent)localObject).putExtra("k_username", paramView);
      ((Intent)localObject).putExtra("showShare", false);
      paramView = am.aixg;
      paramView = f.f.adwf;
      s.s(paramView, "KExposeH5Url");
      paramView = String.format(paramView, Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
      s.s(paramView, "java.lang.String.format(format, *args)");
      ((Intent)localObject).putExtra("rawUrl", paramView);
      c.b(paramRadarMemberView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarMemberView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267268);
      return;
    }
  }
  
  private final ImageView getAvatarCopy()
  {
    AppMethodBeat.i(138611);
    ImageView localImageView = (ImageView)this.NsG.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.NsH.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.NsF.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.NsI.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.NsJ.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.NsO.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.NsK.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.NsL.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.NsM.getValue();
    AppMethodBeat.o(138617);
    return localTextView;
  }
  
  private final void reset()
  {
    AppMethodBeat.i(138625);
    getAvatarCopyContainer().setVisibility(8);
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    AppMethodBeat.o(138625);
  }
  
  public final void a(View paramView, ell paramell, b.e parame)
  {
    AppMethodBeat.i(138623);
    s.u(paramView, "view");
    s.u(paramell, "member");
    Log.d(TAG, "popup");
    this.Nsm = parame;
    this.Nsl = paramell;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener(new RadarMemberView..ExternalSyntheticLambda4(this, paramell));
    }
    getModifyNameBtn().setOnClickListener(this.NsR);
    setOnTouchListener(new RadarMemberView..ExternalSyntheticLambda5(this));
    getExposeTv().setOnClickListener(new RadarMemberView..ExternalSyntheticLambda3(this));
    parame = d.Nua;
    parame = d.a(paramell);
    if (!kotlin.n.n.bp((CharSequence)parame)) {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(parame);
    }
    Object localObject = this.contact;
    int i;
    if ((localObject != null) && (com.tencent.mm.contact.d.rs(((az)localObject).field_type) == true))
    {
      i = 1;
      if (i == 0) {
        break label540;
      }
      parame = this.contact;
      if (parame != null) {
        break label532;
      }
      parame = null;
      label184:
      localObject = getMemberNameTv();
      if ((this.contact == null) || (Util.isNullOrNil(parame))) {
        break label586;
      }
    }
    label532:
    label540:
    label586:
    for (paramell = (CharSequence)p.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramell = (CharSequence)p.b(getContext(), (CharSequence)paramell.vhX, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramell);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.NsE = paramView;
      paramView = this.NsE;
      s.checkNotNull(paramView);
      paramView = paramView.findViewById(a.d.NqL);
      s.s(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramell = (ImageView)paramView;
      paramView = this.NsE;
      s.checkNotNull(paramView);
      paramView = paramView.findViewById(a.d.Nqv);
      s.s(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.NsE;
      s.checkNotNull(parame);
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramell.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.NsN = ((int[])localObject);
      setVisibility(0);
      paramell = new AnimationSet(true);
      paramell.setFillAfter(true);
      paramell.setRepeatCount(1);
      paramell.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramell.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramell.addAnimation((Animation)paramView);
      paramell.setAnimationListener((Animation.AnimationListener)new f(this));
      getAvatarCopyContainer().startAnimation((Animation)paramell);
      AppMethodBeat.o(138623);
      return;
      i = 0;
      break;
      parame = parame.field_conRemark;
      break label184;
      this.NsP = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(parame);
      parame = this.NsP;
      if (parame == null)
      {
        parame = null;
        break label184;
      }
      parame = parame.field_conRemark;
      break label184;
    }
  }
  
  public final void c(String paramString, b.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(138620);
    s.u(paramString, "username");
    s.u(parame, "state");
    if ((!isShowing()) || (this.pzm))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.Nsl;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!s.p(paramString, localObject1))
      {
        localObject1 = this.Nsl;
        if (localObject1 != null) {
          break label103;
        }
      }
    }
    label103:
    for (localObject1 = localObject2;; localObject1 = ((ell)localObject1).UserName)
    {
      if (s.p(paramString, localObject1)) {
        a(parame);
      }
      AppMethodBeat.o(138620);
      return;
      localObject1 = ((ell)localObject1).Zyp;
      break;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(138624);
    Log.d(TAG, "dismiss");
    if (this.pzm)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.pzm = true;
    Object localObject1 = this.NsE;
    s.checkNotNull(localObject1);
    Object localObject2 = ((View)localObject1).findViewById(a.d.Nqv);
    s.s(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.NsN;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    s.checkNotNull(arrayOfInt1);
    localObject2 = new TranslateAnimation(arrayOfInt1[0] - f2 * f1, arrayOfInt2[0], arrayOfInt1[1], arrayOfInt2[1]);
    ((AnimationSet)localObject1).addAnimation((Animation)new ScaleAnimation(f1, 1.0F, f1, 1.0F));
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setAnimationListener((Animation.AnimationListener)new d(this));
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    getAvatarCopyContainer().startAnimation((Animation)localObject1);
    AppMethodBeat.o(138624);
  }
  
  public final ell getMember()
  {
    return this.Nsl;
  }
  
  public final b.e getState()
  {
    return this.Nsm;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(138619);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(138619);
      return true;
    }
    AppMethodBeat.o(138619);
    return false;
  }
  
  public final void setListener(b paramb)
  {
    AppMethodBeat.i(138622);
    s.u(paramb, "listener");
    this.NsQ = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(ell paramell)
  {
    this.Nsl = paramell;
  }
  
  public final void setState(b.e parame)
  {
    this.Nsm = parame;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(ell paramell, b.e parame);
    
    public abstract void b(ell paramell, b.e parame);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animation.AnimationListener
  {
    d(RadarMemberView paramRadarMemberView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      s.u(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.c(this.NsV);
      RadarMemberView.b(this.NsV).sendEmptyMessage(RadarMemberView.gFg());
      AppMethodBeat.o(138594);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138593);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138592);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138592);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends MMHandler
  {
    e(RadarMemberView paramRadarMemberView) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      s.u(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.gFf())
      {
        paramMessage = this.NsV;
        this.NsV.getMember();
        RadarMemberView.a(paramMessage, this.NsV.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.gFg())
      {
        this.NsV.setVisibility(4);
        RadarMemberView.f(this.NsV);
        paramMessage = RadarMemberView.g(this.NsV);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.h(this.NsV);
        if (paramMessage != null) {
          paramMessage.b(this.NsV.getMember(), this.NsV.getState());
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animation.AnimationListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      s.u(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.b(this.NsV).sendEmptyMessage(RadarMemberView.gFf());
      AppMethodBeat.o(138602);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138601);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138601);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138600);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(138600);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements TextWatcher
  {
    g(RadarMemberView paramRadarMemberView) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = false;
      AppMethodBeat.i(138605);
      s.u(paramEditable, "s");
      int j = 50 - paramEditable.length();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject = RadarMemberView.d(this.NsV);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      }
      localObject = RadarMemberView.e(this.NsV);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.ui.widget.a.e)localObject).aEJ(-1))
      {
        if (localObject != null)
        {
          if (paramEditable.length() > 0) {
            bool = true;
          }
          ((Button)localObject).setEnabled(bool);
        }
        AppMethodBeat.o(138605);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138604);
      s.u(paramCharSequence, "s");
      AppMethodBeat.o(138604);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138603);
      s.u(paramCharSequence, "s");
      AppMethodBeat.o(138603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */