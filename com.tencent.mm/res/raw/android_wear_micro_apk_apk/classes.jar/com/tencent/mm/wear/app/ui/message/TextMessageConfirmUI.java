package com.tencent.mm.wear.app.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.g;
import android.widget.TextView;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.g.b;
import com.tencent.mm.wear.app.ui.MMAvatarActivity;

public class TextMessageConfirmUI
  extends MMAvatarActivity
  implements g
{
  private String abU;
  private TextView agW;
  private DelayedConfirmationView agX;
  
  public final void eU()
  {
    this.agX.a(null);
    h.mc().a(new f(this, (byte)0));
  }
  
  public final void eV()
  {
    this.agX.a(null);
    finish();
  }
  
  public final int getLayoutId()
  {
    return 2130903108;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.abU = getIntent().getStringExtra("key_text");
    this.agW = ((TextView)findViewById(2131558522));
    this.agX = ((DelayedConfirmationView)findViewById(2131558523));
    this.agW.setText(this.abU);
    this.agX.eP();
    this.agX.eM();
    this.agX.eO();
    this.agX.eQ();
    this.agX.eT();
    this.agX.start();
    this.agX.a(this);
    N(getUsername());
  }
  
  protected void onStop()
  {
    super.onStop();
    this.agX.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.TextMessageConfirmUI
 * JD-Core Version:    0.7.0.1
 */