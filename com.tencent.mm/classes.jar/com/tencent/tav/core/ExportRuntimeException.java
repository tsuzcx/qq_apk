package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExportRuntimeException
  extends RuntimeException
{
  private final ExportErrorStatus errorStatus;
  
  public ExportRuntimeException(int paramInt, Throwable paramThrowable)
  {
    this(new ExportErrorStatus(paramInt, paramThrowable));
    AppMethodBeat.i(215189);
    AppMethodBeat.o(215189);
  }
  
  public ExportRuntimeException(ExportErrorStatus paramExportErrorStatus)
  {
    super(paramExportErrorStatus.throwable);
    this.errorStatus = paramExportErrorStatus;
  }
  
  public ExportErrorStatus getErrorStatus()
  {
    return this.errorStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.ExportRuntimeException
 * JD-Core Version:    0.7.0.1
 */