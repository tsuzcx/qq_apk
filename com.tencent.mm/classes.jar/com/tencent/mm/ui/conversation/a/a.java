package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b IGH;
  private d IGI;
  a IGJ;
  int aPG;
  private View qe;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.aPG = 0;
    this.qe = null;
    if (this.view != null)
    {
      this.qe = this.view.findViewById(2131296508);
      this.IGI = new d();
      this.IGI.IGN = this.qe;
      this.IGI.IGO = ((Button)this.view.findViewById(2131296429));
      this.IGI.IGO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          if ((a.this.IGH != null) && (a.this.IGJ != null))
          {
            paramAnonymousView = a.this.IGH.acj(a.this.aPG);
            a.this.IGJ.aCs(paramAnonymousView.IGM.id);
          }
          AppMethodBeat.o(38755);
        }
      });
      this.qe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          if ((a.this.IGH != null) && (a.this.IGJ != null))
          {
            paramAnonymousView = a.this.IGH.acj(a.this.aPG);
            a.this.IGJ.lQ(paramAnonymousView.IGM.id, paramAnonymousView.IGM.url);
          }
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38762);
    this.IGH = new b((Context)this.Dsc.get());
    this.IGJ = new a()
    {
      public final void aCs(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.i.a.a.eMk();
        az.ayM();
        com.tencent.mm.model.c.awA().c(new m(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void lQ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.i.a.a.eMk();
        az.ayM();
        com.tencent.mm.model.c.awA().c(new m(2, paramAnonymousString1));
        ac.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        p.a.DfG.a((Context)a.this.Dsc.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.i.a.a locala = com.tencent.mm.pluginsdk.i.a.a.hs(ai.getContext());
    if (this.IGH != null)
    {
      if (locala != null)
      {
        this.IGH.IGL = locala;
        this.IGH.Xb();
        if ((this.IGH != null) && (this.IGH.getCount() > 0) && (this.IGH.acj(0).a(this.IGI) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ac.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
          setVisibility(0);
          AppMethodBeat.o(38762);
          return true;
        }
      }
      setVisibility(8);
    }
    setVisibility(8);
    AppMethodBeat.o(38762);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38760);
    if (g.agP().afY())
    {
      az.ayM();
      com.tencent.mm.model.c.agA().b(this.IGH);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return 2131492953;
  }
  
  public final void release()
  {
    this.IGH = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.qe != null) {
      this.qe.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void aCs(String paramString);
    
    public abstract void lQ(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */