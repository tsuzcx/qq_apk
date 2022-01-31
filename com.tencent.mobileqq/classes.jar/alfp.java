import com.tencent.qphone.base.util.QLog;
import java.io.File;

class alfp
  implements aled
{
  alfp(alfe paramalfe, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Alfe.a(this.jdField_a_of_type_JavaLangString, 0, paramInt1 + alud.a(2131700893));
        return;
      }
      this.jdField_a_of_type_Alfe.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + alud.a(2131700869));
      return;
    }
    this.jdField_a_of_type_Alfe.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + alud.a(2131700887));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfp
 * JD-Core Version:    0.7.0.1
 */