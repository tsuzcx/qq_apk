import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

class aald
  implements aalq
{
  aald(aalb paramaalb, aals paramaals, aalo paramaalo, String paramString, JSONObject paramJSONObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Aals.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Aals)
    {
      aals localaals2 = this.jdField_a_of_type_Aals;
      int i = localaals2.jdField_a_of_type_Int - 1;
      localaals2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Aalo.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Aals.jdField_a_of_type_Boolean) }));
      aalb.a(this.jdField_a_of_type_Aalb, false);
      if (aalb.a(this.jdField_a_of_type_Aalb))
      {
        aalb.b(this.jdField_a_of_type_Aalb, false);
        ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
        ArkAppCenter.a().postToMainThreadDelayed(new aale(this), 5000L);
      }
      if (!this.jdField_a_of_type_Aals.jdField_a_of_type_Boolean)
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (!aalb.b(this.jdField_a_of_type_JavaLangString))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      return;
    }
    aalb.a(this.jdField_a_of_type_OrgJsonJSONObject);
    ArkAiDictMgr.a((QQAppInterface)aalb.a(this.jdField_a_of_type_Aalb).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aald
 * JD-Core Version:    0.7.0.1
 */