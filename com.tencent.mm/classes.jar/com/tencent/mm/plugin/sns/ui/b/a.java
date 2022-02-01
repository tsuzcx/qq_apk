package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a
{
  protected ValueAnimator KpR;
  protected b RHY;
  protected int RHZ;
  protected int RIa;
  protected int RIb;
  protected int RIc;
  protected int RId;
  protected int RIe;
  protected boolean Rle;
  protected Context hOx;
  protected int nxO;
  protected int nxP;
  protected View view;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.hOx = paramActivity;
    this.view = paramView;
    this.Rle = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.RHY = paramb;
  }
  
  public final void bd(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.RHZ = paramBundle.getInt("param_thumb_left");
    this.RIa = paramBundle.getInt("param_thumb_top");
    this.RIb = paramBundle.getInt("param_thumb_width");
    this.RIc = paramBundle.getInt("param_thumb_height");
    this.nxO = paramBundle.getInt("param_target_width");
    this.nxP = paramBundle.getInt("param_target_height");
    this.RId = (this.nxP - this.RIc);
    this.RIe = (this.nxO - this.RIb);
    Log.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.RHZ), Integer.valueOf(this.RIa), Integer.valueOf(this.RIb), Integer.valueOf(this.RIc), Integer.valueOf(this.nxO), Integer.valueOf(this.nxP) });
    AppMethodBeat.o(176405);
  }
  
  public void hqQ()
  {
    AppMethodBeat.i(176406);
    if ((this.KpR != null) && (!this.KpR.isStarted()))
    {
      this.KpR.setStartDelay(0L);
      this.KpR.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */