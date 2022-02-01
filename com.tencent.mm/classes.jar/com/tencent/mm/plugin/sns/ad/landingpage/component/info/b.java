package com.tencent.mm.plugin.sns.ad.landingpage.component.info;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.d.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends aa
{
  @p(hkF=7)
  public d.e PMi;
  @p(hkF=7)
  public d.a PMk;
  public b.a PRQ;
  public List<aa> aAO;
  
  public b()
  {
    AppMethodBeat.i(310645);
    this.aAO = new ArrayList();
    AppMethodBeat.o(310645);
  }
  
  public final List<aa> haE()
  {
    return this.aAO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.info.b
 * JD-Core Version:    0.7.0.1
 */