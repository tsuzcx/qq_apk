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
  private final HashMap<String, XWalkExternalExtensionBridge> mExtensions = new HashMap();
  private boolean mLoadExternalExtensions;
  private final XWalkNativeExtensionLoader mNativeExtensionLoader;
  private final XWalkView mXWalkView;
  
  public XWalkExternalExtensionManagerImpl(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    this.mXWalkView = paramXWalkView;
    if (getBridge() == null)
    {
      Log.e("XWalkExternalExtensionManagerImpl", "Cannot load external extensions due to old version of runtime library");
      this.mContext = null;
      this.mLoadExternalExtensions = false;
      this.mNativeExtensionLoader = null;
      return;
    }
    this.mContext = getViewContext();
    this.mLoadExternalExtensions = true;
    this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
    loadNativeExtensions();
  }
  
  private void createExternalExtension(String paramString1, String paramString2, String paramString3, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    paramXWalkExtensionContextClient = paramXWalkExtensionContextClient.getContext();
    try
    {
      paramXWalkExtensionContextClient.getClassLoader().loadClass(paramString2).getConstructor(new Class[] { String.class, String.class, XWalkExtensionContextClient.class }).newInstance(new Object[] { paramString1, paramString3, this });
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (InstantiationException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (InvocationTargetException paramString1)
    {
      handleException(paramString1);
      return;
    }
    catch (NoSuchMethodException paramString1)
    {
      handleException(paramString1);
    }
  }
  
  private String getFileContent(Context paramContext, String paramString, boolean paramBoolean)
  {
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
      return paramContext;
    }
    finally
    {
      String str;
      Object localObject2;
      if (localObject2 != null) {
        localObject2.close();
      }
    }
  }
  
  private static void handleException(Exception paramException)
  {
    Log.e("XWalkExternalExtensionManagerImpl", "Error in calling methods of external extensions. " + paramException.toString());
  }
  
  private void loadNativeExtensions()
  {
    Object localObject = null;
    try
    {
      String str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label26:
      break label26;
    }
    if ((localObject != null) && (new File(localObject).isDirectory())) {
      this.mNativeExtensionLoader.registerNativeExtensionsInPath(localObject);
    }
  }
  
  public void broadcastMessage(XWalkExternalExtension paramXWalkExternalExtension, String paramString)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.broadcastMessage(paramString);
    }
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
    //   0: aload_0
    //   1: getfield 50	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mLoadExternalExtensions	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 247	java/lang/String:length	()I
    //   12: istore_2
    //   13: aload_1
    //   14: astore_3
    //   15: aload_1
    //   16: iload_2
    //   17: iconst_1
    //   18: isub
    //   19: invokevirtual 251	java/lang/String:charAt	(I)C
    //   22: getstatic 255	java/io/File:separatorChar	C
    //   25: if_icmpne +12 -> 37
    //   28: aload_1
    //   29: iconst_0
    //   30: iload_2
    //   31: iconst_1
    //   32: isub
    //   33: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   36: astore_3
    //   37: aload_3
    //   38: aload_3
    //   39: getstatic 255	java/io/File:separatorChar	C
    //   42: invokevirtual 263	java/lang/String:lastIndexOf	(I)I
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 266	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore_1
    //   51: new 176	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   58: aload_3
    //   59: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: getstatic 270	java/io/File:separator	Ljava/lang/String;
    //   65: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 272
    //   75: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 5
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 48	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mContext	Landroid/content/Context;
    //   88: aload 5
    //   90: iconst_0
    //   91: invokespecial 274	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:getFileContent	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore_1
    //   95: new 276	org/json/JSONObject
    //   98: dup
    //   99: aload_1
    //   100: invokespecial 277	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore_1
    //   104: aload_1
    //   105: ldc_w 279
    //   108: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 6
    //   113: aload_1
    //   114: ldc_w 285
    //   117: invokevirtual 283	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 7
    //   122: aload_1
    //   123: ldc_w 287
    //   126: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +197 -> 328
    //   134: aload_1
    //   135: invokevirtual 247	java/lang/String:length	()I
    //   138: ifeq +190 -> 328
    //   141: new 176	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   148: aload_3
    //   149: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: getstatic 270	java/io/File:separator	Ljava/lang/String;
    //   155: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: aconst_null
    //   167: astore 4
    //   169: aload 4
    //   171: astore_3
    //   172: aload_1
    //   173: ifnull +26 -> 199
    //   176: aload_1
    //   177: invokevirtual 247	java/lang/String:length	()I
    //   180: istore_2
    //   181: aload 4
    //   183: astore_3
    //   184: iload_2
    //   185: ifeq +14 -> 199
    //   188: aload_0
    //   189: aload_0
    //   190: getfield 48	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:mContext	Landroid/content/Context;
    //   193: aload_1
    //   194: iconst_0
    //   195: invokespecial 274	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:getFileContent	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    //   198: astore_3
    //   199: aload 6
    //   201: ifnull -194 -> 7
    //   204: aload 7
    //   206: ifnull -199 -> 7
    //   209: ldc 10
    //   211: new 176	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 292
    //   218: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload 6
    //   223: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 294
    //   229: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 7
    //   234: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 297	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_0
    //   244: aload 6
    //   246: aload 7
    //   248: aload_3
    //   249: aload_0
    //   250: invokespecial 299	org/xwalk/core/extension/XWalkExternalExtensionManagerImpl:createExternalExtension	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xwalk/core/extension/XWalkExtensionContextClient;)V
    //   253: return
    //   254: astore_1
    //   255: ldc 10
    //   257: new 176	java/lang/StringBuilder
    //   260: dup
    //   261: ldc_w 301
    //   264: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: aload 5
    //   269: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 191	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: return
    //   279: astore_1
    //   280: ldc 10
    //   282: new 176	java/lang/StringBuilder
    //   285: dup
    //   286: ldc_w 303
    //   289: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 5
    //   294: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 191	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: return
    //   304: astore_3
    //   305: ldc 10
    //   307: new 176	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 305
    //   314: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload_1
    //   318: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 191	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: return
    //   328: goto -162 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	XWalkExternalExtensionManagerImpl
    //   0	331	1	paramString	String
    //   12	173	2	i	int
    //   14	235	3	localObject1	Object
    //   304	1	3	localIOException	java.io.IOException
    //   167	15	4	localObject2	Object
    //   81	212	5	str1	String
    //   111	134	6	str2	String
    //   120	127	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   95	130	254	org/json/JSONException
    //   134	166	254	org/json/JSONException
    //   176	181	254	org/json/JSONException
    //   188	199	254	org/json/JSONException
    //   209	253	254	org/json/JSONException
    //   305	327	254	org/json/JSONException
    //   83	95	279	java/io/IOException
    //   188	199	304	java/io/IOException
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onDestroy();
    }
    this.mExtensions.clear();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onResume();
    }
  }
  
  public void onStart()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.mExtensions.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExternalExtensionBridge)localIterator.next()).onStop();
    }
  }
  
  public void postBinaryMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, byte[] paramArrayOfByte)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postBinaryMessage(paramInt, paramArrayOfByte);
    }
  }
  
  public void postMessage(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, String paramString)
  {
    paramXWalkExternalExtension = (XWalkExternalExtensionBridge)this.mExtensions.get(paramXWalkExternalExtension.getExtensionName());
    if (paramXWalkExternalExtension != null) {
      paramXWalkExternalExtension.postMessage(paramInt, paramString);
    }
  }
  
  public void registerExtension(XWalkExternalExtension paramXWalkExternalExtension)
  {
    if (this.mExtensions.get(paramXWalkExternalExtension.getExtensionName()) != null)
    {
      Log.e("XWalkExternalExtensionManagerImpl", paramXWalkExternalExtension.getExtensionName() + "is already registered!");
      return;
    }
    XWalkExternalExtensionBridge localXWalkExternalExtensionBridge = XWalkExternalExtensionBridgeFactory.createInstance(paramXWalkExternalExtension);
    this.mExtensions.put(paramXWalkExternalExtension.getExtensionName(), localXWalkExternalExtensionBridge);
  }
  
  public void setAllowExternalExtensions(boolean paramBoolean)
  {
    this.mLoadExternalExtensions = paramBoolean;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    throw new ActivityNotFoundException("This method is no longer supported");
  }
  
  public void unregisterExtension(String paramString)
  {
    XWalkExternalExtensionBridge localXWalkExternalExtensionBridge = (XWalkExternalExtensionBridge)this.mExtensions.get(paramString);
    if (localXWalkExternalExtensionBridge != null)
    {
      this.mExtensions.remove(paramString);
      localXWalkExternalExtensionBridge.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtensionManagerImpl
 * JD-Core Version:    0.7.0.1
 */