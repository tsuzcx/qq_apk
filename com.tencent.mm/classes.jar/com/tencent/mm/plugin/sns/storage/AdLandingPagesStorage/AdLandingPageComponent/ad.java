package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ad
  extends t
{
  public float borderWidth;
  public List<ad.a> itemList;
  public String rtn;
  public String rto;
  public int rtp;
  public int rtq;
  public int rtr;
  public int rts;
  public String rtt;
  
  public ad()
  {
    AppMethodBeat.i(36949);
    this.rtn = "";
    this.rto = "";
    this.rtt = "";
    this.itemList = new ArrayList();
    AppMethodBeat.o(36949);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(36950);
    if (paramObject == this)
    {
      AppMethodBeat.o(36950);
      return true;
    }
    if ((paramObject instanceof ad))
    {
      paramObject = (ad)paramObject;
      if (paramObject.rtn == null)
      {
        if (this.rtn != null) {
          break label162;
        }
        if (paramObject.borderWidth != this.borderWidth) {
          break label162;
        }
        if (paramObject.rto != null) {
          break label169;
        }
        if (this.rto != null) {
          break label162;
        }
        if ((paramObject.rtp != this.rtp) || (paramObject.rtq != this.rtq) || (paramObject.rtr != this.rtr) || (paramObject.rts != this.rts)) {
          break label162;
        }
        if (paramObject.itemList != null) {
          break label186;
        }
        if (this.itemList != null) {
          break label162;
        }
        label127:
        if (paramObject.rtt != null) {
          break label205;
        }
        if (this.rtt != null) {
          break label162;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(36950);
        return true;
        if (paramObject.rtn.equals(this.rtn)) {
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
              AppMethodBeat.o(36950);
              return false;
            } while (!paramObject.rto.equals(this.rto));
            break;
          } while (!paramObject.itemList.equals(this.itemList));
          break label127;
        } while (!paramObject.rtt.equals(this.rtt));
      }
    }
    AppMethodBeat.o(36950);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(36951);
    int i = super.hashCode();
    AppMethodBeat.o(36951);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad
 * JD-Core Version:    0.7.0.1
 */