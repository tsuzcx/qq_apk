package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class am
  extends y
{
  public float borderWidth;
  public List<a> iDI;
  public String zRX;
  public String zRY;
  public int zRZ;
  public int zSa;
  public int zSb;
  public int zSc;
  public String zSd;
  
  public am()
  {
    AppMethodBeat.i(96329);
    this.zRX = "";
    this.zRY = "";
    this.zSd = "";
    this.iDI = new ArrayList();
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
    if ((paramObject instanceof am))
    {
      paramObject = (am)paramObject;
      if (paramObject.zRX == null)
      {
        if (this.zRX != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.zRY != null) {
          break label169;
        }
        if (this.zRY != null) {
          break label162;
        }
        if ((paramObject.zRZ != this.zRZ) || (paramObject.zSa != this.zSa) || (paramObject.zSb != this.zSb) || (paramObject.zSc != this.zSc)) {
          break label162;
        }
        if (paramObject.iDI != null) {
          break label186;
        }
        if (this.iDI != null) {
          break label162;
        }
        label127:
        if (paramObject.zSd != null) {
          break label205;
        }
        if (this.zSd != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.zRX.equals(this.zRX)) {
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
            } while (!paramObject.zRY.equals(this.zRY));
            break;
          } while (!paramObject.iDI.equals(this.iDI));
          break label127;
        } while (!paramObject.zSd.equals(this.zSd));
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
    public String zSe = "";
    
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
        if ((paramObject.label.equals(this.label)) && (paramObject.zSe.equals(this.zSe)) && (paramObject.value == this.value))
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
      int i = (int)(this.label.hashCode() + this.zSe.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am
 * JD-Core Version:    0.7.0.1
 */