import android.view.View;
import com.tencent.widget.AbsListView;

public class alkb
  extends alkm
  implements Runnable
{
  private alkb(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    View localView;
    if ((this.a.isPressed()) && (this.a.mSelectedPosition >= 0))
    {
      int i = this.a.mSelectedPosition;
      int j = this.a.mFirstPosition;
      localView = this.a.getChildAt(i - j);
      if (this.a.mDataChanged) {
        break label108;
      }
      if (!a()) {
        break label128;
      }
    }
    label128:
    for (boolean bool = this.a.performLongPress(localView, this.a.mSelectedPosition, this.a.mSelectedRowId);; bool = false)
    {
      if (bool)
      {
        this.a.setPressed(false);
        localView.setPressed(false);
      }
      label108:
      do
      {
        return;
        this.a.setPressed(false);
      } while (localView == null);
      localView.setPressed(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alkb
 * JD-Core Version:    0.7.0.1
 */