import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.base.BspatchUtil;
import java.io.File;

class aasl
  implements aasq
{
  aasl(aasc paramaasc, aasp paramaasp1, aasp paramaasp2, String paramString, aasr paramaasr) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aasr.a(false);
      return;
      if (!aasc.b(paramArrayOfByte, this.jdField_a_of_type_Aasp.f))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.b, this.jdField_a_of_type_Aasp.f }));
      }
      else
      {
        String str1 = aasc.a(this.b.jdField_a_of_type_JavaLangString);
        if (!new File(str1).isFile())
        {
          ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.d });
          if (!aasc.a(paramArrayOfByte, str2))
          {
            ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, str2 }));
          }
          else
          {
            if (BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString }))) {
              break;
            }
            ArkAppCenter.b("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aasp.f }));
          }
        }
      }
    }
    this.jdField_a_of_type_Aasr.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasl
 * JD-Core Version:    0.7.0.1
 */