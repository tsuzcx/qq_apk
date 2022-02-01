package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private int bgColor;
  private Context context;
  private ViewGroup xfE;
  private LinkedHashMap<String, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l> zIJ;
  private List<x> zMr;
  
  public l(List<x> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.zMr = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.xfE = paramViewGroup;
  }
  
  public final Collection<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l> dXE()
  {
    AppMethodBeat.i(97396);
    if (this.zIJ == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.zIJ.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void fP(List<x> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.zMr)))
    {
      this.zMr = paramList;
      layout();
    }
    AppMethodBeat.o(97394);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(97395);
    if ((this.zMr == null) || (this.zMr.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.zIJ == null) {
      this.zIJ = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.zMr.size())
      {
        x localx = (x)this.zMr.get(i);
        Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)this.zIJ.get(localx.zAg);
        if (localObject != null) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).a(localx);
        }
        try
        {
          label104:
          if (this.xfE != ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).getView().getParent())
          {
            if (this.xfE.getChildCount() <= i) {
              break label195;
            }
            this.xfE.addView(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).getView(), i);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).dWW();
          }
          for (;;)
          {
            i += 1;
            break;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l locall = av.a(this.context, localx, this.xfE, this.bgColor);
            localObject = locall;
            if (locall == null) {
              break label104;
            }
            this.zIJ.put(localx.zAg, locall);
            localObject = locall;
            break label104;
            label195:
            this.xfE.addView(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).getView());
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localObject).dWW();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("CompRenderer", "component may have same id %s,%s", new Object[] { localx.zAg, bt.n(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */