package com.tenpay.android.wechat;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

class MyKeyboardAccessibilityDelegateWrap
  extends View.AccessibilityDelegate
{
  private static final String TAG = "MicroMsg.MyKeyboardAccessibilityDelegateWrap";
  private View.AccessibilityDelegate origin = null;
  private String viewTypeName = null;
  
  public MyKeyboardAccessibilityDelegateWrap() {}
  
  public MyKeyboardAccessibilityDelegateWrap(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.origin = paramAccessibilityDelegate;
  }
  
  public void addExtraDataToAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(208564);
    try
    {
      if (this.origin == null)
      {
        super.addExtraDataToAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo, paramString, paramBundle);
        AppMethodBeat.o(208564);
        return;
      }
      if (Build.VERSION.SDK_INT >= 26) {
        this.origin.addExtraDataToAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo, paramString, paramBundle);
      }
      AppMethodBeat.o(208564);
      return;
    }
    catch (Exception paramView)
    {
      Log.e("MicroMsg.MyKeyboardAccessibilityDelegateWrap", paramView.getMessage());
      AppMethodBeat.o(208564);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(208556);
    if (this.origin == null)
    {
      bool = super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(208556);
      return bool;
    }
    boolean bool = this.origin.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(208556);
    return bool;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(208571);
    if (this.origin == null)
    {
      paramView = super.getAccessibilityNodeProvider(paramView);
      AppMethodBeat.o(208571);
      return paramView;
    }
    paramView = this.origin.getAccessibilityNodeProvider(paramView);
    AppMethodBeat.o(208571);
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(208561);
    if (this.origin == null)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(208561);
      return;
    }
    this.origin.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(208561);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(208545);
    if (this.origin == null) {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    }
    for (;;)
    {
      if ((paramAccessibilityNodeInfo != null) && (this.viewTypeName != null)) {
        paramAccessibilityNodeInfo.setClassName(this.viewTypeName);
      }
      AppMethodBeat.o(208545);
      return;
      this.origin.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    }
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(208557);
    if (this.origin == null)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(208557);
      return;
    }
    this.origin.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(208557);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(208568);
    if (this.origin == null)
    {
      bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      AppMethodBeat.o(208568);
      return bool;
    }
    boolean bool = this.origin.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    AppMethodBeat.o(208568);
    return bool;
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(208552);
    if (this.origin == null)
    {
      bool = super.performAccessibilityAction(paramView, paramInt, paramBundle);
      AppMethodBeat.o(208552);
      return bool;
    }
    boolean bool = this.origin.performAccessibilityAction(paramView, paramInt, paramBundle);
    AppMethodBeat.o(208552);
    return bool;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(208549);
    if (this.origin == null)
    {
      super.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(208549);
      return;
    }
    this.origin.sendAccessibilityEvent(paramView, paramInt);
    AppMethodBeat.o(208549);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(208554);
    if (this.origin == null)
    {
      super.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(208554);
      return;
    }
    this.origin.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(208554);
  }
  
  public void setViewTypeName(String paramString)
  {
    this.viewTypeName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tenpay.android.wechat.MyKeyboardAccessibilityDelegateWrap
 * JD-Core Version:    0.7.0.1
 */