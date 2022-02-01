package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.p;
import org.xwalk.core.XWalkEnvironment;

public class SettingsAboutMMHeaderPreference
  extends Preference
{
  public String xqK = "";
  
  public SettingsAboutMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SettingsAboutMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(74017);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131306291);
    TextView localTextView = (TextView)paramView.findViewById(2131296308);
    if (localTextView != null) {
      localTextView.getPaint().setFakeBoldText(true);
    }
    ((TextView)paramView.findViewById(2131296307)).setText(String.format("%s %s", new Object[] { "Version", this.xqK }));
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        private long xoP = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74016);
          long l = bs.eWj();
          if ((this.xoP > l) || (l - this.xoP > 300L))
          {
            this.xoP = l;
            AppMethodBeat.o(74016);
            return;
          }
          this.xoP = l;
          paramAnonymousView = SettingsAboutMMHeaderPreference.this.mContext;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[] { i.c(paramAnonymousView, d.DIc, true), Integer.valueOf(d.DIc) }));
          localStringBuilder.append(com.tencent.mm.sdk.platformtools.h.info());
          Object localObject;
          int i;
          if (p.fyz())
          {
            if (!com.tencent.mm.sdcard_migrate.b.eTZ()) {
              break label503;
            }
            localObject = com.tencent.mm.loader.j.b.apb();
            if (!com.tencent.mm.sdcard_migrate.b.aKl(com.tencent.mm.loader.j.b.apg())) {
              break label498;
            }
            i = 1;
            localStringBuilder.append(String.format("[storage] %s|%s\n", new Object[] { localObject, Integer.valueOf(i) }));
          }
          for (;;)
          {
            localStringBuilder.append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(i.cGY) }));
            localStringBuilder.append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(z.Ul(0)) }));
            localStringBuilder.append(String.format("[l.ver] %d %s\n", new Object[] { Integer.valueOf(z.Ul(1)), ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType() }));
            localStringBuilder.append(String.format("[w.ver] %d\n", new Object[] { Integer.valueOf(z.Ul(3)) }));
            localStringBuilder.append(String.format("[box.ver] %d\n", new Object[] { Integer.valueOf(z.Ul(2)) }));
            localStringBuilder.append(String.format("[pardus.ver] %d\n", new Object[] { Integer.valueOf(z.Ul(5)) }));
            localStringBuilder.append(String.format("[r.ver] %s\n", new Object[] { com.tencent.mm.sdk.platformtools.h.gMJ }));
            localStringBuilder.append(String.format("[exp.ver] %s\n", new Object[] { SettingsAboutMMHeaderPreference.dBR() }));
            localStringBuilder.append("[xw.ver] ").append(XWalkEnvironment.getInstalledNewstVersion(ai.getContext())).append("\n");
            localObject = new TextView(paramAnonymousView);
            ((TextView)localObject).setText(localStringBuilder);
            ((TextView)localObject).setGravity(19);
            ((TextView)localObject).setTextSize(1, 10.0F);
            ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((TextView)localObject).setTextColor(ao.aJ(SettingsAboutMMHeaderPreference.this.mContext, 2130968584));
            ((TextView)localObject).setTypeface(Typeface.MONOSPACE);
            i = paramAnonymousView.getResources().getDimensionPixelSize(2131165480);
            ((TextView)localObject).setPadding(i, i, i, i);
            com.tencent.mm.ui.base.h.a(paramAnonymousView, null, (View)localObject, null);
            AppMethodBeat.o(74016);
            return;
            label498:
            i = 0;
            break;
            label503:
            localStringBuilder.append(String.format("[storage] %s\n", new Object[] { com.tencent.mm.loader.j.b.apb() }));
          }
        }
      });
    }
    AppMethodBeat.o(74017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */