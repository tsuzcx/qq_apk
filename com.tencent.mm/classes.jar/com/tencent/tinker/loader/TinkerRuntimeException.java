package com.tencent.tinker.loader;

public class TinkerRuntimeException
  extends RuntimeException
{
  private static final String TINKER_RUNTIME_EXCEPTION_PREFIX = "Tinker Exception:";
  private static final long serialVersionUID = 1L;
  
  public TinkerRuntimeException(String paramString)
  {
    super("Tinker Exception:".concat(String.valueOf(paramString)));
  }
  
  public TinkerRuntimeException(String paramString, Throwable paramThrowable)
  {
    super("Tinker Exception:".concat(String.valueOf(paramString)), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerRuntimeException
 * JD-Core Version:    0.7.0.1
 */