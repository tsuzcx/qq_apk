package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
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
    AppMethodBeat.i(219787);
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
      AppMethodBeat.o(219787);
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
      AppMethodBeat.o(219787);
      throw paramContext1;
    }
    TbsLog.i("TbsWizard", "construction end...");
    AppMethodBeat.o(219787);
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 176
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 147	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   10: ifnull +81 -> 91
    //   13: aload_0
    //   14: getfield 31	com/tencent/smtt/sdk/TbsWizard:a	Landroid/content/Context;
    //   17: invokestatic 182	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   20: invokevirtual 186	com/tencent/smtt/sdk/TbsPVConfig:getTbsCoreSandboxModeEnable	()Z
    //   23: istore_2
    //   24: ldc 188
    //   26: getstatic 147	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   29: ldc 190
    //   31: invokeinterface 196 2 0
    //   36: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: istore 4
    //   44: iload 4
    //   46: ifeq +60 -> 106
    //   49: iconst_1
    //   50: istore_1
    //   51: getstatic 147	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   54: astore 5
    //   56: iload_2
    //   57: ifeq +54 -> 111
    //   60: iload_1
    //   61: ifeq +50 -> 111
    //   64: iload_3
    //   65: istore_2
    //   66: aload 5
    //   68: ldc 190
    //   70: iload_2
    //   71: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: invokeinterface 215 3 0
    //   79: pop
    //   80: invokestatic 219	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   83: getstatic 147	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   86: invokeinterface 225 2 0
    //   91: ldc 176
    //   93: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore 5
    //   99: iconst_0
    //   100: istore_2
    //   101: goto -77 -> 24
    //   104: astore 5
    //   106: iconst_0
    //   107: istore_1
    //   108: goto -57 -> 51
    //   111: iconst_0
    //   112: istore_2
    //   113: goto -47 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	TbsWizard
    //   50	58	1	i	int
    //   23	90	2	bool1	boolean
    //   1	64	3	bool2	boolean
    //   42	3	4	bool3	boolean
    //   54	13	5	localMap	Map
    //   97	1	5	localObject1	Object
    //   104	1	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	97	finally
    //   24	44	104	finally
  }
  
  private int b(Context paramContext)
  {
    AppMethodBeat.i(54639);
    TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionCode(44138);
    TbsOneGreyInfoHelper.getCoreEntry().setSdkVersionName("4.4.1.0038");
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
        n.b(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsWizard
 * JD-Core Version:    0.7.0.1
 */