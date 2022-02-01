import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;

public class ackh
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public ackh(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong, acib paramacib)
  {
    paramacib.d();
    e(paramGdtVideoData, paramLong, paramacib);
  }
  
  private void d(GdtVideoData paramGdtVideoData, long paramLong, acib paramacib)
  {
    e(paramGdtVideoData, paramLong, paramacib);
  }
  
  private void e(GdtVideoData paramGdtVideoData, long paramLong, acib paramacib)
  {
    if (paramGdtVideoData == null)
    {
      acho.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    GdtAd localGdtAd;
    long l;
    if (!paramacib.a())
    {
      if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
      {
        acho.d("GdtVideoStatistics", "return startPositionMillis =-1");
        return;
      }
      if (this.jdField_a_of_type_Long > paramLong)
      {
        acho.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
        this.jdField_a_of_type_Long = 0L;
      }
      acho.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      localGdtAd = (GdtAd)paramGdtVideoData.getAd();
      l = this.jdField_a_of_type_Long;
      if (paramLong != paramGdtVideoData.getDurationMillis()) {
        break label182;
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      acia.a(localGdtAd, l, paramLong, bool, this.jdField_a_of_type_Int, paramacib);
      paramacib.b();
      paramacib.d();
      this.jdField_a_of_type_Long = -1L;
      return;
      if (this.jdField_a_of_type_Long != -1L) {
        break;
      }
      this.jdField_a_of_type_Long = 0L;
      break;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    acho.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong, acib paramacib)
  {
    acho.b("GdtVideoStatistics", "onError");
    d(paramGdtVideoData, paramLong, paramacib);
  }
  
  public void a(GdtVideoData paramGdtVideoData, acib paramacib)
  {
    acho.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis(), paramacib);
      paramacib.a(13);
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong, acib paramacib)
  {
    acho.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong, paramacib);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackh
 * JD-Core Version:    0.7.0.1
 */