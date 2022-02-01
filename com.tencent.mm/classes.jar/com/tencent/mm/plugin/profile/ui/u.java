package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.textstatus.a.ac;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/ProfileWordingSetHelper;", "", "()V", "permissionTitle", "", "v", "Landroid/view/View;", "talkOnlyTips", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u Naf;
  
  static
  {
    AppMethodBeat.i(305609);
    Naf = new u();
    AppMethodBeat.o(305609);
  }
  
  public static void iE(View paramView)
  {
    AppMethodBeat.i(305602);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!ac.hFS()) {
        break label38;
      }
    }
    label38:
    for (int i = R.l.gSs;; i = R.l.gSr)
    {
      paramView.setText(i);
      AppMethodBeat.o(305602);
      return;
    }
  }
  
  public static void iF(View paramView)
  {
    AppMethodBeat.i(305606);
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (!ac.hFS()) {
        break label38;
      }
    }
    label38:
    for (int i = R.l.gSv;; i = R.l.gSu)
    {
      paramView.setText(i);
      AppMethodBeat.o(305606);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.u
 * JD-Core Version:    0.7.0.1
 */