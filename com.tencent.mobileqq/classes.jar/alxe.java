import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class alxe
  implements beuq
{
  alxe(alxd paramalxd) {}
  
  public void onResp(bevm parambevm)
  {
    Object localObject = (FilterDesc)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int != 0) {
      lbj.c("VideoFilterTools", "download file failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
      {
        lbj.c("VideoFilterTools", "download file failed: md5 is not match.");
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
        return;
      }
      lbj.c("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = alxd.b;
        bhmi.a(parambevm.jdField_a_of_type_Bevl.c, (String)localObject, false);
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
        if ((alxd.a(this.a).decrementAndGet() == 0) && (alxd.a(this.a) != null))
        {
          alxd.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambevm)
      {
        parambevm.printStackTrace();
        lbj.c("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxe
 * JD-Core Version:    0.7.0.1
 */