package com.tencent.mm.plugin.ringtone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.b;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.uic.g;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion;", "", "()V", "checkCurrentRingtoneSame", "", "tpMediaDesc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "showRingtoneSettingHalfUI", "", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "tpMediaInfoDesc", "isMusicPlayer", "onDismiss", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "showRingtoneSettingHalfUIWithoutPlayer", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  public static void a(Context paramContext, androidx.lifecycle.j paramj, com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(273099);
    s.u(paramContext, "context");
    s.u(paramj, "lifecycle");
    s.u(paramd, "tpMediaInfoDesc");
    s.u(paramb, "onDismiss");
    g localg = new g();
    ah.a locala = new ah.a();
    locala.aiwY = true;
    Object localObject1 = paramd.ODv;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).loop = true;
    }
    localg.a(paramd, true);
    com.tencent.mm.ui.widget.a.j localj = new com.tencent.mm.ui.widget.a.j(paramContext, 0, 0, true);
    localObject1 = c.OGk;
    if (d(paramd)) {}
    Object localObject2;
    View localView1;
    View localView2;
    for (localObject1 = LayoutInflater.from(localj.rootView.getContext()).inflate(b.d.ringtone_setting_info_while_same, null);; localObject1 = LayoutInflater.from(localj.rootView.getContext()).inflate(b.d.ringtone_setting_info, null))
    {
      localObject2 = c.OGk;
      d(paramd);
      localObject2 = (Button)((View)localObject1).findViewById(b.c.ringtone_set);
      localObject5 = (ImageView)((View)localObject1).findViewById(b.c.ringtone_album_iv);
      localView1 = ((View)localObject1).findViewById(b.c.ringtone_card_root);
      localObject4 = com.tencent.mm.plugin.ringtone.c.BL(false);
      localView2 = ((View)localObject1).findViewById(b.c.album_mask);
      localObject3 = ((View)localObject1).findViewById(b.c.ringtone_animator_iv);
      if (localObject3 != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMAnimateView");
      AppMethodBeat.o(273099);
      throw paramContext;
    }
    Object localObject3 = (MMAnimateView)localObject3;
    if (localView2 != null) {
      localView2.setVisibility(0);
    }
    ((MMAnimateView)localObject3).setImageFilePath((String)localObject4);
    ((MMAnimateView)localObject3).stop();
    ((MMAnimateView)localObject3).start();
    Object localObject4 = (WeImageView)((View)localObject1).findViewById(b.c.ringtone_setting_cancel);
    if (localObject4 != null) {
      ((WeImageView)localObject4).setImageDrawable(bb.m(paramContext, b.e.icons_outlined_close, paramContext.getResources().getColor(b.a.FG_0)));
    }
    if (localObject5 != null) {
      ((ImageView)localObject5).setImageDrawable(localj.rootView.getContext().getDrawable(b.b.empty_music_cover));
    }
    if (localObject5 != null) {
      ((cn)h.az(cn.class)).loadImage(paramd.nUM, (ImageView)localObject5);
    }
    Object localObject5 = ((View)localObject1).findViewById(b.c.qq_music_icon_layout);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(b.c.ringtone_title_tv);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(b.c.ringtone_author_tv);
    ((View)localObject5).setVisibility(8);
    localTextView1.setText((CharSequence)paramd.ODz);
    localTextView2.setText((CharSequence)paramd.ODA);
    ((WeImageView)localObject4).setOnClickListener(new c.a..ExternalSyntheticLambda2((MMAnimateView)localObject3, localg, localj, paramb));
    localView1.setOnClickListener(new c.a..ExternalSyntheticLambda3((MMAnimateView)localObject3, locala, localView1, paramContext, localView2, localg, paramd));
    paramj.addObserver((p)new RingtoneHalfBottomDialog.Companion.showRingtoneSettingHalfUI.1.4(localView1, paramContext, (MMAnimateView)localObject3, localView2, localg, paramd, locala));
    localj.agfT = new c.a..ExternalSyntheticLambda5(localView2, (MMAnimateView)localObject3, localg, paramb);
    if (localObject2 != null) {
      ((Button)localObject2).setOnClickListener(new c.a..ExternalSyntheticLambda0(paramContext, paramd, (MMAnimateView)localObject3, localj, paramb));
    }
    localj.setCustomView((View)localObject1);
    localj.dDn();
    AppMethodBeat.o(273099);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(273112);
    s.u(paramContext, "context");
    s.u(paramd, "tpMediaInfoDesc");
    Object localObject2 = paramd.ODv;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).loop = true;
    }
    localObject2 = new com.tencent.mm.ui.widget.a.j(paramContext, 0, 0, true);
    View localView = LayoutInflater.from(((com.tencent.mm.ui.widget.a.j)localObject2).rootView.getContext()).inflate(b.d.ringtone_setting_calling, null);
    s.s(localView, "from(dialog.rootView.con…ne_setting_calling, null)");
    ((TextView)localView.findViewById(b.c.ringtone_card_title)).setText(b.f.other_ringtone_tips);
    Object localObject3 = (ImageView)localView.findViewById(b.c.ringtone_album_iv);
    WeImageView localWeImageView = (WeImageView)localView.findViewById(b.c.ringtone_setting_cancel);
    Button localButton = (Button)localView.findViewById(b.c.ringtone_set);
    localButton.setText(b.f.setting_ringtone_same);
    if (localWeImageView != null) {
      localWeImageView.setImageDrawable(bb.m(paramContext, b.e.icons_outlined_close, paramContext.getResources().getColor(b.a.FG_0)));
    }
    if (localObject3 != null) {
      ((ImageView)localObject3).setImageDrawable(((com.tencent.mm.ui.widget.a.j)localObject2).rootView.getContext().getDrawable(b.b.empty_music_cover));
    }
    if (localObject3 != null) {
      ((cn)h.az(cn.class)).loadImage(paramd.nUM, (ImageView)localObject3);
    }
    Object localObject4 = localView.findViewById(b.c.qq_music_icon_layout);
    localObject3 = (TextView)localView.findViewById(b.c.ringtone_title_tv);
    TextView localTextView1 = (TextView)localView.findViewById(b.c.ringtone_author_tv);
    TextView localTextView2;
    Object localObject5;
    if (paramd.ODw == null)
    {
      ((View)localObject4).setVisibility(0);
      localTextView2 = (TextView)localView.findViewById(b.c.qq_music_tv);
      localObject5 = paramd.ODy;
      if (localObject5 == null)
      {
        if (localObject1 != null) {
          break label429;
        }
        label289:
        if (localObject1 != null) {
          break label458;
        }
        label293:
        ((View)localObject4).setVisibility(8);
        label300:
        localObject1 = (ImageView)localView.findViewById(b.c.qq_music_icon);
        localObject4 = com.tencent.mm.plugin.ringtone.l.b.OFS;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m(paramContext, b.e.icon_filled_qqmusic, b.a.BW_100_Alpha_0_8));
      }
    }
    for (;;)
    {
      ((TextView)localObject3).setText((CharSequence)paramd.ODz);
      localTextView1.setText((CharSequence)paramd.ODA);
      localWeImageView.setOnClickListener(new c.a..ExternalSyntheticLambda4((com.tencent.mm.ui.widget.a.j)localObject2));
      if (localButton != null) {
        localButton.setOnClickListener(new c.a..ExternalSyntheticLambda1(paramContext, paramd, (com.tencent.mm.ui.widget.a.j)localObject2));
      }
      ((com.tencent.mm.ui.widget.a.j)localObject2).setCustomView(localView);
      ((com.tencent.mm.ui.widget.a.j)localObject2).dDn();
      AppMethodBeat.o(273112);
      return;
      localObject5 = ((aa)localObject5).acjr;
      if (localObject5 == null) {
        break;
      }
      localObject1 = Integer.valueOf(((v)localObject5).oOt);
      break;
      label429:
      if (((Integer)localObject1).intValue() != 0) {
        break label289;
      }
      localTextView2.setText(localView.getContext().getResources().getText(b.f.qq_music_text));
      break label300;
      label458:
      if (((Integer)localObject1).intValue() != 1) {
        break label293;
      }
      localTextView2.setText(localView.getContext().getResources().getText(b.f.qq_music_vip_text));
      break label300;
      ((View)localObject4).setVisibility(8);
    }
  }
  
  private static final void a(Context paramContext, final com.tencent.mm.plugin.ringtone.g.d paramd, final MMAnimateView paramMMAnimateView, final com.tencent.mm.ui.widget.a.j paramj, final kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(273155);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramd);
    localb.cH(paramMMAnimateView);
    localb.cH(paramj);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramd, "$tpMediaInfoDesc");
    s.u(paramMMAnimateView, "$mAnimateView");
    s.u(paramj, "$dialog");
    s.u(paramb, "$onDismiss");
    kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new a(paramContext, paramd, paramMMAnimateView, paramj, paramb, null), 3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273155);
  }
  
  private static final void a(Context paramContext, final com.tencent.mm.plugin.ringtone.g.d paramd, final com.tencent.mm.ui.widget.a.j paramj, View paramView)
  {
    AppMethodBeat.i(273174);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramd);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramd, "$tpMediaInfoDesc");
    s.u(paramj, "$dialog");
    kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new b(paramContext, paramd, paramj, null), 3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273174);
  }
  
  private static final void a(View paramView, MMAnimateView paramMMAnimateView, g paramg, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(273145);
    s.u(paramMMAnimateView, "$mAnimateView");
    s.u(paramg, "$player");
    s.u(paramb, "$onDismiss");
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramMMAnimateView.stop();
    paramMMAnimateView.recycle();
    paramg.release();
    paramb.invoke(Boolean.FALSE);
    AppMethodBeat.o(273145);
  }
  
  private static final void a(MMAnimateView paramMMAnimateView, g paramg, com.tencent.mm.ui.widget.a.j paramj, kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(273126);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMAnimateView);
    localb.cH(paramg);
    localb.cH(paramj);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMAnimateView, "$mAnimateView");
    s.u(paramg, "$player");
    s.u(paramj, "$dialog");
    s.u(paramb, "$onDismiss");
    paramMMAnimateView.stop();
    paramMMAnimateView.recycle();
    paramg.release();
    paramj.cyW();
    paramb.invoke(Boolean.FALSE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273126);
  }
  
  private static final void a(MMAnimateView paramMMAnimateView, ah.a parama, View paramView1, Context paramContext, View paramView2, g paramg, com.tencent.mm.plugin.ringtone.g.d paramd, View paramView3)
  {
    AppMethodBeat.i(273137);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMAnimateView);
    localb.cH(parama);
    localb.cH(paramView1);
    localb.cH(paramContext);
    localb.cH(paramView2);
    localb.cH(paramg);
    localb.cH(paramd);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMAnimateView, "$mAnimateView");
    s.u(parama, "$isPlay");
    s.u(paramContext, "$context");
    s.u(paramg, "$player");
    s.u(paramd, "$tpMediaInfoDesc");
    paramMMAnimateView.stop();
    if (!parama.aiwY)
    {
      paramView1.setBackground(paramContext.getDrawable(b.b.ringtone_info_item_shape));
      paramMMAnimateView.setVisibility(0);
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramMMAnimateView.start();
      if (parama.aiwY) {
        break label273;
      }
      bool = true;
      label187:
      paramg.a(paramd, bool);
      if (parama.aiwY) {
        break label279;
      }
    }
    label273:
    label279:
    for (boolean bool = true;; bool = false)
    {
      parama.aiwY = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273137);
      return;
      paramView1.setBackground(paramContext.getDrawable(b.b.ringtone_info_item_shape_stoke));
      paramMMAnimateView.setVisibility(8);
      if (paramView2 == null) {
        break;
      }
      paramView2.setVisibility(8);
      break;
      bool = false;
      break label187;
    }
  }
  
  private static final void c(com.tencent.mm.ui.widget.a.j paramj, View paramView)
  {
    AppMethodBeat.i(273164);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$dialog");
    paramj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273164);
  }
  
  public static boolean d(com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    AppMethodBeat.i(273120);
    s.u(paramd, "tpMediaDesc");
    Object localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localObject = com.tencent.mm.plugin.ringtone.d.aUu((String)localObject);
    if (paramd.ODw != null)
    {
      if ((((com.tencent.mm.plugin.ringtone.g.d)localObject).mIH == paramd.mIH) && (s.p(((com.tencent.mm.plugin.ringtone.g.d)localObject).LYS, paramd.LYS)))
      {
        AppMethodBeat.o(273120);
        return true;
      }
      AppMethodBeat.o(273120);
      return false;
    }
    if (paramd.ODC != 0)
    {
      if (((com.tencent.mm.plugin.ringtone.g.d)localObject).ODC == paramd.ODC)
      {
        AppMethodBeat.o(273120);
        return true;
      }
      AppMethodBeat.o(273120);
      return false;
    }
    AppMethodBeat.o(273120);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    a(Context paramContext, com.tencent.mm.plugin.ringtone.g.d paramd, MMAnimateView paramMMAnimateView, com.tencent.mm.ui.widget.a.j paramj, kotlin.g.a.b<? super Boolean, ah> paramb, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273107);
      paramObject = (kotlin.d.d)new a(this.$context, paramd, paramMMAnimateView, paramj, paramb, paramd);
      AppMethodBeat.o(273107);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273101);
      Object localObject2 = kotlin.d.a.a.aiwj;
      final w localw;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273101);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localw = w.a(this.$context, (CharSequence)this.$context.getResources().getString(b.f.setting_loading), false, 3, null);
        if (localw != null) {
          localw.show();
        }
        paramObject = PluginRingtone.OBl;
        localObject1 = paramd;
        localObject3 = (kotlin.d.d)this;
        this.L$0 = localw;
        this.label = 1;
        localObject1 = paramObject.setRingtoneSelf((com.tencent.mm.plugin.ringtone.g.d)localObject1, 2, (kotlin.d.d)localObject3);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(273101);
          return localObject2;
        }
        break;
      case 1: 
        localw = (w)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = paramMMAnimateView;
      localObject2 = paramj;
      Object localObject3 = this.$context;
      final kotlin.g.a.b localb = paramb;
      if (((Boolean)paramObject).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(bool, (MMAnimateView)localObject1, (com.tencent.mm.ui.widget.a.j)localObject2, localw, (Context)localObject3, localb));
        paramObject = ah.aiuX;
        AppMethodBeat.o(273101);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(boolean paramBoolean, MMAnimateView paramMMAnimateView, com.tencent.mm.ui.widget.a.j paramj, w paramw, Context paramContext, kotlin.g.a.b<? super Boolean, ah> paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(Context paramContext, com.tencent.mm.plugin.ringtone.g.d paramd, com.tencent.mm.ui.widget.a.j paramj, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273109);
      paramObject = (kotlin.d.d)new b(this.$context, paramd, paramj, paramd);
      AppMethodBeat.o(273109);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273103);
      Object localObject2 = kotlin.d.a.a.aiwj;
      final w localw;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273103);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localw = w.a(this.$context, (CharSequence)this.$context.getResources().getString(b.f.setting_loading), false, 3, null);
        if (localw != null) {
          localw.show();
        }
        paramObject = PluginRingtone.OBl;
        localObject1 = paramd;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = localw;
        this.label = 1;
        localObject1 = paramObject.setRingtoneSelf((com.tencent.mm.plugin.ringtone.g.d)localObject1, 1, locald);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(273103);
          return localObject2;
        }
        break;
      case 1: 
        localw = (w)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = paramj;
      localObject2 = this.$context;
      if (((Boolean)paramObject).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(bool, localw, (com.tencent.mm.ui.widget.a.j)localObject1, (Context)localObject2));
        paramObject = ah.aiuX;
        AppMethodBeat.o(273103);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(boolean paramBoolean, w paramw, com.tencent.mm.ui.widget.a.j paramj, Context paramContext)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.widget.c.a
 * JD-Core Version:    0.7.0.1
 */