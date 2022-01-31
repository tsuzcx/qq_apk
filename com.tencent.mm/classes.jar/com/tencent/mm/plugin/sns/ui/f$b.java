package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class f$b
{
  View.OnClickListener rEm = new f.b.1(this);
  View.OnClickListener rEn = new f.b.2(this);
  View.OnClickListener rEo = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(38085);
      f.b.this.rEp = ((f.b.a)paramAnonymousView.getTag());
      int i = f.b.this.rEp.position;
      f.b.this.EB(i);
      AppMethodBeat.o(38085);
    }
  };
  public f.b.a rEp = new f.b.a();
  
  public abstract void EB(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.b
 * JD-Core Version:    0.7.0.1
 */