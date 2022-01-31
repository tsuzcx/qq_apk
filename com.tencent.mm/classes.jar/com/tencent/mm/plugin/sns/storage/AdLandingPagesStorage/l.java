package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private int bgColor;
  private Context context;
  private ViewGroup pMO;
  private List<t> rCJ;
  private LinkedHashMap<String, h> rzc;
  
  public l(List<t> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.rCJ = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.pMO = paramViewGroup;
  }
  
  public final Collection<h> crG()
  {
    AppMethodBeat.i(37787);
    if (this.rzc == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(37787);
      return localObject;
    }
    Object localObject = this.rzc.values();
    AppMethodBeat.o(37787);
    return localObject;
  }
  
  public final void dg(List<t> paramList)
  {
    AppMethodBeat.i(37785);
    if ((paramList != null) && (!paramList.equals(this.rCJ)))
    {
      this.rCJ = paramList;
      layout();
    }
    AppMethodBeat.o(37785);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(37786);
    if ((this.rCJ == null) || (this.rCJ.isEmpty()))
    {
      AppMethodBeat.o(37786);
      return;
    }
    if (this.rzc == null) {
      this.rzc = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.rCJ.size())
      {
        t localt = (t)this.rCJ.get(i);
        Object localObject = (h)this.rzc.get(localt.rsI);
        if (localObject != null) {
          ((h)localObject).a(localt);
        }
        try
        {
          label104:
          if (this.pMO != ((h)localObject).getView().getParent())
          {
            if (this.pMO.getChildCount() <= i) {
              break label195;
            }
            this.pMO.addView(((h)localObject).getView(), i);
            ((h)localObject).cqZ();
          }
          for (;;)
          {
            i += 1;
            break;
            h localh = al.a(this.context, localt, this.pMO, this.bgColor);
            localObject = localh;
            if (localh == null) {
              break label104;
            }
            this.rzc.put(localt.rsI, localh);
            localObject = localh;
            break label104;
            label195:
            this.pMO.addView(((h)localObject).getView());
            ((h)localObject).cqZ();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("CompRenderer", "component may have same id %s,%s", new Object[] { localt.rsI, bo.l(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(37786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */