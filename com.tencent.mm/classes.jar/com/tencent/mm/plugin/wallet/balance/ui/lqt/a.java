package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.f;

public final class a
{
  private Context context = null;
  d kvo = null;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(ckj paramckj, b paramb)
  {
    AppMethodBeat.i(213933);
    if ((paramckj == null) || (this.context == null))
    {
      Log.w("MicroMsg.LqtDialogHelper", "dialog or context is null");
      AppMethodBeat.o(213933);
      return;
    }
    if (paramckj.style == 1)
    {
      if (paramckj.MpS == null)
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog center_btn is null");
        AppMethodBeat.o(213933);
        return;
      }
      if ((this.kvo != null) && (this.kvo.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(213933);
        return;
      }
      this.kvo = h.a(this.context, paramckj.dQx, "", paramckj.MpS.dQx, false, new a(this.context, paramckj.MpS, paramb));
      AppMethodBeat.o(213933);
      return;
    }
    if (paramckj.style == 2)
    {
      if ((paramckj.MpU == null) || (paramckj.MpT == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog right_btn or left_btn is null");
        AppMethodBeat.o(213933);
        return;
      }
      if ((this.kvo != null) && (this.kvo.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(213933);
        return;
      }
      this.kvo = h.a(this.context, paramckj.dQx, "", paramckj.MpU.dQx, paramckj.MpT.dQx, false, new a(this.context, paramckj.MpU, paramb), new a(this.context, paramckj.MpT, paramb));
      AppMethodBeat.o(213933);
      return;
    }
    Log.w("MicroMsg.LqtDialogHelper", "unknown dialog type");
    AppMethodBeat.o(213933);
  }
  
  final class a
    implements DialogInterface.OnClickListener
  {
    private final ckk HwL;
    private final a.b HwM;
    private final Context context;
    
    public a(Context paramContext, ckk paramckk, a.b paramb)
    {
      this.context = paramContext;
      this.HwL = paramckk;
      this.HwM = paramb;
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(213932);
      a.this.kvo = null;
      if ((this.HwL == null) || (this.context == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "LqtDialogBtn or context is null");
        AppMethodBeat.o(213932);
        return;
      }
      if (this.HwL.uSc == 2) {
        f.bn(this.context, this.HwL.nnB);
      }
      for (;;)
      {
        if (this.HwM != null) {
          this.HwM.aep(this.HwL.uSc);
        }
        AppMethodBeat.o(213932);
        return;
        if (this.HwL.uSc == 3) {
          f.u(this.HwL.MpV, this.HwL.MpW, 0, 1061);
        } else {
          Log.i("MicroMsg.LqtDialogHelper", "jump type not support native or none");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void aep(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.a
 * JD-Core Version:    0.7.0.1
 */