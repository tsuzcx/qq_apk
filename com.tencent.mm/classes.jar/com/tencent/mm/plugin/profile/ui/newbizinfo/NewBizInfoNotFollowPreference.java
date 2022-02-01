package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoNotFollowPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Landroid/widget/TextView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"})
public final class NewBizInfoNotFollowPreference
  extends Preference
{
  private boolean pDN;
  private String title = "";
  private TextView titleTv;
  
  public NewBizInfoNotFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewBizInfoNotFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void dqQ()
  {
    AppMethodBeat.i(39614);
    if (!n.aD((CharSequence)this.title)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        TextView localTextView = this.titleTv;
        if (localTextView == null) {
          k.aVY("titleTv");
        }
        localTextView.setText((CharSequence)this.title);
      }
      AppMethodBeat.o(39614);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39613);
    k.h(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131297287);
    k.g(paramView, "view.findViewById(R.id.biz_follow_tv)");
    this.titleTv = ((TextView)paramView);
    this.pDN = true;
    dqQ();
    AppMethodBeat.o(39613);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(39615);
    k.h(paramString, "value");
    this.title = paramString;
    if (this.pDN) {
      dqQ();
    }
    AppMethodBeat.o(39615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoNotFollowPreference
 * JD-Core Version:    0.7.0.1
 */