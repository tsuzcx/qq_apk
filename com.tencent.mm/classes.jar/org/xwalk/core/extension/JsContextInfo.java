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
    AppMethodBeat.i(86109);
    String str = this.targetClass.getSimpleName();
    AppMethodBeat.o(86109);
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
    AppMethodBeat.i(86107);
    String str = "Extension-" + this.extensionClient.getExtensionName();
    AppMethodBeat.o(86107);
    return str;
  }
  
  public ReflectionHelper getTargetReflect()
  {
    AppMethodBeat.i(86108);
    ReflectionHelper localReflectionHelper = this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
    AppMethodBeat.o(86108);
    return localReflectionHelper;
  }
  
  public void postMessage(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(86110);
    this.extensionClient.postMessage(this.extInstanceId, paramJSONObject.toString());
    AppMethodBeat.o(86110);
  }
  
  public void postMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86111);
    this.extensionClient.postBinaryMessage(this.extInstanceId, paramArrayOfByte);
    AppMethodBeat.o(86111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.xwalk.core.extension.JsContextInfo
 * JD-Core Version:    0.7.0.1
 */