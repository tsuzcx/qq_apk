import android.os.Bundle;
import android.os.IInterface;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;

public abstract interface aiec
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle);
  
  public abstract void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiec
 * JD-Core Version:    0.7.0.1
 */