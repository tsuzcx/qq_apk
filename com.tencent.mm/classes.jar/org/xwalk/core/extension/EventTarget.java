package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class EventTarget
  extends BindingObject
{
  private String TAG;
  private Map<String, MessageInfo> mEvents;
  
  public EventTarget()
  {
    AppMethodBeat.i(86095);
    this.TAG = "EventTarget";
    this.mEvents = new HashMap();
    this.mHandler.register("addEventListener", this);
    this.mHandler.register("removeEventListener", this);
    AppMethodBeat.o(86095);
  }
  
  public void dispatchEvent(String paramString)
  {
    AppMethodBeat.i(86097);
    dispatchEvent(paramString, null);
    AppMethodBeat.o(86097);
  }
  
  public void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(86098);
    try
    {
      if (!this.mEvents.containsKey(paramString))
      {
        Log.w(this.TAG, "Attempt to dispatch to non-existing event :".concat(String.valueOf(paramString)));
        AppMethodBeat.o(86098);
        return;
      }
      paramString = (MessageInfo)this.mEvents.get(paramString);
      JSONArray localJSONArray = new JSONArray();
      if (paramJSONObject != null) {
        localJSONArray.put(0, paramJSONObject);
      }
      paramString.postResult(localJSONArray);
      AppMethodBeat.o(86098);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(86098);
    }
  }
  
  public boolean isEventActive(String paramString)
  {
    AppMethodBeat.i(86096);
    boolean bool = this.mEvents.containsKey(paramString);
    AppMethodBeat.o(86096);
    return bool;
  }
  
  public void onAddEventListener(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86099);
    try
    {
      String str = paramMessageInfo.getArgs().getString(0);
      if (this.mEvents.containsKey(str))
      {
        Log.w(this.TAG, "Trying to re-add the event :".concat(String.valueOf(str)));
        AppMethodBeat.o(86099);
        return;
      }
      this.mEvents.put(str, paramMessageInfo);
      startEvent(str);
      AppMethodBeat.o(86099);
      return;
    }
    catch (JSONException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
      AppMethodBeat.o(86099);
    }
  }
  
  public void onRemoveEventListener(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86100);
    try
    {
      paramMessageInfo = paramMessageInfo.getArgs().getString(0);
      if (!this.mEvents.containsKey(paramMessageInfo))
      {
        Log.w(this.TAG, "Attempt to remove non-existing event :".concat(String.valueOf(paramMessageInfo)));
        AppMethodBeat.o(86100);
        return;
      }
      stopEvent(paramMessageInfo);
      this.mEvents.remove(paramMessageInfo);
      AppMethodBeat.o(86100);
      return;
    }
    catch (JSONException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
      AppMethodBeat.o(86100);
    }
  }
  
  public void startEvent(String paramString) {}
  
  public void stopEvent(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.EventTarget
 * JD-Core Version:    0.7.0.1
 */