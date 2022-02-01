package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetManager.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetErrorException;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int mHeight;
  private final int mWidth;
  
  public UrlTileProvider()
  {
    this(256, 256);
  }
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    Object localObject1 = getTileUrl(paramInt1, paramInt2, paramInt3);
    Tile localTile = NO_TILE;
    if (localObject1 == null) {}
    NetResponse localNetResponse;
    do
    {
      while ((localObject1 == null) || (localObject1.length == 0))
      {
        return localTile;
        localNetResponse = requestTileData(((URL)localObject1).toString());
        localObject1 = localObject2;
        if (localNetResponse != null)
        {
          if (!localNetResponse.available()) {
            break;
          }
          localObject1 = localNetResponse.data;
        }
      }
      return new Tile(this.mWidth, this.mHeight, (byte[])localObject1);
      localObject1 = localObject2;
    } while (!(localNetResponse.exception instanceof NetErrorException));
    if (localNetResponse.statusCode == 404) {
      return NO_TILE;
    }
    return new Tile(this.mWidth, this.mHeight, null);
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  protected NetResponse requestTileData(String paramString)
  {
    try
    {
      paramString = NetManager.getInstance().builder().url(paramString).doGet();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */