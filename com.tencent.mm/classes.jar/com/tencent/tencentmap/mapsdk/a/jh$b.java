package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class jh$b
{
  private List<MapLanguageChangeListener> b = new CopyOnWriteArrayList();
  
  public jh$b(jh paramjh) {}
  
  public MapLanguage a()
  {
    if (jh.a(this.a) == null) {
      return MapLanguage.LAN_CHINESE;
    }
    if (jh.a(this.a).D() == 1) {
      return MapLanguage.LAN_ENGLISH;
    }
    return MapLanguage.LAN_CHINESE;
  }
  
  public void a(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    if (paramMapLanguageChangeListener == null) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramMapLanguageChangeListener)) {
        this.b.add(paramMapLanguageChangeListener);
      }
      return;
    }
  }
  
  public void b(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    if (paramMapLanguageChangeListener == null) {
      return;
    }
    synchronized (this.b)
    {
      if (this.b.contains(paramMapLanguageChangeListener)) {
        this.b.remove(paramMapLanguageChangeListener);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jh.b
 * JD-Core Version:    0.7.0.1
 */