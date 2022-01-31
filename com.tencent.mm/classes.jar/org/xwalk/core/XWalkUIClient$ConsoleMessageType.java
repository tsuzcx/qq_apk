package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum XWalkUIClient$ConsoleMessageType
{
  static
  {
    AppMethodBeat.i(85850);
    DEBUG = new ConsoleMessageType("DEBUG", 0);
    ERROR = new ConsoleMessageType("ERROR", 1);
    LOG = new ConsoleMessageType("LOG", 2);
    INFO = new ConsoleMessageType("INFO", 3);
    WARNING = new ConsoleMessageType("WARNING", 4);
    $VALUES = new ConsoleMessageType[] { DEBUG, ERROR, LOG, INFO, WARNING };
    AppMethodBeat.o(85850);
  }
  
  private XWalkUIClient$ConsoleMessageType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkUIClient.ConsoleMessageType
 * JD-Core Version:    0.7.0.1
 */