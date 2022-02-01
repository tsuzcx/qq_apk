package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ak
  extends x
{
  public float borderWidth;
  public List<a> ihv;
  public String yki;
  public String ykj;
  public int ykk;
  public int ykl;
  public int ykm;
  public int ykn;
  public String yko;
  
  public ak()
  {
    AppMethodBeat.i(96329);
    this.yki = "";
    this.ykj = "";
    this.yko = "";
    this.ihv = new ArrayList();
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
    if ((paramObject instanceof ak))
    {
      paramObject = (ak)paramObject;
      if (paramObject.yki == null)
      {
        if (this.yki != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.ykj != null) {
          break label169;
        }
        if (this.ykj != null) {
          break label162;
        }
        if ((paramObject.ykk != this.ykk) || (paramObject.ykl != this.ykl) || (paramObject.ykm != this.ykm) || (paramObject.ykn != this.ykn)) {
          break label162;
        }
        if (paramObject.ihv != null) {
          break label186;
        }
        if (this.ihv != null) {
          break label162;
        }
        label127:
        if (paramObject.yko != null) {
          break label205;
        }
        if (this.yko != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.yki.equals(this.yki)) {
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
            } while (!paramObject.ykj.equals(this.ykj));
            break;
          } while (!paramObject.ihv.equals(this.ihv));
          break label127;
        } while (!paramObject.yko.equals(this.yko));
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
    public String ykp = "";
    
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
        if ((paramObject.label.equals(this.label)) && (paramObject.ykp.equals(this.ykp)) && (paramObject.value == this.value))
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
      int i = (int)(this.label.hashCode() + this.ykp.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak
 * JD-Core Version:    0.7.0.1
 */