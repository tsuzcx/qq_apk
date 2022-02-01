package com.tencent.mm.plugin.taskbar.api;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> FSp = new LinkedList();
  private int FSq = 0;
  
  public final void a(a parama)
  {
    if (!this.FSp.contains(parama)) {
      this.FSp.add(parama);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1) });
    if (paramBoolean1)
    {
      wl(paramBoolean2);
      if ((this.FSq & 0x2) == 0) {}
    }
    label197:
    for (;;)
    {
      return;
      this.FSq |= 0x2;
      this.FSq &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.FSp.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label197;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            locala.caC();
            continue;
            wm(paramBoolean2);
            if ((this.FSq & 0x4) != 0) {
              break;
            }
            this.FSq |= 0x4;
            this.FSq &= 0xFFFFFFFD;
            break label72;
          }
          locala.caB();
          continue;
        }
        if (paramBoolean2) {
          locala.zT(paramInt1);
        } else {
          locala.eG(paramInt1, paramInt2);
        }
      }
    }
  }
  
  public abstract void abu(int paramInt);
  
  public abstract void abv(int paramInt);
  
  public abstract void ac(MotionEvent paramMotionEvent);
  
  public final void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, 0, 0);
  }
  
  public abstract boolean esy();
  
  public abstract boolean fuw();
  
  public abstract void fux();
  
  public void fuy() {}
  
  public abstract void fuz();
  
  public abstract int getAnimationScrollOffset();
  
  public void i(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract void iE();
  
  public abstract void o(View paramView1, View paramView2);
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
  
  public abstract void wk(boolean paramBoolean);
  
  protected void wl(boolean paramBoolean) {}
  
  protected void wm(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void caB();
    
    public abstract void caC();
    
    public abstract void eG(int paramInt1, int paramInt2);
    
    public abstract void zT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.api.b
 * JD-Core Version:    0.7.0.1
 */