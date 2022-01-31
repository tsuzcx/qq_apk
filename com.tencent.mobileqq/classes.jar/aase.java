import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

class aase
  implements aasr
{
  aase(aasc paramaasc, aast paramaast, aasp paramaasp, String paramString, JSONObject paramJSONObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Aast.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Aast)
    {
      aast localaast2 = this.jdField_a_of_type_Aast;
      int i = localaast2.jdField_a_of_type_Int - 1;
      localaast2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Aasp.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Aast.jdField_a_of_type_Boolean) }));
      aasc.a(this.jdField_a_of_type_Aasc, false);
      if (aasc.a(this.jdField_a_of_type_Aasc))
      {
        aasc.b(this.jdField_a_of_type_Aasc, false);
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
        ArkAppCenter.a().postToMainThreadDelayed(new aasf(this), 5000L);
      }
      if (!this.jdField_a_of_type_Aast.jdField_a_of_type_Boolean)
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (!aasc.b(this.jdField_a_of_type_JavaLangString))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      return;
    }
    aasc.a(this.jdField_a_of_type_OrgJsonJSONObject);
    ArkAiDictMgr.a((QQAppInterface)aasc.a(this.jdField_a_of_type_Aasc).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aase
 * JD-Core Version:    0.7.0.1
 */