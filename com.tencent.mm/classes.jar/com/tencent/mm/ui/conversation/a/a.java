package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  b Amd;
  private d Ame;
  a Amf;
  int aug;
  private View jIo;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34632);
    this.aug = 0;
    this.jIo = null;
    if (this.view != null)
    {
      this.jIo = this.view.findViewById(2131821112);
      this.Ame = new d();
      this.Ame.Amj = this.jIo;
      this.Ame.Amk = ((Button)this.view.findViewById(2131821113));
      this.Ame.Amk.setOnClickListener(new a.1(this));
      this.jIo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34629);
          if ((a.this.Amd != null) && (a.this.Amf != null))
          {
            paramAnonymousView = a.this.Amd.QF(a.this.aug);
            a.this.Amf.iA(paramAnonymousView.Ami.id, paramAnonymousView.Ami.url);
          }
          AppMethodBeat.o(34629);
        }
      });
    }
    AppMethodBeat.o(34632);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34635);
    this.Amd = new b((Context)this.vUD.get());
    this.Amf = new a.3(this);
    com.tencent.mm.pluginsdk.h.a.a locala = com.tencent.mm.pluginsdk.h.a.a.fV(ah.getContext());
    if (this.Amd != null)
    {
      if (locala != null)
      {
        this.Amd.Amh = locala;
        this.Amd.Ku();
        if ((this.Amd != null) && (this.Amd.getCount() > 0) && (this.Amd.QF(0).a(this.Ame) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ab.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
          setVisibility(0);
          AppMethodBeat.o(34635);
          return true;
        }
      }
      setVisibility(8);
    }
    setVisibility(8);
    AppMethodBeat.o(34635);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(34633);
    if (g.RJ().QU())
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().b(this.Amd);
    }
    AppMethodBeat.o(34633);
  }
  
  public final int getLayoutId()
  {
    return 2130968645;
  }
  
  public final void release()
  {
    this.Amd = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34634);
    if (this.jIo != null) {
      this.jIo.setVisibility(paramInt);
    }
    AppMethodBeat.o(34634);
  }
  
  public static abstract interface a
  {
    public abstract void ahA(String paramString);
    
    public abstract void iA(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */