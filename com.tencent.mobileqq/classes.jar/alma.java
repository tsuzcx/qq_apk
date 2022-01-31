import com.tencent.widget.Gallery;

public class alma
  implements Runnable
{
  public alma(Gallery paramGallery) {}
  
  public void run()
  {
    Gallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alma
 * JD-Core Version:    0.7.0.1
 */