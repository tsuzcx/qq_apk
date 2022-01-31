import com.tencent.widget.Gallery;

public class ambq
  implements Runnable
{
  public ambq(Gallery paramGallery) {}
  
  public void run()
  {
    Gallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambq
 * JD-Core Version:    0.7.0.1
 */