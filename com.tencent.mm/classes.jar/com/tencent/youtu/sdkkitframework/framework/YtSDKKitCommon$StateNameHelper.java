package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class YtSDKKitCommon$StateNameHelper
{
  private static HashMap<StateClassName, String> _stateNameMap;
  
  static
  {
    AppMethodBeat.i(192662);
    _stateNameMap = new HashMap() {};
    AppMethodBeat.o(192662);
  }
  
  public static String classNameOfState(StateClassName paramStateClassName)
  {
    AppMethodBeat.i(192660);
    paramStateClassName = (String)_stateNameMap.get(paramStateClassName);
    AppMethodBeat.o(192660);
    return paramStateClassName;
  }
  
  public static StateClassName typeOfClassName(String paramString)
  {
    AppMethodBeat.i(192661);
    Iterator localIterator = _stateNameMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getValue()).equals(paramString))
      {
        paramString = (StateClassName)localEntry.getKey();
        AppMethodBeat.o(192661);
        return paramString;
      }
    }
    paramString = StateClassName.UNKNOWN_STATE;
    AppMethodBeat.o(192661);
    return paramString;
  }
  
  public static enum StateClassName
  {
    static
    {
      AppMethodBeat.i(192659);
      UNKNOWN_STATE = new StateClassName("UNKNOWN_STATE", 0);
      TIMEOUT_STATE = new StateClassName("TIMEOUT_STATE", 1);
      IDLE_STATE = new StateClassName("IDLE_STATE", 2);
      SILENT_STATE = new StateClassName("SILENT_STATE", 3);
      ACTION_STATE = new StateClassName("ACTION_STATE", 4);
      REFLECT_STATE = new StateClassName("REFLECT_STATE", 5);
      OCR_AUTO_DETECT_STATE = new StateClassName("OCR_AUTO_DETECT_STATE", 6);
      OCR_MANUAL_DETECT_STATE = new StateClassName("OCR_MANUAL_DETECT_STATE", 7);
      NET_FETCH_STATE = new StateClassName("NET_FETCH_STATE", 8);
      NET_LIVENESS_REQ_RESULT_STATE = new StateClassName("NET_LIVENESS_REQ_RESULT_STATE", 9);
      NET_OCR_REQ_RESULT_STATE = new StateClassName("NET_OCR_REQ_RESULT_STATE", 10);
      LIPREAD_STATE = new StateClassName("LIPREAD_STATE", 11);
      DETECTONLY_STATE = new StateClassName("DETECTONLY_STATE", 12);
      OCR_VIID_STATE = new StateClassName("OCR_VIID_STATE", 13);
      STATE_COUNT = new StateClassName("STATE_COUNT", 14);
      $VALUES = new StateClassName[] { UNKNOWN_STATE, TIMEOUT_STATE, IDLE_STATE, SILENT_STATE, ACTION_STATE, REFLECT_STATE, OCR_AUTO_DETECT_STATE, OCR_MANUAL_DETECT_STATE, NET_FETCH_STATE, NET_LIVENESS_REQ_RESULT_STATE, NET_OCR_REQ_RESULT_STATE, LIPREAD_STATE, DETECTONLY_STATE, OCR_VIID_STATE, STATE_COUNT };
      AppMethodBeat.o(192659);
    }
    
    private StateClassName() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper
 * JD-Core Version:    0.7.0.1
 */