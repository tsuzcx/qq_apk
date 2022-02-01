package org.xwalk.core;

public abstract class XWalkLogMessageListener
{
  public static final String TAG = "XWalkLogMessageListener";
  private Object bridge;
  
  public XWalkLogMessageListener()
  {
    reflectionInit();
  }
  
  private void reflectionInit()
  {
    Object localObject = XWalkStandAloneChannel.getInstance().getBridgeClass("XWalkLogMessageListenerBridge");
    if (localObject == null)
    {
      Log.e("XWalkLogMessageListener", "reflectionInit error, class not found");
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
      Log.e("XWalkLogMessageListener", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public abstract void onLogMessage(int paramInt1, String paramString1, int paramInt2, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkLogMessageListener
 * JD-Core Version:    0.7.0.1
 */