import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.open.agent.AuthorityActivity;
import cooperation.qqfav.util.HandlerPlus;

class akkt
  implements Runnable
{
  akkt(akko paramakko, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_JavaLangString);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_Akko.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akkt
 * JD-Core Version:    0.7.0.1
 */