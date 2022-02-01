package com.tencent.mm.pluginsdk.ui.tools;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class s
{
  private static int DFZ = -1;
  
  public static void a(View paramView, VideoSightView paramVideoSightView)
  {
    AppMethodBeat.i(116268);
    if ((paramView == null) || (paramVideoSightView == null))
    {
      ac.e("VideoSightHelper", "null view object " + paramView + "," + paramVideoSightView);
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
                int i = (int)(j / 1.618D - (s.1.this.DGa.getHeight() >>> 1));
                if (i >= 0)
                {
                  if (s.DFZ < 0) {
                    s.access$002(BackwardSupportUtil.b.g(paramAnonymousView.getContext(), 20.0F));
                  }
                  if (s.1.this.DGa.getHeight() + i + s.DFZ <= j) {
                    break label192;
                  }
                  i -= s.1.this.DGa.getHeight() + i + s.DFZ - j;
                }
                label192:
                for (;;)
                {
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)s.1.this.DGa.getLayoutParams();
                  if ((i > 0) && (i != localLayoutParams.bottomMargin))
                  {
                    ac.i("VideoSightHelper", "setting tip marginBottom ".concat(String.valueOf(i)));
                    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
                    s.1.this.DGa.setLayoutParams(localLayoutParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */