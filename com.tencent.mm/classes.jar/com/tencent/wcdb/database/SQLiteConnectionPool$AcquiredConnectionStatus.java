package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum SQLiteConnectionPool$AcquiredConnectionStatus
{
  static
  {
    AppMethodBeat.i(3043);
    NORMAL = new AcquiredConnectionStatus("NORMAL", 0);
    RECONFIGURE = new AcquiredConnectionStatus("RECONFIGURE", 1);
    DISCARD = new AcquiredConnectionStatus("DISCARD", 2);
    $VALUES = new AcquiredConnectionStatus[] { NORMAL, RECONFIGURE, DISCARD };
    AppMethodBeat.o(3043);
  }
  
  private SQLiteConnectionPool$AcquiredConnectionStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnectionPool.AcquiredConnectionStatus
 * JD-Core Version:    0.7.0.1
 */