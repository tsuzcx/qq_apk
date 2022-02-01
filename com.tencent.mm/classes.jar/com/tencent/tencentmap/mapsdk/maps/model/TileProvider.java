package com.tencent.tencentmap.mapsdk.maps.model;

public abstract interface TileProvider
{
  public static final Tile NO_TILE = Tile.EMPTY_TILE;
  
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileProvider
 * JD-Core Version:    0.7.0.1
 */