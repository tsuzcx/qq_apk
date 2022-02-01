package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer a;
  
  public h(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.a = paramCustomLayer;
  }
  
  public void clearDiskCache()
  {
    AppMethodBeat.i(186293);
    if (this.a == null)
    {
      AppMethodBeat.o(186293);
      return;
    }
    this.a.clearDiskCache();
    AppMethodBeat.o(186293);
  }
  
  public String getId()
  {
    AppMethodBeat.i(186294);
    if (this.a == null)
    {
      AppMethodBeat.o(186294);
      return null;
    }
    String str = this.a.getId();
    AppMethodBeat.o(186294);
    return str;
  }
  
  public void reload()
  {
    AppMethodBeat.i(186291);
    if (this.a == null)
    {
      AppMethodBeat.o(186291);
      return;
    }
    this.a.reload();
    AppMethodBeat.o(186291);
  }
  
  public void remove()
  {
    AppMethodBeat.i(186292);
    if (this.a == null)
    {
      AppMethodBeat.o(186292);
      return;
    }
    this.a.remove();
    AppMethodBeat.o(186292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.h
 * JD-Core Version:    0.7.0.1
 */