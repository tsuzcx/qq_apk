import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aivo
  implements aiud
{
  aivo(aivd paramaivd, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 0, paramInt1 + ajjy.a(2131634716));
        return;
      }
      this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + ajjy.a(2131634692));
      return;
    }
    this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + ajjy.a(2131634710));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivo
 * JD-Core Version:    0.7.0.1
 */