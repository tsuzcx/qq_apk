import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class adlp
  implements axrt
{
  adlp(String paramString1, String paramString2) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = paramaxsq.jdField_a_of_type_Axsp.c;
      String str1 = bace.c(paramaxsq);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bace.a(paramaxsq, str2, false);
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
        bace.d(paramaxsq);
        if (!bool) {
          break label184;
        }
        baig.a(true);
        adll.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      adll.c = false;
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
      adll.o += 1;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adlp
 * JD-Core Version:    0.7.0.1
 */