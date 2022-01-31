import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class ajsw
  implements baug
{
  ajsw(ajsv paramajsv) {}
  
  public void onResp(bavf parambavf)
  {
    Object localObject = (FilterDesc)parambavf.jdField_a_of_type_Bave.a();
    if (parambavf.jdField_a_of_type_Int != 0) {
      lek.c("VideoFilterTools", "download file failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
      {
        lek.c("VideoFilterTools", "download file failed: md5 is not match.");
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
        return;
      }
      lek.c("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = ajsv.b;
        bdhb.a(parambavf.jdField_a_of_type_Bave.c, (String)localObject, false);
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
        if ((ajsv.a(this.a).decrementAndGet() == 0) && (ajsv.a(this.a) != null))
        {
          ajsv.a(this.a).a(true);
          return;
        }
      }
      catch (IOException parambavf)
      {
        parambavf.printStackTrace();
        lek.c("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsw
 * JD-Core Version:    0.7.0.1
 */