import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.base.BspatchUtil;
import java.io.File;

class alru
  implements alrx
{
  alru(alrm paramalrm, alrw paramalrw1, String paramString1, alrw paramalrw2, String paramString2, alry paramalry) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.jdField_b_of_type_JavaLangString }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Alry.a(false);
      return;
      if (!alrm.b(paramArrayOfByte, this.jdField_a_of_type_Alrw.f))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Alrw.f }));
      }
      else
      {
        String str1 = alrm.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Alrw.jdField_a_of_type_JavaLangString);
        if (!new File(str1).isFile())
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Alrw.d });
          if (!alrm.a(paramArrayOfByte, str2))
          {
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, str2 }));
          }
          else
          {
            if (BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString }))) {
              break;
            }
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alrw.f }));
          }
        }
      }
    }
    this.jdField_a_of_type_Alry.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alru
 * JD-Core Version:    0.7.0.1
 */