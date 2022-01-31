package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TbsLogReport$EventType
{
  int a;
  
  static
  {
    AppMethodBeat.i(64483);
    TYPE_DOWNLOAD = new EventType("TYPE_DOWNLOAD", 0, 0);
    TYPE_INSTALL = new EventType("TYPE_INSTALL", 1, 1);
    TYPE_LOAD = new EventType("TYPE_LOAD", 2, 2);
    TYPE_DOWNLOAD_DECOUPLE = new EventType("TYPE_DOWNLOAD_DECOUPLE", 3, 3);
    TYPE_INSTALL_DECOUPLE = new EventType("TYPE_INSTALL_DECOUPLE", 4, 4);
    TYPE_COOKIE_DB_SWITCH = new EventType("TYPE_COOKIE_DB_SWITCH", 5, 5);
    TYPE_SDK_REPORT_INFO = new EventType("TYPE_SDK_REPORT_INFO", 6, 6);
    b = new EventType[] { TYPE_DOWNLOAD, TYPE_INSTALL, TYPE_LOAD, TYPE_DOWNLOAD_DECOUPLE, TYPE_INSTALL_DECOUPLE, TYPE_COOKIE_DB_SWITCH, TYPE_SDK_REPORT_INFO };
    AppMethodBeat.o(64483);
  }
  
  private TbsLogReport$EventType(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.EventType
 * JD-Core Version:    0.7.0.1
 */