package com.tencent.mm.wear.app.ui.pay;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.b.a.i;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.d;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.IOException;

public class PayUI
  extends MMActivity
{
  private Vibrator ajR;
  private GridViewPager ald;
  private DotsPageIndicator ale;
  private a alf;
  private View alg;
  private View alh;
  private View ali;
  private View alj;
  private View alk;
  private View all;
  private TextView alm;
  private TextView aln;
  private ImageButton alo;
  private e alp = new e() {};
  private Runnable alq = new Runnable()
  {
    public final void run()
    {
      PayUI.this.finish();
    }
  };
  
  private void nK()
  {
    ol();
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11032, new byte[] { 1 });
    localb.I(true);
    localb.a(new d()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        aa localaa;
        if (paramAnonymousInt2 == 0) {
          localaa = new aa();
        }
        try
        {
          localaa.h(paramAnonymousArrayOfByte);
          label20:
          if (localaa.Yd == 0)
          {
            paramAnonymousArrayOfByte = com.tencent.mm.wear.a.f.b.c(localaa.Yf.toByteArray(), MMActivity.nP(), MMActivity.nO());
            Bitmap localBitmap = com.tencent.mm.wear.a.f.b.c(localaa.Yg.toByteArray(), MMActivity.nP(), MMActivity.nO());
            PayUI.a(PayUI.this, new a(PayUI.this));
            PayUI.b(PayUI.this).a(localaa.Yh, localaa.Yi, paramAnonymousArrayOfByte, localBitmap);
            PayUI.c(PayUI.this).a(PayUI.b(PayUI.this));
            PayUI.d(PayUI.this).a(PayUI.c(PayUI.this));
            PayUI.d(PayUI.this).fm();
            PayUI.d(PayUI.this).fn();
            PayUI.e(PayUI.this);
            com.tencent.mm.wear.app.d.a.ch(2);
          }
          for (;;)
          {
            PayUI.i(PayUI.this).vibrate(new long[] { 0L, 150L, 100L, 400L }, -1);
            return;
            PayUI.f(PayUI.this).setText(localaa.Ye);
            PayUI.g(PayUI.this);
            com.tencent.mm.wear.app.d.a.ak(3, localaa.Yd);
            continue;
            PayUI.h(PayUI.this);
            com.tencent.mm.wear.app.d.a.ak(3, 2);
          }
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          break label20;
        }
      }
    });
    h.mP().a(localb);
  }
  
  private void ol()
  {
    this.alg.setVisibility(0);
    this.alh.setVisibility(0);
    this.ali.setVisibility(8);
    this.alk.setVisibility(8);
    this.alj.setVisibility(8);
    this.all.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (isRound()) {
      setContentView(2130903097);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      this.ajR = ((Vibrator)getSystemService("vibrator"));
      this.alg = findViewById(2131558499);
      this.alh = findViewById(2131558505);
      this.ali = findViewById(2131558506);
      this.alj = findViewById(2131558509);
      this.alk = findViewById(2131558502);
      this.all = findViewById(2131558512);
      this.all.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          PayUI.a(PayUI.this);
        }
      });
      this.ald = ((GridViewPager)findViewById(2131558503));
      this.ale = ((DotsPageIndicator)findViewById(2131558504));
      this.alm = ((TextView)findViewById(2131558508));
      this.aln = ((TextView)findViewById(2131558511));
      this.alo = ((ImageButton)findViewById(2131558510));
      this.alo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new aj();
          paramAnonymousView.Yq = "offline";
          paramAnonymousView.Yr = ".ui.WalletOfflineEntranceUI";
          try
          {
            paramAnonymousView = new com.tencent.mm.wear.app.f.b(11034, paramAnonymousView.toByteArray());
            h.mP().a(paramAnonymousView);
            com.tencent.mm.wear.app.d.a.ch(6);
            label47:
            PayUI.this.finish();
            Toast.makeText(MMApplication.getContext(), 2131165248, 0).show();
            return;
          }
          catch (IOException paramAnonymousView)
          {
            break label47;
          }
        }
      });
      nK();
      com.tencent.mm.wear.app.d.a.ch(1);
      return;
      setContentView(2130903096);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.a.a.YM.a(this.alp);
  }
  
  protected void onStop()
  {
    com.tencent.mm.sdk.a.a.YM.b(this.alp);
    com.tencent.mm.wear.a.b.a.amv.removeCallbacks(this.alq);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.pay.PayUI
 * JD-Core Version:    0.7.0.1
 */