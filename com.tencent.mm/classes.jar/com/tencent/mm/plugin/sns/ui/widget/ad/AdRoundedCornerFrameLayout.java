package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nh;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class AdRoundedCornerFrameLayout
  extends RoundedCornerFrameLayout
{
  private SnsInfo PJQ = null;
  private int xOq = 0;
  
  public AdRoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdRoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(309280);
    final int i;
    final int j;
    final int k;
    final int m;
    final SnsInfo localSnsInfo;
    final int n;
    if (paramMotionEvent.getAction() == 0)
    {
      i = getWidth();
      j = getHeight();
      k = (int)paramMotionEvent.getX();
      m = (int)paramMotionEvent.getY();
      Log.i("AdRoundedCornerFrameLayout", "onDown, w=" + i + ", h=" + j + ", x=" + k + ", y=" + m);
      localSnsInfo = this.PJQ;
      n = this.xOq;
      if (localSnsInfo != null) {
        break label133;
      }
      Log.e("AdRoundedCornerFrameLayout", "reportClickCoordinate, snsInfo==null, source=".concat(String.valueOf(n)));
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(309280);
      return bool;
      label133:
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309279);
          try
          {
            nh localnh = new nh();
            localnh.jeD = i;
            localnh.jeE = j;
            localnh.jeF = k;
            localnh.jeG = m;
            localnh.ioZ = n;
            localnh.jeH = localnh.F("SnsId", t.uA(localSnsInfo.field_snsId), true);
            localnh.jeI = localnh.F("Uxinfo", localSnsInfo.getUxinfo(), true);
            localnh.jeJ = localnh.F("Extra1", "", true);
            localnh.jeK = localnh.F("Extra2", "", true);
            localnh.bMH();
            AppMethodBeat.o(309279);
            return;
          }
          finally
          {
            Log.e("AdRoundedCornerFrameLayout", "reportClickCoordinate, exp=" + localObject.toString());
            AppMethodBeat.o(309279);
          }
        }
      });
    }
  }
  
  public final void l(SnsInfo paramSnsInfo, int paramInt)
  {
    this.PJQ = paramSnsInfo;
    this.xOq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.AdRoundedCornerFrameLayout
 * JD-Core Version:    0.7.0.1
 */