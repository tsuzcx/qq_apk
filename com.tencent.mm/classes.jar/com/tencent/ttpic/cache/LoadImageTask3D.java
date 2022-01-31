package com.tencent.ttpic.cache;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
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
    AppMethodBeat.i(81801);
    if (this.resourceList != null)
    {
      paramVarArgs = this.resourceList.iterator();
      while (paramVarArgs.hasNext())
      {
        String str = (String)paramVarArgs.next();
        GamePlaySDK.getInstance().loadItemImage(this.dataPath, str);
      }
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(81801);
    return paramVarArgs;
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    AppMethodBeat.i(81802);
    super.onCancelled(paramBoolean);
    AppMethodBeat.o(81802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask3D
 * JD-Core Version:    0.7.0.1
 */