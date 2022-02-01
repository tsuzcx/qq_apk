import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.OnConvertListener;
import eipc.EIPCResult;

class akxv
  implements EmojiGifHelper.OnConvertListener
{
  akxv(akxq paramakxq, int paramInt) {}
  
  public void onConvertResult(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("res", paramBoolean);
    localBundle.putString("path", paramString);
    this.jdField_a_of_type_Akxq.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */