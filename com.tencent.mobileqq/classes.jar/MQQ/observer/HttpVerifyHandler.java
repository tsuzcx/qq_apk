package mqq.observer;

import java.util.HashMap;

public abstract interface HttpVerifyHandler
{
  public abstract void cancelVerifyCode(String paramString, HashMap paramHashMap);
  
  public abstract void refreVerifyCode(String paramString, HashMap paramHashMap);
  
  public abstract void submitVerifyCode(String paramString1, HashMap paramHashMap, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.observer.HttpVerifyHandler
 * JD-Core Version:    0.7.0.1
 */