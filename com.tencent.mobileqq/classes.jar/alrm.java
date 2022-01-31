import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class alrm
  implements alrx
{
  public alrm(ArkAiDictUpdateMgr.1 param1, amro paramamro, alrz paramalrz, amrc paramamrc) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { alrl.a(this.jdField_a_of_type_Amro) }));
      this.jdField_a_of_type_Alrz.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Alrz)
      {
        alrz localalrz2 = this.jdField_a_of_type_Alrz;
        int i = localalrz2.jdField_a_of_type_Int - 1;
        localalrz2.jdField_a_of_type_Int = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_Alrz.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, all success");
          alrl.a(this.jdField_a_of_type_Amrc);
          alrl.b(this.jdField_a_of_type_Amrc);
          alri.b((AppInterface)alrl.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            alrl.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (alrl.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              alrl.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
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
 * Qualified Name:     alrm
 * JD-Core Version:    0.7.0.1
 */