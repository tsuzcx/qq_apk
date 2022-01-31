import com.tencent.qphone.base.util.QLog;

class akuz
  extends akny
{
  akuz(akux paramakux, akou paramakou) {}
  
  public void a()
  {
    akux.a(this.jdField_a_of_type_Akux, true);
    akux.b(this.jdField_a_of_type_Akux, false);
    boolean bool = this.jdField_a_of_type_Akou.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Akux.a();
    this.jdField_a_of_type_Akux.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akuz
 * JD-Core Version:    0.7.0.1
 */