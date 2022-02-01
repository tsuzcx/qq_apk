package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import java.util.Map;

public class TbsWizard
{
  public static final String WEBCOREPROXY_CLASSNAME = "com.tencent.tbs.tbsshell.WebCoreProxy";
  private Context a;
  private Context b;
  private String c;
  private String[] d;
  private DexLoader e;
  private String f;
  
  public TbsWizard(Context paramContext)
  {
    AppMethodBeat.i(54635);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.e = TbsOneGreyInfoHelper.getDexloader();
    libwebp.loadWepLibraryIfNeed(paramContext, this.c);
    a();
    b(paramContext);
    AppMethodBeat.o(54635);
  }
  
  public TbsWizard(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, p paramp)
  {
    AppMethodBeat.i(192713);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || ((paramContext2 == null) && (TbsShareManager.getHostCorePathAppDefined() == null)) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramContext1 = new Exception("TbsWizard paramter error:-1callerContext:" + paramContext1 + "hostcontext" + paramContext2 + "isEmpty" + TextUtils.isEmpty(paramString1) + "dexfileList" + paramArrayOfString);
      AppMethodBeat.o(192713);
      throw paramContext1;
    }
    this.a = paramContext1.getApplicationContext();
    if (paramContext2.getApplicationContext() != null) {}
    for (this.b = paramContext2.getApplicationContext();; this.b = paramContext2)
    {
      this.c = paramString1;
      this.d = paramArrayOfString;
      if (paramp != null) {
        paramp.a("load_tbs_dex", (byte)1);
      }
      i = 0;
      while (i < this.d.length)
      {
        TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        i += 1;
      }
    }
    TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + paramString3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + paramString2);
    this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.mSettings);
    TbsOneGreyInfoHelper.init(this.e, paramContext1, paramContext2, paramString1, paramString2);
    long l = System.currentTimeMillis();
    a(paramContext1);
    new StringBuilder("checkTbsValidityIfNecessary ").append(System.currentTimeMillis() - l);
    if (paramp != null) {
      paramp.a("load_tbs_dex", (byte)2);
    }
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    a();
    if (paramp != null) {
      paramp.a("init_tbs", (byte)1);
    }
    int i = b(paramContext1);
    if (paramp != null) {
      paramp.a("init_tbs", (byte)2);
    }
    if (i < 0)
    {
      paramContext1 = new Exception("TbsWizard init error: " + i + "; msg: " + this.f);
      AppMethodBeat.o(192713);
      throw paramContext1;
    }
    TbsLog.i("TbsWizard", "construction end...");
    AppMethodBeat.o(192713);
  }
  
  private void a()
  {
    boolean bool2 = true;
    AppMethodBeat.i(54638);
    if (QbSdk.mSettings != null) {}
    try
    {
      bool1 = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
      try
      {
        boolean bool3 = "true".equals(String.valueOf(QbSdk.mSettings.get("use_sandbox")));
        if (!bool3) {
          break label106;
        }
        i = 1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Map localMap;
          int i = 0;
          continue;
          bool1 = false;
        }
      }
      localMap = QbSdk.mSettings;
      if ((bool1) && (i != 0))
      {
        bool1 = bool2;
        localMap.put("use_sandbox", Boolean.valueOf(bool1));
        TbsOneGreyInfoHelper.getCoreEntry().initSettings(QbSdk.mSettings);
        AppMethodBeat.o(54638);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
  }
  
  private int b(Context paramContext)
  {
    AppMethodBeat.i(54639);
    TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionCode(43805);
    TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionName("4.4.0.0006");
    TbsOneGreyInfoHelper.getCoreEntry().initRuntimeEnvironment();
    AppMethodBeat.o(54639);
    return 0;
  }
  
  void a(Context paramContext)
  {
    AppMethodBeat.i(54637);
    Object localObject = QbSdk.mSettings;
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("check_tbs_validity");
      if (!(localObject instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = true)
    {
      if (bool) {
        m.b(paramContext);
      }
      AppMethodBeat.o(54637);
      return;
    }
  }
  
  public DexLoader dexLoader()
  {
    return this.e;
  }
  
  public String getCrashExtraMessage()
  {
    AppMethodBeat.i(54640);
    try
    {
      String str = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getCrashExtraMessage();
      AppMethodBeat.o(54640);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54640);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsWizard
 * JD-Core Version:    0.7.0.1
 */