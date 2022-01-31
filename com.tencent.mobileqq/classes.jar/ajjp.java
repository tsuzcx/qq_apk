import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajjp
  implements ajic
{
  ajjp(ajjd paramajjd, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + ajya.a(2131700493));
        return;
      }
      this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + ajya.a(2131700492));
      return;
    }
    this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + ajya.a(2131700514));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjp
 * JD-Core Version:    0.7.0.1
 */