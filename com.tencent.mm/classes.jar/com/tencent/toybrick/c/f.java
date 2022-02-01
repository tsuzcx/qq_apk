package com.tencent.toybrick.c;

import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b.a;
import com.tencent.toybrick.ui.BaseToyUI;
import com.tencent.toybrick.ui.BaseToyUI.a;

public abstract class f<S extends f, T extends a>
{
  BaseToyUI MiT;
  public Runnable MiU;
  public String MiV;
  public b.a<S> MiW;
  public boolean isVisible;
  public Handler mMainHandler;
  
  public abstract void a(T paramT);
  
  public abstract int getLayoutResource();
  
  public abstract T hp(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.f
 * JD-Core Version:    0.7.0.1
 */