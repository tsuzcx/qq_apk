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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.xweb.ao;

public class SettingsAboutMMHeaderPreference
  extends Preference
{
  public String Pqy = "";
  
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
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(b.f.version_code_ll);
    TextView localTextView = (TextView)paramView.findViewById(b.f.about_wechat);
    if (localTextView != null)
    {
      localTextView.getPaint().setFakeBoldText(true);
      localTextView.setText(MMApplicationContext.getResources().getString(b.i.setting_app_name));
    }
    ((TextView)paramView.findViewById(b.f.about_version_code)).setText(String.format("%s %s", new Object[] { "Version", this.Pqy }));
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        private long Pqz = 0L;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74016);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          long l = Util.nowMilliSecond();
          if ((this.Pqz > l) || (l - this.Pqz > 300L))
          {
            this.Pqz = l;
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74016);
            return;
          }
          this.Pqz = l;
          paramAnonymousView = SettingsAboutMMHeaderPreference.this.mContext;
          localObject1 = new StringBuilder();
          int i = d.Yxh;
          ((StringBuilder)localObject1).append(String.format("[ver  ] %s %08X\n", new Object[] { ChannelUtil.formatVersion(paramAnonymousView, i, true), Integer.valueOf(i) }));
          ((StringBuilder)localObject1).append(BuildInfo.info(false));
          Object localObject2 = com.tencent.mm.loader.i.b.bmt();
          if (com.tencent.mm.sdcard_migrate.b.bui(com.tencent.mm.loader.i.b.bmy())) {}
          for (i = 1;; i = 0)
          {
            ((StringBuilder)localObject1).append(String.format("[storage] %s|%s\n", new Object[] { localObject2, Integer.valueOf(i) }));
            ((StringBuilder)localObject1).append(String.format("[cid  ] %d\n", new Object[] { Integer.valueOf(ChannelUtil.channelId) }));
            ((StringBuilder)localObject1).append(String.format("[s.ver] %d\n", new Object[] { Integer.valueOf(aj.asY(0)) }));
            ((StringBuilder)localObject1).append(String.format("[t.ver] %d\n", new Object[] { Integer.valueOf(aj.asY(6)) }));
            ((StringBuilder)localObject1).append(String.format("[l.ver] %d %s\n", new Object[] { Integer.valueOf(aj.asY(1)), ((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType() }));
            ((StringBuilder)localObject1).append(String.format("[w.ver] %d\n", new Object[] { Integer.valueOf(aj.asY(3)) }));
            ((StringBuilder)localObject1).append(String.format("[box.ver] %d\n", new Object[] { Integer.valueOf(aj.asY(2)) }));
            ((StringBuilder)localObject1).append(String.format("[pardus.ver] %d\n", new Object[] { Integer.valueOf(aj.asY(5)) }));
            ((StringBuilder)localObject1).append(String.format("[ts.ver] %d\n", new Object[] { Long.valueOf(((f)h.az(f.class)).getResVersion()) }));
            ((StringBuilder)localObject1).append(String.format("[r.ver] %s\n", new Object[] { BuildInfo.curClientVersion }));
            ((StringBuilder)localObject1).append(String.format("[exp.ver] %s\n", new Object[] { SettingsAboutMMHeaderPreference.gVm() }));
            ((StringBuilder)localObject1).append(String.format("[application] %s\n", new Object[] { SettingsAboutMMHeaderPreference.this.mContext.getPackageName() }));
            ((StringBuilder)localObject1).append(String.format("[brand] %d %s\n", new Object[] { Integer.valueOf(WeChatBrands.UserInfo.xagreementId), WeChatBrands.AppInfo.lang }));
            ((StringBuilder)localObject1).append("[xw.ver] ").append(ao.getInstalledNewstVersion(MMApplicationContext.getContext())).append("\n");
            localObject2 = new TextView(paramAnonymousView);
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setGravity(19);
            ((TextView)localObject2).setTextSize(1, 10.0F);
            ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((TextView)localObject2).setTextColor(SettingsAboutMMHeaderPreference.this.mContext.getResources().getColor(b.c.FG_0));
            ((TextView)localObject2).setTypeface(Typeface.MONOSPACE);
            i = paramAnonymousView.getResources().getDimensionPixelSize(b.d.LargePadding);
            ((TextView)localObject2).setPadding(i, i, i, i);
            k.a(paramAnonymousView, null, (View)localObject2, null);
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74016);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(74017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */