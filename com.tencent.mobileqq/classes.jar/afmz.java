import android.util.LruCache;
import com.tencent.mobileqq.data.MessageForPoke;

class afmz
  extends LruCache<Long, MessageForPoke>
{
  afmz(afmy paramafmy, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, MessageForPoke paramMessageForPoke1, MessageForPoke paramMessageForPoke2)
  {
    if ((paramMessageForPoke1 != null) && (!paramMessageForPoke1.isPlayed))
    {
      paramMessageForPoke1.setPlayed(this.a.b);
      paramMessageForPoke1.mFrameState.a = false;
      paramMessageForPoke1.mFrameState.c = true;
      paramMessageForPoke1.mUnlimitedState.a = false;
      paramMessageForPoke1.mUnlimitedState.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmz
 * JD-Core Version:    0.7.0.1
 */