package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class ProcessService
{
  public static ConcurrentHashMap<String, b> EZP;
  
  static
  {
    AppMethodBeat.i(133212);
    EZP = new ConcurrentHashMap();
    AppMethodBeat.o(133212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.ProcessService
 * JD-Core Version:    0.7.0.1
 */