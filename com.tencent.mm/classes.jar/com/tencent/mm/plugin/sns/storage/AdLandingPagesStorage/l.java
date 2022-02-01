package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.as;
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
  private ViewGroup uPa;
  private LinkedHashMap<String, k> xeK;
  private List<x> xip;
  
  public l(List<x> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.xip = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.uPa = paramViewGroup;
  }
  
  public final Collection<k> dwO()
  {
    AppMethodBeat.i(97396);
    if (this.xeK == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.xeK.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void fw(List<x> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.xip)))
    {
      this.xip = paramList;
      layout();
    }
    AppMethodBeat.o(97394);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(97395);
    if ((this.xip == null) || (this.xip.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.xeK == null) {
      this.xeK = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.xip.size())
      {
        x localx = (x)this.xip.get(i);
        Object localObject = (k)this.xeK.get(localx.wWE);
        if (localObject != null) {
          ((k)localObject).a(localx);
        }
        try
        {
          label104:
          if (this.uPa != ((k)localObject).getView().getParent())
          {
            if (this.uPa.getChildCount() <= i) {
              break label195;
            }
            this.uPa.addView(((k)localObject).getView(), i);
            ((k)localObject).dwf();
          }
          for (;;)
          {
            i += 1;
            break;
            k localk = as.a(this.context, localx, this.uPa, this.bgColor);
            localObject = localk;
            if (localk == null) {
              break label104;
            }
            this.xeK.put(localx.wWE, localk);
            localObject = localk;
            break label104;
            label195:
            this.uPa.addView(((k)localObject).getView());
            ((k)localObject).dwf();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("CompRenderer", "component may have same id %s,%s", new Object[] { localx.wWE, bt.m(localException) });
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