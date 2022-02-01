import com.tencent.qphone.base.util.QLog;

class aazj
  extends bhhe
{
  aazj(aazg paramaazg, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + parambhhf.c + " code = " + parambhhf.jdField_a_of_type_Int);
    }
    boolean bool = this.jdField_a_of_type_Aazg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.jdField_a_of_type_Aazg.a();
  }
  
  public void onProgress(bhhf parambhhf)
  {
    int i = (int)(parambhhf.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazj
 * JD-Core Version:    0.7.0.1
 */