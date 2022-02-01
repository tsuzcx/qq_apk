package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private LinkedHashMap<String, m> Eih;
  private List<z> ElV;
  private int bgColor;
  private Context context;
  private ViewGroup ulG;
  
  public l(List<z> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.ElV = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.ulG = paramViewGroup;
  }
  
  public final Collection<m> fdY()
  {
    AppMethodBeat.i(97396);
    if (this.Eih == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.Eih.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void gV(List<z> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.ElV)))
    {
      this.ElV = paramList;
      layout();
    }
    AppMethodBeat.o(97394);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(97395);
    if ((this.ElV == null) || (this.ElV.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.Eih == null) {
      this.Eih = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.ElV.size())
      {
        z localz = (z)this.ElV.get(i);
        Object localObject = (m)this.Eih.get(localz.DZi);
        if (localObject != null) {
          ((m)localObject).b(localz);
        }
        try
        {
          label104:
          if (this.ulG != ((m)localObject).getView().getParent())
          {
            if (this.ulG.getChildCount() <= i) {
              break label195;
            }
            this.ulG.addView(((m)localObject).getView(), i);
            ((m)localObject).fdp();
          }
          for (;;)
          {
            i += 1;
            break;
            m localm = ay.a(this.context, localz, this.ulG, this.bgColor);
            localObject = localm;
            if (localm == null) {
              break label104;
            }
            this.Eih.put(localz.DZi, localm);
            localObject = localm;
            break label104;
            label195:
            this.ulG.addView(((m)localObject).getView());
            ((m)localObject).fdp();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("CompRenderer", "component may have same id %s,%s", new Object[] { localz.DZi, Util.stackTraceToString(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */