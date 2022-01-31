import com.tencent.widget.VerticalGallery;

public class alol
  implements Runnable
{
  public alol(VerticalGallery paramVerticalGallery) {}
  
  public void run()
  {
    VerticalGallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alol
 * JD-Core Version:    0.7.0.1
 */