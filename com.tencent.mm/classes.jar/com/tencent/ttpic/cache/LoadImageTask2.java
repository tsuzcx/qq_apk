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

public class LoadImageTask2
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public LoadImageTask2(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(81796);
    this.cache = paramMap;
    this.resourceList = paramList;
    if (this.resourceList == null) {
      this.resourceList = new ArrayList();
    }
    this.dataPath = paramString1;
    this.materialId = paramString2;
    this.sampleSize = paramInt;
    AppMethodBeat.o(81796);
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(81797);
    if (this.cache == null)
    {
      paramVarArgs = Boolean.FALSE;
      AppMethodBeat.o(81797);
      return paramVarArgs;
    }
    Iterator localIterator = this.resourceList.iterator();
    label184:
    while (localIterator.hasNext())
    {
      paramVarArgs = (String)localIterator.next();
      if (isCancelled())
      {
        paramVarArgs = Boolean.FALSE;
        AppMethodBeat.o(81797);
        return paramVarArgs;
      }
      Object localObject = this.dataPath + File.separator + paramVarArgs;
      localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, this.sampleSize);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if ((!BitmapUtils.isLegal((Bitmap)localObject)) || (this.cache.containsKey(paramVarArgs))) {
          break label184;
        }
        this.cache.put(paramVarArgs, localObject);
        break;
        paramVarArgs = this.materialId + File.separator + paramVarArgs;
      }
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(81797);
    return paramVarArgs;
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    AppMethodBeat.i(81798);
    super.onCancelled(paramBoolean);
    if (this.cache == null)
    {
      AppMethodBeat.o(81798);
      return;
    }
    Iterator localIterator = this.resourceList.iterator();
    label118:
    while (localIterator.hasNext())
    {
      paramBoolean = (String)localIterator.next();
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if (!this.cache.containsKey(paramBoolean)) {
          break label118;
        }
        this.cache.remove(paramBoolean);
        break;
        paramBoolean = this.materialId + File.separator + paramBoolean;
      }
    }
    AppMethodBeat.o(81798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask2
 * JD-Core Version:    0.7.0.1
 */