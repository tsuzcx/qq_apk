import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class alax
  implements aklu
{
  alax(alap paramalap, int paramInt, String paramString, AppInterface paramAppInterface, File paramFile) {}
  
  public void a(boolean paramBoolean, aklt paramaklt)
  {
    paramaklt = akll.a().a(8, this.jdField_a_of_type_Int);
    Object localObject = new StringBuilder().append("downloadApolloRes onCheckFinish success:").append(paramBoolean).append(" downloadItem:");
    if (paramaklt == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("ApolloPluginRscLoader", 1, paramBoolean);
      localObject = alap.a(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramaklt == null)
    {
      this.jdField_a_of_type_Alap.a((String)localObject, 2, this.jdField_a_of_type_Int + " json里无此id");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramaklt);
    akln.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new alay(this, (String)localObject), localArrayList, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alax
 * JD-Core Version:    0.7.0.1
 */