import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class adwn
  implements aysc
{
  adwn(String paramString1, String paramString2) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = paramaysz.jdField_a_of_type_Aysy.c;
      String str1 = bbdx.c(paramaysz);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bbdx.a(paramaysz, str2, false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label78:
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but unzip is failed");
            }
            bool = false;
          }
        }
        bbdx.d(paramaysz);
        if (!bool) {
          break label184;
        }
        bbkb.a(true);
        adwj.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      adwj.c = false;
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
      break label78;
      label184:
      adwj.o += 1;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwn
 * JD-Core Version:    0.7.0.1
 */