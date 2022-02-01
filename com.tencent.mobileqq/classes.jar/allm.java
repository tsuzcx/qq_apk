import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class allm
  implements bdvw
{
  allm(alll paramalll) {}
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject = (FilterDesc)parambdwt.jdField_a_of_type_Bdws.a();
    if (parambdwt.jdField_a_of_type_Int != 0) {
      lbc.c("VideoFilterTools", "download file failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
      {
        lbc.c("VideoFilterTools", "download file failed: md5 is not match.");
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
        return;
      }
      lbc.c("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = alll.b;
        bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, (String)localObject, false);
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
        if ((alll.a(this.a).decrementAndGet() == 0) && (alll.a(this.a) != null))
        {
          alll.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambdwt)
      {
        parambdwt.printStackTrace();
        lbc.c("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allm
 * JD-Core Version:    0.7.0.1
 */