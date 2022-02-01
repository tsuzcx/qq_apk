package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ao
  extends z
{
  public String Eah;
  public String Eai;
  public int Eaj;
  public int Eak;
  public int Eal;
  public int Eam;
  public String Ean;
  public float borderWidth;
  public List<a> jzm;
  
  public ao()
  {
    AppMethodBeat.i(96329);
    this.Eah = "";
    this.Eai = "";
    this.Ean = "";
    this.jzm = new ArrayList();
    AppMethodBeat.o(96329);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(96330);
    if (paramObject == this)
    {
      AppMethodBeat.o(96330);
      return true;
    }
    if ((paramObject instanceof ao))
    {
      paramObject = (ao)paramObject;
      if (paramObject.Eah == null)
      {
        if (this.Eah != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.Eai != null) {
          break label169;
        }
        if (this.Eai != null) {
          break label162;
        }
        if ((paramObject.Eaj != this.Eaj) || (paramObject.Eak != this.Eak) || (paramObject.Eal != this.Eal) || (paramObject.Eam != this.Eam)) {
          break label162;
        }
        if (paramObject.jzm != null) {
          break label186;
        }
        if (this.jzm != null) {
          break label162;
        }
        label127:
        if (paramObject.Ean != null) {
          break label205;
        }
        if (this.Ean != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.Eah.equals(this.Eah)) {
          break;
        }
        label162:
        label169:
        label186:
        label205:
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(96330);
              return false;
            } while (!paramObject.Eai.equals(this.Eai));
            break;
          } while (!paramObject.jzm.equals(this.jzm));
          break label127;
        } while (!paramObject.Ean.equals(this.Ean));
      }
    }
    AppMethodBeat.o(96330);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(96331);
    int i = super.hashCode();
    AppMethodBeat.o(96331);
    return i;
  }
  
  public static final class a
  {
    public String Eao = "";
    public String label = "";
    public float value;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(96327);
      if (paramObject == this)
      {
        AppMethodBeat.o(96327);
        return true;
      }
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((paramObject.label.equals(this.label)) && (paramObject.Eao.equals(this.Eao)) && (paramObject.value == this.value))
        {
          AppMethodBeat.o(96327);
          return true;
        }
        AppMethodBeat.o(96327);
        return false;
      }
      AppMethodBeat.o(96327);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(96328);
      int i = (int)(this.label.hashCode() + this.Eao.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao
 * JD-Core Version:    0.7.0.1
 */