package com.tencent.mm.plugin.profile.ui.newbizinfo;

import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoErrMsgPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "errMsg", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsgTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"})
public final class NewBizInfoErrMsgPreference
  extends Preference
{
  private String errMsg = "";
  private boolean lJS;
  private MMNeat7extView pDu;
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void ccQ()
  {
    AppMethodBeat.i(154026);
    MMNeat7extView localMMNeat7extView = this.pDu;
    if (localMMNeat7extView == null) {
      a.f.b.j.ays("errMsgTv");
    }
    localMMNeat7extView.af((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.g(localMMNeat7extView.getContext(), (CharSequence)this.errMsg, (int)localMMNeat7extView.getTextSize()));
    AppMethodBeat.o(154026);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(154025);
    a.f.b.j.q(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131823039);
    MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView;
    localMMNeat7extView.setTextSize(1, 16.0F);
    localMMNeat7extView.setTextColor(localMMNeat7extView.getResources().getColor(2131690156));
    a.f.b.j.p(paramView, "view.findViewById<MMNeat…ey_text_color))\n        }");
    this.pDu = ((MMNeat7extView)paramView);
    this.lJS = true;
    ccQ();
    AppMethodBeat.o(154025);
  }
  
  public final void setErrMsg(String paramString)
  {
    AppMethodBeat.i(154027);
    a.f.b.j.q(paramString, "value");
    this.errMsg = paramString;
    if (this.lJS) {
      ccQ();
    }
    AppMethodBeat.o(154027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoErrMsgPreference
 * JD-Core Version:    0.7.0.1
 */