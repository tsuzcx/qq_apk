package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mContext", "Landroid/content/Context;", "username", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mBtnChat", "Landroid/widget/Button;", "getMBtnChat", "()Landroid/widget/Button;", "setMBtnChat", "(Landroid/widget/Button;)V", "getMContext", "()Landroid/content/Context;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "mTvDesc", "Landroid/widget/TextView;", "getMTvDesc", "()Landroid/widget/TextView;", "setMTvDesc", "(Landroid/widget/TextView;)V", "mTvSetSame", "getMTvSetSame", "setMTvSetSame", "mTvTextStatus", "getMTvTextStatus", "setMTvTextStatus", "mTvTextStatusEdt", "mTvTips", "getMTvTips", "setMTvTips", "statusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "getStatusCardView", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusCardView", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;)V", "getUsername", "()Ljava/lang/String;", "vPic", "Landroid/view/View;", "getVPic", "()Landroid/view/View;", "setVPic", "(Landroid/view/View;)V", "dismiss", "", "initUI", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "Companion", "plugin-textstatus_release"})
public final class g
  extends b
  implements i
{
  public static final a Gdz;
  private com.tencent.mm.plugin.textstatus.a.f Gdy;
  private com.tencent.mm.ui.base.q gxX;
  private final Context mContext;
  private final String username;
  
  static
  {
    AppMethodBeat.i(216466);
    Gdz = new a((byte)0);
    AppMethodBeat.o(216466);
  }
  
  public g(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(216465);
    this.mContext = paramContext;
    this.username = paramString;
    AppMethodBeat.o(216465);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(216463);
    super.dismiss();
    com.tencent.mm.plugin.textstatus.a.f localf = this.Gdy;
    if (localf != null)
    {
      localf.fvv();
      AppMethodBeat.o(216463);
      return;
    }
    AppMethodBeat.o(216463);
  }
  
  protected final void initUI()
  {
    AppMethodBeat.i(216462);
    super.initUI();
    Object localObject1 = this.mContext;
    Object localObject2 = n.FXt;
    p.g(localObject2, "StatusShowParam.sDefStatusCardDialogParam");
    localObject1 = new f((Context)localObject1, (n)localObject2);
    localObject2 = ((f)localObject1).tlx;
    p.h(localObject2, "customView");
    LinearLayout localLinearLayout = this.GcD;
    if (localLinearLayout != null) {
      localLinearLayout.addView((View)localObject2, -1, -2);
    }
    ((f)localObject1).DV(this.username);
    ((f)localObject1).dec = ((View.OnClickListener)new b(this));
    this.Gdy = ((com.tencent.mm.plugin.textstatus.a.f)localObject1);
    localObject1 = this.GcD;
    if (localObject1 != null)
    {
      localObject2 = ((LinearLayout)localObject1).getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      if (localObject1 != null)
      {
        ((RelativeLayout.LayoutParams)localObject1).topMargin += au.eu(getContext());
        AppMethodBeat.o(216462);
        return;
      }
      AppMethodBeat.o(216462);
      return;
    }
    AppMethodBeat.o(216462);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216464);
    paramString = this.gxX;
    if (paramString != null)
    {
      paramString.dismiss();
      AppMethodBeat.o(216464);
      return;
    }
    AppMethodBeat.o(216464);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(216461);
    super.onStart();
    AppMethodBeat.o(216461);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216460);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      p.g(paramView, "it");
      if (paramView.getId() == 2131309012) {
        this.GdA.dismiss();
      }
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.g
 * JD-Core Version:    0.7.0.1
 */