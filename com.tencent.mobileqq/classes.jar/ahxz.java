import com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory;
import com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory.DelegateSSLSocket;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public class ahxz
  extends NoSSLv3SocketFactory.DelegateSSLSocket
{
  private ahxz(NoSSLv3SocketFactory paramNoSSLv3SocketFactory, SSLSocket paramSSLSocket)
  {
    super(paramNoSSLv3SocketFactory, paramSSLSocket);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      arrayOfString = paramArrayOfString;
      if (paramArrayOfString.length == 1)
      {
        arrayOfString = paramArrayOfString;
        if ("SSLv3".equals(paramArrayOfString[0]))
        {
          paramArrayOfString = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
          if (paramArrayOfString.size() <= 1) {
            break label101;
          }
          paramArrayOfString.remove("SSLv3");
          QLog.i("setEnabledProtocols", 1, "Removed SSLv3 from enabled protocols");
        }
      }
    }
    for (;;)
    {
      arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
      if (arrayOfString != null) {
        super.setEnabledProtocols(arrayOfString);
      }
      return;
      label101:
      QLog.i("setEnabledProtocols", 1, "SSL stuck with protocol available for " + String.valueOf(paramArrayOfString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahxz
 * JD-Core Version:    0.7.0.1
 */