package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  public boolean HuM = true;
  public WeakReference<EditText> HuN;
  private int HuO;
  private int HuP;
  private ArrayList<InputFilter> HuQ;
  public a HuR;
  private String mText;
  public f.a mcf;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.mcf = f.a.Hrm;
    this.HuM = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.HuN = paramWeakReference;
    this.mcf = f.a.Hrm;
    this.HuM = false;
  }
  
  public static c d(EditText paramEditText)
  {
    AppMethodBeat.i(133841);
    paramEditText = new c(new WeakReference(paramEditText));
    AppMethodBeat.o(133841);
    return paramEditText;
  }
  
  public final c a(f.a parama)
  {
    this.mcf = parama;
    return this;
  }
  
  protected f a(int paramInt, f.a parama)
  {
    AppMethodBeat.i(133845);
    parama = new f(paramInt, parama);
    AppMethodBeat.o(133845);
    return parama;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(133842);
    this.HuR = parama;
    cAQ();
    AppMethodBeat.o(133842);
  }
  
  protected final int aVG()
  {
    AppMethodBeat.i(133843);
    if (bt.isNullOrNil(this.mText))
    {
      if (this.HuN == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.HuN.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.mcf);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.HuP)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.HuO)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  public final c aaj(int paramInt)
  {
    this.HuP = 0;
    this.HuO = paramInt;
    return this;
  }
  
  protected final void cAQ()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.HuM)
    {
      if (this.HuN == null)
      {
        ad.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (bt.gL(this.HuQ))
      {
        localObject = a(this.HuO, this.mcf);
        ((EditText)this.HuN.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.HuR != null)
    {
      switch (aVG())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.HuQ.add(a(this.HuO, this.mcf));
      localObject = (InputFilter[])this.HuQ.toArray(new InputFilter[this.HuQ.size()]);
      ((EditText)this.HuN.get()).setFilters((InputFilter[])localObject);
      break;
      this.HuR.CH(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.HuR.aKr();
      AppMethodBeat.o(133844);
      return;
      this.HuR.ck(this.mText);
    }
  }
  
  public final c feh()
  {
    this.HuM = true;
    return this;
  }
  
  public final c jE(int paramInt1, int paramInt2)
  {
    this.HuP = paramInt1;
    this.HuO = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void CH(String paramString);
    
    public abstract void aKr();
    
    public abstract void ck(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */