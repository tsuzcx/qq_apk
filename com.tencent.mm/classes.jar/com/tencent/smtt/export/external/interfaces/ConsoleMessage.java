package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ConsoleMessage
{
  public abstract int lineNumber();
  
  public abstract String message();
  
  public abstract MessageLevel messageLevel();
  
  public abstract String sourceId();
  
  public static enum MessageLevel
  {
    static
    {
      AppMethodBeat.i(53203);
      TIP = new MessageLevel("TIP", 0);
      LOG = new MessageLevel("LOG", 1);
      WARNING = new MessageLevel("WARNING", 2);
      ERROR = new MessageLevel("ERROR", 3);
      DEBUG = new MessageLevel("DEBUG", 4);
      $VALUES = new MessageLevel[] { TIP, LOG, WARNING, ERROR, DEBUG };
      AppMethodBeat.o(53203);
    }
    
    private MessageLevel() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.ConsoleMessage
 * JD-Core Version:    0.7.0.1
 */