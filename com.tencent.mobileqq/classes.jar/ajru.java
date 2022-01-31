import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class ajru
  extends ajrw
  implements ajry
{
  public ajru(ajrz paramajrz)
  {
    super(null, paramajrz);
    this.jdField_a_of_type_Ajry = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = ajmu.k;
    return str + paramString + ".zip";
  }
  
  public void a(ajrw paramajrw, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bbwg localbbwg = new bbwg(paramString1, new File(paramString2));
    localbbwg.p = true;
    localbbwg.n = true;
    localbbwg.f = "apollo_gif";
    localbbwg.b = 1;
    localbbwg.q = true;
    localbbwg.r = true;
    localbbwg.a(new ajrv(this, paramString1, paramString2, paramString3));
    paramajrw = BaseApplicationImpl.getApplication();
    if (paramajrw != null)
    {
      paramajrw = paramajrw.getRuntime();
      if (!(paramajrw instanceof QQAppInterface)) {}
    }
    for (paramajrw = (QQAppInterface)paramajrw;; paramajrw = null)
    {
      if (paramajrw != null)
      {
        paramajrw = (bbwi)paramajrw.getManager(47);
        if (paramajrw != null)
        {
          paramajrw = paramajrw.a(3);
          if (paramajrw != null) {
            paramajrw.a(localbbwg, localbbwg.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbbwg));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajru
 * JD-Core Version:    0.7.0.1
 */