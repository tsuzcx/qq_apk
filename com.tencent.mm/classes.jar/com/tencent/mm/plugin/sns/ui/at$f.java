package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

abstract class at$f
{
  View.OnClickListener rEm = new at.f.1(this);
  View.OnClickListener rEn = new at.f.2(this);
  View.OnClickListener rEo = new at.f.3(this);
  View.OnClickListener rVj = new at.f.4(this);
  View.OnClickListener rVk = new at.f.5(this);
  View.OnClickListener rVl = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(39216);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(39216);
        return;
      }
      ab.d("MicroMsg.SnsphotoAdapter", "snssight click");
      at.f.this.rVn = ((at.f.a)paramAnonymousView.getTag());
      int i = at.f.this.rVn.cIp;
      int j = at.f.this.rVn.position;
      at.f.this.fK(i, j + 2);
      AppMethodBeat.o(39216);
    }
  };
  View.OnLongClickListener rVm = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(39217);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(39217);
        return true;
      }
      ab.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
      at.f.this.rVn = ((at.f.a)paramAnonymousView.getTag());
      int i = at.f.this.rVn.cIp;
      int j = at.f.this.rVn.position;
      at.f.this.fL(i, j);
      AppMethodBeat.o(39217);
      return true;
    }
  };
  public at.f.a rVn = new at.f.a();
  
  public abstract void EU(int paramInt);
  
  public abstract void fJ(int paramInt1, int paramInt2);
  
  public abstract void fK(int paramInt1, int paramInt2);
  
  public abstract void fL(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.f
 * JD-Core Version:    0.7.0.1
 */