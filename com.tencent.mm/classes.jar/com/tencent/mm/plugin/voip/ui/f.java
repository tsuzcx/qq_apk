package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoIPAvatarContentLayoutUI;", "", "()V", "avatarContentLayout", "Landroid/view/View;", "getAvatarContentLayout", "()Landroid/view/View;", "setAvatarContentLayout", "(Landroid/view/View;)V", "mDynamicTextWrap", "Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment$DynamicTextWrap;", "mIsOpenIm", "", "mIvRemoteTalkerAvatar", "Landroid/widget/ImageView;", "mLlInviteTipsCtn", "mTips", "Landroid/widget/TextView;", "mTvInviteTipsDot", "mTvRemoteTalkerName", "mTvRemoteTalkerNameSubDetail", "applyUIEvent", "", "mUserName", "", "getLayout", "context", "Landroid/content/Context;", "rootView", "Landroid/widget/FrameLayout;", "isVideo", "incTopMarginOfRelativeLayout", "height", "", "release", "setMinWidthFitString", "tv", "textId", "showCalledInviting", "showCalledVoiceConnecting", "showCallingConnecting", "showCallingInviting", "showCallingWaitingAccept", "showConnecting", "showVoiceTalking", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a UJn;
  private ImageView UJo;
  private TextView UJp;
  private TextView UJq;
  private TextView UJr;
  private View UJs;
  private TextView UJt;
  VoipBaseFragment.c UJu;
  View UJv;
  private boolean UJw;
  
  static
  {
    AppMethodBeat.i(292451);
    UJn = new f.a((byte)0);
    AppMethodBeat.o(292451);
  }
  
  public f()
  {
    AppMethodBeat.i(292447);
    this.UJu = new VoipBaseFragment.c();
    AppMethodBeat.o(292447);
  }
  
  public final void GD(boolean paramBoolean)
  {
    AppMethodBeat.i(292502);
    Object localObject = this.UJv;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.UJs;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    if (paramBoolean)
    {
      localObject = this.UJq;
      if (localObject != null) {
        ((TextView)localObject).setText(b.g.voip_invited_video_tip);
      }
      if (this.UJt != null)
      {
        if (!this.UJw) {
          break label146;
        }
        localObject = this.UJt;
        if (localObject != null) {
          break label138;
        }
        localObject = null;
        label78:
        if (Util.isNullOrNil((CharSequence)localObject)) {
          break label146;
        }
        localObject = this.UJt;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.UJu.a(this.UJr, VoipBaseFragment.UKa);
      AppMethodBeat.o(292502);
      return;
      localObject = this.UJq;
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setText(b.g.voip_invited_audio_tip);
      break;
      label138:
      localObject = ((TextView)localObject).getText();
      break label78;
      label146:
      localObject = this.UJt;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  public final View a(Context paramContext, FrameLayout paramFrameLayout, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292464);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "rootView");
    s.u(paramString, "mUserName");
    if (paramBoolean) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(b.e.layout_voip_caller_video, (ViewGroup)paramFrameLayout);; paramContext = LayoutInflater.from(paramContext).inflate(b.e.layout_voip_caller_voice, (ViewGroup)paramFrameLayout))
    {
      this.UJv = paramContext;
      paramContext = this.UJv;
      if (paramContext == null) {
        break label403;
      }
      paramFrameLayout = paramContext.findViewById(b.d.voip_remote_talker_avatar);
      if (paramFrameLayout != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(292464);
      throw paramContext;
    }
    this.UJo = ((ImageView)paramFrameLayout);
    a.b.a(this.UJo, paramString, 0.125F, true);
    paramFrameLayout = paramContext.findViewById(b.d.voip_remote_talker_name);
    if (paramFrameLayout == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(292464);
      throw paramContext;
    }
    this.UJp = ((TextView)paramFrameLayout);
    paramFrameLayout = this.UJp;
    Context localContext;
    CharSequence localCharSequence;
    TextView localTextView;
    if (paramFrameLayout != null)
    {
      localContext = paramContext.getContext();
      localCharSequence = (CharSequence)aa.getDisplayName(paramString);
      localTextView = this.UJp;
      if (localTextView != null) {
        break label244;
      }
    }
    label244:
    for (float f = 14.0F;; f = localTextView.getTextSize())
    {
      paramFrameLayout.setText((CharSequence)p.b(localContext, localCharSequence, f));
      paramFrameLayout = paramContext.findViewById(b.d.voip_invite_tips_dot);
      if (paramFrameLayout != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(292464);
      throw paramContext;
    }
    this.UJr = ((TextView)paramFrameLayout);
    paramFrameLayout = paramContext.findViewById(b.d.voip_invite_tips);
    if (paramFrameLayout == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(292464);
      throw paramContext;
    }
    this.UJq = ((TextView)paramFrameLayout);
    this.UJs = paramContext.findViewById(b.d.voip_invite_tips_ctn);
    this.UJt = ((TextView)paramContext.findViewById(b.d.voip_remote_talker_name_sub_detail));
    paramContext = this.UJr;
    int i = b.g.voip_three_dot;
    if (paramContext == null) {
      Log.e("MicroMsg.VoIPAvatarContentLayoutUI", "TextView is null or text is null");
    }
    for (;;)
    {
      paramContext = a.X(((n)h.ax(n.class)).bzA().JE(paramString));
      this.UJw = au.bwO(paramString);
      if (!Util.isNullOrNil(paramContext))
      {
        paramFrameLayout = this.UJt;
        if (paramFrameLayout != null) {
          paramFrameLayout.setText((CharSequence)paramContext);
        }
      }
      label403:
      paramContext = this.UJv;
      AppMethodBeat.o(292464);
      return paramContext;
      paramContext.setText(i);
      paramFrameLayout = this.UJv;
      if (paramFrameLayout != null)
      {
        i = paramFrameLayout.getResources().getDisplayMetrics().widthPixels;
        int j = paramFrameLayout.getResources().getDisplayMetrics().heightPixels;
        paramContext.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
        paramContext.setWidth(paramContext.getMeasuredWidth());
      }
    }
  }
  
  public final void ial()
  {
    AppMethodBeat.i(292476);
    Object localObject = this.UJv;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.UJq;
    if (localObject != null) {
      ((TextView)localObject).setText(b.g.voip_outcalling);
    }
    this.UJu.a(this.UJr, VoipBaseFragment.UKa);
    localObject = this.UJs;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    AppMethodBeat.o(292476);
  }
  
  public final void iau()
  {
    AppMethodBeat.i(292468);
    Object localObject = this.UJq;
    if (localObject != null) {
      ((TextView)localObject).setText(b.g.voip_waitting);
    }
    this.UJu.a(this.UJr, VoipBaseFragment.UKa);
    localObject = this.UJs;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    AppMethodBeat.o(292468);
  }
  
  public final void iav()
  {
    AppMethodBeat.i(292486);
    Object localObject = this.UJt;
    if (localObject != null)
    {
      if ((!this.UJw) || (Util.isNullOrNil(((TextView)localObject).getText()))) {
        break label102;
      }
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = this.UJv;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.UJq;
      if (localObject != null) {
        ((TextView)localObject).setText(b.g.voip_invite_waiting_tip);
      }
      this.UJu.a(this.UJr, VoipBaseFragment.UKa);
      localObject = this.UJs;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(292486);
      return;
      label102:
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public final void iaw()
  {
    AppMethodBeat.i(292492);
    TextView localTextView = this.UJq;
    if (localTextView != null) {
      localTextView.setText(b.g.voip_waitting);
    }
    this.UJu.a(this.UJr, VoipBaseFragment.UKa);
    AppMethodBeat.o(292492);
  }
  
  public final void iax()
  {
    AppMethodBeat.i(292506);
    Object localObject = this.UJv;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.UJs;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.UJq;
    if (localObject != null) {
      ((TextView)localObject).setText(b.g.voip_waitting);
    }
    this.UJu.a(this.UJr, VoipBaseFragment.UKa);
    AppMethodBeat.o(292506);
  }
  
  public final void iay()
  {
    AppMethodBeat.i(292512);
    View localView = this.UJs;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.UJv;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(292512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f
 * JD-Core Version:    0.7.0.1
 */