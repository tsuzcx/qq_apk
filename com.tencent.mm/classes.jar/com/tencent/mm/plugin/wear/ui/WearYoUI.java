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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wear.model.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends HellActivity
{
  private ObjectAnimator[][] BXA;
  private c BXB;
  private boolean BXC;
  private Runnable BXD;
  private BroadcastReceiver BXE;
  private ImageView BXx;
  private ImageView BXy;
  private ImageView BXz;
  private ImageView fuY;
  private TextView fuZ;
  private c gmw;
  private AtomicInteger moK;
  private Vibrator njY;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(30146);
    this.BXA = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.BXB = new c() {};
    this.moK = new AtomicInteger();
    this.BXD = new Runnable()
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
    this.BXE = new BroadcastReceiver()
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
    this.gmw = new c() {};
    AppMethodBeat.o(30146);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(30148);
    this.BXA[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.BXA[paramInt][0].setRepeatCount(-1);
    this.BXA[paramInt][0].setStartDelay(paramLong);
    this.BXA[paramInt][0].setDuration(3900L);
    this.BXA[paramInt][0].start();
    this.BXA[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.BXA[paramInt][1].setRepeatCount(-1);
    this.BXA[paramInt][1].setStartDelay(paramLong);
    this.BXA[paramInt][1].setDuration(3900L);
    this.BXA[paramInt][1].start();
    this.BXA[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.BXA[paramInt][2].setRepeatCount(-1);
    this.BXA[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.BXA[paramInt][2].setStartDelay(paramLong);
    this.BXA[paramInt][2].setDuration(3900L);
    this.BXA[paramInt][2].start();
    AppMethodBeat.o(30148);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(30149);
    ac.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new b(this.username);
    az.agi().a(paramView, 0);
    finish();
    AppMethodBeat.o(30149);
  }
  
  public void onClickNoCheck(View paramView)
  {
    AppMethodBeat.i(30150);
    ac.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
    AppMethodBeat.o(30150);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30147);
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(2131496070);
    this.njY = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.fuY = ((ImageView)findViewById(2131297008));
    this.fuZ = ((TextView)findViewById(2131302867));
    this.BXx = ((ImageView)findViewById(2131297018));
    this.BXy = ((ImageView)findViewById(2131297019));
    this.BXz = ((ImageView)findViewById(2131297020));
    a.b.d(this.fuY, this.username);
    this.fuZ.setText(v.wk(this.username));
    this.fuY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30139);
        com.tencent.mm.plugin.wear.model.a.ewr();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        ac.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramAnonymousView);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(536870912);
        localIntent.addFlags(67108864);
        d.e(ai.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
        WearYoUI.this.finish();
        AppMethodBeat.o(30139);
      }
    });
    com.tencent.mm.sdk.b.a.GpY.c(this.BXB);
    com.tencent.mm.sdk.b.a.GpY.c(this.gmw);
    a(0, this.BXx, 0L);
    a(1, this.BXy, 1300L);
    a(2, this.BXz, 2600L);
    this.njY.vibrate(200L);
    registerReceiver(this.BXE, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(2130772020, 2130772021);
    AppMethodBeat.o(30147);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30151);
    int i = 0;
    while (i < this.BXA.length)
    {
      int j = 0;
      while (j < this.BXA[i].length)
      {
        this.BXA[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.BXE);
    com.tencent.mm.sdk.b.a.GpY.d(this.gmw);
    com.tencent.mm.sdk.b.a.GpY.d(this.BXB);
    com.tencent.mm.plugin.wear.model.a.ewr().ewK();
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
    private int kar = 1;
    
    public a(int paramInt)
    {
      this.kar = paramInt;
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
      if (this.kar == 2)
      {
        ac.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(WearYoUI.this).get()) });
        if (WearYoUI.e(WearYoUI.this).get() > 0)
        {
          WearYoUI.e(WearYoUI.this).decrementAndGet();
          ap.n(WearYoUI.f(WearYoUI.this), 1000L);
          AppMethodBeat.o(30144);
          return;
        }
        WearYoUI.d(WearYoUI.this).animate().setListener(null);
        WearYoUI.g(WearYoUI.this);
        AppMethodBeat.o(30144);
        return;
      }
      if (this.kar == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */