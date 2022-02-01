package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  b afsE;
  private d afsF;
  a afsG;
  int apW;
  private View doN;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38759);
    this.apW = 0;
    this.doN = null;
    if (this.view != null)
    {
      this.doN = this.view.findViewById(R.h.fqW);
      this.afsF = new d();
      this.afsF.afsL = this.doN;
      this.afsF.afsM = ((Button)this.view.findViewById(R.h.fqp));
      this.afsF.afsM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38755);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((a.this.afsE != null) && (a.this.afsG != null))
          {
            paramAnonymousView = a.this.afsE.aDN(a.this.apW);
            a.this.afsG.bkM(paramAnonymousView.afsK.id);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38755);
        }
      });
      this.doN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38756);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((a.this.afsE != null) && (a.this.afsG != null))
          {
            paramAnonymousView = a.this.afsE.aDN(a.this.apW);
            a.this.afsG.qc(paramAnonymousView.afsK.id, paramAnonymousView.afsK.url);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38756);
        }
      });
    }
    AppMethodBeat.o(38759);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38762);
    this.afsE = new b((Context)this.Ydi.get());
    this.afsG = new a.3(this);
    com.tencent.mm.pluginsdk.k.a.a locala = com.tencent.mm.pluginsdk.k.a.a.lz(MMApplicationContext.getContext());
    if (this.afsE != null)
    {
      if (locala != null)
      {
        this.afsE.afsJ = locala;
        this.afsE.aNy();
        if ((this.afsE != null) && (this.afsE.getCount() > 0) && (this.afsE.aDN(0).a(this.afsF) == 0)) {}
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
    if (h.baC().aZN())
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().remove(this.afsE);
    }
    AppMethodBeat.o(38760);
  }
  
  public final int getLayoutId()
  {
    return R.i.geb;
  }
  
  public final void release()
  {
    this.afsE = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38761);
    if (this.doN != null) {
      this.doN.setVisibility(paramInt);
    }
    AppMethodBeat.o(38761);
  }
  
  public static abstract interface a
  {
    public abstract void bkM(String paramString);
    
    public abstract void qc(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.a
 * JD-Core Version:    0.7.0.1
 */