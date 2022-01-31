package org.xwalk.core.extension;

public class BindingObject
{
  private String TAG = "BindingObject";
  protected MessageHandler mHandler = new MessageHandler();
  protected ExtensionInstanceHelper mInstanceHelper;
  protected String mObjectId;
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    return this.mHandler.handleMessage(paramMessageInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObject
 * JD-Core Version:    0.7.0.1
 */