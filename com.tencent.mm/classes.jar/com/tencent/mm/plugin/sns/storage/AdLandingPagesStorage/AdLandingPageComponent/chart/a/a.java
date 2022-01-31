package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends LinkedHashMap<Spannable, Float>
{
  public long duration = 0L;
  public b oDU = new b();
  public Interpolator oDV = null;
  private String oDW = "";
  
  public a() {}
  
  public a(b paramb)
  {
    this.oDU = paramb;
  }
  
  public final boolean a(a parama)
  {
    if (size() != parama.size()) {
      return false;
    }
    parama = parama.entrySet().iterator();
    while (parama.hasNext()) {
      if (!containsKey(((Map.Entry)parama.next()).getKey())) {
        return false;
      }
    }
    return true;
  }
  
  public final Spannable[] bFb()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getKey());
    }
    return (Spannable[])localArrayList.toArray(new Spannable[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a
 * JD-Core Version:    0.7.0.1
 */