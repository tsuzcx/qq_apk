package com.tencent.ttpic.cache;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.List;

public class LoadImageTask3D
  extends AsyncTask<Void, Integer, Boolean>
{
  private String dataPath;
  private List<String> resourceList;
  
  public LoadImageTask3D(String paramString, List<String> paramList)
  {
    this.dataPath = paramString;
    this.resourceList = paramList;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    if (this.resourceList != null)
    {
      paramVarArgs = this.resourceList.iterator();
      while (paramVarArgs.hasNext()) {
        paramVarArgs.next();
      }
    }
    return Boolean.valueOf(true);
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    super.onCancelled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask3D
 * JD-Core Version:    0.7.0.1
 */