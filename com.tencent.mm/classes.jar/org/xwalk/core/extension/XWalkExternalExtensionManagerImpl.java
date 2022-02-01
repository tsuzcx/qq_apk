package org.xwalk.core.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkExternalExtensionManager;
import org.xwalk.core.XWalkNativeExtensionLoader;
import org.xwalk.core.XWalkView;

public class XWalkExternalExtensionManagerImpl
  extends XWalkExternalExtensionManager
  implements XWalkExtensionContextClient
{
  private static final String TAG = "XWalkExternalExtensionManagerImpl";
  private final Context mContext;
  private final HashMap<String, XWalkExternalExtensionBridge> mExtensions;
  private boolean mLoadExternalExtensions;
  private final XWalkNativeExtensionLoader mNativeExtensionLoader;
  private final XWalkView mXWalkView;
  
  public XWalkExternalExtensionManagerImpl(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(155305);
    this.mExtensions = new HashMap();
    this.mXWalkView = paramXWalkView;
    if (getBridge() == null)
    {
      Log.e("XWalkExternalExtensionManagerImpl", "Cannot load external extensions due to old version of runtime library");
      this.mContext = null;
      this.mLoadExternalExtensions = false;
      this.mNativeExtensionLoader = null;
      AppMethodBeat.o(155305);
      return;
    }
    this.mContext = getViewContext();
    this.mLoadExternalExtensions = true;
    this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
    loadNativeExtensions();
    AppMethodBeat.o(155305);
  }
  
  private void createExternalExtension(String paramString1, String paramString2, String paramString3, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    AppMethodBeat.i(155320);
    paramXWalkExtensionContextClient = paramXWalkExtensionContextClient.getContext();
    try
    {
      paramXWalkExtensionContextClient.getClassLoader().loadClass(paramString2).getConstructor(new Class[] { String.class, String.class, XWalkExtensionContextClient.class }).newInstance(new Object[] { paramString1, paramString3, this });
      AppMethodBeat.o(155320);
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      handleException(paramString1);
      AppMethodBeat.o(155320);
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      handleException(paramString1);
      AppMethodBeat.o(155320);
      return;
    }
    catch (InstantiationException paramString1)
    {
      handleException(paramString1);
      AppMethodBeat.o(155320);
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      handleException(paramString1);
      AppMethodBeat.o(155320);
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      handleException(paramString1);
      AppMethodBeat.o(155320);
    }
  }
  
  private String getFileContent(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(155319);
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {
      localObject1 = localObject4;
    }
    try
    {
      Object localObject5 = paramContext.getResources();
      localObject1 = localObject4;
      str = new File(paramString).getName().split("\\.")[0];
      localObject1 = localObject4;
      int i = ((Resources)localObject5).getIdentifier(str, "raw", paramContext.getPackageName());
      localObject1 = localObject3;
      if (i > 0) {
        localObject1 = localObject4;
      }
      try
      {
        localObject5 = ((Resources)localObject5).openRawResource(i);
        localObject1 = localObject5;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject2 = localObject4;
          Log.w("XWalkExternalExtensionManagerImpl", "Inputstream failed to open for R.raw." + str + ", try to find it in assets");
          localObject2 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramContext.getAssets().open(paramString);
      }
      localObject1 = localObject3;
      paramContext = new byte[((InputStream)localObject3).available()];
      localObject1 = localObject3;
      ((InputStream)localObject3).read(paramContext);
      localObject1 = localObject3;
      paramContext = new String(paramContext);
      if (localObject3 != null) {
        ((InputStream)localObject3).close();
      }
      AppMethodBeat.o(155319);
      return paramContext;
    }
    finally
    {
      String str;
      Object localObject2;
      if (localObject2 != null) {
        localObject2.close();
      }
      AppMethodBeat.o(155319);
    }
  }
  
  private static void handleException(Exception paramException)
  {
    AppMethodBeat.i(155322);
    Log.e("XWalkExternalExtensionManagerImpl", "Error in calling methods of external extensions. " + paramException.toString());
    AppMethodBeat.o(155322);
  }
  
  private void loadNativeExtensions()
  {
    AppMethodBeat.i(155321);
    Object localObject = null;
    try
    {
      String str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label31:
      break label31;
    }
    if ((localObject != null) && (new File(localObject).isDirectory())) {
      this.mNativeExtensionLoader.registerNativeExtensionsInPath(localObject);
    }
    AppMethodBeat.o(155321);
  }
  
  public void broadcastMessage(XWalkExternalExtension paramXWalkExternalExtension, String paramString)
  {
    AppMethodBeat.i(155312);
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.broadcastMessage(paramString);
    }
    AppMethodBeat.o(155312);
  }
  
  public Activity getActivity()
  {
    if ((this.mContext instanceof Activity)) {
      return (Activity)this.mContext;
    }
    return null;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  /* Error */
  public void loadExtension(String paramString)
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 57	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mLoadExternalExtensions	Z
    //   10: ifne +10 -> 20
    //   13: ldc_w 260
    //   16: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_1
    //   21: invokevirtual 263	java/lang/String:length	()I
    //   24: istore_2
    //   25: aload_1
    //   26: astore_3
    //   27: aload_1
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: invokevirtual 267	java/lang/String:charAt	(I)C
    //   34: getstatic 271	java/io/File:separatorChar	C
    //   37: if_icmpne +12 -> 49
    //   40: aload_1
    //   41: iconst_0
    //   42: iload_2
    //   43: iconst_1
    //   44: isub
    //   45: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: aload_3
    //   51: getstatic 271	java/io/File:separatorChar	C
    //   54: invokevirtual 279	java/lang/String:lastIndexOf	(I)I
    //   57: iconst_1
    //   58: iadd
    //   59: invokevirtual 282	java/lang/String:substring	(I)Ljava/lang/String;
    //   62: astore_1
    //   63: new 188	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 286	java/io/File:separator	Ljava/lang/String;
    //   77: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 288
    //   87: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 5
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 55	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mContext	Landroid/content/Context;
    //   100: aload 5
    //   102: iconst_0
    //   103: invokespecial 290	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:getFileContent	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   106: astore_1
    //   107: new 292	org/json/JSONObject
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: aload_1
    //   117: ldc_w 295
    //   120: invokevirtual 299	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore 6
    //   125: aload_1
    //   126: ldc_w 301
    //   129: invokevirtual 299	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 7
    //   134: aload_1
    //   135: ldc_w 303
    //   138: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +200 -> 343
    //   146: aload_1
    //   147: invokevirtual 263	java/lang/String:length	()I
    //   150: ifeq +193 -> 343
    //   153: new 188	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   160: aload_3
    //   161: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: getstatic 286	java/io/File:separator	Ljava/lang/String;
    //   167: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_1
    //   178: aconst_null
    //   179: astore 4
    //   181: aload 4
    //   183: astore_3
    //   184: aload_1
    //   185: ifnull +26 -> 211
    //   188: aload_1
    //   189: invokevirtual 263	java/lang/String:length	()I
    //   192: istore_2
    //   193: aload 4
    //   195: astore_3
    //   196: iload_2
    //   197: ifeq +14 -> 211
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 55	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mContext	Landroid/content/Context;
    //   205: aload_1
    //   206: iconst_0
    //   207: invokespecial 290	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:getFileContent	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   210: astore_3
    //   211: aload 6
    //   213: ifnull +52 -> 265
    //   216: aload 7
    //   218: ifnull +47 -> 265
    //   221: ldc 10
    //   223: new 188	java/lang/StringBuilder
    //   226: dup
    //   227: ldc_w 308
    //   230: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: aload 6
    //   235: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 310
    //   241: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 7
    //   246: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 312	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: aload 6
    //   258: aload 7
    //   260: aload_3
    //   261: aload_0
    //   262: invokespecial 314	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:createExternalExtension	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xwalk/core/extension/XWalkExtensionContextClient;)V
    //   265: ldc_w 260
    //   268: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: return
    //   272: astore_1
    //   273: ldc 10
    //   275: ldc_w 316
    //   278: aload 5
    //   280: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   283: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokestatic 203	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: ldc_w 260
    //   292: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: return
    //   296: astore_3
    //   297: ldc 10
    //   299: ldc_w 325
    //   302: aload_1
    //   303: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   306: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokestatic 203	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: ldc_w 260
    //   315: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: return
    //   319: astore_1
    //   320: ldc 10
    //   322: ldc_w 327
    //   325: aload 5
    //   327: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   330: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   333: invokestatic 203	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: ldc_w 260
    //   339: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: return
    //   343: goto -165 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	XWalkExternalExtensionManagerImpl
    //   0	346	1	paramString	String
    //   24	173	2	i	int
    //   26	235	3	localObject1	Object
    //   296	1	3	localIOException	java.io.IOException
    //   179	15	4	localObject2	Object
    //   93	233	5	str1	String
    //   123	134	6	str2	String
    //   132	127	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   95	107	272	java/io/IOException
    //   200	211	296	java/io/IOException
    //   107	142	319	org/json/JSONException
    //   146	178	319	org/json/JSONException
    //   188	193	319	org/json/JSONException
    //   200	211	319	org/json/JSONException
    //   221	265	319	org/json/JSONException
    //   297	312	319	org/json/JSONException
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(155317);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onDestroy();
    }
    this.mExtensions.clear();
    AppMethodBeat.o(155317);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(155318);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onNewIntent(paramIntent);
    }
    AppMethodBeat.o(155318);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(155315);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onPause();
    }
    AppMethodBeat.o(155315);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(155314);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onResume();
    }
    AppMethodBeat.o(155314);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(155313);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStart();
    }
    AppMethodBeat.o(155313);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(155316);
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStop();
    }
    AppMethodBeat.o(155316);
  }
  
  public void postBinaryMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155311);
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postBinaryMessage(paramInt, paramArrayOfByte);
    }
    AppMethodBeat.o(155311);
  }
  
  public void postMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, String paramString)
  {
    AppMethodBeat.i(155310);
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postMessage(paramInt, paramString);
    }
    AppMethodBeat.o(155310);
  }
  
  public void registerExtension(XWalkExternalExtension paramXWalkExternalExtension)
  {
    AppMethodBeat.i(155306);
    if (this.mExtensions.get(paramXWalkExternalExtension.getExtensionName()) != null)
    {
      Log.e("XWalkExternalExtensionManagerImpl", paramXWalkExternalExtension.getExtensionName() + "is already registered!");
      AppMethodBeat.o(155306);
      return;
    }
    XWalkExternalExtensionBridge localXWalkExternalExtensionBridge = XWalkExternalExtensionBridgeFactory.createInstance(paramXWalkExternalExtension);
    this.mExtensions.put(paramXWalkExternalExtension.getExtensionName(), localXWalkExternalExtensionBridge);
    AppMethodBeat.o(155306);
  }
  
  public void setAllowExternalExtensions(boolean paramBoolean)
  {
    this.mLoadExternalExtensions = paramBoolean;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(155308);
    paramIntent = new ActivityNotFoundException("This method is no longer supported");
    AppMethodBeat.o(155308);
    throw paramIntent;
  }
  
  public void unregisterExtension(String paramString)
  {
    AppMethodBeat.i(155307);
    XWalkExternalExtensionBridge localXWalkExternalExtensionBridge = (XWalkExternalExtensionBridge)this.mExtensions.get(paramString);
    if (localXWalkExternalExtensionBridge != null)
    {
      this.mExtensions.remove(paramString);
      localXWalkExternalExtensionBridge.onDestroy();
    }
    AppMethodBeat.o(155307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtensionManagerImpl
 * JD-Core Version:    0.7.0.1
 */