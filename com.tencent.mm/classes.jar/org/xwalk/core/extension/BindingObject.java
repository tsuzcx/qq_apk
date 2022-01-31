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
    AppMethodBeat.i(86069);
    this.TAG = "BindingObject";
    this.mHandler = new MessageHandler();
    AppMethodBeat.o(86069);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    AppMethodBeat.i(86070);
    paramMessageInfo = this.mHandler.handleMessage(paramMessageInfo);
    AppMethodBeat.o(86070);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObject
 * JD-Core Version:    0.7.0.1
 */