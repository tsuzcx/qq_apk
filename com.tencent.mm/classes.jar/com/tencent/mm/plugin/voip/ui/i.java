package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.b;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.plugin.ringtone.widget.c.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.b;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoIPTopControlUI;", "", "statusManager", "Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "(Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;)V", "clickTime", "", "mBtnMinimizeVoIP", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mBtnSplitScreen", "mMinimizeVoipLsn", "Landroid/view/View$OnClickListener;", "mRingtoneIconLayout", "Landroid/widget/LinearLayout;", "mTopControlUI", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "setStatusManager", "applyEvent", "", "mIsOutCall", "", "dismissUI", "getLayout", "context", "Landroid/content/Context;", "rootView", "Landroid/widget/FrameLayout;", "mUserName", "", "hideSplitScreenBtn", "incTopMarginOfRelativeLayout", "height", "", "onStopRing", "responseRingtoneIconAction", "tpMediaInfoDesc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "showUI", "showVideoTalking", "showVoiceTalking", "updateSplitScreenBtn", "taskId", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a UJV;
  private WeImageView LvW;
  private View UJW;
  private WeImageView UJX;
  private LinearLayout UJY;
  private final View.OnClickListener UJZ;
  com.tencent.mm.plugin.voip.e.a UJy;
  private long tQb;
  
  static
  {
    AppMethodBeat.i(292504);
    UJV = new i.a((byte)0);
    AppMethodBeat.o(292504);
  }
  
  public i(com.tencent.mm.plugin.voip.e.a parama)
  {
    AppMethodBeat.i(292444);
    this.UJy = parama;
    this.UJZ = new i..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(292444);
  }
  
  private static final void a(d paramd, i parami, View paramView)
  {
    AppMethodBeat.i(292449);
    s.u(parami, "this$0");
    com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.hZL();
    if (com.tencent.mm.plugin.voip.f.h.ibw())
    {
      parami = com.tencent.mm.plugin.ringtone.widget.c.OGk;
      parami = paramView.getContext();
      s.s(parami, "it.context");
      s.s(paramd, "desc");
      c.a.a(parami, paramd);
      AppMethodBeat.o(292449);
      return;
    }
    s.s(paramd, "desc");
    paramView = parami.UJY;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = parami.UJY;
    if (paramView != null) {
      paramView.setOnClickListener(new i..ExternalSyntheticLambda3(parami, paramd));
    }
    AppMethodBeat.o(292449);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(292488);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    a.b.a(parami.UJy, a.c.UHJ);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292488);
  }
  
  private static final void a(i parami, d paramd)
  {
    AppMethodBeat.i(292455);
    s.u(parami, "this$0");
    if ((paramd == null) || (paramd.ODB == com.tencent.mm.plugin.ringtone.g.c.ODq) || (paramd.ODB == com.tencent.mm.plugin.ringtone.g.c.ODp))
    {
      AppMethodBeat.o(292455);
      return;
    }
    Object localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.hZM();
    localObject = parami.UJY;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = parami.UJY;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(new i..ExternalSyntheticLambda0(paramd, parami));
    }
    paramd = com.tencent.mm.plugin.ringtone.c.BL(false);
    parami = parami.UJY;
    if (parami == null) {}
    for (parami = null; parami == null; parami = (MMAnimateView)parami.findViewById(b.d.ringtone_animator_iv))
    {
      parami = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMAnimateView");
      AppMethodBeat.o(292455);
      throw parami;
    }
    parami.setImageFilePath(paramd);
    parami.stop();
    parami.start();
    AppMethodBeat.o(292455);
  }
  
  private static final void a(i parami, d paramd, View paramView)
  {
    AppMethodBeat.i(292479);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parami);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parami, "this$0");
    s.u(paramd, "$tpMediaInfoDesc");
    parami = parami.UJW;
    Object localObject3;
    TextView localTextView1;
    TextView localTextView2;
    TextView localTextView3;
    if (parami != null)
    {
      localObject1 = new j(parami.getContext(), 2, 0, true);
      ((j)localObject1).aFe(1);
      ((j)localObject1).au(parami.getContext().getText(b.g.ringtone_educate_ok));
      ((j)localObject1).aFc(Color.parseColor("#07C160"));
      localObject2 = LayoutInflater.from(((j)localObject1).rootView.getContext()).inflate(com.tencent.mm.plugin.voip.b.e.ringtone_calling_info, null);
      s.s(localObject2, "from(dialog.rootView.con…gtone_calling_info, null)");
      parami = (ImageView)((View)localObject2).findViewById(b.d.ringtone_album_iv);
      if (parami != null) {
        parami.setImageDrawable(((j)localObject1).rootView.getContext().getDrawable(b.b.empty_music_cover));
      }
      if (parami != null) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(paramd.nUM, parami);
      }
      localObject3 = ((View)localObject2).findViewById(b.d.qq_music_icon_layout);
      localTextView1 = (TextView)((View)localObject2).findViewById(b.d.ringtone_title_tv);
      localTextView2 = (TextView)((View)localObject2).findViewById(b.d.ringtone_author_tv);
      if (paramd.ODw != null) {
        break label492;
      }
      ((View)localObject3).setVisibility(0);
      localTextView3 = (TextView)((View)localObject2).findViewById(b.c.qq_music_tv);
      parami = paramd.ODy;
      if (parami != null) {
        break label408;
      }
      parami = null;
      if (parami != null) {
        break label433;
      }
      label284:
      if (parami != null) {
        break label462;
      }
      label288:
      ((View)localObject3).setVisibility(8);
      label295:
      parami = (ImageView)((View)localObject2).findViewById(b.d.qq_music_icon);
      localObject3 = com.tencent.mm.plugin.ringtone.l.b.OFS;
      paramView = paramView.getContext();
      s.s(paramView, "it.context");
      parami.setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m(paramView, com.tencent.mm.plugin.ringtone.b.e.icon_filled_qqmusic, b.a.BW_100_Alpha_0_8));
    }
    for (;;)
    {
      localTextView1.setText((CharSequence)paramd.ODz);
      localTextView2.setText((CharSequence)paramd.ODA);
      ((j)localObject1).setCustomView((View)localObject2);
      ((j)localObject1).agfR = new i..ExternalSyntheticLambda5((j)localObject1);
      ((j)localObject1).dDn();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292479);
      return;
      label408:
      parami = parami.acjr;
      if (parami == null)
      {
        parami = null;
        break;
      }
      parami = Integer.valueOf(parami.oOt);
      break;
      label433:
      if (parami.intValue() != 0) {
        break label284;
      }
      localTextView3.setText(((View)localObject2).getContext().getResources().getText(com.tencent.mm.plugin.ringtone.b.f.qq_music_text));
      break label295;
      label462:
      if (parami.intValue() != 1) {
        break label288;
      }
      localTextView3.setText(((View)localObject2).getContext().getResources().getText(com.tencent.mm.plugin.ringtone.b.f.qq_music_vip_text));
      break label295;
      label492:
      ((View)localObject3).setVisibility(8);
    }
  }
  
  private static final void b(i parami, View paramView)
  {
    AppMethodBeat.i(292495);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    if (System.currentTimeMillis() - parami.tQb <= 1000L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292495);
      return;
    }
    parami.tQb = System.currentTimeMillis();
    a.b.a(parami.UJy, a.c.UHI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPTopControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292495);
  }
  
  private static final void k(j paramj)
  {
    AppMethodBeat.i(292461);
    s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(292461);
  }
  
  public final View a(Context paramContext, FrameLayout paramFrameLayout, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292548);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "rootView");
    s.u(paramString, "mUserName");
    this.UJW = LayoutInflater.from(paramContext).inflate(com.tencent.mm.plugin.voip.b.e.layout_voip_top_control, (ViewGroup)paramFrameLayout);
    paramContext = this.UJW;
    if (paramContext != null)
    {
      paramFrameLayout = paramContext.findViewById(b.d.btn_minimize_voip);
      if (paramFrameLayout == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
        AppMethodBeat.o(292548);
        throw paramContext;
      }
      this.UJX = ((WeImageView)paramFrameLayout);
      paramFrameLayout = this.UJX;
      if (paramFrameLayout != null) {
        paramFrameLayout.setBackground(bb.m(paramContext.getContext(), com.tencent.mm.plugin.voip.b.f.icon_filled_min_window, -1));
      }
      paramFrameLayout = this.UJX;
      if (paramFrameLayout != null) {
        paramFrameLayout.setOnClickListener(this.UJZ);
      }
      this.LvW = ((WeImageView)paramContext.findViewById(b.d.btn_split));
      this.UJY = ((LinearLayout)paramContext.findViewById(b.d.ringtone_icon_layout_root));
      if (paramBoolean)
      {
        paramContext = com.tencent.mm.plugin.ringtone.c.OBr;
        com.tencent.mm.plugin.ringtone.c.gOe().a((q)this.UJy, new i..ExternalSyntheticLambda4(this));
      }
    }
    paramContext = this.UJW;
    AppMethodBeat.o(292548);
    return paramContext;
  }
  
  public final boolean aqU(int paramInt)
  {
    AppMethodBeat.i(292556);
    if (this.LvW == null)
    {
      AppMethodBeat.o(292556);
      return false;
    }
    WeImageView localWeImageView1 = this.LvW;
    WeImageView localWeImageView2;
    if (localWeImageView1 != null)
    {
      if (paramInt == -1) {
        break label116;
      }
      localWeImageView1.setVisibility(0);
      if (paramInt != 2) {
        break label89;
      }
      localWeImageView2 = this.LvW;
      if (localWeImageView2 != null) {
        localWeImageView2.setBackground(bb.m(localWeImageView1.getContext(), com.tencent.mm.plugin.voip.b.f.icons_outlined_merge, -1));
      }
      localWeImageView1.setOnClickListener(new i..ExternalSyntheticLambda1(this));
    }
    for (;;)
    {
      AppMethodBeat.o(292556);
      return true;
      label89:
      localWeImageView2 = this.LvW;
      if (localWeImageView2 == null) {
        break;
      }
      localWeImageView2.setBackground(bb.m(localWeImageView1.getContext(), com.tencent.mm.plugin.voip.b.f.icons_outlined_sperated, -1));
      break;
      label116:
      localWeImageView1.setVisibility(8);
    }
  }
  
  public final void aqV(int paramInt)
  {
    AppMethodBeat.i(292584);
    Object localObject1 = this.UJW;
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(292584);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).topMargin += paramInt;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(292584);
  }
  
  public final void iaF()
  {
    AppMethodBeat.i(292593);
    View localView = this.UJW;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(292593);
  }
  
  public final void iaG()
  {
    AppMethodBeat.i(292602);
    View localView = this.UJW;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(292602);
  }
  
  public final void iaJ()
  {
    AppMethodBeat.i(292564);
    WeImageView localWeImageView = this.LvW;
    if (localWeImageView != null) {
      localWeImageView.setVisibility(8);
    }
    AppMethodBeat.o(292564);
  }
  
  public final void iam()
  {
    AppMethodBeat.i(292571);
    LinearLayout localLinearLayout = this.UJY;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    AppMethodBeat.o(292571);
  }
  
  public final void iay()
  {
    AppMethodBeat.i(292575);
    Object localObject = this.UJY;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.UJX;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(292575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.i
 * JD-Core Version:    0.7.0.1
 */