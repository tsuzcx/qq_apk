package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoErrMsgPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "errMsg", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsgTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"})
public final class NewBizInfoErrMsgPreference
  extends Preference
{
  private MMNeat7extView HdM;
  private String errMsg = "";
  private boolean vkO;
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void fqW()
  {
    AppMethodBeat.i(39609);
    MMNeat7extView localMMNeat7extView = this.HdM;
    if (localMMNeat7extView == null) {
      p.bGy("errMsgTv");
    }
    localMMNeat7extView.aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.k(localMMNeat7extView.getContext(), (CharSequence)this.errMsg, (int)localMMNeat7extView.getTextSize()));
    AppMethodBeat.o(39609);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39608);
    p.k(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(R.h.dtq);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView;
    localMMNeat7extView.setTextSize(1, 16.0F);
    localMMNeat7extView.setTextColor(localMMNeat7extView.getResources().getColor(R.e.grey_text_color));
    p.j(paramView, "view.findViewById<MMNeat…ey_text_color))\n        }");
    this.HdM = ((MMNeat7extView)paramView);
    this.vkO = true;
    fqW();
    AppMethodBeat.o(39608);
  }
  
  public final void setErrMsg(String paramString)
  {
    AppMethodBeat.i(39610);
    p.k(paramString, "value");
    this.errMsg = paramString;
    if (this.vkO) {
      fqW();
    }
    AppMethodBeat.o(39610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoErrMsgPreference
 * JD-Core Version:    0.7.0.1
 */