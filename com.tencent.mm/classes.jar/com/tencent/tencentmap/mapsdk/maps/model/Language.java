package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Language
  implements ILanguage
{
  static
  {
    AppMethodBeat.i(173144);
    zh = new Language("zh", 0);
    en = new Language("en", 1);
    $VALUES = new Language[] { zh, en };
    AppMethodBeat.o(173144);
  }
  
  private Language() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Language
 * JD-Core Version:    0.7.0.1
 */