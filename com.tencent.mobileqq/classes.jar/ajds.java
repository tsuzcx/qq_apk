import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class ajds
  extends ajdu
  implements ajdw
{
  public ajds(ajdx paramajdx)
  {
    super(null, paramajdx);
    this.jdField_a_of_type_Ajdw = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = aiys.k;
    return str + paramString + ".zip";
  }
  
  public void a(ajdu paramajdu, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    batm localbatm = new batm(paramString1, new File(paramString2));
    localbatm.p = true;
    localbatm.n = true;
    localbatm.f = "apollo_gif";
    localbatm.b = 1;
    localbatm.q = true;
    localbatm.r = true;
    localbatm.a(new ajdt(this, paramString1, paramString2, paramString3));
    paramajdu = BaseApplicationImpl.getApplication();
    if (paramajdu != null)
    {
      paramajdu = paramajdu.getRuntime();
      if (!(paramajdu instanceof QQAppInterface)) {}
    }
    for (paramajdu = (QQAppInterface)paramajdu;; paramajdu = null)
    {
      if (paramajdu != null)
      {
        paramajdu = (bato)paramajdu.getManager(47);
        if (paramajdu != null)
        {
          paramajdu = paramajdu.a(3);
          if (paramajdu != null) {
            paramajdu.a(localbatm, localbatm.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbatm));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */