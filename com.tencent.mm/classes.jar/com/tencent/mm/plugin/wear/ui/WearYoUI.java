package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adv;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends HellActivity
{
  private ImageView WjB;
  private ImageView WjC;
  private ImageView WjD;
  private ObjectAnimator[][] WjE;
  private IListener WjF;
  private boolean WjG;
  private Runnable WjH;
  private BroadcastReceiver WjI;
  private ImageView lBC;
  private TextView lBD;
  private IListener mIj;
  private Vibrator uAL;
  private AtomicInteger urw;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(30146);
    this.WjE = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.WjF = new IListener(f.hfK) {};
    this.urw = new AtomicInteger();
    this.WjH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30141);
        WearYoUI.c(WearYoUI.this).vibrate(200L);
        WearYoUI.d(WearYoUI.this).animate().scaleX(1.2F);
        WearYoUI.d(WearYoUI.this).animate().scaleY(1.2F);
        WearYoUI.d(WearYoUI.this).animate().setDuration(200L);
        WearYoUI.d(WearYoUI.this).animate().start();
        WearYoUI.d(WearYoUI.this).animate().setListener(new WearYoUI.a(WearYoUI.this, 1));
        AppMethodBeat.o(30141);
      }
    };
    this.WjI = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30142);
        if (paramAnonymousIntent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
          WearYoUI.this.finish();
        }
        AppMethodBeat.o(30142);
      }
    };
    this.mIj = new IListener(f.hfK) {};
    AppMethodBeat.o(30146);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(30148);
    this.WjE[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.WjE[paramInt][0].setRepeatCount(-1);
    this.WjE[paramInt][0].setStartDelay(paramLong);
    this.WjE[paramInt][0].setDuration(3900L);
    this.WjE[paramInt][0].start();
    this.WjE[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.WjE[paramInt][1].setRepeatCount(-1);
    this.WjE[paramInt][1].setStartDelay(paramLong);
    this.WjE[paramInt][1].setDuration(3900L);
    this.WjE[paramInt][1].start();
    this.WjE[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.WjE[paramInt][2].setRepeatCount(-1);
    this.WjE[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.WjE[paramInt][2].setStartDelay(paramLong);
    this.WjE[paramInt][2].setDuration(3900L);
    this.WjE[paramInt][2].start();
    AppMethodBeat.o(30148);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(30149);
    Log.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new com.tencent.mm.plugin.wear.model.d.b(this.username);
    bh.aZW().a(paramView, 0);
    finish();
    AppMethodBeat.o(30149);
  }
  
  public void onClickNoCheck(View paramView)
  {
    AppMethodBeat.i(30150);
    Log.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
    AppMethodBeat.o(30150);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30147);
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(R.i.gpf);
    this.uAL = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.lBC = ((ImageView)findViewById(R.h.avatar_iv));
    this.lBD = ((TextView)findViewById(R.h.nickname_tv));
    this.WjB = ((ImageView)findViewById(R.h.fsx));
    this.WjC = ((ImageView)findViewById(R.h.fsy));
    this.WjD = ((ImageView)findViewById(R.h.fsz));
    a.b.h(this.lBC, this.username);
    this.lBD.setText(aa.getDisplayName(this.username));
    this.lBC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30139);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        com.tencent.mm.plugin.wear.model.a.inK();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        Log.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("Main_User", paramAnonymousView);
        ((Intent)localObject).putExtra("From_fail_notify", true);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        c.g(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
        WearYoUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30139);
      }
    });
    this.WjF.alive();
    this.mIj.alive();
    a(0, this.WjB, 0L);
    a(1, this.WjC, 1300L);
    a(2, this.WjD, 2600L);
    this.uAL.vibrate(200L);
    registerReceiver(this.WjI, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(R.a.fju, R.a.fjv);
    AppMethodBeat.o(30147);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30151);
    int i = 0;
    while (i < this.WjE.length)
    {
      int j = 0;
      while (j < this.WjE[i].length)
      {
        this.WjE[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.WjI);
    this.mIj.dead();
    this.WjF.dead();
    com.tencent.mm.plugin.wear.model.a.inK().ioe();
    super.onDestroy();
    AppMethodBeat.o(30151);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private int rBp = 1;
    
    public a(int paramInt)
    {
      this.rBp = paramInt;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(30145);
      WearYoUI.g(WearYoUI.this);
      AppMethodBeat.o(30145);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(30144);
      if (this.rBp == 2)
      {
        Log.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(WearYoUI.this).get()) });
        if (WearYoUI.e(WearYoUI.this).get() > 0)
        {
          WearYoUI.e(WearYoUI.this).decrementAndGet();
          MMHandlerThread.postToMainThreadDelayed(WearYoUI.f(WearYoUI.this), 1000L);
          AppMethodBeat.o(30144);
          return;
        }
        WearYoUI.d(WearYoUI.this).animate().setListener(null);
        WearYoUI.g(WearYoUI.this);
        AppMethodBeat.o(30144);
        return;
      }
      if (this.rBp == 1)
      {
        WearYoUI.d(WearYoUI.this).animate().scaleX(1.0F);
        WearYoUI.d(WearYoUI.this).animate().scaleY(1.0F);
        WearYoUI.d(WearYoUI.this).animate().setDuration(100L);
        WearYoUI.d(WearYoUI.this).animate().start();
        WearYoUI.d(WearYoUI.this).animate().setListener(new a(WearYoUI.this, 2));
      }
      AppMethodBeat.o(30144);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */