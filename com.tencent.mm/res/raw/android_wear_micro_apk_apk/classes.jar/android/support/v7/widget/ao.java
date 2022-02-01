package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.d;
import android.support.v4.view.r;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class ao
  extends a
{
  final RecyclerView wa;
  final a xh = new a()
  {
    public final void a(View paramAnonymousView, b paramAnonymousb)
    {
      super.a(paramAnonymousView, paramAnonymousb);
      if ((!ao.this.wa.dQ()) && (ao.this.wa.jdMethod_do() != null)) {
        ao.this.wa.jdMethod_do().b(paramAnonymousView, paramAnonymousb);
      }
    }
    
    public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      boolean bool2 = false;
      boolean bool1;
      if (super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle)) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (ao.this.wa.dQ());
        bool1 = bool2;
      } while (ao.this.wa.jdMethod_do() == null);
      return false;
    }
  };
  
  public ao(RecyclerView paramRecyclerView)
  {
    this.wa = paramRecyclerView;
  }
  
  public final void a(View paramView, b paramb)
  {
    super.a(paramView, paramb);
    paramb.setClassName(RecyclerView.class.getName());
    if ((!this.wa.dQ()) && (this.wa.jdMethod_do() != null))
    {
      paramView = this.wa.jdMethod_do();
      af localaf = paramView.wa.uO;
      ak localak = paramView.wa.vC;
      if ((r.e(paramView.wa, -1)) || (r.d(paramView.wa, -1)))
      {
        paramb.addAction(8192);
        paramb.setScrollable(true);
      }
      if ((r.e(paramView.wa, 1)) || (r.d(paramView.wa, 1)))
      {
        paramb.addAction(4096);
        paramb.setScrollable(true);
      }
      paramb.v(d.a(paramView.a(localaf, localak), paramView.b(localaf, localak), false, 0));
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.wa.dQ()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.jdMethod_do() != null) {
        paramView.jdMethod_do().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (this.wa.dQ());
          bool1 = bool2;
        } while (this.wa.jdMethod_do() == null);
        paramView = this.wa.jdMethod_do();
        bool1 = bool2;
      } while (paramView.wa == null);
      switch (paramInt)
      {
      default: 
        i = 0;
        paramInt = 0;
        if (paramInt != 0) {
          break label110;
        }
        bool1 = bool2;
      }
    } while (i == 0);
    label110:
    paramView.wa.scrollBy(i, paramInt);
    return true;
    if (r.e(paramView.wa, -1)) {}
    for (paramInt = -(paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (r.d(paramView.wa, -1))
      {
        i = -(paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!r.e(paramView.wa, 1)) {
          break label255;
        }
      }
      label255:
      for (paramInt = paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (r.d(paramView.wa, 1))
        {
          i = paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight();
          break;
        }
        int j = 0;
        paramInt = i;
        i = j;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ao
 * JD-Core Version:    0.7.0.1
 */