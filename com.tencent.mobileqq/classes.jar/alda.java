import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.File;
import java.util.Locale;

class alda
  implements aldk
{
  alda(alcy paramalcy, aldm paramaldm, aldi paramaldi, String paramString1, aldk paramaldk, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Aldm.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Aldm)
    {
      aldm localaldm2 = this.jdField_a_of_type_Aldm;
      int i = localaldm2.jdField_a_of_type_Int - 1;
      localaldm2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Aldi.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Aldm.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_Aldm.jdField_a_of_type_Boolean)
      {
        bace.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aldk.a(false);
        return;
      }
    }
    if (!alcy.a(alcv.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Aldk.a(false);
      return;
    }
    this.jdField_a_of_type_Aldk.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alda
 * JD-Core Version:    0.7.0.1
 */