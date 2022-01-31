import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ahki
  implements axrt
{
  public void onResp(axsq paramaxsq)
  {
    Object localObject = (ahkl)paramaxsq.jdField_a_of_type_Axsp.a();
    krx.c("VideoFilterTools", "download file call back. file = " + ((ahkl)localObject).a);
    if (paramaxsq.jdField_a_of_type_Int != 0)
    {
      krx.c("VideoFilterTools", "download file faild. errcode = " + paramaxsq.b);
      return;
    }
    if (!((ahkl)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
    {
      krx.c("VideoFilterTools", "download file faild : md5 is not match.");
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    krx.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = ahkg.a();
      bace.a(paramaxsq.jdField_a_of_type_Axsp.c, (String)localObject, false);
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      return;
    }
    catch (IOException paramaxsq)
    {
      paramaxsq.printStackTrace();
      krx.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */