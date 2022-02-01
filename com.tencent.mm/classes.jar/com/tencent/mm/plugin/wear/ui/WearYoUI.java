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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends HellActivity
{
  private boolean DPA;
  private Runnable DPB;
  private BroadcastReceiver DPC;
  private ImageView DPv;
  private ImageView DPw;
  private ImageView DPx;
  private ObjectAnimator[][] DPy;
  private c DPz;
  private ImageView fQl;
  private TextView fQm;
  private c gIM;
  private AtomicInteger mUr;
  private Vibrator nQa;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(30146);
    this.DPy = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.DPz = new c() {};
    this.mUr = new AtomicInteger();
    this.DPB = new Runnable()
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
    this.DPC = new BroadcastReceiver()
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
    this.gIM = new c() {};
    AppMethodBeat.o(30146);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(30148);
    this.DPy[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.DPy[paramInt][0].setRepeatCount(-1);
    this.DPy[paramInt][0].setStartDelay(paramLong);
    this.DPy[paramInt][0].setDuration(3900L);
    this.DPy[paramInt][0].start();
    this.DPy[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.DPy[paramInt][1].setRepeatCount(-1);
    this.DPy[paramInt][1].setStartDelay(paramLong);
    this.DPy[paramInt][1].setDuration(3900L);
    this.DPy[paramInt][1].start();
    this.DPy[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.DPy[paramInt][2].setRepeatCount(-1);
    this.DPy[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.DPy[paramInt][2].setStartDelay(paramLong);
    this.DPy[paramInt][2].setDuration(3900L);
    this.DPy[paramInt][2].start();
    AppMethodBeat.o(30148);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(30149);
    ae.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new com.tencent.mm.plugin.wear.model.d.b(this.username);
    bc.ajj().a(paramView, 0);
    finish();
    AppMethodBeat.o(30149);
  }
  
  public void onClickNoCheck(View paramView)
  {
    AppMethodBeat.i(30150);
    ae.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
    AppMethodBeat.o(30150);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30147);
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(2131496070);
    this.nQa = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.fQl = ((ImageView)findViewById(2131297008));
    this.fQm = ((TextView)findViewById(2131302867));
    this.DPv = ((ImageView)findViewById(2131297018));
    this.DPw = ((ImageView)findViewById(2131297019));
    this.DPx = ((ImageView)findViewById(2131297020));
    a.b.d(this.fQl, this.username);
    this.fQm.setText(w.zP(this.username));
    this.fQl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30139);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        com.tencent.mm.plugin.wear.model.a.eOf();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        ae.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("Main_User", paramAnonymousView);
        ((Intent)localObject).putExtra("From_fail_notify", true);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        d.f(ak.getContext(), "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
        WearYoUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30139);
      }
    });
    com.tencent.mm.sdk.b.a.IvT.c(this.DPz);
    com.tencent.mm.sdk.b.a.IvT.c(this.gIM);
    a(0, this.DPv, 0L);
    a(1, this.DPw, 1300L);
    a(2, this.DPx, 2600L);
    this.nQa.vibrate(200L);
    registerReceiver(this.DPC, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(2130772020, 2130772021);
    AppMethodBeat.o(30147);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30151);
    int i = 0;
    while (i < this.DPy.length)
    {
      int j = 0;
      while (j < this.DPy[i].length)
      {
        this.DPy[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.DPC);
    com.tencent.mm.sdk.b.a.IvT.d(this.gIM);
    com.tencent.mm.sdk.b.a.IvT.d(this.DPz);
    com.tencent.mm.plugin.wear.model.a.eOf().eOy();
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
    private int kyd = 1;
    
    public a(int paramInt)
    {
      this.kyd = paramInt;
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
      if (this.kyd == 2)
      {
        ae.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(WearYoUI.this).get()) });
        if (WearYoUI.e(WearYoUI.this).get() > 0)
        {
          WearYoUI.e(WearYoUI.this).decrementAndGet();
          ar.o(WearYoUI.f(WearYoUI.this), 1000L);
          AppMethodBeat.o(30144);
          return;
        }
        WearYoUI.d(WearYoUI.this).animate().setListener(null);
        WearYoUI.g(WearYoUI.this);
        AppMethodBeat.o(30144);
        return;
      }
      if (this.kyd == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */