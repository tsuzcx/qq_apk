package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

public final class e
{
  static final o mr = new o();
  private final AccessibilityNodeInfo ms;
  public int mt = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      mr = new n();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      mr = new m();
      return;
    }
    if (Build.VERSION.SDK_INT >= 22)
    {
      mr = new l();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mr = new k();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      mr = new j();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      mr = new i();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      mr = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      mr = new g();
      return;
    }
  }
  
  private e(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.ms = paramAccessibilityNodeInfo;
  }
  
  public static e a(e parame)
  {
    return a(AccessibilityNodeInfo.obtain(parame.ms));
  }
  
  public static e a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new e(paramAccessibilityNodeInfo);
  }
  
  public final boolean a(f paramf)
  {
    return mr.c(this.ms, paramf.mY);
  }
  
  public final void addAction(int paramInt)
  {
    this.ms.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.ms.addChild(paramView);
  }
  
  public final AccessibilityNodeInfo bF()
  {
    return this.ms;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (e)paramObject;
        if (this.ms != null) {
          break;
        }
      } while (paramObject.ms == null);
      return false;
    } while (this.ms.equals(paramObject.ms));
    return false;
  }
  
  public final int getActions()
  {
    return this.ms.getActions();
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.ms.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.ms.getBoundsInScreen(paramRect);
  }
  
  public final CharSequence getClassName()
  {
    return this.ms.getClassName();
  }
  
  public final CharSequence getContentDescription()
  {
    return this.ms.getContentDescription();
  }
  
  public final int getMovementGranularities()
  {
    return mr.d(this.ms);
  }
  
  public final CharSequence getPackageName()
  {
    return this.ms.getPackageName();
  }
  
  public final int hashCode()
  {
    if (this.ms == null) {
      return 0;
    }
    return this.ms.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    return mr.c(this.ms);
  }
  
  public final boolean isClickable()
  {
    return this.ms.isClickable();
  }
  
  public final boolean isEnabled()
  {
    return this.ms.isEnabled();
  }
  
  public final boolean isFocusable()
  {
    return this.ms.isFocusable();
  }
  
  public final boolean isFocused()
  {
    return this.ms.isFocused();
  }
  
  public final boolean isLongClickable()
  {
    return this.ms.isLongClickable();
  }
  
  public final boolean isSelected()
  {
    return this.ms.isSelected();
  }
  
  public final boolean isVisibleToUser()
  {
    return mr.b(this.ms);
  }
  
  public final void o(Object paramObject)
  {
    mr.a(this.ms, ((p)paramObject).mZ);
  }
  
  public final void p(Object paramObject)
  {
    mr.b(this.ms, ((q)paramObject).mZ);
  }
  
  public final void recycle()
  {
    this.ms.recycle();
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    mr.b(this.ms, paramBoolean);
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.ms.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.ms.setBoundsInScreen(paramRect);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.ms.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.ms.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.ms.setContentDescription(paramCharSequence);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.ms.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.ms.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.ms.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.ms.setLongClickable(paramBoolean);
  }
  
  public final void setMovementGranularities(int paramInt)
  {
    mr.a(this.ms, paramInt);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.ms.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.ms.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.ms.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.ms.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.ms.setSource(paramView);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    mr.a(this.ms, paramBoolean);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder.append("; boundsInParent: " + localObject);
    getBoundsInScreen((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: " + localObject);
    localStringBuilder.append("; packageName: ").append(this.ms.getPackageName());
    localStringBuilder.append("; className: ").append(this.ms.getClassName());
    localStringBuilder.append("; text: ").append(this.ms.getText());
    localStringBuilder.append("; contentDescription: ").append(this.ms.getContentDescription());
    localStringBuilder.append("; viewId: ").append(mr.e(this.ms));
    localStringBuilder.append("; checkable: ").append(this.ms.isCheckable());
    localStringBuilder.append("; checked: ").append(this.ms.isChecked());
    localStringBuilder.append("; focusable: ").append(this.ms.isFocusable());
    localStringBuilder.append("; focused: ").append(this.ms.isFocused());
    localStringBuilder.append("; selected: ").append(this.ms.isSelected());
    localStringBuilder.append("; clickable: ").append(this.ms.isClickable());
    localStringBuilder.append("; longClickable: ").append(this.ms.isLongClickable());
    localStringBuilder.append("; enabled: ").append(this.ms.isEnabled());
    localStringBuilder.append("; password: ").append(this.ms.isPassword());
    localStringBuilder.append("; scrollable: " + this.ms.isScrollable());
    localStringBuilder.append("; [");
    int i = this.ms.getActions();
    if (i != 0)
    {
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i = (j ^ 0xFFFFFFFF) & i;
      switch (j)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        if (i != 0) {
          localStringBuilder.append(", ");
        }
        break;
        localObject = "ACTION_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_FOCUS";
        continue;
        localObject = "ACTION_SELECT";
        continue;
        localObject = "ACTION_CLEAR_SELECTION";
        continue;
        localObject = "ACTION_CLICK";
        continue;
        localObject = "ACTION_LONG_CLICK";
        continue;
        localObject = "ACTION_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_NEXT_HTML_ELEMENT";
        continue;
        localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue;
        localObject = "ACTION_SCROLL_FORWARD";
        continue;
        localObject = "ACTION_SCROLL_BACKWARD";
        continue;
        localObject = "ACTION_CUT";
        continue;
        localObject = "ACTION_COPY";
        continue;
        localObject = "ACTION_PASTE";
        continue;
        localObject = "ACTION_SET_SELECTION";
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */