package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.g;

public final class a
{
  private Context context = null;
  d nnz = null;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(ctd paramctd, b paramb)
  {
    AppMethodBeat.i(273944);
    if ((paramctd == null) || (this.context == null))
    {
      Log.w("MicroMsg.LqtDialogHelper", "dialog or context is null");
      AppMethodBeat.o(273944);
      return;
    }
    if (paramctd.style == 1)
    {
      if (paramctd.TAV == null)
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog center_btn is null");
        AppMethodBeat.o(273944);
        return;
      }
      if ((this.nnz != null) && (this.nnz.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(273944);
        return;
      }
      this.nnz = h.a(this.context, paramctd.wording, "", paramctd.TAV.wording, false, new a(this.context, paramctd.TAV, paramb));
      AppMethodBeat.o(273944);
      return;
    }
    if (paramctd.style == 2)
    {
      if ((paramctd.TAY == null) || (paramctd.TAW == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog right_btn or left_btn is null");
        AppMethodBeat.o(273944);
        return;
      }
      if ((this.nnz != null) && (this.nnz.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(273944);
        return;
      }
      this.nnz = h.a(this.context, paramctd.wording, "", paramctd.TAY.wording, paramctd.TAW.wording, false, new a(this.context, paramctd.TAY, paramb), new a(this.context, paramctd.TAW, paramb));
      AppMethodBeat.o(273944);
      return;
    }
    Log.w("MicroMsg.LqtDialogHelper", "unknown dialog type");
    AppMethodBeat.o(273944);
  }
  
  final class a
    implements DialogInterface.OnClickListener
  {
    private final cte Ooy;
    private final a.b Ooz;
    private final Context context;
    
    public a(Context paramContext, cte paramcte, a.b paramb)
    {
      this.context = paramContext;
      this.Ooy = paramcte;
      this.Ooz = paramb;
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(272477);
      a.this.nnz = null;
      if ((this.Ooy == null) || (this.context == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "LqtDialogBtn or context is null");
        AppMethodBeat.o(272477);
        return;
      }
      if (this.Ooy.jump_type == 2) {
        g.bA(this.context, this.Ooy.qpi);
      }
      for (;;)
      {
        if (this.Ooz != null) {
          this.Ooz.amc(this.Ooy.jump_type);
        }
        AppMethodBeat.o(272477);
        return;
        if (this.Ooy.jump_type == 3) {
          g.v(this.Ooy.TAZ, this.Ooy.TBa, 0, 1061);
        } else {
          Log.i("MicroMsg.LqtDialogHelper", "jump type not support native or none");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void amc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.a
 * JD-Core Version:    0.7.0.1
 */