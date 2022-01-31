package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.Log;

public class BindingObjectStore
{
  private String TAG;
  private Map<String, BindingObject> mBindingObjects;
  private ExtensionInstanceHelper mInstance;
  
  public BindingObjectStore(MessageHandler paramMessageHandler, ExtensionInstanceHelper paramExtensionInstanceHelper)
  {
    AppMethodBeat.i(86083);
    this.TAG = "BindingObjectStore";
    this.mBindingObjects = new HashMap();
    this.mInstance = paramExtensionInstanceHelper;
    paramMessageHandler.register("JSObjectCollected", "onJSObjectCollected", this);
    paramMessageHandler.register("postMessageToObject", "onPostMessageToObject", this);
    paramMessageHandler.register("postMessageToClass", "onPostMessageToClass", this);
    AppMethodBeat.o(86083);
  }
  
  public boolean addBindingObject(String paramString, BindingObject paramBindingObject)
  {
    AppMethodBeat.i(86084);
    if (this.mBindingObjects.containsKey(paramString))
    {
      Log.w(this.TAG, "Existing binding object:\n".concat(String.valueOf(paramString)));
      AppMethodBeat.o(86084);
      return false;
    }
    paramBindingObject.initBindingInfo(paramString, this.mInstance);
    this.mBindingObjects.put(paramString, paramBindingObject);
    paramBindingObject.onJsBound();
    AppMethodBeat.o(86084);
    return true;
  }
  
  public BindingObject getBindingObject(String paramString)
  {
    AppMethodBeat.i(86085);
    paramString = (BindingObject)this.mBindingObjects.get(paramString);
    AppMethodBeat.o(86085);
    return paramString;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(86094);
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    AppMethodBeat.o(86094);
  }
  
  public void onJSObjectCollected(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86087);
    removeBindingObject(paramMessageInfo.getObjectId());
    AppMethodBeat.o(86087);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(86092);
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onPause();
    }
    AppMethodBeat.o(86092);
  }
  
  public Object onPostMessageToClass(MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    AppMethodBeat.i(86088);
    Object localObject2 = paramMessageInfo.getArgs();
    try
    {
      MessageInfo localMessageInfo = new MessageInfo(paramMessageInfo);
      String str = ((JSONArray)localObject2).getString(0);
      JSONArray localJSONArray = ((JSONArray)localObject2).getJSONArray(1);
      localObject2 = localJSONArray.getString(0);
      localJSONArray = localJSONArray.getJSONArray(1);
      localMessageInfo.setJsName(str);
      localMessageInfo.setArgs(localJSONArray);
      paramMessageInfo = paramMessageInfo.getExtension().getTargetReflect((String)localObject2).handleMessage(localMessageInfo, null);
      AppMethodBeat.o(86088);
      return paramMessageInfo;
    }
    catch (JSONException paramMessageInfo)
    {
      for (;;)
      {
        Log.e(this.TAG, paramMessageInfo.toString());
        paramMessageInfo = localObject1;
      }
    }
    catch (Exception paramMessageInfo)
    {
      for (;;)
      {
        Log.e(this.TAG, paramMessageInfo.toString());
        paramMessageInfo = localObject1;
      }
    }
  }
  
  public Object onPostMessageToObject(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86089);
    localObject1 = null;
    for (;;)
    {
      try
      {
        BindingObject localBindingObject = getBindingObject(paramMessageInfo.getObjectId());
        localMessageInfo = new MessageInfo(paramMessageInfo);
        if (paramMessageInfo.getArgs() == null) {
          continue;
        }
        localObject2 = paramMessageInfo.getArgs();
        paramMessageInfo = ((JSONArray)localObject2).getString(0);
        localObject2 = ((JSONArray)localObject2).getJSONArray(1);
        localMessageInfo.setJsName(paramMessageInfo);
        localMessageInfo.setArgs((JSONArray)localObject2);
        paramMessageInfo = localObject1;
        if (localBindingObject != null) {
          paramMessageInfo = localBindingObject.handleMessage(localMessageInfo);
        }
      }
      catch (JSONException paramMessageInfo)
      {
        MessageInfo localMessageInfo;
        Object localObject2;
        int j;
        int i;
        Log.e(this.TAG, paramMessageInfo.toString());
        paramMessageInfo = localObject1;
        continue;
      }
      catch (NullPointerException paramMessageInfo)
      {
        continue;
      }
      catch (IndexOutOfBoundsException paramMessageInfo)
      {
        continue;
      }
      AppMethodBeat.o(86089);
      return paramMessageInfo;
      localObject2 = paramMessageInfo.getBinaryArgs();
      ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
      j = ((ByteBuffer)localObject2).position();
      i = ((ByteBuffer)localObject2).getInt(j);
      j += 4;
      paramMessageInfo = new String(((ByteBuffer)localObject2).array(), j, i);
      i = j + (4 - i % 4 + i);
      j = ((ByteBuffer)localObject2).array().length;
      localObject2 = ByteBuffer.wrap(((ByteBuffer)localObject2).array(), i, j - i);
      localMessageInfo.setJsName(paramMessageInfo);
      localMessageInfo.setBinaryArgs((ByteBuffer)localObject2);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(86091);
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onResume();
    }
    AppMethodBeat.o(86091);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(86090);
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onStart();
    }
    AppMethodBeat.o(86090);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(86093);
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onStop();
    }
    AppMethodBeat.o(86093);
  }
  
  public BindingObject removeBindingObject(String paramString)
  {
    AppMethodBeat.i(86086);
    paramString = (BindingObject)this.mBindingObjects.remove(paramString);
    if (paramString != null) {
      paramString.onJsDestroyed();
    }
    AppMethodBeat.o(86086);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObjectStore
 * JD-Core Version:    0.7.0.1
 */