package com.tencent.tbs.one;

import android.content.Context;
import android.view.View;
import java.util.Map;

public abstract interface TBSOneDebugger
{
  public abstract View createPanelView(Context paramContext);
  
  public abstract void executeCommand(Context paramContext, String paramString, Map<String, Object> paramMap, TBSOneCallback<Void> paramTBSOneCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneDebugger
 * JD-Core Version:    0.7.0.1
 */