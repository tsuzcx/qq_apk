import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class alnu
  extends alnw
  implements alny
{
  public alnu(alnz paramalnz)
  {
    super(null, paramalnz);
    this.jdField_a_of_type_Alny = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = aliu.k;
    return str + paramString + ".zip";
  }
  
  public void a(alnw paramalnw, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    beae localbeae = new beae(paramString1, new File(paramString2));
    localbeae.p = true;
    localbeae.n = true;
    localbeae.f = "apollo_gif";
    localbeae.b = 1;
    localbeae.q = true;
    localbeae.r = true;
    localbeae.a(new alnv(this, paramString1, paramString2, paramString3));
    paramalnw = BaseApplicationImpl.getApplication();
    if (paramalnw != null)
    {
      paramalnw = paramalnw.getRuntime();
      if (!(paramalnw instanceof QQAppInterface)) {}
    }
    for (paramalnw = (QQAppInterface)paramalnw;; paramalnw = null)
    {
      if (paramalnw != null)
      {
        paramalnw = (beag)paramalnw.getManager(47);
        if (paramalnw != null)
        {
          paramalnw = paramalnw.a(3);
          if (paramalnw != null) {
            paramalnw.a(localbeae, localbeae.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbeae));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnu
 * JD-Core Version:    0.7.0.1
 */