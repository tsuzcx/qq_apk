package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
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
  b Qhx;
  private d Qhy;
  a Qhz;
  int aZW;
  private View sc;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.aZW = 0;
    this.sc = null;
    if (this.view != null)
    {
      this.sc = this.view.findViewById(2131296582);
      this.Qhy = new d();
      this.Qhy.QhD = this.sc;
      this.Qhy.QhE = ((Button)this.view.findViewById(2131296485));
      this.Qhy.QhE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((a.this.Qhx != null) && (a.this.Qhz != null))
          {
            paramAnonymousView = a.this.Qhx.aoa(a.this.aZW);
            a.this.Qhz.aZq(paramAnonymousView.QhC.id);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38755);
        }
      });
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((a.this.Qhx != null) && (a.this.Qhz != null))
          {
            paramAnonymousView = a.this.Qhx.aoa(a.this.aZW);
            a.this.Qhz.nk(paramAnonymousView.QhC.id, paramAnonymousView.QhC.url);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38762);
    this.Qhx = new b((Context)this.Kgr.get());
    this.Qhz = new a()
    {
      public final void aZq(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.k.a.a.gof();
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new m(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void nk(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.k.a.a.gof();
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new m(2, paramAnonymousString1));
        Log.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        q.a.JSZ.a((Context)a.this.Kgr.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.k.a.a locala = com.tencent.mm.pluginsdk.k.a.a.ix(MMApplicationContext.getContext());
    if (this.Qhx != null)
    {
      if (locala != null)
      {
        this.Qhx.QhB = locala;
        this.Qhx.anp();
        if ((this.Qhx != null) && (this.Qhx.getCount() > 0) && (this.Qhx.aoa(0).a(this.Qhy) == 0)) {}
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
    if (g.aAf().azp())
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().remove(this.Qhx);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return 2131492986;
  }
  
  public final void release()
  {
    this.Qhx = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.sc != null) {
      this.sc.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void aZq(String paramString);
    
    public abstract void nk(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */