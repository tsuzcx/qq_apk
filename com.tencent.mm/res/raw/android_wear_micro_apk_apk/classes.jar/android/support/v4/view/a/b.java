package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class b
{
  private final AccessibilityNodeInfo om;
  public int on = -1;
  
  private b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.om = paramAccessibilityNodeInfo;
  }
  
  public static b a(b paramb)
  {
    return a(AccessibilityNodeInfo.obtain(paramb.om));
  }
  
  public static b a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new b(paramAccessibilityNodeInfo);
  }
  
  public final boolean a(c paramc)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.om.removeAction((AccessibilityNodeInfo.AccessibilityAction)paramc.oS);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.om.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.om.addChild(paramView);
  }
  
  public final AccessibilityNodeInfo bX()
  {
    return this.om;
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
        paramObject = (b)paramObject;
        if (this.om != null) {
          break;
        }
      } while (paramObject.om == null);
      return false;
    } while (this.om.equals(paramObject.om));
    return false;
  }
  
  public final int getActions()
  {
    return this.om.getActions();
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.om.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.om.getBoundsInScreen(paramRect);
  }
  
  public final CharSequence getClassName()
  {
    return this.om.getClassName();
  }
  
  public final CharSequence getContentDescription()
  {
    return this.om.getContentDescription();
  }
  
  public final int getMovementGranularities()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.om.getMovementGranularities();
    }
    return 0;
  }
  
  public final CharSequence getPackageName()
  {
    return this.om.getPackageName();
  }
  
  public final int hashCode()
  {
    if (this.om == null) {
      return 0;
    }
    return this.om.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.om.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isClickable()
  {
    return this.om.isClickable();
  }
  
  public final boolean isEnabled()
  {
    return this.om.isEnabled();
  }
  
  public final boolean isFocusable()
  {
    return this.om.isFocusable();
  }
  
  public final boolean isFocused()
  {
    return this.om.isFocused();
  }
  
  public final boolean isLongClickable()
  {
    return this.om.isLongClickable();
  }
  
  public final boolean isSelected()
  {
    return this.om.isSelected();
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.om.isVisibleToUser();
    }
    return false;
  }
  
  public final void recycle()
  {
    this.om.recycle();
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.om.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.om.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.om.setBoundsInScreen(paramRect);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.om.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.om.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.om.setContentDescription(paramCharSequence);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.om.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.om.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.om.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.om.setLongClickable(paramBoolean);
  }
  
  public final void setMovementGranularities(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.om.setMovementGranularities(paramInt);
    }
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.om.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.om.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.om.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.om.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.om.setSource(paramView);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.om.setVisibleToUser(paramBoolean);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder1.append("; boundsInParent: ".concat(String.valueOf(localObject)));
    getBoundsInScreen((Rect)localObject);
    localStringBuilder1.append("; boundsInScreen: ".concat(String.valueOf(localObject)));
    localStringBuilder1.append("; packageName: ").append(this.om.getPackageName());
    localStringBuilder1.append("; className: ").append(this.om.getClassName());
    localStringBuilder1.append("; text: ").append(this.om.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.om.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.om.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.om.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.om.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.om.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.om.isFocused());
      localStringBuilder1.append("; selected: ").append(this.om.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.om.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.om.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.om.isEnabled());
      localStringBuilder1.append("; password: ").append(this.om.isPassword());
      localStringBuilder1.append("; scrollable: " + this.om.isScrollable());
      localStringBuilder1.append("; [");
      i = this.om.getActions();
      label379:
      if (i == 0) {
        break label710;
      }
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i = (j ^ 0xFFFFFFFF) & i;
      switch (j)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
    }
    for (;;)
    {
      localStringBuilder1.append((String)localObject);
      if (i != 0) {
        localStringBuilder1.append(", ");
      }
      break label379;
      localObject = null;
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
    label710:
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public final void v(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.om.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)((d)paramObject).oT);
    }
  }
  
  public final void w(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.om.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)((e)paramObject).oT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.b
 * JD-Core Version:    0.7.0.1
 */