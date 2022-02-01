package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkInitializer;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154157);
    ((TextView)this.IST.ISL.findViewById(2131306169)).setText(this.IST.xJ(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
    AppMethodBeat.o(154157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.6
 * JD-Core Version:    0.7.0.1
 */