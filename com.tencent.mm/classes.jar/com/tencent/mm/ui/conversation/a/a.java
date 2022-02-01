package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b KxN;
  private d KxO;
  a KxP;
  int baa;
  private View rY;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.baa = 0;
    this.rY = null;
    if (this.view != null)
    {
      this.rY = this.view.findViewById(2131296508);
      this.KxO = new d();
      this.KxO.KxT = this.rY;
      this.KxO.KxU = ((Button)this.view.findViewById(2131296429));
      this.KxO.KxU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((a.this.KxN != null) && (a.this.KxP != null))
          {
            paramAnonymousView = a.this.KxN.aeH(a.this.baa);
            a.this.KxP.aHS(paramAnonymousView.KxS.id);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38755);
        }
      });
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((a.this.KxN != null) && (a.this.KxP != null))
          {
            paramAnonymousView = a.this.KxN.aeH(a.this.baa);
            a.this.KxP.mp(paramAnonymousView.KxS.id, paramAnonymousView.KxS.url);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38762);
    this.KxN = new b((Context)this.EXg.get());
    this.KxP = new a()
    {
      public final void aHS(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.k.a.a.fbh();
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new m(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void mp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.k.a.a.fbh();
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new m(2, paramAnonymousString1));
        ad.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        q.a.EJC.a((Context)a.this.EXg.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.k.a.a locala = com.tencent.mm.pluginsdk.k.a.a.hx(aj.getContext());
    if (this.KxN != null)
    {
      if (locala != null)
      {
        this.KxN.KxR = locala;
        this.KxN.Zu();
        if ((this.KxN != null) && (this.KxN.getCount() > 0) && (this.KxN.aeH(0).a(this.KxO) == 0)) {}
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
    if (g.ajA().aiK())
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().b(this.KxN);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return 2131492953;
  }
  
  public final void release()
  {
    this.KxN = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.rY != null) {
      this.rY.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void aHS(String paramString);
    
    public abstract void mp(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */