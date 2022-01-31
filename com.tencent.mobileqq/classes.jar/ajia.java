import com.tencent.qphone.base.util.QLog;

final class ajia
  extends bbwt
{
  ajia(int paramInt, ajie paramajie) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (3 == parambbwu.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Ajie != null) {
        this.jdField_a_of_type_Ajie.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambbwu.a());
      }
    } while (this.jdField_a_of_type_Ajie == null);
    this.jdField_a_of_type_Ajie.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajia
 * JD-Core Version:    0.7.0.1
 */