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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends HellActivity
{
  private ImageView DxQ;
  private ImageView DxR;
  private ImageView DxS;
  private ObjectAnimator[][] DxT;
  private c DxU;
  private boolean DxV;
  private Runnable DxW;
  private BroadcastReceiver DxX;
  private ImageView fOf;
  private TextView fOg;
  private c gGf;
  private AtomicInteger mPm;
  private Vibrator nKv;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(30146);
    this.DxT = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.DxU = new c() {};
    this.mPm = new AtomicInteger();
    this.DxW = new Runnable()
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
    this.DxX = new BroadcastReceiver()
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
    this.gGf = new c() {};
    AppMethodBeat.o(30146);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(30148);
    this.DxT[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.DxT[paramInt][0].setRepeatCount(-1);
    this.DxT[paramInt][0].setStartDelay(paramLong);
    this.DxT[paramInt][0].setDuration(3900L);
    this.DxT[paramInt][0].start();
    this.DxT[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.DxT[paramInt][1].setRepeatCount(-1);
    this.DxT[paramInt][1].setStartDelay(paramLong);
    this.DxT[paramInt][1].setDuration(3900L);
    this.DxT[paramInt][1].start();
    this.DxT[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.DxT[paramInt][2].setRepeatCount(-1);
    this.DxT[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.DxT[paramInt][2].setStartDelay(paramLong);
    this.DxT[paramInt][2].setDuration(3900L);
    this.DxT[paramInt][2].start();
    AppMethodBeat.o(30148);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(30149);
    ad.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new com.tencent.mm.plugin.wear.model.d.b(this.username);
    ba.aiU().a(paramView, 0);
    finish();
    AppMethodBeat.o(30149);
  }
  
  public void onClickNoCheck(View paramView)
  {
    AppMethodBeat.i(30150);
    ad.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
    AppMethodBeat.o(30150);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30147);
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(2131496070);
    this.nKv = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.fOf = ((ImageView)findViewById(2131297008));
    this.fOg = ((TextView)findViewById(2131302867));
    this.DxQ = ((ImageView)findViewById(2131297018));
    this.DxR = ((ImageView)findViewById(2131297019));
    this.DxS = ((ImageView)findViewById(2131297020));
    a.b.d(this.fOf, this.username);
    this.fOg.setText(v.zf(this.username));
    this.fOf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30139);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.plugin.wear.model.a.eKx();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        ad.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("Main_User", paramAnonymousView);
        ((Intent)localObject).putExtra("From_fail_notify", true);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        d.f(aj.getContext(), "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
        WearYoUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wear/ui/WearYoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30139);
      }
    });
    com.tencent.mm.sdk.b.a.IbL.c(this.DxU);
    com.tencent.mm.sdk.b.a.IbL.c(this.gGf);
    a(0, this.DxQ, 0L);
    a(1, this.DxR, 1300L);
    a(2, this.DxS, 2600L);
    this.nKv.vibrate(200L);
    registerReceiver(this.DxX, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(2130772020, 2130772021);
    AppMethodBeat.o(30147);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30151);
    int i = 0;
    while (i < this.DxT.length)
    {
      int j = 0;
      while (j < this.DxT[i].length)
      {
        this.DxT[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.DxX);
    com.tencent.mm.sdk.b.a.IbL.d(this.gGf);
    com.tencent.mm.sdk.b.a.IbL.d(this.DxU);
    com.tencent.mm.plugin.wear.model.a.eKx().eKQ();
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
    private int kuN = 1;
    
    public a(int paramInt)
    {
      this.kuN = paramInt;
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
      if (this.kuN == 2)
      {
        ad.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(WearYoUI.this).get()) });
        if (WearYoUI.e(WearYoUI.this).get() > 0)
        {
          WearYoUI.e(WearYoUI.this).decrementAndGet();
          aq.o(WearYoUI.f(WearYoUI.this), 1000L);
          AppMethodBeat.o(30144);
          return;
        }
        WearYoUI.d(WearYoUI.this).animate().setListener(null);
        WearYoUI.g(WearYoUI.this);
        AppMethodBeat.o(30144);
        return;
      }
      if (this.kuN == 1)
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