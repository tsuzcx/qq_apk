import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ajjn
  implements aiud
{
  ajjn(ajjd paramajjd, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<aiua> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = ajjd.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ajjd.a(paramString1, 0, this.jdField_a_of_type_Int + ajya.a(2131700497));
        return;
      }
      this.jdField_a_of_type_Ajjd.a(paramString1, 2, this.jdField_a_of_type_Int + ajya.a(2131700496));
      return;
    }
    this.jdField_a_of_type_Ajjd.a(paramString1, 2, this.jdField_a_of_type_Int + ajya.a(2131700491));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjn
 * JD-Core Version:    0.7.0.1
 */