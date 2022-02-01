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
import android.support.v4.e.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.a.b.a.c.b;
import com.tencent.matrix.a.b.a.d.d;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.c.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  a QmP;
  
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
    TextView localTextView = (TextView)paramView.findViewById(2131304538);
    final ImageView localImageView = (ImageView)paramView.findViewById(2131304537);
    localTextView.setText(BuildInfo.MATRIX_VERSION);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      int clickCount = 3;
      Toast xfv;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38881);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
        }
        this.clickCount -= 1;
        if (this.xfv == null) {
          this.xfv = Toast.makeText(MatrixSettingHeaderPreference.this.mContext, MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131762977, new Object[] { Integer.valueOf(this.clickCount) }), 1);
        }
        if (this.clickCount <= 0) {
          this.xfv.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131762976));
        }
        for (;;)
        {
          ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1F, -3.0F), Keyframe.ofFloat(0.2F, -3.0F), Keyframe.ofFloat(0.3F, 3.0F), Keyframe.ofFloat(0.4F, -3.0F), Keyframe.ofFloat(0.5F, 3.0F), Keyframe.ofFloat(0.6F, -3.0F), Keyframe.ofFloat(0.7F, 3.0F), Keyframe.ofFloat(0.8F, -3.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(1000L).start();
          this.xfv.show();
          if ((this.clickCount == 0) && (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) != null)) {
            MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this).gWW();
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
          this.xfv.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131762977, new Object[] { Integer.valueOf(this.clickCount) }));
        }
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      private long Dal = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234460);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        long l = Util.nowMilliSecond();
        if ((this.Dal > l) || (l - this.Dal > 300L))
        {
          this.Dal = l;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234460);
          return;
        }
        this.Dal = l;
        paramAnonymousView = paramAnonymousView.getContext();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[ver  ] ").append(String.format(Locale.ENGLISH, "%s %08X", new Object[] { ChannelUtil.formatVersion(paramAnonymousView, com.tencent.mm.protocal.d.KyO, true), Integer.valueOf(com.tencent.mm.protocal.d.KyO) })).append("\n");
        ((StringBuilder)localObject1).append(BuildInfo.info());
        Object localObject2 = (com.tencent.matrix.a.b)com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
        if (localObject2 != null)
        {
          Object localObject3 = (com.tencent.matrix.a.b.a.c)((com.tencent.matrix.a.b)localObject2).cQh.aa(com.tencent.matrix.a.b.a.c.class);
          if (localObject3 != null)
          {
            Object localObject4 = new StringBuilder(String.valueOf(Process.myPid()));
            Object localObject5 = (ActivityManager)MatrixSettingHeaderPreference.this.mContext.getSystemService("activity");
            if (localObject5 != null)
            {
              localObject5 = ((ActivityManager)localObject5).getRunningAppProcesses().iterator();
              while (((Iterator)localObject5).hasNext())
              {
                ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject5).next();
                if ((localRunningAppProcessInfo.processName.contains(MatrixSettingHeaderPreference.this.mContext.getPackageName())) && (!((StringBuilder)localObject4).toString().contains(String.valueOf(localRunningAppProcessInfo.pid)))) {
                  ((StringBuilder)localObject4).append("|").append(localRunningAppProcessInfo.pid);
                }
              }
            }
            ((StringBuilder)localObject1).append("[bat.pids  ] ").append(((StringBuilder)localObject4).toString()).append("\n");
            localObject4 = ((com.tencent.matrix.a.b.a.c)localObject3).bb(0L);
            localObject5 = ((StringBuilder)localObject1).append("[bat.dice  ] ");
            if (com.tencent.matrix.c.a.SA()) {}
            for (i = 1;; i = 0)
            {
              ((StringBuilder)localObject5).append(i).append("\n");
              ((StringBuilder)localObject1).append("[bat.uptime] ").append(((c.b)localObject4).cSM.cTz).append("\n");
              ((StringBuilder)localObject1).append("[bat.fg    ] ").append(((c.b)localObject4).cSN.cTz).append("\n");
              ((StringBuilder)localObject1).append("[bat.bg    ] ").append(((c.b)localObject4).cSO.cTz).append("\n");
              ((StringBuilder)localObject1).append("[bat.fgSrv ] ").append(((c.b)localObject4).cSP.cTz).append("\n");
              localObject3 = ((com.tencent.matrix.a.b.a.c)localObject3).bc(0L);
              localObject3 = ((h.b)localObject3).cUx.subList(0, Math.min(((h.b)localObject3).cUx.size(), 3));
              i = 0;
              while (i < ((List)localObject3).size())
              {
                localObject4 = (k)((List)localObject3).get(i);
                ((StringBuilder)localObject1).append("[bat.uiTop").append(i + 1).append("] ").append((String)((k)localObject4).first).append("/").append(((k)localObject4).second).append("\n");
                i += 1;
              }
            }
          }
          localObject2 = (com.tencent.matrix.a.b.a.d)((com.tencent.matrix.a.b)localObject2).cQh.aa(com.tencent.matrix.a.b.a.d.class);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.matrix.a.b.a.d)localObject2).bd(0L);
            ((StringBuilder)localObject1).append("[bat.charge] ").append(((d.d)localObject2).cTb.cTz).append("\n");
            ((StringBuilder)localObject1).append("[bat.dim   ] ").append(((d.d)localObject2).cTc.cTz).append("\n");
          }
        }
        localObject2 = new TextView(paramAnonymousView);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setGravity(19);
        ((TextView)localObject2).setTextSize(1, 10.0F);
        ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((TextView)localObject2).setTextColor(MatrixSettingHeaderPreference.this.mContext.getResources().getColor(2131099746));
        ((TextView)localObject2).setTypeface(Typeface.MONOSPACE);
        int i = paramAnonymousView.getResources().getDimensionPixelSize(2131165498);
        ((TextView)localObject2).setPadding(i, i, i, i);
        h.a(paramAnonymousView, null, (View)localObject2, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(234460);
      }
    });
    AppMethodBeat.o(38882);
  }
  
  static abstract interface a
  {
    public abstract void gWW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference
 * JD-Core Version:    0.7.0.1
 */