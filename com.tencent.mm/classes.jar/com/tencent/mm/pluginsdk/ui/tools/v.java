package com.tencent.mm.pluginsdk.ui.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
{
  private static int Yut = -1;
  
  public static void a(View paramView, VideoSightView paramVideoSightView)
  {
    AppMethodBeat.i(116268);
    if ((paramView == null) || (paramVideoSightView == null))
    {
      Log.e("VideoSightHelper", "null view object " + paramView + "," + paramVideoSightView);
      AppMethodBeat.o(116268);
      return;
    }
    if (paramView.getVisibility() == 0) {
      paramVideoSightView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(final View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(116267);
          paramAnonymousInt1 = paramAnonymousInt4 - paramAnonymousInt2;
          if ((paramAnonymousInt1 > 0) && (paramAnonymousInt8 - paramAnonymousInt6 != paramAnonymousInt1)) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116266);
                int j = paramAnonymousView.getResources().getDisplayMetrics().heightPixels - paramAnonymousView.getHeight() >>> 1;
                int i = (int)(j / 1.618D - (v.this.getHeight() >>> 1));
                if (i >= 0)
                {
                  if (v.Yut < 0) {
                    v.access$002(BackwardSupportUtil.BitmapFactory.fromDPToPix(paramAnonymousView.getContext(), 20.0F));
                  }
                  if (v.this.getHeight() + i + v.Yut <= j) {
                    break label192;
                  }
                  i -= v.this.getHeight() + i + v.Yut - j;
                }
                label192:
                for (;;)
                {
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)v.this.getLayoutParams();
                  if ((i > 0) && (i != localLayoutParams.bottomMargin))
                  {
                    Log.i("VideoSightHelper", "setting tip marginBottom ".concat(String.valueOf(i)));
                    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
                    v.this.setLayoutParams(localLayoutParams);
                  }
                  AppMethodBeat.o(116266);
                  return;
                }
              }
            });
          }
          AppMethodBeat.o(116267);
        }
      });
    }
    AppMethodBeat.o(116268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.v
 * JD-Core Version:    0.7.0.1
 */