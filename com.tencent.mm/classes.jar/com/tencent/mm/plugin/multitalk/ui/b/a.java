package com.tencent.mm.plugin.multitalk.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.erx;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/tips/MultitalkScreenProjectNewTips;", "Lcom/tencent/mm/plugin/newtips/model/INewTipsView;", "context", "Landroid/content/Context;", "mRootView", "Landroid/view/View;", "mPath", "", "redDot", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMPath", "()Ljava/lang/String;", "setMPath", "(Ljava/lang/String;)V", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "getRedDot", "setRedDot", "compatCallBack", "", "getPath", "getRoot", "isDynamicPath", "showCompatCalBackAfter", "", "showType", "Lcom/tencent/mm/plugin/newtips/model/NewTipsShowType;", "show", "showCompatCalBackBefore", "showCompat", "showCounter", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/TipsInfo;", "showNew", "showNewTips", "showRedPoint", "showRedPointIcon", "showRedPointPointTitleIcon", "showRedPointTitle", "plugin-multitalk_release"})
public final class a
  implements com.tencent.mm.plugin.newtips.a.a
{
  private Context context;
  private View jMT;
  private String mPath;
  private View mrI;
  
  public a(Context paramContext, View paramView1, String paramString, View paramView2)
  {
    AppMethodBeat.i(196452);
    this.context = paramContext;
    this.mrI = paramView1;
    this.mPath = paramString;
    this.jMT = paramView2;
    AppMethodBeat.o(196452);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean eQW()
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.mPath;
  }
  
  public final View getRoot()
  {
    return this.mrI;
  }
  
  public final boolean tX(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(196448);
    if (paramBoolean) {
      this.jMT.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(196448);
      return true;
      this.jMT.setVisibility(8);
    }
  }
  
  public final boolean tZ(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b.a
 * JD-Core Version:    0.7.0.1
 */