import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.open.agent.AuthorityActivity;
import cooperation.qqfav.util.HandlerPlus;

class alaj
  implements Runnable
{
  alaj(alae paramalae, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_JavaLangString);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_Alae.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alaj
 * JD-Core Version:    0.7.0.1
 */