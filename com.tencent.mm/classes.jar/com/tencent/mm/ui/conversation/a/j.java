package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bc.b;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class j
  extends b
{
  LinearLayout vUL = null;
  
  public j(Context paramContext)
  {
    super(paramContext);
    this.vUL = new LinearLayout(paramContext);
    this.vUL.setVisibility(8);
    bc.HI().dWg = new j.1(this, paramContext);
    bc.HI().dWg.HL();
  }
  
  public final boolean apu()
  {
    return (this.vUL != null) && (this.vUL.getVisibility() == 0);
  }
  
  public final void destroy()
  {
    bc.HI().dWg = null;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.vUL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */