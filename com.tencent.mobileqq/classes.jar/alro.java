import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.File;
import java.util.Locale;

class alro
  implements alry
{
  alro(alrm paramalrm, alsa paramalsa, alrw paramalrw, String paramString1, alry paramalry, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Alsa.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Alsa)
    {
      alsa localalsa2 = this.jdField_a_of_type_Alsa;
      int i = localalsa2.jdField_a_of_type_Int - 1;
      localalsa2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Alrw.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Alsa.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_Alsa.jdField_a_of_type_Boolean)
      {
        bbdj.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Alry.a(false);
        return;
      }
    }
    if (!alrm.a(alrj.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Alry.a(false);
      return;
    }
    this.jdField_a_of_type_Alry.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alro
 * JD-Core Version:    0.7.0.1
 */