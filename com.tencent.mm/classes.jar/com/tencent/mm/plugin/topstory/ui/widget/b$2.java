package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adl;
import java.util.Set;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb, adl paramadl, TextView paramTextView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2228);
    if (b.a(this.tmx).contains(this.tmy))
    {
      b.a(this.tmx).remove(this.tmy);
      this.tmz.setTextColor(this.val$context.getResources().getColor(2131690597));
      this.tmz.setBackgroundResource(2130840612);
    }
    while (b.a(this.tmx).isEmpty())
    {
      b.c(this.tmx).setText(b.b(this.tmx).cyA);
      AppMethodBeat.o(2228);
      return;
      b.a(this.tmx).add(this.tmy);
      this.tmz.setTextColor(this.val$context.getResources().getColor(2131690596));
      this.tmz.setBackgroundResource(2130840611);
    }
    b.c(this.tmx).setText(this.val$context.getString(2131304332));
    AppMethodBeat.o(2228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b.2
 * JD-Core Version:    0.7.0.1
 */