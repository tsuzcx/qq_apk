package com.tencent.mm.plugin.sns.ad.landingpage.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class a$b
{
  public int JCD;
  public int JCE;
  public int JCF;
  public int JCG;
  public int jlf;
  
  public final b hu(List<m> paramList)
  {
    AppMethodBeat.i(203510);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(203510);
      return this;
    }
    this.jlf = paramList.size();
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        m localm = (m)paramList.next();
        if (localm == null) {
          continue;
        }
        if (localm.KqB == null) {
          break label170;
        }
        i = localm.KqB.KmC;
        if (localm.KqB == null) {
          break label373;
        }
        j = localm.KqB.fileSize;
      }
      catch (Throwable paramList)
      {
        label104:
        Log.e("AdLandingPageStaticHelper.ComponentStaticBuilder", "build exp=" + paramList.toString());
        AppMethodBeat.o(203510);
        return this;
      }
      this.JCD += 1;
      label278:
      if (j > 0)
      {
        if (j < 20480)
        {
          i = 1;
          a.aw(1675L, i);
          continue;
          label170:
          i = 0;
        }
        else if (j < 51200)
        {
          i = 2;
        }
        else if (j < 102400)
        {
          i = 3;
        }
        else if (j < 204800)
        {
          i = 4;
        }
        else if (j < 512000)
        {
          i = 5;
        }
        else if (j < 1048576)
        {
          i = 6;
        }
        else
        {
          i = 7;
        }
      }
      else
      {
        a.aw(1675L, 19L);
        continue;
        label249:
        if (i == 61)
        {
          this.JCE += 1;
          if (j > 0)
          {
            if (j >= 1048576) {
              break label396;
            }
            i = 8;
            a.aw(1675L, i);
          }
          else
          {
            a.aw(1675L, 20L);
          }
        }
        else if (i == 62)
        {
          this.JCF += 1;
          if (j > 0)
          {
            if (j >= 3145728) {
              break label462;
            }
            i = 15;
          }
        }
      }
    }
    for (;;)
    {
      a.aw(1675L, i);
      break;
      a.aw(1675L, 21L);
      break;
      if (i != 142) {
        break;
      }
      this.JCG += 1;
      break;
      label373:
      j = 0;
      if ((i == 41) || (i == 44)) {
        break label104;
      }
      if (i != 45) {
        break label249;
      }
      break label104;
      label396:
      if (j < 2097152)
      {
        i = 9;
        break label278;
      }
      if (j < 3145728)
      {
        i = 10;
        break label278;
      }
      if (j < 4194304)
      {
        i = 11;
        break label278;
      }
      if (j < 5242880)
      {
        i = 12;
        break label278;
      }
      if (j < 10485760)
      {
        i = 13;
        break label278;
      }
      i = 14;
      break label278;
      label462:
      if (j < 5242880) {
        i = 16;
      } else if (j < 10485760) {
        i = 17;
      } else {
        i = 18;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b
 * JD-Core Version:    0.7.0.1
 */