package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class g
{
  private static final String bwK;
  private static final String bwL;
  public static final int mvC;
  public static final int mvD;
  public static final int mvw = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 8);
  public Intent intent;
  private a pZA;
  private am pZB;
  public h pZy;
  private Point pZz;
  
  static
  {
    mvC = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 96);
    mvD = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 76);
    String str = q.zg();
    bwK = str;
    bwL = o.getString(str.hashCode());
  }
  
  private void X(Intent paramIntent)
  {
    y.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.pZy != null) {
      dismiss();
    }
    if (this.pZy == null) {
      this.pZy = new h(ae.getContext());
    }
    if (this.pZB != null) {
      this.pZB.stopTimer();
    }
    this.pZy.setOnClickListener(new g.2(this, paramIntent));
    WindowManager localWindowManager = (WindowManager)ae.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 51;
    localLayoutParams.width = mvD;
    localLayoutParams.height = mvC;
    if (this.pZz == null)
    {
      int i = com.tencent.mm.kernel.g.DP().Dz().getInt(327947, 0);
      int j = mvw;
      localLayoutParams.x = (com.tencent.mm.cb.a.fj(ae.getContext()) - localLayoutParams.width - j);
      localLayoutParams.y = (i + j);
    }
    try
    {
      for (;;)
      {
        localWindowManager.addView(this.pZy, localLayoutParams);
        this.pZA.a(paramIntent, this.pZy);
        return;
        localLayoutParams.x = this.pZz.x;
        localLayoutParams.y = this.pZz.y;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[] { localException });
      }
    }
  }
  
  public final void Qb(String paramString)
  {
    if (this.pZy != null) {
      this.pZy.Qb(paramString);
    }
  }
  
  public final void a(Intent paramIntent, a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      return;
    }
    this.intent = paramIntent;
    this.pZA = parama;
    if (!b.bg(ae.getContext()))
    {
      y.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = ae.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(a.e.voip_float_permission_alert_content), new g.1(this, parama, paramIntent));
      return;
    }
    X(paramIntent);
  }
  
  public final void dismiss()
  {
    y.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
    WindowManager localWindowManager = (WindowManager)ae.getContext().getSystemService("window");
    try
    {
      if (this.pZy != null)
      {
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.pZy.getLayoutParams();
        this.pZz = new Point(localLayoutParams.x, localLayoutParams.y);
        localWindowManager.removeView(this.pZy);
        this.pZy.setOnClickListener(null);
        this.pZy = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[] { localException });
    }
  }
  
  public final void yg(int paramInt)
  {
    if (this.pZy != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.pZy.Qc(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.g
 * JD-Core Version:    0.7.0.1
 */