package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  public boolean IVj = true;
  public WeakReference<EditText> IVk;
  private int IVl;
  private int IVm;
  private ArrayList<InputFilter> IVn;
  public a IVo;
  public f.a mEd;
  private String mText;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.mEd = f.a.IRJ;
    this.IVj = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.IVk = paramWeakReference;
    this.mEd = f.a.IRJ;
    this.IVj = false;
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
    this.mEd = parama;
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
    this.IVo = parama;
    cNZ();
    AppMethodBeat.o(133842);
  }
  
  public final c acw(int paramInt)
  {
    this.IVm = 0;
    this.IVl = paramInt;
    return this;
  }
  
  protected final int bcE()
  {
    AppMethodBeat.i(133843);
    if (bs.isNullOrNil(this.mText))
    {
      if (this.IVk == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.IVk.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.mEd);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.IVm)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.IVl)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected final void cNZ()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.IVj)
    {
      if (this.IVk == null)
      {
        ac.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (bs.gY(this.IVn))
      {
        localObject = a(this.IVl, this.mEd);
        ((EditText)this.IVk.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.IVo != null)
    {
      switch (bcE())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.IVn.add(a(this.IVl, this.mEd));
      localObject = (InputFilter[])this.IVn.toArray(new InputFilter[this.IVn.size()]);
      ((EditText)this.IVk.get()).setFilters((InputFilter[])localObject);
      break;
      this.IVo.GK(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.IVo.aRi();
      AppMethodBeat.o(133844);
      return;
      this.IVo.ca(this.mText);
    }
  }
  
  public final c fuc()
  {
    this.IVj = true;
    return this;
  }
  
  public final c jQ(int paramInt1, int paramInt2)
  {
    this.IVm = paramInt1;
    this.IVl = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void GK(String paramString);
    
    public abstract void aRi();
    
    public abstract void ca(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */