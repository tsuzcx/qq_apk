package com.tenpay.android.wechat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import com.tenpay.bankcard.LogUtil;
import java.lang.reflect.Method;

public class TenpayAccessibilityDelegate
  extends View.AccessibilityDelegate
{
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return null;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    LogUtil.d("CFT", new Object[] { "sendAccessibilityEvent eventType=" + paramInt });
    Object localObject1;
    if ((paramView != null) && (paramInt == 128)) {
      if ((paramView instanceof EditText))
      {
        LogUtil.d("CFT", new Object[] { "EditText" });
        localObject1 = (EditText)paramView;
        if (!TextUtils.isEmpty(((EditText)localObject1).getContentDescription())) {
          localObject1 = ((EditText)localObject1).getContentDescription();
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramInt = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (paramInt >= ((CharSequence)localObject1).length()) {
            break;
          }
          TenpayTTSUtil.speak(String.valueOf(((CharSequence)localObject1).charAt(paramInt)));
          paramInt += 1;
        }
        if (((EditText)localObject1).getHint() != null)
        {
          localObject1 = ((EditText)localObject1).getHint();
          continue;
          LogUtil.d("CFT", new Object[] { "not EditText" });
          localObject2 = paramView.getContentDescription();
          TenpayTTSUtil.speak((CharSequence)localObject2);
        }
      }
      else
      {
        LogUtil.d("CFT", new Object[] { "content = " + localObject2 });
        LogUtil.d("CFT", new Object[] { "host.getContentDescription() = " + paramView.getContentDescription() });
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          localObject1 = View.class.getMethod("clearAccessibilityFocus", null);
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramView, null);
          localObject1 = View.class.getMethod("requestAccessibilityFocus", null);
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramView, null);
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpayAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */