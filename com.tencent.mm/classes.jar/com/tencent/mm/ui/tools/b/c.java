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
  public boolean KMn = true;
  public WeakReference<EditText> KMo;
  private int KMp;
  private int KMq;
  private ArrayList<InputFilter> KMr;
  public a KMs;
  private String mText;
  public f.a neC;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.neC = f.a.KIN;
    this.KMn = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.KMo = paramWeakReference;
    this.neC = f.a.KIN;
    this.KMn = false;
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
    this.neC = parama;
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
    this.KMs = parama;
    cWs();
    AppMethodBeat.o(133842);
  }
  
  public final c aeU(int paramInt)
  {
    this.KMq = 0;
    this.KMp = paramInt;
    return this;
  }
  
  protected final int bgi()
  {
    AppMethodBeat.i(133843);
    if (bt.isNullOrNil(this.mText))
    {
      if (this.KMo == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.KMo.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.neC);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.KMq)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.KMp)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected final void cWs()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.KMn)
    {
      if (this.KMo == null)
      {
        ad.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (bt.hj(this.KMr))
      {
        localObject = a(this.KMp, this.neC);
        ((EditText)this.KMo.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.KMs != null)
    {
      switch (bgi())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.KMr.add(a(this.KMp, this.neC));
      localObject = (InputFilter[])this.KMr.toArray(new InputFilter[this.KMr.size()]);
      ((EditText)this.KMo.get()).setFilters((InputFilter[])localObject);
      break;
      this.KMs.JZ(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.KMs.aUu();
      AppMethodBeat.o(133844);
      return;
      this.KMs.cU(this.mText);
    }
  }
  
  public final c fKP()
  {
    this.KMn = true;
    return this;
  }
  
  public final c kc(int paramInt1, int paramInt2)
  {
    this.KMq = paramInt1;
    this.KMp = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void JZ(String paramString);
    
    public abstract void aUu();
    
    public abstract void cU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */