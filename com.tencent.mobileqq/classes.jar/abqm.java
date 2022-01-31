import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.util.DynamicFaceDrawable;

class abqm
  implements Runnable
{
  abqm(abql paramabql) {}
  
  public void run()
  {
    if (!DynamicFaceDrawable.b) {
      AbstractVideoImage.resumeAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqm
 * JD-Core Version:    0.7.0.1
 */