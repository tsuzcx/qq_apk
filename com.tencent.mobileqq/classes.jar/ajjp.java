import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ajjp
  implements aiuf
{
  ajjp(ajjf paramajjf, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<aiuc> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = ajjf.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ajjf.a(paramString1, 0, this.jdField_a_of_type_Int + ajyc.a(2131700486));
        return;
      }
      this.jdField_a_of_type_Ajjf.a(paramString1, 2, this.jdField_a_of_type_Int + ajyc.a(2131700485));
      return;
    }
    this.jdField_a_of_type_Ajjf.a(paramString1, 2, this.jdField_a_of_type_Int + ajyc.a(2131700480));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjp
 * JD-Core Version:    0.7.0.1
 */