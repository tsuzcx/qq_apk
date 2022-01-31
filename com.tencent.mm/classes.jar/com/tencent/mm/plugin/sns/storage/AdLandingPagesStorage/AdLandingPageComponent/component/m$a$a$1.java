package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;

final class m$a$a$1
  implements Runnable
{
  m$a$a$1(m.a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(37107);
    m.c(this.rvV.rvU.rvI).setVisibility(8);
    m.d(this.rvV.rvU.rvI).setEnabled(false);
    Button localButton = m.d(this.rvV.rvU.rvI);
    if (!TextUtils.isEmpty(m.b(this.rvV.rvU.rvI).rrG)) {}
    for (String str = m.b(this.rvV.rvU.rvI).rrG;; str = "暂不支持安卓手机")
    {
      localButton.setText(str);
      m.d(this.rvV.rvU.rvI).setVisibility(0);
      AppMethodBeat.o(37107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.a.1
 * JD-Core Version:    0.7.0.1
 */