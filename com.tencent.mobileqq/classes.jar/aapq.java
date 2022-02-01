import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aapq
  extends aapv
{
  aapq(aapl paramaapl, long paramLong, aapi paramaapi, File paramFile)
  {
    super(paramaapl.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Aapi.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapq
 * JD-Core Version:    0.7.0.1
 */