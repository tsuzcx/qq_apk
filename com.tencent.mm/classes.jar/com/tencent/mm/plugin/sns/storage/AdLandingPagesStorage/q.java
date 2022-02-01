package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class q
{
  public ViewGroup CAj;
  public LinkedHashMap<String, n> QTY;
  private List<aa> QXV;
  private int bgColor;
  private Context context;
  
  public q(List<aa> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.QXV = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.CAj = paramViewGroup;
  }
  
  public final void CY()
  {
    AppMethodBeat.i(97395);
    if ((this.QXV == null) || (this.QXV.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.QTY == null) {
      this.QTY = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.QXV.size())
      {
        aa localaa = (aa)this.QXV.get(i);
        Object localObject = (n)this.QTY.get(localaa.QKG);
        if (localObject != null) {
          ((n)localObject).c(localaa);
        }
        try
        {
          label104:
          if (this.CAj != ((n)localObject).getView().getParent())
          {
            if (this.CAj.getChildCount() <= i) {
              break label195;
            }
            this.CAj.addView(((n)localObject).getView(), i);
            ((n)localObject).haC();
          }
          for (;;)
          {
            i += 1;
            break;
            n localn = bb.a(this.context, localaa, this.CAj, this.bgColor);
            localObject = localn;
            if (localn == null) {
              break label104;
            }
            this.QTY.put(localaa.QKG, localn);
            localObject = localn;
            break label104;
            label195:
            this.CAj.addView(((n)localObject).getView());
            ((n)localObject).haC();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("CompRenderer", "component may have same id %s,%s", new Object[] { localaa.QKG, Util.stackTraceToString(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
  
  public final Collection<n> hjV()
  {
    AppMethodBeat.i(97396);
    if (this.QTY == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.QTY.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void notify(List<aa> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.QXV)))
    {
      this.QXV = paramList;
      CY();
    }
    AppMethodBeat.o(97394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.q
 * JD-Core Version:    0.7.0.1
 */