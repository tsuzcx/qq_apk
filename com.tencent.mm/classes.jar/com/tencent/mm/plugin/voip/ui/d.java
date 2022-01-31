package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.z;

public final class d
{
  public static final int oVo;
  public static final int oVu;
  public static final int oVv;
  public Intent intent;
  public e tEY;
  private Point tEZ;
  private a tFa;
  private ap tFb;
  
  static
  {
    AppMethodBeat.i(4979);
    oVo = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 8);
    oVu = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 96);
    oVv = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 76);
    AppMethodBeat.o(4979);
  }
  
  private void ar(Intent paramIntent)
  {
    AppMethodBeat.i(4974);
    ab.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
    if (this.tEY != null) {
      dismiss();
    }
    if (this.tEY == null) {
      this.tEY = new e(ah.getContext());
    }
    if (this.tFb != null) {
      this.tFb.stopTimer();
    }
    this.tEY.setOnClickListener(new d.2(this, paramIntent));
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (com.tencent.mm.compatible.util.d.fv(26)) {
      localLayoutParams.type = 2038;
    }
    for (;;)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.width = oVv;
      localLayoutParams.height = oVu;
      if (this.tEZ == null)
      {
        int i = g.RL().Ru().getInt(327947, 0);
        int j = oVo;
        localLayoutParams.x = (com.tencent.mm.cb.a.gw(ah.getContext()) - localLayoutParams.width - j);
        localLayoutParams.y = (i + j);
      }
      try
      {
        for (;;)
        {
          localWindowManager.addView(this.tEY, localLayoutParams);
          this.tFa.a(paramIntent, this.tEY);
          AppMethodBeat.o(4974);
          return;
          localLayoutParams.type = 2002;
          break;
          localLayoutParams.x = this.tEZ.x;
          localLayoutParams.y = this.tEZ.y;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[] { localException });
        }
      }
    }
  }
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(4975);
    if (this.tEY != null)
    {
      String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
      this.tEY.aeJ(str);
    }
    AppMethodBeat.o(4975);
  }
  
  public final void a(Intent paramIntent, a parama)
  {
    AppMethodBeat.i(4973);
    if (parama == null)
    {
      ab.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
      AppMethodBeat.o(4973);
      return;
    }
    this.intent = paramIntent;
    this.tFa = parama;
    if (!b.bK(ah.getContext()))
    {
      ab.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
      Context localContext = ah.getContext();
      RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131304682), new d.1(this, parama, paramIntent));
      AppMethodBeat.o(4973);
      return;
    }
    ar(paramIntent);
    AppMethodBeat.o(4973);
  }
  
  public final void aeI(String paramString)
  {
    AppMethodBeat.i(4976);
    if (this.tEY != null) {
      this.tEY.aeI(paramString);
    }
    AppMethodBeat.o(4976);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(4977);
    ab.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    try
    {
      if (this.tEY != null)
      {
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.tEY.getLayoutParams();
        this.tEZ = new Point(localLayoutParams.x, localLayoutParams.y);
        localWindowManager.removeView(this.tEY);
        this.tEY.setOnClickListener(null);
        this.tEY = null;
      }
      AppMethodBeat.o(4977);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[] { localException });
      AppMethodBeat.o(4977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d
 * JD-Core Version:    0.7.0.1
 */