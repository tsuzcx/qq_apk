import com.tencent.qphone.base.util.QLog;

class aath
  extends aaty
{
  aath(aatd paramaatd, aatl paramaatl, String paramString)
  {
    super(paramaatd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Aatd.a));
      this.jdField_a_of_type_Aatd.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Aatl.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aath
 * JD-Core Version:    0.7.0.1
 */