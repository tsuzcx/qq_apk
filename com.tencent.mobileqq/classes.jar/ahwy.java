import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ahwy
  implements aysc
{
  public void onResp(aysz paramaysz)
  {
    Object localObject = (ahxb)paramaysz.jdField_a_of_type_Aysy.a();
    lcg.c("VideoFilterTools", "download file call back. file = " + ((ahxb)localObject).a);
    if (paramaysz.jdField_a_of_type_Int != 0)
    {
      lcg.c("VideoFilterTools", "download file faild. errcode = " + paramaysz.b);
      return;
    }
    if (!((ahxb)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
    {
      lcg.c("VideoFilterTools", "download file faild : md5 is not match.");
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    lcg.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = ahww.a();
      bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, (String)localObject, false);
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      return;
    }
    catch (IOException paramaysz)
    {
      paramaysz.printStackTrace();
      lcg.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwy
 * JD-Core Version:    0.7.0.1
 */