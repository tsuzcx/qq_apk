import com.tencent.qphone.base.util.QLog;

class aapj
  extends bhyn
{
  aapj(aapg paramaapg, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + parambhyo.c + " code = " + parambhyo.jdField_a_of_type_Int);
    }
    boolean bool = this.jdField_a_of_type_Aapg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.jdField_a_of_type_Aapg.a();
  }
  
  public void onProgress(bhyo parambhyo)
  {
    int i = (int)(parambhyo.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapj
 * JD-Core Version:    0.7.0.1
 */