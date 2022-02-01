package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.i;

public final class a
{
  private Context context = null;
  e qkG = null;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(dkf paramdkf, b paramb)
  {
    AppMethodBeat.i(316411);
    if ((paramdkf == null) || (this.context == null))
    {
      Log.w("MicroMsg.LqtDialogHelper", "dialog or context is null");
      AppMethodBeat.o(316411);
      return;
    }
    if (paramdkf.style == 1)
    {
      if (paramdkf.aaQk == null)
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog center_btn is null");
        AppMethodBeat.o(316411);
        return;
      }
      if ((this.qkG != null) && (this.qkG.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(316411);
        return;
      }
      this.qkG = k.a(this.context, paramdkf.wording, "", paramdkf.aaQk.wording, false, new a(this.context, paramdkf.aaQk, paramb));
      AppMethodBeat.o(316411);
      return;
    }
    if (paramdkf.style == 2)
    {
      if ((paramdkf.aaQm == null) || (paramdkf.aaQl == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "dialog right_btn or left_btn is null");
        AppMethodBeat.o(316411);
        return;
      }
      if ((this.qkG != null) && (this.qkG.isShowing()))
      {
        Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
        AppMethodBeat.o(316411);
        return;
      }
      this.qkG = k.a(this.context, paramdkf.wording, "", paramdkf.aaQm.wording, paramdkf.aaQl.wording, false, new a(this.context, paramdkf.aaQm, paramb), new a(this.context, paramdkf.aaQl, paramb));
      AppMethodBeat.o(316411);
      return;
    }
    Log.w("MicroMsg.LqtDialogHelper", "unknown dialog type");
    AppMethodBeat.o(316411);
  }
  
  final class a
    implements DialogInterface.OnClickListener
  {
    private final dkg Vdq;
    private final a.b Vdr;
    private final Context context;
    
    public a(Context paramContext, dkg paramdkg, a.b paramb)
    {
      this.context = paramContext;
      this.Vdq = paramdkg;
      this.Vdr = paramb;
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(316392);
      a.this.qkG = null;
      if ((this.Vdq == null) || (this.context == null))
      {
        Log.w("MicroMsg.LqtDialogHelper", "LqtDialogBtn or context is null");
        AppMethodBeat.o(316392);
        return;
      }
      if (this.Vdq.jump_type == 2) {
        i.bC(this.context, this.Vdq.ttL);
      }
      for (;;)
      {
        if (this.Vdr != null) {
          this.Vdr.arL(this.Vdq.jump_type);
        }
        AppMethodBeat.o(316392);
        return;
        if (this.Vdq.jump_type == 3) {
          i.y(this.Vdq.aaQn, this.Vdq.aaQo, 0, 1061);
        } else {
          Log.i("MicroMsg.LqtDialogHelper", "jump type not support native or none");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void arL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.a
 * JD-Core Version:    0.7.0.1
 */