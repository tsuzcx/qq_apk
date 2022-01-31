import com.tencent.qphone.base.util.QLog;

public class amas
{
  protected String a = "";
  
  public amas() {}
  
  public amas(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public amat a()
  {
    if ((this instanceof amat)) {
      return (amat)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public amau a()
  {
    if ((this instanceof amau)) {
      return (amau)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public amav a()
  {
    if ((this instanceof amav)) {
      return (amav)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordSDKShareConfBean object");
    return null;
  }
  
  public amaw a()
  {
    if ((this instanceof amaw)) {
      return (amaw)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public amax a()
  {
    if ((this instanceof amax)) {
      return (amax)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkPlatformConfigBean object");
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amas
 * JD-Core Version:    0.7.0.1
 */