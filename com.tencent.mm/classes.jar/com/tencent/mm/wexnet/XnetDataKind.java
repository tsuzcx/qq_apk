package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XnetDataKind;", "", "()V", "StorageDataKindFloat32", "", "getStorageDataKindFloat32", "()I", "StorageDataKindInt32", "getStorageDataKindInt32", "StorageDataKindInt8", "getStorageDataKindInt8", "StorageDataKindUInt32", "getStorageDataKindUInt32", "StorageDataKindUInt8", "getStorageDataKindUInt8$annotations", "getStorageDataKindUInt8", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class XnetDataKind
{
  public static final XnetDataKind INSTANCE;
  private static final int StorageDataKindFloat32;
  private static final int StorageDataKindInt32;
  private static final int StorageDataKindInt8;
  private static final int StorageDataKindUInt32;
  private static final int StorageDataKindUInt8;
  
  static
  {
    AppMethodBeat.i(231569);
    INSTANCE = new XnetDataKind();
    StorageDataKindUInt8 = 2;
    StorageDataKindInt8 = 6;
    StorageDataKindUInt32 = 4;
    StorageDataKindInt32 = 8;
    StorageDataKindFloat32 = 11;
    AppMethodBeat.o(231569);
  }
  
  public static final int getStorageDataKindUInt8()
  {
    return StorageDataKindUInt8;
  }
  
  public final int getStorageDataKindFloat32()
  {
    return StorageDataKindFloat32;
  }
  
  public final int getStorageDataKindInt32()
  {
    return StorageDataKindInt32;
  }
  
  public final int getStorageDataKindInt8()
  {
    return StorageDataKindInt8;
  }
  
  public final int getStorageDataKindUInt32()
  {
    return StorageDataKindUInt32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wexnet.XnetDataKind
 * JD-Core Version:    0.7.0.1
 */