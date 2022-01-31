import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ahxa
  implements aysa
{
  public void onResp(aysx paramaysx)
  {
    Object localObject = (ahxd)paramaysx.jdField_a_of_type_Aysw.a();
    lcl.c("VideoFilterTools", "download file call back. file = " + ((ahxd)localObject).a);
    if (paramaysx.jdField_a_of_type_Int != 0)
    {
      lcl.c("VideoFilterTools", "download file faild. errcode = " + paramaysx.b);
      return;
    }
    if (!((ahxd)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
    {
      lcl.c("VideoFilterTools", "download file faild : md5 is not match.");
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    lcl.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = ahwy.a();
      bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, (String)localObject, false);
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      return;
    }
    catch (IOException paramaysx)
    {
      paramaysx.printStackTrace();
      lcl.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxa
 * JD-Core Version:    0.7.0.1
 */