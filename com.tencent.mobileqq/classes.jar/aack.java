import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

class aack
  implements Observer<Object>
{
  aack(aacj paramaacj) {}
  
  public void onChanged(@Nullable Object paramObject)
  {
    if (aacj.a(this.a) != null) {
      aacj.a(this.a).setData(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aack
 * JD-Core Version:    0.7.0.1
 */