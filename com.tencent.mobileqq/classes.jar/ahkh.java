import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class ahkh
  implements axrt
{
  ahkh(ahkg paramahkg) {}
  
  public void onResp(axsq paramaxsq)
  {
    Object localObject = (FilterDesc)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int != 0) {
      krx.c("VideoFilterTools", "download file failed. errorCode: " + paramaxsq.b + ", errorMsg: " + paramaxsq.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
      {
        krx.c("VideoFilterTools", "download file failed: md5 is not match.");
        bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
        return;
      }
      krx.c("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = ahkg.b;
        bace.a(paramaxsq.jdField_a_of_type_Axsp.c, (String)localObject, false);
        bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
        if ((ahkg.a(this.a).decrementAndGet() == 0) && (ahkg.a(this.a) != null))
        {
          ahkg.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramaxsq)
      {
        paramaxsq.printStackTrace();
        krx.c("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahkh
 * JD-Core Version:    0.7.0.1
 */