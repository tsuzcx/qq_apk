package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class al
  extends x
{
  public float borderWidth;
  public List<a> iAP;
  public String zAX;
  public String zAY;
  public int zAZ;
  public int zBa;
  public int zBb;
  public int zBc;
  public String zBd;
  
  public al()
  {
    AppMethodBeat.i(96329);
    this.zAX = "";
    this.zAY = "";
    this.zBd = "";
    this.iAP = new ArrayList();
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
    if ((paramObject instanceof al))
    {
      paramObject = (al)paramObject;
      if (paramObject.zAX == null)
      {
        if (this.zAX != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.zAY != null) {
          break label169;
        }
        if (this.zAY != null) {
          break label162;
        }
        if ((paramObject.zAZ != this.zAZ) || (paramObject.zBa != this.zBa) || (paramObject.zBb != this.zBb) || (paramObject.zBc != this.zBc)) {
          break label162;
        }
        if (paramObject.iAP != null) {
          break label186;
        }
        if (this.iAP != null) {
          break label162;
        }
        label127:
        if (paramObject.zBd != null) {
          break label205;
        }
        if (this.zBd != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.zAX.equals(this.zAX)) {
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
            } while (!paramObject.zAY.equals(this.zAY));
            break;
          } while (!paramObject.iAP.equals(this.iAP));
          break label127;
        } while (!paramObject.zBd.equals(this.zBd));
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
    public String zBe = "";
    
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
        if ((paramObject.label.equals(this.label)) && (paramObject.zBe.equals(this.zBe)) && (paramObject.value == this.value))
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
      int i = (int)(this.label.hashCode() + this.zBe.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al
 * JD-Core Version:    0.7.0.1
 */