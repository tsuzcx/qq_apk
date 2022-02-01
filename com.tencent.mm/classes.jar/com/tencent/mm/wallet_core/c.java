package com.tencent.mm.wallet_core;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.a.a;

public class c
  extends View.AccessibilityDelegate
{
  private static final String TAG = "MicroMsg.KindaAccessibilityDelegate";
  private View.AccessibilityDelegate origin;
  private boolean shouldSpeakPassWord;
  private ViewType viewType;
  
  public c()
  {
    AppMethodBeat.i(242110);
    this.viewType = null;
    this.shouldSpeakPassWord = true;
    this.origin = null;
    init();
    AppMethodBeat.o(242110);
  }
  
  public c(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(242114);
    this.viewType = null;
    this.shouldSpeakPassWord = true;
    this.origin = null;
    this.origin = paramAccessibilityDelegate;
    init();
    AppMethodBeat.o(242114);
  }
  
  public c(ViewType paramViewType)
  {
    AppMethodBeat.i(242112);
    this.viewType = null;
    this.shouldSpeakPassWord = true;
    this.origin = null;
    init();
    setViewType(paramViewType);
    AppMethodBeat.o(242112);
  }
  
  private void init() {}
  
  public void addExtraDataToAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(242127);
    try
    {
      if (this.origin == null)
      {
        super.addExtraDataToAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo, paramString, paramBundle);
        AppMethodBeat.o(242127);
        return;
      }
      if (Build.VERSION.SDK_INT >= 26) {
        this.origin.addExtraDataToAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo, paramString, paramBundle);
      }
      AppMethodBeat.o(242127);
      return;
    }
    catch (Exception paramView)
    {
      Log.e("MicroMsg.KindaAccessibilityDelegate", paramView.getMessage());
      AppMethodBeat.o(242127);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242123);
    if (this.origin == null)
    {
      bool = super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(242123);
      return bool;
    }
    boolean bool = this.origin.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(242123);
    return bool;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(242130);
    if (this.origin == null)
    {
      paramView = super.getAccessibilityNodeProvider(paramView);
      AppMethodBeat.o(242130);
      return paramView;
    }
    paramView = this.origin.getAccessibilityNodeProvider(paramView);
    AppMethodBeat.o(242130);
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242126);
    if (this.origin == null)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(242126);
      return;
    }
    this.origin.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(242126);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(242117);
    if (this.origin == null) {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    }
    while ((paramAccessibilityNodeInfo != null) && (this.viewType != null)) {
      if (this.viewType == ViewType.TextView)
      {
        paramAccessibilityNodeInfo.setClassName("android.widget.TextView");
        AppMethodBeat.o(242117);
        return;
        this.origin.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      }
      else if (this.viewType == ViewType.Button)
      {
        paramAccessibilityNodeInfo.setClassName("android.widget.Button");
      }
    }
    AppMethodBeat.o(242117);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242124);
    if (this.origin == null)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(242124);
      return;
    }
    this.origin.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(242124);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242129);
    if (this.origin == null)
    {
      bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      AppMethodBeat.o(242129);
      return bool;
    }
    boolean bool = this.origin.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    AppMethodBeat.o(242129);
    return bool;
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(242121);
    if (this.origin == null)
    {
      bool = super.performAccessibilityAction(paramView, paramInt, paramBundle);
      AppMethodBeat.o(242121);
      return bool;
    }
    boolean bool = this.origin.performAccessibilityAction(paramView, paramInt, paramBundle);
    AppMethodBeat.o(242121);
    return bool;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(242118);
    if (this.shouldSpeakPassWord)
    {
      if (this.origin == null)
      {
        super.sendAccessibilityEvent(paramView, paramInt);
        AppMethodBeat.o(242118);
        return;
      }
      this.origin.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(242118);
      return;
    }
    if ((a.jlu()) && (d.rb(30)) && (a.a.jlv().jls()) && (paramInt == 32768))
    {
      super.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(242118);
      return;
    }
    if ((paramView != null) && ((paramInt == 128) || (paramInt == 1)))
    {
      a.a.jlv().kW(paramView);
      AppMethodBeat.o(242118);
      return;
    }
    AppMethodBeat.o(242118);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242122);
    if (this.origin == null)
    {
      super.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(242122);
      return;
    }
    this.origin.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(242122);
  }
  
  public void setViewType(ViewType paramViewType)
  {
    this.viewType = paramViewType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c
 * JD-Core Version:    0.7.0.1
 */