package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class DeviceUtils$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    AppMethodBeat.i(49868);
    if (Pattern.matches("cpu[0-9]", paramFile.getName()))
    {
      AppMethodBeat.o(49868);
      return true;
    }
    AppMethodBeat.o(49868);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUtils.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */