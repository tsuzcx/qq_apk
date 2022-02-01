package com.tencent.mm.plugin.sns.ad.landingpage.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class a$b
{
  int PTe;
  int PTf;
  int PTg;
  int PTh;
  int PTi;
  int PTj;
  int PTk;
  int PTl;
  int PTm;
  int PTn;
  int lNX;
  int oRy;
  
  public final b D(List<n> paramList, String paramString)
  {
    AppMethodBeat.i(310838);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(310838);
      return this;
    }
    this.lNX = paramList.size();
    boolean bool2;
    boolean bool1;
    int i;
    int k;
    int j;
    label168:
    label196:
    label232:
    label239:
    label371:
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        bool2 = false;
        bool1 = false;
        if (!paramList.hasNext()) {
          break label747;
        }
        n localn = (n)paramList.next();
        if (localn == null) {
          continue;
        }
        if (localn.QOV == null) {
          break label239;
        }
        i = localn.QOV.QKH;
        if (localn.QOV == null) {
          break;
        }
        k = localn.QOV.fileSize;
        j = localn.QOV.QKU;
        if (j == 0) {
          this.PTm += 1;
        }
        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.als(i)) {
          break label569;
        }
        this.oRy += 1;
        if (j != 0) {
          break label569;
        }
        this.PTn += 1;
      }
      finally
      {
        Log.e("AdLandingPageStaticHelper.ComponentStaticBuilder", "build exp=" + paramList.toString());
      }
      this.PTe += 1;
      if (j != 0) {
        break label590;
      }
      this.PTi += 1;
      break label590;
      a.bg(1675L, i);
      continue;
      AppMethodBeat.o(310838);
      return this;
      i = 0;
      continue;
      label244:
      if (k < 51200)
      {
        i = 2;
      }
      else if (k < 102400)
      {
        i = 3;
      }
      else if (k < 204800)
      {
        i = 4;
      }
      else if (k < 512000)
      {
        i = 5;
      }
      else if (k < 1048576)
      {
        i = 6;
      }
      else
      {
        i = 7;
        continue;
        a.bg(1675L, 19L);
        bool1 = true;
        continue;
        if (i == 61)
        {
          this.PTf += 1;
          if (j != 0) {
            break label608;
          }
          this.PTj += 1;
          break label608;
          a.bg(1675L, i);
          continue;
          a.bg(1675L, 20L);
          bool2 = true;
        }
        else if (i == 62)
        {
          this.PTg += 1;
          if (j != 0) {
            break label697;
          }
          this.PTk += 1;
          break label697;
          a.bg(1675L, i);
          continue;
          a.bg(1675L, 21L);
        }
        else if (i == 142)
        {
          this.PTh += 1;
          if (j == 0) {
            this.PTl += 1;
          }
        }
      }
    }
    label311:
    label326:
    label360:
    paramList = com.tencent.mm.plugin.sns.data.l.QnB;
    label420:
    label431:
    label478:
    if (bool2) {
      i = 1;
    }
    for (;;)
    {
      label492:
      com.tencent.mm.plugin.sns.data.l.a(paramList, "", i, j, Util.nullAsNil(paramString));
      Log.d("AdLandingPageStaticHelper.ComponentStaticBuilder", "imgNoFileSize=" + bool1 + ", sightNoFileSize=" + bool2 + ", uxInfo=" + paramString);
      break label232;
      i = 0;
      label569:
      label590:
      label608:
      label747:
      while (!bool1)
      {
        j = 0;
        break label492;
        j = -1;
        k = 0;
        break;
        if ((i == 41) || (i == 44)) {
          break label168;
        }
        if (i != 45) {
          break label326;
        }
        break label168;
        if (k <= 0) {
          break label311;
        }
        if (k >= 20480) {
          break label244;
        }
        i = 1;
        break label196;
        if (k <= 0) {
          break label371;
        }
        if (k < 1048576)
        {
          i = 8;
          break label360;
        }
        if (k < 2097152)
        {
          i = 9;
          break label360;
        }
        if (k < 3145728)
        {
          i = 10;
          break label360;
        }
        if (k < 4194304)
        {
          i = 11;
          break label360;
        }
        if (k < 5242880)
        {
          i = 12;
          break label360;
        }
        if (k < 10485760)
        {
          i = 13;
          break label360;
        }
        i = 14;
        break label360;
        if (k <= 0) {
          break label431;
        }
        if (k < 3145728)
        {
          i = 15;
          break label420;
        }
        if (k < 5242880)
        {
          i = 16;
          break label420;
        }
        if (k < 10485760)
        {
          i = 17;
          break label420;
        }
        i = 18;
        break label420;
        if (bool1) {
          break label478;
        }
        if (!bool2) {
          break label232;
        }
        break label478;
      }
      label697:
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b
 * JD-Core Version:    0.7.0.1
 */