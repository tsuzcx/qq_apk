package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IX5WebSettings$PluginState
{
  static
  {
    AppMethodBeat.i(53209);
    ON = new PluginState("ON", 0);
    ON_DEMAND = new PluginState("ON_DEMAND", 1);
    OFF = new PluginState("OFF", 2);
    $VALUES = new PluginState[] { ON, ON_DEMAND, OFF };
    AppMethodBeat.o(53209);
  }
  
  private IX5WebSettings$PluginState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState
 * JD-Core Version:    0.7.0.1
 */