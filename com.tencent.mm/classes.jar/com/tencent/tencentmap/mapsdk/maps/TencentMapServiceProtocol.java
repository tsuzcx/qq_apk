package com.tencent.tencentmap.mapsdk.maps;

public abstract interface TencentMapServiceProtocol
  extends TencentMapComponent.Component
{
  public static final String SERVICE_NAME_AUTHORIZATION = "authorization";
  public static final String SERVICE_NAME_BLOCK_ROUTE_DATA = "blockroutedata";
  public static final String SERVICE_NAME_INDOOR_DATA = "indoordata";
  public static final String SERVICE_NAME_MAP_DATA = "mapdata";
  public static final String SERVICE_NAME_MAP_POI_DATA = "mappoidata";
  public static final String SERVICE_NAME_MAP_STYLE = "mapstyle";
  public static final String SERVICE_NAME_OFFLINE_MAP_DATA = "offlinemapdata";
  public static final String SERVICE_NAME_OVERSEA_DATA = "overseadata";
  public static final String SERVICE_NAME_RTT_DATA = "rttdata";
  public static final String SERVICE_NAME_SATELLITE_DATA = "satellitedata";
  public static final String SERVICE_NAME_SKETCH_DATA = "sketchdata";
  public static final String SERVICE_NAME_STATISTIC = "statistic";
  public static final String SERVICE_NAME_TRAFFIC_EVENT = "trafficevent";
  
  public abstract IMapService getMapService(String paramString);
  
  public static abstract interface IMapService
  {
    public abstract void setAllow(boolean paramBoolean);
    
    public abstract void setUseHttps(boolean paramBoolean);
    
    public abstract void setUseTest(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol
 * JD-Core Version:    0.7.0.1
 */