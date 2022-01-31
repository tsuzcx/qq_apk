package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.model.be.b;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class k
  extends b
{
  LinearLayout AmM;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34673);
    this.AmM = null;
    this.AmM = new LinearLayout(paramContext);
    this.AmM.setVisibility(8);
    be.aaG().fmq = new k.1(this, paramContext);
    be.aaG().fmq.aaK();
    AppMethodBeat.o(34673);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34674);
    if ((this.AmM != null) && (this.AmM.getVisibility() == 0))
    {
      AppMethodBeat.o(34674);
      return true;
    }
    AppMethodBeat.o(34674);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(34675);
    be.aaG().fmq = null;
    AppMethodBeat.o(34675);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.AmM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */