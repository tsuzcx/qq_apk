import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.mobileqq.widget.GuideViewBuilder.GuideLayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class alce
  extends FrameLayout
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public alce(GuideViewBuilder paramGuideViewBuilder, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private FrameLayout.LayoutParams a(alcd paramalcd, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    if (paramGuideLayoutParams.width == -9) {
      paramGuideLayoutParams.width = (paramalcd.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + -paramGuideLayoutParams.a * 2);
    }
    if (paramGuideLayoutParams.height == -9) {
      paramGuideLayoutParams.height = (paramalcd.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + -paramGuideLayoutParams.b * 2);
    }
    if (paramGuideLayoutParams.a != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x3;
      paramGuideLayoutParams.leftMargin = (paramalcd.jdField_a_of_type_ArrayOfInt[0] + paramGuideLayoutParams.a - this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (paramGuideLayoutParams.b != 2147483647)
    {
      paramGuideLayoutParams.gravity |= 0x30;
      paramGuideLayoutParams.topMargin = (paramalcd.jdField_a_of_type_ArrayOfInt[1] + paramGuideLayoutParams.b - this.jdField_a_of_type_ArrayOfInt[1]);
    }
    return paramGuideLayoutParams;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        alcd localalcd = (alcd)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if (localalcd.jdField_a_of_type_ArrayOfInt == null)
        {
          localalcd.jdField_a_of_type_ArrayOfInt = new int[2];
          localalcd.jdField_a_of_type_AndroidViewView.getLocationOnScreen(localalcd.jdField_a_of_type_ArrayOfInt);
        }
        i += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuideView", 2, "getLocationOnScreen Null Pointer");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      alcd localalcd = (alcd)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
      int j = paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(localalcd.jdField_a_of_type_ArrayOfInt[0], localalcd.jdField_a_of_type_ArrayOfInt[1], localalcd.jdField_a_of_type_ArrayOfInt[0] + localalcd.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), localalcd.jdField_a_of_type_ArrayOfInt[1] + localalcd.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.offset(-this.jdField_a_of_type_ArrayOfInt[0], -this.jdField_a_of_type_ArrayOfInt[1]);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      localalcd.jdField_a_of_type_AndroidViewView.getRootView().draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
    {
      alcd localalcd = (alcd)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(paramInt1);
      Iterator localIterator = localalcd.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (indexOfChild((View)localPair.first) == -1)
        {
          Object localObject = ((View)localPair.first).getLayoutParams();
          if (localPair.second != null) {
            localObject = a(localalcd, (GuideViewBuilder.GuideLayoutParams)localPair.second);
          }
          if (localObject != null) {
            addViewInLayout((View)localPair.first, -1, (ViewGroup.LayoutParams)localObject);
          }
        }
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = 0;
      while (i < GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).size())
      {
        alcd localalcd = (alcd)GuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder).valueAt(i);
        if ((paramMotionEvent.getX() > localalcd.jdField_a_of_type_ArrayOfInt[0]) && (paramMotionEvent.getX() < localalcd.jdField_a_of_type_ArrayOfInt[0] + localalcd.jdField_a_of_type_AndroidViewView.getMeasuredWidth()) && (paramMotionEvent.getY() > localalcd.jdField_a_of_type_ArrayOfInt[1]) && (paramMotionEvent.getY() < localalcd.jdField_a_of_type_ArrayOfInt[1] + localalcd.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) && (localalcd.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a.dismiss();
          localalcd.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(localalcd.jdField_a_of_type_AndroidViewView);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */