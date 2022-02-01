package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ap
  extends aa
{
  public String KnC;
  public String KnD;
  public int KnE;
  public int KnF;
  public int KnG;
  public int KnH;
  public String KnI;
  public float borderWidth;
  public List<a> moS;
  
  public ap()
  {
    AppMethodBeat.i(96329);
    this.KnC = "";
    this.KnD = "";
    this.KnI = "";
    this.moS = new ArrayList();
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
    if ((paramObject instanceof ap))
    {
      paramObject = (ap)paramObject;
      if (paramObject.KnC == null)
      {
        if (this.KnC != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.KnD != null) {
          break label169;
        }
        if (this.KnD != null) {
          break label162;
        }
        if ((paramObject.KnE != this.KnE) || (paramObject.KnF != this.KnF) || (paramObject.KnG != this.KnG) || (paramObject.KnH != this.KnH)) {
          break label162;
        }
        if (paramObject.moS != null) {
          break label186;
        }
        if (this.moS != null) {
          break label162;
        }
        label127:
        if (paramObject.KnI != null) {
          break label205;
        }
        if (this.KnI != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.KnC.equals(this.KnC)) {
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
            } while (!paramObject.KnD.equals(this.KnD));
            break;
          } while (!paramObject.moS.equals(this.moS));
          break label127;
        } while (!paramObject.KnI.equals(this.KnI));
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
    public String KnJ = "";
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
        if ((paramObject.label.equals(this.label)) && (paramObject.KnJ.equals(this.KnJ)) && (paramObject.value == this.value))
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
      int i = (int)(this.label.hashCode() + this.KnJ.hashCode() + this.value);
      AppMethodBeat.o(96328);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap
 * JD-Core Version:    0.7.0.1
 */