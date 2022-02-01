import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

final class ahnx
  implements beuq
{
  ahnx(String paramString1, String paramString2) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      parambevm = parambevm.jdField_a_of_type_Bevl.c;
      String str1 = bhmi.c(parambevm);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bhmi.a(parambevm, str2, false);
          brgs.a(str2);
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
        bhmi.d(parambevm);
        if (!bool) {
          break label189;
        }
        bhsi.a(true);
        ahnt.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      ahnt.c = false;
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
      ahnt.o += 1;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnx
 * JD-Core Version:    0.7.0.1
 */