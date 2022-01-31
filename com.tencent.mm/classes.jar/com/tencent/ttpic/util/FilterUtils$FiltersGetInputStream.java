package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterUtils$FiltersGetInputStream
  implements FilterRawGet.GetInputStream
{
  public InputStream getInputStream(String paramString)
  {
    AppMethodBeat.i(83911);
    String str = ResourcePathMapper.getFilterResPath(paramString);
    if (str == null) {}
    for (;;)
    {
      try
      {
        paramString = VideoGlobalContext.getContext().getAssets().open("raw" + File.separator + paramString);
        return paramString;
      }
      catch (IOException paramString)
      {
        return null;
      }
      finally
      {
        AppMethodBeat.o(83911);
      }
      if (str.startsWith("assets://"))
      {
        paramString = str.substring(str.lastIndexOf("assets://") + 9);
        paramString = VideoGlobalContext.getContext().getAssets().open(paramString);
      }
      else
      {
        paramString = new FileInputStream(new File(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.FilterUtils.FiltersGetInputStream
 * JD-Core Version:    0.7.0.1
 */