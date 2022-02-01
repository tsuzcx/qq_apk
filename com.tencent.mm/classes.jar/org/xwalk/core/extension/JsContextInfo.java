package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class JsContextInfo
{
  private int extInstanceId;
  private XWalkExternalExtension extensionClient;
  private String objectId;
  private Class<?> targetClass;
  
  JsContextInfo(int paramInt, XWalkExternalExtension paramXWalkExternalExtension, Class<?> paramClass, String paramString)
  {
    this.extensionClient = paramXWalkExternalExtension;
    this.extInstanceId = paramInt;
    this.objectId = paramString;
    this.targetClass = paramClass;
  }
  
  public String getConstructorName()
  {
    AppMethodBeat.i(155223);
    String str = this.targetClass.getSimpleName();
    AppMethodBeat.o(155223);
    return str;
  }
  
  public XWalkExternalExtension getExtensionClient()
  {
    return this.extensionClient;
  }
  
  public String getObjectId()
  {
    return this.objectId;
  }
  
  public String getTag()
  {
    AppMethodBeat.i(155221);
    String str = "Extension-" + this.extensionClient.getExtensionName();
    AppMethodBeat.o(155221);
    return str;
  }
  
  public ReflectionHelper getTargetReflect()
  {
    AppMethodBeat.i(155222);
    ReflectionHelper localReflectionHelper = this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
    AppMethodBeat.o(155222);
    return localReflectionHelper;
  }
  
  public void postMessage(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(155224);
    this.extensionClient.postMessage(this.extInstanceId, paramJSONObject.toString());
    AppMethodBeat.o(155224);
  }
  
  public void postMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155225);
    this.extensionClient.postBinaryMessage(this.extInstanceId, paramArrayOfByte);
    AppMethodBeat.o(155225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.JsContextInfo
 * JD-Core Version:    0.7.0.1
 */