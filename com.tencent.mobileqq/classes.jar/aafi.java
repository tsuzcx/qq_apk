import com.tencent.qphone.base.util.QLog;

class aafi
  extends aafw
{
  aafi(aafb paramaafb, aafj paramaafj, String paramString1, String paramString2)
  {
    super(paramaafb);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Aafb.a));
      this.jdField_a_of_type_Aafb.a = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aafj.a(this.jdField_a_of_type_JavaLangString, true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_Aafj.a(this.b, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafi
 * JD-Core Version:    0.7.0.1
 */