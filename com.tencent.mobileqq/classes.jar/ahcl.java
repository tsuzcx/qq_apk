import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.OnConvertListener;
import eipc.EIPCResult;

class ahcl
  implements EmojiGifHelper.OnConvertListener
{
  ahcl(ahcg paramahcg, int paramInt) {}
  
  public void onConvertResult(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("res", paramBoolean);
    localBundle.putString("path", paramString);
    this.jdField_a_of_type_Ahcg.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcl
 * JD-Core Version:    0.7.0.1
 */