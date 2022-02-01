package com.tencent.tav.extractor.wrapper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.HashMap;

public class ExtractorWrapperPool
{
  private static final HashMap<String, ExtractorWrapper> extractorHashMap;
  
  static
  {
    AppMethodBeat.i(202078);
    extractorHashMap = new HashMap();
    AppMethodBeat.o(202078);
  }
  
  public static void clear()
  {
    try
    {
      AppMethodBeat.i(202077);
      extractorHashMap.clear();
      AppMethodBeat.o(202077);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean contains(String paramString)
  {
    try
    {
      AppMethodBeat.i(202072);
      boolean bool = extractorHashMap.containsKey(paramString);
      AppMethodBeat.o(202072);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void fillIn(String paramString, AssetExtractor paramAssetExtractor)
  {
    try
    {
      AppMethodBeat.i(202076);
      paramString = get(paramString);
      paramString.checkAndLoad(paramAssetExtractor);
      paramAssetExtractor.setSize(paramString.getVideoSize());
      paramAssetExtractor.setDuration(paramString.getDuration());
      paramAssetExtractor.setPreferRotation(paramString.getPreferRotation());
      AppMethodBeat.o(202076);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static ExtractorWrapper get(String paramString)
  {
    try
    {
      AppMethodBeat.i(202071);
      ExtractorWrapper localExtractorWrapper2 = (ExtractorWrapper)extractorHashMap.get(paramString);
      ExtractorWrapper localExtractorWrapper1 = localExtractorWrapper2;
      if (localExtractorWrapper2 == null) {
        localExtractorWrapper1 = new ExtractorWrapper(paramString);
      }
      extractorHashMap.put(paramString, localExtractorWrapper1);
      AppMethodBeat.o(202071);
      return localExtractorWrapper1;
    }
    finally {}
  }
  
  public static void load(AssetExtractor paramAssetExtractor)
  {
    try
    {
      AppMethodBeat.i(202075);
      get(paramAssetExtractor.getSourcePath()).checkAndLoad(paramAssetExtractor);
      AppMethodBeat.o(202075);
      return;
    }
    finally
    {
      paramAssetExtractor = finally;
      throw paramAssetExtractor;
    }
  }
  
  public static void load(String paramString)
  {
    try
    {
      AppMethodBeat.i(202074);
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(paramString);
      get(paramString).checkAndLoad(localAssetExtractor);
      AppMethodBeat.o(202074);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void put(ExtractorWrapper paramExtractorWrapper)
  {
    try
    {
      AppMethodBeat.i(202073);
      extractorHashMap.put(paramExtractorWrapper.getVideoPath(), paramExtractorWrapper);
      AppMethodBeat.o(202073);
      return;
    }
    finally
    {
      paramExtractorWrapper = finally;
      throw paramExtractorWrapper;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorWrapperPool
 * JD-Core Version:    0.7.0.1
 */