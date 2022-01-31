package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.x5.a.d;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements a
{
  public final void a(Context paramContext, d.a parama)
  {
    AppMethodBeat.i(85095);
    QbSdk.preInit(paramContext, new e.b(parama));
    AppMethodBeat.o(85095);
  }
  
  public final void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(85102);
    QbSdk.canOpenFile(paramContext, paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(85102);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(85099);
    QbSdk.setTbsListener(new e.a(paramh));
    AppMethodBeat.o(85099);
  }
  
  public final boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(85101);
    boolean bool = QbSdk.startQbOrMiniQBToLoadUrl(paramContext, paramString, paramHashMap, new a.d(paramValueCallback));
    AppMethodBeat.o(85101);
    return bool;
  }
  
  public final boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(85105);
    boolean bool = QbSdk.canOpenWebPlus(paramContext);
    AppMethodBeat.o(85105);
    return bool;
  }
  
  public final void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(85106);
    QbSdk.closeFileReader(paramContext);
    AppMethodBeat.o(85106);
  }
  
  public final void forceSysWebView()
  {
    AppMethodBeat.i(85107);
    QbSdk.forceSysWebView();
    AppMethodBeat.o(85107);
  }
  
  public final boolean getTBSInstalling()
  {
    AppMethodBeat.i(85097);
    boolean bool = QbSdk.getTBSInstalling();
    AppMethodBeat.o(85097);
    return bool;
  }
  
  public final int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(85098);
    int i = QbSdk.getTbsVersion(paramContext);
    AppMethodBeat.o(85098);
    return i;
  }
  
  public final void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(85104);
    QbSdk.initTbsSettings(paramMap);
    AppMethodBeat.o(85104);
  }
  
  public final boolean isTbsCoreInited()
  {
    AppMethodBeat.i(85103);
    boolean bool = QbSdk.isTbsCoreInited();
    AppMethodBeat.o(85103);
    return bool;
  }
  
  public final void reset(Context paramContext)
  {
    AppMethodBeat.i(85096);
    QbSdk.reset(paramContext);
    AppMethodBeat.o(85096);
  }
  
  public final void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(85108);
    QbSdk.setUploadCode(paramContext, paramInt);
    AppMethodBeat.o(85108);
  }
  
  public final int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(85100);
    int i = QbSdk.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
    AppMethodBeat.o(85100);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e
 * JD-Core Version:    0.7.0.1
 */