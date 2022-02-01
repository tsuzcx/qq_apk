package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoNotFollowPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindView", "", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Landroid/widget/TextView;", "onBindView", "", "view", "Landroid/view/View;", "setText", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NewBizInfoNotFollowPreference
  extends Preference
{
  private String title = "";
  private TextView titleTv;
  private boolean yxr;
  
  public NewBizInfoNotFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewBizInfoNotFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39613);
    s.u(paramView, "view");
    super.onBindView(paramView);
    paramView = paramView.findViewById(R.h.ftB);
    s.s(paramView, "view.findViewById(R.id.biz_follow_tv)");
    this.titleTv = ((TextView)paramView);
    this.yxr = true;
    int i;
    if (!n.bp((CharSequence)this.title))
    {
      i = 1;
      if (i != 0)
      {
        paramView = this.titleTv;
        if (paramView != null) {
          break label100;
        }
        s.bIx("titleTv");
        paramView = null;
      }
    }
    label100:
    for (;;)
    {
      paramView.setText((CharSequence)this.title);
      AppMethodBeat.o(39613);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoNotFollowPreference
 * JD-Core Version:    0.7.0.1
 */