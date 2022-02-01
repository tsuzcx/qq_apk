import com.tencent.qphone.base.util.QLog;

class aatu
  extends zqh
{
  aatu(aato paramaato, aaty paramaaty) {}
  
  public void onFailure(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_Aaty.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Aato.a.a));
    }
    this.jdField_a_of_type_Aato.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatu
 * JD-Core Version:    0.7.0.1
 */