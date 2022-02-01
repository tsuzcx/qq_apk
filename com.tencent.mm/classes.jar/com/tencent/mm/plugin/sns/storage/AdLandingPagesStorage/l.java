package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private LinkedHashMap<String, m> Kvo;
  private List<aa> Kzd;
  private int bgColor;
  private Context context;
  private ViewGroup ybY;
  
  public l(List<aa> paramList, Context paramContext, ViewGroup paramViewGroup)
  {
    this.Kzd = paramList;
    this.context = paramContext;
    this.bgColor = 0;
    this.ybY = paramViewGroup;
  }
  
  public final void fP()
  {
    AppMethodBeat.i(97395);
    if ((this.Kzd == null) || (this.Kzd.isEmpty()))
    {
      AppMethodBeat.o(97395);
      return;
    }
    if (this.Kvo == null) {
      this.Kvo = new LinkedHashMap();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.Kzd.size())
      {
        aa localaa = (aa)this.Kzd.get(i);
        Object localObject = (m)this.Kvo.get(localaa.KmB);
        if (localObject != null) {
          ((m)localObject).c(localaa);
        }
        try
        {
          label104:
          if (this.ybY != ((m)localObject).getView().getParent())
          {
            if (this.ybY.getChildCount() <= i) {
              break label195;
            }
            this.ybY.addView(((m)localObject).getView(), i);
            ((m)localObject).fRm();
          }
          for (;;)
          {
            i += 1;
            break;
            m localm = ba.a(this.context, localaa, this.ybY, this.bgColor);
            localObject = localm;
            if (localm == null) {
              break label104;
            }
            this.Kvo.put(localaa.KmB, localm);
            localObject = localm;
            break label104;
            label195:
            this.ybY.addView(((m)localObject).getView());
            ((m)localObject).fRm();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("CompRenderer", "component may have same id %s,%s", new Object[] { localaa.KmB, Util.stackTraceToString(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(97395);
  }
  
  public final Collection<m> fRQ()
  {
    AppMethodBeat.i(97396);
    if (this.Kvo == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97396);
      return localObject;
    }
    Object localObject = this.Kvo.values();
    AppMethodBeat.o(97396);
    return localObject;
  }
  
  public final void notify(List<aa> paramList)
  {
    AppMethodBeat.i(97394);
    if ((paramList != null) && (!paramList.equals(this.Kzd)))
    {
      this.Kzd = paramList;
      fP();
    }
    AppMethodBeat.o(97394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */