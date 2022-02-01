package com.tencent.mm.ui.matrix;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.a.a.a.d.b;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.a.f.d;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.b.k.c;
import com.tencent.matrix.a.b.k.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.performance.diagnostic.c.a;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MatrixSettingHeaderPreference
  extends Preference
{
  a XKO;
  
  public MatrixSettingHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MatrixSettingHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(38882);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(R.h.dMr);
    ImageView localImageView = (ImageView)paramView.findViewById(R.h.dMq);
    localTextView.setText(BuildInfo.MATRIX_VERSION);
    paramView.setOnLongClickListener(new MatrixSettingHeaderPreference.1(this, localImageView));
    paramView.setOnClickListener(new View.OnClickListener()
    {
      private long JfM = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267655);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        long l = Util.nowMilliSecond();
        if ((this.JfM > l) || (l - this.JfM > 300L))
        {
          this.JfM = l;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267655);
          return;
        }
        this.JfM = l;
        localObject1 = paramAnonymousView.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ver  ] ").append(String.format(Locale.ENGLISH, "%s %08X", new Object[] { ChannelUtil.formatVersion((Context)localObject1, com.tencent.mm.protocal.d.RAD, true), Integer.valueOf(com.tencent.mm.protocal.d.RAD) })).append("\n");
        if (BuildInfo.IS_ARM64) {}
        Object localObject2;
        for (paramAnonymousView = "arm64-v8a";; paramAnonymousView = "armeabi-v7a")
        {
          localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { paramAnonymousView }));
          int j = 0;
          paramAnonymousView = (com.tencent.mm.plugin.performance.diagnostic.c)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.b.b.class);
          i = j;
          if (paramAnonymousView != null)
          {
            i = j;
            if (paramAnonymousView.fnt().fnB()) {
              i = 1;
            }
          }
          paramAnonymousView = (com.tencent.mm.plugin.performance.diagnostic.c)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.c.b.class);
          j = i;
          if (paramAnonymousView != null)
          {
            j = i;
            if (paramAnonymousView.fnt().fnB()) {
              j = i | 0x2;
            }
          }
          localStringBuilder.append("[diag ] ").append(j).append("\n");
          paramAnonymousView = (com.tencent.matrix.a.c)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.a.c.class);
          if (paramAnonymousView == null) {
            break label797;
          }
          localObject2 = (com.tencent.matrix.a.a.a.d)paramAnonymousView.cSM.Z(com.tencent.matrix.a.a.a.d.class);
          if (localObject2 == null) {
            break label725;
          }
          localObject3 = new StringBuilder(String.valueOf(Process.myPid()));
          localObject4 = (ActivityManager)MatrixSettingHeaderPreference.this.mContext.getSystemService("activity");
          if (localObject4 == null) {
            break;
          }
          localObject4 = ((ActivityManager)localObject4).getRunningAppProcesses().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject4).next();
            if ((localRunningAppProcessInfo.processName.contains(MatrixSettingHeaderPreference.this.mContext.getPackageName())) && (!((StringBuilder)localObject3).toString().contains(String.valueOf(localRunningAppProcessInfo.pid)))) {
              ((StringBuilder)localObject3).append("|").append(localRunningAppProcessInfo.pid);
            }
          }
        }
        localStringBuilder.append("[bat.pids  ] ").append(((StringBuilder)localObject3).toString()).append("\n");
        Object localObject3 = ((com.tencent.matrix.a.a.a.d)localObject2).bn(0L);
        Object localObject4 = localStringBuilder.append("[bat.dice  ] ");
        if (com.tencent.matrix.c.a.WU()) {}
        for (int i = 1;; i = 0)
        {
          ((StringBuilder)localObject4).append(i).append("\n");
          localStringBuilder.append("[bat.uptime] ").append(((d.b)localObject3).cVh.cWu).append("\n");
          localStringBuilder.append("[bat.fg    ] ").append(((d.b)localObject3).cVi.cWu).append("\n");
          localStringBuilder.append("[bat.bg    ] ").append(((d.b)localObject3).cVj.cWu).append("\n");
          localStringBuilder.append("[bat.fgSrv ] ").append(((d.b)localObject3).cVk.cWu).append("\n");
          localObject2 = ((com.tencent.matrix.a.a.a.d)localObject2).bo(0L);
          localObject2 = ((k.c)localObject2).cXX.subList(0, Math.min(((k.c)localObject2).cXX.size(), 3));
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject3 = (k.c.a)((List)localObject2).get(i);
            localStringBuilder.append("[bat.uiTop").append(i + 1).append("] ").append(((k.c.a)localObject3).key).append("/").append(((k.c.a)localObject3).ratio).append("\n");
            i += 1;
          }
        }
        label725:
        paramAnonymousView = (f)paramAnonymousView.cSM.Z(f.class);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.bp(0L);
          localStringBuilder.append("[bat.charge] ").append(paramAnonymousView.cVH.cWu).append("\n");
          localStringBuilder.append("[bat.dim   ] ").append(paramAnonymousView.cVJ.cWu).append("\n");
        }
        label797:
        paramAnonymousView = new TextView((Context)localObject1);
        paramAnonymousView.setText(localStringBuilder);
        paramAnonymousView.setGravity(19);
        paramAnonymousView.setTextSize(1, 10.0F);
        paramAnonymousView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        paramAnonymousView.setTextColor(MatrixSettingHeaderPreference.this.mContext.getResources().getColor(b.c.FG_0));
        paramAnonymousView.setTypeface(Typeface.MONOSPACE);
        i = ((Context)localObject1).getResources().getDimensionPixelSize(b.d.LargePadding);
        paramAnonymousView.setPadding(i, i, i, i);
        h.a((Context)localObject1, null, paramAnonymousView, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267655);
      }
    });
    AppMethodBeat.o(38882);
  }
  
  static abstract interface a
  {
    public abstract void hXz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference
 * JD-Core Version:    0.7.0.1
 */