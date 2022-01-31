import com.tencent.qphone.base.util.QLog;

final class akzm
  extends bdvu
{
  akzm(int paramInt, akzq paramakzq) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (3 == parambdvv.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Akzq != null) {
        this.jdField_a_of_type_Akzq.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambdvv.a());
      }
    } while (this.jdField_a_of_type_Akzq == null);
    this.jdField_a_of_type_Akzq.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */