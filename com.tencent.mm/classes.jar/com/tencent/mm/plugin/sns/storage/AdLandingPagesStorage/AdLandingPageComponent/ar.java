package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ar
  extends aa
{
  public String QLJ;
  public String QLK;
  public int QLL;
  public int QLM;
  public int QLN;
  public int QLO;
  public String QLP;
  public float borderWidth;
  public List<ar.a> piH;
  
  public ar()
  {
    AppMethodBeat.i(96329);
    this.QLJ = "";
    this.QLK = "";
    this.QLP = "";
    this.piH = new ArrayList();
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
    if ((paramObject instanceof ar))
    {
      paramObject = (ar)paramObject;
      if (paramObject.QLJ == null)
      {
        if (this.QLJ != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.QLK != null) {
          break label169;
        }
        if (this.QLK != null) {
          break label162;
        }
        if ((paramObject.QLL != this.QLL) || (paramObject.QLM != this.QLM) || (paramObject.QLN != this.QLN) || (paramObject.QLO != this.QLO)) {
          break label162;
        }
        if (paramObject.piH != null) {
          break label186;
        }
        if (this.piH != null) {
          break label162;
        }
        label127:
        if (paramObject.QLP != null) {
          break label205;
        }
        if (this.QLP != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(96330);
        return true;
        if (paramObject.QLJ.equals(this.QLJ)) {
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
            } while (!paramObject.QLK.equals(this.QLK));
            break;
          } while (!paramObject.piH.equals(this.piH));
          break label127;
        } while (!paramObject.QLP.equals(this.QLP));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar
 * JD-Core Version:    0.7.0.1
 */