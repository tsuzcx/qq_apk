package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  protected boolean XVP = true;
  public WeakReference<EditText> XVQ;
  protected int XVR;
  protected int XVS;
  protected ArrayList<InputFilter> XVT;
  public a XVU;
  protected String mText;
  protected g.a rvC;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.rvC = g.a.XSu;
    this.XVP = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.XVQ = paramWeakReference;
    this.rvC = g.a.XSu;
    this.XVP = false;
  }
  
  public static c i(EditText paramEditText)
  {
    AppMethodBeat.i(133841);
    paramEditText = new c(new WeakReference(paramEditText));
    AppMethodBeat.o(133841);
    return paramEditText;
  }
  
  public final c Hh(boolean paramBoolean)
  {
    this.XVP = paramBoolean;
    return this;
  }
  
  protected g a(int paramInt, g.a parama)
  {
    AppMethodBeat.i(133845);
    parama = new g(paramInt, parama);
    AppMethodBeat.o(133845);
    return parama;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(133842);
    this.XVU = parama;
    euX();
    AppMethodBeat.o(133842);
  }
  
  public final c axx(int paramInt)
  {
    this.XVS = 0;
    this.XVR = paramInt;
    return this;
  }
  
  public final c b(g.a parama)
  {
    this.rvC = parama;
    return this;
  }
  
  protected int bNF()
  {
    AppMethodBeat.i(133843);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.XVQ == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.XVQ.get()).getText().toString().trim();
    }
    int j = g.a(this.mText, this.rvC);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.XVS)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.XVR)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected void euX()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.XVP)
    {
      if (this.XVQ == null)
      {
        Log.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (Util.isNullOrNil(this.XVT))
      {
        localObject = a(this.XVR, this.rvC);
        ((EditText)this.XVQ.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.XVU != null)
    {
      switch (bNF())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.XVT.add(a(this.XVR, this.rvC));
      localObject = (InputFilter[])this.XVT.toArray(new InputFilter[this.XVT.size()]);
      ((EditText)this.XVQ.get()).setFilters((InputFilter[])localObject);
      break;
      this.XVU.abc(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.XVU.abd(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.XVU.dN(this.mText);
    }
  }
  
  public final c mM(int paramInt1, int paramInt2)
  {
    this.XVS = paramInt1;
    this.XVR = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void abc(String paramString);
    
    public abstract void abd(String paramString);
    
    public abstract void dN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */