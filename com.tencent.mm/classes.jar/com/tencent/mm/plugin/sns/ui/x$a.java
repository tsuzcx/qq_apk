package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class x$a
{
  public View.OnClickListener xno = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(97924);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(97924);
        return;
      }
      int i = ((Integer)paramAnonymousView.getTag()).intValue();
      x.a.this.Je(i);
      AppMethodBeat.o(97924);
    }
  };
  
  public abstract void Je(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.x.a
 * JD-Core Version:    0.7.0.1
 */