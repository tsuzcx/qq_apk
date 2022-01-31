package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends LinkedHashMap<Spannable, Float>
{
  public long duration;
  public b rtv;
  public Interpolator rtw;
  private String rtx;
  
  public a()
  {
    AppMethodBeat.i(36954);
    this.rtv = new b();
    this.rtw = null;
    this.duration = 0L;
    this.rtx = "";
    AppMethodBeat.o(36954);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(36955);
    this.rtv = new b();
    this.rtw = null;
    this.duration = 0L;
    this.rtx = "";
    this.rtv = paramb;
    AppMethodBeat.o(36955);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(36956);
    if (size() != parama.size())
    {
      AppMethodBeat.o(36956);
      return false;
    }
    parama = parama.entrySet().iterator();
    while (parama.hasNext()) {
      if (!containsKey(((Map.Entry)parama.next()).getKey()))
      {
        AppMethodBeat.o(36956);
        return false;
      }
    }
    AppMethodBeat.o(36956);
    return true;
  }
  
  public final Spannable[] cqI()
  {
    AppMethodBeat.i(36957);
    Object localObject = new ArrayList();
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((Map.Entry)localIterator.next()).getKey());
    }
    localObject = (Spannable[])((ArrayList)localObject).toArray(new Spannable[((ArrayList)localObject).size()]);
    AppMethodBeat.o(36957);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a
 * JD-Core Version:    0.7.0.1
 */