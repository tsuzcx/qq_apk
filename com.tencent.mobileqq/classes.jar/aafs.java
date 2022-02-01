import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

class aafs
  extends ExecuteBinResponseCallback
{
  aafs(aafm paramaafm, aafw paramaafw) {}
  
  public void onFailure(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_Aafw.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Aafm.a.a));
    }
    this.jdField_a_of_type_Aafm.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafs
 * JD-Core Version:    0.7.0.1
 */