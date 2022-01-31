import com.tencent.qphone.base.util.QLog;

final class aiub
  extends batl
{
  aiub(int paramInt, aiue paramaiue) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (3 == parambatm.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Aiue != null) {
        this.jdField_a_of_type_Aiue.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambatm.a());
      }
    } while (this.jdField_a_of_type_Aiue == null);
    this.jdField_a_of_type_Aiue.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiub
 * JD-Core Version:    0.7.0.1
 */