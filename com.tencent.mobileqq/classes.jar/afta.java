import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class afta
  implements bapx
{
  afta(String paramString1, String paramString2) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      parambaqw = parambaqw.jdField_a_of_type_Baqv.c;
      String str1 = bdcs.c(parambaqw);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bdcs.a(parambaqw, str2, false);
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
        bdcs.d(parambaqw);
        if (!bool) {
          break label184;
        }
        bdiv.a(true);
        afsw.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      afsw.c = false;
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
      afsw.o += 1;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afta
 * JD-Core Version:    0.7.0.1
 */