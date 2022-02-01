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
  private long agh;
  private com.tencent.mm.wear.app.ui.widget.d aie;
  private Bitmap ajA;
  private a ajB;
  private GestureDetector ajy;
  private TopCropImageView ajz;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    this.aie = new com.tencent.mm.wear.app.ui.widget.d(this);
    this.ajz = ((TopCropImageView)findViewById(2131558449));
    this.agh = getIntent().getLongExtra("key_msg_id", 0L);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.DetailImgUI", "msgId %d", new Object[] { Long.valueOf(this.agh) });
    this.ajy = new GestureDetector(this, new c(this, (byte)0));
    this.aie.a(new e()
    {
      public final void onStart()
      {
        DetailImgUI.this.finish();
      }
    });
    this.aie.setTimeout(30000L);
    this.aie.X(getString(2131165242));
    this.aie.Y(getString(2131165211));
    this.aie.startLoading();
    if (this.ajB != null)
    {
      this.ajB.cancel();
      this.ajB = null;
    }
    this.ajB = new a(this, (byte)0);
    h.mP().a(this.ajB);
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.ajB != null)
    {
      this.ajB.cancel();
      this.ajB = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.ajy.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.DetailImgUI
 * JD-Core Version:    0.7.0.1
 */