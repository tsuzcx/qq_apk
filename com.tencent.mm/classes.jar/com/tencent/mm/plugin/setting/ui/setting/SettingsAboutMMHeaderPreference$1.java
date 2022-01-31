package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

final class SettingsAboutMMHeaderPreference$1
  implements View.OnClickListener
{
  private long qGX = 0L;
  
  SettingsAboutMMHeaderPreference$1(SettingsAboutMMHeaderPreference paramSettingsAboutMMHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127085);
    long l = bo.aoy();
    if ((this.qGX > l) || (l - this.qGX > 300L))
    {
      this.qGX = l;
      AppMethodBeat.o(127085);
      return;
    }
    this.qGX = l;
    paramView = this.qGY.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[] { g.d(paramView, d.whH, true), Integer.valueOf(d.whH) }));
    localStringBuilder.append(f.bau());
    localStringBuilder.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(g.bWu) }));
    localStringBuilder.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(aa.Jf(0)) }));
    localStringBuilder.append(String.format("[l.ver] %d\n", new Object[] { Integer.valueOf(aa.Jf(1)) }));
    localStringBuilder.append(String.format("[ws.ver] %d\n", new Object[] { Integer.valueOf(r.aLx()) }));
    localStringBuilder.append(String.format("[r.ver] %s\n", new Object[] { "0x27000536" }));
    TextView localTextView = new TextView(paramView);
    localTextView.setText(localStringBuilder);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16777216);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramView.getResources().getDimensionPixelSize(2131427772);
    localTextView.setPadding(i, i, i, i);
    h.a(paramView, null, localTextView, null);
    AppMethodBeat.o(127085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */