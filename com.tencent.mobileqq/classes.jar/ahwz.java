import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class ahwz
  implements aysa
{
  ahwz(ahwy paramahwy) {}
  
  public void onResp(aysx paramaysx)
  {
    Object localObject = (FilterDesc)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int != 0) {
      lcl.c("VideoFilterTools", "download file failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
      {
        lcl.c("VideoFilterTools", "download file failed: md5 is not match.");
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
        return;
      }
      lcl.c("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = ahwy.b;
        bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, (String)localObject, false);
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
        if ((ahwy.a(this.a).decrementAndGet() == 0) && (ahwy.a(this.a) != null))
        {
          ahwy.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramaysx)
      {
        paramaysx.printStackTrace();
        lcl.c("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwz
 * JD-Core Version:    0.7.0.1
 */