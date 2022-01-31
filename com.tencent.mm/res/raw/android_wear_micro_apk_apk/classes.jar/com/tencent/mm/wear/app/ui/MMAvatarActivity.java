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
  private ImageView aeA;
  
  protected final void N(String paramString)
  {
    d.c("MicroMsg.MMAvatarActivity", "set bg avatar: %s", new Object[] { paramString });
    a locala = new a();
    locala.acL = this.aeA;
    locala.width = 320;
    locala.height = 320;
    locala.type = 3;
    locala.acH = paramString;
    locala.acN = 10;
    h.me().a(locala);
  }
  
  public abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getLayoutId());
    this.aeA = ((ImageView)findViewById(2131558442));
    this.aeA.setScaleX(1.2F);
    this.aeA.setScaleY(1.2F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.MMAvatarActivity
 * JD-Core Version:    0.7.0.1
 */