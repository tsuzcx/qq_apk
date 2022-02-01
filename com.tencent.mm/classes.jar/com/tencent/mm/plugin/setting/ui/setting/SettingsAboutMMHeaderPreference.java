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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.v;
import org.xwalk.core.XWalkEnvironment;

public class SettingsAboutMMHeaderPreference
  extends Preference
{
  public String yVv = "";
  
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
    ((TextView)paramView.findViewById(2131296307)).setText(String.format("%s %s", new Object[] { "Version", this.yVv }));
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        private long yVw = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74016);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          long l = bu.fpO();
          if ((this.yVw > l) || (l - this.yVw > 300L))
          {
            this.yVw = l;
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74016);
            return;
          }
          this.yVw = l;
          paramAnonymousView = SettingsAboutMMHeaderPreference.this.mContext;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.format("[ver  ] %s %08X\n", new Object[] { k.c(paramAnonymousView, d.FFH, true), Integer.valueOf(d.FFH) }));
          ((StringBuilder)localObject1).append(j.info());
          Object localObject2;
          int i;
          if (v.fTQ())
          {
            if (!v.fTO()) {
              break label562;
            }
            localObject2 = com.tencent.mm.loader.j.b.asd();
            if (!com.tencent.mm.sdcard_migrate.b.aRn(com.tencent.mm.loader.j.b.asi())) {
              break label557;
            }
            i = 1;
            ((StringBuilder)localObject1).append(String.format("[storage] %s|%s\n", new Object[] { localObject2, Integer.valueOf(i) }));
          }
          for (;;)
          {
            ((StringBuilder)localObject1).append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(k.cSM) }));
            ((StringBuilder)localObject1).append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(0)) }));
            ((StringBuilder)localObject1).append(String.format("[l.ver] %d %s\n", new Object[] { Integer.valueOf(ad.WL(1)), ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType() }));
            ((StringBuilder)localObject1).append(String.format("[w.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(3)) }));
            ((StringBuilder)localObject1).append(String.format("[box.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(2)) }));
            ((StringBuilder)localObject1).append(String.format("[pardus.ver] %d\n", new Object[] { Integer.valueOf(ad.WL(5)) }));
            ((StringBuilder)localObject1).append(String.format("[r.ver] %s\n", new Object[] { j.hju }));
            ((StringBuilder)localObject1).append(String.format("[exp.ver] %s\n", new Object[] { SettingsAboutMMHeaderPreference.dQQ() }));
            ((StringBuilder)localObject1).append("[xw.ver] ").append(XWalkEnvironment.getInstalledNewstVersion(ak.getContext())).append("\n");
            localObject2 = new TextView(paramAnonymousView);
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setGravity(19);
            ((TextView)localObject2).setTextSize(1, 10.0F);
            ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((TextView)localObject2).setTextColor(SettingsAboutMMHeaderPreference.this.mContext.getResources().getColor(2131099732));
            ((TextView)localObject2).setTypeface(Typeface.MONOSPACE);
            i = paramAnonymousView.getResources().getDimensionPixelSize(2131165480);
            ((TextView)localObject2).setPadding(i, i, i, i);
            h.a(paramAnonymousView, null, (View)localObject2, null);
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74016);
            return;
            label557:
            i = 0;
            break;
            label562:
            ((StringBuilder)localObject1).append(String.format("[storage] %s\n", new Object[] { com.tencent.mm.loader.j.b.asd() }));
          }
        }
      });
    }
    AppMethodBeat.o(74017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */