package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoErrMsgPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "errMsg", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsgTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NewBizInfoErrMsgPreference
  extends Preference
{
  private MMNeat7extView NbM;
  private String errMsg = "";
  private boolean yxr;
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewBizInfoErrMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39608);
    s.u(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(R.h.ftI);
    Object localObject = (MMNeat7extView)paramView;
    ((MMNeat7extView)localObject).setTextSize(1, 16.0F);
    ((MMNeat7extView)localObject).setTextColor(((MMNeat7extView)localObject).getResources().getColor(R.e.grey_text_color));
    localObject = ah.aiuX;
    s.s(paramView, "view.findViewById<MMNeat…ey_text_color))\n        }");
    this.NbM = ((MMNeat7extView)paramView);
    this.yxr = true;
    paramView = this.NbM;
    if (paramView == null)
    {
      s.bIx("errMsgTv");
      paramView = null;
    }
    for (;;)
    {
      paramView.aZ((CharSequence)p.j(paramView.getContext(), (CharSequence)this.errMsg, (int)paramView.getTextSize()));
      AppMethodBeat.o(39608);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoErrMsgPreference
 * JD-Core Version:    0.7.0.1
 */