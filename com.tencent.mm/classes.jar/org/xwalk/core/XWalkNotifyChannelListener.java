package org.xwalk.core;

public abstract class XWalkNotifyChannelListener
{
  private static final String TAG = "XWalkNotifyChannelListener";
  private Object bridge;
  
  public XWalkNotifyChannelListener()
  {
    reflectionInit();
  }
  
  private void reflectionInit()
  {
    Object localObject = XWalkStandAloneChannel.getInstance().getBridgeClass("XWalkNotifyChannelListenerBridge");
    if (localObject == null)
    {
      Log.e("XWalkNotifyChannelListener", "reflectionInit error, class not found");
      return;
    }
    localObject = new ReflectConstructor((Class)localObject, new Class[] { Object.class });
    try
    {
      this.bridge = ((ReflectConstructor)localObject).newInstance(new Object[] { this });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkNotifyChannelListener", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public abstract void onNotifyCallBackChannel(int paramInt, Object[] paramArrayOfObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkNotifyChannelListener
 * JD-Core Version:    0.7.0.1
 */