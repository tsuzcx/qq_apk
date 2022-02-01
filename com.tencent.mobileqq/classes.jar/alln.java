import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class alln
  implements bdvw
{
  public void onResp(bdwt parambdwt)
  {
    Object localObject = (allq)parambdwt.jdField_a_of_type_Bdws.a();
    lbc.c("VideoFilterTools", "download file call back. file = " + ((allq)localObject).a);
    if (parambdwt.jdField_a_of_type_Int != 0)
    {
      lbc.c("VideoFilterTools", "download file faild. errcode = " + parambdwt.b);
      return;
    }
    if (!((allq)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
    {
      lbc.c("VideoFilterTools", "download file faild : md5 is not match.");
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    lbc.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = alll.a();
      bgmg.a(parambdwt.jdField_a_of_type_Bdws.c, (String)localObject, false);
      bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      return;
    }
    catch (IOException parambdwt)
    {
      parambdwt.printStackTrace();
      lbc.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alln
 * JD-Core Version:    0.7.0.1
 */