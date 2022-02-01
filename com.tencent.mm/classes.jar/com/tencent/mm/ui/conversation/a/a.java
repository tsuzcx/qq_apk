package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bd.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b XEH;
  private d XEI;
  a XEJ;
  int aJs;
  private View bvK;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.aJs = 0;
    this.bvK = null;
    if (this.view != null)
    {
      this.bvK = this.view.findViewById(R.h.dqI);
      this.XEI = new d();
      this.XEI.XEO = this.bvK;
      this.XEI.XEP = ((Button)this.view.findViewById(R.h.dqb));
      this.XEI.XEP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((a.this.XEH != null) && (a.this.XEJ != null))
          {
            paramAnonymousView = a.this.XEH.axf(a.this.aJs);
            a.this.XEJ.blj(paramAnonymousView.XEN.id);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38755);
        }
      });
      this.bvK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((a.this.XEH != null) && (a.this.XEJ != null))
          {
            paramAnonymousView = a.this.XEH.axf(a.this.aJs);
            a.this.XEJ.oe(paramAnonymousView.XEN.id, paramAnonymousView.XEN.url);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38762);
    this.XEH = new b((Context)this.Rhc.get());
    this.XEJ = new a()
    {
      public final void blj(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.l.a.a.hiP();
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new m(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void oe(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.l.a.a.hiP();
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new m(2, paramAnonymousString1));
        Log.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        q.a.QSe.b((Context)a.this.Rhc.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.l.a.a locala = com.tencent.mm.pluginsdk.l.a.a.jA(MMApplicationContext.getContext());
    if (this.XEH != null)
    {
      if (locala != null)
      {
        this.XEH.XEM = locala;
        this.XEH.atr();
        if ((this.XEH != null) && (this.XEH.getCount() > 0) && (this.XEH.axf(0).a(this.XEI) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
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
    if (h.aHE().aGM())
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().remove(this.XEH);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return R.i.ebt;
  }
  
  public final void release()
  {
    this.XEH = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.bvK != null) {
      this.bvK.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void blj(String paramString);
    
    public abstract void oe(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */