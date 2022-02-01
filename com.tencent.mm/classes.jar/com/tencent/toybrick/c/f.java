package com.tencent.toybrick.c;

import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b.a;
import com.tencent.toybrick.ui.BaseToyUI;
import com.tencent.toybrick.ui.BaseToyUI.a;

public abstract class f<S extends f, T extends a>
{
  BaseToyUI KsS;
  public Runnable KsT;
  public String KsU;
  public b.a<S> KsV;
  public boolean isVisible;
  public Handler mMainHandler;
  
  public abstract void a(T paramT);
  
  public abstract T gY(View paramView);
  
  public abstract int getLayoutResource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.f
 * JD-Core Version:    0.7.0.1
 */