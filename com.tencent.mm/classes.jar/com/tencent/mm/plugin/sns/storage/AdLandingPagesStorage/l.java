package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private int bgColor;
  private Context context;
  private ViewGroup vXQ;
  private LinkedHashMap<String, k> yrz;
  private List<x> yvd;
  
  public l(List<x> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.yvd = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.vXQ = paramViewGroup;
  }
  
  public final Collection<k> dLn()
  {
    AppMethodBeat.i(97396);
    if (this.yrz == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.yrz.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void fE(List<x> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.yvd)))
    {
      this.yvd = paramList;
      layout();
    }
    AppMethodBeat.o(97394);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(97395);
    if ((this.yvd == null) || (this.yvd.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.yrz == null) {
      this.yrz = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.yvd.size())
      {
        x localx = (x)this.yvd.get(i);
        Object localObject = (k)this.yrz.get(localx.yjs);
        if (localObject != null) {
          ((k)localObject).a(localx);
        }
        try
        {
          label104:
          if (this.vXQ != ((k)localObject).getView().getParent())
          {
            if (this.vXQ.getChildCount() <= i) {
              break label195;
            }
            this.vXQ.addView(((k)localObject).getView(), i);
            ((k)localObject).dKE();
          }
          for (;;)
          {
            i += 1;
            break;
            k localk = as.a(this.context, localx, this.vXQ, this.bgColor);
            localObject = localk;
            if (localk == null) {
              break label104;
            }
            this.yrz.put(localx.yjs, localk);
            localObject = localk;
            break label104;
            label195:
            this.vXQ.addView(((k)localObject).getView());
            ((k)localObject).dKE();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("CompRenderer", "component may have same id %s,%s", new Object[] { localx.yjs, bs.m(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */