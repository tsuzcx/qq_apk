package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
{
  public static void a(ListView paramListView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(245497);
    if (paramListView == null)
    {
      AppMethodBeat.o(245497);
      return;
    }
    if ((d(paramListView, paramInt1)) && (paramBoolean2))
    {
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop itemvisible, not scroll");
      }
      AppMethodBeat.o(245497);
      return;
    }
    Log.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1) });
    paramListView.setItemChecked(paramInt1, true);
    if ((paramBoolean1) && (d.rb(24)) && (!c(paramListView, paramInt1)))
    {
      int i = b(paramListView, paramInt1);
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.ChattingUI.ScrollController", "[smoothScrollToPositionFromTop] position:%s, y:%s, calcDuring:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
      paramListView.smoothScrollToPositionFromTop(paramInt1, paramInt2, i);
      AppMethodBeat.o(245497);
      return;
    }
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingUI.ScrollController", "[setSelectionFromTop] position:%s, y:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    paramListView.setSelectionFromTop(paramInt1, paramInt2);
    AppMethodBeat.o(245497);
  }
  
  private static int b(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(245501);
    int n = paramListView.getLastVisiblePosition();
    int i1 = paramListView.getFirstVisiblePosition();
    int k = d(paramListView);
    if (paramInt < i1)
    {
      paramInt = k / (i1 - paramInt);
      AppMethodBeat.o(245501);
      return paramInt;
    }
    if (paramInt > n)
    {
      paramInt = k / ((paramInt - n + 1) * 2);
      AppMethodBeat.o(245501);
      return paramInt;
    }
    int i = k;
    int m;
    if (paramInt == paramListView.getAdapter().getCount() - 1)
    {
      m = a.K(paramListView.getContext(), e(paramListView));
      if (!(paramListView instanceof ScrollControlListView)) {
        break label313;
      }
      i = ((ScrollControlListView)paramListView).getExtraScrollDistance();
      i = a.K(paramListView.getContext(), i);
      if (i == 0) {
        break label310;
      }
      Log.d("MicroMsg.ChattingUI.ScrollController", "calcDuring extraScrollDistanceDp: ".concat(String.valueOf(i)));
      m -= i;
    }
    for (;;)
    {
      int j = k;
      if (m >= 52.0F) {
        j = (int)(52.0F / m * k);
      }
      k = j;
      if ((paramListView instanceof ScrollControlListView))
      {
        k = j;
        if (i < 15)
        {
          long l = ((ScrollControlListView)paramListView).axj(paramListView.getChildCount() - 1);
          k = j;
          if (l > 0L)
          {
            k = (int)(j + l);
            Log.d("MicroMsg.ChattingUI.ScrollController", "calcDuring extraScrollTime: ".concat(String.valueOf(l)));
          }
        }
      }
      i = k;
      if (Log.getLogLevel() <= 1)
      {
        Log.d("MicroMsg.ChattingUI.ScrollController", "calcDuring maxDuring %s position %s firstVisible:%s lastVisible:%s lastBottomGap:".concat(String.valueOf(m)), new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(n) });
        i = k;
      }
      AppMethodBeat.o(245501);
      return i;
      label310:
      continue;
      label313:
      i = 0;
    }
  }
  
  public static boolean c(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(245506);
    int i = paramListView.getLastVisiblePosition();
    int j = paramListView.getFirstVisiblePosition();
    if ((paramInt < j) && (j - paramInt >= 20))
    {
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.ChattingUI.ScrollController", "tooFarAway return true 1111 position:%s firstVisible:%s lastVisible:%s ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i) });
      }
      AppMethodBeat.o(245506);
      return true;
    }
    if ((paramInt > i) && (paramInt - i >= 20))
    {
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.ChattingUI.ScrollController", "tooFarAway return true 2222 position:%s firstVisible:%s lastVisible:%s ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i) });
      }
      AppMethodBeat.o(245506);
      return true;
    }
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingUI.ScrollController", "tooFarAway return false position:%s firstVisible:%s lastVisible:%s ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i) });
    }
    AppMethodBeat.o(245506);
    return false;
  }
  
  private static int d(ListView paramListView)
  {
    AppMethodBeat.i(245499);
    int i = paramListView.getHeight();
    if (i > 0)
    {
      i = (int)(a.K(paramListView.getContext(), i) / 712.0F * 1800.0F);
      AppMethodBeat.o(245499);
      return i;
    }
    AppMethodBeat.o(245499);
    return 1800;
  }
  
  public static boolean d(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(245512);
    int i = paramListView.getLastVisiblePosition();
    if ((paramListView.getFirstVisiblePosition() < paramInt) && (paramInt < i))
    {
      AppMethodBeat.o(245512);
      return true;
    }
    AppMethodBeat.o(245512);
    return false;
  }
  
  public static int e(ListView paramListView)
  {
    int i = 0;
    AppMethodBeat.i(245504);
    if (paramListView == null)
    {
      AppMethodBeat.o(245504);
      return 0;
    }
    int m = paramListView.getChildCount();
    int j = paramListView.getHeight();
    int k = paramListView.getPaddingBottom();
    paramListView = paramListView.getChildAt(m - 1);
    if (paramListView == null) {}
    for (;;)
    {
      AppMethodBeat.o(245504);
      return i - (j - k);
      i = paramListView.getBottom();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */