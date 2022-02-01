import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;

public class acxz
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public acxz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong)
  {
    if (paramGdtVideoData == null)
    {
      acvc.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
    {
      acvc.d("GdtVideoStatistics", "return startPositionMillis =-1");
      return;
    }
    if (this.jdField_a_of_type_Long > paramLong)
    {
      acvc.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
      this.jdField_a_of_type_Long = 0L;
    }
    long l = this.jdField_a_of_type_Long;
    if (paramLong == paramGdtVideoData.getDurationMillis()) {}
    for (boolean bool = true;; bool = false)
    {
      String str = acvn.a(l, paramLong, bool, this.jdField_a_of_type_Int);
      acvc.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      acvn.a((GdtAd)paramGdtVideoData.getAd(), str);
      this.jdField_a_of_type_Long = -1L;
      return;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData)
  {
    acvc.b("GdtVideoStatistics", "onError");
    c(paramGdtVideoData, -1L);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    acvc.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void b(GdtVideoData paramGdtVideoData)
  {
    acvc.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis());
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong)
  {
    acvc.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong);
  }
  
  public void c(GdtVideoData paramGdtVideoData)
  {
    if (paramGdtVideoData == null)
    {
      acvc.d("GdtVideoStatistics", "805 reportLoadError data == null return");
      return;
    }
    acvc.b("GdtVideoStatistics", "reportLoadError:" + paramGdtVideoData.getPlayScene());
    String str = acvn.a(paramGdtVideoData.getPlayScene());
    acvn.a((GdtAd)paramGdtVideoData.getAd(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxz
 * JD-Core Version:    0.7.0.1
 */