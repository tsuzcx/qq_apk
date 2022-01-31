import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class ahua
  extends URLDrawableDownListener.Adapter
{
  public ahua(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahua
 * JD-Core Version:    0.7.0.1
 */