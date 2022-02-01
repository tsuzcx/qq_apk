package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class c
{
  public boolean IoO = false;
  MMActivity activity;
  
  public c(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  private void a(final cdh paramcdh, final a parama)
  {
    AppMethodBeat.i(214260);
    if (paramcdh.IoN == 1)
    {
      h.a(this.activity, paramcdh.dQx, "", paramcdh.IoL.dQx, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214254);
          parama.a(paramcdh.IoL);
          c.a(c.this, paramcdh.IoL);
          AppMethodBeat.o(214254);
        }
      });
      AppMethodBeat.o(214260);
      return;
    }
    if (paramcdh.IoN == 2) {
      h.a(this.activity, paramcdh.dQx, "", paramcdh.IoM.dQx, paramcdh.IoL.dQx, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214255);
          parama.a(paramcdh.IoL);
          c.a(c.this, paramcdh.IoM);
          AppMethodBeat.o(214255);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214256);
          parama.a(paramcdh.IoL);
          c.a(c.this, paramcdh.IoL);
          AppMethodBeat.o(214256);
        }
      });
    }
    AppMethodBeat.o(214260);
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.IoN == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(cdh paramcdh)
  {
    if (paramcdh == null) {}
    while (paramcdh.IoN == 0) {
      return false;
    }
    return true;
  }
  
  public final void a(final b paramb, final a parama)
  {
    AppMethodBeat.i(214258);
    if (paramb.IoN == 1)
    {
      h.a(this.activity, paramb.dQx, "", paramb.IoL.dQx, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214251);
          parama.a(paramb.IoL);
          c.a(c.this, paramb.IoL);
          AppMethodBeat.o(214251);
        }
      });
      AppMethodBeat.o(214258);
      return;
    }
    if (paramb.IoN == 2) {
      h.a(this.activity, paramb.dQx, "", paramb.IoM.dQx, paramb.IoL.dQx, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214252);
          parama.a(paramb.IoM);
          c.a(c.this, paramb.IoM);
          AppMethodBeat.o(214252);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214253);
          parama.a(paramb.IoL);
          c.a(c.this, paramb.IoL);
          AppMethodBeat.o(214253);
        }
      });
    }
    AppMethodBeat.o(214258);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(214257);
    a(paramb, new a()
    {
      public final void a(cfl paramAnonymouscfl) {}
    });
    AppMethodBeat.o(214257);
  }
  
  public final void b(cdh paramcdh)
  {
    AppMethodBeat.i(214259);
    a(paramcdh, new a()
    {
      public final void a(cfl paramAnonymouscfl) {}
    });
    AppMethodBeat.o(214259);
  }
  
  public static abstract interface a
  {
    public abstract void a(cfl paramcfl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */