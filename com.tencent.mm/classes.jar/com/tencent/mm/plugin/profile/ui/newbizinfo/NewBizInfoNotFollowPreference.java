package com.tencent.mm.plugin.profile.ui.newbizinfo;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoNotFollowPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Landroid/widget/TextView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"})
public final class NewBizInfoNotFollowPreference
  extends Preference
{
  private boolean lJS;
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
  
  private final void ccQ()
  {
    AppMethodBeat.i(154031);
    if (!m.ap((CharSequence)this.title)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        TextView localTextView = this.titleTv;
        if (localTextView == null) {
          j.ays("titleTv");
        }
        localTextView.setText((CharSequence)this.title);
      }
      AppMethodBeat.o(154031);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(154030);
    j.q(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131823163);
    j.p(paramView, "view.findViewById(R.id.biz_follow_tv)");
    this.titleTv = ((TextView)paramView);
    this.lJS = true;
    ccQ();
    AppMethodBeat.o(154030);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(154032);
    j.q(paramString, "value");
    this.title = paramString;
    if (this.lJS) {
      ccQ();
    }
    AppMethodBeat.o(154032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoNotFollowPreference
 * JD-Core Version:    0.7.0.1
 */