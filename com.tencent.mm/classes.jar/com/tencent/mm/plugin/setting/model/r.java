package com.tencent.mm.plugin.setting.model;

import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/model/SettingsAuthViewUtils;", "", "()V", "TAG", "", "updateAuthInfoViewMaxWidth", "", "appNameTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "appTypeTextView", "Landroid/widget/TextView;", "containerMaxWidth", "", "appNameViewMaxWidth", "appTypeViewMaxWidth", "resetFirst", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r PnQ;
  
  static
  {
    AppMethodBeat.i(298519);
    PnQ = new r();
    AppMethodBeat.o(298519);
  }
  
  public static final void a(MMNeat7extView paramMMNeat7extView, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(298516);
    s.u(paramMMNeat7extView, "appNameTextView");
    s.u(paramTextView, "appTypeTextView");
    if (paramBoolean)
    {
      paramMMNeat7extView.setMaxWidth(2147483647);
      paramTextView.setMaxWidth(2147483647);
    }
    paramMMNeat7extView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramMMNeat7extView.getMeasuredWidth();
    int j = paramTextView.getMeasuredWidth();
    Log.i("MicroMsg.SettingsAuthViewUtils", "updateAuthInfoViewMaxWidth appTypeWidth: " + j + ", appNameTextViewWidth: " + i);
    if (i + j > paramInt1)
    {
      if (j >= paramInt3)
      {
        if (i <= paramInt2)
        {
          paramMMNeat7extView.setMaxWidth(2147483647);
          paramTextView.setMaxWidth(paramInt1 - i);
          AppMethodBeat.o(298516);
          return;
        }
        paramMMNeat7extView.setMaxWidth(paramInt2);
        paramTextView.setMaxWidth(paramInt3);
        AppMethodBeat.o(298516);
        return;
      }
      paramMMNeat7extView.setMaxWidth(paramInt1 - j);
      paramTextView.setMaxWidth(2147483647);
      AppMethodBeat.o(298516);
      return;
    }
    paramMMNeat7extView.setMaxWidth(2147483647);
    paramTextView.setMaxWidth(2147483647);
    AppMethodBeat.o(298516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.r
 * JD-Core Version:    0.7.0.1
 */