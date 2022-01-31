package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DeviceInstance$SOC_CLASS
{
  public int score;
  public int value;
  
  static
  {
    AppMethodBeat.i(49842);
    NULL = new SOC_CLASS("NULL", 0, -1, -1);
    HIGH = new SOC_CLASS("HIGH", 1, 0, 4000);
    NORMAL = new SOC_CLASS("NORMAL", 2, 1, 3000);
    LOW = new SOC_CLASS("LOW", 3, 2, 1000);
    V_LOW = new SOC_CLASS("V_LOW", 4, 3, 0);
    $VALUES = new SOC_CLASS[] { NULL, HIGH, NORMAL, LOW, V_LOW };
    AppMethodBeat.o(49842);
  }
  
  private DeviceInstance$SOC_CLASS(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
    this.score = paramInt2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(49841);
    String str = "SOC_CLASS{value=" + this.value + ", score=" + this.score + '}';
    AppMethodBeat.o(49841);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceInstance.SOC_CLASS
 * JD-Core Version:    0.7.0.1
 */