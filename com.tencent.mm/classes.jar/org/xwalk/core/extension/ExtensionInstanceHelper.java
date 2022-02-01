package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExtensionInstanceHelper
{
  XWalkExternalExtension mExtension;
  MessageHandler mHandler;
  int mId;
  private BindingObjectStore mStore;
  
  public ExtensionInstanceHelper(XWalkExternalExtension paramXWalkExternalExtension, int paramInt)
  {
    AppMethodBeat.i(155215);
    this.mId = paramInt;
    this.mExtension = paramXWalkExternalExtension;
    this.mHandler = new MessageHandler(this.mExtension.getMessageHandler());
    if (this.mExtension.isAutoJS()) {
      ReflectionHelper.registerHandlers(this.mExtension.getReflection(), this.mHandler, this.mExtension);
    }
    this.mStore = new BindingObjectStore(this.mHandler, this);
    AppMethodBeat.o(155215);
  }
  
  public boolean addBindingObject(String paramString, BindingObject paramBindingObject)
  {
    AppMethodBeat.i(155217);
    boolean bool = this.mStore.addBindingObject(paramString, paramBindingObject);
    AppMethodBeat.o(155217);
    return bool;
  }
  
  public BindingObject getBindingObject(String paramString)
  {
    AppMethodBeat.i(155216);
    paramString = this.mStore.getBindingObject(paramString);
    AppMethodBeat.o(155216);
    return paramString;
  }
  
  public XWalkExternalExtension getExtension()
  {
    return this.mExtension;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public Object handleMessage(String paramString)
  {
    AppMethodBeat.i(155219);
    paramString = new MessageInfo(this.mExtension, this.mId, paramString);
    paramString = this.mHandler.handleMessage(paramString);
    AppMethodBeat.o(155219);
    return paramString;
  }
  
  public Object handleMessage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155220);
    paramArrayOfByte = new MessageInfo(this.mExtension, this.mId, paramArrayOfByte);
    paramArrayOfByte = this.mHandler.handleMessage(paramArrayOfByte);
    AppMethodBeat.o(155220);
    return paramArrayOfByte;
  }
  
  public BindingObject removeBindingObject(String paramString)
  {
    AppMethodBeat.i(155218);
    paramString = this.mStore.removeBindingObject(paramString);
    AppMethodBeat.o(155218);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.ExtensionInstanceHelper
 * JD-Core Version:    0.7.0.1
 */