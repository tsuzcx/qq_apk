import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class agfc
  implements agfa
{
  agfc(agfb paramagfb) {}
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    agfb.a(this.a).put(Long.valueOf(paramLong), Float.valueOf(paramFloat));
    agfb.a(this.a).a(paramLong, paramFloat, paramString);
  }
  
  public void b(long paramLong)
  {
    QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onDownloadSuccess:" + paramLong);
    agfb.a(this.a).b(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfc
 * JD-Core Version:    0.7.0.1
 */