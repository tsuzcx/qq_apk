import com.tencent.qphone.base.util.QLog;

class aafh
  extends aafw
{
  aafh(aafb paramaafb, aafj paramaafj, String paramString)
  {
    super(paramaafb);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "mixAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "mixAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Aafb.a));
      this.jdField_a_of_type_Aafb.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Aafj.a(this.jdField_a_of_type_JavaLangString, false, "mixAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafh
 * JD-Core Version:    0.7.0.1
 */