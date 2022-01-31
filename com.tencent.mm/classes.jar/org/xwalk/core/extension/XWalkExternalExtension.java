package org.xwalk.core.extension;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(86189);
    if (!XWalkExternalExtension.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(86189);
      return;
    }
  }
  
  public XWalkExternalExtension(String paramString1, String paramString2, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    this(paramString1, paramString2, null, paramXWalkExtensionContextClient);
  }
  
  public XWalkExternalExtension(String paramString1, String paramString2, String[] paramArrayOfString, XWalkExtensionContextClient paramXWalkExtensionContextClient)
  {
    AppMethodBeat.i(86176);
    if ((!$assertionsDisabled) && (paramXWalkExtensionContextClient == null))
    {
      paramString1 = new AssertionError();
      AppMethodBeat.o(86176);
      throw paramString1;
    }
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
      if ((this.mJsApi == null) || (this.mJsApi.length() == 0))
      {
        Log.e("Extension-" + this.mName, "Can't generate JavaScript stub for this extension.");
        AppMethodBeat.o(86176);
      }
    }
    else
    {
      this.mReflection = null;
      this.useJsStubGeneration = false;
    }
    this.mExtensionContext.registerExtension(this);
    AppMethodBeat.o(86176);
  }
  
  public final void broadcastMessage(String paramString)
  {
    AppMethodBeat.i(86187);
    this.mExtensionContext.broadcastMessage(this, paramString);
    AppMethodBeat.o(86187);
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
    AppMethodBeat.i(86183);
    ExtensionInstanceHelper localExtensionInstanceHelper = (ExtensionInstanceHelper)this.instanceHelpers.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(86183);
    return localExtensionInstanceHelper;
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
    AppMethodBeat.i(86182);
    paramString = this.mReflection.getConstructorReflection(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(86182);
      return paramString;
    }
    paramString = this.mReflection;
    AppMethodBeat.o(86182);
    return paramString;
  }
  
  public boolean isAutoJS()
  {
    return this.useJsStubGeneration;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86180);
    if (this.useJsStubGeneration) {
      getInstanceHelper(paramInt).handleMessage(paramArrayOfByte);
    }
    AppMethodBeat.o(86180);
  }
  
  public void onDestroy() {}
  
  public void onInstanceCreated(int paramInt)
  {
    AppMethodBeat.i(86177);
    this.instanceHelpers.put(Integer.valueOf(paramInt), new ExtensionInstanceHelper(this, paramInt));
    AppMethodBeat.o(86177);
  }
  
  public void onInstanceDestroyed(int paramInt)
  {
    AppMethodBeat.i(86178);
    this.instanceHelpers.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(86178);
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86179);
    if (this.useJsStubGeneration) {
      getInstanceHelper(paramInt).handleMessage(paramString);
    }
    AppMethodBeat.o(86179);
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public String onSyncMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86181);
    Object localObject = null;
    if (this.useJsStubGeneration) {
      localObject = getInstanceHelper(paramInt).handleMessage(paramString);
    }
    if (localObject != null)
    {
      paramString = ReflectionHelper.objToJSON(localObject);
      AppMethodBeat.o(86181);
      return paramString;
    }
    AppMethodBeat.o(86181);
    return "";
  }
  
  public final void postBinaryMessage(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86186);
    this.mExtensionContext.postBinaryMessage(this, paramInt, paramArrayOfByte);
    AppMethodBeat.o(86186);
  }
  
  public final void postMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(86185);
    this.mExtensionContext.postMessage(this, paramInt, paramString);
    AppMethodBeat.o(86185);
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    AppMethodBeat.i(86184);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "onEvent");
      localJSONObject.put("type", paramString);
      localJSONObject.put("event", ReflectionHelper.objToJSON(paramObject));
      broadcastMessage(localJSONObject.toString());
      AppMethodBeat.o(86184);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(86184);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(86188);
    paramIntent = new ActivityNotFoundException("This method is no longer supported");
    AppMethodBeat.o(86188);
    throw paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.extension.XWalkExternalExtension
 * JD-Core Version:    0.7.0.1
 */