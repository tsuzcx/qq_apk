import com.tencent.qphone.base.util.QLog;

final class ajic
  extends bbwf
{
  ajic(int paramInt, ajig paramajig) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (3 == parambbwg.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Ajig != null) {
        this.jdField_a_of_type_Ajig.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambbwg.a());
      }
    } while (this.jdField_a_of_type_Ajig == null);
    this.jdField_a_of_type_Ajig.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajic
 * JD-Core Version:    0.7.0.1
 */