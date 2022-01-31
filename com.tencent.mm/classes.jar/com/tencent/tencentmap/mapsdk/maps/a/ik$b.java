package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ik$b
{
  private List<MapLanguageChangeListener> b;
  
  public ik$b(ik paramik)
  {
    AppMethodBeat.i(148451);
    this.b = new CopyOnWriteArrayList();
    AppMethodBeat.o(148451);
  }
  
  public MapLanguage a()
  {
    AppMethodBeat.i(148452);
    if (ik.a(this.a) == null)
    {
      localMapLanguage = MapLanguage.LAN_CHINESE;
      AppMethodBeat.o(148452);
      return localMapLanguage;
    }
    if (ik.a(this.a).A() == 1)
    {
      localMapLanguage = MapLanguage.LAN_ENGLISH;
      AppMethodBeat.o(148452);
      return localMapLanguage;
    }
    MapLanguage localMapLanguage = MapLanguage.LAN_CHINESE;
    AppMethodBeat.o(148452);
    return localMapLanguage;
  }
  
  public void a(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    AppMethodBeat.i(148453);
    if (paramMapLanguageChangeListener == null)
    {
      AppMethodBeat.o(148453);
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramMapLanguageChangeListener)) {
        this.b.add(paramMapLanguageChangeListener);
      }
      AppMethodBeat.o(148453);
      return;
    }
  }
  
  public void b(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    AppMethodBeat.i(148454);
    if (paramMapLanguageChangeListener == null)
    {
      AppMethodBeat.o(148454);
      return;
    }
    synchronized (this.b)
    {
      if (this.b.contains(paramMapLanguageChangeListener)) {
        this.b.remove(paramMapLanguageChangeListener);
      }
      AppMethodBeat.o(148454);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ik.b
 * JD-Core Version:    0.7.0.1
 */