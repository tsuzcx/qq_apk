import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.open.agent.CardContainer;

public class alji
  implements Runnable
{
  public alji(CardContainer paramCardContainer) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(LastModifySupportDownloader.a(this.a.a()));
    if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alji
 * JD-Core Version:    0.7.0.1
 */