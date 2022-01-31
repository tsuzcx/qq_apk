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
  private Vibrator agp;
  private GridViewPager ahB;
  private DotsPageIndicator ahC;
  private a ahD;
  private View ahE;
  private View ahF;
  private View ahG;
  private View ahH;
  private View ahI;
  private View ahJ;
  private TextView ahK;
  private TextView ahL;
  private ImageButton ahM;
  private e ahN = new e() {};
  private Runnable ahO = new Runnable()
  {
    public final void run()
    {
      PayUI.this.finish();
    }
  };
  
  private void mY()
  {
    this.ahE.setVisibility(0);
    this.ahF.setVisibility(0);
    this.ahG.setVisibility(8);
    this.ahI.setVisibility(8);
    this.ahH.setVisibility(8);
    this.ahJ.setVisibility(8);
    com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(11032, new byte[] { 1 });
    localb.F(true);
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
          if (localaa.Wi == 0)
          {
            paramAnonymousArrayOfByte = com.tencent.mm.wear.a.f.b.c(localaa.Wk.toByteArray(), MMActivity.nc(), MMActivity.nb());
            Bitmap localBitmap = com.tencent.mm.wear.a.f.b.c(localaa.Wl.toByteArray(), MMActivity.nc(), MMActivity.nb());
            PayUI.a(PayUI.this, new a(PayUI.this));
            PayUI.b(PayUI.this).a(localaa.Wm, localaa.Wn, paramAnonymousArrayOfByte, localBitmap);
            PayUI.c(PayUI.this).a(PayUI.b(PayUI.this));
            PayUI.d(PayUI.this).a(PayUI.c(PayUI.this));
            PayUI.d(PayUI.this).eW();
            PayUI.d(PayUI.this).eX();
            PayUI.e(PayUI.this);
            com.tencent.mm.wear.app.d.a.bL(2);
          }
          for (;;)
          {
            PayUI.i(PayUI.this).vibrate(new long[] { 0L, 150L, 100L, 400L }, -1);
            return;
            PayUI.f(PayUI.this).setText(localaa.Wj);
            PayUI.g(PayUI.this);
            com.tencent.mm.wear.app.d.a.ah(3, localaa.Wi);
            continue;
            PayUI.h(PayUI.this);
            com.tencent.mm.wear.app.d.a.ah(3, 2);
          }
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          break label20;
        }
      }
    });
    h.mc().a(localb);
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
      this.agp = ((Vibrator)getSystemService("vibrator"));
      this.ahE = findViewById(2131558498);
      this.ahF = findViewById(2131558504);
      this.ahG = findViewById(2131558505);
      this.ahH = findViewById(2131558508);
      this.ahI = findViewById(2131558501);
      this.ahJ = findViewById(2131558511);
      this.ahJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          PayUI.a(PayUI.this);
        }
      });
      this.ahB = ((GridViewPager)findViewById(2131558502));
      this.ahC = ((DotsPageIndicator)findViewById(2131558503));
      this.ahK = ((TextView)findViewById(2131558507));
      this.ahL = ((TextView)findViewById(2131558510));
      this.ahM = ((ImageButton)findViewById(2131558509));
      this.ahM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new aj();
          paramAnonymousView.Wv = "offline";
          paramAnonymousView.Ww = ".ui.WalletOfflineEntranceUI";
          try
          {
            paramAnonymousView = new com.tencent.mm.wear.app.f.b(11034, paramAnonymousView.toByteArray());
            h.mc().a(paramAnonymousView);
            com.tencent.mm.wear.app.d.a.bL(6);
            label47:
            PayUI.this.finish();
            Toast.makeText(MMApplication.getContext(), 2131165245, 0).show();
            return;
          }
          catch (IOException paramAnonymousView)
          {
            break label47;
          }
        }
      });
      mY();
      com.tencent.mm.wear.app.d.a.bL(1);
      return;
      setContentView(2130903096);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.a.a.WJ.a(this.ahN);
  }
  
  protected void onStop()
  {
    com.tencent.mm.sdk.a.a.WJ.b(this.ahN);
    com.tencent.mm.wear.a.b.a.aiT.removeCallbacks(this.ahO);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.pay.PayUI
 * JD-Core Version:    0.7.0.1
 */