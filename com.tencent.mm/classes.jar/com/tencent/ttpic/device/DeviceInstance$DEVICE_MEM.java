package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum DeviceInstance$DEVICE_MEM
{
  private final String device;
  private final int sizeInKB;
  
  static
  {
    AppMethodBeat.i(49838);
    GN9010 = new DEVICE_MEM("GN9010", 0, "GN9010", 81920);
    vivo_Y23L = new DEVICE_MEM("vivo_Y23L", 1, "vivo_Y23L", 81920);
    vivo_Y27 = new DEVICE_MEM("vivo_Y27", 2, "vivo_Y27", 81920);
    HUAWEI_PLK = new DEVICE_MEM("HUAWEI_PLK", 3, "HUAWEI_PLK-AL10", 81920);
    $VALUES = new DEVICE_MEM[] { GN9010, vivo_Y23L, vivo_Y27, HUAWEI_PLK };
    AppMethodBeat.o(49838);
  }
  
  private DeviceInstance$DEVICE_MEM(String paramString, int paramInt)
  {
    this.device = paramString;
    this.sizeInKB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceInstance.DEVICE_MEM
 * JD-Core Version:    0.7.0.1
 */