package org.xwalk.core.extension;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class XWalkExternalExtension
{
  private Map<Integer, ExtensionInstanceHelper> instanceHelpers;
  protected String[] mEntryPoints;
  protected XWalkExtensionContextClient mExtensionContext;
  protected MessageHandler mHandler;
  protected String mJsApi;
  protected String mName;
  protected ReflectionHelper mReflection;
  protected boolean useJsStubGeneration;
  
  static
  {
    if (!XWalkExternalExtension.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkExternalExtension(String paramString1, String paramString2, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    this(paramString1, paramString2, null, paramXWalkExtensionContextClient);
  }
  
  public XWalkExternalExtension(String paramString1, String paramString2, String[] paramArrayOfString, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    assert (paramXWalkExtensionContextClient != null);
    this.mName = paramString1;
    this.mJsApi = paramString2;
    this.mEntryPoints = paramArrayOfString;
    this.mExtensionContext = paramXWalkExtensionContextClient;
    this.instanceHelpers = new HashMap();
    this.mHandler = new MessageHandler();
    if ((this.mJsApi == null) || (this.mJsApi.length() == 0))
    {
      this.useJsStubGeneration = true;
      this.mReflection = new ReflectionHelper(getClass());
      this.mJsApi = new JsStubGenerator(this.mReflection).generate();
      if ((this.mJsApi == null) || (this.mJsApi.length() == 0)) {
        Log.e("Extension-" + this.mName, "Can't generate JavaScript stub for this extension.");
      }
    }
    else
    {
      this.mReflection = null;
      this.useJsStubGeneration = false;
    }
    this.mExtensionContext.registerExtension(this);
  }
  
  public final void broadcastMessage(String paramString)
  {
    this.mExtensionContext.broadcastMessage(this, paramString);
  }
  
  public final String[] getEntryPoints()
  {
    return this.mEntryPoints;
  }
  
  public final String getExtensionName()
  {
    return this.mName;
  }
  
  protected ExtensionInstanceHelper getInstanceHelper(int paramInt)
  {
    return (ExtensionInstanceHelper)this.instanceHelpers.get(Integer.valueOf(paramInt));
  }
  
  public final String getJsApi()
  {
    return this.mJsApi;
  }
  
  public MessageHandler getMessageHandler()
  {
    return this.mHandler;
  }
  
  public ReflectionHelper getReflection()
  {
    return this.mReflection;
  }
  
  public ReflectionHelper getTargetReflect(String paramString)
  {
    paramString = this.mReflection.getConstructorReflection(paramString);
    if (paramString != null) {
      return paramString;
    }
    return this.mReflection;
  }
  
  public boolean isAutoJS()
  {
    return this.useJsStubGeneration;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.useJsStubGeneration) {
      getInstanceHelper(paramInt).handleMessage(paramArrayOfByte);
    }
  }
  
  public void onDestroy() {}
  
  public void onInstanceCreated(int paramInt)
  {
    this.instanceHelpers.put(Integer.valueOf(paramInt), new ExtensionInstanceHelper(this, paramInt));
  }
  
  public void onInstanceDestroyed(int paramInt)
  {
    this.instanceHelpers.remove(Integer.valueOf(paramInt));
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    if (this.useJsStubGeneration) {
      getInstanceHelper(paramInt).handleMessage(paramString);
    }
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public String onSyncMessage(int paramInt, String paramString)
  {
    Object localObject = null;
    if (this.useJsStubGeneration) {
      localObject = getInstanceHelper(paramInt).handleMessage(paramString);
    }
    if (localObject != null) {
      return ReflectionHelper.objToJSON(localObject);
    }
    return "";
  }
  
  public final void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    this.mExtensionContext.postBinaryMessage(this, paramInt, paramArrayOfByte);
  }
  
  public final void postMessage(int paramInt, String paramString)
  {
    this.mExtensionContext.postMessage(this, paramInt, paramString);
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "onEvent");
      localJSONObject.put("type", paramString);
      localJSONObject.put("event", ReflectionHelper.objToJSON(paramObject));
      broadcastMessage(localJSONObject.toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    throw new ActivityNotFoundException("This method is no longer supported");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtension
 * JD-Core Version:    0.7.0.1
 */