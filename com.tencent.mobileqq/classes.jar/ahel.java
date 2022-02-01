import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class ahel
  implements bdvw
{
  ahel(String paramString1, String paramString2) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      parambdwt = parambdwt.jdField_a_of_type_Bdws.c;
      String str1 = bgmg.c(parambdwt);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bgmg.a(parambdwt, str2, false);
          bqfh.a(str2);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label83:
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but unzip is failed");
            }
            bool = false;
          }
        }
        bgmg.d(parambdwt);
        if (!bool) {
          break label189;
        }
        bgsg.a(true);
        aheh.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      aheh.c = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but md5 is mismatched");
      }
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp failed ");
      }
      bool = false;
      break label83;
      label189:
      aheh.o += 1;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahel
 * JD-Core Version:    0.7.0.1
 */