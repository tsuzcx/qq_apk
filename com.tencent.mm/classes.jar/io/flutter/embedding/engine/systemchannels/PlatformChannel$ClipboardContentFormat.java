package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PlatformChannel$ClipboardContentFormat
{
  private String encodedName;
  
  static
  {
    AppMethodBeat.i(10275);
    PLAIN_TEXT = new ClipboardContentFormat("PLAIN_TEXT", 0, "text/plain");
    $VALUES = new ClipboardContentFormat[] { PLAIN_TEXT };
    AppMethodBeat.o(10275);
  }
  
  private PlatformChannel$ClipboardContentFormat(String paramString)
  {
    this.encodedName = paramString;
  }
  
  static ClipboardContentFormat fromValue(String paramString)
  {
    AppMethodBeat.i(10274);
    ClipboardContentFormat[] arrayOfClipboardContentFormat = values();
    int j = arrayOfClipboardContentFormat.length;
    int i = 0;
    while (i < j)
    {
      ClipboardContentFormat localClipboardContentFormat = arrayOfClipboardContentFormat[i];
      if (localClipboardContentFormat.encodedName.equals(paramString))
      {
        AppMethodBeat.o(10274);
        return localClipboardContentFormat;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such ClipboardContentFormat: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10274);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat
 * JD-Core Version:    0.7.0.1
 */