package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.e;
import android.support.v4.view.a.p;
import android.support.v4.view.r;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class ao
  extends a
{
  final RecyclerView uk;
  final a vs = new a()
  {
    public final void a(View paramAnonymousView, e paramAnonymouse)
    {
      super.a(paramAnonymousView, paramAnonymouse);
      if ((!ao.this.uk.dC()) && (ao.this.uk.df() != null)) {
        ao.this.uk.df().b(paramAnonymousView, paramAnonymouse);
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
        } while (ao.this.uk.dC());
        bool1 = bool2;
      } while (ao.this.uk.df() == null);
      paramAnonymousView = ao.this.uk.df();
      paramAnonymousBundle = paramAnonymousView.uk.sY;
      paramAnonymousView = paramAnonymousView.uk.tM;
      return false;
    }
  };
  
  public ao(RecyclerView paramRecyclerView)
  {
    this.uk = paramRecyclerView;
  }
  
  public final void a(View paramView, e parame)
  {
    super.a(paramView, parame);
    parame.setClassName(RecyclerView.class.getName());
    if ((!this.uk.dC()) && (this.uk.df() != null))
    {
      paramView = this.uk.df();
      af localaf = paramView.uk.sY;
      ak localak = paramView.uk.tM;
      if ((r.b(paramView.uk, -1)) || (r.a(paramView.uk, -1)))
      {
        parame.addAction(8192);
        parame.setScrollable(true);
      }
      if ((r.b(paramView.uk, 1)) || (r.a(paramView.uk, 1)))
      {
        parame.addAction(4096);
        parame.setScrollable(true);
      }
      parame.o(p.b(paramView.a(localaf, localak), paramView.b(localaf, localak), false, 0));
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!this.uk.dC()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.df() != null) {
        paramView.df().onInitializeAccessibilityEvent(paramAccessibilityEvent);
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
          } while (this.uk.dC());
          bool1 = bool2;
        } while (this.uk.df() == null);
        paramView = this.uk.df();
        paramBundle = paramView.uk.sY;
        paramBundle = paramView.uk.tM;
        bool1 = bool2;
      } while (paramView.uk == null);
      switch (paramInt)
      {
      default: 
        i = 0;
        paramInt = 0;
        if (paramInt != 0) {
          break label126;
        }
        bool1 = bool2;
      }
    } while (i == 0);
    label126:
    paramView.uk.scrollBy(i, paramInt);
    return true;
    if (r.b(paramView.uk, -1)) {}
    for (paramInt = -(paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      if (r.a(paramView.uk, -1))
      {
        i = -(paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight());
        break;
        if (!r.b(paramView.uk, 1)) {
          break label271;
        }
      }
      label271:
      for (paramInt = paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (r.a(paramView.uk, 1))
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