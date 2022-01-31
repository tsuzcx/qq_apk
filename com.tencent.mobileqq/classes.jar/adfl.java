import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotchat.PttShowRoomMng.Guest;

public class adfl
  extends LruCache
{
  public adfl(PttShowRoomMng paramPttShowRoomMng, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfl
 * JD-Core Version:    0.7.0.1
 */