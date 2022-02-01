import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;

public class akrp
  extends URLDrawableHelper.Adapter
{
  public akrp(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.a.b();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrp
 * JD-Core Version:    0.7.0.1
 */