import java.io.File;

class ajjq
  implements ajic
{
  ajjq(ajjd paramajjd, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 0, paramInt2 + ajya.a(2131700510));
        return;
      }
      this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + ajya.a(2131700486));
      return;
    }
    this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + ajya.a(2131700507));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjq
 * JD-Core Version:    0.7.0.1
 */