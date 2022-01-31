import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

class aayy
  implements aazl
{
  aayy(aayw paramaayw, aazn paramaazn, aazj paramaazj, String paramString, JSONObject paramJSONObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Aazn.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Aazn)
    {
      aazn localaazn2 = this.jdField_a_of_type_Aazn;
      int i = localaazn2.jdField_a_of_type_Int - 1;
      localaazn2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Aazj.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Aazn.jdField_a_of_type_Boolean) }));
      aayw.a(this.jdField_a_of_type_Aayw, false);
      if (aayw.a(this.jdField_a_of_type_Aayw))
      {
        aayw.b(this.jdField_a_of_type_Aayw, false);
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
        ArkAppCenter.a().postToMainThreadDelayed(new aayz(this), 5000L);
      }
      if (!this.jdField_a_of_type_Aazn.jdField_a_of_type_Boolean)
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (!aayw.b(this.jdField_a_of_type_JavaLangString))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      return;
    }
    aayw.a(this.jdField_a_of_type_OrgJsonJSONObject);
    ArkAiDictMgr.a((QQAppInterface)aayw.a(this.jdField_a_of_type_Aayw).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayy
 * JD-Core Version:    0.7.0.1
 */