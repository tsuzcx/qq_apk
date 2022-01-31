import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aivp
  implements aiud
{
  aivp(aivd paramaivd, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + ajjy.a(2131634697));
        return;
      }
      this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + ajjy.a(2131634696));
      return;
    }
    this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + ajjy.a(2131634718));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivp
 * JD-Core Version:    0.7.0.1
 */