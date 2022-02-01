package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b KUh;
  private d KUi;
  a KUj;
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
      this.KUi = new d();
      this.KUi.KUn = this.rY;
      this.KUi.KUo = ((Button)this.view.findViewById(2131296429));
      this.KUi.KUo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((a.this.KUh != null) && (a.this.KUj != null))
          {
            paramAnonymousView = a.this.KUh.afq(a.this.baa);
            a.this.KUj.aJl(paramAnonymousView.KUm.id);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((a.this.KUh != null) && (a.this.KUj != null))
          {
            paramAnonymousView = a.this.KUh.afq(a.this.baa);
            a.this.KUj.mw(paramAnonymousView.KUm.id, paramAnonymousView.KUm.url);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(38762);
    this.KUh = new b((Context)this.FpA.get());
    this.KUj = new a()
    {
      public final void aJl(String paramAnonymousString)
      {
        AppMethodBeat.i(38758);
        com.tencent.mm.pluginsdk.k.a.a.feV();
        bc.aCg();
        com.tencent.mm.model.c.azE().d(new m(3, paramAnonymousString));
        AppMethodBeat.o(38758);
      }
      
      public final void mw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(38757);
        com.tencent.mm.pluginsdk.k.a.a.feV();
        bc.aCg();
        com.tencent.mm.model.c.azE().d(new m(2, paramAnonymousString1));
        ae.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramAnonymousString2)));
        q.a.Fca.a((Context)a.this.FpA.get(), paramAnonymousString2, true);
        AppMethodBeat.o(38757);
      }
    };
    com.tencent.mm.pluginsdk.k.a.a locala = com.tencent.mm.pluginsdk.k.a.a.hD(ak.getContext());
    if (this.KUh != null)
    {
      if (locala != null)
      {
        this.KUh.KUl = locala;
        this.KUh.ZD();
        if ((this.KUh != null) && (this.KUh.getCount() > 0) && (this.KUh.afq(0).a(this.KUi) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ae.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
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
    if (g.ajP().aiZ())
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().b(this.KUh);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return 2131492953;
  }
  
  public final void release()
  {
    this.KUh = null;
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
    public abstract void aJl(String paramString);
    
    public abstract void mw(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */