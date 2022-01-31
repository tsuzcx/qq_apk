import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ajjn
  implements aiuk
{
  ajjn(ajjf paramajjf, int paramInt, String paramString, AppInterface paramAppInterface, File paramFile) {}
  
  public void a(boolean paramBoolean, aiuj paramaiuj)
  {
    paramaiuj = aiub.a().a(8, this.jdField_a_of_type_Int);
    Object localObject = new StringBuilder().append("downloadApolloRes onCheckFinish success:").append(paramBoolean).append(" downloadItem:");
    if (paramaiuj == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("ApolloPluginRscLoader", 1, paramBoolean);
      localObject = ajjf.a(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramaiuj == null)
    {
      this.jdField_a_of_type_Ajjf.a((String)localObject, 2, this.jdField_a_of_type_Int + " json里无此id");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramaiuj);
    aiud.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ajjo(this, (String)localObject), localArrayList, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjn
 * JD-Core Version:    0.7.0.1
 */