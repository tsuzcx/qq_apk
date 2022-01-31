package com.tencent.toybrick.c;

import android.os.Handler;
import android.view.View;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b.a;
import com.tencent.toybrick.ui.BaseToyUI;

public abstract class f<S extends f, T extends a>
{
  public boolean isVisible;
  public Handler mMainHandler;
  BaseToyUI xaY;
  public Runnable xaZ;
  public String xba;
  public b.a<S> xbb;
  
  public abstract void a(T paramT);
  
  public abstract T er(View paramView);
  
  public abstract int getLayoutResource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.f
 * JD-Core Version:    0.7.0.1
 */