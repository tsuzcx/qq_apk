import com.tencent.qapmsdk.QAPM.ABType;

public class abqt
  extends QAPM.ABType
{
  public void active()
  {
    setPerfTimeout(1, 9223372036854775807L);
    setPerfTimeout(4, 9223372036854775807L);
    setPerfTimeout(2, 9223372036854775807L);
  }
  
  public String getDescription()
  {
    return "AIO3D背景";
  }
  
  public void unactive()
  {
    setPerfTimeout(1, 3000L);
    setPerfTimeout(2, 2000L);
    setPerfTimeout(4, 9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqt
 * JD-Core Version:    0.7.0.1
 */