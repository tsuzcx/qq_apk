package com.tencent.tav.extractor;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExtractorDelegateFactory
{
  private static IExtractorDelegateCreator extractorDelegateCreator;
  
  static
  {
    AppMethodBeat.i(215016);
    extractorDelegateCreator = new IExtractorDelegateCreator()
    {
      public final IExtractorDelegate createExtractorDelegate()
      {
        AppMethodBeat.i(215063);
        ApiExtractorDelegate localApiExtractorDelegate = new ApiExtractorDelegate();
        AppMethodBeat.o(215063);
        return localApiExtractorDelegate;
      }
    };
    AppMethodBeat.o(215016);
  }
  
  public static IExtractorDelegate createDelegate()
  {
    AppMethodBeat.i(215008);
    IExtractorDelegate localIExtractorDelegate = extractorDelegateCreator.createExtractorDelegate();
    AppMethodBeat.o(215008);
    return localIExtractorDelegate;
  }
  
  public static void setExtractorDelegateCreator(IExtractorDelegateCreator paramIExtractorDelegateCreator)
  {
    extractorDelegateCreator = paramIExtractorDelegateCreator;
  }
  
  public static abstract interface IExtractorDelegateCreator
  {
    public abstract IExtractorDelegate createExtractorDelegate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorDelegateFactory
 * JD-Core Version:    0.7.0.1
 */