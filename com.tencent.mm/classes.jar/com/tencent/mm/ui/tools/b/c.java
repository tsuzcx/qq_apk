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
  protected boolean afMe = true;
  public WeakReference<EditText> afMf;
  protected int afMg;
  protected int afMh;
  protected ArrayList<InputFilter> afMi;
  public a afMj;
  protected String mText;
  protected g.a uGI;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.uGI = g.a.afII;
    this.afMe = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.afMf = paramWeakReference;
    this.uGI = g.a.afII;
    this.afMe = false;
  }
  
  public static String bCI(String paramString)
  {
    AppMethodBeat.i(251160);
    String str = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      int i = g.bCx(paramString);
      g.ek(32, paramString);
      str = paramString;
      if (i > 32)
      {
        i = g.ei(32, paramString);
        str = paramString;
        if (i > 0)
        {
          str = paramString;
          if (i < 32)
          {
            str = paramString;
            if (i < paramString.length()) {
              str = paramString.substring(0, i);
            }
          }
        }
      }
    }
    AppMethodBeat.o(251160);
    return str;
  }
  
  public static c i(EditText paramEditText)
  {
    AppMethodBeat.i(133841);
    paramEditText = new c(new WeakReference(paramEditText));
    AppMethodBeat.o(133841);
    return paramEditText;
  }
  
  public final c Nc(boolean paramBoolean)
  {
    this.afMe = paramBoolean;
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
    this.afMj = parama;
    fBQ();
    AppMethodBeat.o(133842);
  }
  
  public final c aEg(int paramInt)
  {
    this.afMh = 0;
    this.afMg = paramInt;
    return this;
  }
  
  public final c b(g.a parama)
  {
    this.uGI = parama;
    return this;
  }
  
  protected int cnU()
  {
    AppMethodBeat.i(133843);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.afMf == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.afMf.get()).getText().toString().trim();
    }
    int j = g.a(this.mText, this.uGI);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.afMh)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.afMg)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected void fBQ()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.afMe)
    {
      if (this.afMf == null)
      {
        Log.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (Util.isNullOrNil(this.afMi))
      {
        localObject = a(this.afMg, this.uGI);
        ((EditText)this.afMf.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.afMj != null)
    {
      switch (cnU())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.afMi.add(a(this.afMg, this.uGI));
      localObject = (InputFilter[])this.afMi.toArray(new InputFilter[this.afMi.size()]);
      ((EditText)this.afMf.get()).setFilters((InputFilter[])localObject);
      break;
      this.afMj.Tw(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.afMj.Tx(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.afMj.eY(this.mText);
    }
  }
  
  public final c oF(int paramInt1, int paramInt2)
  {
    this.afMh = paramInt1;
    this.afMg = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void Tw(String paramString);
    
    public abstract void Tx(String paramString);
    
    public abstract void eY(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */