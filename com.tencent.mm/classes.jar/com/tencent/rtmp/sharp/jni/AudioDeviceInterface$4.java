package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class AudioDeviceInterface$4
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(13910);
    paramFile = paramFile.getName();
    if (paramFile.startsWith("cpu"))
    {
      int i = 3;
      while (i < paramFile.length())
      {
        if ((paramFile.charAt(i) < '0') || (paramFile.charAt(i) > '9'))
        {
          AppMethodBeat.o(13910);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(13910);
      return true;
    }
    AppMethodBeat.o(13910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface.4
 * JD-Core Version:    0.7.0.1
 */