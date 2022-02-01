package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public class w
  implements com.tencent.mm.am.h
{
  public boolean VTO = false;
  public b VTP;
  private a VTQ;
  public boolean hBY = false;
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71305);
    this.VTQ = parama;
    com.tencent.mm.kernel.h.baF();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWj, Boolean.FALSE)).booleanValue();
    Log.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    if ((!this.VTO) && (bool))
    {
      parama.nothing();
      AppMethodBeat.o(71305);
      return;
    }
    if (this.hBY)
    {
      Log.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[] { Boolean.valueOf(this.hBY) });
      parama.nothing();
      AppMethodBeat.o(71305);
      return;
    }
    if (paramBoolean)
    {
      this.hBY = true;
      parama = new k();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(parama, 0);
      AppMethodBeat.o(71305);
      return;
    }
    parama.nothing();
    AppMethodBeat.o(71305);
  }
  
  public final void agree()
  {
    AppMethodBeat.i(71303);
    u localu = new u();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(localu, 0);
    if (this.VTQ != null) {
      this.VTQ.agree();
    }
    AppMethodBeat.o(71303);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(71304);
    if (this.VTQ != null) {
      this.VTQ.cancel();
    }
    AppMethodBeat.o(71304);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(71302);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2541, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2791, this);
    AppMethodBeat.o(71302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(71301);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2541, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2791, this);
    AppMethodBeat.o(71301);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71306);
    if ((paramp instanceof k))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      paramString = (k)paramp;
      Log.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s ,darkmode：%s need_agree_duty %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(ao.cvt()), paramString.VxC, paramString.VxD, Boolean.valueOf(paramString.VxE) });
      if (this.VTO)
      {
        paramp = new Intent();
        paramp.putExtra("agreement_content", paramString.VxC);
        paramp.putExtra("agreement_content_darkmode", paramString.VxD);
        com.tencent.mm.br.c.b(this.VTP.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramp, this.VTP.getShowAgreenRequestCode());
        AppMethodBeat.o(71306);
        return;
      }
      if ((ao.cvt()) && (paramString.VxE))
      {
        paramp = new Intent();
        paramp.putExtra("agreement_content", paramString.VxC);
        paramp.putExtra("agreement_content_darkmode", paramString.VxD);
        com.tencent.mm.br.c.b(this.VTP.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", paramp, this.VTP.getShowAgreenRequestCode());
        AppMethodBeat.o(71306);
        return;
      }
      if (this.VTQ != null) {
        this.VTQ.nothing();
      }
      AppMethodBeat.o(71306);
      return;
    }
    if ((paramp instanceof u))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(71306);
        return;
      }
      if (!this.VTO)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWj, Boolean.TRUE);
      }
      Log.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
    }
    AppMethodBeat.o(71306);
  }
  
  public static abstract interface a
  {
    public abstract void agree();
    
    public abstract void cancel();
    
    public abstract void nothing();
  }
  
  public static abstract interface b
  {
    public abstract Context getContext();
    
    public abstract int getShowAgreenRequestCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.w
 * JD-Core Version:    0.7.0.1
 */