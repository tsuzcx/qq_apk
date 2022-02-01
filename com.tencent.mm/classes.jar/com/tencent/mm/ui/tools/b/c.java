package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  public boolean LiL = true;
  public WeakReference<EditText> LiM;
  private int LiN;
  private int LiO;
  private ArrayList<InputFilter> LiP;
  public a LiQ;
  private String mText;
  public f.a njK;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.njK = f.a.Lfh;
    this.LiL = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.LiM = paramWeakReference;
    this.njK = f.a.Lfh;
    this.LiL = false;
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
    this.njK = parama;
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
    this.LiQ = parama;
    cYX();
    AppMethodBeat.o(133842);
  }
  
  public final c afD(int paramInt)
  {
    this.LiO = 0;
    this.LiN = paramInt;
    return this;
  }
  
  protected final int bgQ()
  {
    AppMethodBeat.i(133843);
    if (bu.isNullOrNil(this.mText))
    {
      if (this.LiM == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.LiM.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.njK);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.LiO)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.LiN)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected final void cYX()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.LiL)
    {
      if (this.LiM == null)
      {
        ae.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (bu.ht(this.LiP))
      {
        localObject = a(this.LiN, this.njK);
        ((EditText)this.LiM.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.LiQ != null)
    {
      switch (bgQ())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.LiP.add(a(this.LiN, this.njK));
      localObject = (InputFilter[])this.LiP.toArray(new InputFilter[this.LiP.size()]);
      ((EditText)this.LiM.get()).setFilters((InputFilter[])localObject);
      break;
      this.LiQ.Ky(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.LiQ.aUT();
      AppMethodBeat.o(133844);
      return;
      this.LiQ.cW(this.mText);
    }
  }
  
  public final c fPi()
  {
    this.LiL = true;
    return this;
  }
  
  public final c kj(int paramInt1, int paramInt2)
  {
    this.LiO = paramInt1;
    this.LiN = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void Ky(String paramString);
    
    public abstract void aUT();
    
    public abstract void cW(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */