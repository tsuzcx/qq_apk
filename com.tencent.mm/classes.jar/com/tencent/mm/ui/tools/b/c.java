package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  public boolean AyD = true;
  public WeakReference<EditText> AyE;
  private int AyF;
  private int AyG;
  private ArrayList<InputFilter> AyH;
  public a AyI;
  public f.a jmp;
  private String mText;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.jmp = f.a.Avn;
    this.AyD = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.AyE = paramWeakReference;
    this.jmp = f.a.Avn;
    this.AyD = false;
  }
  
  public static c d(EditText paramEditText)
  {
    AppMethodBeat.i(67866);
    paramEditText = new c(new WeakReference(paramEditText));
    AppMethodBeat.o(67866);
    return paramEditText;
  }
  
  public final c QS(int paramInt)
  {
    this.AyG = 0;
    this.AyF = paramInt;
    return this;
  }
  
  protected f a(int paramInt, f.a parama)
  {
    AppMethodBeat.i(67870);
    parama = new f(paramInt, parama);
    AppMethodBeat.o(67870);
    return parama;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(67867);
    this.AyI = parama;
    bEI();
    AppMethodBeat.o(67867);
  }
  
  protected final int azZ()
  {
    AppMethodBeat.i(67868);
    if (bo.isNullOrNil(this.mText))
    {
      if (this.AyE == null)
      {
        AppMethodBeat.o(67868);
        return 1;
      }
      this.mText = ((EditText)this.AyE.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.jmp);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(67868);
      return 2;
    }
    if (j < this.AyG)
    {
      AppMethodBeat.o(67868);
      return 1;
    }
    if (j > this.AyF)
    {
      AppMethodBeat.o(67868);
      return 2;
    }
    AppMethodBeat.o(67868);
    return 0;
  }
  
  protected final void bEI()
  {
    AppMethodBeat.i(67869);
    Object localObject;
    if (!this.AyD)
    {
      if (this.AyE == null)
      {
        ab.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(67869);
        return;
      }
      if (bo.es(this.AyH))
      {
        localObject = a(this.AyF, this.jmp);
        ((EditText)this.AyE.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.AyI != null)
    {
      switch (azZ())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(67869);
      return;
      this.AyH.add(a(this.AyF, this.jmp));
      localObject = (InputFilter[])this.AyH.toArray(new InputFilter[this.AyH.size()]);
      ((EditText)this.AyE.get()).setFilters((InputFilter[])localObject);
      break;
      this.AyI.kY(this.mText);
      AppMethodBeat.o(67869);
      return;
      this.AyI.JU();
      AppMethodBeat.o(67869);
      return;
      this.AyI.vn();
    }
  }
  
  public final c hR(int paramInt1, int paramInt2)
  {
    this.AyG = paramInt1;
    this.AyF = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void JU();
    
    public abstract void kY(String paramString);
    
    public abstract void vn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */