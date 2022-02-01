package com.tencent.mm.plugin.multitalk.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.fng;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/tips/MultitalkScreenProjectNewTips;", "Lcom/tencent/mm/plugin/newtips/model/INewTipsView;", "context", "Landroid/content/Context;", "mRootView", "Landroid/view/View;", "mPath", "", "redDot", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMPath", "()Ljava/lang/String;", "setMPath", "(Ljava/lang/String;)V", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "getRedDot", "setRedDot", "compatCallBack", "", "getPath", "getRoot", "isDynamicPath", "showCompatCalBackAfter", "", "showType", "Lcom/tencent/mm/plugin/newtips/model/NewTipsShowType;", "show", "showCompatCalBackBefore", "showCompat", "showCounter", "tipsInfo", "Lcom/tencent/mm/protocal/protobuf/TipsInfo;", "showNew", "showNewTips", "showRedPoint", "showRedPointIcon", "showRedPointPointTitleIcon", "showRedPointTitle", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.newtips.a.a
{
  private Context context;
  private String mPath;
  private View mlS;
  private View plc;
  
  public a(Context paramContext, View paramView1, String paramString, View paramView2)
  {
    AppMethodBeat.i(285334);
    this.context = paramContext;
    this.plc = paramView1;
    this.mPath = paramString;
    this.mlS = paramView2;
    AppMethodBeat.o(285334);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean fZD()
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.mPath;
  }
  
  public final View getRoot()
  {
    return this.plc;
  }
  
  public final boolean ym(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(285386);
    if (paramBoolean) {
      this.mlS.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(285386);
      return true;
      this.mlS.setVisibility(8);
    }
  }
  
  public final boolean yo(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b.a
 * JD-Core Version:    0.7.0.1
 */