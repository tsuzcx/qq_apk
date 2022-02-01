package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BackwardSupportUtil$SmoothScrollFactory
{
  public static void scrollTo(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(156074);
    if (paramListView == null)
    {
      AppMethodBeat.o(156074);
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      new SmoothScrollToPosition22().doScroll(paramListView, paramInt);
      AppMethodBeat.o(156074);
      return;
    }
    new SmoothScrollToPosition21below().doScroll(paramListView, paramInt);
    AppMethodBeat.o(156074);
  }
  
  public static void scrollToFromTop(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(156075);
    if (paramListView == null)
    {
      AppMethodBeat.o(156075);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      new SmoothScrollToPosition22().doScrollFromTop(paramListView, paramInt);
      AppMethodBeat.o(156075);
      return;
    }
    new SmoothScrollToPosition21below().doScrollFromTop(paramListView, paramInt);
    AppMethodBeat.o(156075);
  }
  
  public static void scrollToTop(ListView paramListView)
  {
    AppMethodBeat.i(156073);
    if (paramListView == null)
    {
      AppMethodBeat.o(156073);
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      new SmoothScrollToPosition22().doScroll(paramListView);
      AppMethodBeat.o(156073);
      return;
    }
    new SmoothScrollToPosition21below().doScroll(paramListView);
    AppMethodBeat.o(156073);
  }
  
  public static abstract interface IScroll
  {
    public abstract void doScroll(ListView paramListView);
    
    public abstract void doScroll(ListView paramListView, int paramInt);
    
    public abstract void doScrollFromTop(ListView paramListView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory
 * JD-Core Version:    0.7.0.1
 */