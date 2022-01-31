package com.tencent.mm.plugin.wear.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wear.model.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends Activity
{
  private ImageView doU;
  private TextView doV;
  private Vibrator ibr;
  private c pWJ = new WearYoUI.5(this);
  private ImageView qSR;
  private ImageView qSS;
  private ImageView qST;
  private ObjectAnimator[][] qSU = (ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 });
  private c qSV = new WearYoUI.2(this);
  private boolean qSW;
  private AtomicInteger qSX = new AtomicInteger();
  private Runnable qSY = new WearYoUI.3(this);
  private BroadcastReceiver qSZ = new WearYoUI.4(this);
  private String username;
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    this.qSU[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.qSU[paramInt][0].setRepeatCount(-1);
    this.qSU[paramInt][0].setStartDelay(paramLong);
    this.qSU[paramInt][0].setDuration(3900L);
    this.qSU[paramInt][0].start();
    this.qSU[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.qSU[paramInt][1].setRepeatCount(-1);
    this.qSU[paramInt][1].setStartDelay(paramLong);
    this.qSU[paramInt][1].setDuration(3900L);
    this.qSU[paramInt][1].start();
    this.qSU[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.qSU[paramInt][2].setRepeatCount(-1);
    this.qSU[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.qSU[paramInt][2].setStartDelay(paramLong);
    this.qSU[paramInt][2].setDuration(3900L);
    this.qSU[paramInt][2].start();
  }
  
  public void onClickCheck(View paramView)
  {
    y.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new b(this.username);
    au.Dk().a(paramView, 0);
    finish();
  }
  
  public void onClickNoCheck(View paramView)
  {
    y.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(R.i.wear_yo_ui);
    this.ibr = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.doU = ((ImageView)findViewById(R.h.avatar_iv));
    this.doV = ((TextView)findViewById(R.h.nickname_tv));
    this.qSR = ((ImageView)findViewById(R.h.avatar_wave_1_iv));
    this.qSS = ((ImageView)findViewById(R.h.avatar_wave_2_iv));
    this.qST = ((ImageView)findViewById(R.h.avatar_wave_3_iv));
    a.b.n(this.doU, this.username);
    this.doV.setText(r.gV(this.username));
    this.doU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.plugin.wear.model.a.bYL();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        y.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramAnonymousView);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(536870912);
        localIntent.addFlags(67108864);
        d.e(ae.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
        WearYoUI.this.finish();
      }
    });
    com.tencent.mm.sdk.b.a.udP.c(this.qSV);
    com.tencent.mm.sdk.b.a.udP.c(this.pWJ);
    a(0, this.qSR, 0L);
    a(1, this.qSS, 1300L);
    a(2, this.qST, 2600L);
    this.ibr.vibrate(200L);
    registerReceiver(this.qSZ, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(R.a.dialog_enter, R.a.dialog_exit);
  }
  
  protected void onDestroy()
  {
    int i = 0;
    while (i < this.qSU.length)
    {
      int j = 0;
      while (j < this.qSU[i].length)
      {
        this.qSU[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.qSZ);
    com.tencent.mm.sdk.b.a.udP.d(this.pWJ);
    com.tencent.mm.sdk.b.a.udP.d(this.qSV);
    com.tencent.mm.plugin.wear.model.a.bYL().qRB.bZb();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */