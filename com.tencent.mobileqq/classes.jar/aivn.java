import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class aivn
  implements aihm
{
  aivn(aivd paramaivd, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<aihj> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = aivd.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Aivd.a(paramString1, 0, this.jdField_a_of_type_Int + ajjy.a(2131634701));
        return;
      }
      this.jdField_a_of_type_Aivd.a(paramString1, 2, this.jdField_a_of_type_Int + ajjy.a(2131634700));
      return;
    }
    this.jdField_a_of_type_Aivd.a(paramString1, 2, this.jdField_a_of_type_Int + ajjy.a(2131634695));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivn
 * JD-Core Version:    0.7.0.1
 */