import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class alcz
  implements aldk
{
  public alcz(ArkAiDictUpdateMgr.1 param1, ambr paramambr, aldm paramaldm, ambf paramambf) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { alcy.a(this.jdField_a_of_type_Ambr) }));
      this.jdField_a_of_type_Aldm.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Aldm)
      {
        aldm localaldm2 = this.jdField_a_of_type_Aldm;
        int i = localaldm2.jdField_a_of_type_Int - 1;
        localaldm2.jdField_a_of_type_Int = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_Aldm.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, all success");
          alcy.a(this.jdField_a_of_type_Ambf);
          alcy.b(this.jdField_a_of_type_Ambf);
          alcv.b((AppInterface)alcy.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            alcy.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (alcy.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              alcy.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
              ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
              ArkAppCenter.a().postToMainThreadDelayed(new ArkAiDictUpdateMgr.1.1.1(this), 5000L);
            }
            return;
          }
          finally {}
        }
      }
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, one or more tasks failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alcz
 * JD-Core Version:    0.7.0.1
 */