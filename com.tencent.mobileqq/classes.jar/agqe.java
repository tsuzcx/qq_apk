import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;

public class agqe
  implements View.OnLongClickListener
{
  private WeakReference a;
  
  private agqe(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView == null) || (!paramView.isAdded())) {
      return false;
    }
    ActionSheet localActionSheet = ActionSheet.a(paramView.getActivity());
    localActionSheet.b(2131435065);
    localActionSheet.c(2131432998);
    localActionSheet.a(new agqf(this, paramView, localActionSheet));
    localActionSheet.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agqe
 * JD-Core Version:    0.7.0.1
 */