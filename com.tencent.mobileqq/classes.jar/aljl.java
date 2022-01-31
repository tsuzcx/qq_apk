import com.tencent.qphone.base.util.QLog;

class aljl
  extends alck
{
  aljl(aljj paramaljj, aldg paramaldg) {}
  
  public void a()
  {
    aljj.a(this.jdField_a_of_type_Aljj, true);
    aljj.b(this.jdField_a_of_type_Aljj, false);
    boolean bool = this.jdField_a_of_type_Aldg.c();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    this.jdField_a_of_type_Aljj.a();
    this.jdField_a_of_type_Aljj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljl
 * JD-Core Version:    0.7.0.1
 */