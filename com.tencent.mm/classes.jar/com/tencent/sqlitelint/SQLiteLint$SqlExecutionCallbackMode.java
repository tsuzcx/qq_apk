package com.tencent.sqlitelint;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum SQLiteLint$SqlExecutionCallbackMode
{
  static
  {
    AppMethodBeat.i(52827);
    HOOK = new SqlExecutionCallbackMode("HOOK", 0);
    CUSTOM_NOTIFY = new SqlExecutionCallbackMode("CUSTOM_NOTIFY", 1);
    $VALUES = new SqlExecutionCallbackMode[] { HOOK, CUSTOM_NOTIFY };
    AppMethodBeat.o(52827);
  }
  
  private SQLiteLint$SqlExecutionCallbackMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode
 * JD-Core Version:    0.7.0.1
 */