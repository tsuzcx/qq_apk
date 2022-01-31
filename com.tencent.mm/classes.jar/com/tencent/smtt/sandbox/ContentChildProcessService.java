package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentChildProcessService
  extends ChildProcessService
{
  public ContentChildProcessService()
  {
    super(new SandboxContentChildProcessServiceDelegate());
    AppMethodBeat.i(138990);
    AppMethodBeat.o(138990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ContentChildProcessService
 * JD-Core Version:    0.7.0.1
 */