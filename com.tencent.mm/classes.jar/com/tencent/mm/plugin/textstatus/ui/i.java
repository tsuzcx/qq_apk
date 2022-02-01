package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.a.l.a;
import com.tencent.mm.plugin.textstatus.a.u;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.anim.d.g;
import com.tencent.mm.ui.anim.d.m;
import com.tencent.mm.ui.anim.d.n;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.bg;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mContext", "Landroid/content/Context;", "username", "", "(Landroid/content/Context;Ljava/lang/String;)V", "gloUIC", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "getGloUIC", "()Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "getMContext", "()Landroid/content/Context;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "statusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "getStatusCardView", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusCardView", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;)V", "getUsername", "()Ljava/lang/String;", "dismiss", "", "dismissByClickCard", "dismissByCloseBtn", "dismissBySpace", "initUI", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "show", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c
  implements com.tencent.mm.am.h
{
  public static final i.a TwY;
  j TwZ;
  private final com.tencent.mm.ui.component.glocom.b Txa;
  private w lKp;
  private final Context mContext;
  private final String username;
  
  static
  {
    AppMethodBeat.i(291301);
    TwY = new i.a((byte)0);
    AppMethodBeat.o(291301);
  }
  
  public i(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(291274);
    this.mContext = paramContext;
    this.username = paramString;
    this.Txa = ((com.tencent.mm.ui.component.glocom.b)new i.b(this));
    AppMethodBeat.o(291274);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(291288);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    if (paramView.getId() == a.e.TdX)
    {
      parami.dismiss();
      parami = parami.TwZ;
      if (parami != null) {
        parami.wk(103L);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291288);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(291404);
    Object localObject = hIo();
    if (localObject != null) {
      com.tencent.mm.ui.anim.d.a.a((View)localObject, new g().a((com.tencent.mm.ui.anim.d.c)new m((n)com.tencent.mm.ui.anim.d.k.adMQ)));
    }
    super.dismiss();
    localObject = this.TwZ;
    if (localObject != null) {
      ((j)localObject).hFv();
    }
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFA();
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFE();
    localObject = this.mContext;
    if ((localObject instanceof MMFragmentActivity)) {}
    for (localObject = (MMFragmentActivity)localObject;; localObject = null)
    {
      if (localObject != null) {
        this.Txa.d((MMFragmentActivity)localObject);
      }
      AppMethodBeat.o(291404);
      return;
    }
  }
  
  protected final void hIm()
  {
    AppMethodBeat.i(291366);
    super.hIm();
    j localj = this.TwZ;
    if (localj != null) {
      localj.wk(101L);
    }
    AppMethodBeat.o(291366);
  }
  
  protected final void hIn()
  {
    AppMethodBeat.i(291376);
    super.hIn();
    j localj = this.TwZ;
    if (localj != null) {
      localj.wk(102L);
    }
    AppMethodBeat.o(291376);
  }
  
  protected final void initUI()
  {
    AppMethodBeat.i(291352);
    super.initUI();
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFz();
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFD();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.k.nq(this.mContext).q(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.p.class, 9, (byte)0));
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject1 = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject1).sessionId = d.We(1);
    }
    Log.i("MicroMsg.TextStatus.TextStatusCardDialog", "initUI: ");
    localObject1 = this.mContext;
    Object localObject2 = x.hFN();
    s.s(localObject2, "defCardDialog()");
    localObject1 = new h((Context)localObject1, (x)localObject2);
    setCustomView(((h)localObject1).Aoy);
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.bdN(this.username);
    l.a.a((com.tencent.mm.plugin.textstatus.a.l)localObject1, this.username, (com.tencent.mm.plugin.textstatus.h.f.b)localObject2);
    ((h)localObject1).fhU = new i..ExternalSyntheticLambda0(this);
    this.TwZ = ((j)localObject1);
    localObject1 = hIo();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label288;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      if (localObject1 != null)
      {
        if (!bg.isMIUI()) {
          break label293;
        }
        i = 0;
        label233:
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (i + (((RelativeLayout.LayoutParams)localObject1).topMargin + bf.fs(getContext())));
      }
    }
    localObject1 = this.mContext;
    if ((localObject1 instanceof MMFragmentActivity)) {}
    for (localObject1 = (MMFragmentActivity)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        this.Txa.c((MMFragmentActivity)localObject1);
      }
      AppMethodBeat.o(291352);
      return;
      label288:
      localObject1 = null;
      break;
      label293:
      i = o.I(getContext(), 25);
      break label233;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(291414);
    paramString = this.lKp;
    if (paramString != null) {
      paramString.dismiss();
    }
    AppMethodBeat.o(291414);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(291332);
    super.onStart();
    AppMethodBeat.o(291332);
  }
  
  public final void show()
  {
    AppMethodBeat.i(291392);
    super.show();
    LinearLayout localLinearLayout = hIo();
    if (localLinearLayout != null) {
      com.tencent.mm.ui.anim.d.a.a((View)localLinearLayout, new com.tencent.mm.ui.anim.d.f().a((com.tencent.mm.ui.anim.d.b)new com.tencent.mm.ui.anim.d.l((n)com.tencent.mm.ui.anim.d.k.adMQ, 3)));
    }
    AppMethodBeat.o(291392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.i
 * JD-Core Version:    0.7.0.1
 */