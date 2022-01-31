import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agxr
  implements agxs
{
  public agxr(StickerBubbleListView paramStickerBubbleListView) {}
  
  public void a(View paramView)
  {
    if (((paramView instanceof StickerBubbleImageView)) && (paramView.getVisibility() == 0))
    {
      ((StickerBubbleImageView)paramView).a();
      if ((StickerBubbleListView.a(this.a) == null) || (StickerBubbleListView.a(this.a).get() != paramView)) {
        StickerBubbleListView.a(this.a, new WeakReference((StickerBubbleImageView)paramView));
      }
      paramView = (View)paramView.getParent();
      View localView = (View)paramView.getParent();
      if (StickerBubbleListView.a(this.a) == null) {
        StickerBubbleListView.a(this.a, new Rect());
      }
      Rect localRect = StickerBubbleListView.a(this.a);
      int i = localView.getLeft();
      int j = paramView.getLeft();
      int k = localView.getTop();
      int m = paramView.getTop();
      int n = localView.getLeft();
      int i1 = paramView.getRight();
      int i2 = localView.getTop();
      localRect.set(i + j, k + m, n + i1, paramView.getBottom() + i2);
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleListView", 2, "notifyItemViewTouchDown with rect: " + StickerBubbleListView.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxr
 * JD-Core Version:    0.7.0.1
 */