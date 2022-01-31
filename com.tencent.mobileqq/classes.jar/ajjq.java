import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ajjq
  implements ajie
{
  ajjq(ajjf paramajjf, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_JavaLangString, 0, paramInt1 + ajyc.a(2131700501));
        return;
      }
      this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + ajyc.a(2131700477));
      return;
    }
    this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + ajyc.a(2131700495));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjq
 * JD-Core Version:    0.7.0.1
 */