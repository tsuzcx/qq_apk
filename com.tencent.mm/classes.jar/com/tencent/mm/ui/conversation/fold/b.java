package com.tencent.mm.ui.conversation.fold;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;

public final class b
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private View doN;
  private TextView lDI;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(256859);
    this.doN = null;
    if (this.view != null)
    {
      this.doN = this.view.findViewById(R.h.fSF);
      this.lDI = ((TextView)this.view.findViewById(R.h.fIM));
      this.lDI.setText(paramContext.getString(R.l.gxl));
    }
    AppMethodBeat.o(256859);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.geV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.fold.b
 * JD-Core Version:    0.7.0.1
 */