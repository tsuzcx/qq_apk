package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.Map;

public class LoadGrayImageTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private final FaceOffUtil.FEATURE_TYPE featureType;
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache;
  private final int sampleSize;
  
  public LoadGrayImageTask(Map<FaceOffUtil.FEATURE_TYPE, Bitmap> paramMap, FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE, int paramInt)
  {
    this.mGrayCache = paramMap;
    this.featureType = paramFEATURE_TYPE;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(81791);
    if (isCancelled())
    {
      paramVarArgs = Boolean.FALSE;
      AppMethodBeat.o(81791);
      return paramVarArgs;
    }
    if (this.mGrayCache == null)
    {
      paramVarArgs = Boolean.FALSE;
      AppMethodBeat.o(81791);
      return paramVarArgs;
    }
    if (!this.mGrayCache.containsKey(this.featureType))
    {
      paramVarArgs = FaceOffUtil.getGrayBitmap(this.featureType);
      this.mGrayCache.put(this.featureType, paramVarArgs);
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(81791);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadGrayImageTask
 * JD-Core Version:    0.7.0.1
 */