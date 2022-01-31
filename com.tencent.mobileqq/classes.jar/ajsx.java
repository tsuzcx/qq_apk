import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ajsx
  implements baug
{
  public void onResp(bavf parambavf)
  {
    Object localObject = (ajta)parambavf.jdField_a_of_type_Bave.a();
    lek.c("VideoFilterTools", "download file call back. file = " + ((ajta)localObject).a);
    if (parambavf.jdField_a_of_type_Int != 0)
    {
      lek.c("VideoFilterTools", "download file faild. errcode = " + parambavf.b);
      return;
    }
    if (!((ajta)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
    {
      lek.c("VideoFilterTools", "download file faild : md5 is not match.");
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    lek.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = ajsv.a();
      bdhb.a(parambavf.jdField_a_of_type_Bave.c, (String)localObject, false);
      bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      return;
    }
    catch (IOException parambavf)
    {
      parambavf.printStackTrace();
      lek.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsx
 * JD-Core Version:    0.7.0.1
 */