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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.aby;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends HellActivity
{
  private ImageView PsO;
  private ImageView PsP;
  private ImageView PsQ;
  private ObjectAnimator[][] PsR;
  private IListener PsS;
  private boolean PsT;
  private Runnable PsU;
  private BroadcastReceiver PsV;
  private ImageView iZG;
  private TextView iZH;
  private IListener khI;
  private AtomicInteger rjg;
  private Vibrator rqC;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(30146);
    this.PsR = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.PsS = new IListener() {};
    this.rjg = new AtomicInteger();
    this.PsU = new Runnable()
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
    this.PsV = new BroadcastReceiver()
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
    this.khI = new IListener() {};
    AppMethodBeat.o(30146);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(30148);
    this.PsR[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.PsR[paramInt][0].setRepeatCount(-1);
    this.PsR[paramInt][0].setStartDelay(paramLong);
    this.PsR[paramInt][0].setDuration(3900L);
    this.PsR[paramInt][0].start();
    this.PsR[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.PsR[paramInt][1].setRepeatCount(-1);
    this.PsR[paramInt][1].setStartDelay(paramLong);
    this.PsR[paramInt][1].setDuration(3900L);
    this.PsR[paramInt][1].start();
    this.PsR[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.PsR[paramInt][2].setRepeatCount(-1);
    this.PsR[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.PsR[paramInt][2].setStartDelay(paramLong);
    this.PsR[paramInt][2].setDuration(3900L);
    this.PsR[paramInt][2].start();
    AppMethodBeat.o(30148);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(30149);
    Log.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new com.tencent.mm.plugin.wear.model.d.b(this.username);
    bh.aGY().a(paramView, 0);
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
    setContentView(R.i.emb);
    this.rqC = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.iZG = ((ImageView)findViewById(R.h.avatar_iv));
    this.iZH = ((TextView)findViewById(R.h.nickname_tv));
    this.PsO = ((ImageView)findViewById(R.h.dsf));
    this.PsP = ((ImageView)findViewById(R.h.dsg));
    this.PsQ = ((ImageView)findViewById(R.h.dsh));
    a.b.d(this.iZG, this.username);
    this.iZH.setText(aa.PJ(this.username));
    this.iZG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30139);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        com.tencent.mm.plugin.wear.model.a.gOv();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        Log.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("Main_User", paramAnonymousView);
        ((Intent)localObject).putExtra("From_fail_notify", true);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
        WearYoUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30139);
      }
    });
    EventCenter.instance.addListener(this.PsS);
    EventCenter.instance.addListener(this.khI);
    a(0, this.PsO, 0L);
    a(1, this.PsP, 1300L);
    a(2, this.PsQ, 2600L);
    this.rqC.vibrate(200L);
    registerReceiver(this.PsV, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(R.a.djy, R.a.djz);
    AppMethodBeat.o(30147);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30151);
    int i = 0;
    while (i < this.PsR.length)
    {
      int j = 0;
      while (j < this.PsR[i].length)
      {
        this.PsR[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.PsV);
    EventCenter.instance.removeListener(this.khI);
    EventCenter.instance.removeListener(this.PsS);
    com.tencent.mm.plugin.wear.model.a.gOv().gOQ();
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
    private int oxQ = 1;
    
    public a(int paramInt)
    {
      this.oxQ = paramInt;
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
      if (this.oxQ == 2)
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
      if (this.oxQ == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */