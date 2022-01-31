import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class alfo
  implements akqe
{
  alfo(alfe paramalfe, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<akqb> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = alfe.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Alfe.a(paramString1, 0, this.jdField_a_of_type_Int + alud.a(2131700878));
        return;
      }
      this.jdField_a_of_type_Alfe.a(paramString1, 2, this.jdField_a_of_type_Int + alud.a(2131700877));
      return;
    }
    this.jdField_a_of_type_Alfe.a(paramString1, 2, this.jdField_a_of_type_Int + alud.a(2131700872));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfo
 * JD-Core Version:    0.7.0.1
 */