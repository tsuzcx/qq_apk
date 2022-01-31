import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.RedPackRainCloudView;

class abgq
  implements Runnable
{
  abgq(abgo paramabgo) {}
  
  public void run()
  {
    if ((!this.a.a.isFinishing()) && (this.a.a.a.getVisibility() == 0))
    {
      this.a.a.a.setVisibility(8);
      ARMapActivity.d(this.a.a, false);
      ARMapActivity.c(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgq
 * JD-Core Version:    0.7.0.1
 */