import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class afxp
  implements baug
{
  afxp(String paramString1, String paramString2) {}
  
  public void onResp(bavf parambavf)
  {
    if (parambavf.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      parambavf = parambavf.jdField_a_of_type_Bave.c;
      String str1 = bdhb.c(parambavf);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bdhb.a(parambavf, str2, false);
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
        bdhb.d(parambavf);
        if (!bool) {
          break label184;
        }
        bdne.a(true);
        afxl.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      afxl.c = false;
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
      afxl.o += 1;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxp
 * JD-Core Version:    0.7.0.1
 */