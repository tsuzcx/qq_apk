package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.t;
import java.util.Map;

class bl
{
  private Context a;
  private Context b;
  private String c;
  private String[] d;
  private DexLoader e;
  private String f;
  private String g;
  
  public bl(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, an paraman)
  {
    AppMethodBeat.i(139404);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = "TbsDexOpt";
    this.g = null;
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || ((paramContext2 == null) && (TbsShareManager.getHostCorePathAppDefined() == null)) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramContext1 = new Exception("TbsWizard paramter error:-1callerContext:" + paramContext1 + "hostcontext" + paramContext2 + "isEmpty" + TextUtils.isEmpty(paramString1) + "dexfileList" + paramArrayOfString);
      AppMethodBeat.o(139404);
      throw paramContext1;
    }
    this.a = paramContext1.getApplicationContext();
    if (paramContext2.getApplicationContext() != null) {}
    for (this.b = paramContext2.getApplicationContext();; this.b = paramContext2)
    {
      this.c = paramString1;
      this.d = paramArrayOfString;
      this.f = paramString2;
      if (paraman != null) {
        paraman.a("load_tbs_dex", (byte)1);
      }
      i = 0;
      while (i < this.d.length)
      {
        TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        i += 1;
      }
    }
    TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + paramString3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + paramString2);
    this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.n);
    System.currentTimeMillis();
    a(paramContext1);
    if (paraman != null) {
      paraman.a("load_tbs_dex", (byte)2);
    }
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName))
    {
      paramContext2 = this.e;
      paramString1 = this.a;
      paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
    }
    if (QbSdk.n != null) {
      bool1 = false;
    }
    try
    {
      bool2 = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
      bool1 = bool2;
    }
    catch (Throwable paramContext2)
    {
      boolean bool2;
      label445:
      break label445;
    }
    int i = 0;
    try
    {
      bool2 = "true".equals(String.valueOf(QbSdk.n.get("use_sandbox")));
      if (bool2) {
        i = 1;
      }
    }
    catch (Throwable paramContext2)
    {
      label476:
      break label476;
    }
    paramContext2 = QbSdk.n;
    if ((bool1) && (i != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramContext2.put("use_sandbox", Boolean.valueOf(bool1));
      paramContext2 = this.e;
      paramString1 = QbSdk.n;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
      if (paraman != null) {
        paraman.a("init_tbs", (byte)1);
      }
      i = b(paramContext1);
      if (paraman != null) {
        paraman.a("init_tbs", (byte)2);
      }
      if (i >= 0) {
        break;
      }
      paramContext1 = new Exception("TbsWizard init error: " + i + "; msg: " + this.g);
      AppMethodBeat.o(139404);
      throw paramContext1;
    }
    TbsLog.i("TbsWizard", "construction end...");
    AppMethodBeat.o(139404);
  }
  
  private int b(Context paramContext)
  {
    AppMethodBeat.i(139407);
    Object localObject1 = this.e;
    Object localObject2 = b.a;
    Object localObject3 = b.b;
    Object localObject4 = b.c;
    String str1 = b.d;
    ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[] { Context.class, String.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    String str2;
    String str3;
    int i;
    if ((this.b == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.1114", Integer.valueOf(43663), str3, str4 });
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        c();
        d();
        localObject1 = this.e;
        localObject2 = this.b;
        localObject3 = this.e;
        localObject4 = this.c;
        str1 = this.f;
        localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
      }
      if (localObject2 != null) {
        break label716;
      }
      i = -3;
      label389:
      if (i >= 0) {
        break label774;
      }
      paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        this.g = ("#" + ((Throwable)localObject1).getMessage() + "; cause: " + ((Throwable)localObject1).getCause() + "; th: " + localObject1);
      }
      if (!(paramContext instanceof String)) {}
    }
    label774:
    for (this.g = ((String)paramContext);; this.g = null)
    {
      AppMethodBeat.o(139407);
      return i;
      TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + paramContext + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.c + " mDexOptPath is " + this.f);
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "4.3.0.1114", Integer.valueOf(43663), str3 });
      break;
      label716:
      if ((localObject2 instanceof Integer))
      {
        i = ((Integer)localObject2).intValue();
        break label389;
      }
      if ((localObject2 instanceof Throwable))
      {
        TbsCoreLoadStat.getInstance().a(this.a, 328, (Throwable)localObject2);
        i = -5;
        break label389;
      }
      i = -4;
      break label389;
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(139408);
    this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.3.0.1114" });
    AppMethodBeat.o(139408);
  }
  
  private void d()
  {
    AppMethodBeat.i(139409);
    this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43663));
    AppMethodBeat.o(139409);
  }
  
  public String a()
  {
    String str = null;
    AppMethodBeat.i(139410);
    Object localObject1 = this.e;
    Object localObject2 = Boolean.TYPE;
    Boolean localBoolean = Boolean.TRUE;
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { localBoolean, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0] });
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null)
    {
      localObject1 = String.valueOf(localObject1);
      str = (String)localObject1 + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
    }
    if (str == null)
    {
      AppMethodBeat.o(139410);
      return "X5 core get nothing...";
    }
    AppMethodBeat.o(139410);
    return str;
  }
  
  void a(Context paramContext)
  {
    AppMethodBeat.i(139405);
    Object localObject = QbSdk.n;
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("check_tbs_validity");
      if (!(localObject instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {
        t.b(paramContext);
      }
      AppMethodBeat.o(139405);
      return;
    }
  }
  
  public void a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, an paraman)
  {
    AppMethodBeat.i(139406);
    this.a = paramContext1.getApplicationContext();
    if (this.b.getApplicationContext() != null) {
      this.b = this.b.getApplicationContext();
    }
    this.c = paramString1;
    this.d = paramArrayOfString;
    this.f = paramString2;
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if (QbSdk.n != null)
    {
      paramContext2 = this.e;
      paramString1 = QbSdk.n;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = b(paramContext1);
    if (i < 0)
    {
      paramContext1 = new Exception("continueInit init error: " + i + "; msg: " + this.g);
      AppMethodBeat.o(139406);
      throw paramContext1;
    }
    AppMethodBeat.o(139406);
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(139411);
    paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null)
    {
      AppMethodBeat.o(139411);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(139411);
    return bool;
  }
  
  public DexLoader b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.bl
 * JD-Core Version:    0.7.0.1
 */