import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class ajoi
  implements bapx
{
  public void onResp(baqw parambaqw)
  {
    Object localObject = (ajol)parambaqw.jdField_a_of_type_Baqv.a();
    lek.c("VideoFilterTools", "download file call back. file = " + ((ajol)localObject).a);
    if (parambaqw.jdField_a_of_type_Int != 0)
    {
      lek.c("VideoFilterTools", "download file faild. errcode = " + parambaqw.b);
      return;
    }
    if (!((ajol)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
    {
      lek.c("VideoFilterTools", "download file faild : md5 is not match.");
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    lek.c("VideoFilterTools", "download file successed.");
    try
    {
      localObject = ajog.a();
      bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, (String)localObject, false);
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      return;
    }
    catch (IOException parambaqw)
    {
      parambaqw.printStackTrace();
      lek.c("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoi
 * JD-Core Version:    0.7.0.1
 */