package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class g
{
  public boolean Phv = false;
  MMActivity activity;
  
  public g(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  private void a(final cmb paramcmb, final a parama)
  {
    AppMethodBeat.i(209299);
    if (paramcmb.Phf == 1)
    {
      h.a(this.activity, paramcmb.wording, "", paramcmb.Phd.wording, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214698);
          parama.a(paramcmb.Phd);
          g.a(g.this, paramcmb.Phd);
          AppMethodBeat.o(214698);
        }
      });
      AppMethodBeat.o(209299);
      return;
    }
    if (paramcmb.Phf == 2) {
      h.a(this.activity, paramcmb.wording, "", paramcmb.Phe.wording, paramcmb.Phd.wording, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(203104);
          parama.a(paramcmb.Phd);
          g.a(g.this, paramcmb.Phe);
          AppMethodBeat.o(203104);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(272283);
          parama.a(paramcmb.Phd);
          g.a(g.this, paramcmb.Phd);
          AppMethodBeat.o(272283);
        }
      });
    }
    AppMethodBeat.o(209299);
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.Phf == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(cmb paramcmb)
  {
    if (paramcmb == null) {}
    while (paramcmb.Phf == 0) {
      return false;
    }
    return true;
  }
  
  public final void a(final b paramb, final a parama)
  {
    AppMethodBeat.i(209297);
    if (paramb.Phf == 1)
    {
      h.a(this.activity, paramb.wording, "", paramb.Phd.wording, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199355);
          parama.a(paramb.Phd);
          g.a(g.this, paramb.Phd);
          AppMethodBeat.o(199355);
        }
      });
      AppMethodBeat.o(209297);
      return;
    }
    if (paramb.Phf == 2) {
      h.a(this.activity, paramb.wording, "", paramb.Phe.wording, paramb.Phd.wording, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271914);
          parama.a(paramb.Phe);
          g.a(g.this, paramb.Phe);
          AppMethodBeat.o(271914);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(272561);
          parama.a(paramb.Phd);
          g.a(g.this, paramb.Phd);
          AppMethodBeat.o(272561);
        }
      });
    }
    AppMethodBeat.o(209297);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(209296);
    a(paramb, new a()
    {
      public final void a(coi paramAnonymouscoi) {}
    });
    AppMethodBeat.o(209296);
  }
  
  public final void b(cmb paramcmb)
  {
    AppMethodBeat.i(209298);
    a(paramcmb, new a()
    {
      public final void a(coi paramAnonymouscoi) {}
    });
    AppMethodBeat.o(209298);
  }
  
  public static abstract interface a
  {
    public abstract void a(coi paramcoi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */