package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/ProfileWordingSetHelper;", "", "()V", "permissionTitle", "", "v", "Landroid/view/View;", "talkOnlyTips", "app_release"})
public final class t
{
  public static final t Urt;
  
  static
  {
    AppMethodBeat.i(258308);
    Urt = new t();
    AppMethodBeat.o(258308);
  }
  
  public static void hT(View paramView)
  {
    AppMethodBeat.i(258306);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!p.fvC()) {
        break label37;
      }
    }
    label37:
    for (int i = 2131764310;; i = 2131764057)
    {
      paramView.setText(i);
      AppMethodBeat.o(258306);
      return;
    }
  }
  
  public static void hU(View paramView)
  {
    AppMethodBeat.i(258307);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!p.fvC()) {
        break label37;
      }
    }
    label37:
    for (int i = 2131764416;; i = 2131764060)
    {
      paramView.setText(i);
      AppMethodBeat.o(258307);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.t
 * JD-Core Version:    0.7.0.1
 */