package com.tencent.mm.plugin.textstatus.f;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.t;
import com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity.a;
import com.tencent.mm.plugin.textstatus.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "descAnimTransMax", "", "getDescAnimTransMax", "()I", "setDescAnimTransMax", "(I)V", "isPostOpen", "", "()Z", "setPostOpen", "(Z)V", "layoutAuthorCustomView", "Landroid/widget/FrameLayout;", "getLayoutAuthorCustomView", "()Landroid/widget/FrameLayout;", "setLayoutAuthorCustomView", "(Landroid/widget/FrameLayout;)V", "layoutCenterMove", "Landroid/view/View;", "getLayoutCenterMove", "()Landroid/view/View;", "setLayoutCenterMove", "(Landroid/view/View;)V", "layoutNotify", "getLayoutNotify", "setLayoutNotify", "layoutStatus", "getLayoutStatus", "setLayoutStatus", "layoutTopic", "getLayoutTopic", "setLayoutTopic", "pulldownState", "getPulldownState", "setPulldownState", "shouldShowAuthor", "getShouldShowAuthor", "setShouldShowAuthor", "showSameTopics", "getShowSameTopics", "setShowSameTopics", "startOpenTime", "", "getStartOpenTime", "()J", "setStartOpenTime", "(J)V", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "setTvAuthorName", "(Landroid/widget/TextView;)V", "tvBrandDesc", "getTvBrandDesc", "setTvBrandDesc", "vTopLine", "getVTopLine", "setVTopLine", "brandClick", "", "getSameFriendTipsDefAlpha", "", "goToSameTopic", "handleAuthor", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "handleDescAnimInited", "handleIconTipsClick", "iconStatusClick", "init", "contentView", "isCanPullDown", "isMusicStatus", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "curTranslation", "unfoldTranslation", "sendLuckyMoney", "update", "username", "", "item", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "markAndGone", "resumeVisibility", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
  implements d
{
  public static final b.a Tlc;
  private View Tld;
  private TextView Tle;
  private FrameLayout Tlf;
  private TextView Tlg;
  private View Tlh;
  private View Tli;
  private View Tlj;
  private View Tlk;
  private int Tll;
  private boolean Tlm;
  private boolean Tln;
  private boolean Tlo;
  private int Tlp;
  private long Tlq;
  
  static
  {
    AppMethodBeat.i(289796);
    Tlc = new b.a((byte)0);
    AppMethodBeat.o(289796);
  }
  
  public b(x paramx)
  {
    super(paramx);
    AppMethodBeat.i(289749);
    this.Tll = 1;
    AppMethodBeat.o(289749);
  }
  
  private static final void a(e parame, b paramb, View paramView)
  {
    AppMethodBeat.i(289779);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (parame != null) {
      parame.gz(paramb.getContext());
    }
    parame = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(paramb.getContext(), 61L, null, null, 0L, 0L, 0L, 124);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289779);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(289790);
    s.u(paramb, "this$0");
    View localView = paramb.Tlj;
    int i;
    int j;
    if (localView == null)
    {
      i = 0;
      localView = paramb.Tlj;
      if (localView != null) {
        break label93;
      }
      j = 0;
      label37:
      localView = paramb.hHo();
      if (localView != null) {
        break label102;
      }
    }
    label93:
    label102:
    for (int k = 0;; k = localView.getMeasuredHeight())
    {
      paramb.Tlp = Math.max(k - (j + i) - paramb.getContext().getResources().getDimensionPixelSize(a.c.TbD), 0);
      AppMethodBeat.o(289790);
      return;
      i = (int)localView.getY();
      break;
      j = localView.getMeasuredHeight();
      break label37;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(289769);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.hGZ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289769);
  }
  
  private static final void a(b paramb, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(289773);
    s.u(paramb, "this$0");
    if (paramInt8 - paramInt6 != paramView.getHeight())
    {
      paramView = paramb.Tlj;
      if (paramView != null) {
        paramView.post(new b..ExternalSyntheticLambda3(paramb));
      }
    }
    AppMethodBeat.o(289773);
  }
  
  private boolean hHd()
  {
    Object localObject1 = null;
    AppMethodBeat.i(289766);
    Object localObject2 = this.Tmb;
    if (localObject2 == null) {}
    for (;;)
    {
      boolean bool = s.p(localObject1, "music_player@inner");
      AppMethodBeat.o(289766);
      return bool;
      localObject2 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject2);
      if (localObject2 != null) {
        localObject1 = ((TextStatusTopicInfo)localObject2).sourceId;
      }
    }
  }
  
  private static void kk(View paramView)
  {
    AppMethodBeat.i(289757);
    s.u(paramView, "<this>");
    int i = paramView.getVisibility();
    paramView.setTag(a.e.TdY, Integer.valueOf(i));
    paramView.setVisibility(8);
    AppMethodBeat.o(289757);
  }
  
  private static void kl(View paramView)
  {
    AppMethodBeat.i(289763);
    s.u(paramView, "<this>");
    Object localObject = paramView.getTag(a.e.TdY);
    if ((localObject instanceof Integer)) {
      paramView.setVisibility(((Number)localObject).intValue());
    }
    AppMethodBeat.o(289763);
  }
  
  public final void afI(int paramInt) {}
  
  public final void afJ(int paramInt) {}
  
  public final void afK(int paramInt) {}
  
  public final boolean b(String paramString, com.tencent.mm.plugin.textstatus.h.f.b paramb, t paramt)
  {
    AppMethodBeat.i(289869);
    s.u(paramString, "username");
    boolean bool = super.b(paramString, paramb, paramt);
    int i;
    if (this.Tlm)
    {
      paramb = hHm();
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.Tmb;
      int j = 0;
      if (paramb != null)
      {
        paramt = (CharSequence)paramb.field_TopicId;
        if ((paramt != null) && (!n.bp(paramt))) {
          break label544;
        }
        i = 1;
        label77:
        if (i == 0)
        {
          paramt = f.TjQ;
          j = f.hGH().p(paramb.field_TopicId, kotlin.a.p.al(new String[] { paramString })).size();
        }
        if ((!hHe().aom(4)) || (j <= 0)) {
          break label550;
        }
        Log.i("MicroMsg.TextStatus.BaseProfileLoadLogic", s.X("sametsize ", Integer.valueOf(j)));
        paramString = hHg();
        if (paramString != null)
        {
          paramt = am.aixg;
          paramt = String.format(com.tencent.mm.plugin.textstatus.util.b.hKh().a(com.tencent.mm.plugin.textstatus.h.f.b.b(paramb), j, com.tencent.mm.plugin.textstatus.util.b.hKh().f(com.tencent.mm.plugin.textstatus.h.f.b.b(paramb)), 1), Arrays.copyOf(new Object[0], 0));
          s.s(paramt, "java.lang.String.format(format, *args)");
          paramString.setText((CharSequence)paramt);
        }
        this.Tln = true;
        paramString = hHg();
        if (paramString != null) {
          paramString.setAlpha(1.0F);
        }
        paramString = hHg();
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramString = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (paramString != null) {
          paramString.Tpe = j;
        }
        label273:
        if (!this.Tln) {
          break label558;
        }
        paramString = this.TlN;
        if (paramString != null) {
          paramString.setAlpha(1.0F);
        }
        label294:
        if (bool)
        {
          paramString = hHr();
          paramt = this.Tle;
          if (paramt != null)
          {
            if (paramString != null) {
              break label590;
            }
            paramString = null;
            label319:
            paramt.setText(paramString);
          }
          paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramString = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
          if (paramString != null) {
            paramString.Tpj = this.Tll;
          }
        }
      }
      if (bool)
      {
        paramString = hHo();
        if (paramString != null) {
          paramString.addOnLayoutChangeListener(new b..ExternalSyntheticLambda2(this));
        }
        if (paramb != null) {
          break label598;
        }
        paramString = null;
        label388:
        paramString = (CharSequence)paramString;
        if ((paramString != null) && (!n.bp(paramString))) {
          break label620;
        }
        i = 1;
        label407:
        if (i != 0) {
          break label672;
        }
        paramt = hHr();
        paramString = this.Tlf;
        if (paramString != null) {
          paramString.removeAllViews();
        }
        if (this.Tlf != null) {
          break label626;
        }
        paramString = Boolean.FALSE;
        label441:
        if (paramt != null) {
          break label650;
        }
        paramb = null;
        label447:
        if (!s.p(paramString, Boolean.TRUE)) {
          break label664;
        }
        if ((paramb != null) && (!n.bp(paramb))) {
          break label658;
        }
        i = 1;
        label471:
        if (i != 0) {
          break label664;
        }
        this.Tlo = true;
        paramString = this.Tlg;
        if (paramString != null) {
          paramString.setText(paramb);
        }
        paramString = hHj();
        if (paramString != null) {
          paramString.setOnClickListener(new b..ExternalSyntheticLambda0(paramt, this));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(289869);
      return bool;
      paramb = hHm();
      if (paramb == null) {
        break;
      }
      paramb.setVisibility(8);
      break;
      label544:
      i = 0;
      break label77;
      label550:
      this.Tln = false;
      break label273;
      label558:
      paramString = this.TlN;
      if (paramString == null) {
        break label294;
      }
      paramt = paramb.field_IconID;
      s.s(paramt, "info.field_IconID");
      paramString.setAlpha(bdR(paramt));
      break label294;
      label590:
      paramString = paramString.etT();
      break label319;
      label598:
      paramString = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb);
      if (paramString == null)
      {
        paramString = null;
        break label388;
      }
      paramString = paramString.sourceId;
      break label388;
      label620:
      i = 0;
      break label407;
      label626:
      if (paramt == null)
      {
        paramString = null;
        break label441;
      }
      paramString = Boolean.valueOf(paramt.f(this.Tlf));
      break label441;
      label650:
      paramb = paramt.etS();
      break label447;
      label658:
      i = 0;
      break label471;
      label664:
      this.Tlo = false;
      continue;
      label672:
      this.Tlo = false;
    }
  }
  
  public final void etL()
  {
    ViewPropertyAnimator localViewPropertyAnimator = null;
    AppMethodBeat.i(289919);
    Object localObject = this.Tld;
    if (localObject == null) {}
    for (;;)
    {
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.setDuration(200L);
      }
      AppMethodBeat.o(289919);
      return;
      localObject = ((View)localObject).animate();
      if (localObject != null) {
        localViewPropertyAnimator = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      }
    }
  }
  
  public final void etM()
  {
    ViewPropertyAnimator localViewPropertyAnimator = null;
    AppMethodBeat.i(289927);
    Object localObject = this.Tld;
    if (localObject == null) {}
    for (;;)
    {
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.setDuration(200L);
      }
      AppMethodBeat.o(289927);
      return;
      localObject = ((View)localObject).animate();
      if (localObject != null) {
        localViewPropertyAnimator = ((ViewPropertyAnimator)localObject).alpha(0.15F);
      }
    }
  }
  
  public final void g(View paramView)
  {
    AppMethodBeat.i(289830);
    s.u(paramView, "contentView");
    super.g(paramView);
    this.Tld = paramView.findViewById(a.e.TeW);
    this.Tle = ((TextView)paramView.findViewById(a.e.tv_brand_desc));
    this.Tlf = ((FrameLayout)paramView.findViewById(a.e.TcV));
    this.Tlg = ((TextView)paramView.findViewById(a.e.Teg));
    this.Tlh = paramView.findViewById(a.e.Tdt);
    this.Tli = paramView.findViewById(a.e.Tdn);
    this.Tlk = paramView.findViewById(a.e.Tdy);
    paramView = hHp();
    if ((paramView != null) && (paramView.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = hHp();
        if (paramView != null) {
          paramView.setOnClickListener(new b..ExternalSyntheticLambda1(this));
        }
      }
      paramView = l.TBz;
      l.C((View)this.Tlf, com.tencent.mm.cd.a.fromDPToPix(getContext(), 10.0F));
      i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
      paramView = this.Tlk;
      if (paramView != null) {
        paramView.setOnTouchListener((View.OnTouchListener)new b(i, this));
      }
      AppMethodBeat.o(289830);
      return;
    }
  }
  
  public final void gBu() {}
  
  public final void gBv() {}
  
  public final boolean hFr()
  {
    AppMethodBeat.i(289822);
    boolean bool = com.tencent.mm.plugin.textstatus.ui.b.a(getUsername(), (k)hHr(), this.Tmb);
    AppMethodBeat.o(289822);
    return bool;
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(289835);
    Fx(false);
    super.hGZ();
    AppMethodBeat.o(289835);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(289846);
    Object localObject1 = f.TjQ;
    Object localObject2 = f.hGH();
    localObject1 = this.Tmb;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (((g)localObject2).p((String)localObject1, kotlin.a.p.al(new String[] { getUsername() })).size() <= 0) {
        break label168;
      }
      if (ac.hGq())
      {
        if (!s.p(com.tencent.mm.plugin.auth.a.a.cUx(), getUsername())) {
          break label148;
        }
        i = 3;
        label73:
        localObject1 = TextStatusOtherTopicFriendsActivity.TzE;
        TextStatusOtherTopicFriendsActivity.a.bb(getContext(), i);
      }
      localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      localObject1 = this.Tmb;
      if (localObject1 != null) {
        break label153;
      }
      localObject1 = null;
      label100:
      if (!s.p(localObject2, localObject1)) {
        break label161;
      }
    }
    label148:
    label153:
    label161:
    for (localObject1 = "2";; localObject1 = "1")
    {
      localObject2 = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 28L, (String)localObject1, null, 0L, 0L, 0L, 120);
      AppMethodBeat.o(289846);
      return;
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_TopicId;
      break;
      i = 4;
      break label73;
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_UserName;
      break label100;
    }
    label168:
    super.hHa();
    AppMethodBeat.o(289846);
  }
  
  public final boolean hHb()
  {
    com.tencent.mm.plugin.textstatus.i.b localb = null;
    int j = 0;
    AppMethodBeat.i(289879);
    if (!super.hHb())
    {
      int i;
      if (ac.hGq())
      {
        if (s.p(com.tencent.mm.plugin.auth.a.a.cUx(), getUsername())) {}
        for (i = 3;; i = 4)
        {
          localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
          com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 28L, null, this.Tmb, 0L, 0L, 0L, 116);
          localObject = TextStatusOtherTopicFriendsActivity.TzE;
          TextStatusOtherTopicFriendsActivity.a.bb(getContext(), i);
          AppMethodBeat.o(289879);
          return true;
        }
      }
      boolean bool = s.p(getUsername(), com.tencent.mm.plugin.auth.a.a.cUx());
      if (bool)
      {
        localObject = f.TjQ;
        com.tencent.mm.plugin.textstatus.h.f.b localb1 = f.bdN(com.tencent.mm.plugin.auth.a.a.cUx());
        localObject = f.TjQ;
        int k = f.hGH().hHP();
        g localg;
        if (localb1 != null)
        {
          i = 1;
          localObject = f.TjQ;
          localg = f.hGH();
          if (localb1 != null) {
            break label279;
          }
          localObject = null;
          label157:
          String str = com.tencent.mm.plugin.auth.a.a.cUx();
          s.s(str, "username()");
          if ((!localg.p((String)localObject, kotlin.a.p.al(new String[] { str })).isEmpty()) || (k - i <= 0)) {
            break label351;
          }
          localObject = f.TjQ;
          localg = f.hGH();
          if (localb1 != null) {
            break label289;
          }
        }
        label279:
        label289:
        for (localObject = localb;; localObject = localb1.field_TopicId)
        {
          localObject = localg.nj((String)localObject, com.tencent.mm.plugin.auth.a.a.cUx()).iterator();
          i = j;
          while (((Iterator)localObject).hasNext()) {
            if (((g.c)((Iterator)localObject).next()).isValid()) {
              i += 1;
            }
          }
          i = 0;
          break;
          localObject = localb1.field_TopicId;
          break label157;
        }
        if (i > 0)
        {
          localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
          com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 28L, "3", this.Tmb, 0L, 0L, 0L, 112);
          localObject = TextStatusOtherTopicFriendsActivity.TzE;
          TextStatusOtherTopicFriendsActivity.a.bb(getContext(), 3);
          AppMethodBeat.o(289879);
          return true;
        }
      }
      label351:
      if (bool) {}
      for (Object localObject = "2";; localObject = "1")
      {
        localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 28L, (String)localObject, this.Tmb, 0L, 0L, 0L, 112);
        AppMethodBeat.o(289879);
        return true;
      }
    }
    AppMethodBeat.o(289879);
    return false;
  }
  
  public final void hHc()
  {
    AppMethodBeat.i(289913);
    super.hHc();
    if ((this.Tll == 2) && (hHd()))
    {
      com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 63L, null, this.Tmb, 0L, 0L, 0L, 116);
    }
    AppMethodBeat.o(289913);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(289909);
    long l1 = cn.bDw();
    long l2 = this.Tlq;
    this.Tlm = false;
    this.Tll = 1;
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject).Tpj = this.Tll;
    }
    localObject = this.Tle;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.Tmb;
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      if ((!this.Tln) && (!bool))
      {
        localObject = hHg();
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      localObject = hHj();
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(8);
      }
      localObject = hHm();
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.Tmb;
      if (localObject != null) {
        break label509;
      }
      localObject = null;
      label174:
      if ((localObject == null) || (d((TextStatusTopicInfo)localObject) != true)) {
        break label519;
      }
      i = 1;
      label190:
      if (i != 0)
      {
        LinearLayout localLinearLayout = hHi();
        if (localLinearLayout != null) {
          localLinearLayout.setVisibility(0);
        }
      }
      if (localObject != null) {
        break label524;
      }
      localObject = null;
      label219:
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label534;
      }
      i = 1;
      label241:
      if (i == 0)
      {
        localObject = hHr();
        if ((localObject == null) || (((e)localObject).etQ() != true)) {
          break label539;
        }
      }
    }
    label519:
    label524:
    label534:
    label539:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = hHf();
        if (localObject != null) {
          kl((View)localObject);
        }
        localObject = this.Tlh;
        if (localObject != null) {
          kl((View)localObject);
        }
        localObject = this.Tli;
        if (localObject != null) {
          kl((View)localObject);
        }
        localObject = hHh();
        if (localObject != null) {
          kl((View)localObject);
        }
        if (s.p(getUsername(), com.tencent.mm.plugin.auth.a.a.cUx()))
        {
          localObject = hHk();
          if (localObject != null) {
            kl((View)localObject);
          }
          localObject = hHn();
          if (localObject != null) {
            kl((View)localObject);
          }
          localObject = hHl();
          if (localObject != null) {
            kl((View)localObject);
          }
        }
      }
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 65L, null, null, 0L, 0L, 0L, 124);
      if ((hHd()) && (l1 - l2 > 5000L))
      {
        localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 64L, null, null, 0L, 0L, 0L, 124);
      }
      hHq();
      AppMethodBeat.o(289909);
      return;
      localObject = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject);
      if (localObject == null)
      {
        bool = false;
        break;
      }
      bool = c((TextStatusTopicInfo)localObject);
      break;
      label509:
      localObject = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject);
      break label174;
      i = 0;
      break label190;
      localObject = ((TextStatusTopicInfo)localObject).sourceId;
      break label219;
      i = 0;
      break label241;
    }
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(289898);
    this.Tlq = cn.bDw();
    this.Tlm = true;
    this.Tll = 2;
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject).Tpj = this.Tll;
    }
    localObject = hHg();
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = hHm();
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.Tmb;
    int i;
    label135:
    if (localObject == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label325;
      }
      i = 1;
      label112:
      if (i == 0)
      {
        localObject = hHr();
        if ((localObject == null) || (((e)localObject).etQ() != true)) {
          break label330;
        }
        i = 1;
        if (i != 0)
        {
          localObject = hHr();
          if (localObject != null) {
            break label335;
          }
        }
      }
    }
    label325:
    label330:
    label335:
    for (paramBoolean = true;; paramBoolean = ((e)localObject).eKU())
    {
      if (paramBoolean)
      {
        localObject = this.Tle;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      localObject = hHf();
      if (localObject != null) {
        kk((View)localObject);
      }
      localObject = this.Tli;
      if (localObject != null) {
        kk((View)localObject);
      }
      localObject = hHh();
      if (localObject != null) {
        kk((View)localObject);
      }
      if (s.p(getUsername(), com.tencent.mm.plugin.auth.a.a.cUx()))
      {
        localObject = hHk();
        if (localObject != null) {
          kk((View)localObject);
        }
        localObject = hHn();
        if (localObject != null) {
          kk((View)localObject);
        }
        localObject = hHl();
        if (localObject != null) {
          kk((View)localObject);
        }
      }
      hHq();
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 42L, null, null, 0L, 0L, 0L, 124);
      AppMethodBeat.o(289898);
      return;
      localObject = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject);
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((TextStatusTopicInfo)localObject).sourceId;
      break;
      i = 0;
      break label112;
      i = 0;
      break label135;
    }
  }
  
  public final void w(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(289889);
    Object localObject = hHf();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof ConstraintLayout.LayoutParams)) {
        break label92;
      }
    }
    label92:
    for (localObject = (ConstraintLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((ConstraintLayout.LayoutParams)localObject).atV = (0.5F * paramFloat1 + 0.5F);
        TextView localTextView = hHf();
        if (localTextView != null) {
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(289889);
      return;
      localObject = ((TextView)localObject).getLayoutParams();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$init$2", "Landroid/view/View$OnTouchListener;", "isCatchDown", "", "()Z", "setCatchDown", "(Z)V", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnTouchListener
  {
    private boolean Tlr;
    
    b(int paramInt, b paramb) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      boolean bool2 = false;
      AppMethodBeat.i(289698);
      if (paramMotionEvent == null)
      {
        paramView = null;
        if (paramView != null) {
          break label43;
        }
        label21:
        if (paramView != null) {
          break label97;
        }
      }
      label43:
      label97:
      while (paramView.intValue() != 1)
      {
        AppMethodBeat.o(289698);
        return false;
        paramView = Integer.valueOf(paramMotionEvent.getAction());
        break;
        if (paramView.intValue() != 0) {
          break label21;
        }
        f = paramMotionEvent.getX();
        if ((f >= 0.0F) && (f < this.Tls)) {}
        for (;;)
        {
          this.Tlr = bool1;
          bool1 = this.Tlr;
          AppMethodBeat.o(289698);
          return bool1;
          bool1 = false;
        }
      }
      float f = paramMotionEvent.getX();
      bool1 = bool2;
      if (f >= 0.0F)
      {
        bool1 = bool2;
        if (f < this.Tls)
        {
          bool1 = bool2;
          if (this.Tlr) {
            bool1 = true;
          }
        }
      }
      if (bool1)
      {
        paramView = jdField_this.TlN;
        if (paramView != null) {
          paramView.performClick();
        }
      }
      AppMethodBeat.o(289698);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.b
 * JD-Core Version:    0.7.0.1
 */