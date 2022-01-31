package com.tencent.ttpic.cache;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import java.util.Iterator;
import java.util.List;

public class Load3DTextureTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private String dataPath;
  private List<String> resourceList;
  
  public Load3DTextureTask(String paramString, List<String> paramList)
  {
    this.dataPath = paramString;
    this.resourceList = paramList;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(81776);
    if (this.resourceList != null)
    {
      paramVarArgs = this.resourceList.iterator();
      while (paramVarArgs.hasNext())
      {
        String str = (String)paramVarArgs.next();
        GamePlaySDK.getInstance().loadItemImage(this.dataPath, str, true);
      }
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(81776);
    return paramVarArgs;
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    AppMethodBeat.i(81777);
    super.onCancelled(paramBoolean);
    AppMethodBeat.o(81777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.cache.Load3DTextureTask
 * JD-Core Version:    0.7.0.1
 */