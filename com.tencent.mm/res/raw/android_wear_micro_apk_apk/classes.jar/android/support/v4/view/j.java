package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class j
{
  private final View bo;
  private ViewParent jP;
  private ViewParent jQ;
  private boolean jR;
  private int[] jS;
  
  public j(View paramView)
  {
    this.bo = paramView;
  }
  
  private void a(int paramInt, ViewParent paramViewParent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jP = paramViewParent;
      return;
    }
    this.jQ = paramViewParent;
  }
  
  private ViewParent v(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.jP;
    }
    return this.jQ;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.jR)
    {
      localViewParent = v(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0))
      {
        if (paramArrayOfInt == null) {
          break label136;
        }
        this.bo.getLocationInWindow(paramArrayOfInt);
        j = paramArrayOfInt[0];
        i = paramArrayOfInt[1];
      }
    }
    for (;;)
    {
      ao.a(localViewParent, this.bo, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (paramArrayOfInt != null)
      {
        this.bo.getLocationInWindow(paramArrayOfInt);
        paramArrayOfInt[0] -= j;
        paramArrayOfInt[1] -= i;
      }
      return true;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
      }
      return false;
      label136:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.jR)
    {
      localViewParent = v(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramArrayOfInt2 == null) {
          break label173;
        }
        this.bo.getLocationInWindow(paramArrayOfInt2);
        j = paramArrayOfInt2[0];
        i = paramArrayOfInt2[1];
      }
    }
    for (;;)
    {
      if (paramArrayOfInt1 == null)
      {
        if (this.jS == null) {
          this.jS = new int[2];
        }
        paramArrayOfInt1 = this.jS;
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        ao.a(localViewParent, this.bo, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.bo.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= j;
          paramArrayOfInt2[1] -= i;
        }
        return (paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0);
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        return false;
      }
      label173:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2)
  {
    if (t(paramInt2)) {
      return true;
    }
    if (this.jR)
    {
      ViewParent localViewParent = this.bo.getParent();
      View localView = this.bo;
      while (localViewParent != null)
      {
        if (ao.a(localViewParent, localView, this.bo, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          ao.b(localViewParent, localView, this.bo, paramInt1, paramInt2);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jR)
    {
      ViewParent localViewParent = v(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = ao.a(localViewParent, this.bo, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jR)
    {
      ViewParent localViewParent = v(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = ao.a(localViewParent, this.bo, paramFloat1, paramFloat2);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public final boolean hasNestedScrollingParent()
  {
    return t(0);
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.jR;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.jR) {
      r.u(this.bo);
    }
    this.jR = paramBoolean;
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    return c(paramInt, 0);
  }
  
  public final void stopNestedScroll()
  {
    u(0);
  }
  
  public final boolean t(int paramInt)
  {
    return v(paramInt) != null;
  }
  
  public final void u(int paramInt)
  {
    ViewParent localViewParent = v(paramInt);
    if (localViewParent != null)
    {
      ao.a(localViewParent, this.bo, paramInt);
      a(paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.j
 * JD-Core Version:    0.7.0.1
 */