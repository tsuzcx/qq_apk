package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c
  extends a
{
  private String hnV;
  public f.a huj;
  public boolean wfM = true;
  public WeakReference<EditText> wfN;
  private int wfO;
  private int wfP;
  private ArrayList<InputFilter> wfQ;
  public a wfR;
  
  public c(String paramString)
  {
    this.hnV = paramString;
    this.huj = f.a.wcT;
    this.wfM = false;
  }
  
  public c(WeakReference<EditText> paramWeakReference)
  {
    this.wfN = paramWeakReference;
    this.huj = f.a.wcT;
    this.wfM = false;
  }
  
  public static c d(EditText paramEditText)
  {
    return new c(new WeakReference(paramEditText));
  }
  
  public final c Ig(int paramInt)
  {
    this.wfP = 0;
    this.wfO = paramInt;
    return this;
  }
  
  public f a(int paramInt, f.a parama)
  {
    return new f(paramInt, parama);
  }
  
  public final void a(a parama)
  {
    this.wfR = parama;
    cnV();
  }
  
  protected final int afv()
  {
    if (bk.bl(this.hnV))
    {
      if (this.wfN == null) {
        return 1;
      }
      this.hnV = ((EditText)this.wfN.get()).getText().toString().trim();
    }
    int j = f.a(this.hnV, this.huj);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      return 2;
    }
    if (j < this.wfP) {
      return 1;
    }
    if (j > this.wfO) {
      return 2;
    }
    return 0;
  }
  
  protected final void cnV()
  {
    Object localObject;
    if (!this.wfM)
    {
      if (this.wfN == null)
      {
        y.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        return;
      }
      if (!bk.dk(this.wfQ)) {
        break label119;
      }
      localObject = a(this.wfO, this.huj);
      ((EditText)this.wfN.get()).setFilters(new InputFilter[] { localObject });
    }
    while (this.wfR != null) {
      switch (afv())
      {
      default: 
        return;
      case 0: 
        this.wfR.eP(this.hnV);
        return;
        label119:
        this.wfQ.add(a(this.wfO, this.huj));
        localObject = (InputFilter[])this.wfQ.toArray(new InputFilter[this.wfQ.size()]);
        ((EditText)this.wfN.get()).setFilters((InputFilter[])localObject);
      }
    }
    this.wfR.xB();
    return;
    this.wfR.xC();
  }
  
  public final c fJ(int paramInt1, int paramInt2)
  {
    this.wfP = paramInt1;
    this.wfO = paramInt2;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void eP(String paramString);
    
    public abstract void xB();
    
    public abstract void xC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.c
 * JD-Core Version:    0.7.0.1
 */