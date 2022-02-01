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
  public b zSh;
  public Interpolator zSi;
  private String zSj;
  
  public a()
  {
    AppMethodBeat.i(96334);
    this.zSh = new b();
    this.zSi = null;
    this.duration = 0L;
    this.zSj = "";
    AppMethodBeat.o(96334);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(96335);
    this.zSh = new b();
    this.zSi = null;
    this.duration = 0L;
    this.zSj = "";
    this.zSh = paramb;
    AppMethodBeat.o(96335);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(96336);
    if (size() != parama.size())
    {
      AppMethodBeat.o(96336);
      return false;
    }
    parama = parama.entrySet().iterator();
    while (parama.hasNext()) {
      if (!containsKey(((Map.Entry)parama.next()).getKey()))
      {
        AppMethodBeat.o(96336);
        return false;
      }
    }
    AppMethodBeat.o(96336);
    return true;
  }
  
  public final Spannable[] dZW()
  {
    AppMethodBeat.i(96337);
    Object localObject = new ArrayList();
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((Map.Entry)localIterator.next()).getKey());
    }
    localObject = (Spannable[])((ArrayList)localObject).toArray(new Spannable[((ArrayList)localObject).size()]);
    AppMethodBeat.o(96337);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a
 * JD-Core Version:    0.7.0.1
 */