import android.util.Log;
import com.tencent.TMG.sdk.AVRoomMulti.RequestViewListCompleteCallback;
import com.tencent.TMG.sdk.AVView;

class ajbi
  implements AVRoomMulti.RequestViewListCompleteCallback
{
  ajbi(ajbc paramajbc) {}
  
  public void OnComplete(String[] paramArrayOfString, AVView[] paramArrayOfAVView, int paramInt1, int paramInt2, String paramString)
  {
    Log.d("CmGameAvHandler", "RequestViewListCompleteCallback.OnComplete result: " + paramInt2 + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbi
 * JD-Core Version:    0.7.0.1
 */