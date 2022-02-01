package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentChildProcessService
  extends ChildProcessService
{
  public ContentChildProcessService()
  {
    super(new SandboxContentChildProcessServiceDelegate());
    AppMethodBeat.i(53815);
    AppMethodBeat.o(53815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ContentChildProcessService
 * JD-Core Version:    0.7.0.1
 */