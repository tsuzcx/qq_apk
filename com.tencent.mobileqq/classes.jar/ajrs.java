import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class ajrs
  extends ajru
  implements ajrw
{
  public ajrs(ajrx paramajrx)
  {
    super(null, paramajrx);
    this.jdField_a_of_type_Ajrw = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = ajms.k;
    return str + paramString + ".zip";
  }
  
  public void a(ajru paramajru, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bbwu localbbwu = new bbwu(paramString1, new File(paramString2));
    localbbwu.p = true;
    localbbwu.n = true;
    localbbwu.f = "apollo_gif";
    localbbwu.b = 1;
    localbbwu.q = true;
    localbbwu.r = true;
    localbbwu.a(new ajrt(this, paramString1, paramString2, paramString3));
    paramajru = BaseApplicationImpl.getApplication();
    if (paramajru != null)
    {
      paramajru = paramajru.getRuntime();
      if (!(paramajru instanceof QQAppInterface)) {}
    }
    for (paramajru = (QQAppInterface)paramajru;; paramajru = null)
    {
      if (paramajru != null)
      {
        paramajru = (bbww)paramajru.getManager(47);
        if (paramajru != null)
        {
          paramajru = paramajru.a(3);
          if (paramajru != null) {
            paramajru.a(localbbwu, localbbwu.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbbwu));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajrs
 * JD-Core Version:    0.7.0.1
 */