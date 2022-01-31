import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorAdapter.ChildItemHolder;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;

public class aeep
  implements IIconDecoder.IIconListener
{
  public aeep(NearbyVisitorListActivity paramNearbyVisitorListActivity) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt1 != 1) || (TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    while ((paramBitmap == null) || (paramInt2 != 200)) {
      return;
    }
    paramInt2 = this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildCount();
    paramInt1 = 0;
    label43:
    Object localObject2;
    Object localObject1;
    if (paramInt1 < paramInt2)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildAt(paramInt1).getTag();
      localObject1 = paramBitmap;
      if (localObject2 != null)
      {
        localObject1 = paramBitmap;
        if ((localObject2 instanceof NearbyVisitorAdapter.ChildItemHolder))
        {
          localObject2 = (NearbyVisitorAdapter.ChildItemHolder)localObject2;
          localObject1 = paramBitmap;
          if (paramString.equals(String.valueOf(((NearbyVisitorAdapter.ChildItemHolder)localObject2).jdField_b_of_type_Int)))
          {
            localObject1 = paramBitmap;
            if (((NearbyVisitorAdapter.ChildItemHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView != null)
            {
              if (paramBitmap != null) {
                break label255;
              }
              paramBitmap = this.a.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(((NearbyVisitorAdapter.ChildItemHolder)localObject2).jdField_b_of_type_Int), 200, true, true);
            }
          }
        }
      }
    }
    label255:
    for (;;)
    {
      localObject1 = new StatableBitmapDrawable(this.a.getResources(), paramBitmap, false, false);
      if (this.a.d == 0) {
        this.a.d = ((int)(((NearbyVisitorAdapter.ChildItemHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.a() * 1.1F + 0.5F));
      }
      ((StatableBitmapDrawable)localObject1).setBounds(0, 0, this.a.d, this.a.d);
      ((NearbyVisitorAdapter.ChildItemHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject1, null);
      localObject1 = paramBitmap;
      paramInt1 += 1;
      paramBitmap = (Bitmap)localObject1;
      break label43;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeep
 * JD-Core Version:    0.7.0.1
 */