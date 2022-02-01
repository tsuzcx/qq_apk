package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public final class j
{
  public boolean VYj = false;
  MMActivity activity;
  
  public j(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  public static boolean a(c paramc)
  {
    if (paramc == null) {}
    while (paramc.VXS == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(dcm paramdcm)
  {
    if (paramdcm == null) {}
    while (paramdcm.VXS == 0) {
      return false;
    }
    return true;
  }
  
  public final void a(final c paramc, final a parama)
  {
    AppMethodBeat.i(301435);
    if (paramc.VXS == 1)
    {
      k.a(this.activity, paramc.wording, "", paramc.VXQ.wording, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301452);
          parama.a(paramc.VXQ);
          j.a(j.this, paramc.VXQ);
          AppMethodBeat.o(301452);
        }
      });
      AppMethodBeat.o(301435);
      return;
    }
    if (paramc.VXS == 2) {
      k.a(this.activity, paramc.wording, "", paramc.VXR.wording, paramc.VXQ.wording, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301451);
          parama.a(paramc.VXR);
          j.a(j.this, paramc.VXR);
          AppMethodBeat.o(301451);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301446);
          parama.a(paramc.VXQ);
          j.a(j.this, paramc.VXQ);
          AppMethodBeat.o(301446);
        }
      });
    }
    AppMethodBeat.o(301435);
  }
  
  public final void a(final dcm paramdcm, final a parama)
  {
    AppMethodBeat.i(301437);
    if (paramdcm.VXS == 1)
    {
      k.a(this.activity, paramdcm.wording, "", paramdcm.VXQ.wording, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301447);
          parama.a(paramdcm.VXQ);
          j.a(j.this, paramdcm.VXQ);
          AppMethodBeat.o(301447);
        }
      });
      AppMethodBeat.o(301437);
      return;
    }
    if (paramdcm.VXS == 2) {
      k.a(this.activity, paramdcm.wording, "", paramdcm.VXR.wording, paramdcm.VXQ.wording, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301448);
          parama.a(paramdcm.VXQ);
          j.a(j.this, paramdcm.VXR);
          AppMethodBeat.o(301448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301449);
          parama.a(paramdcm.VXQ);
          j.a(j.this, paramdcm.VXQ);
          AppMethodBeat.o(301449);
        }
      });
    }
    AppMethodBeat.o(301437);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(301430);
    a(paramc, new a()
    {
      public final void a(dfc paramAnonymousdfc) {}
    });
    AppMethodBeat.o(301430);
  }
  
  public static abstract interface a
  {
    public abstract void a(dfc paramdfc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.j
 * JD-Core Version:    0.7.0.1
 */