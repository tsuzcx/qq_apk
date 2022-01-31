import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;

public class aigm
  extends GestureKeyInfo
{
  public String b;
  public int e = 0;
  public int f = 0;
  
  public aigm(GestureMgrRecognize paramGestureMgrRecognize) {}
  
  public void a(aigm paramaigm)
  {
    super.a(paramaigm);
    paramaigm.e = this.e;
    paramaigm.f = this.f;
    paramaigm.b = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aigm
 * JD-Core Version:    0.7.0.1
 */