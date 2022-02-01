package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  protected boolean QxK = true;
  public WeakReference<EditText> QxL;
  protected int QxM;
  protected int QxN;
  protected ArrayList<InputFilter> QxO;
  public a QxP;
  protected String mText;
  protected f.a ots;
  
  public c(String paramString)
  {
    this.mText = paramString;
    this.ots = f.a.Qui;
    this.QxK = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.QxL = paramWeakReference;
    this.ots = f.a.Qui;
    this.QxK = false;
  }
  
  public static c f(EditText paramEditText)
  {
    AppMethodBeat.i(133841);
    paramEditText = new c(new WeakReference(paramEditText));
    AppMethodBeat.o(133841);
    return paramEditText;
  }
  
  public final c CN(boolean paramBoolean)
  {
    this.QxK = paramBoolean;
    return this;
  }
  
  public final c a(f.a parama)
  {
    this.ots = parama;
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
    this.QxP = parama;
    dSw();
    AppMethodBeat.o(133842);
  }
  
  public final c aoq(int paramInt)
  {
    this.QxN = 0;
    this.QxM = paramInt;
    return this;
  }
  
  protected int bCj()
  {
    AppMethodBeat.i(133843);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.QxL == null)
      {
        AppMethodBeat.o(133843);
        return 1;
      }
      this.mText = ((EditText)this.QxL.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.ots);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(133843);
      return 2;
    }
    if (j < this.QxN)
    {
      AppMethodBeat.o(133843);
      return 1;
    }
    if (j > this.QxM)
    {
      AppMethodBeat.o(133843);
      return 2;
    }
    AppMethodBeat.o(133843);
    return 0;
  }
  
  protected void dSw()
  {
    AppMethodBeat.i(133844);
    Object localObject;
    if (!this.QxK)
    {
      if (this.QxL == null)
      {
        Log.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(133844);
        return;
      }
      if (Util.isNullOrNil(this.QxO))
      {
        localObject = a(this.QxM, this.ots);
        ((EditText)this.QxL.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.QxP != null)
    {
      switch (bCj())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133844);
      return;
      this.QxO.add(a(this.QxM, this.ots));
      localObject = (InputFilter[])this.QxO.toArray(new InputFilter[this.QxO.size()]);
      ((EditText)this.QxL.get()).setFilters((InputFilter[])localObject);
      break;
      this.QxP.Tw(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.QxP.Tx(this.mText);
      AppMethodBeat.o(133844);
      return;
      this.QxP.dv(this.mText);
    }
  }
  
  public final c lv(int paramInt1, int paramInt2)
  {
    this.QxN = paramInt1;
    this.QxM = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void Tw(String paramString);
    
    public abstract void Tx(String paramString);
    
    public abstract void dv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.c
 * JD-Core Version:    0.7.0.1
 */