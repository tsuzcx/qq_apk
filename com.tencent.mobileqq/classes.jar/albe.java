import android.os.Handler;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

public class albe
  implements Runnable
{
  public albe(CustomHorizontalScrollView paramCustomHorizontalScrollView) {}
  
  public void run()
  {
    int i = this.a.getScrollX();
    if (i == this.a.jdField_a_of_type_Int)
    {
      int j = i % (this.a.b + this.a.c);
      if (this.a.e + i >= this.a.d) {
        return;
      }
      if (j < this.a.b / 2) {
        this.a.smoothScrollBy(-j, 0);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Int = i;
        return;
        if (j >= this.a.b / 2)
        {
          int k = this.a.b;
          int m = this.a.c;
          this.a.smoothScrollBy(k + m - j, 0);
        }
      }
    }
    this.a.jdField_a_of_type_Int = i;
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     albe
 * JD-Core Version:    0.7.0.1
 */