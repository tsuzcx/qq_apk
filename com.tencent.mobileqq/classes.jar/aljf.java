import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class aljf
  extends aljh
  implements aljj
{
  public aljf(aljk paramaljk)
  {
    super(null, paramaljk);
    this.jdField_a_of_type_Aljj = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = alef.k;
    return str + paramString + ".zip";
  }
  
  public void a(aljh paramaljh, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bdvv localbdvv = new bdvv(paramString1, new File(paramString2));
    localbdvv.p = true;
    localbdvv.n = true;
    localbdvv.f = "apollo_gif";
    localbdvv.b = 1;
    localbdvv.q = true;
    localbdvv.r = true;
    localbdvv.a(new aljg(this, paramString1, paramString2, paramString3));
    paramaljh = BaseApplicationImpl.getApplication();
    if (paramaljh != null)
    {
      paramaljh = paramaljh.getRuntime();
      if (!(paramaljh instanceof QQAppInterface)) {}
    }
    for (paramaljh = (QQAppInterface)paramaljh;; paramaljh = null)
    {
      if (paramaljh != null)
      {
        paramaljh = (bdvx)paramaljh.getManager(47);
        if (paramaljh != null)
        {
          paramaljh = paramaljh.a(3);
          if (paramaljh != null) {
            paramaljh.a(localbdvv, localbdvv.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbdvv));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljf
 * JD-Core Version:    0.7.0.1
 */