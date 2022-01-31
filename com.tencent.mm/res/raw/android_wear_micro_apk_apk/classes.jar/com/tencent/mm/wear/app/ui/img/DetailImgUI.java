package com.tencent.mm.wear.app.ui.img;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.g.b;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.widget.e;

public class DetailImgUI
  extends MMActivity
{
  private long acG;
  private com.tencent.mm.wear.app.ui.widget.d aeC;
  private GestureDetector afW;
  private TopCropImageView afX;
  private Bitmap afY;
  private a afZ;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    this.aeC = new com.tencent.mm.wear.app.ui.widget.d(this);
    this.afX = ((TopCropImageView)findViewById(2131558448));
    this.acG = getIntent().getLongExtra("key_msg_id", 0L);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.DetailImgUI", "msgId %d", new Object[] { Long.valueOf(this.acG) });
    this.afW = new GestureDetector(this, new c(this, (byte)0));
    this.aeC.a(new e()
    {
      public final void onStart()
      {
        DetailImgUI.this.finish();
      }
    });
    this.aeC.setTimeout(30000L);
    this.aeC.Q(getString(2131165241));
    this.aeC.R(getString(2131165211));
    this.aeC.startLoading();
    if (this.afZ != null)
    {
      this.afZ.cancel();
      this.afZ = null;
    }
    this.afZ = new a(this, (byte)0);
    h.mc().a(this.afZ);
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.afZ != null)
    {
      this.afZ.cancel();
      this.afZ = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.afW.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.DetailImgUI
 * JD-Core Version:    0.7.0.1
 */