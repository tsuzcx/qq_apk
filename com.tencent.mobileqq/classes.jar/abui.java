import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;

public class abui
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public abui(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong, abry paramabry)
  {
    paramabry.d();
    e(paramGdtVideoData, paramLong, paramabry);
  }
  
  private void d(GdtVideoData paramGdtVideoData, long paramLong, abry paramabry)
  {
    e(paramGdtVideoData, paramLong, paramabry);
  }
  
  private void e(GdtVideoData paramGdtVideoData, long paramLong, abry paramabry)
  {
    if (paramGdtVideoData == null)
    {
      abrl.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    GdtAd localGdtAd;
    long l;
    if (!paramabry.a())
    {
      if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
      {
        abrl.d("GdtVideoStatistics", "return startPositionMillis =-1");
        return;
      }
      if (this.jdField_a_of_type_Long > paramLong)
      {
        abrl.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
        this.jdField_a_of_type_Long = 0L;
      }
      abrl.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      localGdtAd = (GdtAd)paramGdtVideoData.getAd();
      l = this.jdField_a_of_type_Long;
      if (paramLong != paramGdtVideoData.getDurationMillis()) {
        break label182;
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      abrx.a(localGdtAd, l, paramLong, bool, this.jdField_a_of_type_Int, paramabry);
      paramabry.b();
      paramabry.d();
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
    abrl.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong, abry paramabry)
  {
    abrl.b("GdtVideoStatistics", "onError");
    d(paramGdtVideoData, paramLong, paramabry);
  }
  
  public void a(GdtVideoData paramGdtVideoData, abry paramabry)
  {
    abrl.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis(), paramabry);
      paramabry.a(13);
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong, abry paramabry)
  {
    abrl.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong, paramabry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abui
 * JD-Core Version:    0.7.0.1
 */