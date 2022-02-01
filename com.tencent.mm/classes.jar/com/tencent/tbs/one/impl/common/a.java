package com.tencent.tbs.one.impl.common;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;

public final class a
{
  public static TBSOneRuntimeExtension a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174191);
    TBSOneManager localTBSOneManager = TBSOneManager.getInstance(paramContext, paramString);
    paramString = localTBSOneManager.getLoadedComponent("extension");
    paramContext = paramString;
    if (paramString == null) {}
    try
    {
      paramContext = localTBSOneManager.loadComponentSync("extension");
      if (!(paramContext.getEntryObject() instanceof TBSOneRuntimeExtension))
      {
        paramContext = new TBSOneException(504, "Failed to cast the entry object of runtime extension");
        AppMethodBeat.o(174191);
        throw paramContext;
      }
    }
    catch (TBSOneException paramContext)
    {
      paramContext = new TBSOneException(503, "Failed to load runtime extension, caused by: [" + paramContext.getErrorCode() + "] " + paramContext.getMessage(), paramContext.getCause());
      AppMethodBeat.o(174191);
      throw paramContext;
    }
    paramContext = (TBSOneRuntimeExtension)paramContext.getEntryObject();
    AppMethodBeat.o(174191);
    return paramContext;
  }
  
  public static void a(Context paramContext, TBSOneCallback<TBSOneDebugPlugin> paramTBSOneCallback)
  {
    AppMethodBeat.i(174193);
    TBSOneManager.getInstance(paramContext, "debug").loadComponentAsync("debugger", new TBSOneCallback() {});
    AppMethodBeat.o(174193);
  }
  
  public static TBSOneRuntimeExtension b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174192);
    paramContext = TBSOneManager.getInstance(paramContext, paramString).getLoadedComponent("extension");
    if ((paramContext != null) && ((paramContext.getEntryObject() instanceof TBSOneRuntimeExtension)))
    {
      paramContext = (TBSOneRuntimeExtension)paramContext.getEntryObject();
      AppMethodBeat.o(174192);
      return paramContext;
    }
    AppMethodBeat.o(174192);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.a
 * JD-Core Version:    0.7.0.1
 */