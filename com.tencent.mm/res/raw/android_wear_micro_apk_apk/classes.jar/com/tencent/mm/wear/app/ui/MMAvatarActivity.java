package com.tencent.mm.wear.app.ui;

import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.c.a;
import com.tencent.mm.wear.app.c.b;

public abstract class MMAvatarActivity
  extends MMActivity
{
  private ImageView aic;
  
  protected final void U(String paramString)
  {
    d.c("MicroMsg.MMAvatarActivity", "set bg avatar: %s", new Object[] { paramString });
    a locala = new a();
    locala.agm = this.aic;
    locala.width = 320;
    locala.height = 320;
    locala.type = 3;
    locala.agi = paramString;
    locala.ago = 10;
    h.mR().a(locala);
  }
  
  public abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getLayoutId());
    this.aic = ((ImageView)findViewById(2131558443));
    this.aic.setScaleX(1.2F);
    this.aic.setScaleY(1.2F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.MMAvatarActivity
 * JD-Core Version:    0.7.0.1
 */