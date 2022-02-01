package QMF_PROTOCAL;

import java.io.Serializable;

public final class eGetConfigScene
  implements Serializable
{
  public static final eGetConfigScene SQGetConfigApnChanged = new eGetConfigScene(5, 101, "SQGetConfigApnChanged");
  public static final eGetConfigScene SQGetConfigAppStart;
  public static final eGetConfigScene SQGetConfigAppTimer = new eGetConfigScene(6, 102, "SQGetConfigAppTimer");
  public static final eGetConfigScene SQGetConfigFromBackToFront = new eGetConfigScene(7, 103, "SQGetConfigFromBackToFront");
  public static final eGetConfigScene SQGetConfigRecvDelPush = new eGetConfigScene(8, 104, "SQGetConfigRecvDelPush");
  public static final eGetConfigScene SceneAppActivate;
  public static final eGetConfigScene SceneAppRun;
  public static final eGetConfigScene SceneNetworkChanged;
  public static final eGetConfigScene SceneTimeout;
  public static final int _SQGetConfigApnChanged = 101;
  public static final int _SQGetConfigAppStart = 100;
  public static final int _SQGetConfigAppTimer = 102;
  public static final int _SQGetConfigFromBackToFront = 103;
  public static final int _SQGetConfigRecvDelPush = 104;
  public static final int _SceneAppActivate = 1;
  public static final int _SceneAppRun = 0;
  public static final int _SceneNetworkChanged = 3;
  public static final int _SceneTimeout = 2;
  private static eGetConfigScene[] __values = new eGetConfigScene[8];
  private String __T = new String();
  private int __value;
  
  static
  {
    SceneAppRun = new eGetConfigScene(0, 0, "SceneAppRun");
    SceneAppActivate = new eGetConfigScene(1, 1, "SceneAppActivate");
    SceneTimeout = new eGetConfigScene(2, 2, "SceneTimeout");
    SceneNetworkChanged = new eGetConfigScene(3, 3, "SceneNetworkChanged");
    SQGetConfigAppStart = new eGetConfigScene(4, 100, "SQGetConfigAppStart");
  }
  
  private eGetConfigScene(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eGetConfigScene convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eGetConfigScene[] arrayOfeGetConfigScene = __values;
      if (i >= arrayOfeGetConfigScene.length) {
        break;
      }
      if (arrayOfeGetConfigScene[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eGetConfigScene convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eGetConfigScene[] arrayOfeGetConfigScene = __values;
      if (i >= arrayOfeGetConfigScene.length) {
        break;
      }
      if (arrayOfeGetConfigScene[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QMF_PROTOCAL.eGetConfigScene
 * JD-Core Version:    0.7.0.1
 */