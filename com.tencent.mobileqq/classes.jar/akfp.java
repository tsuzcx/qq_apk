import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class akfp
  extends ajtd
{
  public static String a = "Add_friend_to_desktop|";
  public static String b = "Click_desktop_friend|";
  private String c = "FuMeiTiCeSu|";
  
  public akfp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "PLUG|" + paramString1 + "|" + paramString2 + "|internal|" + paramString3 + "|PB|" + paramString4 + "||";
  }
  
  public void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
      localToServiceMsg.extraData.putAll(paramBundle);
      super.send(localToServiceMsg);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
    localToServiceMsg.extraData.putStringArray("data", paramArrayOfString);
    super.send(localToServiceMsg);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfp
 * JD-Core Version:    0.7.0.1
 */