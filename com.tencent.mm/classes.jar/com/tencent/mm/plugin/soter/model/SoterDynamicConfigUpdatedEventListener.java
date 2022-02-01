package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.sdk.event.IListener;

public class SoterDynamicConfigUpdatedEventListener
  extends IListener<du>
{
  private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";
  
  public SoterDynamicConfigUpdatedEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161756);
    this.__eventId = du.class.getName().hashCode();
    AppMethodBeat.o(161756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.SoterDynamicConfigUpdatedEventListener
 * JD-Core Version:    0.7.0.1
 */