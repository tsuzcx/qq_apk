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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI
  extends Activity
{
  private ImageView egq;
  private TextView egr;
  private Vibrator kqP;
  private c tCo;
  private ImageView uHY;
  private ImageView uHZ;
  private ImageView uIa;
  private ObjectAnimator[][] uIb;
  private c uIc;
  private boolean uId;
  private AtomicInteger uIe;
  private Runnable uIf;
  private BroadcastReceiver uIg;
  private String username;
  
  public WearYoUI()
  {
    AppMethodBeat.i(26471);
    this.uIb = ((ObjectAnimator[][])Array.newInstance(ObjectAnimator.class, new int[] { 3, 3 }));
    this.uIc = new WearYoUI.2(this);
    this.uIe = new AtomicInteger();
    this.uIf = new WearYoUI.3(this);
    this.uIg = new WearYoUI.4(this);
    this.tCo = new WearYoUI.5(this);
    AppMethodBeat.o(26471);
  }
  
  private void a(int paramInt, ImageView paramImageView, long paramLong)
  {
    AppMethodBeat.i(26473);
    this.uIb[paramInt][0] = ObjectAnimator.ofFloat(paramImageView, "scaleX", new float[] { 1.0F, 2.5F });
    this.uIb[paramInt][0].setRepeatCount(-1);
    this.uIb[paramInt][0].setStartDelay(paramLong);
    this.uIb[paramInt][0].setDuration(3900L);
    this.uIb[paramInt][0].start();
    this.uIb[paramInt][1] = ObjectAnimator.ofFloat(paramImageView, "scaleY", new float[] { 1.0F, 2.5F });
    this.uIb[paramInt][1].setRepeatCount(-1);
    this.uIb[paramInt][1].setStartDelay(paramLong);
    this.uIb[paramInt][1].setDuration(3900L);
    this.uIb[paramInt][1].start();
    this.uIb[paramInt][2] = ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
    this.uIb[paramInt][2].setRepeatCount(-1);
    this.uIb[paramInt][2].setInterpolator(new AccelerateInterpolator());
    this.uIb[paramInt][2].setStartDelay(paramLong);
    this.uIb[paramInt][2].setDuration(3900L);
    this.uIb[paramInt][2].start();
    AppMethodBeat.o(26473);
  }
  
  public void onClickCheck(View paramView)
  {
    AppMethodBeat.i(26474);
    ab.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[] { this.username });
    paramView = new b(this.username);
    aw.Rc().a(paramView, 0);
    finish();
    AppMethodBeat.o(26474);
  }
  
  public void onClickNoCheck(View paramView)
  {
    AppMethodBeat.i(26475);
    ab.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[] { this.username });
    finish();
    AppMethodBeat.o(26475);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26472);
    super.onCreate(paramBundle);
    getWindow().addFlags(4718592);
    setContentView(2130971289);
    this.kqP = ((Vibrator)getSystemService("vibrator"));
    this.username = getIntent().getStringExtra("key_talker");
    this.egq = ((ImageView)findViewById(2131821210));
    this.egr = ((TextView)findViewById(2131823254));
    this.uHY = ((ImageView)findViewById(2131829509));
    this.uHZ = ((ImageView)findViewById(2131829510));
    this.uIa = ((ImageView)findViewById(2131829511));
    a.b.s(this.egq, this.username);
    this.egr.setText(s.nE(this.username));
    this.egq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26462);
        com.tencent.mm.plugin.wear.model.a.cYy();
        paramAnonymousView = WearYoUI.a(WearYoUI.this);
        ab.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[] { paramAnonymousView });
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramAnonymousView);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(536870912);
        localIntent.addFlags(67108864);
        d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
        WearYoUI.this.finish();
        AppMethodBeat.o(26462);
      }
    });
    com.tencent.mm.sdk.b.a.ymk.c(this.uIc);
    com.tencent.mm.sdk.b.a.ymk.c(this.tCo);
    a(0, this.uHY, 0L);
    a(1, this.uHZ, 1300L);
    a(2, this.uIa, 2600L);
    this.kqP.vibrate(200L);
    registerReceiver(this.uIg, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    overridePendingTransition(2131034159, 2131034160);
    AppMethodBeat.o(26472);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(26476);
    int i = 0;
    while (i < this.uIb.length)
    {
      int j = 0;
      while (j < this.uIb[i].length)
      {
        this.uIb[i][j].cancel();
        j += 1;
      }
      i += 1;
    }
    unregisterReceiver(this.uIg);
    com.tencent.mm.sdk.b.a.ymk.d(this.tCo);
    com.tencent.mm.sdk.b.a.ymk.d(this.uIc);
    com.tencent.mm.plugin.wear.model.a.cYy().uGJ.cYO();
    super.onDestroy();
    AppMethodBeat.o(26476);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI
 * JD-Core Version:    0.7.0.1
 */