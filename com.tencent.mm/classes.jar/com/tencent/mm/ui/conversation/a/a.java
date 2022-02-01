package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b Hgo;
  private d Hgp;
  a Hgq;
  int aOQ;
  private View pf;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.aOQ = 0;
    this.pf = null;
    if (this.view != null)
    {
      this.pf = this.view.findViewById(2131296508);
      this.Hgp = new d();
      this.Hgp.Hgu = this.pf;
      this.Hgp.Hgv = ((Button)this.view.findViewById(2131296429));
      this.Hgp.Hgv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          if ((a.this.Hgo != null) && (a.this.Hgq != null))
          {
            paramAnonymousView = a.this.Hgo.ZW(a.this.aOQ);
            a.this.Hgq.axa(paramAnonymousView.Hgt.id);
          }
          AppMethodBeat.o(38755);
        }
      });
      this.pf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          if ((a.this.Hgo != null) && (a.this.Hgq != null))
          {
            paramAnonymousView = a.this.Hgo.ZW(a.this.aOQ);
            a.this.Hgq.lt(paramAnonymousView.Hgt.id, paramAnonymousView.Hgt.url);
          }
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38762);
    this.Hgo = new b((Context)this.BZM.get());
    this.Hgq = new a()
    {
      public final void axa(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.i.a.a.ewQ();
        az.arV();
        com.tencent.mm.model.c.apL().c(new l(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void lt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.i.a.a.ewQ();
        az.arV();
        com.tencent.mm.model.c.apL().c(new l(2, paramAnonymousString1));
        ad.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        p.a.BNw.a((Context)a.this.BZM.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.i.a.a locala = com.tencent.mm.pluginsdk.i.a.a.hh(aj.getContext());
    if (this.Hgo != null)
    {
      if (locala != null)
      {
        this.Hgo.Hgs = locala;
        this.Hgo.Wd();
        if ((this.Hgo != null) && (this.Hgo.getCount() > 0) && (this.Hgo.ZW(0).a(this.Hgp) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
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
    if (g.afz().aeI())
    {
      az.arV();
      com.tencent.mm.model.c.afk().b(this.Hgo);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return 2131492953;
  }
  
  public final void release()
  {
    this.Hgo = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.pf != null) {
      this.pf.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void axa(String paramString);
    
    public abstract void lt(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */