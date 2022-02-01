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
  private String afv;
  private TextView aky;
  private DelayedConfirmationView akz;
  
  public final void fk()
  {
    this.akz.a(null);
    h.mP().a(new f(this, (byte)0));
  }
  
  public final void fl()
  {
    this.akz.a(null);
    finish();
  }
  
  public final int getLayoutId()
  {
    return 2130903108;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.afv = getIntent().getStringExtra("key_text");
    this.aky = ((TextView)findViewById(2131558523));
    this.akz = ((DelayedConfirmationView)findViewById(2131558524));
    this.aky.setText(this.afv);
    this.akz.ff();
    this.akz.fc();
    this.akz.fe();
    this.akz.fg();
    this.akz.fj();
    this.akz.start();
    this.akz.a(this);
    U(getUsername());
  }
  
  protected void onStop()
  {
    super.onStop();
    this.akz.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.TextMessageConfirmUI
 * JD-Core Version:    0.7.0.1
 */