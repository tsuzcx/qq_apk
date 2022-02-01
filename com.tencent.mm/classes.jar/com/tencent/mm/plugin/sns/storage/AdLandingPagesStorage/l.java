package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private List<y> Ady;
  private int bgColor;
  private Context context;
  private ViewGroup xvw;
  private LinkedHashMap<String, m> zZQ;
  
  public l(List<y> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.Ady = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.xvw = paramViewGroup;
  }
  
  public final Collection<m> ebh()
  {
    AppMethodBeat.i(97396);
    if (this.zZQ == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.zZQ.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void fY(List<y> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.Ady)))
    {
      this.Ady = paramList;
      layout();
    }
    AppMethodBeat.o(97394);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(97395);
    if ((this.Ady == null) || (this.Ady.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.zZQ == null) {
      this.zZQ = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.Ady.size())
      {
        y localy = (y)this.Ady.get(i);
        Object localObject = (m)this.zZQ.get(localy.zRg);
        if (localObject != null) {
          ((m)localObject).a(localy);
        }
        try
        {
          label104:
          if (this.xvw != ((m)localObject).getView().getParent())
          {
            if (this.xvw.getChildCount() <= i) {
              break label195;
            }
            this.xvw.addView(((m)localObject).getView(), i);
            ((m)localObject).eaA();
          }
          for (;;)
          {
            i += 1;
            break;
            m localm = av.a(this.context, localy, this.xvw, this.bgColor);
            localObject = localm;
            if (localm == null) {
              break label104;
            }
            this.zZQ.put(localy.zRg, localm);
            localObject = localm;
            break label104;
            label195:
            this.xvw.addView(((m)localObject).getView());
            ((m)localObject).eaA();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("CompRenderer", "component may have same id %s,%s", new Object[] { localy.zRg, bu.o(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */