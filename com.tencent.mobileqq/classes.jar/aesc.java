import com.tencent.qphone.base.util.QLog;

class aesc
  implements aese
{
  aesc(aesb paramaesb, aesd paramaesd) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aesb.a(this.jdField_a_of_type_Aesb, this.jdField_a_of_type_Aesd.a());
      this.jdField_a_of_type_Aesd.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Aesd.a());
    aesb.a(this.jdField_a_of_type_Aesb, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */