import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class ajox
{
  private String a;
  private String b;
  
  public ajox(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.a = paramString2;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (TextUtils.isEmpty(paramString)) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte1.length == 0)) {}
    do
    {
      return false;
      try
      {
        paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bbca.decode(paramString.getBytes("UTF-8"), 0)));
        Signature localSignature = Signature.getInstance("SHA1WithRSA");
        localSignature.initVerify(paramString);
        localSignature.update(paramArrayOfByte1);
        boolean bool = localSignature.verify(paramArrayOfByte2);
        return bool;
      }
      catch (Throwable paramArrayOfByte1) {}
    } while (!QLog.isColorLevel());
    QLog.d("RSAVerify", 2, "verify failed");
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    try
    {
      if ((bbdj.a(this.a)) && (bbdj.a(this.b)))
      {
        byte[] arrayOfByte1 = bbdj.a(this.a);
        byte[] arrayOfByte2 = bbdj.a(this.b);
        if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0) || (arrayOfByte2 == null) || (arrayOfByte2.length == 0)) {
          break label104;
        }
        if (paramInt == 0) {
          return a(arrayOfByte1, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq8i/7++SDj/syS1oKlYdNJXuRQo1IxcizuFBwq9Ohi9q9u0GInkVFi/3mRU6opILNqNVUoVncxnvfrBrrzxXgPkOow4TFTfo0f2wQRxsuVud/Fjtiz256JKFvIXHdTJ+ZAFIHLtcJMrDhvTUgIIfv5uDZIXARy2KFSzUhqoEwZt3I3Uv9beVecgYofjQ/N/YtG2uWb5dpHMXfsq6JpEpfKxbbFPYJLnrMol0ngsgDrF1h3C28R6l28jFL1nzkxBNt1dIrmitveA0dXbZhYWpRDjg7Ywwt96c1Qq85rs+TL6pNKAYt7aJy/6+PGfMcbkRrtsL72eokicKHnMKVC84fQIDAQAB", arrayOfByte2);
        }
        if (1 != paramInt) {
          break label102;
        }
        bool = a(arrayOfByte1, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5ZRiTq5kd+Bsb7Rsvrk/8kF3jRPEAln7kLVAKRi4+jb/gdKEAI9y5jhuyobFq9jLMqKCYKJKb8v/KaGjX0LFZg5+FnC/duF829s7lWPKXNggne+hQOwhWFiamCwf8r8Hzi3YmrKPR4iA/bJUwTbey9T0hKpYbB9QA7IpIQAmGd4cn1ylq/2vblqNwpVV53+SCSg5XRqIXwPYRL9siMZEJAtXbjbpHw8B18zYUGlh2XRJssZyNtgtHOQIvwmdUOGTVRTt7sBZy7adUnq3cpH6/qpdLlAVUAFq/WLwUHNviC+uW47884PSdwqHg8NdeIhitfbcdtOmCNt3OJUvf91L/QIDAQAB", arrayOfByte2);
        return bool;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return false;
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    bool = false;
    label102:
    return bool;
    label104:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajox
 * JD-Core Version:    0.7.0.1
 */