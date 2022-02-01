package com.tencent.mm.plugin.textstatus.ui;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.proto.f;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mContext", "Landroid/content/Context;", "username", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mBtnChat", "Landroid/widget/Button;", "getMBtnChat", "()Landroid/widget/Button;", "setMBtnChat", "(Landroid/widget/Button;)V", "getMContext", "()Landroid/content/Context;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "mTvDesc", "Landroid/widget/TextView;", "getMTvDesc", "()Landroid/widget/TextView;", "setMTvDesc", "(Landroid/widget/TextView;)V", "mTvSetSame", "getMTvSetSame", "setMTvSetSame", "mTvTextStatus", "getMTvTextStatus", "setMTvTextStatus", "mTvTextStatusEdt", "mTvTips", "getMTvTips", "setMTvTips", "statusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "getStatusCardView", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusCardView", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;)V", "getUsername", "()Ljava/lang/String;", "vPic", "Landroid/view/View;", "getVPic", "()Landroid/view/View;", "setVPic", "(Landroid/view/View;)V", "dismiss", "", "initUI", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "show", "Companion", "plugin-textstatus_release"})
public final class i
  extends c
  implements com.tencent.mm.an.i
{
  public static final i.a MKK;
  private com.tencent.mm.plugin.textstatus.a.h MKJ;
  private s jhZ;
  private final Context mContext;
  private final String username;
  
  static
  {
    AppMethodBeat.i(238332);
    MKK = new i.a((byte)0);
    AppMethodBeat.o(238332);
  }
  
  public i(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(238329);
    this.mContext = paramContext;
    this.username = paramString;
    AppMethodBeat.o(238329);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(238321);
    Object localObject = gmu();
    if (localObject != null)
    {
      ((LinearLayout)localObject).setPivotX(((LinearLayout)localObject).getWidth() / 2.0F);
      ((LinearLayout)localObject).setPivotY(0.0F);
      localObject = ((LinearLayout)localObject).animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F));
      p.j(localObject, "it.animate().scaleX(0f).…lerateInterpolator(1.5f))");
      ((ViewPropertyAnimator)localObject).setDuration(200L);
    }
    super.dismiss();
    localObject = this.MKJ;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.textstatus.a.h)localObject).gkI();
      AppMethodBeat.o(238321);
      return;
    }
    AppMethodBeat.o(238321);
  }
  
  protected final void initUI()
  {
    AppMethodBeat.i(238312);
    super.initUI();
    Object localObject1 = g.Xox;
    ((a)g.lm(this.mContext).i(a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(f.class, 9, (byte)0));
    localObject1 = a.JbV;
    localObject1 = (f)a.a.a(this.mContext, 9, f.class);
    if (localObject1 != null) {
      ((f)localObject1).sessionId = com.tencent.mm.plugin.fts.a.d.Sx(1);
    }
    localObject1 = this.mContext;
    Object localObject2 = r.gkU();
    p.j(localObject2, "StatusShowParam.defCardDialog()");
    localObject1 = new h((Context)localObject1, (r)localObject2);
    setCustomView(((h)localObject1).wRV);
    ((h)localObject1).KN(this.username);
    ((h)localObject1).dig = ((View.OnClickListener)new i.b(this));
    this.MKJ = ((com.tencent.mm.plugin.textstatus.a.h)localObject1);
    localObject1 = gmu();
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
        if (ay.isMIUI()) {}
        for (int i = 0;; i = com.tencent.mm.ui.statusbar.d.getStatusBarHeight(getContext()))
        {
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (i + (((RelativeLayout.LayoutParams)localObject1).topMargin + ax.ew(getContext())));
          AppMethodBeat.o(238312);
          return;
        }
      }
      AppMethodBeat.o(238312);
      return;
    }
    AppMethodBeat.o(238312);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(238325);
    paramString = this.jhZ;
    if (paramString != null)
    {
      paramString.dismiss();
      AppMethodBeat.o(238325);
      return;
    }
    AppMethodBeat.o(238325);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(238308);
    super.onStart();
    AppMethodBeat.o(238308);
  }
  
  public final void show()
  {
    AppMethodBeat.i(238317);
    super.show();
    LinearLayout localLinearLayout = gmu();
    if (localLinearLayout != null)
    {
      localLinearLayout.setScaleX(0.0F);
      localLinearLayout.setScaleY(0.0F);
      localLinearLayout.setAlpha(0.0F);
      localLinearLayout.post((Runnable)new i.c(localLinearLayout));
      AppMethodBeat.o(238317);
      return;
    }
    AppMethodBeat.o(238317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.i
 * JD-Core Version:    0.7.0.1
 */