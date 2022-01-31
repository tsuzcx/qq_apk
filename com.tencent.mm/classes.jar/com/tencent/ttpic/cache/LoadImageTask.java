package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadImageTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public LoadImageTask(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(81793);
    this.cache = paramMap;
    this.resourceList = paramList;
    if (this.resourceList == null) {
      this.resourceList = new ArrayList();
    }
    this.dataPath = paramString1;
    this.materialId = paramString2;
    this.sampleSize = paramInt;
    AppMethodBeat.o(81793);
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(81794);
    if (this.cache == null)
    {
      paramVarArgs = Boolean.FALSE;
      AppMethodBeat.o(81794);
      return paramVarArgs;
    }
    Iterator localIterator = this.resourceList.iterator();
    paramVarArgs = null;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isCancelled())
      {
        paramVarArgs = Boolean.FALSE;
        AppMethodBeat.o(81794);
        return paramVarArgs;
      }
      Object localObject = this.dataPath + File.separator + str;
      localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, this.sampleSize);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if (!BitmapUtils.isLegal((Bitmap)localObject)) {
          break label180;
        }
        this.cache.put(str, localObject);
        paramVarArgs = (Void[])localObject;
        break;
        str = this.materialId + File.separator + str;
      }
      label180:
      if (BitmapUtils.isLegal(paramVarArgs)) {
        this.cache.put(str, paramVarArgs);
      }
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(81794);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask
 * JD-Core Version:    0.7.0.1
 */