package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindingObject
{
  private String TAG;
  protected MessageHandler mHandler;
  protected ExtensionInstanceHelper mInstanceHelper;
  protected String mObjectId;
  
  public BindingObject()
  {
    AppMethodBeat.i(155183);
    this.TAG = "BindingObject";
    this.mHandler = new MessageHandler();
    AppMethodBeat.o(155183);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(155184);
    paramMessageInfo = this.mHandler.handleMessage(paramMessageInfo);
    AppMethodBeat.o(155184);
    return paramMessageInfo;
  }
  
  public void initBindingInfo(String paramString, ExtensionInstanceHelper paramExtensionInstanceHelper)
  {
    this.mObjectId = paramString;
    this.mInstanceHelper = paramExtensionInstanceHelper;
  }
  
  public void onDestroy() {}
  
  public void onJsBound() {}
  
  public void onJsDestroyed() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObject
 * JD-Core Version:    0.7.0.1
 */