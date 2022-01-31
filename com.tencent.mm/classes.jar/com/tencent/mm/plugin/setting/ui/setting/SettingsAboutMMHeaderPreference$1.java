package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.u.r;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

final class SettingsAboutMMHeaderPreference$1
  implements View.OnClickListener
{
  private long nSX = 0L;
  
  SettingsAboutMMHeaderPreference$1(SettingsAboutMMHeaderPreference paramSettingsAboutMMHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    long l = bk.UY();
    if ((this.nSX > l) || (l - this.nSX > 300L))
    {
      this.nSX = l;
      return;
    }
    this.nSX = l;
    paramView = this.nSY.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[] { e.d(paramView, com.tencent.mm.protocal.d.spa, true), Integer.valueOf(com.tencent.mm.protocal.d.spa) }));
    localStringBuilder.append(com.tencent.mm.sdk.platformtools.d.ayN());
    localStringBuilder.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(e.bvj) }));
    localStringBuilder.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(aa.Bs(0)) }));
    localStringBuilder.append(String.format("[l.ver] %d\n", new Object[] { Integer.valueOf(aa.Bs(1)) }));
    localStringBuilder.append(String.format("[ws.ver] %d\n", new Object[] { Integer.valueOf(r.aoB()) }));
    localStringBuilder.append(String.format("[r.ver] %s\n", new Object[] { "0x26070333" }));
    TextView localTextView = new TextView(paramView);
    localTextView.setText(localStringBuilder);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16777216);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramView.getResources().getDimensionPixelSize(a.d.LargePadding);
    localTextView.setPadding(i, i, i, i);
    h.a(paramView, null, localTextView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */