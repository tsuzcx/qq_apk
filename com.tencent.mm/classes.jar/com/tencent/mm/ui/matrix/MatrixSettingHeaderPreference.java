package com.tencent.mm.ui.matrix;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.a.a.a.d.b;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.h.d;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.b.o.c;
import com.tencent.matrix.a.b.o.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.performance.diagnostic.c.a;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MatrixSettingHeaderPreference
  extends Preference
{
  a afxD;
  
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
    TextView localTextView = (TextView)paramView.findViewById(R.h.fOa);
    final ImageView localImageView = (ImageView)paramView.findViewById(R.h.fNZ);
    localTextView.setText(BuildInfo.MATRIX_VERSION);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      Toast HDo;
      int clickCount = 3;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38881);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
        }
        this.clickCount -= 1;
        if (this.HDo == null) {
          this.HDo = Toast.makeText(MatrixSettingHeaderPreference.this.mContext, MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.l.gNE, new Object[] { Integer.valueOf(this.clickCount) }), 1);
        }
        if (this.clickCount <= 0) {
          this.HDo.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.l.gND));
        }
        for (;;)
        {
          ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1F, -3.0F), Keyframe.ofFloat(0.2F, -3.0F), Keyframe.ofFloat(0.3F, 3.0F), Keyframe.ofFloat(0.4F, -3.0F), Keyframe.ofFloat(0.5F, 3.0F), Keyframe.ofFloat(0.6F, -3.0F), Keyframe.ofFloat(0.7F, 3.0F), Keyframe.ofFloat(0.8F, -3.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(1000L).start();
          this.HDo.show();
          if ((this.clickCount == 0) && (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) != null)) {
            MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this).jBJ();
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
          this.HDo.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.l.gNE, new Object[] { Integer.valueOf(this.clickCount) }));
        }
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      private long Pqz = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249796);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        long l = Util.nowMilliSecond();
        if ((this.Pqz > l) || (l - this.Pqz > 300L))
        {
          this.Pqz = l;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249796);
          return;
        }
        this.Pqz = l;
        localObject1 = paramAnonymousView.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ver  ] ").append(String.format(Locale.ENGLISH, "%s %08X", new Object[] { ChannelUtil.formatVersion((Context)localObject1, com.tencent.mm.protocal.d.Yxh, true), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) })).append("\n");
        if (BuildInfo.IS_ARM64) {}
        Object localObject2;
        for (paramAnonymousView = "arm64-v8a";; paramAnonymousView = "armeabi-v7a")
        {
          localStringBuilder.append(String.format("[eabi ] %s\n", new Object[] { paramAnonymousView }));
          int j = 0;
          paramAnonymousView = (com.tencent.mm.plugin.performance.diagnostic.c)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.b.b.class);
          i = j;
          if (paramAnonymousView != null)
          {
            i = j;
            if (paramAnonymousView.gyg().gyp()) {
              i = 1;
            }
          }
          paramAnonymousView = (com.tencent.mm.plugin.performance.diagnostic.c)com.tencent.mm.plugin.performance.a.a.MIk.bX(com.tencent.mm.plugin.performance.diagnostic.c.b.class);
          j = i;
          if (paramAnonymousView != null)
          {
            j = i;
            if (paramAnonymousView.gyg().gyp()) {
              j = i | 0x2;
            }
          }
          localStringBuilder.append("[diag ] ").append(j).append("\n");
          paramAnonymousView = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
          if (paramAnonymousView == null) {
            break label798;
          }
          localObject2 = (com.tencent.matrix.a.a.a.d)paramAnonymousView.eOc.aj(com.tencent.matrix.a.a.a.d.class);
          if (localObject2 == null) {
            break label726;
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
        Object localObject3 = ((com.tencent.matrix.a.a.a.d)localObject2).dF(0L);
        Object localObject4 = localStringBuilder.append("[bat.dice  ] ");
        if (com.tencent.matrix.c.a.axX()) {}
        for (int i = 1;; i = 0)
        {
          ((StringBuilder)localObject4).append(i).append("\n");
          localStringBuilder.append("[bat.uptime] ").append(((d.b)localObject3).eQH.eSn).append("\n");
          localStringBuilder.append("[bat.fg    ] ").append(((d.b)localObject3).eQI.eSn).append("\n");
          localStringBuilder.append("[bat.bg    ] ").append(((d.b)localObject3).eQJ.eSn).append("\n");
          localStringBuilder.append("[bat.fgSrv ] ").append(((d.b)localObject3).eQK.eSn).append("\n");
          localObject2 = ((com.tencent.matrix.a.a.a.d)localObject2).dG(0L);
          localObject2 = ((o.c)localObject2).eUw.subList(0, Math.min(((o.c)localObject2).eUw.size(), 3));
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localObject3 = (o.c.a)((List)localObject2).get(i);
            localStringBuilder.append("[bat.uiTop").append(i + 1).append("] ").append(((o.c.a)localObject3).key).append("/").append(((o.c.a)localObject3).ratio).append("\n");
            i += 1;
          }
        }
        label726:
        paramAnonymousView = (h)paramAnonymousView.eOc.aj(h.class);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.dH(0L);
          localStringBuilder.append("[bat.charge] ").append(paramAnonymousView.eRy.eSn).append("\n");
          localStringBuilder.append("[bat.dim   ] ").append(paramAnonymousView.eRA.eSn).append("\n");
        }
        label798:
        paramAnonymousView = new TextView((Context)localObject1);
        paramAnonymousView.setText(localStringBuilder);
        paramAnonymousView.setGravity(19);
        paramAnonymousView.setTextSize(1, 10.0F);
        paramAnonymousView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        paramAnonymousView.setTextColor(MatrixSettingHeaderPreference.this.mContext.getResources().getColor(b.c.FG_0));
        paramAnonymousView.setTypeface(Typeface.MONOSPACE);
        i = ((Context)localObject1).getResources().getDimensionPixelSize(b.d.LargePadding);
        paramAnonymousView.setPadding(i, i, i, i);
        k.a((Context)localObject1, null, paramAnonymousView, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249796);
      }
    });
    AppMethodBeat.o(38882);
  }
  
  static abstract interface a
  {
    public abstract void jBJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference
 * JD-Core Version:    0.7.0.1
 */