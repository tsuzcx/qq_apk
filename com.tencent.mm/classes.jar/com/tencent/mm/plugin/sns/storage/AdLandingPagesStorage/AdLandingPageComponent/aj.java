package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class aj
  extends x
{
  public float borderWidth;
  public List<a> hGT;
  public String wXA;
  public String wXu;
  public String wXv;
  public int wXw;
  public int wXx;
  public int wXy;
  public int wXz;
  
  public aj()
  {
    AppMethodBeat.i(96329);
    this.wXu = "";
    this.wXv = "";
    this.wXA = "";
    this.hGT = new ArrayList();
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
    if ((paramObject instanceof aj))
    {
      paramObject = (aj)paramObject;
      if (paramObject.wXu == null)
      {
        if (this.wXu != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.wXv != null) {
          break label169;
        }
        if (this.wXv != null) {
          break label162;
        }
        if ((paramObject.wXw != this.wXw) || (paramObject.wXx != this.wXx) || (paramObject.wXy != this.wXy) || (paramObject.wXz != this.wXz)) {
          break label162;
        }
        if (paramObject.hGT != null) {
          break label186;
        }
        if (this.hGT != null) {
          break label162;
        }
        label127:
        if (paramObject.wXA != null) {
          break label205;
        }
        if (this.wXA != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.wXu.equals(this.wXu)) {
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
            } while (!paramObject.wXv.equals(this.wXv));
            break;
          } while (!paramObject.hGT.equals(this.hGT));
          break label127;
        } while (!paramObject.wXA.equals(this.wXA));
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
    public String label = "";
    public float value;
    public String wXB = "";
    
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
        if ((paramObject.label.equals(this.label)) && (paramObject.wXB.equals(this.wXB)) && (paramObject.value == this.value))
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
      int i = (int)(this.label.hashCode() + this.wXB.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj
 * JD-Core Version:    0.7.0.1
 */