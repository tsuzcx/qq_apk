import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class alxf
  implements beuq
{
  public void onResp(bevm parambevm)
  {
    Object localObject = (alxi)parambevm.jdField_a_of_type_Bevl.a();
    lbj.c("VideoFilterTools", "download file call back. file = " + ((alxi)localObject).a);
    if (parambevm.jdField_a_of_type_Int != 0)
    {
      lbj.c("VideoFilterTools", "download file faild. errcode = " + parambevm.b);
      return;
    }
    if (!((alxi)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
    {
      lbj.c("VideoFilterTools", "download file faild : md5 is not match.");
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    lbj.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = alxd.a();
      bhmi.a(parambevm.jdField_a_of_type_Bevl.c, (String)localObject, false);
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      return;
    }
    catch (IOException parambevm)
    {
      parambevm.printStackTrace();
      lbj.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxf
 * JD-Core Version:    0.7.0.1
 */