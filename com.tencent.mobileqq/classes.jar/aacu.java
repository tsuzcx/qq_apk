import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class aacu
  implements URLDrawable.URLDrawableListener
{
  private WeakReference<AsyncRichTextView> a;
  
  public aacu(AsyncRichTextView paramAsyncRichTextView)
  {
    this.a = new WeakReference(paramAsyncRichTextView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AsyncRichTextView", 4, "onLoadSuccessed ");
    }
    if ((this.a != null) && (this.a.get() != null)) {
      ((AsyncRichTextView)this.a.get()).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacu
 * JD-Core Version:    0.7.0.1
 */