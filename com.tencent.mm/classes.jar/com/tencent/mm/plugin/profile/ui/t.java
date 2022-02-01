package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/ProfileWordingSetHelper;", "", "()V", "permissionTitle", "", "v", "Landroid/view/View;", "talkOnlyTips", "app_release"})
public final class t
{
  public static final t HbX;
  
  static
  {
    AppMethodBeat.i(285600);
    HbX = new t();
    AppMethodBeat.o(285600);
  }
  
  public static void fK(View paramView)
  {
    AppMethodBeat.i(285596);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!com.tencent.mm.plugin.textstatus.a.t.gkZ()) {
        break label38;
      }
    }
    label38:
    for (int i = R.l.ePP;; i = R.l.ePO)
    {
      paramView.setText(i);
      AppMethodBeat.o(285596);
      return;
    }
  }
  
  public static void fL(View paramView)
  {
    AppMethodBeat.i(285597);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!com.tencent.mm.plugin.textstatus.a.t.gkZ()) {
        break label38;
      }
    }
    label38:
    for (int i = R.l.ePS;; i = R.l.ePR)
    {
      paramView.setText(i);
      AppMethodBeat.o(285597);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.t
 * JD-Core Version:    0.7.0.1
 */