package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;
import java.util.Map;

public class TbsOneFileOpenManager
{
  public static TbsOneFileOpenManager tbsOneGreyInfoHelper;
  
  public TbsOneFileOpenManager(Context paramContext)
  {
    AppMethodBeat.i(54337);
    TbsFileInterfaceImpl.initEngine(paramContext);
    AppMethodBeat.o(54337);
  }
  
  public static TbsOneFileOpenManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(54336);
      if (tbsOneGreyInfoHelper == null) {
        tbsOneGreyInfoHelper = new TbsOneFileOpenManager(paramContext);
      }
      paramContext = tbsOneGreyInfoHelper;
      AppMethodBeat.o(54336);
      return paramContext;
    }
    finally {}
  }
  
  void a(Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(54339);
    if (paramMap.containsKey("filePath")) {
      paramBundle.putString("filePath", (String)paramMap.get("filePath"));
    }
    try
    {
      if (paramMap.containsKey("style")) {
        paramBundle.putInt("style", Integer.parseInt((String)paramMap.get("style")));
      }
      try
      {
        label64:
        if (paramMap.containsKey("topBarBgColor")) {
          paramBundle.putInt("topBarBgColor", Integer.parseInt((String)paramMap.get("topBarBgColor")));
        }
        label95:
        if ((paramBundle != null) && (paramMap.containsKey("menuData"))) {
          paramBundle.putString("menuData", (String)paramMap.get("menuData"));
        }
        AppMethodBeat.o(54339);
        return;
      }
      catch (Exception localException1)
      {
        break label95;
      }
    }
    catch (Exception localException2)
    {
      break label64;
    }
  }
  
  public boolean canOpenFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54340);
    TbsFileInterfaceImpl.getInstance();
    boolean bool = TbsFileInterfaceImpl.canOpenFile(paramString);
    AppMethodBeat.o(54340);
    return bool;
  }
  
  public void closeFileReader()
  {
    AppMethodBeat.i(54341);
    TbsFileInterfaceImpl.getInstance().closeFileReader();
    AppMethodBeat.o(54341);
  }
  
  public int openFile(Context paramContext, Bundle paramBundle, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54338);
    paramValueCallback = new ITbsReaderCallback()
    {
      public void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(54321);
        if (paramValueCallback == null)
        {
          AppMethodBeat.o(54321);
          return;
        }
        if (10 == paramAnonymousInteger.intValue()) {
          paramValueCallback.onReceiveValue("plugin success");
        }
        for (;;)
        {
          if (13 == paramAnonymousInteger.intValue()) {
            paramValueCallback.onReceiveValue((String)paramAnonymousObject1);
          }
          AppMethodBeat.o(54321);
          return;
          if (11 == paramAnonymousInteger.intValue()) {
            paramValueCallback.onReceiveValue("plugin failed");
          }
        }
      }
    };
    int i = TbsFileInterfaceImpl.getInstance().openFileReader(paramContext, paramBundle, paramValueCallback, null);
    AppMethodBeat.o(54338);
    return i;
  }
  
  public int startMiniQB(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54342);
    paramString2 = new Bundle();
    a(paramMap, paramString2);
    if (!paramMap.containsKey("filePath")) {
      paramString2.putString("filePath", paramString1);
    }
    int i = openFile(paramContext, paramString2, paramValueCallback);
    AppMethodBeat.o(54342);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsOneFileOpenManager
 * JD-Core Version:    0.7.0.1
 */