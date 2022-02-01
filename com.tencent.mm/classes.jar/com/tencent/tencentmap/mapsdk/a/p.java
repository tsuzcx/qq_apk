package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay a;
  
  public p(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.a = paramTileOverlay;
  }
  
  public void clearTileCache()
  {
    AppMethodBeat.i(186182);
    if (this.a == null)
    {
      AppMethodBeat.o(186182);
      return;
    }
    this.a.clearTileCache();
    AppMethodBeat.o(186182);
  }
  
  public String getId()
  {
    AppMethodBeat.i(186183);
    if (this.a == null)
    {
      AppMethodBeat.o(186183);
      return null;
    }
    String str = this.a.getId();
    AppMethodBeat.o(186183);
    return str;
  }
  
  public void reload()
  {
    AppMethodBeat.i(186178);
    if (this.a == null)
    {
      AppMethodBeat.o(186178);
      return;
    }
    this.a.reload();
    AppMethodBeat.o(186178);
  }
  
  public void remove()
  {
    AppMethodBeat.i(186179);
    if (this.a == null)
    {
      AppMethodBeat.o(186179);
      return;
    }
    this.a.remove();
    AppMethodBeat.o(186179);
  }
  
  public void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(186180);
    if (this.a == null)
    {
      AppMethodBeat.o(186180);
      return;
    }
    this.a.setDiskCacheDir(paramString);
    AppMethodBeat.o(186180);
  }
  
  public void setZindex(int paramInt)
  {
    AppMethodBeat.i(186181);
    if (this.a == null)
    {
      AppMethodBeat.o(186181);
      return;
    }
    this.a.setZindex(paramInt);
    AppMethodBeat.o(186181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.p
 * JD-Core Version:    0.7.0.1
 */