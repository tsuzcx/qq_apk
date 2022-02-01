package com.tencent.tbs.one.optional;

import android.content.Context;
import android.view.View;
import com.tencent.tbs.one.TBSOneCallback;
import java.util.Map;

public abstract class TBSOneDebugPlugin
{
  public View createDebuggingView(Context paramContext, String paramString)
  {
    return null;
  }
  
  public void executeCommand(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, TBSOneCallback<Void> paramTBSOneCallback)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneDebugPlugin
 * JD-Core Version:    0.7.0.1
 */